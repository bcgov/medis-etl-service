package ca.bc.gov.chefs.etl.forms.pda.facilityMapping.json;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Form form;
    private String lateEntry;
    private List<FacilityMapping> facilityMapping = new ArrayList<>();

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

    public List<FacilityMapping> getFacilityMapping() {
        return facilityMapping;
    }

    public void setFacilityMapping(List<FacilityMapping> facilityMapping) {
        this.facilityMapping = facilityMapping;
    }

    @Override
    public String toString() {
        return "Root [form=" + form + ", lateEntry=" + lateEntry + ", facilityMapping=" + facilityMapping + "]";
    }
}
