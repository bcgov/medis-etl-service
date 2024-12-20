package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PrimaryCareInitiative implements IModel {
    private String primaryCareNetworkId;
    private String primaryCareInitiativeId;
    private String initiativeName;
    private String initiativeType;
    private String typeOfCare;
    private String initiativeCode;

    public String getPrimaryCareNetworkId() {
        return primaryCareNetworkId;
    }

    public void setPrimaryCareNetworkId(String primaryCareNetworkId) {
        this.primaryCareNetworkId = primaryCareNetworkId;
    }

    public String getPrimaryCareInitiativeId() {
        return primaryCareInitiativeId;
    }

    public void setPrimaryCareInitiativeId(String primaryCareInitiativeId) {
        this.primaryCareInitiativeId = primaryCareInitiativeId;
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

    public String getTypeOfCare() {
        return typeOfCare;
    }

    public void setTypeOfCare(String typeOfCare) {
        this.typeOfCare = typeOfCare;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.HA_HIERARCHY_PRIMARY_CARE_INITIATIVES;
    }

    public String getInitiativeCode() {
        return initiativeCode;
    }

    public void setInitiativeCode(String initiativeCode) {
        this.initiativeCode = initiativeCode;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(primaryCareNetworkId);
        elements.add(primaryCareInitiativeId);

        elements.add(initiativeName);
        elements.add(initiativeType);
        elements.add(typeOfCare);
        elements.add(initiativeCode);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }

}
