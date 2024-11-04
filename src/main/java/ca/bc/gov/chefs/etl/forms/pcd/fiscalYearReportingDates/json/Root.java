package ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Form form;
    private String lateEntry;
    private String fiscalYear;
    private List<PeriodReportingDates> periodReportingDates = new ArrayList<>();
    private List<InterimReportingDates> interimReportingDates = new ArrayList<>();
    private List<QuarterReportingDates> quarterReportingDates = new ArrayList<>();

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

    public List<PeriodReportingDates> getPeriodReportingDates() {
        return periodReportingDates;
    }

    public void setPeriodReportingDates(List<PeriodReportingDates> periodReportingDates) {
        this.periodReportingDates = periodReportingDates;
    }

    public List<InterimReportingDates> getInterimReportingDates() {
        return interimReportingDates;
    }

    public void setInterimReportingDates(List<InterimReportingDates> interimReportingDates) {
        this.interimReportingDates = interimReportingDates;
    }

    public List<QuarterReportingDates> getQuarterReportingDates() {
        return quarterReportingDates;
    }

    public void setQuarterReportingDates(List<QuarterReportingDates> quarterReportingDates) {
        this.quarterReportingDates = quarterReportingDates;
    }

    @Override
    public String toString() {
        return "Root [form=" + form + ", lateEntry=" + lateEntry + ", fiscalYear=" + fiscalYear
                + ", periodReportingDates=" + periodReportingDates + ", interimReportingDates=" + interimReportingDates
                + ", quarterReportingDates=" + quarterReportingDates + "]";
    }
}
