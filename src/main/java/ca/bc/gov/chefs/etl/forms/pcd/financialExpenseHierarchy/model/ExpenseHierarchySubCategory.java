package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class ExpenseHierarchySubCategory implements IModel{

    private String expenseCategoryId;
    private String expenseSubCategoryId;
    private String expenseSubCategory;

    public String getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(String expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public String getExpenseSubCategoryId() {
        return expenseSubCategoryId;
    }

    public void setExpenseSubCategoryId(String expenseSubCategoryId) {
        this.expenseSubCategoryId = expenseSubCategoryId;
    }

    public String getExpenseSubCategory() {
        return expenseSubCategory;
    }

    public void setExpenseSubCategory(String expenseSubCategory) {
        this.expenseSubCategory = expenseSubCategory;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.EXPENSE_HIERARCHY_SUB_CATEGORY;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(expenseCategoryId);
        elements.add(expenseSubCategoryId);
        elements.add(expenseSubCategory);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
