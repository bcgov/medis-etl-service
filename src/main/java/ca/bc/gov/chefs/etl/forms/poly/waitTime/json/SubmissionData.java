package ca.bc.gov.chefs.etl.forms.poly.waitTime.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmissionData {
    private String region;
    private String origin;
    private String priority;
    private String patientRef;
    private String sleepIssue;
    private String otherComment;
    private String referralDate;
    private String selectComment;
    private String totalWaitTime;
    private String healthAuthority;
    private String level1StudyDate;
    private String consultToStudyWait2;
    private String specialistConsultDate;
    private String referralToConsultWait1;

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

    public String getOtherComment() {
        return otherComment;
    }

    public void setOtherComment(String otherComment) {
        this.otherComment = otherComment;
    }

    public String getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(String referralDate) {
        this.referralDate = referralDate;
    }

    public String getSelectComment() {
        return selectComment;
    }

    public void setSelectComment(String selectComment) {
        this.selectComment = selectComment;
    }

    public String getTotalWaitTime() {
        return totalWaitTime;
    }

    public void setTotalWaitTime(String totalWaitTime) {
        this.totalWaitTime = totalWaitTime;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getLevel1StudyDate() {
        return level1StudyDate;
    }

    public void setLevel1StudyDate(String level1StudyDate) {
        this.level1StudyDate = level1StudyDate;
    }

    public String getConsultToStudyWait2() {
        return consultToStudyWait2;
    }

    public void setConsultToStudyWait2(String consultToStudyWait2) {
        this.consultToStudyWait2 = consultToStudyWait2;
    }

    public String getSpecialistConsultDate() {
        return specialistConsultDate;
    }

    public void setSpecialistConsultDate(String specialistConsultDate) {
        this.specialistConsultDate = specialistConsultDate;
    }

    public String getReferralToConsultWait1() {
        return referralToConsultWait1;
    }

    public void setReferralToConsultWait1(String referralToConsultWait1) {
        this.referralToConsultWait1 = referralToConsultWait1;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "SubmissionData [region=" + region + ", origin=" + origin + ", priority=" + priority + ", patientRef=" + patientRef + ", sleepIssue=" + sleepIssue + ", otherComment=" + otherComment
                + ", referralDate=" + referralDate + ", selectComment=" + selectComment + ", totalWaitTime=" + totalWaitTime + ", healthAuthority=" + healthAuthority + ", level1StudyDate="
                + level1StudyDate + ", consultToStudyWait2=" + consultToStudyWait2 + ", specialistConsultDate=" + specialistConsultDate + ", referralToConsultWait1=" + referralToConsultWait1 + "]";
    }

}
