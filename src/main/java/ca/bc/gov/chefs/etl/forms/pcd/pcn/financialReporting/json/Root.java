package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json;

import ca.bc.gov.chefs.etl.core.json.Form;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public String lateEntry;
    public String fiscalYear;
    public String communityName;
    public RootFinancialData financialData;
    public String periodReported;
    public String healthAuthority;
    public String reasonForExceptionInPeriodReported;
}
