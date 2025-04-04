package ca.bc.gov.chefs.etl.forms.poly.waitTime.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.POLYConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PolyWaitTimeSubmission implements IModel {

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
    private String fiscalYear;

    private List<PolyWaitTimeData> polyWaitTimeData = new ArrayList<>();
    private List<PolyWaitTimeDataManual> polyWaitTimeDataManual = new ArrayList<>();

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

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public List<PolyWaitTimeData> getPolyWaitTimeData() {
        return polyWaitTimeData;
    }

    public void setPolyWaitTimeData(List<PolyWaitTimeData> polyWaitTimeData) {
        this.polyWaitTimeData = polyWaitTimeData;
    }

    public List<PolyWaitTimeDataManual> getPolyWaitTimeDataManual() {
        return polyWaitTimeDataManual;
    }

    public void setPolyWaitTimeDataManual(List<PolyWaitTimeDataManual> polyWaitTimeDataManual) {
        this.polyWaitTimeDataManual = polyWaitTimeDataManual;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return POLYConstants.POLY_WAIT_TIME_SUBMISSION;
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
        elements.add(fiscalYear);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> polyWaitTimeIModels = new ArrayList<>();
        polyWaitTimeIModels.addAll(this.getPolyWaitTimeData());
        polyWaitTimeIModels.addAll(this.getPolyWaitTimeDataManual());
        return polyWaitTimeIModels;
    }

    @Override
    public String toString() {
        return "PolyWaitTimeSubmission [submissionId=" + submissionId + ", createdAt=" + createdAt + ", lateEntry="
                + lateEntry + ", submitterFullName=" + submitterFullName + ", submitterUserName=" + submitterUserName
                + ", submitterEmail=" + submitterEmail + ", submissionStatus=" + submissionStatus
                + ", submissionVersion=" + submissionVersion + ", submissionFormName=" + submissionFormName
                + ", period=" + period + ", facility=" + facility + ", fiscalYear="
                + fiscalYear + "]";
    }

}
