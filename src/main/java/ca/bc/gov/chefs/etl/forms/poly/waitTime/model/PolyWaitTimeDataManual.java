package ca.bc.gov.chefs.etl.forms.poly.waitTime.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.POLYConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import static ca.bc.gov.chefs.etl.util.CSVUtil.formatDateRemoveTime;
import static ca.bc.gov.chefs.etl.util.CSVUtil.formatFiscalYearPOLY;

public class PolyWaitTimeDataManual implements IModel {

    private String fiscalYear;
    private String period;
    private String facilityId;
    private String origin;
    private String referralDate;
    private String consultDate;
    private String issue;
    private String priority;
    private String studyDate;
    private String referralToConsultWaitTime;
    private String consultToStudyWaitTime;
    private String totalWaitTime;

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = formatFiscalYearPOLY(fiscalYear);
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(String referralDate) {
        this.referralDate = formatDateRemoveTime(referralDate);
    }

    public String getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(String consultDate) {
        this.consultDate = formatDateRemoveTime(consultDate);
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStudyDate() {
        return studyDate;
    }

    public void setStudyDate(String studyDate) {
        this.studyDate =  formatDateRemoveTime(studyDate);
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

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return POLYConstants.POLY_WAIT_TIME_DATA_MANUAL;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> csvElements = new ArrayList<>();
        csvElements.add(fiscalYear);
        csvElements.add(period);
        csvElements.add(facilityId);
        csvElements.add(origin);
        csvElements.add(referralDate);
        csvElements.add(consultDate);
        csvElements.add(issue);
        csvElements.add(priority);
        csvElements.add(studyDate);
        csvElements.add(referralToConsultWaitTime);
        csvElements.add(consultToStudyWaitTime);
        csvElements.add(totalWaitTime);

        return csvElements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> iModels = new ArrayList<>();
        return iModels;
    }

}
