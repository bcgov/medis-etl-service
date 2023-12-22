package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CHC {
    public String chcName;
    public List<Clinic> chcClinic;
    public String getChcName() {
        return chcName;
    }
    public void setChcName(String chcName) {
        this.chcName = chcName;
    }
    public List<Clinic> getChcClinic() {
        return chcClinic;
    }
    public void setChcClinic(List<Clinic> chcClinic) {
        this.chcClinic = chcClinic;
    }
}
