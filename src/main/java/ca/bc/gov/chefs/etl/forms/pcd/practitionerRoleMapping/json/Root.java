package ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public String lateEntry;
    public List<Mappings> mappings = new ArrayList<>();
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
    public List<Mappings> getMappings() {
        return mappings;
    }
    public void setMappings(List<Mappings> mappings) {
        this.mappings = mappings;
    }

    @Override
    public String toString() {
        return "Root [form=" + form + ", lateEntry=" + lateEntry + ", mappings=" + mappings + "]";
    }
}
