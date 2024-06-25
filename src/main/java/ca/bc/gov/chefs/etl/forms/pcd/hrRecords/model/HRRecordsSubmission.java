package ca.bc.gov.chefs.etl.forms.pcd.hrRecords.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class HRRecordsSubmission implements IModel{
    public String submissionId;
    public String createdAt;
    public String lateEntry;
    public String submitterFullName;
    public String submitterUserName;
    public String submitterEmail;
    public String submissionStatus;
    public String submissionVersion;
    public String submissionFormName;
    public String reportingLevel;
    public String clinicId;
    public String healthAuthority;
    public String pcnCommunityName;
    public String pcnName;
    public String initiativeType;
    public String clinicName;
    public String clinicType;
    public List<HRRecordsData> hrRecordsData;
    
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
    public String getReportingLevel() {
        return reportingLevel;
    }
    public void setReportingLevel(String reportingLevel) {
        this.reportingLevel = reportingLevel;
    }
    public String getClinicId() {
        return clinicId;
    }
    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }
    public String getHealthAuthority() {
        return healthAuthority;
    }
    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }
    public String getPcnCommunityName() {
        return pcnCommunityName;
    }
    public void setPcnCommunityName(String pcnCommunityName) {
        this.pcnCommunityName = pcnCommunityName;
    }
    public String getPcnName() {
        return pcnName;
    }
    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
    }
    public String getInitiativeType() {
        return initiativeType;
    }
    public void setInitiativeType(String initiativeType) {
        this.initiativeType = initiativeType;
    }
    public String getClinicName() {
        return clinicName;
    }
    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
    public String getClinicType() {
        return clinicType;
    }
    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }
    public List<HRRecordsData> getHrRecordsData() {
        return hrRecordsData;
    }
    public void setHrRecordsData(List<HRRecordsData> hrRecordsData) {
        this.hrRecordsData = hrRecordsData;
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
        elements.add(reportingLevel);
        elements.add(clinicId);
        elements.add(healthAuthority);
        elements.add(pcnCommunityName);
        elements.add(pcnName);
        elements.add(initiativeType);
        elements.add(clinicName);
        elements.add(clinicType);
        return elements;
    }
    @Override
    public String getFormType() {
        return PCDConstants.HR_RECORDS_SUBMISSION;
    }
    @Override
    public List<IModel> getObjects() {
        List<IModel> HRRecordsIModels = new ArrayList<>();
        HRRecordsIModels.addAll(hrRecordsData);
        return HRRecordsIModels;
    }

    @Override
    public String toString() {
        return "HRRecordsSubmission [submissionId=" + submissionId + ", createdAt=" + createdAt + ", lateEntry="
                + lateEntry + ", submitterFullName=" + submitterFullName + ", submitterUserName=" + submitterUserName
                + ", submitterEmail=" + submitterEmail + ", submissionStatus=" + submissionStatus
                + ", submissionVersion=" + submissionVersion + ", submissionFormName=" + submissionFormName
                + ", reportingLevel=" + reportingLevel + ", clinicId=" + clinicId + ", healthAuthority="
                + healthAuthority + ", pcnCommunityName=" + pcnCommunityName + ", pcnName=" + pcnName
                + ", initiativeType=" + initiativeType + ", clinicName=" + clinicName + ", clinicType=" + clinicType
                + ", hrRecordsData=" + hrRecordsData + "]";
    }
}