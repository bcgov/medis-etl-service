package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootUPCC {
    public String initiativeType;
    public List<RootExpenseCategoryUPCC> expenseCategories;
    
    public String getInitiativeType() {
        return initiativeType;
    }
    public void setInitiativeType(String initiativeType) {
        this.initiativeType = initiativeType;
    }
    public List<RootExpenseCategoryUPCC> getExpenseCategories() {
        return expenseCategories;
    }
    public void setExpenseCategories(List<RootExpenseCategoryUPCC> expenseCategories) {
        this.expenseCategories = expenseCategories;
    }
}
