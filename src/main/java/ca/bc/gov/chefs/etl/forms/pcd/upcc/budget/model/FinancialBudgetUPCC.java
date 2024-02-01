package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetUPCC  implements IModel {

    private String submissionId;
    private String createdAt;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String healthAuthority;
    private String communityName;
    private String fiscalYear;
    private String uppcName;

    private List<FinancialBudgetUPCCExpense> financialBudgetUPCCExpenses;

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

    public List<FinancialBudgetUPCCExpense> getFinancialBudgetUPCCExpenses() {
        return financialBudgetUPCCExpenses;
    }

    public void setFinancialBudgetUPCCExpenses(List<FinancialBudgetUPCCExpense> financialBudgetUPCCExpenses) {
        this.financialBudgetUPCCExpenses = financialBudgetUPCCExpenses;
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
        elements.add(submitterFullName);
        elements.add(submitterUserName);
        elements.add(submitterEmail);
        elements.add(submissionStatus);
        elements.add(healthAuthority);
        elements.add(communityName);
        elements.add(fiscalYear);
        elements.add(uppcName);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> UpccBudgetIModels = new ArrayList<>();
        UpccBudgetIModels.addAll(financialBudgetUPCCExpenses);
        return UpccBudgetIModels;
    }
    
}
