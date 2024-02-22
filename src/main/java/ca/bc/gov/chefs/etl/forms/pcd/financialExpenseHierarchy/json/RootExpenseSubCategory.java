package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootExpenseSubCategory {
    
    public String expenseSubCategory;
    public List<RootExpenseItem> expenseItems;
    
    public String getExpenseSubCategory() {
        return expenseSubCategory;
    }
    public void setExpenseSubCategory(String expenseSubCategory) {
        this.expenseSubCategory = expenseSubCategory;
    }
    public List<RootExpenseItem> getExpenseItems() {
        return expenseItems;
    }
    public void setExpenseItems(List<RootExpenseItem> expenseItems) {
        this.expenseItems = expenseItems;
    }

}
