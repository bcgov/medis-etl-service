package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NPPCC {
    public String nppccName;
    public List<Clinic> nppccClinic;
    public String getNppccName() {
        return nppccName;
    }
    public void setNppccName(String nppccName) {
        this.nppccName = nppccName;
    }
    public List<Clinic> getNppccClinic() {
        return nppccClinic;
    }
    public void setNppccClinic(List<Clinic> nppccClinic) {
        this.nppccClinic = nppccClinic;
    }
}
