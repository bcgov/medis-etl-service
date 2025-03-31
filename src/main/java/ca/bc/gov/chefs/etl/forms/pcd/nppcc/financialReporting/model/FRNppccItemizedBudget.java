package ca.bc.gov.chefs.etl.forms.pcd.nppcc.financialReporting.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class FRNppccItemizedBudget implements IModel {
	public String submissionId;
	public String budgetId;
	public String expenseCategory;
	public String expenseSubCategory;
	public String approvedBudget;
	public String fyExpenseVariance;
	public String proratedYtdBudget;
	public String fyEstimatedSurplus;
	public String ytdExpenseVariance;
	public String fyExpenseVarianceNote;
	public String ytdExpenseVarianceNote;

	public List<FRNppccItemizedFinancialData> frNppccItemizedFinancialData;

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

	public String getApprovedBudget() {
		return approvedBudget;
	}

	public void setApprovedBudget(String approvedBudget) {
		this.approvedBudget = approvedBudget;
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
		return CSVUtil.replaceCarriageReturnLineFeed(fyExpenseVarianceNote);
	}

	public void setFyExpenseVarianceNote(String fyExpenseVarianceNote) {
		this.fyExpenseVarianceNote = fyExpenseVarianceNote;
	}

	public String getYtdExpenseVarianceNote() {
		return CSVUtil.replaceCarriageReturnLineFeed(ytdExpenseVarianceNote);
	}

	public void setYtdExpenseVarianceNote(String ytdExpenseVarianceNote) {
		this.ytdExpenseVarianceNote = ytdExpenseVarianceNote;
	}

	public List<FRNppccItemizedFinancialData> getFrNppccItemizedFinancialData() {
		return frNppccItemizedFinancialData;
	}

	public void setFrNppccItemizedFinancialData(List<FRNppccItemizedFinancialData> frNppccItemizedFinancialData) {
		this.frNppccItemizedFinancialData = frNppccItemizedFinancialData;
	}

	@Override
	public String getFileName() {
		return null;
	}

	@Override
	public String getFormType() {
		return PCDConstants.FR_NPPCC_ITEMIZED_BUDGET;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(submissionId);
		elements.add(budgetId);
		elements.add(expenseCategory);
		elements.add(expenseSubCategory);
		elements.add(approvedBudget);
		elements.add(fyExpenseVariance);
		elements.add(proratedYtdBudget);
		elements.add(fyEstimatedSurplus);
		elements.add(ytdExpenseVariance);
		elements.add(getFyExpenseVarianceNote());
		elements.add(getYtdExpenseVarianceNote());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		List<IModel> FRUpccItemizedBudgetIModel = new ArrayList<>();
		FRUpccItemizedBudgetIModel.addAll(frNppccItemizedFinancialData);
		return FRUpccItemizedBudgetIModel;
	}
}
