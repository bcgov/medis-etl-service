package ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootDataSubmissionTeamBasedCare {
    public List<RootPatientCareItem> deliveredVirtually;
    public List<RootPatientCareItem> patientEncountersFp;
    public List<RootPatientCareItem> patientEncountersNp;
    public List<RootPatientCareItem> patientEncountersRn;
    public List<RootPatientCareItem> outsideBusinessHours;
    public List<RootPatientCareItem> patientEncountersLpn;
    public List<RootPatientCareItem> patientEncountersOther;
    public List<RootPatientCareItem> totalPatientEncounters;

    public String deliveredVirtuallyYtd;
    public String patientEncountersFpYtd;
    public String patientEncountersNpYtd;
    public String patientEncountersRnYtd;
    public String outsideBusinessHoursYtd;
    public String patientEncountersLpnYtd;
    public String patientEncountersOtherYtd;
    public String patientEncountersGrandTotal;

    public List<RootPatientCareItem> getDeliveredVirtually() {
        return deliveredVirtually;
    }

    public void setDeliveredVirtually(List<RootPatientCareItem> deliveredVirtually) {
        this.deliveredVirtually = deliveredVirtually;
    }

    public List<RootPatientCareItem> getPatientEncountersFp() {
        return patientEncountersFp;
    }

    public void setPatientEncountersFp(List<RootPatientCareItem> patientEncountersFp) {
        this.patientEncountersFp = patientEncountersFp;
    }

    public List<RootPatientCareItem> getPatientEncountersNp() {
        return patientEncountersNp;
    }

    public void setPatientEncountersNp(List<RootPatientCareItem> patientEncountersNp) {
        this.patientEncountersNp = patientEncountersNp;
    }

    public List<RootPatientCareItem> getPatientEncountersRn() {
        return patientEncountersRn;
    }

    public void setPatientEncountersRn(List<RootPatientCareItem> patientEncountersRn) {
        this.patientEncountersRn = patientEncountersRn;
    }

    public List<RootPatientCareItem> getOutsideBusinessHours() {
        return outsideBusinessHours;
    }

    public void setOutsideBusinessHours(List<RootPatientCareItem> outsideBusinessHours) {
        this.outsideBusinessHours = outsideBusinessHours;
    }

    public List<RootPatientCareItem> getPatientEncountersLpn() {
        return patientEncountersLpn;
    }

    public void setPatientEncountersLpn(List<RootPatientCareItem> patientEncountersLpn) {
        this.patientEncountersLpn = patientEncountersLpn;
    }

    public List<RootPatientCareItem> getPatientEncountersOther() {
        return patientEncountersOther;
    }

    public void setPatientEncountersOther(List<RootPatientCareItem> patientEncountersOther) {
        this.patientEncountersOther = patientEncountersOther;
    }

    public List<RootPatientCareItem> getTotalPatientEncounters() {
        return totalPatientEncounters;
    }

    public void setTotalPatientEncounters(List<RootPatientCareItem> totalPatientEncounters) {
        this.totalPatientEncounters = totalPatientEncounters;
    }

    public String getDeliveredVirtuallyYtd() {
        return deliveredVirtuallyYtd;
    }

    public void setDeliveredVirtuallyYtd(String deliveredVirtuallyYtd) {
        this.deliveredVirtuallyYtd = deliveredVirtuallyYtd;
    }

    public String getPatientEncountersFpYtd() {
        return patientEncountersFpYtd;
    }

    public void setPatientEncountersFpYtd(String patientEncountersFpYtd) {
        this.patientEncountersFpYtd = patientEncountersFpYtd;
    }

    public String getPatientEncountersNpYtd() {
        return patientEncountersNpYtd;
    }

    public void setPatientEncountersNpYtd(String patientEncountersNpYtd) {
        this.patientEncountersNpYtd = patientEncountersNpYtd;
    }

    public String getPatientEncountersRnYtd() {
        return patientEncountersRnYtd;
    }

    public void setPatientEncountersRnYtd(String patientEncountersRnYtd) {
        this.patientEncountersRnYtd = patientEncountersRnYtd;
    }

    public String getOutsideBusinessHoursYtd() {
        return outsideBusinessHoursYtd;
    }

    public void setOutsideBusinessHoursYtd(String outsideBusinessHoursYtd) {
        this.outsideBusinessHoursYtd = outsideBusinessHoursYtd;
    }

    public String getPatientEncountersLpnYtd() {
        return patientEncountersLpnYtd;
    }

    public void setPatientEncountersLpnYtd(String patientEncountersLpnYtd) {
        this.patientEncountersLpnYtd = patientEncountersLpnYtd;
    }

    public String getPatientEncountersOtherYtd() {
        return patientEncountersOtherYtd;
    }

    public void setPatientEncountersOtherYtd(String patientEncountersOtherYtd) {
        this.patientEncountersOtherYtd = patientEncountersOtherYtd;
    }

    public String getPatientEncountersGrandTotal() {
        return patientEncountersGrandTotal;
    }

    public void setPatientEncountersGrandTotal(String patientEncountersGrandTotal) {
        this.patientEncountersGrandTotal = patientEncountersGrandTotal;
    }

    @Override
    public String toString() {
        return "RootDataSubmissionTeamBasedCare [deliveredVirtually=" + deliveredVirtually + ", patientEncountersFp="
                + patientEncountersFp + ", patientEncountersNp=" + patientEncountersNp + ", patientEncountersRn="
                + patientEncountersRn + ", outsideBusinessHours=" + outsideBusinessHours + ", patientEncountersLpn="
                + patientEncountersLpn + ", patientEncountersOther=" + patientEncountersOther
                + ", totalPatientEncounters=" + totalPatientEncounters + ", deliveredVirtuallyYtd="
                + deliveredVirtuallyYtd + ", patientEncountersFpYtd=" + patientEncountersFpYtd
                + ", patientEncountersNpYtd=" + patientEncountersNpYtd + ", patientEncountersRnYtd="
                + patientEncountersRnYtd + ", outsideBusinessHoursYtd=" + outsideBusinessHoursYtd
                + ", patientEncountersLpnYtd=" + patientEncountersLpnYtd + ", patientEncountersOtherYtd="
                + patientEncountersOtherYtd + ", patientEncountersGrandTotal=" + patientEncountersGrandTotal + "]";
    }
}
