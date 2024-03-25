package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootFinancialSubCategory {
    public RootTotals subtotals;
    public List<RootFinancial> financials;
    public RootTotals getSubtotals() {
        return subtotals;
    }
    public void setSubtotals(RootTotals subtotals) {
        this.subtotals = subtotals;
    }
    public List<RootFinancial> getFinancials() {
        return financials;
    }
    public void setFinancials(List<RootFinancial> financials) {
        this.financials = financials;
    }
}
