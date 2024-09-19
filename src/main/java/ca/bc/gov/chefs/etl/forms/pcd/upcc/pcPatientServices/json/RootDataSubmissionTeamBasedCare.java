package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootDataSubmissionTeamBasedCare {
    public List<RootPatientCareItem> deliveredVirtuallyPrac;
    public List<RootPatientCareItem> totalPatientEncounters;
    public List<RootPatientCareItem> duringBusinessHoursPrac;
    public List<RootPatientCareItem> outsideBusinessHoursPrac;
    public List<RootPatientCareItem> deliveredVirtuallyNonPrac;
    public List<RootPatientCareItem> duringBusinessHoursNonPrac;
    public List<RootPatientCareItem> outsideBusinessHoursNonPrac;
    public List<RootPatientCareItem> patientEncountersPracSubtotals;
    public List<RootPatientCareItem> patientEncountersNonPracSubtotals;

    public List<RootPatientCareItem> getDeliveredVirtuallyPrac() {
        return deliveredVirtuallyPrac;
    }

    public void setDeliveredVirtuallyPrac(List<RootPatientCareItem> deliveredVirtuallyPrac) {
        this.deliveredVirtuallyPrac = deliveredVirtuallyPrac;
    }

    public List<RootPatientCareItem> getTotalPatientEncounters() {
        return totalPatientEncounters;
    }

    public void setTotalPatientEncounters(List<RootPatientCareItem> totalPatientEncounters) {
        this.totalPatientEncounters = totalPatientEncounters;
    }

    public List<RootPatientCareItem> getDuringBusinessHoursPrac() {
        return duringBusinessHoursPrac;
    }

    public void setDuringBusinessHoursPrac(List<RootPatientCareItem> duringBusinessHoursPrac) {
        this.duringBusinessHoursPrac = duringBusinessHoursPrac;
    }

    public List<RootPatientCareItem> getOutsideBusinessHoursPrac() {
        return outsideBusinessHoursPrac;
    }

    public void setOutsideBusinessHoursPrac(List<RootPatientCareItem> outsideBusinessHoursPrac) {
        this.outsideBusinessHoursPrac = outsideBusinessHoursPrac;
    }

    public List<RootPatientCareItem> getDeliveredVirtuallyNonPrac() {
        return deliveredVirtuallyNonPrac;
    }

    public void setDeliveredVirtuallyNonPrac(List<RootPatientCareItem> deliveredVirtuallyNonPrac) {
        this.deliveredVirtuallyNonPrac = deliveredVirtuallyNonPrac;
    }

    public List<RootPatientCareItem> getDuringBusinessHoursNonPrac() {
        return duringBusinessHoursNonPrac;
    }

    public void setDuringBusinessHoursNonPrac(List<RootPatientCareItem> duringBusinessHoursNonPrac) {
        this.duringBusinessHoursNonPrac = duringBusinessHoursNonPrac;
    }

    public List<RootPatientCareItem> getOutsideBusinessHoursNonPrac() {
        return outsideBusinessHoursNonPrac;
    }

    public void setOutsideBusinessHoursNonPrac(List<RootPatientCareItem> outsideBusinessHoursNonPrac) {
        this.outsideBusinessHoursNonPrac = outsideBusinessHoursNonPrac;
    }

    public List<RootPatientCareItem> getPatientEncountersPracSubtotals() {
        return patientEncountersPracSubtotals;
    }

    public void setPatientEncountersPracSubtotals(List<RootPatientCareItem> patientEncountersPracSubtotals) {
        this.patientEncountersPracSubtotals = patientEncountersPracSubtotals;
    }

    public List<RootPatientCareItem> getPatientEncountersNonPracSubtotals() {
        return patientEncountersNonPracSubtotals;
    }

    public void setPatientEncountersNonPracSubtotals(List<RootPatientCareItem> patientEncountersNonPracSubtotals) {
        this.patientEncountersNonPracSubtotals = patientEncountersNonPracSubtotals;
    }

    @Override
    public String toString() {
        return "RootDataSubmissionTeamBasedCare [deliveredVirtuallyPrac=" + deliveredVirtuallyPrac
                + ", totalPatientEncounters=" + totalPatientEncounters + ", duringBusinessHoursPrac="
                + duringBusinessHoursPrac
                + ", outsideBusinessHoursPrac=" + outsideBusinessHoursPrac + ", deliveredVirtuallyNonPrac="
                + deliveredVirtuallyNonPrac + ", duringBusinessHoursNonPrac=" + duringBusinessHoursNonPrac
                + ", outsideBusinessHoursNonPrac=" + outsideBusinessHoursNonPrac + ", patientEncountersPracSubtotals="
                + patientEncountersPracSubtotals + ", patientEncountersNonPracSubtotals="
                + patientEncountersNonPracSubtotals
                + "]";
    }
}
