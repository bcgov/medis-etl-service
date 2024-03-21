package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.processor;

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
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.PcnBudgetPCNTotals;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.PcnExpensePrimaryTargetPopulation;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.PcnExpenseStrategy;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdPcnBudgetApiResponseProcessor extends BaseApiResponseProcessor{

    @Override
	@SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> pcnBudgetModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
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
		for(Root root : pcnBudgetModels){
			List<FinancialBudgetPCNExpense> budgetPCNExpenses = new ArrayList<>();
			List<PcnBudgetPCNTotals> budgetPCNTotals = new ArrayList<>();

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

			/*mapping totals */
			PcnBudgetPCNTotals pcnTotals = new PcnBudgetPCNTotals();
			pcnTotals.setSubmissionId(root.getForm().getSubmissionId());
			pcnTotals.setTotalApprovedFtes(root.getTotals().getTotalApprovedFtes());
			pcnTotals.setTotalApprovedBudget(root.getTotals().getTotalApprovedBudget());
			pcnTotals.setTotalFtesInclRelief(root.getTotals().getTotalFtesInclRelief());
			pcnTotals.setTotalTotalBudgetAllocation(root.getTotals().getTotalTotalBudgetAllocation());
			pcnTotals.setClinicalApprovedFtes(root.getTotals().getClinicalApprovedFtes());
			pcnTotals.setClinicalApprovedBudget(root.getTotals().getClinicalApprovedBudget());
			pcnTotals.setClinicalFiscalYearFtes(root.getTotals().getClinicalFiscalYearFtes());
			pcnTotals.setClinicalBudgetAllocation(root.getTotals().getClinicalBudgetAllocation());
			pcnTotals.setDofpApprovedFtes(root.getTotals().getDofpApprovedFtes());
			pcnTotals.setDofpApprovedBudget(root.getTotals().getDofpApprovedBudget());
			pcnTotals.setDofpFiscalYearFtes(root.getTotals().getDofpFiscalYearFtes());
			pcnTotals.setDofpBudgetAllocation(root.getTotals().getDofpBudgetAllocation());
			pcnTotals.setDofpResourcesApprovedFtes(root.getTotals().getDofpResourcesApprovedFtes());
			pcnTotals.setDofpResourcesApprovedBudget(root.getTotals().getDofpResourcesApprovedBudget());
			pcnTotals.setDofpResourcesFiscalYearFtes(root.getTotals().getDofpResourcesFiscalYearFtes());
			pcnTotals.setDofpResourcesAllocation(root.getTotals().getDofpResourcesAllocation());
			pcnTotals.setPhysicianApprovedFtes(root.getTotals().getPhysicianApprovedFtes());
			pcnTotals.setPhysicianApprovedBudget(root.getTotals().getPhysicianApprovedBudget());
			pcnTotals.setPhysicianFiscalYearFtes(root.getTotals().getPhysicianFiscalYearFtes());
			pcnTotals.setPhysicianBudgetAllocation(root.getTotals().getPhysicianBudgetAllocation());
			pcnTotals.setHealthAuthorityApprovedFtes(root.getTotals().getHealthAuthorityApprovedFtes());
			pcnTotals.setHealthAuthorityApprovedBudget(root.getTotals().getHealthAuthorityApprovedBudget());
			pcnTotals.setHealthAuthorityFiscalYearFtes(root.getTotals().getHealthAuthorityFiscalYearFtes());
			pcnTotals.setHealthAuthorityBudgetAllocation(root.getTotals().getHealthAuthorityBudgetAllocation());
			pcnTotals.setOverheadApprovedBudget(root.getTotals().getOverheadApprovedBudget());
			pcnTotals.setOverheadBudgetAllocation(root.getTotals().getOverheadBudgetAllocation());
			pcnTotals.setOverheadDofpApprovedBudget(root.getTotals().getOverheadDofpApprovedBudget());
			pcnTotals.setOverheadDofpBudgetAllocation(root.getTotals().getOverheadDofpAllocation());
			pcnTotals.setOneTimeFundingBudgetAllocation(root.getTotals().getOneTimeFundingBudgetAllocation());
			pcnTotals.setOneTimeFundingDofpAllocation(root.getTotals().getOneTimeFundingDofpAllocation());

			budgetPCNTotals.add(pcnTotals);

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
			budgetPCN.setBudgetPCNTotals(budgetPCNTotals);
			budgetPCN.setBudgetPCNExpenses(budgetPCNExpenses);
			financialBudgetPCN.add(budgetPCN);
		}

        return financialBudgetPCN;
    }
}
