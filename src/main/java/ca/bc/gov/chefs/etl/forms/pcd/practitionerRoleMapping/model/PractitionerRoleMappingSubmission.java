package ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PractitionerRoleMappingSubmission implements IModel {
    public String submissionId;
    public String createdAt;
    public String lateEntry;
    public String submitterFullName;
    public String submitterUserName;
    public String submitterEmail;
    public String submissionStatus;
    public String submissionVersion;
    public String submissionFormName;
    public List<PractitionerRoleMappingData> practitionerRoleMappingData = new ArrayList<>(); 
    
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
    public List<PractitionerRoleMappingData> getPractitionerRoleMappingData() {
        return practitionerRoleMappingData;
    }
    public void setPractitionerRoleMappingData(List<PractitionerRoleMappingData> practitionerRoleMappingData) {
        this.practitionerRoleMappingData = practitionerRoleMappingData;
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
        return elements;
    }
    @Override
    public String getFileName() {
        return null;
    }
    @Override
    public String getFormType() {
        return PCDConstants.PRACTITIONER_ROLE_MAPPING_SUBMISSION;
    }
    @Override
    public List<IModel> getObjects() {
        List<IModel> pactitionerRoleMapppingIModels = new ArrayList<>();
        pactitionerRoleMapppingIModels.addAll(practitionerRoleMappingData);
        return pactitionerRoleMapppingIModels;
    }

    @Override
    public String toString() {
        return "PractitionerRoleMappingSubmission [submissionId=" + submissionId + ", createdAt=" + createdAt
                + ", lateEntry=" + lateEntry + ", submitterFullName=" + submitterFullName + ", submitterUserName="
                + submitterUserName + ", submitterEmail=" + submitterEmail + ", submissionStatus=" + submissionStatus
                + ", submissionVersion=" + submissionVersion + ", submissionFormName=" + submissionFormName
                + ", practitionerRoleMappingData=" + practitionerRoleMappingData + "]";
    }
}   
