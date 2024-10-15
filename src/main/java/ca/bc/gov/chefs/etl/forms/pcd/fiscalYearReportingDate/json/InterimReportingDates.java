package ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDate.json;

public class InterimReportingDates {
    private String interim;
    private String endDate;
    private String startDate;
    private String submissionDueDate;
    private String validationDueDate;

    public String getInterim() {
        return interim;
    }

    public void setInterim(String interim) {
        this.interim = interim;
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
        return "InterimReportingDates [interim=" + interim + ", endDate=" + endDate + ", startDate=" + startDate
                + ", submissionDueDate=" + submissionDueDate + ", validationDueDate=" + validationDueDate + "]";
    }
}
