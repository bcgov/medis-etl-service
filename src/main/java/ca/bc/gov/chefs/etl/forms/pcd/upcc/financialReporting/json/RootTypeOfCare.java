package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootTypeOfCare {
    public RootTotals subtotals;
    public List<RootFinancial> financials;
}
