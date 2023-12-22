package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClinicData {
    public String clinicName;
    public String clinicType;

    public String getClinicName() {
        return clinicName;
    }
    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
    public String getClinicType() {
        return clinicType;
    }
    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }
}
