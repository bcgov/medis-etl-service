package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetUPCCExpense implements IModel{


    private String submissionId;
    private String expenseCategory;
    private String expenseSubCategory;
    private String typeOfCare;
    private String expenseItem;
    private String expenseItemSubType;
    private String approvedBudget;
    private String approvedFtesInclRelief;
    
    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
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

    public String getTypeOfCare() {
        return typeOfCare;
    }

    public void setTypeOfCare(String typeOfCare) {
        this.typeOfCare = typeOfCare;
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

    public String getApprovedFtesInclRelief() {
        return approvedFtesInclRelief;
    }

    public void setApprovedFtesInclRelief(String approvedFtesInclRelief) {
        this.approvedFtesInclRelief = approvedFtesInclRelief;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FINANCIAL_BUDGET_UPCC_EXPENSE;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(submissionId);
        elements.add(expenseCategory);
        elements.add(expenseSubCategory);
        elements.add(typeOfCare);
        elements.add(expenseItem);
        elements.add(expenseItemSubType);
        elements.add(approvedBudget);
        elements.add(approvedFtesInclRelief);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
