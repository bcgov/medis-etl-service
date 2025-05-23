package ca.bc.gov.chefs.etl.forms.pcd.chc.budget.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootChcBudget {
	public String expenseCategory;
	public String expenseSubCategory;
	public String expenseItem;
	public String expenseItemSubType;
	public String approvedFtes;
	public String approvedBudget;
	public String approvedAttachmentTarget;

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

	public String getApprovedFtes() {
		return approvedFtes;
	}

	public void setApprovedFtes(String approvedFtes) {
		this.approvedFtes = approvedFtes;
	}

	public String getApprovedBudget() {
		return approvedBudget;
	}

	public void setApprovedBudget(String approvedBudget) {
		this.approvedBudget = approvedBudget;
	}

	public String getApprovedAttachmentTarget() {
		return approvedAttachmentTarget;
	}

	public void setApprovedAttachmentTarget(String approvedAttachmentTarget) {
		this.approvedAttachmentTarget = approvedAttachmentTarget;
	}

	@Override
	public String toString() {
		return "RootChcBudget [expenseCategory=" + expenseCategory + ", expenseSubCategory=" + expenseSubCategory
				+ ", expenseItem=" + expenseItem + ", expenseItemSubType=" + expenseItemSubType + ", approvedFtes="
				+ approvedFtes + ", approvedBudget=" + approvedBudget + ", approvedAttachmentTarget="
				+ approvedAttachmentTarget + "]";
	}

}
