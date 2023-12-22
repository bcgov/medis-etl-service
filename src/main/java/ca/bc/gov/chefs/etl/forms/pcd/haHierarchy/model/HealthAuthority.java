package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class HealthAuthority implements IModel{

    private String healthAuthority;
    private String submissionId;
    private String createdAt;
    private String submitterEmail;
    private String submissionStatus;
    private String submitterUserName;
    private String submitterFullName;
    private String submissionVersion;
    private String submissionFormName;

    private List<Community> Community;
    private List<PrimaryCareNetwork> PrimaryCareNetwork;
    private List<PrimaryCareInitiatives> PrimaryCareInitiatives;
    private List<Clinic> Clinic;

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSubmitterEmail() {
        return submitterEmail;
    }

    public void setSubmitterEmail(String submitterEmail) {
        this.submitterEmail = submitterEmail;
    }

    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public String getSubmitterUserName() {
        return submitterUserName;
    }

    public void setSubmitterUserName(String submitterUsername) {
        this.submitterUserName = submitterUsername;
    }

    public String getSubmitterFullName() {
        return submitterFullName;
    }

    public void setSubmitterFullName(String submitterFullName) {
        this.submitterFullName = submitterFullName;
    }

    public String getSubmissionVersion() {
        return submissionVersion;
    }

    public void setSubmissionVersion(String submissionversion) {
        this.submissionVersion = submissionversion;
    }

    public String getSubmissionFormName() {
        return submissionFormName;
    }

    public void setSubmissionFormName(String submissionformName) {
        this.submissionFormName = submissionformName;
    }

    public List<Community> getCommunity() {
        return Community;
    }

    public void setCommunity(List<Community> community) {
        Community = community;
    }

    public List<PrimaryCareNetwork> getPrimaryCareNetwork() {
        return PrimaryCareNetwork;
    }

    public void setPrimaryCareNetwork(List<PrimaryCareNetwork> primaryCareNetwork) {
        PrimaryCareNetwork = primaryCareNetwork;
    }

    public List<PrimaryCareInitiatives> getPrimaryCareInitiatives() {
        return PrimaryCareInitiatives;
    }

    public void setPrimaryCareInitiatives(List<PrimaryCareInitiatives> primaryCareInitiatives) {
        PrimaryCareInitiatives = primaryCareInitiatives;
    }
    public List<Clinic> getClinic() {
        return Clinic;
    }

    public void setClinic(List<Clinic> clinic) {
        Clinic = clinic;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.HA_HIERARCHY_HEALTH_AUTHORITY;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
		elements.add(this.healthAuthority);
		elements.add(this.submissionId);
		elements.add(this.createdAt);
		elements.add(this.submitterEmail);
		elements.add(this.submissionStatus);
		elements.add(this.submitterUserName);
		elements.add(this.submitterFullName);
		elements.add(this.submissionVersion);
		elements.add(this.submissionFormName);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> haHierarchyIModels = new ArrayList<>();
        haHierarchyIModels.addAll(this.getCommunity());
        haHierarchyIModels.addAll(this.getPrimaryCareNetwork());
        haHierarchyIModels.addAll(this.getPrimaryCareInitiatives());
        haHierarchyIModels.addAll(this.getClinic());
        return haHierarchyIModels;
    }
    
}
