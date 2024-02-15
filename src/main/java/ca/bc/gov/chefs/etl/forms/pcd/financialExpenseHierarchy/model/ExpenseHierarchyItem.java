package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class ExpenseHierarchyItem implements IModel{

    private String expenseSubCategoryId;
    private String expenseItemId;
    private String expenseItem;
    private String resourceCategory;
    private String positionType;
    private String typeOfCare;

    public String getExpenseSubCategoryId() {
        return expenseSubCategoryId;
    }

    public void setExpenseSubCategoryId(String expenseSubCategoryId) {
        this.expenseSubCategoryId = expenseSubCategoryId;
    }

    public String getExpenseItemId() {
        return expenseItemId;
    }

    public void setExpenseItemId(String expenseItemId) {
        this.expenseItemId = expenseItemId;
    }

    public String getExpenseItem() {
        return expenseItem;
    }

    public void setExpenseItem(String expenseItem) {
        this.expenseItem = expenseItem;
    }

    public String getResourceCategory() {
        return resourceCategory;
    }

    public void setResourceCategory(String resourceCategory) {
        this.resourceCategory = resourceCategory;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getTypeOfCare() {
        return typeOfCare;
    }

    public void setTypeOfCare(String typeOfCare) {
        this.typeOfCare = typeOfCare;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FINANCIAL_EXPENSE_ITEM;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(expenseSubCategoryId);
        elements.add(expenseItemId);
        elements.add(expenseItem);
        elements.add(resourceCategory);
        elements.add(positionType);
        elements.add(typeOfCare);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
