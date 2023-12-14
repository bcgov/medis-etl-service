package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class ClinicName implements IModel {
    private String submissionId;
    private String clinicName;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return Constants.PCD_STATUS_TRACKER_CLINIC_NAME;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(submissionId);
        elements.add(clinicName);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }

}
