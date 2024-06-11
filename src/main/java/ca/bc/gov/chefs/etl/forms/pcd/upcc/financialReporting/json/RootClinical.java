package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootClinical {
    public RootTotals totals;
    public RootTypeOfCare urgentCare;
    public RootTypeOfCare mixedStream;
    public RootTypeOfCare longitudinalCare;
    public RootTotals getTotals() {
        return totals;
    }
    public void setTotals(RootTotals totals) {
        this.totals = totals;
    }
    public RootTypeOfCare getUrgentCare() {
        return urgentCare;
    }
    public void setUrgentCare(RootTypeOfCare urgentCare) {
        this.urgentCare = urgentCare;
    }
    public RootTypeOfCare getMixedStream() {
        return mixedStream;
    }
    public void setMixedStream(RootTypeOfCare mixedStream) {
        this.mixedStream = mixedStream;
    }
    public RootTypeOfCare getLongitudinalCare() {
        return longitudinalCare;
    }
    public void setLongitudinalCare(RootTypeOfCare longitudinalCare) {
        this.longitudinalCare = longitudinalCare;
    }
}
