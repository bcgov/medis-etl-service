package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootDataSubmissionAccess {
    private List<RootPatientCareItem> uniquePatients;
    private List<RootPatientCareItem> uniquePatientSinceOpening1;
    private List<RootPatientCareItem> uniquePatientsWithoutMsp;

    private String totalUniquePatients;
    private String totalUniquePatientsWithoutMsp;

    public List<RootPatientCareItem> getUniquePatients() {
        return uniquePatients;
    }

    public void setUniquePatients(List<RootPatientCareItem> uniquePatients) {
        this.uniquePatients = uniquePatients;
    }

    public List<RootPatientCareItem> getUniquePatientSinceOpening1() {
        return uniquePatientSinceOpening1;
    }

    public void setUniquePatientSinceOpening1(List<RootPatientCareItem> uniquePatientSinceOpening1) {
        this.uniquePatientSinceOpening1 = uniquePatientSinceOpening1;
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
        return "RootDataSubmissionAccess [uniquePatients=" + uniquePatients + ", uniquePatientSinceOpening1="
                + uniquePatientSinceOpening1 + ", uniquePatientsWithoutMsp=" + uniquePatientsWithoutMsp
                + ", totalUniquePatients=" + totalUniquePatients + ", totalUniquePatientsWithoutMsp="
                + totalUniquePatientsWithoutMsp + "]";
    }
}
