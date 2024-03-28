package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.calculatedControlFields;

import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json.RootUpccBudget;

public class CalculatedTotals {
    
    private String approvedBudget;
    private String approvedFtes;
    private String clinicalApprovedBudget;
    private String clinicalApprovedFtes;
    private String overheadApprovedBudget;
    private String oneTimeFundingApprovedBudget;

    public CalculatedTotals(Root root){
        this.approvedBudget = this.calculateApprovedBudget(root);
        // this.approvedFtes= ;
        // this.clinicalApprovedBudget= ;
        // this.clinicalApprovedFtes= ;
        // this.overheadApprovedBudget= ;
        // this.oneTimeFundingApprovedBudget= ;
    }

    private String calculateApprovedBudget(Root root){
        Double calculatedBudget = 0.0;
        if(root.getUpccBudget() !=null && !root.getUpccBudget().isEmpty()){
            for(RootUpccBudget budget : root.getUpccBudget()){
                calculatedBudget =+ Double.parseDouble(budget.getApprovedBudget());
            }
            return calculatedBudget.toString();
        }
        return calculatedBudget.toString();
    }

    public String getApprovedBudget() {
        return approvedBudget;
    }

    public void setApprovedBudget(String approvedBudget) {
        this.approvedBudget = approvedBudget;
    }

    public String getApprovedFtes() {
        return approvedFtes;
    }

    public void setApprovedFtes(String approvedFtes) {
        this.approvedFtes = approvedFtes;
    }

    public String getClinicalApprovedBudget() {
        return clinicalApprovedBudget;
    }

    public void setClinicalApprovedBudget(String clinicalApprovedBudget) {
        this.clinicalApprovedBudget = clinicalApprovedBudget;
    }

    public String getClinicalApprovedFtes() {
        return clinicalApprovedFtes;
    }

    public void setClinicalApprovedFtes(String clinicalApprovedFtes) {
        this.clinicalApprovedFtes = clinicalApprovedFtes;
    }

    public String getOverheadApprovedBudget() {
        return overheadApprovedBudget;
    }

    public void setOverheadApprovedBudget(String overheadApprovedBudget) {
        this.overheadApprovedBudget = overheadApprovedBudget;
    }

    public String getOneTimeFundingApprovedBudget() {
        return oneTimeFundingApprovedBudget;
    }

    public void setOneTimeFundingApprovedBudget(String oneTimeFundingApprovedBudget) {
        this.oneTimeFundingApprovedBudget = oneTimeFundingApprovedBudget;
    }
}
