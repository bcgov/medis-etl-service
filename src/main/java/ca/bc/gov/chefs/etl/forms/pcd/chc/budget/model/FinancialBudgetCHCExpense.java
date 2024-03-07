package ca.bc.gov.chefs.etl.forms.pcd.chc.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetCHCExpense implements IModel {

    private String submissionId;
    private String expenseId;
    private String expenseCategory;
    private String expenseSubCategory;
    private String expenseItem;
    private String expenseItemSubType;
    private String approvedBudget;
    private String approvedFtes;

    private List<CHCExpenseStrategy> strategies;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
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

    public String getExpenseItem() {
        return expenseItem;
    }

    public void setExpenseItem(String expenseItem) {
        this.expenseItem = expenseItem;
    }

    public String getExpenseItemSubType() {
        return expenseItemSubType;
    }

    public void setExpenseItemSubType(String expenseItemSubType) {
        this.expenseItemSubType = expenseItemSubType;
    }

    public String getApprovedBudget() {
        return approvedBudget;
    }

    public void setApprovedBudget(String approvedBudget) {
        this.approvedBudget = approvedBudget;
    }

    public String getApprovedFtes() {
        return approvedFtes;
    }

    public void setApprovedFtes(String approvedFtes) {
        this.approvedFtes = approvedFtes;
    }

    public List<CHCExpenseStrategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<CHCExpenseStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FINANCIAL_BUDGET_CHC_EXPENSE;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(submissionId);
        elements.add(expenseId);
        elements.add(expenseCategory);
        elements.add(expenseSubCategory);
        elements.add(expenseItem);
        elements.add(expenseItemSubType);
        elements.add(approvedBudget);
        elements.add(approvedFtes);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> iModels = new ArrayList<>();
        iModels.addAll(strategies);
        return iModels;
    }

}
