package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class FRPcnSubmission implements IModel {

    private String submissionId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;
    private String healthAuthority;
    private String communityName;
    private String communityCode;
    private String fiscalYear;
    private String periodReported;
    private String reasonForExceptionPeriodReported;
    private String additionalNotes;

    private List<FRPcnFinancialData> pcnFinancialData;
    private List<FRPcnItemizedBudget> pcnItemizedBudget;
    private List<FRPcnFinancialTotals> pcnTotals;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLateEntry() {
        return lateEntry;
    }

    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }

    public String getSubmitterFullName() {
        return submitterFullName;
    }

    public void setSubmitterFullName(String submitterFullName) {
        this.submitterFullName = submitterFullName;
    }

    public String getSubmitterUserName() {
        return submitterUserName;
    }

    public void setSubmitterUserName(String submitterUserName) {
        this.submitterUserName = submitterUserName;
    }

    public String getSubmitterEmail() {
        return submitterEmail;
    }

    public void setSubmitterEmail(String submitterEmail) {
        this.submitterEmail = submitterEmail;
    }

    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public String getSubmissionVersion() {
        return submissionVersion;
    }

    public void setSubmissionVersion(String submissionVersion) {
        this.submissionVersion = submissionVersion;
    }

    public String getSubmissionFormName() {
        return submissionFormName;
    }

    public void setSubmissionFormName(String submissionFormName) {
        this.submissionFormName = submissionFormName;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
    
    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getPeriodReported() {
        return periodReported;
    }

    public void setPeriodReported(String periodReported) {
        this.periodReported = periodReported;
    }

    public String getReasonForExceptionPeriodReported() {
        return CSVUtil.replaceCarriageReturnLineFeed(reasonForExceptionPeriodReported);
    }

    public void setReasonForExceptionPeriodReported(String reasonForExceptionPeriodReported) {
        this.reasonForExceptionPeriodReported = reasonForExceptionPeriodReported;
    }

    public String getAdditionalNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(additionalNotes);
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public List<FRPcnFinancialData> getPcnFinancialData() {
        return pcnFinancialData;
    }

    public void setPcnFinancialData(List<FRPcnFinancialData> pcnFinancialData) {
        this.pcnFinancialData = pcnFinancialData;
    }

    public List<FRPcnItemizedBudget> getPcnItemizedBudget() {
        return pcnItemizedBudget;
    }

    public void setPcnItemizedBudget(List<FRPcnItemizedBudget> pcnItemizedBudget) {
        this.pcnItemizedBudget = pcnItemizedBudget;
    }

    public List<FRPcnFinancialTotals> getPcnTotals() {
        return pcnTotals;
    }

    public void setPcnTotals(List<FRPcnFinancialTotals> pcnTotals) {
        this.pcnTotals = pcnTotals;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FR_PCN_SUBMISSION;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(createdAt);
        elements.add(lateEntry);
        elements.add(submitterFullName);
        elements.add(submitterUserName);
        elements.add(submitterEmail);
        elements.add(submissionStatus);
        elements.add(submissionVersion);
        elements.add(submissionFormName);
        elements.add(healthAuthority);
        elements.add(communityName);
        elements.add(communityCode);
        elements.add(fiscalYear);
        elements.add(periodReported);
        elements.add(getReasonForExceptionPeriodReported());
        elements.add(getAdditionalNotes());
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> FRPcnIModels = new ArrayList<>();
        FRPcnIModels.addAll(pcnFinancialData);
        FRPcnIModels.addAll(pcnItemizedBudget);
        FRPcnIModels.addAll(pcnTotals);
        return FRPcnIModels;
    }

}
