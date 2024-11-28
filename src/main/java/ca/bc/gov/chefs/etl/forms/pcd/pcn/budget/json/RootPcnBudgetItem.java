package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootPcnBudgetItem {
	public String expenseItem;
	public String annualBudget;
	public String ftesInclRelief;
	public String expenseCategory;
	public String approved4YearFtEs;
	public String expenseItemSubType;
	public String expenseSubCategory;
	public String fiscalYearAllocation;
	public String totalBudgetAllocation;
	public String approvedAttachmentTarget;

	public String getExpenseItem() {
		return expenseItem;
	}

	public void setExpenseItem(String expenseItem) {
		this.expenseItem = expenseItem;
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

	public String getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	public String getApproved4YearFtEs() {
		return approved4YearFtEs;
	}

	public void setApproved4YearFtEs(String approved4YearFtEs) {
		this.approved4YearFtEs = approved4YearFtEs;
	}

	public String getExpenseItemSubType() {
		return expenseItemSubType;
	}

	public void setExpenseItemSubType(String expenseItemSubType) {
		this.expenseItemSubType = expenseItemSubType;
	}

	public String getExpenseSubCategory() {
		return expenseSubCategory;
	}

	public void setExpenseSubCategory(String expenseSubCategory) {
		this.expenseSubCategory = expenseSubCategory;
	}

	public String getFiscalYearAllocation() {
		return fiscalYearAllocation;
	}

	public void setFiscalYearAllocation(String fiscalYearAllocation) {
		this.fiscalYearAllocation = fiscalYearAllocation;
	}

	public String getTotalBudgetAllocation() {
		return totalBudgetAllocation;
	}

	public void setTotalBudgetAllocation(String totalBudgetAllocation) {
		this.totalBudgetAllocation = totalBudgetAllocation;
	}

	public String getApprovedAttachmentTarget() {
		return approvedAttachmentTarget;
	}

	public void setApprovedAttachmentTarget(String approvedAttachmentTarget) {
		this.approvedAttachmentTarget = approvedAttachmentTarget;
	}

	@Override
	public String toString() {
		return "RootPcnBudgetItem [expenseItem=" + expenseItem + ", annualBudget=" + annualBudget + ", ftesInclRelief="
				+ ftesInclRelief + ", expenseCategory=" + expenseCategory + ", approved4YearFtEs=" + approved4YearFtEs
				+ ", expenseItemSubType=" + expenseItemSubType + ", expenseSubCategory=" + expenseSubCategory
				+ ", fiscalYearAllocation=" + fiscalYearAllocation + ", totalBudgetAllocation=" + totalBudgetAllocation
				+ ", approvedAttachmentTarget=" + approvedAttachmentTarget + "]";
	}

}
