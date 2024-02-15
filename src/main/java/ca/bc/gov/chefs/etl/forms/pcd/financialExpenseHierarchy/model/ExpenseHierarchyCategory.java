package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class ExpenseHierarchyCategory implements IModel{

    private String submissionId;
    private String expenseCategoryId;
    private String initiativeType;
    private String typeOfCare;
    private String expenseCategory;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(String expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public String getInitiativeType() {
        return initiativeType;
    }

    public void setInitiativeType(String initiativeType) {
        this.initiativeType = initiativeType;
    }

    public String getTypeOfCare() {
        return typeOfCare;
    }

    public void setTypeOfCare(String typeOfCare) {
        this.typeOfCare = typeOfCare;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FINANCIAL_EXPENSE_CATEGORY;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(expenseCategoryId);
        elements.add(initiativeType);
        elements.add(typeOfCare);
        elements.add(expenseCategory);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
