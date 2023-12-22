package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

import java.util.ArrayList;
import java.util.List;

public class IssueAndRisk implements IModel {

    private String submissionId;

    private String issueId;

    private String issueRaisedDate;

    private String relevantSites;

    private String issueClosedDate;

    private String riskCategory;

    private String issueAndRisk;

    private String dateMitigationPlanCommences;

    private String mitigationStrategy;

    private String issuesNotes;

    private List<IssueAndRiskType> issueAndRiskTypes;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public List<IssueAndRiskType> getIssueAndRiskTypes() {
        return issueAndRiskTypes;
    }

    public void setIssueAndRiskTypes(List<IssueAndRiskType> issueAndRiskTypes) {
        this.issueAndRiskTypes = issueAndRiskTypes;
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

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getIssueAndRisk() {
        return issueAndRisk;
    }

    public void setIssueAndRisk(String issueAndRisk) {
        this.issueAndRisk = issueAndRisk;
    }

    public String getDateMitigationPlanCommences() {
        return dateMitigationPlanCommences;
    }

    public void setDateMitigationPlanCommences(String dateMitigationPlanCommences) {
        this.dateMitigationPlanCommences = dateMitigationPlanCommences;
    }

    public String getMitigationStrategy() {
        return mitigationStrategy;
    }

    public void setMitigationStrategy(String mitigationStrategy) {
        this.mitigationStrategy = mitigationStrategy;
    }

    public String getIssuesNotes() {
        return issuesNotes;
    }

    public void setIssuesNotes(String issuesNotes) {
        this.issuesNotes = issuesNotes;
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
        elements.add(riskCategory);
        elements.add(issueAndRisk);
        elements.add(dateMitigationPlanCommences);
        elements.add(mitigationStrategy);
        elements.add(issuesNotes);

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
