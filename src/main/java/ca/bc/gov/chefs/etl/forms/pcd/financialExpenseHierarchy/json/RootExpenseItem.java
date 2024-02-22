package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootExpenseItem {
    public String expenseItem;
    public String positionType;
    public String resourceCategory;
    public List<String> expenseItemSubTypes;
    
    public String getExpenseItem() {
        return expenseItem;
    }
    public void setExpenseItem(String expenseItem) {
        this.expenseItem = expenseItem;
    }
    public String getPositionType() {
        return positionType;
    }
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
    public String getResourceCategory() {
        return resourceCategory;
    }
    public void setResourceCategory(String resourceCategory) {
        this.resourceCategory = resourceCategory;
    }
    public List<String> getExpenseItemSubTypes() {
        return expenseItemSubTypes;
    }
    public void setExpenseItemSubTypes(List<String> expenseItemSubTypes) {
        this.expenseItemSubTypes = expenseItemSubTypes;
    }
}
