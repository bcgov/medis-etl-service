package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootPCN {
    public String pcnInitiativeType;
    public List<RootExpenseCategory> expenseCategories;
    
    public String getPcnInitiativeType() {
        return pcnInitiativeType;
    }
    public void setPcnInitiativeType(String pcnInitiativeType) {
        this.pcnInitiativeType = pcnInitiativeType;
    }
    public List<RootExpenseCategory> getExpenseCategories() {
        return expenseCategories;
    }
    public void setExpenseCategories(List<RootExpenseCategory> expenseCategories) {
        this.expenseCategories = expenseCategories;
    }
}
