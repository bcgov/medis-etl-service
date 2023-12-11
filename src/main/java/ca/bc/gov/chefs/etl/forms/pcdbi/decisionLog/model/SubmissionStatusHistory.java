package ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class SubmissionStatusHistory implements IModel{

    private String confirmationId;
    private String dateStatusChanged;
    private String assignee;
    private String updatedBy;

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = confirmationId;
    }

    public String getDateStatusChanged() {
        return dateStatusChanged;
    }

    public void setDateStatusChanged(String dateStatusChanged) {
        this.dateStatusChanged = dateStatusChanged;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return Constants.SUBMISSION_STATUS_HISTORY;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
		elements.add(this.confirmationId);
		elements.add(this.dateStatusChanged);
		elements.add(this.assignee);
		elements.add(this.updatedBy);
		return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
