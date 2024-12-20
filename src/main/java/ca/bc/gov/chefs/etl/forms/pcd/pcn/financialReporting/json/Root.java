package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public String lateEntry;
    public String fiscalYear;
    public String communityName;
    public String communityId;
    public RootFinancialData financialData;
    public String periodReported;
    public String healthAuthority;
    public String reasonForExceptionInPeriodReported;
    public Form getForm() {
        return form;
    }
    public void setForm(Form form) {
        this.form = form;
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
    public String getCommunityName() {
        return communityName;
    }
    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
    public RootFinancialData getFinancialData() {
        return financialData;
    }
    public void setFinancialData(RootFinancialData financialData) {
        this.financialData = financialData;
    }
    public String getPeriodReported() {
        return periodReported;
    }
    public void setPeriodReported(String periodReported) {
        this.periodReported = periodReported;
    }
    public String getHealthAuthority() {
        return healthAuthority;
    }
    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }
    public String getReasonForExceptionInPeriodReported() {
        return reasonForExceptionInPeriodReported;
    }
    public void setReasonForExceptionInPeriodReported(String reasonForExceptionInPeriodReported) {
        this.reasonForExceptionInPeriodReported = reasonForExceptionInPeriodReported;
    }
    public String getCommunityId() {
        return communityId;
    }
    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }
}
