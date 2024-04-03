package ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootFinancialData {
    public RootTotals totals;
    public RootClinical clinical;
    public RootOverhead overhead;
    public RootOneTimeFunding oneTimeFunding;
    public String additionalNotes;
    public RootOtherResources otherResourceAndItem;

    public RootTotals getTotals() {
        return totals;
    }

    public void setTotals(RootTotals totals) {
        this.totals = totals;
    }

    public RootClinical getClinical() {
        return clinical;
    }

    public void setClinical(RootClinical clinical) {
        this.clinical = clinical;
    }

    public RootOverhead getOverhead() {
        return overhead;
    }

    public void setOverhead(RootOverhead overhead) {
        this.overhead = overhead;
    }

    public RootOneTimeFunding getOneTimeFunding() {
        return oneTimeFunding;
    }

    public void setOneTimeFunding(RootOneTimeFunding oneTimeFunding) {
        this.oneTimeFunding = oneTimeFunding;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public RootOtherResources getOtherResourceAndItem() {
        return otherResourceAndItem;
    }

    public void setOtherResourceAndItem(RootOtherResources otherResourceAndItem) {
        this.otherResourceAndItem = otherResourceAndItem;
    }

}
