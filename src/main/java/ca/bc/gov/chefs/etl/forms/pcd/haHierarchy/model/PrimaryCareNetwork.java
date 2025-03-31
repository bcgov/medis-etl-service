package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PrimaryCareNetwork implements IModel {

    private String communityId;
    private String primaryCareNetworkId;
    private String pcnName;
    private String pcnType;
    private String pcnCode;

    private List<PrimaryCareInitiative> primaryCareInitiatives = new ArrayList<>();
    private List<Clinic> clinics = new ArrayList<>();

    public String getPcnName() {
        return pcnName;
    }

    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
    }

    public String getPcnType() {
        return pcnType;
    }

    public void setPcnType(String pcnType) {
        this.pcnType = pcnType;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getPrimaryCareNetworkId() {
        return primaryCareNetworkId;
    }

    public void setPrimaryCareNetworkId(String primaryCareNetworkId) {
        this.primaryCareNetworkId = primaryCareNetworkId;
    }

    public List<PrimaryCareInitiative> getPrimaryCareInitiatives() {
        return primaryCareInitiatives;
    }

    public void setPrimaryCareInitiatives(List<PrimaryCareInitiative> primaryCareInitiatives) {
        this.primaryCareInitiatives = primaryCareInitiatives;
    }

    public List<Clinic> getClinics() {
        return clinics;
    }

    public void setClinics(List<Clinic> clinics) {
        this.clinics = clinics;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.HA_HIERARCHY_PRIMARY_CARE_NETWORK;
    }

    public String getPcnCode() {
        return pcnCode;
    }

    public void setPcnCode(String pcnCode) {
        this.pcnCode = pcnCode;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(communityId);
        elements.add(primaryCareNetworkId);
        elements.add(pcnName);
        elements.add(pcnType);
        elements.add(pcnCode);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> primaryCareNetworkModels = new ArrayList<>();
        primaryCareNetworkModels.addAll(clinics);
        primaryCareNetworkModels.addAll(primaryCareInitiatives);

        return primaryCareNetworkModels;
    }

}
