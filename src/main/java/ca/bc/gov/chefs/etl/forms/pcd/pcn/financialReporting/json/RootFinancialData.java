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
    public RootDofp getDofp() {
        return dofp;
    }
    public void setDofp(RootDofp dofp) {
        this.dofp = dofp;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public RootTotals getTotals() {
        return totals;
    }
    public void setTotals(RootTotals totals) {
        this.totals = totals;
    }
    public RootHealthAuthority getHealthAuthority() {
        return healthAuthority;
    }
    public void setHealthAuthority(RootHealthAuthority healthAuthority) {
        this.healthAuthority = healthAuthority;
    }
    public RootChangeManagement getChangeManagement() {
        return changeManagement;
    }
    public void setChangeManagement(RootChangeManagement changeManagement) {
        this.changeManagement = changeManagement;
    }
    public RootFamilyPhysicians getFamilyPhysicians() {
        return familyPhysicians;
    }
    public void setFamilyPhysicians(RootFamilyPhysicians familyPhysicians) {
        this.familyPhysicians = familyPhysicians;
    }
}
