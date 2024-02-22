package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootFinancialData {
    public RootTotals totals;
    public RootClinical clinical;

    public String additionalNotes;
    public String overheadDataLoaded;
}
