package ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class ProvincialRiskCategory implements IModel {
    private String submissionId;
    private String categoryOfIssue;

    
    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
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
        return PCDConstants.PROVINCIAL_RISK_CATEGORY;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(submissionId);
        elements.add(categoryOfIssue);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> ProvincialRiskCategoryIModels = new ArrayList<>();
        return ProvincialRiskCategoryIModels;
    }

    @Override
    public String toString() {
        return "ProvincialRiskCategory [submissionId=" + submissionId + ", categoryOfIssue=" + categoryOfIssue + "]";
    }
}
