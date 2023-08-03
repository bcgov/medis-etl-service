package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

import java.util.ArrayList;
import java.util.List;

public class IssueAndRiskType implements IModel {

    private String issueId;

    private String typeOfIssue;

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getTypeOfIssue() {
        return typeOfIssue;
    }

    public void setTypeOfIssue(String typeOfIssue) {
        this.typeOfIssue = typeOfIssue;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return Constants.PCD_STATUS_TRACKER_ISSUE_AND_RISK_TYPE;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(getIssueId());
        elements.add(getTypeOfIssue());

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
}
