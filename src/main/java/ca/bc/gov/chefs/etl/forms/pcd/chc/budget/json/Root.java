package ca.bc.gov.chefs.etl.forms.pcd.chc.budget.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public RootChcTotals totals;
    public String chcName;
    public String lateEntry;
    public String fiscalYear;
    public List<RootChcBudget> chcBudget;
    public String communityName;
    public String healthAuthority;

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public RootChcTotals getTotals() {
        return totals;
    }

    public void setTotals(RootChcTotals totals) {
        this.totals = totals;
    }

    public String getChcName() {
        return chcName;
    }

    public void setChcName(String chcName) {
        this.chcName = chcName;
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

    public List<RootChcBudget> getChcBudget() {
        return chcBudget;
    }

    public void setChcBudget(List<RootChcBudget> chcBudget) {
        this.chcBudget = chcBudget;
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

    @Override
    public String toString() {
        return "Root [form=" + form + ", totals=" + totals + ", chcName=" + chcName + ", lateEntry=" + lateEntry + ", fiscalYear="
                + fiscalYear + ", chcBudget=" + chcBudget + ", communityName=" + communityName + ", healthAuthority=" + healthAuthority
                + "]";
    }
    
    

}
