package ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.processor;

import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_CLINICAL;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_ONE_TIME_FUNDING;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_OTHER_RESOURCES;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_OVERHEAD;
import static ca.bc.gov.chefs.etl.util.CSVUtil.parseBigDecimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.json.RootNppccBudget;
import ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.model.FinancialBudgetNPPCC;
import ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.model.FinancialBudgetNPPCCExpense;
import ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.model.FinancialBudgetNPPCCTotals;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdNppccBudgetApiResponseProcessor extends BaseApiResponseProcessor {

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        payload = JsonUtil.fixUnicodeCharacters(payload);
        ObjectMapper mapper = new ObjectMapper();

		List<Root> nppccBudgetModels = mapper.readValue(payload, new TypeReference<List<Root>>() {
		});

        List<FinancialBudgetNPPCC> parsedNppccBudget = parseNppccBudgetRequest(nppccBudgetModels);

        validateRecordCount(nppccBudgetModels, parsedNppccBudget);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedNppccBudget;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_NPPCC_BUDGET_DIR, isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<FinancialBudgetNPPCC> parseNppccBudgetRequest(List<Root> nppccBudgetPayloads) {
        List<FinancialBudgetNPPCC> parsedNppccBudget = new ArrayList<>();
        for (Root root : nppccBudgetPayloads) {
            FinancialBudgetNPPCC financialBudgetNPPCC = new FinancialBudgetNPPCC();
            List<FinancialBudgetNPPCCTotals> financialBudgetNPPCCTotals = new ArrayList<>();
            List<FinancialBudgetNPPCCExpense> financialBudgetNPPCCExpenses = new ArrayList<>();
            
            String submissionId = root.getForm().getSubmissionId();

            // Use ModelMapper to handle the basic conversion
            ModelMapper modelMapper = new ModelMapper();

            /** mapping FinancialBudgetNPPCC */
            financialBudgetNPPCC.setSubmissionId(submissionId);
            financialBudgetNPPCC.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
            financialBudgetNPPCC.setLateEntry(root.getLateEntry());
            financialBudgetNPPCC.setSubmitterFullName(root.getForm().getFullName());
            financialBudgetNPPCC.setSubmitterUserName(root.getForm().getUsername());
            financialBudgetNPPCC.setSubmitterEmail(root.getForm().getEmail());
            financialBudgetNPPCC.setSubmissionStatus(root.getForm().getStatus());
            financialBudgetNPPCC.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
            financialBudgetNPPCC.setSubmissionFormName(root.getForm().getFormName());
            financialBudgetNPPCC.setHealthAuthority(root.getHealthAuthority());
            financialBudgetNPPCC.setCommunityName(root.getCommunityName());
            financialBudgetNPPCC.setFiscalYear(root.getFiscalYear());
            financialBudgetNPPCC.setNppccName(root.getNppccName());
            
            FinancialBudgetNPPCCTotals totals = new FinancialBudgetNPPCCTotals(submissionId);

            /** mapping FinancialBudgetNPPCCExpense */
            for (RootNppccBudget budget : root.getNppccBudget()) {
                FinancialBudgetNPPCCExpense newNppccExpense = modelMapper.map(budget, FinancialBudgetNPPCCExpense.class);                
                newNppccExpense.setSubmissionId(root.getForm().getSubmissionId());
                newNppccExpense.setExpenseId(UUID.randomUUID().toString());

                financialBudgetNPPCCExpenses.add(newNppccExpense);
                
                populateTotals(totals, budget);

            }
            
            // Finalize the totals
            financialBudgetNPPCCTotals.add(totals);     
            
            financialBudgetNPPCC.setFinancialBudgetNPPCCTotals(financialBudgetNPPCCTotals);
            financialBudgetNPPCC.setFinancialBudgetNPPCCExpenses(financialBudgetNPPCCExpenses);
            parsedNppccBudget.add(financialBudgetNPPCC);
        }

        return parsedNppccBudget;
    }
    
    private void populateTotals(FinancialBudgetNPPCCTotals totals, RootNppccBudget budget) {
        BigDecimal approvedBudget = parseBigDecimal(budget.getApprovedBudget());
        BigDecimal approvedFtes = parseBigDecimal(budget.getApprovedFtes());
        
        // Sub-Category totals
        switch (budget.getExpenseSubCategory()) {
        case SUB_CATEGORY_CLINICAL:
            totals.setClinicalApprovedBudget(totals.getClinicalApprovedBudget().add(approvedBudget));
            totals.setClinicalApprovedFtes(totals.getClinicalApprovedFtes().add(approvedFtes));
            break;
        case SUB_CATEGORY_ONE_TIME_FUNDING:
            totals.setOneTimeFundingApprovedBudget(totals.getOneTimeFundingApprovedBudget().add(approvedBudget));
            break;
        case SUB_CATEGORY_OTHER_RESOURCES:
            totals.setOtherResourcesApprovedBudget(totals.getOtherResourcesApprovedBudget().add(approvedBudget));
            totals.setOtherResourcesApprovedFtes(totals.getOtherResourcesApprovedFtes().add(approvedFtes));
            break;
        case SUB_CATEGORY_OVERHEAD:
            totals.setOverheadApprovedBudget(totals.getOverheadApprovedBudget().add(approvedBudget));
            break;
        }
    }

}
