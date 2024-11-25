package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PCPSUpccSubmissionData implements IModel {
    private String submissionId;
    private String pcPatientServicesRecordId;
    private String periodForDataEntry;
    private String uniquePatients;
    private String uniquePatientsSinceOpen;
    private String uniquePatientsWithoutMsp;
    private String pvAttachedToClinic;
    private String pvAttachedNotToClinic;
    private String pvUnattached;
    private String patientEncFp;
    private String patientEncNp;
    private String patientEncRn;
    private String patientEncLpn;
    private String patientEncOther;
    private String patientEncVirtually;
    private String patientEncOutsideBusHrs;
    private String accessNotes;
    private String patientVolumesNotes;
    private String teamBasedCareServiceNotes;

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

    public String getUniquePatientsWithoutMsp() {
        return uniquePatientsWithoutMsp;
    }

    public void setUniquePatientsWithoutMsp(String uniquePatientsWithoutMsp) {
        this.uniquePatientsWithoutMsp = uniquePatientsWithoutMsp;
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

    public String getPatientEncFp() {
        return patientEncFp;
    }

    public void setPatientEncFp(String patientEncFp) {
        this.patientEncFp = patientEncFp;
    }

    public String getPatientEncNp() {
        return patientEncNp;
    }

    public void setPatientEncNp(String patientEncNp) {
        this.patientEncNp = patientEncNp;
    }

    public String getPatientEncRn() {
        return patientEncRn;
    }

    public void setPatientEncRn(String patientEncRn) {
        this.patientEncRn = patientEncRn;
    }

    public String getPatientEncLpn() {
        return patientEncLpn;
    }

    public void setPatientEncLpn(String patientEncLpn) {
        this.patientEncLpn = patientEncLpn;
    }

    public String getPatientEncOther() {
        return patientEncOther;
    }

    public void setPatientEncOther(String patientEncOther) {
        this.patientEncOther = patientEncOther;
    }

    public String getPatientEncVirtually() {
        return patientEncVirtually;
    }

    public void setPatientEncVirtually(String patientEncVirtually) {
        this.patientEncVirtually = patientEncVirtually;
    }

    public String getPatientEncOutsideBusHrs() {
        return patientEncOutsideBusHrs;
    }

    public void setPatientEncOutsideBusHrs(String patientEncOutsideBusHrs) {
        this.patientEncOutsideBusHrs = patientEncOutsideBusHrs;
    }

    public String getAccessNotes() {
        return accessNotes;
    }

    public void setAccessNotes(String accessNotes) {
        this.accessNotes = accessNotes;
    }

    public String getPatientVolumesNotes() {
        return patientVolumesNotes;
    }

    public void setPatientVolumesNotes(String patientVolumesNotes) {
        this.patientVolumesNotes = patientVolumesNotes;
    }

    public String getTeamBasedCareServiceNotes() {
        return teamBasedCareServiceNotes;
    }

    public void setTeamBasedCareServiceNotes(String teamBasedCareServiceNotes) {
        this.teamBasedCareServiceNotes = teamBasedCareServiceNotes;
    }

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
        elements.add(uniquePatientsWithoutMsp);
        elements.add(pvAttachedToClinic);
        elements.add(pvAttachedNotToClinic);
        elements.add(pvUnattached);
        elements.add(patientEncFp);
        elements.add(patientEncNp);
        elements.add(patientEncRn);
        elements.add(patientEncLpn);
        elements.add(patientEncOther);
        elements.add(patientEncVirtually);
        elements.add(patientEncOutsideBusHrs);
        elements.add(accessNotes);
        elements.add(patientVolumesNotes);
        elements.add(teamBasedCareServiceNotes);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "PCPSUpccSubmissionData [submissionId=" + submissionId + ", pcPatientServicesRecordId="
                + pcPatientServicesRecordId + ", periodForDataEntry=" + periodForDataEntry + ", uniquePatients="
                + uniquePatients + ", uniquePatientsSinceOpen=" + uniquePatientsSinceOpen
                + ", uniquePatientsWithoutMsp=" + uniquePatientsWithoutMsp + ", pvAttachedToClinic="
                + pvAttachedToClinic + ", pvAttachedNotToClinic=" + pvAttachedNotToClinic + ", pvUnattached="
                + pvUnattached + ", patientEncFp=" + patientEncFp + ", patientEncNp=" + patientEncNp + ", patientEncRn="
                + patientEncRn + ", patientEncLpn=" + patientEncLpn + ", patientEncOther=" + patientEncOther
                + ", patientEncVirtually=" + patientEncVirtually + ", patientEncOutsideBusHrs="
                + patientEncOutsideBusHrs + ", accessNotes=" + accessNotes + ", patientVolumesNotes="
                + patientVolumesNotes + ", teamBasedCareServiceNotes=" + teamBasedCareServiceNotes + "]";
    }

}
