package ca.bc.gov.chefs.etl.forms.pda.facilityMapping.json;

public class FacilityMapping {
    private String facilityValue;
    private String facilityId;

    public String getFacilityValue() {
        return facilityValue;
    }

    public void setFacilityValue(String facilityValue) {
        this.facilityValue = facilityValue;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public String toString() {
        return "FacilityMapping [facilityValue=" + facilityValue + ", facilityId=" + facilityId + "]";
    }
}
