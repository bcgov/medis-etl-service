package ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Form form;
    private Boolean lateEntry;
    private String issuesNotes;
    private String levelOfRisk;
    private String relevantSites;
    private String issueRiskTitle;
    private String issueClosedDate;
    private String issueRaisedDate;
    private String typeOfInitiative;
    private List<String> issueRiskCategory = new ArrayList<>();
    private String mitigationStrategy;
    private String descriptionOfIssueOrRisk;
    private String dateMitigationPlanCommences;
    
    public Form getForm() {
        return form;
    }
    public void setForm(Form form) {
        this.form = form;
    }
    public Boolean getLateEntry() {
        return lateEntry;
    }
    public void setLateEntry(Boolean lateEntry) {
        this.lateEntry = lateEntry;
    }
    public String getIssuesNotes() {
        return issuesNotes;
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
    public String getRelevantSites() {
        return relevantSites;
    }
    public void setRelevantSites(String relevantSites) {
        this.relevantSites = relevantSites;
    }
    public String getIssueRiskTitle() {
        return issueRiskTitle;
    }
    public void setIssueRiskTitle(String issueRiskTitle) {
        this.issueRiskTitle = issueRiskTitle;
    }
    public String getIssueClosedDate() {
        return issueClosedDate;
    }
    public void setIssueClosedDate(String issueClosedDate) {
        this.issueClosedDate = issueClosedDate;
    }
    public String getIssueRaisedDate() {
        return issueRaisedDate;
    }
    public void setIssueRaisedDate(String issueRaisedDate) {
        this.issueRaisedDate = issueRaisedDate;
    }
    public String getTypeOfInitiative() {
        return typeOfInitiative;
    }
    public void setTypeOfInitiative(String typeOfInitiative) {
        this.typeOfInitiative = typeOfInitiative;
    }
    public List<String> getIssueRiskCategory() {
        return issueRiskCategory;
    }
    public void setIssueRiskCategory(List<String> issueRiskCategory) {
        this.issueRiskCategory = issueRiskCategory;
    }
    public String getMitigationStrategy() {
        return mitigationStrategy;
    }
    public void setMitigationStrategy(String mitigationStrategy) {
        this.mitigationStrategy = mitigationStrategy;
    }
    public String getDescriptionOfIssueOrRisk() {
        return descriptionOfIssueOrRisk;
    }
    public void setDescriptionOfIssueOrRisk(String descriptionOfIssueOrRisk) {
        this.descriptionOfIssueOrRisk = descriptionOfIssueOrRisk;
    }
    public String getDateMitigationPlanCommences() {
        return dateMitigationPlanCommences;
    }
    public void setDateMitigationPlanCommences(String dateMitigationPlanCommences) {
        this.dateMitigationPlanCommences = dateMitigationPlanCommences;
    }

    @Override
    public String toString() {
        return "Root [form=" + form + ", lateEntry=" + lateEntry + ", issuesNotes=" + issuesNotes + ", levelOfRisk="
                + levelOfRisk + ", relevantSites=" + relevantSites + ", issueRiskTitle=" + issueRiskTitle
                + ", issueClosedDate=" + issueClosedDate + ", issueRaisedDate=" + issueRaisedDate
                + ", typeOfInitiative=" + typeOfInitiative + ", issueRiskCategory=" + issueRiskCategory
                + ", mitigationStrategy=" + mitigationStrategy + ", descriptionOfIssueOrRisk="
                + descriptionOfIssueOrRisk + ", dateMitigationPlanCommences=" + dateMitigationPlanCommences + "]";
    }
}
