package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CHC {
    public String chcName;
    public String chcNameId;

    public String getChcName() {
        return chcName;
    }

    public void setChcName(String chcName) {
        this.chcName = chcName;
    }

    public String getChcNameId() {
        return chcNameId;
    }

    public void setChcNameId(String chcNameId) {
        this.chcNameId = chcNameId;
    }
}
