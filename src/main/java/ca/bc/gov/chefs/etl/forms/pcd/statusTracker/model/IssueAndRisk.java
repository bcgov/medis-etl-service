package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class IssueAndRisk implements IModel {

    private String submissionId;
    private String issueId;
    private String issueRaisedDate;
    private String relevantSites;
    private String issueClosedDate;
    private String issueAndRiskDescription;
    private String dateMitigationPlanComms;
    private String mitigationStrategy;
    private String issuesNotes;
    private String levelOfRisk;
    private String issueAndRiskTitle;

    private List<IssueAndRiskType> issueAndRiskTypes;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
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

    public List<IssueAndRiskType> getIssueAndRiskTypes() {
        return issueAndRiskTypes;
    }

    public void setIssueAndRiskTypes(List<IssueAndRiskType> issueAndRiskTypes) {
        this.issueAndRiskTypes = issueAndRiskTypes;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.PCD_STATUS_TRACKER_ISSUE_AND_RISK;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(submissionId);
        elements.add(issueId);
        elements.add(issueRaisedDate);
        elements.add(relevantSites);
        elements.add(issueClosedDate);
        elements.add(getIssueAndRiskDescription());
        elements.add(dateMitigationPlanComms);
        elements.add(getMitigationStrategy());
        elements.add(getIssuesNotes());
        elements.add(levelOfRisk);
        elements.add(issueAndRiskTitle);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> pcdStatusTrackerIssueAndRiskIModels = new ArrayList<>();

        if (issueAndRiskTypes != null) {
            pcdStatusTrackerIssueAndRiskIModels.addAll(issueAndRiskTypes);
        }

        return pcdStatusTrackerIssueAndRiskIModels;
    }
}
