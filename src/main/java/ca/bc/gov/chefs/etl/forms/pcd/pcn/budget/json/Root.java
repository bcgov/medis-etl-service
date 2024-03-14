package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public RootTotals totals;
    public String lateEntry;
    public String fiscalYear;
    public String communityName;
    public String healthAuthority;
    public List<RootPcnBudgetItem> pcnBudget;
    
    public Form getForm() {
        return form;
    }
    public void setForm(Form form) {
        this.form = form;
    }
    public RootTotals getTotals() {
        return totals;
    }
    public void setTotals(RootTotals totals) {
        this.totals = totals;
    }
    public String getLateEntry() {
        return lateEntry;
    }
    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }
    public String getFiscalYear() {
        return fiscalYear;
    }
    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
    public String getCommunityName() {
        return communityName;
    }
    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
    public String getHealthAuthority() {
        return healthAuthority;
    }
    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }
    public List<RootPcnBudgetItem> getPcnBudget() {
        return pcnBudget;
    }
    public void setPcnBudget(List<RootPcnBudgetItem> pcnBudget) {
        this.pcnBudget = pcnBudget;
    }
}
