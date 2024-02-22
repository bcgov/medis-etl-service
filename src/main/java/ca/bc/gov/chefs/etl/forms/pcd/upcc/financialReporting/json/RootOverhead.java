package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootOverhead {
    public RootTotals totals;
    public RootOverheadBudget budget;
    public List<RootFinancial> financials;
    public RootTotals getTotals() {
        return totals;
    }
    public void setTotals(RootTotals totals) {
        this.totals = totals;
    }
    public RootOverheadBudget getBudget() {
        return budget;
    }
    public void setBudget(RootOverheadBudget budget) {
        this.budget = budget;
    }
    public List<RootFinancial> getFinancials() {
        return financials;
    }
    public void setFinancials(List<RootFinancial> financials) {
        this.financials = financials;
    }
}
