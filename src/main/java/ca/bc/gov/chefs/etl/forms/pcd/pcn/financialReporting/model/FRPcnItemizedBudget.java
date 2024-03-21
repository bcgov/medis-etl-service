package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FRPcnItemizedBudget implements IModel{

    private String submissionId;
    private String budgetId;
    private String expenseCategory;
    private String expenseSubCategory;
    private String expenseItem;
    private String totalBudgetAllocation;
    private String fyExpenseVariance;
    private String proratedYtdBudget;
    private String fyEstimatedSurplus;
    private String ytdExpenseVariance;
    private String fyExpenseVarianceNote;
    private String ytdExpenseVarianceNote;
    private String annualBudget;
    private String fiscalYearAllocation;
    private String fyExpenseForecast;

    private List<FRPcnItemizedFinancialData> pcnItemizedFinancialData;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getExpenseSubCategory() {
        return expenseSubCategory;
    }

    public void setExpenseSubCategory(String expenseSubCategory) {
        this.expenseSubCategory = expenseSubCategory;
    }

    public String getExpenseItem() {
        return expenseItem;
    }

    public void setExpenseItem(String expenseItem) {
        this.expenseItem = expenseItem;
    }

    public String getTotalBudgetAllocation() {
        return totalBudgetAllocation;
    }

    public void setTotalBudgetAllocation(String totalBudgetAllocation) {
        this.totalBudgetAllocation = totalBudgetAllocation;
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

    public String getAnnualBudget() {
        return annualBudget;
    }

    public void setAnnualBudget(String annualBudget) {
        this.annualBudget = annualBudget;
    }

    public String getFiscalYearAllocation() {
        return fiscalYearAllocation;
    }

    public void setFiscalYearAllocation(String fiscalYearAllocation) {
        this.fiscalYearAllocation = fiscalYearAllocation;
    }

    public String getFyExpenseForecast() {
        return fyExpenseForecast;
    }

    public void setFyExpenseForecast(String fyExpenseForecast) {
        this.fyExpenseForecast = fyExpenseForecast;
    }

    public List<FRPcnItemizedFinancialData> getPcnItemizedFinancialData() {
        return pcnItemizedFinancialData;
    }

    public void setPcnItemizedFinancialData(List<FRPcnItemizedFinancialData> pcnItemizedFinancialData) {
        this.pcnItemizedFinancialData = pcnItemizedFinancialData;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FR_PCN_ITEMIZED_BUDGET;
    }

    @Override
    public List<String> getCsvElements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCsvElements'");
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> FRPcnBudgetIModels = new ArrayList<>();
        FRPcnBudgetIModels.addAll(pcnItemizedFinancialData);
        return FRPcnBudgetIModels;
    }
    
}
