package ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FiscalYearInterimDates implements IModel {
    private String submissionId;
    private String interimId;
    private String interim;
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

    public String getInterimId() {
        return interimId;
    }

    public void setInterimId(String interimId) {
        this.interimId = interimId;
    }

    public String getInterim() {
        return interim;
    }

    public void setInterim(String interim) {
        this.interim = interim;
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
        return PCDConstants.FISCAL_YEAR_INTERIM_DATES;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(interimId);
        elements.add(interim);
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
