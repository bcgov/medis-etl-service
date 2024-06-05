package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.processor;

import static ca.bc.gov.chefs.etl.constant.PCDConstants.CATEGORY_HEALTH_AUTHORITY;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_CLINICAL;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_ONE_TIME_FUNDING;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_OVERHEAD;
import static ca.bc.gov.chefs.etl.util.CSVUtil.parseBigDecimal;

import java.math.BigDecimal;
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
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccFinancialTotals;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccItemizedBudget;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccItemizedFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FinancialReportingUpccSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdUpccFRApiResponseProcessor extends BaseApiResponseProcessor {

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        payload = JsonUtil.fixExpenseItemAndSubType(payload);
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

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<FinancialReportingUpccSubmission> parseUpccFRRequest(List<Root> upccFRPayloads) {
        List<FinancialReportingUpccSubmission> parsedUpccFR = new ArrayList<>();
        for (Root root : upccFRPayloads) {
            FinancialReportingUpccSubmission financialReportingUpccSubmission = new FinancialReportingUpccSubmission();
            List<FRUpccFinancialData> upccFinancialData = new ArrayList<>();
            List<FRUpccItemizedBudget> upccItemizedBudget = new ArrayList<>();
            List<FRUpccFinancialTotals> upccFinancialTotals = new ArrayList<>();
            List<FRUpccItemizedFinancialData> upccItemizedFinancialData = new ArrayList<>();
            
            String submissionId = root.getForm().getSubmissionId();

            /** mapping FinancialReprotingUPCCSubmission */
            financialReportingUpccSubmission.setSubmissionId(submissionId);
            financialReportingUpccSubmission.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
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
            financialReportingUpccSubmission.setPeriodReported(root.getPeriodReported());
            financialReportingUpccSubmission
                    .setReasonForExceptionInPeriodReported(root.getReasonForExceptionInPeriodReported());
            financialReportingUpccSubmission.setAdditionalNotes(root.getFinancialData().getAdditionalNotes());
            
            Totals clinicalTotals = new Totals(submissionId, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_CLINICAL);

            /* Clinical Urgent Care */
            if (root.getFinancialData().getClinical().getUrgentCare() != null) {
                
                if (root.getFinancialData().getClinical().getUrgentCare().getFinancials() != null
                        && !root.getFinancialData().getClinical().getUrgentCare().getFinancials().isEmpty()) {
                    for (RootFinancial ucFinancial : root.getFinancialData().getClinical().getUrgentCare()
                            .getFinancials()) {
                        if (!ucFinancial.getExpenseItem().isEmpty() && ucFinancial.getExpenseItem() != null) {
                            FRUpccFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
                                    ucFinancial);
                            upccFinancialData.add(newFinancialData);
                            
                            populateTotals(clinicalTotals, ucFinancial);
                        }
                    }
                }
            }

            /* Clinical Longitudinal Care */
            if (root.getFinancialData().getClinical().getLongitudinalCare() != null) {
                if (root.getFinancialData().getClinical().getLongitudinalCare().getFinancials() != null
                        && !root.getFinancialData().getClinical().getLongitudinalCare().getFinancials().isEmpty()) {
                    for (RootFinancial lcFinancial : root.getFinancialData().getClinical().getLongitudinalCare()
                            .getFinancials()) {
                        if (!lcFinancial.getExpenseItem().isEmpty() && lcFinancial.getExpenseItem() != null) {
                            FRUpccFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
                                    lcFinancial);
                            upccFinancialData.add(newFinancialData);
                            
                            populateTotals(clinicalTotals, lcFinancial);
                        }
                    }
                }
            }

            /* Clinical Mixed Stream */
            if (root.getFinancialData().getClinical().getMixedStream() != null) {
                if (root.getFinancialData().getClinical().getMixedStream().getFinancials() != null
                        && !root.getFinancialData().getClinical().getMixedStream().getFinancials().isEmpty()) {
                    for (RootFinancial msFinancial : root.getFinancialData().getClinical().getMixedStream()
                            .getFinancials()) {
                        if (!msFinancial.getExpenseItem().isEmpty() && msFinancial.getExpenseItem() != null) {
                            FRUpccFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
                                    msFinancial);
                            upccFinancialData.add(newFinancialData);
                            
                            populateTotals(clinicalTotals, msFinancial);
                        }
                    }
                }
            }

            /* One Time Funding */
            Totals oneTimeFundingTotals = new Totals(submissionId, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_ONE_TIME_FUNDING);
            
            if (root.getFinancialData().getOneTimeFunding() != null) {
                if (root.getFinancialData().getOneTimeFunding().getFinancials() != null
                        && !root.getFinancialData().getOneTimeFunding().getFinancials().isEmpty()) {
                    for (RootFinancial otfFinancial : root.getFinancialData().getOneTimeFunding().getFinancials()) {
                        if (!otfFinancial.getExpenseItem().isEmpty() && otfFinancial.getExpenseItem() != null) {
                            FRUpccFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
                                    otfFinancial);
                            upccFinancialData.add(newFinancialData);
                            
                            populateTotals(oneTimeFundingTotals, otfFinancial);
                        }
                    }
                }
            }

            /* Overhead */
            Totals overheadTotals = new Totals(submissionId, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_OVERHEAD);
            
            if (root.getFinancialData().getOverhead() != null) {
                if (root.getFinancialData().getOverhead().getBudget() != null) {
                    RootOverheadBudget rootBudget = root.getFinancialData().getOverhead().getBudget();
                    FRUpccItemizedBudget overheadBudget = new FRUpccItemizedBudget();
                    overheadBudget.setSubmissionId(root.getForm().getSubmissionId());
                    overheadBudget.setBudgetId(UUID.randomUUID().toString());
                    overheadBudget.setExpenseCategory(CATEGORY_HEALTH_AUTHORITY);
                    overheadBudget.setExpenseSubCategory(SUB_CATEGORY_OVERHEAD);
                    overheadBudget.setApprovedBudget(rootBudget.getApprovedBudget());
                    overheadBudget.setFyExpenseVariance(rootBudget.getFyExpenseVariance());
                    overheadBudget.setProratedYtdBudget(rootBudget.getProratedYtdBudget());
                    overheadBudget.setFyEstimatedSurplus(rootBudget.getFyEstimatedSurplus());
                    overheadBudget.setYtdExpenseVariance(rootBudget.getYtdExpenseVariance());
                    overheadBudget.setFyExpenseVarianceNote(rootBudget.getFyExpenseVarianceNote());
                    overheadBudget.setYtdExpenseVarianceNote(rootBudget.getYtdExpenseVarianceNote());
                    
                    populateTotals(overheadTotals, rootBudget);
                    
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
                                
                                populateTotals(overheadTotals, overheadFinancial);
                            }
                        }
                    }
                    overheadBudget.setFrUpccItemizedFinancialData(upccItemizedFinancialData); 
                    upccItemizedBudget.add(overheadBudget);
                }

            }
            
            // Finalize the totals
            upccFinancialTotals.add(convertTotals(clinicalTotals));
            upccFinancialTotals.add(convertTotals(oneTimeFundingTotals));
            upccFinancialTotals.add(convertTotals(overheadTotals));

            financialReportingUpccSubmission.setFrUpccFinancialData(upccFinancialData);
            financialReportingUpccSubmission.setFrUpccItemizedBudgets(upccItemizedBudget);
            financialReportingUpccSubmission.setFrUpccFinancialTotals(upccFinancialTotals);
            parsedUpccFR.add(financialReportingUpccSubmission);
        }

        return parsedUpccFR;
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
    
    private void populateTotals(Totals totals, RootFinancial financial) {
        totals.setApprovedBudget(totals.getApprovedBudget().add(parseBigDecimal(financial.getApprovedBudget())));
        totals.setApprovedFtesInclRelief(totals.getApprovedFtesInclRelief().add(parseBigDecimal(financial.getApprovedFtesInclRelief())));
        totals.setFtesHiredToDate(totals.getFtesHiredToDate().add(parseBigDecimal(financial.getFtesHiredToDate())));
        totals.setFyExpenseForecast(totals.getFyExpenseForecast().add(parseBigDecimal(financial.getFyExpenseForecast())));

        totals.setP1(totals.getP1().add(parseBigDecimal(financial.getP1())));
        totals.setP2(totals.getP2().add(parseBigDecimal(financial.getP2())));
        totals.setP3(totals.getP3().add(parseBigDecimal(financial.getP3())));
        totals.setP4(totals.getP4().add(parseBigDecimal(financial.getP4())));
        totals.setP5(totals.getP5().add(parseBigDecimal(financial.getP5())));
        totals.setP6(totals.getP6().add(parseBigDecimal(financial.getP6())));
        totals.setP7(totals.getP7().add(parseBigDecimal(financial.getP7())));
        totals.setP8(totals.getP8().add(parseBigDecimal(financial.getP8())));
        totals.setP9(totals.getP9().add(parseBigDecimal(financial.getP9())));
        totals.setP10(totals.getP10().add(parseBigDecimal(financial.getP10())));
        totals.setP11(totals.getP11().add(parseBigDecimal(financial.getP11())));
        totals.setP12(totals.getP12().add(parseBigDecimal(financial.getP12())));
        totals.setP13(totals.getP13().add(parseBigDecimal(financial.getP13())));
    }
    private void populateTotals(Totals totals, RootOverheadBudget budget) {
        totals.setApprovedBudget(totals.getApprovedBudget().add(parseBigDecimal(budget.getApprovedBudget())));
    }
    
    /**
     * Rounds the totals and convert to String before outputting to CSV.
     * @param totals
     * @param upccTotals
     */
    private FRUpccFinancialTotals convertTotals(Totals totals) {
        FRUpccFinancialTotals upccTotals = new FRUpccFinancialTotals();
        
        upccTotals.setSubmissionId(totals.getSubmissionId());
        upccTotals.setExpenseCategory(totals.getExpenseCategory());
        upccTotals.setExpenseSubCategory(totals.getExpenseSubCategory());
        
        upccTotals.setApprovedBudget(totals.getApprovedBudget().toString());
        upccTotals.setApprovedFtesInclRelief(totals.getApprovedFtesInclRelief().toString());        
        upccTotals.setFtesHiredToDate(totals.getFtesHiredToDate().toString());
        upccTotals.setFyExpenseForecast(totals.getFyExpenseForecast().toString());

        upccTotals.setP1(totals.getP1().toString());
        upccTotals.setP2(totals.getP2().toString());
        upccTotals.setP3(totals.getP3().toString());
        upccTotals.setP4(totals.getP4().toString());
        upccTotals.setP5(totals.getP5().toString());
        upccTotals.setP6(totals.getP6().toString());
        upccTotals.setP7(totals.getP7().toString());
        upccTotals.setP8(totals.getP8().toString());
        upccTotals.setP9(totals.getP9().toString());
        upccTotals.setP10(totals.getP10().toString());
        upccTotals.setP11(totals.getP11().toString());
        upccTotals.setP12(totals.getP12().toString());
        upccTotals.setP13(totals.getP13().toString());
        
        return upccTotals;
    }
    
    class Totals {
        
        public Totals(String submissionId, String expenseCategory, String expenseSubCategory) {
            super();
            this.submissionId = submissionId;
            this.expenseCategory = expenseCategory;
            this.expenseSubCategory = expenseSubCategory;
        }
        private String submissionId;
        private String expenseCategory;
        private String expenseSubCategory;
        private BigDecimal approvedBudget = BigDecimal.ZERO;
        private BigDecimal ftesHiredToDate = BigDecimal.ZERO;
        private BigDecimal fyExpenseForecast = BigDecimal.ZERO;
        private BigDecimal approvedFtesInclRelief = BigDecimal.ZERO;;
        private BigDecimal p1 = BigDecimal.ZERO;;
        private BigDecimal p2 = BigDecimal.ZERO;;
        private BigDecimal p3 = BigDecimal.ZERO;;
        private BigDecimal p4 = BigDecimal.ZERO;;
        private BigDecimal p5 = BigDecimal.ZERO;;
        private BigDecimal p6 = BigDecimal.ZERO;;
        private BigDecimal p7 = BigDecimal.ZERO;;
        private BigDecimal p8 = BigDecimal.ZERO;;
        private BigDecimal p9 = BigDecimal.ZERO;;
        private BigDecimal p10 = BigDecimal.ZERO;;
        private BigDecimal p11 = BigDecimal.ZERO;;
        private BigDecimal p12 = BigDecimal.ZERO;;
        private BigDecimal p13 = BigDecimal.ZERO;;
        
        public String getSubmissionId() {
            return submissionId;
        }
        public void setSubmissionId(String submissionId) {
            this.submissionId = submissionId;
        }
        public String getExpenseCategory() {
            return expenseCategory;
        }
        public void setExpenseCategory(String expenseCategory) {
            this.expenseCategory = expenseCategory;
        }
        public String getExpenseSubCategory() {
            return expenseSubCategory;
        }
        public void setExpenseSubCategory(String expenseSubCategory) {
            this.expenseSubCategory = expenseSubCategory;
        }
        public BigDecimal getApprovedBudget() {
            return approvedBudget;
        }
        public void setApprovedBudget(BigDecimal approvedBudget) {
            this.approvedBudget = approvedBudget;
        }
        public BigDecimal getFtesHiredToDate() {
            return ftesHiredToDate;
        }
        public void setFtesHiredToDate(BigDecimal ftesHiredToDate) {
            this.ftesHiredToDate = ftesHiredToDate;
        }
        public BigDecimal getFyExpenseForecast() {
            return fyExpenseForecast;
        }
        public void setFyExpenseForecast(BigDecimal fyExpenseForecast) {
            this.fyExpenseForecast = fyExpenseForecast;
        }
        public BigDecimal getApprovedFtesInclRelief() {
            return approvedFtesInclRelief;
        }
        public void setApprovedFtesInclRelief(BigDecimal approvedFtesInclRelief) {
            this.approvedFtesInclRelief = approvedFtesInclRelief;
        }
        public BigDecimal getP1() {
            return p1;
        }
        public void setP1(BigDecimal p1) {
            this.p1 = p1;
        }
        public BigDecimal getP2() {
            return p2;
        }
        public void setP2(BigDecimal p2) {
            this.p2 = p2;
        }
        public BigDecimal getP3() {
            return p3;
        }
        public void setP3(BigDecimal p3) {
            this.p3 = p3;
        }
        public BigDecimal getP4() {
            return p4;
        }
        public void setP4(BigDecimal p4) {
            this.p4 = p4;
        }
        public BigDecimal getP5() {
            return p5;
        }
        public void setP5(BigDecimal p5) {
            this.p5 = p5;
        }
        public BigDecimal getP6() {
            return p6;
        }
        public void setP6(BigDecimal p6) {
            this.p6 = p6;
        }
        public BigDecimal getP7() {
            return p7;
        }
        public void setP7(BigDecimal p7) {
            this.p7 = p7;
        }
        public BigDecimal getP8() {
            return p8;
        }
        public void setP8(BigDecimal p8) {
            this.p8 = p8;
        }
        public BigDecimal getP9() {
            return p9;
        }
        public void setP9(BigDecimal p9) {
            this.p9 = p9;
        }
        public BigDecimal getP10() {
            return p10;
        }
        public void setP10(BigDecimal p10) {
            this.p10 = p10;
        }
        public BigDecimal getP11() {
            return p11;
        }
        public void setP11(BigDecimal p11) {
            this.p11 = p11;
        }
        public BigDecimal getP12() {
            return p12;
        }
        public void setP12(BigDecimal p12) {
            this.p12 = p12;
        }
        public BigDecimal getP13() {
            return p13;
        }
        public void setP13(BigDecimal p13) {
            this.p13 = p13;
        }
   
        
    }
}
