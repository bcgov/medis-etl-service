package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json;

import ca.bc.gov.chefs.etl.core.json.Form;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
}
