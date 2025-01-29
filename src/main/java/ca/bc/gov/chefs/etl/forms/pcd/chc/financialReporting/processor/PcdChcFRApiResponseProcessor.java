package ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.processor;

import static ca.bc.gov.chefs.etl.constant.PCDConstants.CATEGORY_HEALTH_AUTHORITY;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_CLINICAL;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_ONE_TIME_FUNDING;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_OTHER_RESOURCES;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_OVERHEAD;
import static ca.bc.gov.chefs.etl.util.CSVUtil.isNonZero;
import static ca.bc.gov.chefs.etl.util.CSVUtil.parseBigDecimal;

import java.math.BigDecimal;
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
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model.FRChcFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model.FRChcFinancialTotals;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model.FRChcItemizedBudget;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model.FRChcItemizedFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model.FinancialReportingChcSubmission;
import ca.bc.gov.chefs.etl.forms.pcd.haMapping.json.HaMapping;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;
public class PcdChcFRApiResponseProcessor extends BaseApiResponseProcessor {

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        payload = JsonUtil.fixExpenseItemAndSubType(payload);
        payload = JsonUtil.fixUnicodeCharacters(payload);
        ObjectMapper mapper = new ObjectMapper();

        List<Root> chcFRModels = mapper.readValue(payload,
                new TypeReference<List<Root>>() {
                });
        
        String haHierarchyMappingPayload = (String)exchange.getProperties().get("haMapping");
       
        List<HaMapping> haMappings = mapper.readValue(haHierarchyMappingPayload, new TypeReference<List<HaMapping>>() {
		});
        
        List<FinancialReportingChcSubmission> parsedChcFR = parseChcFRRequest(chcFRModels, haMappings);

        validateRecordCount(chcFRModels, parsedChcFR);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedChcFR;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_CHC_FR_DIR, isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<FinancialReportingChcSubmission> parseChcFRRequest(List<Root> chcFRPayloads, List<HaMapping> haMappings) {
        List<FinancialReportingChcSubmission> parsedChcFR = new ArrayList<>();
        for (Root root : chcFRPayloads) {
            FinancialReportingChcSubmission financialReportingChcSubmission = new FinancialReportingChcSubmission();
            List<FRChcFinancialData> chcFinancialData = new ArrayList<>();
            List<FRChcItemizedBudget> chcItemizedBudgets = new ArrayList<>();
            List<FRChcFinancialTotals> chcFinancialTotals = new ArrayList<>();
            List<FRChcItemizedFinancialData> chcItemizedFinancials = new ArrayList<>();
            
            String submissionId = root.getForm().getSubmissionId();

            /** mapping FinancialReportingChcSubmission */
            financialReportingChcSubmission.setSubmissionId(submissionId);
            financialReportingChcSubmission.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
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
            String chcCode = StringUtils.defaultIfBlank(root.getChcId(), JsonUtil.fixHierarchyCode(haMappings, "CHC", root.getChcName()));
            financialReportingChcSubmission.setChcCode(chcCode);
            financialReportingChcSubmission.setFiscalYear(root.getFiscalYear());
            financialReportingChcSubmission.setPeriodReported(root.getPeriodReported());
            financialReportingChcSubmission
                    .setReasonForExceptionInPeriodReported(root.getReasonForExceptionInPeriodReported());
            financialReportingChcSubmission.setAdditionalNotes(root.getFinancialData().getAdditionalNotes());
            
            RootFinancialData financialData = root.getFinancialData();

            /** Clinical */
            Totals clinicalTotals = new Totals(submissionId, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_CLINICAL);
            RootClinical clinical = financialData.getClinical();            
            if (clinical != null) {
                if (clinical.getFinancials() != null) {
                    for (RootFinancial financial : clinical.getFinancials()) {
                        if (StringUtils.isNotBlank(financial.getExpenseItem()) && isNonZero(financial.getApprovedBudget())) {
                            FRChcFinancialData chcFinancial = mapFinancialData(root.getForm().getSubmissionId(), financial);
                            chcFinancialData.add(chcFinancial);
                            
                            populateTotals(clinicalTotals, financial);
                        }
                    }
                }
            }
            
            /** Other Resources & Items */
            Totals otherResourcesTotals = new Totals(submissionId, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_OTHER_RESOURCES);
            RootOtherResources otherResources = financialData.getOtherResourceAndItem();
            if (otherResources != null) {

                if (otherResources.getFinancials() != null) {
                    for (RootFinancial financial : otherResources.getFinancials()) {
                        if (StringUtils.isNotBlank(financial.getExpenseItem()) && isNonZero(financial.getApprovedBudget())) {
                            FRChcFinancialData chcFinancial = mapFinancialData(root.getForm().getSubmissionId(), financial);
                            chcFinancialData.add(chcFinancial);
                            
                            populateTotals(otherResourcesTotals, financial);
                        }
                    }
                }

            }
            
             
            /** One-Time Funding */
            Totals oneTimeFundingTotals = new Totals(submissionId, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_ONE_TIME_FUNDING);
            RootOneTimeFunding oneTimeFunding = financialData.getOneTimeFunding();
            if (oneTimeFunding != null) {
                if (oneTimeFunding.getFinancials() != null) {
                    for (RootFinancial financial : oneTimeFunding.getFinancials()) {
                        if (StringUtils.isNotBlank(financial.getExpenseItem()) && isNonZero(financial.getApprovedBudget())) {
                            FRChcFinancialData chcFinancial = mapFinancialData(root.getForm().getSubmissionId(), financial);
                            chcFinancialData.add(chcFinancial);
                            
                            populateTotals(oneTimeFundingTotals, financial);
                        }
                    }
                }

            }

            /* Overhead */
            Totals overheadTotals = new Totals(submissionId, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_OVERHEAD);
            RootOverhead overhead = financialData.getOverhead();
            if (overhead != null) {

                if (overhead.getBudget() != null && isNonZero(overhead.getBudget().getApprovedBudget())) {
                    RootOverheadBudget rootBudget = overhead.getBudget();
                    FRChcItemizedBudget overheadBudget = new FRChcItemizedBudget();
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
                                
                                populateTotals(overheadTotals, financial);
                            }
                        }
                        overheadBudget.setFrChcItemizedFinancialData(chcItemizedFinancials);
                        chcItemizedBudgets.add(overheadBudget);
                    }
                }
            }
            financialReportingChcSubmission.setFrChcFinancialData(chcFinancialData);
            financialReportingChcSubmission.setFrChcItemizedBudgets(chcItemizedBudgets);
            financialReportingChcSubmission.setFrChcFinancialTotals(chcFinancialTotals);
            parsedChcFR.add(financialReportingChcSubmission);
            
            // Finalize the totals
            chcFinancialTotals.add(convertTotals(clinicalTotals));
            chcFinancialTotals.add(convertTotals(otherResourcesTotals));
            chcFinancialTotals.add(convertTotals(oneTimeFundingTotals));
            chcFinancialTotals.add(convertTotals(overheadTotals));
        }

        return parsedChcFR;
    }

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
    
    private void populateTotals(Totals totals, RootFinancial financial) {
        totals.setApprovedBudget(totals.getApprovedBudget().add(parseBigDecimal(financial.getApprovedBudget())));
        totals.setApprovedFtes(totals.getApprovedFtes().add(parseBigDecimal(financial.getApprovedFtes())));
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
    private FRChcFinancialTotals convertTotals(Totals totals) {
        FRChcFinancialTotals chcTotals = new FRChcFinancialTotals();
        
        chcTotals.setSubmissionId(totals.getSubmissionId());
        chcTotals.setExpenseCategory(totals.getExpenseCategory());
        chcTotals.setExpenseSubCategory(totals.getExpenseSubCategory());
        
        chcTotals.setApprovedBudget(totals.getApprovedBudget().toString());
        chcTotals.setApprovedFtes(totals.getApprovedFtes().toString());        
        chcTotals.setFtesHiredToDate(totals.getFtesHiredToDate().toString());
        chcTotals.setFyExpenseForecast(totals.getFyExpenseForecast().toString());

        chcTotals.setP1(totals.getP1().toString());
        chcTotals.setP2(totals.getP2().toString());
        chcTotals.setP3(totals.getP3().toString());
        chcTotals.setP4(totals.getP4().toString());
        chcTotals.setP5(totals.getP5().toString());
        chcTotals.setP6(totals.getP6().toString());
        chcTotals.setP7(totals.getP7().toString());
        chcTotals.setP8(totals.getP8().toString());
        chcTotals.setP9(totals.getP9().toString());
        chcTotals.setP10(totals.getP10().toString());
        chcTotals.setP11(totals.getP11().toString());
        chcTotals.setP12(totals.getP12().toString());
        chcTotals.setP13(totals.getP13().toString());
        
        return chcTotals;
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
        private BigDecimal approvedFtes = BigDecimal.ZERO;;
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

        public BigDecimal getApprovedFtes() {
            return approvedFtes;
        }
        public void setApprovedFtes(BigDecimal approvedFtes) {
            this.approvedFtes = approvedFtes;
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
