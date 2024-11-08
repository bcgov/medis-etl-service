package ca.bc.gov.chefs.etl.forms.pda.facilityMapping.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PDAConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PdaFacilityMappingSubmission implements IModel {
    private String submissionId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;
    private List<PdaFacilityMappingData> pdaFacilityMappingData = new ArrayList<>();

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

    public List<PdaFacilityMappingData> getPdaFacilityMappingData() {
        return pdaFacilityMappingData;
    }

    public void setPdaFacilityMappingData(List<PdaFacilityMappingData> pdaFacilityMappingData) {
        this.pdaFacilityMappingData = pdaFacilityMappingData;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PDAConstants.PDA_FACILITY_MAPPING_SUBMISSION;
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
    public List<IModel> getObjects() {
        List<IModel> pdaFacilityModels = new ArrayList<>();
        pdaFacilityModels.addAll(this.getPdaFacilityMappingData());
        return pdaFacilityModels;
    }

}
