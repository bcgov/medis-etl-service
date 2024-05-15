package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.processor;

import static ca.bc.gov.chefs.etl.constant.PCDConstants.CATEGORY_DOFP;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.CATEGORY_FAMILY_PYHSICIANS;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.CATEGORY_HEALTH_AUTHORITY;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_HEALTH_CLINICAL;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_DOFP_RESOURCES;
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
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.json.RootAdditionalSchedule1Info;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.json.RootPcnBudgetItem;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.FinancialBudgetPCN;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.FinancialBudgetPCNExpense;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.FinancialBudgetPCNTotals;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.PcnExpensePrimaryTargetPopulation;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.PcnExpenseStrategy;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;

public class PcdPcnBudgetApiResponseProcessor extends BaseApiResponseProcessor{

    @Override
	@SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		ObjectMapper mapper = new ObjectMapper();

        List<Root> pcnBudgetModels = mapper.readValue(payload, new TypeReference<List<Root>>() {
        });

		List<FinancialBudgetPCN> parsedPcnBudget = parsePcnBudgetRequest(pcnBudgetModels);
		
		validateRecordCount(pcnBudgetModels, parsedPcnBudget);
		
		List<IModel> iModels = (List<IModel>) (List<?>) parsedPcnBudget;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_PCN_BUDGET_DIR, isHeaderAdded);

		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setFiles(filesGenerated);
		exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }
    
    private List<FinancialBudgetPCN> parsePcnBudgetRequest(List<Root> pcnBudgetModels){
        List<FinancialBudgetPCN> financialBudgetPCN = new ArrayList<>();
		for (Root root : pcnBudgetModels){
			List<FinancialBudgetPCNExpense> budgetPCNExpenses = new ArrayList<>();
			List<FinancialBudgetPCNTotals> budgetPCNTotals = new ArrayList<>();
			
			String submissionId = root.getForm().getSubmissionId();

			/* mapping financialBudgetPCN */
			FinancialBudgetPCN budgetPCN = new FinancialBudgetPCN();
			budgetPCN.setSubmissionId(root.getForm().getSubmissionId());
			budgetPCN.setCreatedAt(root.getForm().getCreatedAt());
			budgetPCN.setLateEntry(root.getLateEntry());
			budgetPCN.setSubmitterFullName(root.getForm().getFullName());
			budgetPCN.setSubmitterUserName(root.getForm().getUsername());
			budgetPCN.setSubmitterEmail(root.getForm().getEmail());
			budgetPCN.setSubmissionStatus(root.getForm().getStatus());
			budgetPCN.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
			budgetPCN.setSubmissionFormName(root.getForm().getFormName());
			budgetPCN.setHealthAuthority(root.getHealthAuthority());
			budgetPCN.setCommunityName(root.getCommunityName());
			budgetPCN.setFiscalYear(root.getFiscalYear());
			
			Totals totals = new Totals(submissionId);

			/** Mapping Expenses */
			for(RootPcnBudgetItem budgetItem : root.getPcnBudget()){
				List<PcnExpenseStrategy> expenseStrategies = new ArrayList<>();
				FinancialBudgetPCNExpense budgetPCNExpense = new FinancialBudgetPCNExpense();
				budgetPCNExpense.setSubmissionId(root.getForm().getSubmissionId());
				budgetPCNExpense.setExpenseId(UUID.randomUUID().toString());
				budgetPCNExpense.setExpenseCategory(budgetItem.getExpenseCategory());
				budgetPCNExpense.setExpenseSubCategory(budgetItem.getExpenseSubCategory());
				budgetPCNExpense.setExpenseItem(budgetItem.getExpenseItem());
				budgetPCNExpense.setExpenseItemSubType(budgetItem.getExpenseItemSubType());
				budgetPCNExpense.setTotalBudgetAllocation(budgetItem.getTotalBudgetAllocation());
				budgetPCNExpense.setAnnualBudget(budgetItem.getAnnualBudget());
				budgetPCNExpense.setFtesInclRelief(budgetItem.getFtesInclRelief());
				budgetPCNExpense.setApproved4YearsFtes(budgetItem.getApproved4YearFtEs());
				budgetPCNExpense.setFiscalYearAllocation(budgetItem.getFiscalYearAllocation());
				
				populateTotals(totals, budgetItem);

				/* mapping strategies */
				if(budgetItem.getAdditionalSchedule1Info() != null && !budgetItem.getAdditionalSchedule1Info().isEmpty()){
					for(RootAdditionalSchedule1Info additionalInfo : budgetItem.getAdditionalSchedule1Info()){
						if(!additionalInfo.getStrategyTitle().isEmpty()){
							List<PcnExpensePrimaryTargetPopulation> expensePrimaryTargetPopulations = new ArrayList<>();
							PcnExpenseStrategy pcnExpenseStrategy = new PcnExpenseStrategy();
							pcnExpenseStrategy.setExpenseId(budgetPCNExpense.getExpenseId());
							pcnExpenseStrategy.setStrategyId(UUID.randomUUID().toString());
							pcnExpenseStrategy.setStrategyTitle(additionalInfo.getStrategyTitle());
							/* mapping targeted population */
							if(additionalInfo.getPrimaryTargetPopulation() != null && 
							!additionalInfo.getPrimaryTargetPopulation().isEmpty()){
								for(String targetedPop : additionalInfo.getPrimaryTargetPopulation()){
									PcnExpensePrimaryTargetPopulation expensePrimaryTargetPopulation = new PcnExpensePrimaryTargetPopulation();
									expensePrimaryTargetPopulation.setStrategyId(pcnExpenseStrategy.getStrategyId());
									expensePrimaryTargetPopulation.setTargetPopulation(targetedPop);

									expensePrimaryTargetPopulations.add(expensePrimaryTargetPopulation);
								}
							}
							pcnExpenseStrategy.setExpensePrimaryTargetPopulations(expensePrimaryTargetPopulations);
							expenseStrategies.add(pcnExpenseStrategy);
						}
					}
				}
				budgetPCNExpense.setExpenseStrategies(expenseStrategies);
				budgetPCNExpenses.add(budgetPCNExpense);
			}
            // Finalize the totals
			budgetPCNTotals.add(convertTotals(totals));  
            
			budgetPCN.setBudgetPCNTotals(budgetPCNTotals);
			budgetPCN.setBudgetPCNExpenses(budgetPCNExpenses);
			financialBudgetPCN.add(budgetPCN);
		}

        return financialBudgetPCN;
    }
    
    /**
     * Rounds the totals and convert to String before outputting to CSV.
     * @param totals
     * @return Converted totals
     */
    private FinancialBudgetPCNTotals convertTotals(Totals totals) {
        FinancialBudgetPCNTotals pcnTotals = new FinancialBudgetPCNTotals();
        pcnTotals.setSubmissionId(totals.getSubmissionId());
        
        // Family Physicians
        pcnTotals.setPhysicianApprovedFtes(totals.getPhysicianApprovedFtes().toString());
        pcnTotals.setPhysicianFiscalYearFtes(totals.getPhysicianFiscalYearFtes().toString());
        pcnTotals.setPhysicianApprovedBudget(totals.getPhysicianApprovedBudget().toString());
        pcnTotals.setPhysicianBudgetAllocation(totals.getPhysicianBudgetAllocation().toString());
        
        // Health Authority
        pcnTotals.setClinicalApprovedFtes(totals.getClinicalApprovedFtes().toString());
        pcnTotals.setClinicalFiscalYearFtes(totals.getClinicalFiscalYearFtes().toString());
        pcnTotals.setClinicalApprovedBudget(totals.getClinicalApprovedBudget().toString());
        pcnTotals.setClinicalBudgetAllocation(totals.getClinicalBudgetAllocation().toString());
        pcnTotals.setOverheadApprovedBudget(totals.getOverheadApprovedBudget().toString());
        pcnTotals.setOverheadBudgetAllocation(totals.getOverheadBudgetAllocation().toString());
        pcnTotals.setOneTimeFundingBudgetAllocation(totals.getOneTimeFundingBudgetAllocation().toString());
        
        // Division of Family Practice
        pcnTotals.setDofpResourcesApprovedFtes(totals.getDofpResourcesApprovedFtes().toString());
        pcnTotals.setDofpResourcesFiscalYearFtes(totals.getDofpResourcesFiscalYearFtes().toString());
        pcnTotals.setDofpResourcesApprovedBudget(totals.getDofpResourcesApprovedBudget().toString());
        pcnTotals.setDofpResourcesAllocation(totals.getDofpResourcesAllocation().toString());
        pcnTotals.setOverheadDofpApprovedBudget(totals.getOverheadDofpApprovedBudget().toString());
        pcnTotals.setOverheadDofpBudgetAllocation(totals.getOverheadDofpBudgetAllocation().toString());
        pcnTotals.setOneTimeFundingDofpAllocation(totals.getOneTimeFundingDofpAllocation().toString());
        
        return pcnTotals;
    }
    
    
    private void populateTotals(Totals totals, RootPcnBudgetItem budget) {
        BigDecimal approvedFtes = parseBigDecimal(budget.getApproved4YearFtEs());
        BigDecimal ftesIncludingRelief = parseBigDecimal(budget.getFtesInclRelief());
        BigDecimal approvedBudget = parseBigDecimal(budget.getAnnualBudget());
        BigDecimal totalBudgetAllocation = parseBigDecimal(budget.getTotalBudgetAllocation());
        
        switch (budget.getExpenseCategory()) {
        case CATEGORY_FAMILY_PYHSICIANS:
            totals.setPhysicianApprovedFtes(totals.getPhysicianApprovedFtes().add(approvedFtes));
            totals.setPhysicianFiscalYearFtes(totals.getPhysicianFiscalYearFtes().add(ftesIncludingRelief));
            totals.setPhysicianApprovedBudget(totals.getPhysicianApprovedBudget().add(approvedBudget));
            totals.setPhysicianBudgetAllocation(totals.getPhysicianBudgetAllocation().add(totalBudgetAllocation));
            break;

        case CATEGORY_HEALTH_AUTHORITY:
            switch (budget.getExpenseSubCategory()) {
            case SUB_CATEGORY_HEALTH_CLINICAL:
                totals.setClinicalApprovedFtes(totals.getClinicalApprovedFtes().add(approvedFtes));
                totals.setClinicalFiscalYearFtes(totals.getClinicalFiscalYearFtes().add(ftesIncludingRelief));
                totals.setClinicalApprovedBudget(totals.getClinicalApprovedBudget().add(approvedBudget));
                totals.setClinicalBudgetAllocation(totals.getClinicalBudgetAllocation().add(totalBudgetAllocation));                
                break;
            case SUB_CATEGORY_OVERHEAD:
                totals.setOverheadApprovedBudget(totals.getOverheadApprovedBudget().add(approvedBudget));
                totals.setOverheadBudgetAllocation(totals.getOverheadBudgetAllocation().add(totalBudgetAllocation));
                break;
            case SUB_CATEGORY_ONE_TIME_FUNDING:
                totals.setOneTimeFundingBudgetAllocation(totals.getOneTimeFundingBudgetAllocation().add(totalBudgetAllocation));
                break;
            }
            break;
        case CATEGORY_DOFP:
            // Sub-Category totals
            switch (budget.getExpenseSubCategory()) {
            case SUB_CATEGORY_DOFP_RESOURCES:
                totals.setDofpResourcesApprovedFtes(totals.getDofpResourcesApprovedFtes().add(approvedFtes));
                totals.setDofpResourcesFiscalYearFtes(totals.getDofpResourcesFiscalYearFtes().add(ftesIncludingRelief));
                totals.setDofpResourcesApprovedBudget(totals.getDofpResourcesApprovedBudget().add(approvedBudget));
                totals.setDofpResourcesAllocation(totals.getDofpResourcesAllocation().add(totalBudgetAllocation));
                break;
            case SUB_CATEGORY_OVERHEAD:
                totals.setOverheadDofpApprovedBudget(totals.getOverheadDofpApprovedBudget().add(approvedBudget));
                totals.setOverheadDofpBudgetAllocation(totals.getOverheadDofpBudgetAllocation().add(totalBudgetAllocation));
                break;
            case SUB_CATEGORY_ONE_TIME_FUNDING:
                totals.setOneTimeFundingDofpAllocation(totals.getOneTimeFundingDofpAllocation().add(totalBudgetAllocation));
                break;
            }
            break;

        }
        

    }
    
    class Totals {
        private String submissionId;
        private BigDecimal physicianApprovedFtes = BigDecimal.ZERO;
        private BigDecimal physicianApprovedBudget = BigDecimal.ZERO;
        private BigDecimal physicianFiscalYearFtes = BigDecimal.ZERO;
        private BigDecimal physicianBudgetAllocation = BigDecimal.ZERO;
        private BigDecimal clinicalApprovedFtes = BigDecimal.ZERO;
        private BigDecimal clinicalApprovedBudget = BigDecimal.ZERO;
        private BigDecimal clinicalFiscalYearFtes = BigDecimal.ZERO;
        private BigDecimal clinicalBudgetAllocation = BigDecimal.ZERO;        
        private BigDecimal overheadApprovedBudget = BigDecimal.ZERO;
        private BigDecimal overheadBudgetAllocation = BigDecimal.ZERO;
        private BigDecimal oneTimeFundingBudgetAllocation = BigDecimal.ZERO;
        private BigDecimal dofpResourcesApprovedFtes = BigDecimal.ZERO;
        private BigDecimal dofpResourcesApprovedBudget = BigDecimal.ZERO;
        private BigDecimal dofpResourcesFiscalYearFtes = BigDecimal.ZERO;
        private BigDecimal dofpResourcesAllocation = BigDecimal.ZERO;
        private BigDecimal overheadDofpApprovedBudget = BigDecimal.ZERO;
        private BigDecimal overheadDofpBudgetAllocation = BigDecimal.ZERO;        
        private BigDecimal oneTimeFundingDofpAllocation = BigDecimal.ZERO;
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
        public BigDecimal getPhysicianApprovedFtes() {
            return physicianApprovedFtes;
        }
        public void setPhysicianApprovedFtes(BigDecimal physicianApprovedFtes) {
            this.physicianApprovedFtes = physicianApprovedFtes;
        }
        public BigDecimal getPhysicianApprovedBudget() {
            return physicianApprovedBudget;
        }
        public void setPhysicianApprovedBudget(BigDecimal physicianApprovedBudget) {
            this.physicianApprovedBudget = physicianApprovedBudget;
        }
        public BigDecimal getPhysicianFiscalYearFtes() {
            return physicianFiscalYearFtes;
        }
        public void setPhysicianFiscalYearFtes(BigDecimal physicianFiscalYearFtes) {
            this.physicianFiscalYearFtes = physicianFiscalYearFtes;
        }
        public BigDecimal getPhysicianBudgetAllocation() {
            return physicianBudgetAllocation;
        }
        public void setPhysicianBudgetAllocation(BigDecimal physicianBudgetAllocation) {
            this.physicianBudgetAllocation = physicianBudgetAllocation;
        }
        public BigDecimal getClinicalApprovedFtes() {
            return clinicalApprovedFtes;
        }
        public void setClinicalApprovedFtes(BigDecimal clinicalApprovedFtes) {
            this.clinicalApprovedFtes = clinicalApprovedFtes;
        }
        public BigDecimal getClinicalApprovedBudget() {
            return clinicalApprovedBudget;
        }
        public void setClinicalApprovedBudget(BigDecimal clinicalApprovedBudget) {
            this.clinicalApprovedBudget = clinicalApprovedBudget;
        }
        public BigDecimal getClinicalFiscalYearFtes() {
            return clinicalFiscalYearFtes;
        }
        public void setClinicalFiscalYearFtes(BigDecimal clinicalFiscalYearFtes) {
            this.clinicalFiscalYearFtes = clinicalFiscalYearFtes;
        }
        public BigDecimal getClinicalBudgetAllocation() {
            return clinicalBudgetAllocation;
        }
        public void setClinicalBudgetAllocation(BigDecimal clinicalBudgetAllocation) {
            this.clinicalBudgetAllocation = clinicalBudgetAllocation;
        }
        public BigDecimal getOverheadApprovedBudget() {
            return overheadApprovedBudget;
        }
        public void setOverheadApprovedBudget(BigDecimal overheadApprovedBudget) {
            this.overheadApprovedBudget = overheadApprovedBudget;
        }
        public BigDecimal getOverheadBudgetAllocation() {
            return overheadBudgetAllocation;
        }
        public void setOverheadBudgetAllocation(BigDecimal overheadBudgetAllocation) {
            this.overheadBudgetAllocation = overheadBudgetAllocation;
        }
        public BigDecimal getOneTimeFundingBudgetAllocation() {
            return oneTimeFundingBudgetAllocation;
        }
        public void setOneTimeFundingBudgetAllocation(BigDecimal oneTimeFundingBudgetAllocation) {
            this.oneTimeFundingBudgetAllocation = oneTimeFundingBudgetAllocation;
        }
        public BigDecimal getDofpResourcesApprovedFtes() {
            return dofpResourcesApprovedFtes;
        }
        public void setDofpResourcesApprovedFtes(BigDecimal dofpResourcesApprovedFtes) {
            this.dofpResourcesApprovedFtes = dofpResourcesApprovedFtes;
        }
        public BigDecimal getDofpResourcesApprovedBudget() {
            return dofpResourcesApprovedBudget;
        }
        public void setDofpResourcesApprovedBudget(BigDecimal dofpResourcesApprovedBudget) {
            this.dofpResourcesApprovedBudget = dofpResourcesApprovedBudget;
        }
        public BigDecimal getDofpResourcesFiscalYearFtes() {
            return dofpResourcesFiscalYearFtes;
        }
        public void setDofpResourcesFiscalYearFtes(BigDecimal dofpResourcesFiscalYearFtes) {
            this.dofpResourcesFiscalYearFtes = dofpResourcesFiscalYearFtes;
        }
        public BigDecimal getDofpResourcesAllocation() {
            return dofpResourcesAllocation;
        }
        public void setDofpResourcesAllocation(BigDecimal dofpResourcesAllocation) {
            this.dofpResourcesAllocation = dofpResourcesAllocation;
        }
        public BigDecimal getOverheadDofpApprovedBudget() {
            return overheadDofpApprovedBudget;
        }
        public void setOverheadDofpApprovedBudget(BigDecimal overheadDofpApprovedBudget) {
            this.overheadDofpApprovedBudget = overheadDofpApprovedBudget;
        }
        public BigDecimal getOverheadDofpBudgetAllocation() {
            return overheadDofpBudgetAllocation;
        }
        public void setOverheadDofpBudgetAllocation(BigDecimal overheadDofpBudgetAllocation) {
            this.overheadDofpBudgetAllocation = overheadDofpBudgetAllocation;
        }
        public BigDecimal getOneTimeFundingDofpAllocation() {
            return oneTimeFundingDofpAllocation;
        }
        public void setOneTimeFundingDofpAllocation(BigDecimal oneTimeFundingDofpAllocation) {
            this.oneTimeFundingDofpAllocation = oneTimeFundingDofpAllocation;
        }

    }
}
