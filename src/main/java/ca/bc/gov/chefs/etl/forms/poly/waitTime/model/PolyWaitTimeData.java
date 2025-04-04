package ca.bc.gov.chefs.etl.forms.poly.waitTime.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.POLYConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PolyWaitTimeData implements IModel {

    private String submissionId;
    private String polyWaitTimeDataId;
    private String healthAuthority;
    private String facility;
    private String region;
    private String priority;
    private String patientRef;
    private String sleepIssue;
    private String referralDate;
    private String level1StudyDate;
    private String specialistConsultDate;
    private String consultToStudyWaitTime;
    private String referralToConsultWaitTime;
    private String totalWaitTime;
    private String selectComment;
    private String otherComment;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getPolyWaitTimeDataId() {
        return polyWaitTimeDataId;
    }

    public void setPolyWaitTimeDataId(String polyWaitTimeDataId) {
        this.polyWaitTimeDataId = polyWaitTimeDataId;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPatientRef() {
        return patientRef;
    }

    public void setPatientRef(String patientRef) {
        this.patientRef = patientRef;
    }

    public String getSleepIssue() {
        return sleepIssue;
    }

    public void setSleepIssue(String sleepIssue) {
        this.sleepIssue = sleepIssue;
    }

    public String getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(String referralDate) {
        this.referralDate = referralDate;
    }

    public String getLevel1StudyDate() {
        return level1StudyDate;
    }

    public void setLevel1StudyDate(String level1StudyDate) {
        this.level1StudyDate = level1StudyDate;
    }

    public String getSpecialistConsultDate() {
        return specialistConsultDate;
    }

    public void setSpecialistConsultDate(String specialistConsultDate) {
        this.specialistConsultDate = specialistConsultDate;
    }

    public String getConsultToStudyWaitTime() {
        return consultToStudyWaitTime;
    }

    public void setConsultToStudyWaitTime(String consultToStudyWaitTime) {
        this.consultToStudyWaitTime = consultToStudyWaitTime;
    }

    public String getReferralToConsultWaitTime() {
        return referralToConsultWaitTime;
    }

    public void setReferralToConsultWaitTime(String referralToConsultWaitTime) {
        this.referralToConsultWaitTime = referralToConsultWaitTime;
    }

    public String getTotalWaitTime() {
        return totalWaitTime;
    }

    public void setTotalWaitTime(String totalWaitTime) {
        this.totalWaitTime = totalWaitTime;
    }

    public String getSelectComment() {
        return selectComment;
    }

    public void setSelectComment(String selectComment) {
        this.selectComment = selectComment;
    }

    public String getOtherComment() {
        return otherComment;
    }

    public void setOtherComment(String otherComment) {
        this.otherComment = otherComment;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return POLYConstants.POLY_WAIT_TIME_DATA;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(polyWaitTimeDataId);
        elements.add(facility);
        elements.add(healthAuthority);
        elements.add(region);
        elements.add(priority);
        elements.add(patientRef);
        elements.add(sleepIssue);
        elements.add(referralDate);
        elements.add(level1StudyDate);
        elements.add(specialistConsultDate);
        elements.add(consultToStudyWaitTime);
        elements.add(referralToConsultWaitTime);
        elements.add(totalWaitTime);
        elements.add(selectComment);
        elements.add(otherComment);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> polyWaitTimeDataIModels = new ArrayList<>();
        return polyWaitTimeDataIModels;
    }

    @Override
    public String toString() {
        return "PolyWaitTimeData [submissionId=" + submissionId + ", polyWaitTimeDataId=" + polyWaitTimeDataId
                + ", healthAuthority=" + healthAuthority + ", facility=" + facility + ", region=" + region
                + ", priority=" + priority + ", patientRef=" + patientRef + ", sleepIssue=" + sleepIssue
                + ", referralDate=" + referralDate + ", level1StudyDate=" + level1StudyDate + ", specialistConsultDate="
                + specialistConsultDate + ", consultToStudyWaitTime=" + consultToStudyWaitTime
                + ", referralToConsultWaitTime=" + referralToConsultWaitTime + ", totalWaitTime=" + totalWaitTime
                + ", selectComment=" + selectComment + ", otherComment=" + otherComment + "]";
    }

}
