package ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FiscalYearReportingDatesSubmission implements IModel {
    private String submissionId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;
    private String fiscalYear;

    private List<FiscalYearQuarterDates> fiscalYearQuarterDates;
    private List<FiscalYearInterimDates> fiscalYearInterimDates;
    private List<FiscalYearPeriodDates> fiscalYearPeriodDates;

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

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public List<FiscalYearQuarterDates> getFiscalYearQuarterDates() {
        return fiscalYearQuarterDates;
    }

    public void setFiscalYearQuarterDates(List<FiscalYearQuarterDates> fiscalYearQuarterDates) {
        this.fiscalYearQuarterDates = fiscalYearQuarterDates;
    }

    public List<FiscalYearInterimDates> getFiscalYearInterimDates() {
        return fiscalYearInterimDates;
    }

    public void setFiscalYearInterimDates(List<FiscalYearInterimDates> fiscalYearInterimDates) {
        this.fiscalYearInterimDates = fiscalYearInterimDates;
    }

    public List<FiscalYearPeriodDates> getFiscalYearPeriodDates() {
        return fiscalYearPeriodDates;
    }

    public void setFiscalYearPeriodDates(List<FiscalYearPeriodDates> fiscalYearPeriodDates) {
        this.fiscalYearPeriodDates = fiscalYearPeriodDates;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FISCAL_YEAR_REPORTING_DATES_SUBMISSION;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> csvElements = new ArrayList<>();
        csvElements.add(submissionId);
        csvElements.add(createdAt);
        csvElements.add(lateEntry);
        csvElements.add(submitterFullName);
        csvElements.add(submitterUserName);
        csvElements.add(submitterEmail);
        csvElements.add(submissionStatus);
        csvElements.add(submissionVersion);
        csvElements.add(submissionFormName);
        csvElements.add(fiscalYear);
        return csvElements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> FiscalYearReportingDatesIModels = new ArrayList<>();
        FiscalYearReportingDatesIModels.addAll(fiscalYearQuarterDates);
        FiscalYearReportingDatesIModels.addAll(fiscalYearInterimDates);
        FiscalYearReportingDatesIModels.addAll(fiscalYearPeriodDates);
        return FiscalYearReportingDatesIModels;
    }

    @Override
    public String toString() {
        return "FiscalYearReportingDatesSubmission [submissionId=" + submissionId + ", createdAt=" + createdAt
                + ", lateEntry=" + lateEntry + ", submitterFullName=" + submitterFullName + ", submitterUserName="
                + submitterUserName + ", submitterEmail=" + submitterEmail + ", submissionStatus=" + submissionStatus
                + ", submissionVersion=" + submissionVersion + ", submissionFormName=" + submissionFormName
                + ", fiscalYear=" + fiscalYear + ", fiscalYearQuarterDates=" + fiscalYearQuarterDates
                + ", fiscalYearInterimDates=" + fiscalYearInterimDates + ", fiscalYearPeriodDates="
                + fiscalYearPeriodDates + "]";
    }

}
