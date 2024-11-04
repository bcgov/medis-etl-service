package ca.bc.gov.chefs.etl.forms.pda.waitTime.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PDAConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PdaWaitTimeSubmission implements IModel {

    private String submissionId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;
    private String period;
    private String facility;
    private String facilityId;
    private String fiscalYear;

    private List<PdaWaitTimeData> pdaWaitTimeData = new ArrayList<>();

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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public List<PdaWaitTimeData> getPdaWaitTimeData() {
        return pdaWaitTimeData;
    }

    public void setPdaWaitTimeData(List<PdaWaitTimeData> pdaWaitTimeData) {
        this.pdaWaitTimeData = pdaWaitTimeData;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PDAConstants.PDA_WAIT_TIME_SUBMISSION;
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
        elements.add(period);
        elements.add(facility);
        elements.add(facilityId);
        elements.add(fiscalYear);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> pdaWaitTimeIModels = new ArrayList<>();
        pdaWaitTimeIModels.addAll(this.getPdaWaitTimeData());
        return pdaWaitTimeIModels;
    }

    @Override
    public String toString() {
        return "PdaWaitTimeSubmission [submissionId=" + submissionId + ", createdAt=" + createdAt + ", lateEntry="
                + lateEntry + ", submitterFullName=" + submitterFullName + ", submitterUserName=" + submitterUserName
                + ", submitterEmail=" + submitterEmail + ", submissionStatus=" + submissionStatus
                + ", submissionVersion=" + submissionVersion + ", submissionFormName=" + submissionFormName
                + ", period=" + period + ", facility=" + facility + ", facilityId=" + facilityId + ", fiscalYear="
                + fiscalYear + "]";
    }

}
