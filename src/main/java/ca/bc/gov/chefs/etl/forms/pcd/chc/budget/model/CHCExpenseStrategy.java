package ca.bc.gov.chefs.etl.forms.pcd.chc.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class CHCExpenseStrategy implements IModel {
    private String expenseId;
    private String strategyId;
    private String strategyTitle;

    private List<CHCExpensePrimaryTargetPopulation> primaryTargetPopulations;

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getStrategyTitle() {
        return strategyTitle;
    }

    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle;
    }

    public List<CHCExpensePrimaryTargetPopulation> getPrimaryTargetPopulations() {
        return primaryTargetPopulations;
    }

    public void setPrimaryTargetPopulations(List<CHCExpensePrimaryTargetPopulation> primaryTargetPopulations) {
        this.primaryTargetPopulations = primaryTargetPopulations;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.CHC_EXPENSE_STRATEGY;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(expenseId);
        elements.add(strategyId);
        elements.add(strategyTitle);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> iModels = new ArrayList<>();
        iModels.addAll(primaryTargetPopulations);
        return iModels;
    }

}
