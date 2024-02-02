package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.eclipse.jetty.server.RequestLog.Collection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json.RootUpccBudget;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model.FinancialBudgetUPCC;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model.FinancialBudgetUPCCExpense;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model.UpccExpensePrimaryTargetPopulation;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model.UpccExpenseStrategyTitle;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdUpccBudgetApiResponseProcessor implements Processor {
    
	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> UpccBudgetModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<FinancialBudgetUPCC> parsedUpccBudget = parseUpccBudgetRequest(UpccBudgetModels);
		List<IModel> iModels = (List<IModel>) (List<?>) parsedUpccBudget;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_UPCC_BUDGET_DIR, isHeaderAdded);

		//  SuccessResponse successResponse = new SuccessResponse();
		//  successResponse.setFiles(filesGenerated);
		//  exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}

    private List<FinancialBudgetUPCC> parseUpccBudgetRequest(List<Root> UpccBudgetPayloads) {
        List<FinancialBudgetUPCC> parsedUpccBudget = new ArrayList<>();
        for (Root root : UpccBudgetPayloads) {
            FinancialBudgetUPCC financialBudgetUPCC = new FinancialBudgetUPCC();
            List<FinancialBudgetUPCCExpense> financialBudgetUPCCExpenses = new ArrayList<>();
            List<UpccExpensePrimaryTargetPopulation> upccExpensePrimaryTargetPopulation = new ArrayList<>();
            List<UpccExpenseStrategyTitle> upccExpenseStrategyTitle = new ArrayList<>();

            /** mapping  financialBudgetUPCC */
            financialBudgetUPCC.setSubmissionId(root.getForm().getSubmissionId());
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

            /** mapping financialBudgetUPCCExpense */
            for(RootUpccBudget budget : root.getUpccBudget()){
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

                /** mapping UpccExpensePrimaryTargetPopulation */
                if( budget.getPrimaryTargetPopulation() != null && !budget.getPrimaryTargetPopulation().isEmpty()){
                    for(String targetPopulation : budget.getPrimaryTargetPopulation()){
                        UpccExpensePrimaryTargetPopulation newTargetPopulation = new UpccExpensePrimaryTargetPopulation();
                        newTargetPopulation.setExpenseId(newUpccExpense.getExpenseId());
                        newTargetPopulation.setTargetPopulation(targetPopulation);
    
                        upccExpensePrimaryTargetPopulation.add(newTargetPopulation);
                    }
                }

                /** mapping UpccExpenseStrategyTitle */
                if(budget.getStrategyTitle() != null && !budget.getStrategyTitle().isEmpty()){
                    for(String strategyTitle : budget.getStrategyTitle()){
                        UpccExpenseStrategyTitle newExpenseStrategyTitle = new UpccExpenseStrategyTitle();
                        newExpenseStrategyTitle.setExpenseId(newUpccExpense.getExpenseId());
                        newExpenseStrategyTitle.setStrategyTitleId(UUID.randomUUID().toString());
                        newExpenseStrategyTitle.setStrategyTitle(strategyTitle);
    
                        upccExpenseStrategyTitle.add(newExpenseStrategyTitle);
                    }
                }
                
                financialBudgetUPCCExpenses.add(newUpccExpense);
            }

            financialBudgetUPCC.setFinancialBudgetUPCCExpenses(financialBudgetUPCCExpenses);
            financialBudgetUPCC.setUpccExpensePrimaryTargetPopulation(upccExpensePrimaryTargetPopulation);
            financialBudgetUPCC.setUpccExpenseStrategyTitles(upccExpenseStrategyTitle);
            parsedUpccBudget.add(financialBudgetUPCC);
        }

        return parsedUpccBudget;
    }
}
