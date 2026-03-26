package ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class ProvincialRiskTracking implements IModel {
    private String submissionId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;
    private String typeOfInitiative;
    private String issueRaisedDate;
    private String relevantSites;
    private String issueClosedDate;
    private String issueAndRiskDescription;
    private String dateMitigationPlanComms;
    private String mitigationStrategy;
    private String issuesNotes;
    private String levelOfRisk;
    private String issueAndRiskTitle;
    private List<ProvincialRiskCategory> provincialRiskCategories;

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

    public String getTypeOfInitiative() {
        return typeOfInitiative;
    }

    public void setTypeOfInitiative(String typeOfInitiative) {
        this.typeOfInitiative = typeOfInitiative;
    }

    public String getIssueRaisedDate() {
        return issueRaisedDate;
    }

    public void setIssueRaisedDate(String issueRaisedDate) {
        this.issueRaisedDate = issueRaisedDate;
    }

    public String getRelevantSites() {
        return relevantSites;
    }

    public void setRelevantSites(String relevantSites) {
        this.relevantSites = relevantSites;
    }

    public String getIssueClosedDate() {
        return issueClosedDate;
    }

    public void setIssueClosedDate(String issueClosedDate) {
        this.issueClosedDate = issueClosedDate;
    }

    public String getIssueAndRiskDescription() {
        return CSVUtil.replaceCarriageReturnLineFeed(issueAndRiskDescription);
    }

    public void setIssueAndRiskDescription(String issueAndRiskDescription) {
        this.issueAndRiskDescription = issueAndRiskDescription;
    }

    public String getDateMitigationPlanComms() {
        return dateMitigationPlanComms;
    }

    public void setDateMitigationPlanComms(String dateMitigationPlanComms) {
        this.dateMitigationPlanComms = dateMitigationPlanComms;
    }

    public String getMitigationStrategy() {
        return CSVUtil.replaceCarriageReturnLineFeed(mitigationStrategy);
    }

    public void setMitigationStrategy(String mitigationStrategy) {
        this.mitigationStrategy = mitigationStrategy;
    }

    public String getIssuesNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(issuesNotes);
    }

    public void setIssuesNotes(String issuesNotes) {
        this.issuesNotes = issuesNotes;
    }

    public String getLevelOfRisk() {
        return levelOfRisk;
    }

    public void setLevelOfRisk(String levelOfRisk) {
        this.levelOfRisk = levelOfRisk;
    }

    public String getIssueAndRiskTitle() {
        return issueAndRiskTitle;
    }

    public void setIssueAndRiskTitle(String issueAndRiskTitle) {
        this.issueAndRiskTitle = issueAndRiskTitle;
    }

    public List<ProvincialRiskCategory> getProvincialRiskCategories() {
        return provincialRiskCategories;
    }

    public void setProvincialRiskCategories(List<ProvincialRiskCategory> provincialRiskCategories) {
        this.provincialRiskCategories = provincialRiskCategories;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.PROVINCIAL_RISK_TRACKING;
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
        elements.add(typeOfInitiative);
        elements.add(issueRaisedDate);
        elements.add(relevantSites);
        elements.add(issueClosedDate);
        elements.add(getIssueAndRiskDescription());
        elements.add(dateMitigationPlanComms);
        elements.add(getMitigationStrategy());
        elements.add(getIssueAndRiskDescription());
        elements.add(levelOfRisk);
        elements.add(issueAndRiskTitle);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> provincialRiskTrackingIModels = new ArrayList<>();
        provincialRiskTrackingIModels.addAll(provincialRiskCategories);
        return provincialRiskTrackingIModels;
    }

    @Override
    public String toString() {
        return "ProvincialRiskTracking [submissionId=" + submissionId + ", createdAt=" + createdAt + ", lateEntry="
                + lateEntry + ", submitterFullName=" + submitterFullName + ", submitterUserName=" + submitterUserName
                + ", submitterEmail=" + submitterEmail + ", submissionStatus=" + submissionStatus
                + ", submissionVersion=" + submissionVersion + ", submissionFormName=" + submissionFormName
                + ", typeOfInitiative=" + typeOfInitiative + ", issueRaisedDate=" + issueRaisedDate + ", relevantSites="
                + relevantSites + ", issueClosedDate=" + issueClosedDate + ", issueAndRiskDescription="
                + issueAndRiskDescription + ", dateMitigationPlanComms=" + dateMitigationPlanComms
                + ", mitigationStrategy=" + mitigationStrategy + ", issuesNotes=" + issuesNotes + ", levelOfRisk="
                + levelOfRisk + ", issueAndRiskTitle=" + issueAndRiskTitle + ", provincialRiskCategories="
                + provincialRiskCategories + "]";
    }
}
