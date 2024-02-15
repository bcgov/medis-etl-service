package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class ExpenseHierarchySubmission implements IModel{

    private String submissionId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;

    private List<ExpenseHierarchyCategory> expenseHierarchyCategories;
    private List<ExpenseHierarchySubCategory> expenseHierarchySubCategories;
    private List<ExpenseHierarchyItem> expenseHierarchyItems;
    private List<ExpenseHierarchyItemSubCategory> expenseHierarchyItemSubCategories;

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

    public List<ExpenseHierarchyCategory> getExpenseHierarchyCategories() {
        return expenseHierarchyCategories;
    }

    public void setExpenseHierarchyCategories(List<ExpenseHierarchyCategory> expenseHierarchyCategories) {
        this.expenseHierarchyCategories = expenseHierarchyCategories;
    }

    public List<ExpenseHierarchySubCategory> getExpenseHierarchySubCategories() {
        return expenseHierarchySubCategories;
    }

    public void setExpenseHierarchySubCategories(List<ExpenseHierarchySubCategory> expenseHierarchySubCategories) {
        this.expenseHierarchySubCategories = expenseHierarchySubCategories;
    }

    public List<ExpenseHierarchyItem> getExpenseHierarchyItems() {
        return expenseHierarchyItems;
    }

    public void setExpenseHierarchyItems(List<ExpenseHierarchyItem> expenseHierarchyItems) {
        this.expenseHierarchyItems = expenseHierarchyItems;
    }

    public List<ExpenseHierarchyItemSubCategory> getExpenseHierarchyItemSubCategories() {
        return expenseHierarchyItemSubCategories;
    }

    public void setExpenseHierarchyItemSubCategories(
            List<ExpenseHierarchyItemSubCategory> expenseHierarchyItemSubCategories) {
        this.expenseHierarchyItemSubCategories = expenseHierarchyItemSubCategories;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FINANCIAL_EXPENSE_SUBMISSION;
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
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> ExpenseHierarchyIModels = new ArrayList<>();
        ExpenseHierarchyIModels.addAll(expenseHierarchyCategories);
        ExpenseHierarchyIModels.addAll(expenseHierarchySubCategories);
        ExpenseHierarchyIModels.addAll(expenseHierarchyItems);
        ExpenseHierarchyIModels.addAll(expenseHierarchyItemSubCategories);
        return ExpenseHierarchyIModels;
    }
    
}
