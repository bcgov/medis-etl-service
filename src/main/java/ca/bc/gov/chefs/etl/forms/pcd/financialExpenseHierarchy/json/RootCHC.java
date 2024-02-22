package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootCHC {
    public String initiativeType;
    public List<RootExpenseCategory> expenseCategories;
    
    public String getInitiativeType() {
        return initiativeType;
    }
    public void setInitiativeType(String initiativeType) {
        this.initiativeType = initiativeType;
    }
    public List<RootExpenseCategory> getExpenseCategories() {
        return expenseCategories;
    }
    public void setExpenseCategories(List<RootExpenseCategory> expenseCategories) {
        this.expenseCategories = expenseCategories;
    }
}
