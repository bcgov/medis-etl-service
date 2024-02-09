package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootTotals {
    public String totalApprovedFtes;
    public String totalApprovedBudget;
    public String clinicalApprovedFtes;
    public String clinicalApprovedBudget;
    public String clinicalLcApprovedFtes;
    public String clinicalMsApprovedFtes;
    public String clinicalUcApprovedFtes;
    public String overheadApprovedBudget;
    public String clinicalLcApprovedBudget;
    public String clinicalMsApprovedBudget;
    public String clinicalUcApprovedBudget;
    public String oneTimeFundingApprovedBudget;
    
    public String getTotalApprovedFtes() {
        return totalApprovedFtes;
    }
    public void setTotalApprovedFtes(String totalApprovedFtes) {
        this.totalApprovedFtes = totalApprovedFtes;
    }
    public String getTotalApprovedBudget() {
        return totalApprovedBudget;
    }
    public void setTotalApprovedBudget(String totalApprovedBudget) {
        this.totalApprovedBudget = totalApprovedBudget;
    }
    public String getClinicalApprovedFtes() {
        return clinicalApprovedFtes;
    }
    public void setClinicalApprovedFtes(String clinicalApprovedFtes) {
        this.clinicalApprovedFtes = clinicalApprovedFtes;
    }
    public String getClinicalApprovedBudget() {
        return clinicalApprovedBudget;
    }
    public void setClinicalApprovedBudget(String clinicalApprovedBudget) {
        this.clinicalApprovedBudget = clinicalApprovedBudget;
    }
    public String getClinicalLcApprovedFtes() {
        return clinicalLcApprovedFtes;
    }
    public void setClinicalLcApprovedFtes(String clinicalLcApprovedFtes) {
        this.clinicalLcApprovedFtes = clinicalLcApprovedFtes;
    }
    public String getClinicalMsApprovedFtes() {
        return clinicalMsApprovedFtes;
    }
    public void setClinicalMsApprovedFtes(String clinicalMsApprovedFtes) {
        this.clinicalMsApprovedFtes = clinicalMsApprovedFtes;
    }
    public String getClinicalUcApprovedFtes() {
        return clinicalUcApprovedFtes;
    }
    public void setClinicalUcApprovedFtes(String clinicalUcApprovedFtes) {
        this.clinicalUcApprovedFtes = clinicalUcApprovedFtes;
    }
    public String getOverheadApprovedBudget() {
        return overheadApprovedBudget;
    }
    public void setOverheadApprovedBudget(String overheadApprovedBudget) {
        this.overheadApprovedBudget = overheadApprovedBudget;
    }
    public String getClinicalLcApprovedBudget() {
        return clinicalLcApprovedBudget;
    }
    public void setClinicalLcApprovedBudget(String clinicalLcApprovedBudget) {
        this.clinicalLcApprovedBudget = clinicalLcApprovedBudget;
    }
    public String getClinicalMsApprovedBudget() {
        return clinicalMsApprovedBudget;
    }
    public void setClinicalMsApprovedBudget(String clinicalMsApprovedBudget) {
        this.clinicalMsApprovedBudget = clinicalMsApprovedBudget;
    }
    public String getClinicalUcApprovedBudget() {
        return clinicalUcApprovedBudget;
    }
    public void setClinicalUcApprovedBudget(String clinicalUcApprovedBudget) {
        this.clinicalUcApprovedBudget = clinicalUcApprovedBudget;
    }
    public String getOneTimeFundingApprovedBudget() {
        return oneTimeFundingApprovedBudget;
    }
    public void setOneTimeFundingApprovedBudget(String oneTimeFundingApprovedBudget) {
        this.oneTimeFundingApprovedBudget = oneTimeFundingApprovedBudget;
    }
}
