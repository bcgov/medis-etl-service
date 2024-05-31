package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootUpccBudget {
	public String typeOfCare;
	public String expenseItem;
	public List<String> strategyTitle;
	public String approvedBudget;
	public String expenseCategory;
	public String expenseItemSubType;
	public String expenseSubCategory;
	public String approvedFtesInclRelief;
	public String approvedAttachmentTarget;

	public List<RootAdditionalInfo> additionalSchedule1Info;

	public String getTypeOfCare() {
		return typeOfCare;
	}

	public void setTypeOfCare(String typeOfCare) {
		this.typeOfCare = typeOfCare;
	}

	public String getExpenseItem() {
		return expenseItem;
	}

	public void setExpenseItem(String expenseItem) {
		this.expenseItem = expenseItem;
	}

	public List<String> getStrategyTitle() {
		return strategyTitle;
	}

	public void setStrategyTitle(List<String> strategyTitle) {
		this.strategyTitle = strategyTitle;
	}

	public String getApprovedBudget() {
		return approvedBudget;
	}

	public void setApprovedBudget(String approvedBudget) {
		this.approvedBudget = approvedBudget;
	}

	public String getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
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

	public String getApprovedFtesInclRelief() {
		return approvedFtesInclRelief;
	}

	public void setApprovedFtesInclRelief(String approvedFtesInclRelief) {
		this.approvedFtesInclRelief = approvedFtesInclRelief;
	}

	public String getApprovedAttachmentTarget() {
		return approvedAttachmentTarget;
	}

	public void setApprovedAttachmentTarget(String approvedAttachmentTarget) {
		this.approvedAttachmentTarget = approvedAttachmentTarget;
	}

	public List<RootAdditionalInfo> getAdditionalSchedule1Info() {
		return additionalSchedule1Info;
	}

	public void setAdditionalSchedule1Info(List<RootAdditionalInfo> additionalSchedule1Info) {
		this.additionalSchedule1Info = additionalSchedule1Info;
	}

	@Override
	public String toString() {
		return "RootUpccBudget [typeOfCare=" + typeOfCare + ", expenseItem=" + expenseItem + ", strategyTitle="
				+ strategyTitle + ", approvedBudget=" + approvedBudget + ", expenseCategory=" + expenseCategory
				+ ", expenseItemSubType=" + expenseItemSubType + ", expenseSubCategory=" + expenseSubCategory
				+ ", approvedFtesInclRelief=" + approvedFtesInclRelief + ", approvedAttachmentTarget="
				+ approvedAttachmentTarget + ", additionalSchedule1Info=" + additionalSchedule1Info + "]";
	}
}
