package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootBudget {
    public String annualBudget;
    public String fyExpenseVariance;
    public String proratedYtdBudget;
    public String fyEstimatedSurplus;
    public String ytdExpenseVariance;
    public String fiscalYearAllocation;
    public String fyExpenseVarianceNote;
    public String totalBudgetAllocation;
    public String ytdExpenseVarianceNote;
    public String getAnnualBudget() {
        return annualBudget;
    }
    public void setAnnualBudget(String annualBudget) {
        this.annualBudget = annualBudget;
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
    public String getFiscalYearAllocation() {
        return fiscalYearAllocation;
    }
    public void setFiscalYearAllocation(String fiscalYearAllocation) {
        this.fiscalYearAllocation = fiscalYearAllocation;
    }
    public String getFyExpenseVarianceNote() {
        return fyExpenseVarianceNote;
    }
    public void setFyExpenseVarianceNote(String fyExpenseVarianceNote) {
        this.fyExpenseVarianceNote = fyExpenseVarianceNote;
    }
    public String getTotalBudgetAllocation() {
        return totalBudgetAllocation;
    }
    public void setTotalBudgetAllocation(String totalBudgetAllocation) {
        this.totalBudgetAllocation = totalBudgetAllocation;
    }
    public String getYtdExpenseVarianceNote() {
        return ytdExpenseVarianceNote;
    }
    public void setYtdExpenseVarianceNote(String ytdExpenseVarianceNote) {
        this.ytdExpenseVarianceNote = ytdExpenseVarianceNote;
    }
}
