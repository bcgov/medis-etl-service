package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootOverheadBudget {
    public String approvedBudget;
    public String fyExpenseVariance;
    public String proratedYtdBudget;
    public String fyEstimatedSurplus;
    public String ytdExpenseVariance;
    public String fyExpenseVarianceNote;
    public String ytdExpenseVarianceNote;
    
    public String getApprovedBudget() {
        return approvedBudget;
    }
    public void setApprovedBudget(String approvedBudget) {
        this.approvedBudget = approvedBudget;
    }
    public String getFyExpenseVariance() {
        return fyExpenseVariance;
    }
    public void setFyExpenseVariance(String fyExpenseVariance) {
        this.fyExpenseVariance = fyExpenseVariance;
    }
    public String getProratedYtdBudget() {
        return proratedYtdBudget;
    }
    public void setProratedYtdBudget(String proratedYtdBudget) {
        this.proratedYtdBudget = proratedYtdBudget;
    }
    public String getFyEstimatedSurplus() {
        return fyEstimatedSurplus;
    }
    public void setFyEstimatedSurplus(String fyEstimatedSurplus) {
        this.fyEstimatedSurplus = fyEstimatedSurplus;
    }
    public String getYtdExpenseVariance() {
        return ytdExpenseVariance;
    }
    public void setYtdExpenseVariance(String ytdExpenseVariance) {
        this.ytdExpenseVariance = ytdExpenseVariance;
    }
    public String getFyExpenseVarianceNote() {
        return fyExpenseVarianceNote;
    }
    public void setFyExpenseVarianceNote(String fyExpenseVarianceNote) {
        this.fyExpenseVarianceNote = fyExpenseVarianceNote;
    }
    public String getYtdExpenseVarianceNote() {
        return ytdExpenseVarianceNote;
    }
    public void setYtdExpenseVarianceNote(String ytdExpenseVarianceNote) {
        this.ytdExpenseVarianceNote = ytdExpenseVarianceNote;
    }
}
