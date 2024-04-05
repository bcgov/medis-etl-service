package ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.json.RootClinical;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.json.RootFinancial;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.json.RootFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.json.RootOneTimeFunding;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.json.RootOtherResources;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.json.RootOverhead;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.json.RootOverheadBudget;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.json.RootTotals;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model.FRChcFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model.FRChcFinancialTotals;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model.FRChcItemizedBudget;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model.FRChcItemizedFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model.FinancialReportingChcSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdChcFRApiResponseProcessor extends BaseApiResponseProcessor {

    private static final String EXPENSE_CATEGORY_HEALTH_AUTHORITY = "Health Authority";
    private static final String EXPENSE_SUBCATEGORY_CLINICAL = "Clinical & Traditional Wellness Resources";
    private static final String EXPENSE_SUBCATEGORY_OVERHEAD = "Overhead";
    private static final String EXPENSE_SUBCATEGORY_ONE_TIME_FUNDING = "One-Time Funding";
    private static final String EXPENSE_SUBCATEGORY_OTHER_RESOURCES = "Other Resources & Items";

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        payload = JsonUtil.fixExpenseItemSubType(payload);
        //payload = JsonUtil.roundDigitsNumber(payload);
        ObjectMapper mapper = new ObjectMapper();

        List<Root> chcFRModels = mapper.readValue(payload,
                new TypeReference<List<Root>>() {
                });
        List<FinancialReportingChcSubmission> parsedChcFR = parseChcFRRequest(chcFRModels);

        validateRecordCount(chcFRModels, parsedChcFR);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedChcFR;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_CHC_FR_DIR, isHeaderAdded);

         SuccessResponse successResponse = new SuccessResponse();
         successResponse.setFiles(filesGenerated);
         exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<FinancialReportingChcSubmission> parseChcFRRequest(List<Root> chcFRPayloads) {
        List<FinancialReportingChcSubmission> parsedChcFR = new ArrayList<>();
        for (Root root : chcFRPayloads) {
            FinancialReportingChcSubmission financialReportingChcSubmission = new FinancialReportingChcSubmission();
            List<FRChcFinancialData> chcFinancialData = new ArrayList<>();
            List<FRChcItemizedBudget> chcItemizedBudgets = new ArrayList<>();
            List<FRChcFinancialTotals> chcFinancialTotals = new ArrayList<>();
            List<FRChcItemizedFinancialData> chcItemizedFinancials = new ArrayList<>();

            /** mapping FinancialReprotingChcSubmission */
            financialReportingChcSubmission.setSubmissionId(root.getForm().getSubmissionId());
            financialReportingChcSubmission.setCreatedAt(CSVUtil.getFormattedDate(root.getForm().getCreatedAt()));
            financialReportingChcSubmission.setLateEntry(root.getLateEntry());
            financialReportingChcSubmission.setSubmitterFullName(root.getForm().getFullName());
            financialReportingChcSubmission.setSubmitterUserName(root.getForm().getUsername());
            financialReportingChcSubmission.setSubmitterEmail(root.getForm().getEmail());
            financialReportingChcSubmission.setSubmissionStatus(root.getForm().getStatus());
            financialReportingChcSubmission.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
            financialReportingChcSubmission.setSubmissionFormName(root.getForm().getFormName());
            financialReportingChcSubmission.setHealthAuthority(root.getHealthAuthority());
            financialReportingChcSubmission.setCommunityName(root.getCommunityName());
            financialReportingChcSubmission.setChcName(root.getChcName());
            financialReportingChcSubmission.setFiscalYear(root.getFiscalYear());
            financialReportingChcSubmission.setPeriodReported(root.getPeriodReported());
            financialReportingChcSubmission
                    .setReasonForExceptionInPeriodReported(root.getReasonForExceptionInPeriodReported());
            financialReportingChcSubmission.setAdditionalNotes(root.getFinancialData().getAdditionalNotes());
            
            RootFinancialData financialData = root.getFinancialData();

            /** Clinical */
            RootClinical clinical = financialData.getClinical();            
            if (clinical != null) {
                if (clinical.getTotals() != null) {
                    FRChcFinancialTotals clinicalTotal = mapTotals(root.getForm().getSubmissionId(),
                            root.getFinancialData().getClinical().getTotals(), EXPENSE_CATEGORY_HEALTH_AUTHORITY,
                            EXPENSE_SUBCATEGORY_CLINICAL);
                    chcFinancialTotals.add(clinicalTotal);
                }
                
                if (clinical.getFinancials() != null) {
                    for (RootFinancial financial : clinical.getFinancials()) {
                        if (StringUtils.isNotBlank(financial.getExpenseItem())) {
                            FRChcFinancialData chcFinancial = mapFinancialData(root.getForm().getSubmissionId(), financial);
                            chcFinancialData.add(chcFinancial);
                        }
                    }
                }
            }
            
            /** Other Resources & Items */
            RootOtherResources otherResources = financialData.getOtherResourceAndItem();
            if (otherResources != null) {
                if (otherResources.getTotals() != null) {
                    FRChcFinancialTotals otfTotal = mapTotals(root.getForm().getSubmissionId(),
                            root.getFinancialData().getOtherResourceAndItem().getTotals(), EXPENSE_CATEGORY_HEALTH_AUTHORITY,
                            EXPENSE_SUBCATEGORY_OTHER_RESOURCES);
                    chcFinancialTotals.add(otfTotal);
                }
                if (otherResources.getFinancials() != null) {
                    for (RootFinancial financial : otherResources.getFinancials()) {
                        if (StringUtils.isNotBlank(financial.getExpenseItem())) {
                            FRChcFinancialData chcFinancial = mapFinancialData(root.getForm().getSubmissionId(), financial);
                            chcFinancialData.add(chcFinancial);
                        }
                    }
                }

            }
            
             
            /** One-Time Funding */
            RootOneTimeFunding oneTimeFunding = financialData.getOneTimeFunding();
            if (oneTimeFunding != null) {
                if (oneTimeFunding.getTotals() != null) {
                    FRChcFinancialTotals otfTotal = mapTotals(root.getForm().getSubmissionId(),
                            root.getFinancialData().getOneTimeFunding().getTotals(), EXPENSE_CATEGORY_HEALTH_AUTHORITY,
                            EXPENSE_SUBCATEGORY_ONE_TIME_FUNDING);
                    chcFinancialTotals.add(otfTotal);
                }
                if (oneTimeFunding.getFinancials() != null) {
                    for (RootFinancial financial : oneTimeFunding.getFinancials()) {
                        if (StringUtils.isNotBlank(financial.getExpenseItem())) {
                            FRChcFinancialData chcFinancial = mapFinancialData(root.getForm().getSubmissionId(), financial);
                            chcFinancialData.add(chcFinancial);
                        }
                    }
                }

            }



            /* Overhead */
            RootOverhead overhead = financialData.getOverhead();
            if (overhead != null) {
                if (overhead.getTotals() != null) {
                    FRChcFinancialTotals overheadTotal = mapTotals(root.getForm().getSubmissionId(),
                            root.getFinancialData().getOverhead().getTotals(), EXPENSE_CATEGORY_HEALTH_AUTHORITY,
                            EXPENSE_SUBCATEGORY_OVERHEAD);
                    chcFinancialTotals.add(overheadTotal);
                }
                if (overhead.getBudget() != null) {
                    RootOverheadBudget rootBudget = overhead.getBudget();
                    FRChcItemizedBudget overheadBudget = new FRChcItemizedBudget();
                    overheadBudget.setSubmissionId(root.getForm().getSubmissionId());
                    overheadBudget.setBudgetId(UUID.randomUUID().toString());
                    overheadBudget.setExpenseCategory(EXPENSE_CATEGORY_HEALTH_AUTHORITY);
                    overheadBudget.setExpenseSubCategory(EXPENSE_SUBCATEGORY_OVERHEAD);
                    overheadBudget.setApprovedBudget(rootBudget.getApprovedBudget());
                    overheadBudget.setFyExpenseVariance(rootBudget.getFyExpenseVariance());
                    overheadBudget.setProratedYtdBudget(rootBudget.getProratedYtdBudget());
                    overheadBudget.setFyEstimatedSurplus(rootBudget.getFyEstimatedSurplus());
                    overheadBudget.setYtdExpenseVariance(rootBudget.getYtdExpenseVariance());
                    overheadBudget.setFyExpenseVarianceNote(rootBudget.getFyExpenseVarianceNote());
                    overheadBudget.setYtdExpenseVarianceNote(rootBudget.getYtdExpenseVarianceNote());

                    if (overhead.getFinancials() != null) {
                        for (RootFinancial financial : overhead.getFinancials()) {
                            if (StringUtils.isNotEmpty(financial.getExpenseItem())) {
                                FRChcItemizedFinancialData itemizedFinancial = new FRChcItemizedFinancialData();
                                itemizedFinancial.setBudgetId(overheadBudget.getBudgetId());
                                itemizedFinancial.setExpenseId(UUID.randomUUID().toString());
                                itemizedFinancial.setExpenseItem(financial.getExpenseItem());
                                itemizedFinancial.setExpenseItemSubtype(financial.getExpenseItemSubType());
                                itemizedFinancial.setFyExpenseForecast(financial.getFyExpenseForecast());
                                itemizedFinancial.setP1(financial.getP1());
                                itemizedFinancial.setP2(financial.getP2());
                                itemizedFinancial.setP3(financial.getP3());
                                itemizedFinancial.setP4(financial.getP4());
                                itemizedFinancial.setP5(financial.getP5());
                                itemizedFinancial.setP6(financial.getP6());
                                itemizedFinancial.setP7(financial.getP7());
                                itemizedFinancial.setP8(financial.getP8());
                                itemizedFinancial.setP9(financial.getP9());
                                itemizedFinancial.setP10(financial.getP10());
                                itemizedFinancial.setP11(financial.getP11());
                                itemizedFinancial.setP12(financial.getP12());
                                itemizedFinancial.setP13(financial.getP13());
                                itemizedFinancial.setTotalActualYtdExpenses(financial.getTotalActualYtdExpenses());

                                chcItemizedFinancials.add(itemizedFinancial);
                            }
                        }
                        overheadBudget.setFrUpccItemizedFinancialData(chcItemizedFinancials);
                        chcItemizedBudgets.add(overheadBudget);
                    }
                }
            }
            financialReportingChcSubmission.setFrChcFinancialData(chcFinancialData);
            financialReportingChcSubmission.setFrChcItemizedBudgets(chcItemizedBudgets);
            financialReportingChcSubmission.setFrChcFinancialTotals(chcFinancialTotals);
            parsedChcFR.add(financialReportingChcSubmission);
        }

        return parsedChcFR;
    }

    private FRChcFinancialTotals mapTotals(String submissionId, RootTotals rootTotal, String expenseCategory,
            String expenseSubCategory) {
        FRChcFinancialTotals financialTotal = new FRChcFinancialTotals();
        financialTotal.setSubmissionId(submissionId);
        financialTotal.setExpenseCategory(expenseCategory);
        financialTotal.setExpenseSubCategory(expenseSubCategory);
        financialTotal.setApprovedFtes(rootTotal.getApprovedFtes());
        financialTotal.setApprovedBudget(rootTotal.getApprovedBudget());
        financialTotal.setFtesHiredToDate(rootTotal.getFtesHiredToDate());
        financialTotal.setFyExpenseForecast(rootTotal.getFyExpenseForecast());
        financialTotal.setFyExpenseVariance(rootTotal.getFyExpenseVariance());
        financialTotal.setProratedYtdBudget(rootTotal.getProratedYtdBudget());
        financialTotal.setFyEstimatedSurplus(rootTotal.getFyEstimatedSurplus());
        financialTotal.setYtdExpenseVariance(rootTotal.getYtdExpenseVariance());
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

//    public FRUpccFinancialSubTotals mapSubTotal(String submissionId, RootTotals rootSubtotal, String expenseCategory,
//            String expenseSubCategory, String typeOfCare) {
//        FRUpccFinancialSubTotals financialSubTotal = new FRUpccFinancialSubTotals();
//        financialSubTotal.setSubmissionId(submissionId);
//        financialSubTotal.setExpenseCategory(expenseCategory);
//        financialSubTotal.setExpenseSubCategory(expenseSubCategory);
//        financialSubTotal.setTypeOfCare(typeOfCare);
//        financialSubTotal.setApprovedBudget(rootSubtotal.getApprovedBudget());
//        financialSubTotal.setFtesHiredToDate(rootSubtotal.getFtesHiredToDate());
//        financialSubTotal.setFyExpenseForecast(rootSubtotal.getFyExpenseForecast());
//        financialSubTotal.setFyExpenseVariance(rootSubtotal.getFyExpenseVariance());
//        financialSubTotal.setFyEstimatedSurplus(rootSubtotal.getFyEstimatedSurplus());
//        financialSubTotal.setProratedYtdBudget(rootSubtotal.getProratedYtdBudget());
//        financialSubTotal.setYtdExpenseVariance(rootSubtotal.getYtdExpenseVariance());
//        financialSubTotal.setApprovedFtesInclRelief(rootSubtotal.getApprovedFtesInclRelief());
//        financialSubTotal.setTotalActualYtdExpense(rootSubtotal.getTotalActualYtdExpenses());
//        financialSubTotal.setP1(rootSubtotal.getP1());
//        financialSubTotal.setP2(rootSubtotal.getP2());
//        financialSubTotal.setP3(rootSubtotal.getP3());
//        financialSubTotal.setP4(rootSubtotal.getP4());
//        financialSubTotal.setP5(rootSubtotal.getP5());
//        financialSubTotal.setP6(rootSubtotal.getP6());
//        financialSubTotal.setP7(rootSubtotal.getP7());
//        financialSubTotal.setP8(rootSubtotal.getP8());
//        financialSubTotal.setP9(rootSubtotal.getP9());
//        financialSubTotal.setP10(rootSubtotal.getP10());
//        financialSubTotal.setP11(rootSubtotal.getP11());
//        financialSubTotal.setP12(rootSubtotal.getP12());
//        financialSubTotal.setP13(rootSubtotal.getP13());
//        return financialSubTotal;
//    }

    public FRChcFinancialData mapFinancialData(String submissionId, RootFinancial financial) {
        FRChcFinancialData newFinancialData = new FRChcFinancialData();
        newFinancialData.setSubmissionId(submissionId);
        newFinancialData.setExpenseId(UUID.randomUUID().toString());
        newFinancialData.setApprovedBudget(financial.getApprovedBudget());
        newFinancialData.setApprovedFtes(financial.getApprovedFtes());
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
        newFinancialData.setYtdExpenseVariance(financial.getYtdExpenseVariance());
        newFinancialData.setYtdExpenseVarianceNote(financial.getYtdExpenseVarianceNote());

        return newFinancialData;
    }
}
