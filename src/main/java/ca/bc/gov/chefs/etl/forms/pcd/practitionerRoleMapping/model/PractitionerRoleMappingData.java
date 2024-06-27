package ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PractitionerRoleMappingData implements IModel {
    public String submissionId;
    public String pracRoleRecordId;
    public String practitionerRole;
    public String positionType;
    public String resourceCategory;

    public String getSubmissionId() {
        return submissionId;
    }
    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }
    public String getPracRoleRecordId() {
        return pracRoleRecordId;
    }
    public void setPracRoleRecordId(String pracRoleRecordId) {
        this.pracRoleRecordId = pracRoleRecordId;
    }
    public String getPractitionerRole() {
        return practitionerRole;
    }
    public void setPractitionerRole(String practitionerRole) {
        this.practitionerRole = practitionerRole;
    }
    public String getPositionType() {
        return positionType;
    }
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
    public String getResourceCategory() {
        return resourceCategory;
    }
    public void setResourceCategory(String resourceCategory) {
        this.resourceCategory = resourceCategory;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(pracRoleRecordId);
        elements.add(practitionerRole);
        elements.add(positionType);
        elements.add(resourceCategory);
        return elements;
    }
    @Override
    public String getFileName() {
        return null;
    }
    @Override
    public String getFormType() {
        return PCDConstants.PRACTITIONER_ROLE_MAPPING_DATA;
    }
    @Override
    public List<IModel> getObjects() {
        List<IModel> objects = new ArrayList<>();
        return objects;
    }

    @Override
    public String toString() {
        return "PractitionerRoleMappingSubmission [submissionId=" + submissionId + ", pracRoleRecordId="
                + pracRoleRecordId + ", practitionerRole=" + practitionerRole + ", positionType=" + positionType
                + ", resourceCategory=" + resourceCategory + "]";
    }
}
