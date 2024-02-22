package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootClinical {
    public RootTotals totals;
    public RootTypeOfCare urgentCare;
    public RootTypeOfCare mixedStream;
    public RootTypeOfCare longitudinalCare;
}
