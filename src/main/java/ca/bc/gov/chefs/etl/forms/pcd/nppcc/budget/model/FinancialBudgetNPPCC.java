package ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetNPPCC implements IModel {

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
	private String nppccName;

	private List<FinancialBudgetNPPCCTotals> financialBudgetNPPCCTotals;
	private List<FinancialBudgetNPPCCExpense> financialBudgetNPPCCExpenses;

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

	public String getNppccName() {
		return nppccName;
	}

	public void setNppccName(String nppccName) {
		this.nppccName = nppccName;
	}

	public List<FinancialBudgetNPPCCTotals> getFinancialBudgetNPPCCTotals() {
		return financialBudgetNPPCCTotals;
	}

	public void setFinancialBudgetNPPCCTotals(List<FinancialBudgetNPPCCTotals> financialBudgetNPPCCTotals) {
		this.financialBudgetNPPCCTotals = financialBudgetNPPCCTotals;
	}

	public List<FinancialBudgetNPPCCExpense> getFinancialBudgetNPPCCExpenses() {
		return financialBudgetNPPCCExpenses;
	}

	public void setFinancialBudgetNPPCCExpenses(List<FinancialBudgetNPPCCExpense> financialBudgetNPPCCExpenses) {
		this.financialBudgetNPPCCExpenses = financialBudgetNPPCCExpenses;
	}

	@Override
	public String getFileName() {
		return null;
	}

	@Override
	public String getFormType() {
		return PCDConstants.FINANCIAL_BUDGET_NPPCC;
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
		elements.add(nppccName);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		List<IModel> nppccBudgetIModels = new ArrayList<>();
		nppccBudgetIModels.addAll(financialBudgetNPPCCTotals);
		nppccBudgetIModels.addAll(financialBudgetNPPCCExpenses);
		return nppccBudgetIModels;
	}

}
