package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FNPCC {
    public String fnpccName;
    public String fnpccNameId;

    public String getFnpccName() {
        return fnpccName;
    }

    public void setFnpccName(String fnpccName) {
        this.fnpccName = fnpccName;
    }

    public String getFnpccNameId() {
        return fnpccNameId;
    }

    public void setFnpccNameId(String fnpccNameId) {
        this.fnpccNameId = fnpccNameId;
    }
}
