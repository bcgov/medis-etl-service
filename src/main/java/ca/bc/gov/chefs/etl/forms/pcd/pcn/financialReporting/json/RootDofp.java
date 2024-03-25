package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootDofp {
    public RootTotals totals;
    public RootFinancialSubCategory resource;
    public RootFinancialSubCategory oneTimeFunding;
    public RootOverhead overhead;
    public RootTotals getTotals() {
        return totals;
    }
    public void setTotals(RootTotals totals) {
        this.totals = totals;
    }
    public RootFinancialSubCategory getResource() {
        return resource;
    }
    public void setResource(RootFinancialSubCategory resource) {
        this.resource = resource;
    }
    public RootFinancialSubCategory getOneTimeFunding() {
        return oneTimeFunding;
    }
    public void setOneTimeFunding(RootFinancialSubCategory oneTimeFunding) {
        this.oneTimeFunding = oneTimeFunding;
    }
    public RootOverhead getOverhead() {
        return overhead;
    }
    public void setOverhead(RootOverhead overhead) {
        this.overhead = overhead;
    }
}
