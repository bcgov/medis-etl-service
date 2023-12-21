package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class DecisionLogInitiatives implements IModel{

    private String submissionId;
    private String initiativeName;
    private String initiativeType;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getInitiativeName() {
        return initiativeName;
    }

    public void setInitiativeName(String initiativeName) {
        this.initiativeName = initiativeName;
    }

    public String getInitiativeType() {
        return initiativeType;
    }

    public void setInitiativeType(String initiativeType) {
        this.initiativeType = initiativeType;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.DECISION_LOG_INITIATIVES;
    }

    @Override
    public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.submissionId);
		elements.add(this.initiativeName);
		elements.add(this.initiativeType);
		return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
