package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UPCC {
    public String upccName;
    public String typeOfCare;
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
}
