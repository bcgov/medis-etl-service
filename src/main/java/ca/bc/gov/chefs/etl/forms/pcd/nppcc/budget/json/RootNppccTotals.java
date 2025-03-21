package ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootNppccTotals {
    public String totalApprovedFtes;
    public String totalApprovedBudget;
    public String clinicalApprovedFtes;
    public String clinicalApprovedBudget;
    public String overheadApprovedBudget;
    public String otherResourcesApprovedFtes;
    public String otherResourcesApprovedBudget;
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

    public String getOverheadApprovedBudget() {
        return overheadApprovedBudget;
    }

    public void setOverheadApprovedBudget(String overheadApprovedBudget) {
        this.overheadApprovedBudget = overheadApprovedBudget;
    }

    public String getOtherResourcesApprovedFtes() {
        return otherResourcesApprovedFtes;
    }

    public void setOtherResourcesApprovedFtes(String otherResourcesApprovedFtes) {
        this.otherResourcesApprovedFtes = otherResourcesApprovedFtes;
    }

    public String getOtherResourcesApprovedBudget() {
        return otherResourcesApprovedBudget;
    }

    public void setOtherResourcesApprovedBudget(String otherResourcesApprovedBudget) {
        this.otherResourcesApprovedBudget = otherResourcesApprovedBudget;
    }

    public String getOneTimeFundingApprovedBudget() {
        return oneTimeFundingApprovedBudget;
    }

    public void setOneTimeFundingApprovedBudget(String oneTimeFundingApprovedBudget) {
        this.oneTimeFundingApprovedBudget = oneTimeFundingApprovedBudget;
    }

    @Override
    public String toString() {
        return "RootChcTotals [totalApprovedFtes=" + totalApprovedFtes + ", totalApprovedBudget=" + totalApprovedBudget
                + ", clinicalApprovedFtes=" + clinicalApprovedFtes + ", clinicalApprovedBudget=" + clinicalApprovedBudget
                + ", overheadApprovedBudget=" + overheadApprovedBudget + ", otherResourcesApprovedFtes=" + otherResourcesApprovedFtes
                + ", otherResourcesApprovedBudget=" + otherResourcesApprovedBudget + ", oneTimeFundingApprovedBudget="
                + oneTimeFundingApprovedBudget + "]";
    }

}
