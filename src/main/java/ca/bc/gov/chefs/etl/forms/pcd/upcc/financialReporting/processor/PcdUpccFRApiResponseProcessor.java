package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json.RootFinancial;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json.RootOverheadBudget;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json.RootTotals;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccFinancialSubTotals;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccFinancialTotals;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccItemizedBudget;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccItemizedFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FinancialReportingUpccSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdUpccFRApiResponseProcessor extends BaseApiResponseProcessor {

    private static final String EXPENSE_CATEGORY_CLINICAL = "Health Authority";
    private static final String EXPENSE_SUBCATEGORY_CLINICAL = "Clinical & Traditional Wellness Resources";
    private static final String EXPENSE_CATEGORY_OVERHEAD = "Health Authority";
    private static final String EXPENSE_SUBCATEGORY_OVERHEAD = "Overhead";
    private static final String EXPENSE_CATEGORY_OTF = "Health Authority";
    private static final String EXPENSE_SUBCATEGORY_OTF = "One-Time Funding";
    private static final String TYPE_OF_CARE_LC = "Longitudinal Care (LC)";
    private static final String TYPE_OF_CARE_UC = "Urgent Care (UC)";
    private static final String TYPE_OF_CARE_MS = "Mixed Stream (MS)";

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        payload = JsonUtil.fixExpenseItemSubType(payload);
        payload = JsonUtil.roundDigitsNumber(payload);
        ObjectMapper mapper = new ObjectMapper();

        List<Root> upccFRModels = mapper.readValue(payload,
                new TypeReference<List<Root>>() {
                });
        List<FinancialReportingUpccSubmission> parsedUpccFR = parseUpccFRRequest(upccFRModels);

        validateRecordCount(upccFRModels, parsedUpccFR);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedUpccFR;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_UPCC_FR_DIR, isHeaderAdded);

        // SuccessResponse successResponse = new SuccessResponse();
        // successResponse.setFiles(filesGenerated);
        // exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<FinancialReportingUpccSubmission> parseUpccFRRequest(List<Root> upccFRPayloads) {
        List<FinancialReportingUpccSubmission> parsedUpccFR = new ArrayList<>();
        for (Root root : upccFRPayloads) {
            FinancialReportingUpccSubmission financialReportingUpccSubmission = new FinancialReportingUpccSubmission();
            List<FRUpccFinancialData> upccFinancialData = new ArrayList<>();
            List<FRUpccItemizedBudget> upccItemizedBudget = new ArrayList<>();
            List<FRUpccFinancialTotals> upccFinancialTotals = new ArrayList<>();
            List<FRUpccFinancialSubTotals> upccFinancialSubtotals = new ArrayList<>();
            List<FRUpccItemizedFinancialData> upccItemizedFinancialData = new ArrayList<>();

            /** mapping FinancialReprotingUPCCSubmission */
            financialReportingUpccSubmission.setSubmissionId(root.getForm().getSubmissionId());
            financialReportingUpccSubmission.setCreatedAt(root.getForm().getCreatedAt());
            financialReportingUpccSubmission.setLateEntry(root.getLateEntry());
            financialReportingUpccSubmission.setSubmitterFullName(root.getForm().getFullName());
            financialReportingUpccSubmission.setSubmitterUserName(root.getForm().getUsername());
            financialReportingUpccSubmission.setSubmitterEmail(root.getForm().getEmail());
            financialReportingUpccSubmission.setSubmissionStatus(root.getForm().getStatus());
            financialReportingUpccSubmission.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
            financialReportingUpccSubmission.setSubmissionFormName(root.getForm().getFormName());
            financialReportingUpccSubmission.setHealthAuthority(root.getHealthAuthority());
            financialReportingUpccSubmission.setCommunityName(root.getCommunityName());
            financialReportingUpccSubmission.setUppcName(root.getUpccName());
            financialReportingUpccSubmission.setFiscalYear(root.getFiscalYear());
            financialReportingUpccSubmission.setInterimReported(root.getPeriodReported());
            financialReportingUpccSubmission
                    .setReasonForExceptionInPeriodReported(root.getReasonForExceptionInPeriodReported());
            financialReportingUpccSubmission.setAdditionalNotes(root.getFinancialData().getAdditionalNotes());

            /** Clinical */
            if (root.getFinancialData().getClinical().getTotals() != null) {
                FRUpccFinancialTotals clinicalTotal = mapTotals(root.getForm().getSubmissionId(),
                        root.getFinancialData().getClinical().getTotals(), EXPENSE_CATEGORY_CLINICAL,
                        EXPENSE_SUBCATEGORY_CLINICAL);
                upccFinancialTotals.add(clinicalTotal);
            }
            /* Clinical Urgent Care */
            if (root.getFinancialData().getClinical().getUrgentCare() != null) {
                if (root.getFinancialData().getClinical().getUrgentCare().getSubtotals() != null) {
                    FRUpccFinancialSubTotals UCsubtotal = mapSubTotal(root.getForm().getSubmissionId(),
                            root.getFinancialData().getClinical().getUrgentCare().getSubtotals(),
                            EXPENSE_CATEGORY_CLINICAL, EXPENSE_SUBCATEGORY_CLINICAL, TYPE_OF_CARE_UC);
                    upccFinancialSubtotals.add(UCsubtotal);
                }
                if (root.getFinancialData().getClinical().getUrgentCare().getFinancials() != null
                        && !root.getFinancialData().getClinical().getUrgentCare().getFinancials().isEmpty()) {
                    for (RootFinancial ucFinancial : root.getFinancialData().getClinical().getUrgentCare()
                            .getFinancials()) {
                        if (!ucFinancial.getExpenseItem().isEmpty() && ucFinancial.getExpenseItem() != null) {
                            FRUpccFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
                                    ucFinancial);
                            upccFinancialData.add(newFinancialData);
                        }
                    }
                }
            }

            /* Clinical Longitudinal Care */
            if (root.getFinancialData().getClinical().getLongitudinalCare() != null) {
                if (root.getFinancialData().getClinical().getLongitudinalCare().getSubtotals() != null) {
                    FRUpccFinancialSubTotals LCsubtotal = mapSubTotal(root.getForm().getSubmissionId(),
                            root.getFinancialData().getClinical().getLongitudinalCare().getSubtotals(),
                            EXPENSE_CATEGORY_CLINICAL, EXPENSE_SUBCATEGORY_CLINICAL, TYPE_OF_CARE_LC);
                    upccFinancialSubtotals.add(LCsubtotal);
                }
                if (root.getFinancialData().getClinical().getLongitudinalCare().getFinancials() != null
                        && !root.getFinancialData().getClinical().getLongitudinalCare().getFinancials().isEmpty()) {
                    for (RootFinancial lcFinancial : root.getFinancialData().getClinical().getLongitudinalCare()
                            .getFinancials()) {
                        if (!lcFinancial.getExpenseItem().isEmpty() && lcFinancial.getExpenseItem() != null) {
                            FRUpccFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
                                    lcFinancial);
                            upccFinancialData.add(newFinancialData);
                        }
                    }
                }
            }

            /* Clinical Mixed Stream */
            if (root.getFinancialData().getClinical().getMixedStream() != null) {
                if (root.getFinancialData().getClinical().getMixedStream().getSubtotals() != null) {
                    FRUpccFinancialSubTotals MSsubtotal = mapSubTotal(root.getForm().getSubmissionId(),
                            root.getFinancialData().getClinical().getMixedStream().getSubtotals(),
                            EXPENSE_CATEGORY_CLINICAL, EXPENSE_SUBCATEGORY_CLINICAL, TYPE_OF_CARE_MS);
                    upccFinancialSubtotals.add(MSsubtotal); 
                }
                if (root.getFinancialData().getClinical().getMixedStream().getFinancials() != null
                        && !root.getFinancialData().getClinical().getMixedStream().getFinancials().isEmpty()) {
                    for (RootFinancial msFinancial : root.getFinancialData().getClinical().getMixedStream()
                            .getFinancials()) {
                        if (!msFinancial.getExpenseItem().isEmpty() && msFinancial.getExpenseItem() != null) {
                            FRUpccFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
                                    msFinancial);
                            upccFinancialData.add(newFinancialData);
                        }
                    }
                }
            }

            /* One Time Funding */
            if (root.getFinancialData().getOneTimeFunding() != null) {
                if (root.getFinancialData().getOneTimeFunding().getTotals() != null) {
                    FRUpccFinancialTotals OTFTotal = mapTotals(root.getForm().getSubmissionId(),
                            root.getFinancialData().getOneTimeFunding().getTotals(), EXPENSE_CATEGORY_OTF,
                            EXPENSE_SUBCATEGORY_OTF);
                    upccFinancialTotals.add(OTFTotal);
                }
                if (root.getFinancialData().getOneTimeFunding().getFinancials() != null
                        && !root.getFinancialData().getOneTimeFunding().getFinancials().isEmpty()) {
                    for (RootFinancial otfFinancial : root.getFinancialData().getOneTimeFunding().getFinancials()) {
                        if (!otfFinancial.getExpenseItem().isEmpty() && otfFinancial.getExpenseItem() != null) {
                            FRUpccFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
                                    otfFinancial);
                            upccFinancialData.add(newFinancialData);
                        }
                    }
                }
            }

            /* Overhead */
            if (root.getFinancialData().getOverhead() != null) {
                if (root.getFinancialData().getOverhead().getTotals() != null) {
                    FRUpccFinancialTotals overheadTotal = mapTotals(root.getForm().getSubmissionId(),
                            root.getFinancialData().getOverhead().getTotals(), EXPENSE_CATEGORY_OVERHEAD,
                            EXPENSE_SUBCATEGORY_OVERHEAD);
                    upccFinancialTotals.add(overheadTotal);
                }
                if (root.getFinancialData().getOverhead().getBudget() != null) {
                    RootOverheadBudget rootBudget = root.getFinancialData().getOverhead().getBudget();
                    FRUpccItemizedBudget overheadBudget = new FRUpccItemizedBudget();
                    overheadBudget.setSubmissionId(root.getForm().getSubmissionId());
                    overheadBudget.setBudgetId(UUID.randomUUID().toString());
                    overheadBudget.setExpenseCategory(EXPENSE_CATEGORY_OVERHEAD);
                    overheadBudget.setExpenseSubCategory(EXPENSE_SUBCATEGORY_OVERHEAD);
                    overheadBudget.setApprovedBudget(rootBudget.getApprovedBudget());
                    overheadBudget.setFyExpenseVariance(rootBudget.getFyExpenseVariance());
                    overheadBudget.setProratedYtdBudget(rootBudget.getProratedYtdBudget());
                    overheadBudget.setFyEstimatedSurplus(rootBudget.getFyEstimatedSurplus());
                    overheadBudget.setYtdExpenseVariance(rootBudget.getYtdExpenseVariance());
                    overheadBudget.setFyExpenseVarianceNote(rootBudget.getFyExpenseVarianceNote());
                    overheadBudget.setYtdExpenseVarianceNote(rootBudget.getYtdExpenseVarianceNote());
                    if (root.getFinancialData().getOverhead().getFinancials() != null
                            && !root.getFinancialData().getOverhead().getFinancials().isEmpty()) {
                        for (RootFinancial overheadFinancial : root.getFinancialData().getOverhead().getFinancials()) {
                            if (!overheadFinancial.getExpenseItem().isEmpty()
                                    && overheadFinancial.getExpenseItem() != null) {
                                FRUpccItemizedFinancialData newItemizedFinancialData = new FRUpccItemizedFinancialData();
                                newItemizedFinancialData.setBudgetId(overheadBudget.getBudgetId());
                                newItemizedFinancialData.setExpenseId(UUID.randomUUID().toString());
                                newItemizedFinancialData.setExpenseItem(overheadFinancial.getExpenseItem());
                                newItemizedFinancialData.setExpenseItemSubtype(overheadFinancial.getExpenseItemSubType());
                                newItemizedFinancialData.setFyExpenseForecast(overheadFinancial.getFyExpenseForecast());
                                newItemizedFinancialData.setP1(overheadFinancial.getP1());
                                newItemizedFinancialData.setP2(overheadFinancial.getP2());
                                newItemizedFinancialData.setP3(overheadFinancial.getP3());
                                newItemizedFinancialData.setP4(overheadFinancial.getP4());
                                newItemizedFinancialData.setP5(overheadFinancial.getP5());
                                newItemizedFinancialData.setP6(overheadFinancial.getP6());
                                newItemizedFinancialData.setP7(overheadFinancial.getP7());
                                newItemizedFinancialData.setP8(overheadFinancial.getP8());
                                newItemizedFinancialData.setP9(overheadFinancial.getP9());
                                newItemizedFinancialData.setP10(overheadFinancial.getP10());
                                newItemizedFinancialData.setP11(overheadFinancial.getP11());
                                newItemizedFinancialData.setP12(overheadFinancial.getP12());
                                newItemizedFinancialData.setP13(overheadFinancial.getP13());
                                newItemizedFinancialData.setTotalActualYtdExpenses(overheadFinancial.getTotalActualYtdExpenses());
    
                                upccItemizedFinancialData.add(newItemizedFinancialData);
                            }
                        }
                    }
                    overheadBudget.setFrUpccItemizedFinancialData(upccItemizedFinancialData); 
                    upccItemizedBudget.add(overheadBudget);
                }

            }

            financialReportingUpccSubmission.setFrUpccFinancialData(upccFinancialData);
            financialReportingUpccSubmission.setFrUpccItemizedBudgets(upccItemizedBudget);
            financialReportingUpccSubmission.setFrUpccFinancialTotals(upccFinancialTotals);
            financialReportingUpccSubmission.setFrUpccFinancialSubTotals(upccFinancialSubtotals);
            parsedUpccFR.add(financialReportingUpccSubmission);
        }

        return parsedUpccFR;
    }

    private FRUpccFinancialTotals mapTotals(String submissionId, RootTotals rootTotal, String expenseCategory,
            String expenseSubCategory) {
        FRUpccFinancialTotals financialTotal = new FRUpccFinancialTotals();
        financialTotal.setSubmissionId(submissionId);
        financialTotal.setExpenseCategory(expenseCategory);
        financialTotal.setExpenseSubCategory(expenseSubCategory);
        financialTotal.setApprovedBudget(rootTotal.getApprovedBudget());
        financialTotal.setFtesHiredToDate(rootTotal.getFtesHiredToDate());
        financialTotal.setFyExpenseForecast(rootTotal.getFyExpenseForecast());
        financialTotal.setProratedYtdBudget(rootTotal.getProratedYtdBudget());
        financialTotal.setYtdExpenseVariance(rootTotal.getYtdExpenseVariance());
        financialTotal.setApprovedFtesInclRelief(rootTotal.getApprovedFtesInclRelief());
        financialTotal.setTotalActualYtdExpense(rootTotal.getTotalActualYtdExpenses());
        financialTotal.setP1(rootTotal.getP1());
        financialTotal.setP2(rootTotal.getP2());
        financialTotal.setP3(rootTotal.getP3());
        financialTotal.setP4(rootTotal.getP4());
        financialTotal.setP5(rootTotal.getP5());
        financialTotal.setP6(rootTotal.getP6());
        financialTotal.setP7(rootTotal.getP7());
        financialTotal.setP8(rootTotal.getP8());
        financialTotal.setP9(rootTotal.getP9());
        financialTotal.setP10(rootTotal.getP10());
        financialTotal.setP11(rootTotal.getP11());
        financialTotal.setP12(rootTotal.getP12());
        financialTotal.setP13(rootTotal.getP13());

        return financialTotal;
    }

    public FRUpccFinancialSubTotals mapSubTotal(String submissionId, RootTotals rootSubtotal, String expenseCategory,
            String expenseSubCategory, String typeOfCare) {
        FRUpccFinancialSubTotals financialSubTotal = new FRUpccFinancialSubTotals();
        financialSubTotal.setSubmissionId(submissionId);
        financialSubTotal.setExpenseCategory(expenseCategory);
        financialSubTotal.setExpenseSubCategory(expenseSubCategory);
        financialSubTotal.setTypeOfCare(typeOfCare);
        financialSubTotal.setApprovedBudget(rootSubtotal.getApprovedBudget());
        financialSubTotal.setFtesHiredToDate(rootSubtotal.getFtesHiredToDate());
        financialSubTotal.setFyExpenseForecast(rootSubtotal.getFyExpenseForecast());
        financialSubTotal.setFyExpenseVariance(rootSubtotal.getFyExpenseVariance());
        financialSubTotal.setFyEstimatedSurplus(rootSubtotal.getFyEstimatedSurplus());
        financialSubTotal.setProratedYtdBudget(rootSubtotal.getProratedYtdBudget());
        financialSubTotal.setYtdExpenseVariance(rootSubtotal.getYtdExpenseVariance());
        financialSubTotal.setApprovedFtesInclRelief(rootSubtotal.getApprovedFtesInclRelief());
        financialSubTotal.setTotalActualYtdExpense(rootSubtotal.getTotalActualYtdExpenses());
        financialSubTotal.setP1(rootSubtotal.getP1());
        financialSubTotal.setP2(rootSubtotal.getP2());
        financialSubTotal.setP3(rootSubtotal.getP3());
        financialSubTotal.setP4(rootSubtotal.getP4());
        financialSubTotal.setP5(rootSubtotal.getP5());
        financialSubTotal.setP6(rootSubtotal.getP6());
        financialSubTotal.setP7(rootSubtotal.getP7());
        financialSubTotal.setP8(rootSubtotal.getP8());
        financialSubTotal.setP9(rootSubtotal.getP9());
        financialSubTotal.setP10(rootSubtotal.getP10());
        financialSubTotal.setP11(rootSubtotal.getP11());
        financialSubTotal.setP12(rootSubtotal.getP12());
        financialSubTotal.setP13(rootSubtotal.getP13());
        return financialSubTotal;
    }

    public FRUpccFinancialData mapFinancialData(String submissionId, RootFinancial financial) {
        FRUpccFinancialData newFinancialData = new FRUpccFinancialData();
        newFinancialData.setSubmissionId(submissionId);
        newFinancialData.setExpenseId(UUID.randomUUID().toString());
        newFinancialData.setApprovedBudget(financial.getApprovedBudget());
        newFinancialData.setApprovedFtesInclRelief(financial.getApprovedFtesInclRelief());
        newFinancialData.setExpenseCategory(financial.getExpenseCategory());
        newFinancialData.setExpenseSubCategory(financial.getExpenseSubCategory());
        newFinancialData.setExpenseItem(financial.getExpenseItem());
        newFinancialData.setExpenseItemSubType(financial.getExpenseItemSubType());
        newFinancialData.setSpecialty(financial.getSpecialty());
        newFinancialData.setOtherSpecialty(financial.getOtherSpecialty());
        newFinancialData.setFtesHiredToDate(financial.getFtesHiredToDate());
        newFinancialData.setFyExpenseForecast(financial.getFyExpenseForecast());
        newFinancialData.setFyEstimatedSurplus(financial.getFyEstimatedSurplus());
        newFinancialData.setFyExpenseVariance(financial.getFyExpenseVariance());
        newFinancialData.setFyExpenseVarianceNote(financial.getFyExpenseVarianceNote());
        newFinancialData.setP1(financial.getP1());
        newFinancialData.setP2(financial.getP2());
        newFinancialData.setP3(financial.getP3());
        newFinancialData.setP4(financial.getP4());
        newFinancialData.setP5(financial.getP5());
        newFinancialData.setP6(financial.getP6());
        newFinancialData.setP7(financial.getP7());
        newFinancialData.setP8(financial.getP8());
        newFinancialData.setP9(financial.getP9());
        newFinancialData.setP10(financial.getP10());
        newFinancialData.setP11(financial.getP11());
        newFinancialData.setP12(financial.getP12());
        newFinancialData.setP13(financial.getP13());
        newFinancialData.setProratedYtdBudget(financial.getProratedYtdBudget());
        newFinancialData.setTotalActualYtdExpenses(financial.getTotalActualYtdExpenses());
        newFinancialData.setTypeOfCare(financial.getTypeOfCare());
        newFinancialData.setYtdExpenseVariance(financial.getYtdExpenseVariance());
        newFinancialData.setYtdExpenseVarianceNote(financial.getYtdExpenseVarianceNote());

        return newFinancialData;
    }
}
