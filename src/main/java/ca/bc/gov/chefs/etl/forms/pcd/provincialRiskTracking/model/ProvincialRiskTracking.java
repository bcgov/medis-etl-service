package ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

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
    private String typeOfInitative;
    private String issueRaisedDate;
    private String relevantSites;
    private String issueClosedDate;
    private String issueAndRiskDescription;
    private String dateMitigationPlanComms;
    private String mitigationStrategy;
    private String isuesNotes;
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
    public String getTypeOfInitative() {
        return typeOfInitative;
    }
    public void setTypeOfInitative(String typeOfInitative) {
        this.typeOfInitative = typeOfInitative;
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
        return issueAndRiskDescription;
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
        return mitigationStrategy;
    }
    public void setMitigationStrategy(String mitigationStrategy) {
        this.mitigationStrategy = mitigationStrategy;
    }
    public String getIsuesNotes() {
        return isuesNotes;
    }
    public void setIsuesNotes(String isuesNotes) {
        this.isuesNotes = isuesNotes;
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
        elements.add(typeOfInitative);
        elements.add(issueRaisedDate);
        elements.add(relevantSites);
        elements.add(issueClosedDate);
        elements.add(issueAndRiskDescription);
        elements.add(dateMitigationPlanComms);
        elements.add(mitigationStrategy);
        elements.add(isuesNotes);
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
}
