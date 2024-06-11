package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootExpenseSubCategoryUPCC {
    public String expenseSubCategory;
    public List<RootTypeOfCare> typesOfCare;

    public String getExpenseSubCategory() {
        return expenseSubCategory;
    }
    public void setExpenseSubCategory(String expenseSubCategory) {
        this.expenseSubCategory = expenseSubCategory;
    }
    public List<RootTypeOfCare> getTypesOfCare() {
        return typesOfCare;
    }
    public void setTypesOfCare(List<RootTypeOfCare> typesOfCare) {
        this.typesOfCare = typesOfCare;
    }
}
