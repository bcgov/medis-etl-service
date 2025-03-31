package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootDataSubmissionPatientVolumes {
    public List<RootPatientCareItem> unattached;
    public List<RootPatientCareItem> totalPatientVisits;
    public List<RootPatientCareItem> attachedToTheClinic;
    public List<RootPatientCareItem> attachedNotToTheClinic;

    public String unattachedYtd;
    public String attachedToTheClinicYtd;
    public String attachedNotToTheClinicYtd;

    public List<RootPatientCareItem> getUnattached() {
        return unattached;
    }

    public void setUnattached(List<RootPatientCareItem> unattached) {
        this.unattached = unattached;
    }

    public List<RootPatientCareItem> getTotalPatientVisits() {
        return totalPatientVisits;
    }

    public void setTotalPatientVisits(List<RootPatientCareItem> totalPatientVisits) {
        this.totalPatientVisits = totalPatientVisits;
    }

    public List<RootPatientCareItem> getAttachedToTheClinic() {
        return attachedToTheClinic;
    }

    public void setAttachedToTheClinic(List<RootPatientCareItem> attachedToTheClinic) {
        this.attachedToTheClinic = attachedToTheClinic;
    }

    public List<RootPatientCareItem> getAttachedNotToTheClinic() {
        return attachedNotToTheClinic;
    }

    public void setAttachedNotToTheClinic(List<RootPatientCareItem> attachedNotToTheClinic) {
        this.attachedNotToTheClinic = attachedNotToTheClinic;
    }

    public String getUnattachedYtd() {
        return unattachedYtd;
    }

    public void setUnattachedYtd(String unattachedYtd) {
        this.unattachedYtd = unattachedYtd;
    }

    public String getAttachedToTheClinicYtd() {
        return attachedToTheClinicYtd;
    }

    public void setAttachedToTheClinicYtd(String attachedToTheClinicYtd) {
        this.attachedToTheClinicYtd = attachedToTheClinicYtd;
    }

    public String getAttachedNotToTheClinicYtd() {
        return attachedNotToTheClinicYtd;
    }

    public void setAttachedNotToTheClinicYtd(String attachedNotToTheClinicYtd) {
        this.attachedNotToTheClinicYtd = attachedNotToTheClinicYtd;
    }

    @Override
    public String toString() {
        return "RootDataSubmissionPatientVolumes [unattached=" + unattached + ", totalPatientVisits="
                + totalPatientVisits + ", attachedToTheClinic=" + attachedToTheClinic + ", attachedNotToTheClinic="
                + attachedNotToTheClinic + ", unattachedYtd=" + unattachedYtd + ", attachedToTheClinicYtd="
                + attachedToTheClinicYtd + ", attachedNotToTheClinicYtd=" + attachedNotToTheClinicYtd + "]";
    }
}
