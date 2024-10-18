package ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FiscalYearQuarterDates implements IModel {

    private String submissionId;
    private String quarterId;
    private String quarter;
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

    public String getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(String quarterId) {
        this.quarterId = quarterId;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
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
        return PCDConstants.FISCAL_YEAR_QUARTER_DATES;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(quarterId);
        elements.add(quarter);
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
