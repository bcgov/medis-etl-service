package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class ChangeRequestFileUpload implements IModel{

    private String submissionId;
    private String id;
    private String url;
    private String size;
    private String storage;
    private String originalName;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.DECISION_LOG_CHANGE_REQUEST_FILE_UPLOAD;
    }

    @Override
    public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.id);
		elements.add(this.url);
		elements.add(this.size);
		elements.add(this.storage);
		elements.add(this.originalName);
		elements.add(this.submissionId);
		return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
