package ca.bc.gov.chefs.etl.forms.poly.waitTime.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Form form;
    private String period;
    private String facility;
    private String facilityId;
    private String facilityName;
    private String lateEntry;
    private String fiscalYear;
    private List<SubmissionData> submission = new ArrayList<>();

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
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

    public String getLateEntry() {
        return lateEntry;
    }

    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public List<SubmissionData> getSubmission() {
        return submission;
    }

    public void setSubmission(List<SubmissionData> submission) {
        this.submission = submission;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    @Override
    public String toString() {
        return "Root [form=" + form + ", period=" + period + ", facility=" + facility + ", facilityId=" + facilityId + ", facilityName=" + facilityName + ", lateEntry=" + lateEntry + ", fiscalYear="
                + fiscalYear + ", submission=" + submission + "]";
    }
}
