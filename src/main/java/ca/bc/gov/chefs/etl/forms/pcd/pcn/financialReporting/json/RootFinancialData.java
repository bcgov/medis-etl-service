package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootFinancialData {
    public RootDofp dofp;
    public String notes;
    public RootTotals totals;
    public RootHealthAuthority healthAuthority;
    public RootChangeManagement changeManagement;
    public RootFamilyPhysicians familyPhysicians;
}
