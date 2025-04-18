package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public String lateEntry;
    public String upccName;
    public String upccId;
    public String upccTypeOfCare;
    public String fiscalYear;
    public String pcnCommunity;
    public String healthAuthority;
    public String periodReported;
    public String reasonForExceptionInPeriodReported;
    public RootDataSubmission dataSubmission;

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getUpccName() {
        return upccName;
    }

    public void setUpccName(String upccName) {
        this.upccName = upccName;
    }

    public String getUpccTypeOfCare() {
        return upccTypeOfCare;
    }

    public void setUpccTypeOfCare(String upccTypeOfCare) {
        this.upccTypeOfCare = upccTypeOfCare;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getPcnCommunity() {
        return pcnCommunity;
    }

    public void setPcnCommunity(String pcnCommunity) {
        this.pcnCommunity = pcnCommunity;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getPeriodReported() {
        return periodReported;
    }

    public void setPeriodReported(String periodReported) {
        this.periodReported = periodReported;
    }

    public String getReasonForExceptionInPeriodReported() {
        return reasonForExceptionInPeriodReported;
    }

    public void setReasonForExceptionInPeriodReported(String reasonForExceptionInPeriodReported) {
        this.reasonForExceptionInPeriodReported = reasonForExceptionInPeriodReported;
    }

    public RootDataSubmission getDataSubmission() {
        return dataSubmission;
    }

    public void setDataSubmission(RootDataSubmission dataSubmission) {
        this.dataSubmission = dataSubmission;
    }

    public String getLateEntry() {
        return lateEntry;
    }

    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }

    public String getUpccId() {
        return upccId;
    }

    public void setUpccId(String upccId) {
        this.upccId = upccId;
    }

    @Override
    public String toString() {
        return "Root [form=" + form + ", lateEntry=" + lateEntry + ", upccName=" + upccName
                + ", upccId=" + upccId + ", upccTypeOfCare=" + upccTypeOfCare + ", fiscalYear="
                + fiscalYear + ", pcnCommunity=" + pcnCommunity + ", healthAuthority="
                + healthAuthority + ", periodReported=" + periodReported
                + ", reasonForExceptionInPeriodReported=" + reasonForExceptionInPeriodReported
                + ", dataSubmission=" + dataSubmission + "]";
    }
}
