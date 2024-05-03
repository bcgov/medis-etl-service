package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.processor;

import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_CLINICAL;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_ONE_TIME_FUNDING;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_OVERHEAD;
import static ca.bc.gov.chefs.etl.util.CSVUtil.formatBigDecimal;
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
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json.RootAdditionalInfo;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json.RootUpccBudget;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model.FinancialBudgetUPCC;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model.FinancialBudgetUPCCExpense;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model.FinancialBudgetUPCCTotals;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model.UpccExpensePrimaryTargetPopulation;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model.UpccExpenseStrategy;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdUpccBudgetApiResponseProcessor extends BaseApiResponseProcessor {
    
	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> upccBudgetModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<FinancialBudgetUPCC> parsedUpccBudget = parseUpccBudgetRequest(upccBudgetModels);
		
		validateRecordCount(upccBudgetModels, parsedUpccBudget);
		
		List<IModel> iModels = (List<IModel>) (List<?>) parsedUpccBudget;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_UPCC_BUDGET_DIR, isHeaderAdded);

		  SuccessResponse successResponse = new SuccessResponse();
		  successResponse.setFiles(filesGenerated);
		  exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}

    private List<FinancialBudgetUPCC> parseUpccBudgetRequest(List<Root> upccBudgetPayloads) {
        List<FinancialBudgetUPCC> parsedUpccBudget = new ArrayList<>();
        for (Root root : upccBudgetPayloads) {
            FinancialBudgetUPCC financialBudgetUPCC = new FinancialBudgetUPCC();
            List<FinancialBudgetUPCCTotals> financialBudgetUPCCTotals = new ArrayList<>();
            List<FinancialBudgetUPCCExpense> financialBudgetUPCCExpenses = new ArrayList<>();
            List<UpccExpensePrimaryTargetPopulation> upccExpensePrimaryTargetPopulation = new ArrayList<>();
            List<UpccExpenseStrategy> upccExpenseStrategy = new ArrayList<>();
            
            String submissionId = root.getForm().getSubmissionId();

            /** mapping  financialBudgetUPCC */
            financialBudgetUPCC.setSubmissionId(submissionId);
            financialBudgetUPCC.setCreatedAt(root.getForm().getCreatedAt());
            financialBudgetUPCC.setLateEntry(root.getLateEntry());
            financialBudgetUPCC.setSubmitterFullName(root.getForm().getFullName());
            financialBudgetUPCC.setSubmitterUserName(root.getForm().getUsername());
            financialBudgetUPCC.setSubmitterEmail(root.getForm().getEmail());
            financialBudgetUPCC.setSubmissionStatus(root.getForm().getStatus());
            financialBudgetUPCC.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
            financialBudgetUPCC.setSubmissionFormName(root.getForm().getFormName());
            financialBudgetUPCC.setHealthAuthority(root.getHealthAuthority());
            financialBudgetUPCC.setCommunityName(root.getCommunityName());
            financialBudgetUPCC.setFiscalYear(root.getFiscalYear());
            financialBudgetUPCC.setUppcName(root.getUpccName());
                   
            Totals totals = new Totals(submissionId);
            
            /** mapping financialBudgetUPCCExpense */
            for (RootUpccBudget budget : root.getUpccBudget()) {
                FinancialBudgetUPCCExpense newUpccExpense = new FinancialBudgetUPCCExpense();
                newUpccExpense.setSubmissionId(root.getForm().getSubmissionId());
                newUpccExpense.setExpenseId(UUID.randomUUID().toString());
                newUpccExpense.setExpenseCategory(budget.getExpenseCategory());
                newUpccExpense.setExpenseSubCategory(budget.getExpenseSubCategory());
                newUpccExpense.setTypeOfCare(budget.getTypeOfCare());
                newUpccExpense.setExpenseItem(budget.getExpenseItem());
                newUpccExpense.setExpenseItemSubType(budget.getExpenseItemSubType());
                newUpccExpense.setApprovedBudget(budget.getApprovedBudget());
                newUpccExpense.setApprovedFtesInclRelief(budget.getApprovedFtesInclRelief());

                financialBudgetUPCCExpenses.add(newUpccExpense);
                
                populateTotals(totals, budget);

                /** mapping UpccExpenseStrategy */
                if (budget.getAdditionalSchedule1Info() != null && !budget.getAdditionalSchedule1Info().isEmpty()) {
                    for(RootAdditionalInfo additionalInfo : budget.getAdditionalSchedule1Info()){
                        if (!additionalInfo.getStrategyTitle().isEmpty()) {
                            UpccExpenseStrategy newExpenseStrategy = new UpccExpenseStrategy();
                            newExpenseStrategy.setExpenseId(newUpccExpense.getExpenseId());
                            newExpenseStrategy.setStrategyId(UUID.randomUUID().toString());
                            newExpenseStrategy.setStrategyTitle(additionalInfo.getStrategyTitle());
                            upccExpenseStrategy.add(newExpenseStrategy);
                            /** mapping UpccExpensePrimaryTargetPopulation */
                            if (additionalInfo.getPrimaryTargetPopulation() != null 
                            && !additionalInfo.getPrimaryTargetPopulation().isEmpty()) {
                                for (String targetPopulation : additionalInfo.getPrimaryTargetPopulation()) {
                                    UpccExpensePrimaryTargetPopulation newTargetPopulation = new UpccExpensePrimaryTargetPopulation();
                                    newTargetPopulation.setStrategyId(newExpenseStrategy.getStrategyId());
                                    newTargetPopulation.setTargetPopulation(targetPopulation);
            
                                    upccExpensePrimaryTargetPopulation.add(newTargetPopulation);
                                }
                            }
                        }
                    }
                }
            }


            // Finalize the totals
            financialBudgetUPCCTotals.add(convertTotals(totals));     
            
            financialBudgetUPCC.setFinancialBudgetUPCCTotals(financialBudgetUPCCTotals);
            financialBudgetUPCC.setFinancialBudgetUPCCExpenses(financialBudgetUPCCExpenses);
            financialBudgetUPCC.setUpccExpensePrimaryTargetPopulation(upccExpensePrimaryTargetPopulation);
            financialBudgetUPCC.setUpccExpenseStrategies(upccExpenseStrategy);
            parsedUpccBudget.add(financialBudgetUPCC);
        }

        return parsedUpccBudget;
    }
    
    private void populateTotals(Totals totals, RootUpccBudget budget) {
        BigDecimal approvedBudget = parseBigDecimal(budget.getApprovedBudget());
        BigDecimal approvedFtes = parseBigDecimal(budget.getApprovedFtesInclRelief());
        
        // Sub-Category totals
        switch (budget.getExpenseSubCategory()) {
        case SUB_CATEGORY_CLINICAL:
            totals.setClinicalApprovedBudget(totals.getClinicalApprovedBudget().add(approvedBudget));
            totals.setClinicalApprovedFtes(totals.getClinicalApprovedFtes().add(approvedFtes));
            break;
        case SUB_CATEGORY_ONE_TIME_FUNDING:
            totals.setOneTimeFundingApprovedBudget(totals.getOneTimeFundingApprovedBudget().add(approvedBudget));
            break;
        case SUB_CATEGORY_OVERHEAD:
            totals.setOverheadApprovedBudget(totals.getOverheadApprovedBudget().add(approvedBudget));
            break;
        }
    }
    
    /**
     * Rounds the totals and convert to String before outputting to CSV.
     * @param totals
     * @return Converted totals
     */
    private FinancialBudgetUPCCTotals convertTotals(Totals totals) {
        FinancialBudgetUPCCTotals upccTotals = new FinancialBudgetUPCCTotals();
        upccTotals.setSubmissionId(totals.getSubmissionId());
        
        upccTotals.setClinicalApprovedBudget(formatBigDecimal(totals.getClinicalApprovedBudget()));
        upccTotals.setClinicalApprovedFtes(formatBigDecimal(totals.getClinicalApprovedFtes()));
        
        upccTotals.setOneTimeFundingApprovedBudget(formatBigDecimal(totals.getOneTimeFundingApprovedBudget()));
        upccTotals.setOverheadApprovedBudget(formatBigDecimal(totals.getOverheadApprovedBudget()));
       
        return upccTotals;
    }
    
    class Totals {
        private String submissionId;
        private BigDecimal totalApprovedBudget = BigDecimal.ZERO;
        private BigDecimal totalApprovedFtes = BigDecimal.ZERO;
        private BigDecimal clinicalApprovedBudget = BigDecimal.ZERO;
        private BigDecimal clinicalApprovedFtes = BigDecimal.ZERO;
        private BigDecimal overheadApprovedBudget = BigDecimal.ZERO;
        private BigDecimal oneTimeFundingApprovedBudget = BigDecimal.ZERO;
        
        public Totals(String submissionId) {
            super();
            this.submissionId = submissionId;
        }
        public String getSubmissionId() {
            return submissionId;
        }
        public void setSubmissionId(String submissionId) {
            this.submissionId = submissionId;
        }
        public BigDecimal getTotalApprovedBudget() {
            return totalApprovedBudget;
        }
        public void setTotalApprovedBudget(BigDecimal totalApprovedBudget) {
            this.totalApprovedBudget = totalApprovedBudget;
        }
        public BigDecimal getTotalApprovedFtes() {
            return totalApprovedFtes;
        }
        public void setTotalApprovedFtes(BigDecimal totalApprovedFtes) {
            this.totalApprovedFtes = totalApprovedFtes;
        }
        public BigDecimal getClinicalApprovedBudget() {
            return clinicalApprovedBudget;
        }
        public void setClinicalApprovedBudget(BigDecimal clinicalApprovedBudget) {
            this.clinicalApprovedBudget = clinicalApprovedBudget;
        }
        public BigDecimal getClinicalApprovedFtes() {
            return clinicalApprovedFtes;
        }
        public void setClinicalApprovedFtes(BigDecimal clinicalApprovedFtes) {
            this.clinicalApprovedFtes = clinicalApprovedFtes;
        }
        public BigDecimal getOverheadApprovedBudget() {
            return overheadApprovedBudget;
        }
        public void setOverheadApprovedBudget(BigDecimal overheadApprovedBudget) {
            this.overheadApprovedBudget = overheadApprovedBudget;
        }
        public BigDecimal getOneTimeFundingApprovedBudget() {
            return oneTimeFundingApprovedBudget;
        }
        public void setOneTimeFundingApprovedBudget(BigDecimal oneTimeFundingApprovedBudget) {
            this.oneTimeFundingApprovedBudget = oneTimeFundingApprovedBudget;
        }
        
        
    }
}

