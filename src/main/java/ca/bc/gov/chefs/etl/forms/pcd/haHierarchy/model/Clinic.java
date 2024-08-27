package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class Clinic implements IModel {
    private String primaryCareNetworkId;
    private String clinicId;
    private String clinicName;
    private String clinicType;

    public String getPrimaryCareNetworkId() {
        return primaryCareNetworkId;
    }

    public void setPrimaryCareNetworkId(String primaryCareNetworkId) {
        this.primaryCareNetworkId = primaryCareNetworkId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.HA_HIERARCHY_CLINIC;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(primaryCareNetworkId);
        elements.add(clinicId);
        elements.add(clinicName);
        elements.add(clinicType);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }

}
