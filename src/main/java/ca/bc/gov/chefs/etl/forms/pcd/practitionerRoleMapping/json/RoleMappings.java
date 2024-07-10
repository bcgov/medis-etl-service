package ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.json;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleMappings {
    private String positionType;
    private String practitionerRole;
    private String resourceCategory;
    public String getPositionType() {
        return positionType;
    }
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
    public String getPractitionerRole() {
        return practitionerRole;
    }
    public void setPractitionerRole(String practitionerRole) {
        this.practitionerRole = practitionerRole;
    }
    public String getResourceCategory() {
        return resourceCategory;
    }
    public void setResourceCategory(String resourceCategory) {
        this.resourceCategory = resourceCategory;
    }

    @Override
    public String toString() {
        return "Mappings [positionType=" + positionType + ", practitionerRole=" + practitionerRole
                + ", resourceCategory=" + resourceCategory + "]";
    }
}
