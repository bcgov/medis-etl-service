package ca.bc.gov.chefs.etl.forms.pcd.chc.budget.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.json.RootAdditionalSchedule1Info;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.json.RootChcBudget;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.model.CHCExpenseStrategy;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.model.CHCExpensePrimaryTargetPopulation;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.model.FinancialBudgetCHC;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.model.FinancialBudgetCHCExpense;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.model.FinancialBudgetCHCTotals;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdChcBudgetApiResponseProcessor extends BaseApiResponseProcessor {

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        payload = JsonUtil.roundDigitsNumber(payload);
        ObjectMapper mapper = new ObjectMapper();

        List<Root> chcBudgetModels = mapper.readValue(payload, new TypeReference<List<Root>>() {
        });

        List<FinancialBudgetCHC> parsedChcBudget = parseChcBudgetRequest(chcBudgetModels);

        validateRecordCount(chcBudgetModels, parsedChcBudget);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedChcBudget;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_CHC_BUDGET_DIR, isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<FinancialBudgetCHC> parseChcBudgetRequest(List<Root> chcBudgetPayloads) {
        List<FinancialBudgetCHC> parsedChcBudget = new ArrayList<>();
        for (Root root : chcBudgetPayloads) {
            FinancialBudgetCHC financialBudgetCHC = new FinancialBudgetCHC();
            List<FinancialBudgetCHCTotals> financialBudgetCHCTotals = new ArrayList<>();
            List<FinancialBudgetCHCExpense> financialBudgetCHCExpenses = new ArrayList<>();

            // Use ModelMapper to handle the basic conversion
            ModelMapper modelMapper = new ModelMapper();

            /** mapping FinancialBudgetCHC */
            financialBudgetCHC.setSubmissionId(root.getForm().getSubmissionId());
            financialBudgetCHC.setCreatedAt(CSVUtil.getFormattedDate(root.getForm().getCreatedAt()));
            financialBudgetCHC.setLateEntry(root.getLateEntry());
            financialBudgetCHC.setSubmitterFullName(root.getForm().getFullName());
            financialBudgetCHC.setSubmitterUserName(root.getForm().getUsername());
            financialBudgetCHC.setSubmitterEmail(root.getForm().getEmail());
            financialBudgetCHC.setSubmissionStatus(root.getForm().getStatus());
            financialBudgetCHC.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
            financialBudgetCHC.setSubmissionFormName(root.getForm().getFormName());
            financialBudgetCHC.setHealthAuthority(root.getHealthAuthority());
            financialBudgetCHC.setCommunityName(root.getCommunityName());
            financialBudgetCHC.setFiscalYear(root.getFiscalYear());
            financialBudgetCHC.setChcName(root.getChcName());

            /** mapping FinancialBudgetCHCTotals */
            FinancialBudgetCHCTotals submissionTotals = modelMapper.map(root.getTotals(), FinancialBudgetCHCTotals.class);
            submissionTotals.setSubmissionId(root.getForm().getSubmissionId());

            financialBudgetCHCTotals.add(submissionTotals);

            /** mapping FinancialBudgetCHCExpense */
            for (RootChcBudget budget : root.getChcBudget()) {
                FinancialBudgetCHCExpense newChcExpense = modelMapper.map(budget, FinancialBudgetCHCExpense.class);                
                newChcExpense.setSubmissionId(root.getForm().getSubmissionId());
                newChcExpense.setExpenseId(UUID.randomUUID().toString());

                financialBudgetCHCExpenses.add(newChcExpense);
                
                List<CHCExpenseStrategy> chcStrategies = new ArrayList<>();
                /** mapping CHCExpenseStrategy */
                for (RootAdditionalSchedule1Info additionalSchedule: budget.getAdditionalSchedule1Info()) {
                    if (StringUtils.isBlank(additionalSchedule.getStrategyTitle())) {
                        continue;
                    }
                    CHCExpenseStrategy chcSchedule = new CHCExpenseStrategy();
                    chcSchedule.setExpenseId(newChcExpense.getExpenseId());
                    chcSchedule.setStrategyId(UUID.randomUUID().toString());
                    chcSchedule.setStrategyTitle(additionalSchedule.getStrategyTitle());
                    
                    chcStrategies.add(chcSchedule);

                    /** mapping CHCExpensePrimaryTargetPopulation */
                    List<CHCExpensePrimaryTargetPopulation> chcPrimaryTargets = new ArrayList<>();
                    for (String primaryTarget: additionalSchedule.getPrimaryTargetPopulation()) {
                        CHCExpensePrimaryTargetPopulation chcPrimaryTarget = new CHCExpensePrimaryTargetPopulation();
                        chcPrimaryTarget.setStrategyId(chcSchedule.getStrategyId());
                        chcPrimaryTarget.setTargetPopulation(primaryTarget);
                        
                        chcPrimaryTargets.add(chcPrimaryTarget);                        
                    }
                    chcSchedule.setPrimaryTargetPopulations(chcPrimaryTargets);
                }
                newChcExpense.setStrategies(chcStrategies);

            }
            financialBudgetCHC.setFinancialBudgetCHCTotals(financialBudgetCHCTotals);
            financialBudgetCHC.setFinancialBudgetCHCExpenses(financialBudgetCHCExpenses);
            parsedChcBudget.add(financialBudgetCHC);
        }

        return parsedChcBudget;
    }
}
