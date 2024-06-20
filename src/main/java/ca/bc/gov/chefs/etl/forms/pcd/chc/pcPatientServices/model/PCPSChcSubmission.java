package ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PCPSChcSubmission implements IModel {
    private String submissionId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;
    private String chcName;
    private String pcnCommunityName;
    private String healthAuthority;
    private String fiscalYear;
    private String periodReported;
    private String reasonForExceptPeriodRep;
    private String notes;

    private List<PCPSChcSubmissionData> pcpsSubmissionData;

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

    public String getChcName() {
        return chcName;
    }

    public void setChcName(String chcName) {
        this.chcName = chcName;
    }

    public String getPcnCommunityName() {
        return pcnCommunityName;
    }

    public void setPcnCommunityName(String pcnCommunityName) {
        this.pcnCommunityName = pcnCommunityName;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
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

    public void setPeriodReported(String periodReported) {
        this.periodReported = periodReported;
    }

    public String getReasonForExceptPeriodRep() {
        return reasonForExceptPeriodRep;
    }

    public void setReasonForExceptPeriodRep(String reasonForExceptPeriodRep) {
        this.reasonForExceptPeriodRep = reasonForExceptPeriodRep;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<PCPSChcSubmissionData> getPcpsSubmissionData() {
        return pcpsSubmissionData;
    }

    public void setPcpsSubmissionData(List<PCPSChcSubmissionData> pcpsSubmissionData) {
        this.pcpsSubmissionData = pcpsSubmissionData;
    }

    @Override
    public String getFormType() {
        return PCDConstants.PC_PATIENT_SERVICES_CHC_SUBMISSION;
    }

    @Override
    public String getFileName() {
        return null;
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
        elements.add(chcName);
        elements.add(pcnCommunityName);
        elements.add(healthAuthority);
        elements.add(fiscalYear);
        elements.add(periodReported);
        elements.add(reasonForExceptPeriodRep);
        elements.add(notes);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> pcpsSubmissionDataIModels = new ArrayList<>();
        pcpsSubmissionDataIModels.addAll(pcpsSubmissionData);
        return pcpsSubmissionDataIModels;
    }

    @Override
    public String toString() {
        return "PCPSSubmission [submissionId=" + submissionId + ", createdAt=" + createdAt + ", lateEntry=" + lateEntry
                + ", submitterFullName=" + submitterFullName + ", submitterUserName=" + submitterUserName
                + ", submitterEmail="
                + submitterEmail + ", submissionStatus=" + submissionStatus + ", submissionVersion=" + submissionVersion
                + ", submissionFormName=" + submissionFormName + ", chcName=" + chcName
                + ", pcnCommunityName=" + pcnCommunityName + ", healthAuthority=" + healthAuthority + ", fiscalYear="
                + fiscalYear + ", periodReported=" + periodReported
                + ", reasonForExceptPeriodRep=" + reasonForExceptPeriodRep + ", notes=" + notes
                + ", pcpsSubmissionData="
                + pcpsSubmissionData + "]";
    }
}
