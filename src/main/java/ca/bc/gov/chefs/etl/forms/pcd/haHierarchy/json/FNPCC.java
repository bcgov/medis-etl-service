package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FNPCC {
    public String fnpccName;
    public String getFnpccName() {
        return fnpccName;
    }
    public void setFnpccName(String fnpccName) {
        this.fnpccName = fnpccName;
    }
}
