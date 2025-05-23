package ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootDataSubmissionAccess {
    public List<RootPatientCareItem> uniquePatients;
    public List<RootPatientCareItem> uniquePatientsWithoutMsp;

    public String totalUniquePatients;
    public String totalUniquePatientsWithoutMsp;

    public List<RootPatientCareItem> getUniquePatients() {
        return uniquePatients;
    }

    public void setUniquePatients(List<RootPatientCareItem> uniquePatients) {
        this.uniquePatients = uniquePatients;
    }

    public List<RootPatientCareItem> getUniquePatientsWithoutMsp() {
        return uniquePatientsWithoutMsp;
    }

    public void setUniquePatientsWithoutMsp(List<RootPatientCareItem> uniquePatientsWithoutMsp) {
        this.uniquePatientsWithoutMsp = uniquePatientsWithoutMsp;
    }

    public String getTotalUniquePatients() {
        return totalUniquePatients;
    }

    public void setTotalUniquePatients(String totalUniquePatients) {
        this.totalUniquePatients = totalUniquePatients;
    }

    public String getTotalUniquePatientsWithoutMsp() {
        return totalUniquePatientsWithoutMsp;
    }

    public void setTotalUniquePatientsWithoutMsp(String totalUniquePatientsWithoutMsp) {
        this.totalUniquePatientsWithoutMsp = totalUniquePatientsWithoutMsp;
    }

    @Override
    public String toString() {
        return "RootDataSubmissionAccess [uniquePatients=" + uniquePatients + ", uniquePatientsWithoutMsp="
                + uniquePatientsWithoutMsp
                + ", totalUniquePatients=" + totalUniquePatients + ", totalUniquePatientsWithoutMsp="
                + totalUniquePatientsWithoutMsp + "]";
    }
}
