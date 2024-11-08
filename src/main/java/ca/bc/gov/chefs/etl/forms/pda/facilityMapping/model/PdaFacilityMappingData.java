package ca.bc.gov.chefs.etl.forms.pda.facilityMapping.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PDAConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PdaFacilityMappingData implements IModel {
    private String submissionId;
    private String pdaFacilityMappingDataId;
    private String facilityName;
    private String facilityId;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getPdaFacilityMappingDataId() {
        return pdaFacilityMappingDataId;
    }

    public void setPdaFacilityMappingDataId(String pdaFacilityMappingDataId) {
        this.pdaFacilityMappingDataId = pdaFacilityMappingDataId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PDAConstants.PDA_FACILITY_MAPPING_DATA;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(pdaFacilityMappingDataId);
        elements.add(facilityName);
        elements.add(facilityId);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> pdaFacilityDataModels = new ArrayList<>();
        return pdaFacilityDataModels;
    }

}
