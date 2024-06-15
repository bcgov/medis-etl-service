package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PCPSUpccSubmissionData implements IModel {
  @Override
  public String toString() {
    return "PCPSSubmissionData [submissionId=" + submissionId + ", pcPatientServicesRecordId="
        + pcPatientServicesRecordId + ", periodForDataEntry=" + periodForDataEntry + ", uniquePatients="
        + uniquePatients + ", uniquePatientsSinceOpen=" + uniquePatientsSinceOpen + ", pvAttachedToClinic="
        + pvAttachedToClinic + ", pvAttachedNotToClinic=" + pvAttachedNotToClinic + ", pvUnattached=" + pvUnattached
        + ", pvVirtuallyPrac=" + peVirtuallyPrac + ", peDuringBusHrsPrac=" + peDuringBusHrsPrac
        + ", peOutsideBusHrsPrac=" + peOutsideBusHrsPrac + ", peVirtuallyNonPrac=" + peVirtuallyNonPrac
        + ", peDuringBusHrsNonPrac=" + peDuringBusHrsNonPrac + ", peOutsideBusHrsNonPrac=" + peOutsideBusHrsNonPrac
        + "]";
  }

  private String submissionId;
  private String pcPatientServicesRecordId;
  private String periodForDataEntry;
  private String uniquePatients;
  private String uniquePatientsSinceOpen;
  private String pvAttachedToClinic;
  private String pvAttachedNotToClinic;
  private String pvUnattached;
  private String peVirtuallyPrac;
  private String peDuringBusHrsPrac;
  private String peOutsideBusHrsPrac;
  private String peVirtuallyNonPrac;
  private String peDuringBusHrsNonPrac;
  private String peOutsideBusHrsNonPrac;

  @Override
  public String getFileName() {
    return null;
  }

  @Override
  public String getFormType() {
    return PCDConstants.PC_PATIENT_SERVICES_UPCC_DATA;
  }

  @Override
  public List<String> getCsvElements() {
    List<String> elements = new ArrayList<String>();

    elements.add(submissionId);
    elements.add(pcPatientServicesRecordId);
    elements.add(periodForDataEntry);
    elements.add(uniquePatients);
    elements.add(uniquePatientsSinceOpen);
    elements.add(pvAttachedToClinic);
    elements.add(pvAttachedNotToClinic);
    elements.add(pvUnattached);
    elements.add(peVirtuallyPrac);
    elements.add(peDuringBusHrsPrac);
    elements.add(peOutsideBusHrsPrac);
    elements.add(peVirtuallyNonPrac);
    elements.add(peDuringBusHrsNonPrac);
    elements.add(peOutsideBusHrsNonPrac);

    return elements;
  }

  @Override
  public List<IModel> getObjects() {
    return new ArrayList<>();
  }

  public String getSubmissionId() {
    return submissionId;
  }

  public void setSubmissionId(String submissionId) {
    this.submissionId = submissionId;
  }

  public String getPcPatientServicesRecordId() {
    return pcPatientServicesRecordId;
  }

  public void setPcPatientServicesRecordId(String pcPatientServicesRecordId) {
    this.pcPatientServicesRecordId = pcPatientServicesRecordId;
  }

  public String getPeriodForDataEntry() {
    return periodForDataEntry;
  }

  public void setPeriodForDataEntry(String periodForDataEntry) {
    this.periodForDataEntry = periodForDataEntry;
  }

  public String getUniquePatients() {
    return uniquePatients;
  }

  public void setUniquePatients(String uniquePatients) {
    this.uniquePatients = uniquePatients;
  }

  public String getUniquePatientsSinceOpen() {
    return uniquePatientsSinceOpen;
  }

  public void setUniquePatientsSinceOpen(String uniquePatientsSinceOpen) {
    this.uniquePatientsSinceOpen = uniquePatientsSinceOpen;
  }

  public String getPvAttachedToClinic() {
    return pvAttachedToClinic;
  }

  public void setPvAttachedToClinic(String pvAttachedToClinic) {
    this.pvAttachedToClinic = pvAttachedToClinic;
  }

  public String getPvAttachedNotToClinic() {
    return pvAttachedNotToClinic;
  }

  public void setPvAttachedNotToClinic(String pvAttachedNotToClinic) {
    this.pvAttachedNotToClinic = pvAttachedNotToClinic;
  }

  public String getPvUnattached() {
    return pvUnattached;
  }

  public void setPvUnattached(String pvUnattached) {
    this.pvUnattached = pvUnattached;
  }

  public String getPeVirtuallyPrac() {
    return peVirtuallyPrac;
  }

  public void setPeVirtuallyPrac(String peVirtuallyPrac) {
    this.peVirtuallyPrac = peVirtuallyPrac;
  }

  public String getPeDuringBusHrsPrac() {
    return peDuringBusHrsPrac;
  }

  public void setPeDuringBusHrsPrac(String peDuringBusHrsPrac) {
    this.peDuringBusHrsPrac = peDuringBusHrsPrac;
  }

  public String getPeOutsideBusHrsPrac() {
    return peOutsideBusHrsPrac;
  }

  public void setPeOutsideBusHrsPrac(String peOutsideBusHrsPrac) {
    this.peOutsideBusHrsPrac = peOutsideBusHrsPrac;
  }

  public String getPeVirtuallyNonPrac() {
    return peVirtuallyNonPrac;
  }

  public void setPeVirtuallyNonPrac(String peVirtuallyNonPrac) {
    this.peVirtuallyNonPrac = peVirtuallyNonPrac;
  }

  public String getPeDuringBusHrsNonPrac() {
    return peDuringBusHrsNonPrac;
  }

  public void setPeDuringBusHrsNonPrac(String peDuringBusHrsNonPrac) {
    this.peDuringBusHrsNonPrac = peDuringBusHrsNonPrac;
  }

  public String getPeOutsideBusHrsNonPrac() {
    return peOutsideBusHrsNonPrac;
  }

  public void setPeOutsideBusHrsNonPrac(String peOutsideBusHrsNonPrac) {
    this.peOutsideBusHrsNonPrac = peOutsideBusHrsNonPrac;
  }
}
