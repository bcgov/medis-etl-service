package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PCNNames implements IModel {

    private String submissionId;
    private String pcnName;
    private String type;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getPcnName() {
        return pcnName;
    }

    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.DECISION_LOG_PCN_NAMES;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
		elements.add(this.submissionId);
		elements.add(this.pcnName);
		elements.add(this.type);
		return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
