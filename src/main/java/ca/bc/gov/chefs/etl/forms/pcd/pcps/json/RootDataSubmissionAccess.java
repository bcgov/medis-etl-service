package ca.bc.gov.chefs.etl.forms.pcd.pcps.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootDataSubmissionAccess {
  @Override
  public String toString() {
    return "RootDataSubmissionAccess [uniquePatients=" + uniquePatients + ", uniquePatientSinceOpening="
        + uniquePatientSinceOpening + "]";
  }
  public List<RootPatientCareItem> uniquePatients;
  public List<RootPatientCareItem> uniquePatientSinceOpening;
  public List<RootPatientCareItem> getUniquePatients() {
    return uniquePatients;
  }
  public void setUniquePatients(List<RootPatientCareItem> uniquePatients) {
    this.uniquePatients = uniquePatients;
  }
  public List<RootPatientCareItem> getUniquePatientSinceOpening() {
    return uniquePatientSinceOpening;
  }
  public void setUniquePatientSinceOpening(List<RootPatientCareItem> uniquePatientSinceOpening) {
    this.uniquePatientSinceOpening = uniquePatientSinceOpening;
  }
}
