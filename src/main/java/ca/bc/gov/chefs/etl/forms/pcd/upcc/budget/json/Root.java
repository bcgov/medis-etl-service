package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public RootTotals totals;
    public String upccName;
    public String lateEntry;
    public String fiscalYear;
    public List<RootUpccBudget> upccBudget;
    public String communityName;
    public String healthAuthority;
    public String preventDuplicate;
    
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
    public String getUpccName() {
        return upccName;
    }
    public void setUpccName(String upccName) {
        this.upccName = upccName;
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
    public List<RootUpccBudget> getUpccBudget() {
        return upccBudget;
    }
    public void setUpccBudget(List<RootUpccBudget> upccBudget) {
        this.upccBudget = upccBudget;
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
    public String getPreventDuplicate() {
        return preventDuplicate;
    }
    public void setPreventDuplicate(String preventDuplicate) {
        this.preventDuplicate = preventDuplicate;
    }
}
