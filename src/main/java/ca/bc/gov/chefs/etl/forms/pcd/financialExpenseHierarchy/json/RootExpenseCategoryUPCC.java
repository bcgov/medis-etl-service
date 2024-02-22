package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootExpenseCategoryUPCC {
    public String expenseCategory;
    public List<RootExpenseSubCategoryUPCC> expenseSubCategories;
    
    public String getExpenseCategory() {
        return expenseCategory;
    }
    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }
    public List<RootExpenseSubCategoryUPCC> getExpenseSubCategories() {
        return expenseSubCategories;
    }
    public void setExpenseSubCategories(List<RootExpenseSubCategoryUPCC> expenseSubCategories) {
        this.expenseSubCategories = expenseSubCategories;
    }
}
