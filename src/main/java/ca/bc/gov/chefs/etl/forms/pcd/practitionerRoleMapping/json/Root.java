package ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Form form;
    private String lateEntry;
    private List<RoleMappings> roleMappings = new ArrayList<>();
    public Form getForm() {
        return form;
    }
    public void setForm(Form form) {
        this.form = form;
    }
    public String getLateEntry() {
        return lateEntry;
    }
    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }
    public List<RoleMappings> getRoleMappings() {
        return roleMappings;
    }
    public void setRoleMappings(List<RoleMappings> roleMappings) {
        this.roleMappings = roleMappings;
    }

    @Override
    public String toString() {
        return "Root [form=" + form + ", lateEntry=" + lateEntry + ", roleMappings=" + roleMappings + "]";
    }
}
