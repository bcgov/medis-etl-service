package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootOneTimeFunding {
    public RootTotals totals;
    public List<RootFinancial> financials;
    public RootTotals getTotals() {
        return totals;
    }
    public void setTotals(RootTotals totals) {
        this.totals = totals;
    }
    public List<RootFinancial> getFinancials() {
        return financials;
    }
    public void setFinancials(List<RootFinancial> financials) {
        this.financials = financials;
    }
}
