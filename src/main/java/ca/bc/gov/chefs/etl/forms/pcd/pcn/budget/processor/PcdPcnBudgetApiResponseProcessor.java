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
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.json.RootPcnBudgetItem;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.FinancialBudgetPCN;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.FinancialBudgetPCNExpense;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model.FinancialBudgetPCNTotals;
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
			
			FinancialBudgetPCNTotals totals = new FinancialBudgetPCNTotals(submissionId);

			/** Mapping Expenses */
			for(RootPcnBudgetItem budgetItem : root.getPcnBudget()){
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
				budgetPCNExpense.setApprovedAttachmentTarget(budgetItem.getApprovedAttachmentTarget());
				
				populateTotals(totals, budgetItem);

				budgetPCNExpenses.add(budgetPCNExpense);
			}
			budgetPCNTotals.add(totals);  
            
			budgetPCN.setBudgetPCNTotals(budgetPCNTotals);
			budgetPCN.setBudgetPCNExpenses(budgetPCNExpenses);
			financialBudgetPCN.add(budgetPCN);
		}

        return financialBudgetPCN;
    }
    
    private void populateTotals(FinancialBudgetPCNTotals totals, RootPcnBudgetItem budget) {
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
    
}
