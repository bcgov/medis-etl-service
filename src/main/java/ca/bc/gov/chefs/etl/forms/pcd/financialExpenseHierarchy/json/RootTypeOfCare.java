package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootTypeOfCare {
    public String typeOfCare;
    public List<RootExpenseItem> expenseItems;
    
    public String getTypeOfCare() {
        return typeOfCare;
    }
    public void setTypeOfCare(String typeOfCare) {
        this.typeOfCare = typeOfCare;
    }
    public List<RootExpenseItem> getExpenseItems() {
        return expenseItems;
    }
    public void setExpenseItems(List<RootExpenseItem> expenseItems) {
        this.expenseItems = expenseItems;
    }
}
