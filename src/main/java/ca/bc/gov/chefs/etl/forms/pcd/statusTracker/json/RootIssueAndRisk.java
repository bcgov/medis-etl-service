package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.IssueAndRiskType;

import java.util.ArrayList;
import java.util.List;

public class RootIssueAndRisk {

    private String confirmationId;

    private String issueId;

    private String issueRaisedDate;

    private List<String> typeOfIssue;

    private String relevantSites;

    private String issueClosedDate;

    private String riskCategory;

    private String issueAndRisk;

    private String dateMitigationPlanCommences;

    private String mitigationStrategy;

    private String issuesNotes;

    private String communityName; /** Adding this because some data uploaded to PROD has it **/

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = confirmationId;
    }

    public List<String> getTypeOfIssue() {
        return typeOfIssue;
    }

    public void setTypeOfIssue(List<String> typeOfIssue) {
        this.typeOfIssue = typeOfIssue;
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

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}
