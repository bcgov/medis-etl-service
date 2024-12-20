package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

import java.util.ArrayList;
import java.util.List;

public class IssueAndRiskType implements IModel {

    private String issueId;

    private String categoryOfIssue;

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getCategoryOfIssue() {
        return categoryOfIssue;
    }

    public void setCategoryOfIssue(String categoryOfIssue) {
        this.categoryOfIssue = categoryOfIssue;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.PCD_STATUS_TRACKER_ISSUE_AND_RISK_CATEGORY;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(issueId);
        elements.add(categoryOfIssue);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
}
