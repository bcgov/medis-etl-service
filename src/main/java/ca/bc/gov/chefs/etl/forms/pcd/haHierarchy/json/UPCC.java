package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UPCC {
    public String upccName;
    public String typeOfCare;
    public List<ClinicData> upccClinic;
    public String getUpccName() {
        return upccName;
    }
    public void setUpccName(String upccName) {
        this.upccName = upccName;
    }
    public String getTypeOfCare() {
        return typeOfCare;
    }
    public void setTypeOfCare(String typeOfCare) {
        this.typeOfCare = typeOfCare;
    }
    public List<ClinicData> getUpccClinic() {
        return upccClinic;
    }
    public void setUpccClinic(List<ClinicData> upccClinic) {
        this.upccClinic = upccClinic;
    }
}
