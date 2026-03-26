package ca.bc.gov.chefs.etl.forms.pcd.nppcc.financialReporting.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class FinancialReportingNppccSubmission implements IModel {

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
	private String nppccName;
	private String nppccId;
	private String fiscalYear;
	private String periodReported;
	private String reasonForExceptionInPeriodReported;
	private String additionalNotes;

	private List<FRNppccFinancialTotals> frNppccFinancialTotals = new ArrayList<>();
	private List<FRNppccFinancialData> frNppccFinancialData = new ArrayList<>();
	private List<FRNppccItemizedBudget> frNppccItemizedBudgets = new ArrayList<>();

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
		this.lateEntry = StringUtils.defaultIfEmpty(lateEntry, PCDConstants.DEFAULT_BOOLEAN_FALSE);
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

	public String getNppccName() {
		return nppccName;
	}

	public void setNppccName(String nppccName) {
		this.nppccName = nppccName;
	}

	public String getNppccId() {
		return nppccId;
	}

	public void setNppccId(String nppccId) {
		this.nppccId = nppccId;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getPeriodReported() {
		return periodReported;
	}

	public void setPeriodReported(String interimReported) {
		this.periodReported = interimReported;
	}

	public String getReasonForExceptionInPeriodReported() {
		return CSVUtil.replaceCarriageReturnLineFeed(reasonForExceptionInPeriodReported);
	}

	public void setReasonForExceptionInPeriodReported(String reasonForExceptionInPeriodReported) {
		this.reasonForExceptionInPeriodReported = reasonForExceptionInPeriodReported;
	}

	public String getAdditionalNotes() {
		return CSVUtil.replaceCarriageReturnLineFeed(additionalNotes);
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public List<FRNppccFinancialTotals> getFrNppccFinancialTotals() {
		return frNppccFinancialTotals;
	}

	public void setFrNppccFinancialTotals(List<FRNppccFinancialTotals> frNppccFinancialTotals) {
		this.frNppccFinancialTotals = frNppccFinancialTotals;
	}

	public List<FRNppccFinancialData> getFrNppccFinancialData() {
		return frNppccFinancialData;
	}

	public void setFrNppccFinancialData(List<FRNppccFinancialData> frNppccFinancialData) {
		this.frNppccFinancialData = frNppccFinancialData;
	}

	public List<FRNppccItemizedBudget> getFrNppccItemizedBudgets() {
		return frNppccItemizedBudgets;
	}

	public void setFrNppccItemizedBudgets(List<FRNppccItemizedBudget> frNppccItemizedBudgets) {
		this.frNppccItemizedBudgets = frNppccItemizedBudgets;
	}

	@Override
	public String getFileName() {
		return null;
	}

	@Override
	public String getFormType() {
		return PCDConstants.FR_NPPCC_SUBMISSION;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(getSubmissionId());
		elements.add(getCreatedAt());
		elements.add(getLateEntry());
		elements.add(getSubmitterFullName());
		elements.add(getSubmitterUserName());
		elements.add(getSubmitterEmail());
		elements.add(getSubmissionStatus());
		elements.add(getSubmissionVersion());
		elements.add(getSubmissionFormName());
		elements.add(getHealthAuthority());
		elements.add(getCommunityName());
		elements.add(getFiscalYear());
		elements.add(getNppccName());
		elements.add(getNppccId());
		elements.add(getPeriodReported());
		elements.add(getReasonForExceptionInPeriodReported());
		elements.add(getAdditionalNotes());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		List<IModel> iModels = new ArrayList<>();
		iModels.addAll(frNppccFinancialTotals);
		iModels.addAll(frNppccFinancialData);
		iModels.addAll(frNppccItemizedBudgets);
		return iModels;
	}

}
