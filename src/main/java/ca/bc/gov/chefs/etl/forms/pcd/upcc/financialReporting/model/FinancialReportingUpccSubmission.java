package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialReportingUpccSubmission implements IModel{

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
    private String uppcName;
    private String fiscalYear;
    private String interimReported;
    private String reasonForExceptionInPeriodReported;
    private String additionalNotes;

    private List<FRUpccFinancialData> frUpccFinancialData;

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

    public String getUppcName() {
        return uppcName;
    }

    public void setUppcName(String uppcName) {
        this.uppcName = uppcName;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getInterimReported() {
        return interimReported;
    }

    public void setInterimReported(String interimReported) {
        this.interimReported = interimReported;
    }

    public String getReasonForExceptionInPeriodReported() {
        return reasonForExceptionInPeriodReported;
    }

    public void setReasonForExceptionInPeriodReported(String reasonForExceptionInPeriodReported) {
        this.reasonForExceptionInPeriodReported = reasonForExceptionInPeriodReported;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public List<FRUpccFinancialData> getFrUpccFinancialData() {
        return frUpccFinancialData;
    }

    public void setFrUpccFinancialData(List<FRUpccFinancialData> frUpccFinancialData) {
        this.frUpccFinancialData = frUpccFinancialData;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FR_UPCC_SUBMISSION;
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
        elements.add(uppcName);
        elements.add(fiscalYear);
        elements.add(interimReported);
        elements.add(reasonForExceptionInPeriodReported);
        elements.add(additionalNotes);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> FRUpccIModels = new ArrayList<>();
        FRUpccIModels.addAll(frUpccFinancialData);
        return FRUpccIModels;
    }
    
}
