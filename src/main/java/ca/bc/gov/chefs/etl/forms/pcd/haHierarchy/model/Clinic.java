package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class Clinic implements IModel{

    private String clinicName;
    private String clinicType;
    private String pcnName;
    private String initiativeName;
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

    public String getPcnName() {
        return pcnName;
    }

    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
    }

    public String getInitiativeName() {
        return initiativeName;
    }

    public void setInitiativeName(String initiativeName) {
        this.initiativeName = initiativeName;
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
		elements.add(this.clinicName);
		elements.add(this.clinicType);
		elements.add(this.pcnName);
		elements.add(this.initiativeName);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
