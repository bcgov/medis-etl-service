package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class DecisionLogComments implements IModel{

    private String submissionId;
    private String comment;
    private String commentDate;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return Constants.DECISION_LOG_COMMENTS;
    }

    @Override
    public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.submissionId);
		elements.add(this.comment);
		elements.add(this.commentDate);
		return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}