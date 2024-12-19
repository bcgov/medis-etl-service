package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NPPCC {
    public String nppccName;
    public String nppccNameId;

    public String getNppccName() {
        return nppccName;
    }

    public void setNppccName(String nppccName) {
        this.nppccName = nppccName;
    }

    public String getNppccNameId() {
        return nppccNameId;
    }

    public void setNppccNameId(String nppccNameId) {
        this.nppccNameId = nppccNameId;
    }
}
