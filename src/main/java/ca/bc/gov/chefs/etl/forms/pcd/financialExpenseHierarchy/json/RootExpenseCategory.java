package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootExpenseCategory {
    public String expenseCategory;
    public List<RootExpenseSubCategory> expenseSubCategories;
    
    public String getExpenseCategory() {
        return expenseCategory;
    }
    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }
    public List<RootExpenseSubCategory> getExpenseSubCategories() {
        return expenseSubCategories;
    }
    public void setExpenseSubCategories(List<RootExpenseSubCategory> expenseSubCategories) {
        this.expenseSubCategories = expenseSubCategories;
    }
}
