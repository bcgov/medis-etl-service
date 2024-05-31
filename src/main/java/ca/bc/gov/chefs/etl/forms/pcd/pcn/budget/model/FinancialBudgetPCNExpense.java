package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetPCNExpense implements IModel{

    private String submissionId;
    private String expenseId;
    private String expenseCategory;
    private String expenseSubCategory;
    private String expenseItem;
    private String expenseItemSubType;
    private String totalBudgetAllocation;
    private String annualBudget;
    private String ftesInclRelief;
    private String approved4YearsFtes;
    private String fiscalYearAllocation;
    private String approvedAttachmentTarget;

    private List<PcnExpenseStrategy> expenseStrategies;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
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

    public String getExpenseItemSubType() {
        return expenseItemSubType;
    }

    public void setExpenseItemSubType(String expenseItemSubType) {
        this.expenseItemSubType = expenseItemSubType;
    }

    public String getTotalBudgetAllocation() {
        return totalBudgetAllocation;
    }

    public void setTotalBudgetAllocation(String totalBudgetAllocation) {
        this.totalBudgetAllocation = totalBudgetAllocation;
    }

    public String getAnnualBudget() {
        return annualBudget;
    }

    public void setAnnualBudget(String annualBudget) {
        this.annualBudget = annualBudget;
    }

    public String getFtesInclRelief() {
        return ftesInclRelief;
    }

    public void setFtesInclRelief(String ftesInclRelief) {
        this.ftesInclRelief = ftesInclRelief;
    }

    public String getApproved4YearsFtes() {
        return approved4YearsFtes;
    }

    public void setApproved4YearsFtes(String approved4YearsFtes) {
        this.approved4YearsFtes = approved4YearsFtes;
    }

    public String getFiscalYearAllocation() {
        return fiscalYearAllocation;
    }

    public void setFiscalYearAllocation(String fiscalYearAllocation) {
        this.fiscalYearAllocation = fiscalYearAllocation;
    }
    
    

    public String getApprovedAttachmentTarget() {
		return approvedAttachmentTarget;
	}

	public void setApprovedAttachmentTarget(String approvedAttachmentTarget) {
		this.approvedAttachmentTarget = approvedAttachmentTarget;
	}

	public List<PcnExpenseStrategy> getExpenseStrategies() {
        return expenseStrategies;
    }

    public void setExpenseStrategies(List<PcnExpenseStrategy> expenseStrategies) {
        this.expenseStrategies = expenseStrategies;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FINANCIAL_BUDGET_PCN_EXPENSE;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(expenseId);
        elements.add(expenseCategory);
        elements.add(expenseSubCategory);
        elements.add(expenseItem);
        elements.add(expenseItemSubType);
        elements.add(totalBudgetAllocation);
        elements.add(annualBudget);
        elements.add(ftesInclRelief);
        elements.add(approved4YearsFtes);
        elements.add(fiscalYearAllocation);
        elements.add(approvedAttachmentTarget);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> PcnExpenseIModels = new ArrayList<>();
        PcnExpenseIModels.addAll(expenseStrategies);
        return PcnExpenseIModels;
    }
    
}
