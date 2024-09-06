package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CHC {
    public String chcName;

    public String getChcName() {
        return chcName;
    }

    public void setChcName(String chcName) {
        this.chcName = chcName;
    }
}
