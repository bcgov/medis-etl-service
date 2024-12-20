package ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FiscalYearPeriodDates implements IModel {

    private String submissionId;
    private String periodId;
    private String period;
    private String startDate;
    private String endDate;
    private String submissionDueDate;
    private String validationDueDate;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FISCAL_YEAR_PERIOD_DATES;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(periodId);
        elements.add(period);
        elements.add(startDate);
        elements.add(endDate);
        elements.add(submissionDueDate);
        elements.add(validationDueDate);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }

}
