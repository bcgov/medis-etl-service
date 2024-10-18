package ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.json;

public class PeriodReportingDates {
    private String period;
    private String endDate;
    private String startDate;
    private String submissionDueDate;
    private String validationDueDate;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSubmissionDueDate() {
        return submissionDueDate;
    }

    public void setSubmissionDueDate(String submissionDueDate) {
        this.submissionDueDate = submissionDueDate;
    }

    public String getValidationDueDate() {
        return validationDueDate;
    }

    public void setValidationDueDate(String validationDueDate) {
        this.validationDueDate = validationDueDate;
    }

    @Override
    public String toString() {
        return "PeriodReportingDates [period=" + period + ", endDate=" + endDate + ", startDate=" + startDate
                + ", submissionDueDate=" + submissionDueDate + ", validationDueDate=" + validationDueDate + "]";
    }
}