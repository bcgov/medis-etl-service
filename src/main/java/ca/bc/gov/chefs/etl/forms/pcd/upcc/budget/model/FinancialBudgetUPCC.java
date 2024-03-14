package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetUPCC  implements IModel {

    private String submissionId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;
    private String healthAuthority;
    private String communityName;
    private String fiscalYear;
    private String uppcName;

    private List<FinancialBudgetUPCCTotals> financialBudgetUPCCTotals;
    private List<FinancialBudgetUPCCExpense> financialBudgetUPCCExpenses;
    private List<UpccExpensePrimaryTargetPopulation> upccExpensePrimaryTargetPopulation;
    private List<UpccExpenseStrategy> upccExpenseStrategies;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLateEntry() {
        return lateEntry;
    }

    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }

    public String getSubmitterFullName() {
        return submitterFullName;
    }

    public void setSubmitterFullName(String submitterFullName) {
        this.submitterFullName = submitterFullName;
    }

    public String getSubmitterUserName() {
        return submitterUserName;
    }

    public void setSubmitterUserName(String submitterUserName) {
        this.submitterUserName = submitterUserName;
    }

    public String getSubmitterEmail() {
        return submitterEmail;
    }

    public void setSubmitterEmail(String submitterEmail) {
        this.submitterEmail = submitterEmail;
    }

    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public String getSubmissionVersion() {
        return submissionVersion;
    }

    public void setSubmissionVersion(String submissionVersion) {
        this.submissionVersion = submissionVersion;
    }

    public String getSubmissionFormName() {
        return submissionFormName;
    }

    public void setSubmissionFormName(String submissionFormName) {
        this.submissionFormName = submissionFormName;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getUppcName() {
        return uppcName;
    }

    public void setUppcName(String uppcName) {
        this.uppcName = uppcName;
    }

    public List<FinancialBudgetUPCCTotals> getFinancialBudgetUPCCTotals() {
        return financialBudgetUPCCTotals;
    }

    public void setFinancialBudgetUPCCTotals(List<FinancialBudgetUPCCTotals> financialBudgetUPCCTotals) {
        this.financialBudgetUPCCTotals = financialBudgetUPCCTotals;
    }

    public List<FinancialBudgetUPCCExpense> getFinancialBudgetUPCCExpenses() {
        return financialBudgetUPCCExpenses;
    }

    public void setFinancialBudgetUPCCExpenses(List<FinancialBudgetUPCCExpense> financialBudgetUPCCExpenses) {
        this.financialBudgetUPCCExpenses = financialBudgetUPCCExpenses;
    }

    public List<UpccExpensePrimaryTargetPopulation> getUpccExpensePrimaryTargetPopulation() {
        return upccExpensePrimaryTargetPopulation;
    }

    public void setUpccExpensePrimaryTargetPopulation(
            List<UpccExpensePrimaryTargetPopulation> upccExpensePrimaryTargetPopulation) {
        this.upccExpensePrimaryTargetPopulation = upccExpensePrimaryTargetPopulation;
    }

    public List<UpccExpenseStrategy> getUpccExpenseStrategies() {
        return upccExpenseStrategies;
    }

    public void setUpccExpenseStrategies(List<UpccExpenseStrategy> upccExpenseStrategies) {
        this.upccExpenseStrategies = upccExpenseStrategies;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FINANCIAL_BUDGET_UPCC;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(createdAt);
        elements.add(lateEntry);
        elements.add(submitterFullName);
        elements.add(submitterUserName);
        elements.add(submitterEmail);
        elements.add(submissionStatus);
        elements.add(submissionVersion);
        elements.add(submissionFormName);
        elements.add(healthAuthority);
        elements.add(communityName);
        elements.add(fiscalYear);
        elements.add(uppcName);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> UpccBudgetIModels = new ArrayList<>();
        UpccBudgetIModels.addAll(financialBudgetUPCCTotals);
        UpccBudgetIModels.addAll(financialBudgetUPCCExpenses);
        UpccBudgetIModels.addAll(upccExpensePrimaryTargetPopulation);
        UpccBudgetIModels.addAll(upccExpenseStrategies);
        return UpccBudgetIModels;
    }
    
}
