package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootHealthAuthority {
    public RootTotals totals;
    public RootFinancialSubCategory clinical;
    public RootOverhead overhead;
    public RootFinancialSubCategory oneTimeFunding;
    public RootTotals getTotals() {
        return totals;
    }
    public void setTotals(RootTotals totals) {
        this.totals = totals;
    }
    public RootFinancialSubCategory getClinical() {
        return clinical;
    }
    public void setClinical(RootFinancialSubCategory clinical) {
        this.clinical = clinical;
    }
    public RootOverhead getOverhead() {
        return overhead;
    }
    public void setOverhead(RootOverhead overhead) {
        this.overhead = overhead;
    }
    public RootFinancialSubCategory getOneTimeFunding() {
        return oneTimeFunding;
    }
    public void setOneTimeFunding(RootFinancialSubCategory oneTimeFunding) {
        this.oneTimeFunding = oneTimeFunding;
    }
}
