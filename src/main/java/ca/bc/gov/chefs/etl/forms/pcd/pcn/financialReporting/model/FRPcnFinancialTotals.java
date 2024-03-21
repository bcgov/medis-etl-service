package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model;

import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FRPcnFinancialTotals implements IModel{

    private String submissionId;
    private String expenseCategory;
    private String annualBudget;
    private String approved4YearFtes;
    private String ftesHiredToDate;
    private String fyExpenseForecast;
    private String proratedYtdBudget;
    private String ytdExpenseVariance;
    private String ftesInclRelief;
    private String totalActualYtdExpenses;
    private String fyEstimatedSurplus;
    private String fyExpenseVariance;
    private String p1;
    private String p2;
    private String p3;
    private String p4;
    private String p5;
    private String p6;
    private String p7;
    private String p8;
    private String p9;
    private String p10;
    private String p11;
    private String p12;
    private String p13;
    private String totalBudgetAllocation;
    
    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getAnnualBudget() {
        return annualBudget;
    }

    public void setAnnualBudget(String annualBudget) {
        this.annualBudget = annualBudget;
    }

    public String getApproved4YearFtes() {
        return approved4YearFtes;
    }

    public void setApproved4YearFtes(String approved4YearFtes) {
        this.approved4YearFtes = approved4YearFtes;
    }

    public String getFtesHiredToDate() {
        return ftesHiredToDate;
    }

    public void setFtesHiredToDate(String ftesHiredToDate) {
        this.ftesHiredToDate = ftesHiredToDate;
    }

    public String getFyExpenseForecast() {
        return fyExpenseForecast;
    }

    public void setFyExpenseForecast(String fyExpenseForecast) {
        this.fyExpenseForecast = fyExpenseForecast;
    }

    public String getProratedYtdBudget() {
        return proratedYtdBudget;
    }

    public void setProratedYtdBudget(String proratedYtdBudget) {
        this.proratedYtdBudget = proratedYtdBudget;
    }

    public String getYtdExpenseVariance() {
        return ytdExpenseVariance;
    }

    public void setYtdExpenseVariance(String ytdExpenseVariance) {
        this.ytdExpenseVariance = ytdExpenseVariance;
    }

    public String getFtesInclRelief() {
        return ftesInclRelief;
    }

    public void setFtesInclRelief(String ftesInclRelief) {
        this.ftesInclRelief = ftesInclRelief;
    }

    public String getTotalActualYtdExpenses() {
        return totalActualYtdExpenses;
    }

    public void setTotalActualYtdExpenses(String totalActualYtdExpenses) {
        this.totalActualYtdExpenses = totalActualYtdExpenses;
    }

    public String getFyEstimatedSurplus() {
        return fyEstimatedSurplus;
    }

    public void setFyEstimatedSurplus(String fyEstimatedSurplus) {
        this.fyEstimatedSurplus = fyEstimatedSurplus;
    }

    public String getFyExpenseVariance() {
        return fyExpenseVariance;
    }

    public void setFyExpenseVariance(String fyExpenseVariance) {
        this.fyExpenseVariance = fyExpenseVariance;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }

    public String getP6() {
        return p6;
    }

    public void setP6(String p6) {
        this.p6 = p6;
    }

    public String getP7() {
        return p7;
    }

    public void setP7(String p7) {
        this.p7 = p7;
    }

    public String getP8() {
        return p8;
    }

    public void setP8(String p8) {
        this.p8 = p8;
    }

    public String getP9() {
        return p9;
    }

    public void setP9(String p9) {
        this.p9 = p9;
    }

    public String getP10() {
        return p10;
    }

    public void setP10(String p10) {
        this.p10 = p10;
    }

    public String getP11() {
        return p11;
    }

    public void setP11(String p11) {
        this.p11 = p11;
    }

    public String getP12() {
        return p12;
    }

    public void setP12(String p12) {
        this.p12 = p12;
    }

    public String getP13() {
        return p13;
    }

    public void setP13(String p13) {
        this.p13 = p13;
    }

    public String getTotalBudgetAllocation() {
        return totalBudgetAllocation;
    }

    public void setTotalBudgetAllocation(String totalBudgetAllocation) {
        this.totalBudgetAllocation = totalBudgetAllocation;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FR_PCN_FINANCIAL_TOTALS;
    }

    @Override
    public List<String> getCsvElements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCsvElements'");
    }

    @Override
    public List<IModel> getObjects() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getObjects'");
    }
    
}
