package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootTotals {
    public String p1;
    public String p2;
    public String p3;
    public String p4;
    public String p5;
    public String p6;
    public String p7;
    public String p8;
    public String p9;
    public String p10;
    public String p11;
    public String p12;
    public String p13;
    public String annualBudget;
    public String ftesInclRelief;
    public String ftesHiredToDate;
    public String approved4yearFtes;
    public String fyExpenseForecast;
    public String fyExpenseVariance;
    public String proratedYtdBudget;
    public String fyEstimatedSurplus;
    public String ytdExpenseVariance;
    public String totalBudgetAllocation;
    public String totalActualYtdExpenses;
}
