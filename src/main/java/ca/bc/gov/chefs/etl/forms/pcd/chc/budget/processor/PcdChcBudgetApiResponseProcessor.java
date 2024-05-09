package ca.bc.gov.chefs.etl.forms.pcd.chc.budget.processor;

import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_CLINICAL;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_ONE_TIME_FUNDING;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_OTHER_RESOURCES;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_OVERHEAD;
import static ca.bc.gov.chefs.etl.util.CSVUtil.formatBigDecimal;
import static ca.bc.gov.chefs.etl.util.CSVUtil.parseBigDecimal;

import java.math.BigDecimal;
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
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.model.CHCExpensePrimaryTargetPopulation;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.model.CHCExpenseStrategy;
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
            
            String submissionId = root.getForm().getSubmissionId();

            // Use ModelMapper to handle the basic conversion
            ModelMapper modelMapper = new ModelMapper();

            /** mapping FinancialBudgetCHC */
            financialBudgetCHC.setSubmissionId(submissionId);
            financialBudgetCHC.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
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
            
            Totals totals = new Totals(submissionId);

            /** mapping FinancialBudgetCHCExpense */
            for (RootChcBudget budget : root.getChcBudget()) {
                FinancialBudgetCHCExpense newChcExpense = modelMapper.map(budget, FinancialBudgetCHCExpense.class);                
                newChcExpense.setSubmissionId(root.getForm().getSubmissionId());
                newChcExpense.setExpenseId(UUID.randomUUID().toString());

                financialBudgetCHCExpenses.add(newChcExpense);
                
                populateTotals(totals, budget);
                
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
            
            // Finalize the totals
            financialBudgetCHCTotals.add(convertTotals(totals));     
            
            financialBudgetCHC.setFinancialBudgetCHCTotals(financialBudgetCHCTotals);
            financialBudgetCHC.setFinancialBudgetCHCExpenses(financialBudgetCHCExpenses);
            parsedChcBudget.add(financialBudgetCHC);
        }

        return parsedChcBudget;
    }
    
    private void populateTotals(Totals totals, RootChcBudget budget) {
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
    
    /**
     * Rounds the totals and convert to String before outputting to CSV.
     * @param totals
     * @return Converted totals
     */
    private FinancialBudgetCHCTotals convertTotals(Totals totals) {
        FinancialBudgetCHCTotals chcTotals = new FinancialBudgetCHCTotals();
        chcTotals.setSubmissionId(totals.getSubmissionId());
        
        chcTotals.setClinicalApprovedBudget(formatBigDecimal(totals.getClinicalApprovedBudget()));
        chcTotals.setClinicalApprovedFtes(formatBigDecimal(totals.getClinicalApprovedFtes()));
        
        chcTotals.setOneTimeFundingApprovedBudget(formatBigDecimal(totals.getOneTimeFundingApprovedBudget()));        
        chcTotals.setOtherResourcesApprovedBudget(formatBigDecimal(totals.getOtherResourcesApprovedBudget()));
        chcTotals.setOtherResourcesApprovedFtes(formatBigDecimal(totals.getOtherResourcesApprovedFtes()));        
        chcTotals.setOverheadApprovedBudget(formatBigDecimal(totals.getOverheadApprovedBudget()));
       
        return chcTotals;
    }
    
    class Totals {
        private String submissionId;
        private BigDecimal totalApprovedBudget = BigDecimal.ZERO;
        private BigDecimal totalApprovedFtes = BigDecimal.ZERO;
        private BigDecimal clinicalApprovedBudget = BigDecimal.ZERO;
        private BigDecimal clinicalApprovedFtes = BigDecimal.ZERO;
        private BigDecimal overheadApprovedBudget = BigDecimal.ZERO;
        private BigDecimal otherResourcesApprovedFtes = BigDecimal.ZERO;
        private BigDecimal otherResourcesApprovedBudget = BigDecimal.ZERO;
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
        public BigDecimal getOtherResourcesApprovedFtes() {
            return otherResourcesApprovedFtes;
        }
        public void setOtherResourcesApprovedFtes(BigDecimal otherResourcesApprovedFtes) {
            this.otherResourcesApprovedFtes = otherResourcesApprovedFtes;
        }
        public BigDecimal getOtherResourcesApprovedBudget() {
            return otherResourcesApprovedBudget;
        }
        public void setOtherResourcesApprovedBudget(BigDecimal otherResourcesApprovedBudget) {
            this.otherResourcesApprovedBudget = otherResourcesApprovedBudget;
        }
        
        
    }
}
