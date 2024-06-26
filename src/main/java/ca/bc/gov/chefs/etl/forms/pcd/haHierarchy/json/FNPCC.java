package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FNPCC {
    public String fnpccName;
    public List<ClinicData> fnpccClinic;
    public String getFnpccName() {
        return fnpccName;
    }
    public void setFnpccName(String fnpccName) {
        this.fnpccName = fnpccName;
    }
    public List<ClinicData> getFnpccClinic() {
        return fnpccClinic;
    }
    public void setFnpccClinic(List<ClinicData> fnpccClinic) {
        this.fnpccClinic = fnpccClinic;
    }
}
