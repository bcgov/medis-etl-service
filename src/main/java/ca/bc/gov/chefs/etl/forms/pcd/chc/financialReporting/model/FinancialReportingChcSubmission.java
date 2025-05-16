package ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class FinancialReportingChcSubmission implements IModel {

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
    private String chcName;
    private String chcCode;
    private String fiscalYear;
    private String periodReported;
    private String reasonForExceptionInPeriodReported;
    private String additionalNotes;

    private List<FRChcFinancialTotals> frChcFinancialTotals = new ArrayList<>();
    private List<FRChcFinancialData> frChcFinancialData = new ArrayList<>();
    private List<FRChcItemizedBudget> frChcItemizedBudgets = new ArrayList<>();

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
        this.lateEntry = StringUtils.defaultIfEmpty(lateEntry, PCDConstants.DEFAULT_BOOLEAN_FALSE);
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

    public String getChcName() {
        return chcName;
    }

    public void setChcName(String chcName) {
        this.chcName = chcName;
    }

    public String getChcCode() {
        return chcCode;
    }

    public void setChcCode(String chcCode) {
        this.chcCode = chcCode;
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

    public void setPeriodReported(String interimReported) {
        this.periodReported = interimReported;
    }

    public String getReasonForExceptionInPeriodReported() {
        return CSVUtil.replaceCarriageReturnLineFeed(reasonForExceptionInPeriodReported);
    }

    public void setReasonForExceptionInPeriodReported(String reasonForExceptionInPeriodReported) {
        this.reasonForExceptionInPeriodReported = reasonForExceptionInPeriodReported;
    }

    public String getAdditionalNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(additionalNotes);
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public List<FRChcFinancialTotals> getFrChcFinancialTotals() {
        return frChcFinancialTotals;
    }

    public void setFrChcFinancialTotals(List<FRChcFinancialTotals> frChcFinancialTotals) {
        this.frChcFinancialTotals = frChcFinancialTotals;
    }

    public List<FRChcFinancialData> getFrChcFinancialData() {
        return frChcFinancialData;
    }

    public void setFrChcFinancialData(List<FRChcFinancialData> frChcFinancialData) {
        this.frChcFinancialData = frChcFinancialData;
    }

    public List<FRChcItemizedBudget> getFrChcItemizedBudgets() {
        return frChcItemizedBudgets;
    }

    public void setFrChcItemizedBudgets(List<FRChcItemizedBudget> frChcItemizedBudgets) {
        this.frChcItemizedBudgets = frChcItemizedBudgets;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FR_CHC_SUBMISSION;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(this.getSubmissionId());
        elements.add(this.getCreatedAt());
        elements.add(this.getLateEntry());
        elements.add(this.getSubmitterFullName());
        elements.add(this.getSubmitterUserName());
        elements.add(this.getSubmitterEmail());
        elements.add(this.getSubmissionStatus());
        elements.add(this.getSubmissionVersion());
        elements.add(this.getSubmissionFormName());
        elements.add(this.getHealthAuthority());
        elements.add(this.getCommunityName());
        elements.add(this.getFiscalYear());
        elements.add(this.getChcName());
        elements.add(this.getChcCode());   
        elements.add(this.getPeriodReported());
        elements.add(this.getReasonForExceptionInPeriodReported());
        elements.add(this.getAdditionalNotes());
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> iModels = new ArrayList<>();
        iModels.addAll(frChcFinancialTotals);
        iModels.addAll(frChcFinancialData);
        iModels.addAll(frChcItemizedBudgets);
        return iModels;
    }

}
