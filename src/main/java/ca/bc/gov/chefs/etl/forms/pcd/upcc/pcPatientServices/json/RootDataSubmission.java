package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootDataSubmission {
    private RootDataSubmissionAccess access;
    private RootDataSubmissionPatientVolumes patientVolumes;
    private RootDataSubmissionTeamBasedCare teamBasedCareService;
    private String accessNotes;
    private String submissionNotes;
    private String ftesHiredToDateFp;
    private String ftesHiredToDateNp;
    private String ftesHiredToDateRn;
    private String ftesHiredToDateLpn;
    private String patientVolumesNotes;
    private String ftesHiredToDateOther;
    private String currentApprovedFtEsFp;
    private String currentApprovedFtEsNp;
    private String currentApprovedFtEsRn;
    private String currentApprovedFtEsLpn;
    private String currentApprovedFtEsOther;
    private String teamBasedCareServiceNotes;

    // Repeating fields
    private String unattachedP1;
    private String uniquePatientsP1;
    private String deliveredVirtuallyP1;
    private String attachedToTheClinicP1;
    private String patientEncountersFpP1;
    private String patientEncountersNpP1;
    private String patientEncountersRnP1;
    private String outsideBusinessHoursP1;
    private String patientEncountersLpnP1;
    private String attachedNotToTheClinicP1;
    private String patientEncountersOtherP1;
    private String uniquePatientsWithoutMspP1;
    private String uniquePatientsSinceOpeningP1;

    private String unattachedP2;
    private String uniquePatientsP2;
    private String deliveredVirtuallyP2;
    private String attachedToTheClinicP2;
    private String patientEncountersFpP2;
    private String patientEncountersNpP2;
    private String patientEncountersRnP2;
    private String outsideBusinessHoursP2;
    private String patientEncountersLpnP2;
    private String attachedNotToTheClinicP2;
    private String patientEncountersOtherP2;
    private String uniquePatientsWithoutMspP2;
    private String uniquePatientsSinceOpeningP2;

    private String unattachedP3;
    private String uniquePatientsP3;
    private String deliveredVirtuallyP3;
    private String attachedToTheClinicP3;
    private String patientEncountersFpP3;
    private String patientEncountersNpP3;
    private String patientEncountersRnP3;
    private String outsideBusinessHoursP3;
    private String patientEncountersLpnP3;
    private String attachedNotToTheClinicP3;
    private String patientEncountersOtherP3;
    private String uniquePatientsWithoutMspP3;
    private String uniquePatientsSinceOpeningP3;

    private String unattachedP4;
    private String uniquePatientsP4;
    private String deliveredVirtuallyP4;
    private String attachedToTheClinicP4;
    private String patientEncountersFpP4;
    private String patientEncountersNpP4;
    private String patientEncountersRnP4;
    private String outsideBusinessHoursP4;
    private String patientEncountersLpnP4;
    private String attachedNotToTheClinicP4;
    private String patientEncountersOtherP4;
    private String uniquePatientsWithoutMspP4;
    private String uniquePatientsSinceOpeningP4;

    private String unattachedP5;
    private String uniquePatientsP5;
    private String deliveredVirtuallyP5;
    private String attachedToTheClinicP5;
    private String patientEncountersFpP5;
    private String patientEncountersNpP5;
    private String patientEncountersRnP5;
    private String outsideBusinessHoursP5;
    private String patientEncountersLpnP5;
    private String attachedNotToTheClinicP5;
    private String patientEncountersOtherP5;
    private String uniquePatientsWithoutMspP5;
    private String uniquePatientsSinceOpeningP5;

    private String unattachedP6;
    private String uniquePatientsP6;
    private String deliveredVirtuallyP6;
    private String attachedToTheClinicP6;
    private String patientEncountersFpP6;
    private String patientEncountersNpP6;
    private String patientEncountersRnP6;
    private String outsideBusinessHoursP6;
    private String patientEncountersLpnP6;
    private String attachedNotToTheClinicP6;
    private String patientEncountersOtherP6;
    private String uniquePatientsWithoutMspP6;
    private String uniquePatientsSinceOpeningP6;

    private String unattachedP7;
    private String uniquePatientsP7;
    private String deliveredVirtuallyP7;
    private String attachedToTheClinicP7;
    private String patientEncountersFpP7;
    private String patientEncountersNpP7;
    private String patientEncountersRnP7;
    private String outsideBusinessHoursP7;
    private String patientEncountersLpnP7;
    private String attachedNotToTheClinicP7;
    private String patientEncountersOtherP7;
    private String uniquePatientsWithoutMspP7;
    private String uniquePatientsSinceOpeningP7;

    private String unattachedP8;
    private String uniquePatientsP8;
    private String deliveredVirtuallyP8;
    private String attachedToTheClinicP8;
    private String patientEncountersFpP8;
    private String patientEncountersNpP8;
    private String patientEncountersRnP8;
    private String outsideBusinessHoursP8;
    private String patientEncountersLpnP8;
    private String attachedNotToTheClinicP8;
    private String patientEncountersOtherP8;
    private String uniquePatientsWithoutMspP8;
    private String uniquePatientsSinceOpeningP8;

    private String unattachedP9;
    private String uniquePatientsP9;
    private String deliveredVirtuallyP9;
    private String attachedToTheClinicP9;
    private String patientEncountersFpP9;
    private String patientEncountersNpP9;
    private String patientEncountersRnP9;
    private String outsideBusinessHoursP9;
    private String patientEncountersLpnP9;
    private String attachedNotToTheClinicP9;
    private String patientEncountersOtherP9;
    private String uniquePatientsWithoutMspP9;
    private String uniquePatientsSinceOpeningP9;

    private String unattachedP10;
    private String uniquePatientsP10;
    private String deliveredVirtuallyP10;
    private String attachedToTheClinicP10;
    private String patientEncountersFpP10;
    private String patientEncountersNpP10;
    private String patientEncountersRnP10;
    private String outsideBusinessHoursP10;
    private String patientEncountersLpnP10;
    private String attachedNotToTheClinicP10;
    private String patientEncountersOtherP10;
    private String uniquePatientsWithoutMspP10;
    private String uniquePatientsSinceOpeningP10;

    private String unattachedP11;
    private String uniquePatientsP11;
    private String deliveredVirtuallyP11;
    private String attachedToTheClinicP11;
    private String patientEncountersFpP11;
    private String patientEncountersNpP11;
    private String patientEncountersRnP11;
    private String outsideBusinessHoursP11;
    private String patientEncountersLpnP11;
    private String attachedNotToTheClinicP11;
    private String patientEncountersOtherP11;
    private String uniquePatientsWithoutMspP11;
    private String uniquePatientsSinceOpeningP11;

    private String unattachedP12;
    private String uniquePatientsP12;
    private String deliveredVirtuallyP12;
    private String attachedToTheClinicP12;
    private String patientEncountersFpP12;
    private String patientEncountersNpP12;
    private String patientEncountersRnP12;
    private String outsideBusinessHoursP12;
    private String patientEncountersLpnP12;
    private String attachedNotToTheClinicP12;
    private String patientEncountersOtherP12;
    private String uniquePatientsWithoutMspP12;
    private String uniquePatientsSinceOpeningP12;

    private String unattachedP13;
    private String uniquePatientsP13;
    private String deliveredVirtuallyP13;
    private String attachedToTheClinicP13;
    private String patientEncountersFpP13;
    private String patientEncountersNpP13;
    private String patientEncountersRnP13;
    private String outsideBusinessHoursP13;
    private String patientEncountersLpnP13;
    private String attachedNotToTheClinicP13;
    private String patientEncountersOtherP13;
    private String uniquePatientsWithoutMspP13;
    private String uniquePatientsSinceOpeningP13;

    public RootDataSubmissionAccess getAccess() {
        return access;
    }

    public void setAccess(RootDataSubmissionAccess access) {
        this.access = access;
    }

    public RootDataSubmissionPatientVolumes getPatientVolumes() {
        return patientVolumes;
    }

    public void setPatientVolumes(RootDataSubmissionPatientVolumes patientVolumes) {
        this.patientVolumes = patientVolumes;
    }

    public RootDataSubmissionTeamBasedCare getTeamBasedCareService() {
        return teamBasedCareService;
    }

    public void setTeamBasedCareService(RootDataSubmissionTeamBasedCare teamBasedCareService) {
        this.teamBasedCareService = teamBasedCareService;
    }

    public String getAccessNotes() {
        return accessNotes;
    }

    public void setAccessNotes(String accessNotes) {
        this.accessNotes = accessNotes;
    }

    public String getSubmissionNotes() {
        return submissionNotes;
    }

    public void setSubmissionNotes(String submissionNotes) {
        this.submissionNotes = submissionNotes;
    }

    public String getFtesHiredToDateFp() {
        return ftesHiredToDateFp;
    }

    public void setFtesHiredToDateFp(String ftesHiredToDateFp) {
        this.ftesHiredToDateFp = ftesHiredToDateFp;
    }

    public String getFtesHiredToDateNp() {
        return ftesHiredToDateNp;
    }

    public void setFtesHiredToDateNp(String ftesHiredToDateNp) {
        this.ftesHiredToDateNp = ftesHiredToDateNp;
    }

    public String getFtesHiredToDateRn() {
        return ftesHiredToDateRn;
    }

    public void setFtesHiredToDateRn(String ftesHiredToDateRn) {
        this.ftesHiredToDateRn = ftesHiredToDateRn;
    }

    public String getFtesHiredToDateLpn() {
        return ftesHiredToDateLpn;
    }

    public void setFtesHiredToDateLpn(String ftesHiredToDateLpn) {
        this.ftesHiredToDateLpn = ftesHiredToDateLpn;
    }

    public String getPatientVolumesNotes() {
        return patientVolumesNotes;
    }

    public void setPatientVolumesNotes(String patientVolumesNotes) {
        this.patientVolumesNotes = patientVolumesNotes;
    }

    public String getFtesHiredToDateOther() {
        return ftesHiredToDateOther;
    }

    public void setFtesHiredToDateOther(String ftesHiredToDateOther) {
        this.ftesHiredToDateOther = ftesHiredToDateOther;
    }

    public String getCurrentApprovedFtEsFp() {
        return currentApprovedFtEsFp;
    }

    public void setCurrentApprovedFtEsFp(String currentApprovedFtEsFp) {
        this.currentApprovedFtEsFp = currentApprovedFtEsFp;
    }

    public String getCurrentApprovedFtEsNp() {
        return currentApprovedFtEsNp;
    }

    public void setCurrentApprovedFtEsNp(String currentApprovedFtEsNp) {
        this.currentApprovedFtEsNp = currentApprovedFtEsNp;
    }

    public String getCurrentApprovedFtEsRn() {
        return currentApprovedFtEsRn;
    }

    public void setCurrentApprovedFtEsRn(String currentApprovedFtEsRn) {
        this.currentApprovedFtEsRn = currentApprovedFtEsRn;
    }

    public String getCurrentApprovedFtEsLpn() {
        return currentApprovedFtEsLpn;
    }

    public void setCurrentApprovedFtEsLpn(String currentApprovedFtEsLpn) {
        this.currentApprovedFtEsLpn = currentApprovedFtEsLpn;
    }

    public String getCurrentApprovedFtEsOther() {
        return currentApprovedFtEsOther;
    }

    public void setCurrentApprovedFtEsOther(String currentApprovedFtEsOther) {
        this.currentApprovedFtEsOther = currentApprovedFtEsOther;
    }

    public String getTeamBasedCareServiceNotes() {
        return teamBasedCareServiceNotes;
    }

    public void setTeamBasedCareServiceNotes(String teamBasedCareServiceNotes) {
        this.teamBasedCareServiceNotes = teamBasedCareServiceNotes;
    }

    public String getUnattachedP1() {
        return unattachedP1;
    }

    public void setUnattachedP1(String unattachedP1) {
        this.unattachedP1 = unattachedP1;
    }

    public String getUniquePatientsP1() {
        return uniquePatientsP1;
    }

    public void setUniquePatientsP1(String uniquePatientsP1) {
        this.uniquePatientsP1 = uniquePatientsP1;
    }

    public String getDeliveredVirtuallyP1() {
        return deliveredVirtuallyP1;
    }

    public void setDeliveredVirtuallyP1(String deliveredVirtuallyP1) {
        this.deliveredVirtuallyP1 = deliveredVirtuallyP1;
    }

    public String getAttachedToTheClinicP1() {
        return attachedToTheClinicP1;
    }

    public void setAttachedToTheClinicP1(String attachedToTheClinicP1) {
        this.attachedToTheClinicP1 = attachedToTheClinicP1;
    }

    public String getPatientEncountersFpP1() {
        return patientEncountersFpP1;
    }

    public void setPatientEncountersFpP1(String patientEncountersFpP1) {
        this.patientEncountersFpP1 = patientEncountersFpP1;
    }

    public String getPatientEncountersNpP1() {
        return patientEncountersNpP1;
    }

    public void setPatientEncountersNpP1(String patientEncountersNpP1) {
        this.patientEncountersNpP1 = patientEncountersNpP1;
    }

    public String getPatientEncountersRnP1() {
        return patientEncountersRnP1;
    }

    public void setPatientEncountersRnP1(String patientEncountersRnP1) {
        this.patientEncountersRnP1 = patientEncountersRnP1;
    }

    public String getOutsideBusinessHoursP1() {
        return outsideBusinessHoursP1;
    }

    public void setOutsideBusinessHoursP1(String outsideBusinessHoursP1) {
        this.outsideBusinessHoursP1 = outsideBusinessHoursP1;
    }

    public String getPatientEncountersLpnP1() {
        return patientEncountersLpnP1;
    }

    public void setPatientEncountersLpnP1(String patientEncountersLpnP1) {
        this.patientEncountersLpnP1 = patientEncountersLpnP1;
    }

    public String getAttachedNotToTheClinicP1() {
        return attachedNotToTheClinicP1;
    }

    public void setAttachedNotToTheClinicP1(String attachedNotToTheClinicP1) {
        this.attachedNotToTheClinicP1 = attachedNotToTheClinicP1;
    }

    public String getPatientEncountersOtherP1() {
        return patientEncountersOtherP1;
    }

    public void setPatientEncountersOtherP1(String patientEncountersOtherP1) {
        this.patientEncountersOtherP1 = patientEncountersOtherP1;
    }

    public String getUniquePatientsWithoutMspP1() {
        return uniquePatientsWithoutMspP1;
    }

    public void setUniquePatientsWithoutMspP1(String uniquePatientsWithoutMspP1) {
        this.uniquePatientsWithoutMspP1 = uniquePatientsWithoutMspP1;
    }

    public String getUniquePatientsSinceOpeningP1() {
        return uniquePatientsSinceOpeningP1;
    }

    public void setUniquePatientsSinceOpeningP1(String uniquePatientsSinceOpeningP1) {
        this.uniquePatientsSinceOpeningP1 = uniquePatientsSinceOpeningP1;
    }

    public String getUnattachedP2() {
        return unattachedP2;
    }

    public void setUnattachedP2(String unattachedP2) {
        this.unattachedP2 = unattachedP2;
    }

    public String getUniquePatientsP2() {
        return uniquePatientsP2;
    }

    public void setUniquePatientsP2(String uniquePatientsP2) {
        this.uniquePatientsP2 = uniquePatientsP2;
    }

    public String getDeliveredVirtuallyP2() {
        return deliveredVirtuallyP2;
    }

    public void setDeliveredVirtuallyP2(String deliveredVirtuallyP2) {
        this.deliveredVirtuallyP2 = deliveredVirtuallyP2;
    }

    public String getAttachedToTheClinicP2() {
        return attachedToTheClinicP2;
    }

    public void setAttachedToTheClinicP2(String attachedToTheClinicP2) {
        this.attachedToTheClinicP2 = attachedToTheClinicP2;
    }

    public String getPatientEncountersFpP2() {
        return patientEncountersFpP2;
    }

    public void setPatientEncountersFpP2(String patientEncountersFpP2) {
        this.patientEncountersFpP2 = patientEncountersFpP2;
    }

    public String getPatientEncountersNpP2() {
        return patientEncountersNpP2;
    }

    public void setPatientEncountersNpP2(String patientEncountersNpP2) {
        this.patientEncountersNpP2 = patientEncountersNpP2;
    }

    public String getPatientEncountersRnP2() {
        return patientEncountersRnP2;
    }

    public void setPatientEncountersRnP2(String patientEncountersRnP2) {
        this.patientEncountersRnP2 = patientEncountersRnP2;
    }

    public String getOutsideBusinessHoursP2() {
        return outsideBusinessHoursP2;
    }

    public void setOutsideBusinessHoursP2(String outsideBusinessHoursP2) {
        this.outsideBusinessHoursP2 = outsideBusinessHoursP2;
    }

    public String getPatientEncountersLpnP2() {
        return patientEncountersLpnP2;
    }

    public void setPatientEncountersLpnP2(String patientEncountersLpnP2) {
        this.patientEncountersLpnP2 = patientEncountersLpnP2;
    }

    public String getAttachedNotToTheClinicP2() {
        return attachedNotToTheClinicP2;
    }

    public void setAttachedNotToTheClinicP2(String attachedNotToTheClinicP2) {
        this.attachedNotToTheClinicP2 = attachedNotToTheClinicP2;
    }

    public String getPatientEncountersOtherP2() {
        return patientEncountersOtherP2;
    }

    public void setPatientEncountersOtherP2(String patientEncountersOtherP2) {
        this.patientEncountersOtherP2 = patientEncountersOtherP2;
    }

    public String getUniquePatientsWithoutMspP2() {
        return uniquePatientsWithoutMspP2;
    }

    public void setUniquePatientsWithoutMspP2(String uniquePatientsWithoutMspP2) {
        this.uniquePatientsWithoutMspP2 = uniquePatientsWithoutMspP2;
    }

    public String getUniquePatientsSinceOpeningP2() {
        return uniquePatientsSinceOpeningP2;
    }

    public void setUniquePatientsSinceOpeningP2(String uniquePatientsSinceOpeningP2) {
        this.uniquePatientsSinceOpeningP2 = uniquePatientsSinceOpeningP2;
    }

    public String getUnattachedP3() {
        return unattachedP3;
    }

    public void setUnattachedP3(String unattachedP3) {
        this.unattachedP3 = unattachedP3;
    }

    public String getUniquePatientsP3() {
        return uniquePatientsP3;
    }

    public void setUniquePatientsP3(String uniquePatientsP3) {
        this.uniquePatientsP3 = uniquePatientsP3;
    }

    public String getDeliveredVirtuallyP3() {
        return deliveredVirtuallyP3;
    }

    public void setDeliveredVirtuallyP3(String deliveredVirtuallyP3) {
        this.deliveredVirtuallyP3 = deliveredVirtuallyP3;
    }

    public String getAttachedToTheClinicP3() {
        return attachedToTheClinicP3;
    }

    public void setAttachedToTheClinicP3(String attachedToTheClinicP3) {
        this.attachedToTheClinicP3 = attachedToTheClinicP3;
    }

    public String getPatientEncountersFpP3() {
        return patientEncountersFpP3;
    }

    public void setPatientEncountersFpP3(String patientEncountersFpP3) {
        this.patientEncountersFpP3 = patientEncountersFpP3;
    }

    public String getPatientEncountersNpP3() {
        return patientEncountersNpP3;
    }

    public void setPatientEncountersNpP3(String patientEncountersNpP3) {
        this.patientEncountersNpP3 = patientEncountersNpP3;
    }

    public String getPatientEncountersRnP3() {
        return patientEncountersRnP3;
    }

    public void setPatientEncountersRnP3(String patientEncountersRnP3) {
        this.patientEncountersRnP3 = patientEncountersRnP3;
    }

    public String getOutsideBusinessHoursP3() {
        return outsideBusinessHoursP3;
    }

    public void setOutsideBusinessHoursP3(String outsideBusinessHoursP3) {
        this.outsideBusinessHoursP3 = outsideBusinessHoursP3;
    }

    public String getPatientEncountersLpnP3() {
        return patientEncountersLpnP3;
    }

    public void setPatientEncountersLpnP3(String patientEncountersLpnP3) {
        this.patientEncountersLpnP3 = patientEncountersLpnP3;
    }

    public String getAttachedNotToTheClinicP3() {
        return attachedNotToTheClinicP3;
    }

    public void setAttachedNotToTheClinicP3(String attachedNotToTheClinicP3) {
        this.attachedNotToTheClinicP3 = attachedNotToTheClinicP3;
    }

    public String getPatientEncountersOtherP3() {
        return patientEncountersOtherP3;
    }

    public void setPatientEncountersOtherP3(String patientEncountersOtherP3) {
        this.patientEncountersOtherP3 = patientEncountersOtherP3;
    }

    public String getUniquePatientsWithoutMspP3() {
        return uniquePatientsWithoutMspP3;
    }

    public void setUniquePatientsWithoutMspP3(String uniquePatientsWithoutMspP3) {
        this.uniquePatientsWithoutMspP3 = uniquePatientsWithoutMspP3;
    }

    public String getUniquePatientsSinceOpeningP3() {
        return uniquePatientsSinceOpeningP3;
    }

    public void setUniquePatientsSinceOpeningP3(String uniquePatientsSinceOpeningP3) {
        this.uniquePatientsSinceOpeningP3 = uniquePatientsSinceOpeningP3;
    }

    public String getUnattachedP4() {
        return unattachedP4;
    }

    public void setUnattachedP4(String unattachedP4) {
        this.unattachedP4 = unattachedP4;
    }

    public String getUniquePatientsP4() {
        return uniquePatientsP4;
    }

    public void setUniquePatientsP4(String uniquePatientsP4) {
        this.uniquePatientsP4 = uniquePatientsP4;
    }

    public String getDeliveredVirtuallyP4() {
        return deliveredVirtuallyP4;
    }

    public void setDeliveredVirtuallyP4(String deliveredVirtuallyP4) {
        this.deliveredVirtuallyP4 = deliveredVirtuallyP4;
    }

    public String getAttachedToTheClinicP4() {
        return attachedToTheClinicP4;
    }

    public void setAttachedToTheClinicP4(String attachedToTheClinicP4) {
        this.attachedToTheClinicP4 = attachedToTheClinicP4;
    }

    public String getPatientEncountersFpP4() {
        return patientEncountersFpP4;
    }

    public void setPatientEncountersFpP4(String patientEncountersFpP4) {
        this.patientEncountersFpP4 = patientEncountersFpP4;
    }

    public String getPatientEncountersNpP4() {
        return patientEncountersNpP4;
    }

    public void setPatientEncountersNpP4(String patientEncountersNpP4) {
        this.patientEncountersNpP4 = patientEncountersNpP4;
    }

    public String getPatientEncountersRnP4() {
        return patientEncountersRnP4;
    }

    public void setPatientEncountersRnP4(String patientEncountersRnP4) {
        this.patientEncountersRnP4 = patientEncountersRnP4;
    }

    public String getOutsideBusinessHoursP4() {
        return outsideBusinessHoursP4;
    }

    public void setOutsideBusinessHoursP4(String outsideBusinessHoursP4) {
        this.outsideBusinessHoursP4 = outsideBusinessHoursP4;
    }

    public String getPatientEncountersLpnP4() {
        return patientEncountersLpnP4;
    }

    public void setPatientEncountersLpnP4(String patientEncountersLpnP4) {
        this.patientEncountersLpnP4 = patientEncountersLpnP4;
    }

    public String getAttachedNotToTheClinicP4() {
        return attachedNotToTheClinicP4;
    }

    public void setAttachedNotToTheClinicP4(String attachedNotToTheClinicP4) {
        this.attachedNotToTheClinicP4 = attachedNotToTheClinicP4;
    }

    public String getPatientEncountersOtherP4() {
        return patientEncountersOtherP4;
    }

    public void setPatientEncountersOtherP4(String patientEncountersOtherP4) {
        this.patientEncountersOtherP4 = patientEncountersOtherP4;
    }

    public String getUniquePatientsWithoutMspP4() {
        return uniquePatientsWithoutMspP4;
    }

    public void setUniquePatientsWithoutMspP4(String uniquePatientsWithoutMspP4) {
        this.uniquePatientsWithoutMspP4 = uniquePatientsWithoutMspP4;
    }

    public String getUniquePatientsSinceOpeningP4() {
        return uniquePatientsSinceOpeningP4;
    }

    public void setUniquePatientsSinceOpeningP4(String uniquePatientsSinceOpeningP4) {
        this.uniquePatientsSinceOpeningP4 = uniquePatientsSinceOpeningP4;
    }

    public String getUnattachedP5() {
        return unattachedP5;
    }

    public void setUnattachedP5(String unattachedP5) {
        this.unattachedP5 = unattachedP5;
    }

    public String getUniquePatientsP5() {
        return uniquePatientsP5;
    }

    public void setUniquePatientsP5(String uniquePatientsP5) {
        this.uniquePatientsP5 = uniquePatientsP5;
    }

    public String getDeliveredVirtuallyP5() {
        return deliveredVirtuallyP5;
    }

    public void setDeliveredVirtuallyP5(String deliveredVirtuallyP5) {
        this.deliveredVirtuallyP5 = deliveredVirtuallyP5;
    }

    public String getAttachedToTheClinicP5() {
        return attachedToTheClinicP5;
    }

    public void setAttachedToTheClinicP5(String attachedToTheClinicP5) {
        this.attachedToTheClinicP5 = attachedToTheClinicP5;
    }

    public String getPatientEncountersFpP5() {
        return patientEncountersFpP5;
    }

    public void setPatientEncountersFpP5(String patientEncountersFpP5) {
        this.patientEncountersFpP5 = patientEncountersFpP5;
    }

    public String getPatientEncountersNpP5() {
        return patientEncountersNpP5;
    }

    public void setPatientEncountersNpP5(String patientEncountersNpP5) {
        this.patientEncountersNpP5 = patientEncountersNpP5;
    }

    public String getPatientEncountersRnP5() {
        return patientEncountersRnP5;
    }

    public void setPatientEncountersRnP5(String patientEncountersRnP5) {
        this.patientEncountersRnP5 = patientEncountersRnP5;
    }

    public String getOutsideBusinessHoursP5() {
        return outsideBusinessHoursP5;
    }

    public void setOutsideBusinessHoursP5(String outsideBusinessHoursP5) {
        this.outsideBusinessHoursP5 = outsideBusinessHoursP5;
    }

    public String getPatientEncountersLpnP5() {
        return patientEncountersLpnP5;
    }

    public void setPatientEncountersLpnP5(String patientEncountersLpnP5) {
        this.patientEncountersLpnP5 = patientEncountersLpnP5;
    }

    public String getAttachedNotToTheClinicP5() {
        return attachedNotToTheClinicP5;
    }

    public void setAttachedNotToTheClinicP5(String attachedNotToTheClinicP5) {
        this.attachedNotToTheClinicP5 = attachedNotToTheClinicP5;
    }

    public String getPatientEncountersOtherP5() {
        return patientEncountersOtherP5;
    }

    public void setPatientEncountersOtherP5(String patientEncountersOtherP5) {
        this.patientEncountersOtherP5 = patientEncountersOtherP5;
    }

    public String getUniquePatientsWithoutMspP5() {
        return uniquePatientsWithoutMspP5;
    }

    public void setUniquePatientsWithoutMspP5(String uniquePatientsWithoutMspP5) {
        this.uniquePatientsWithoutMspP5 = uniquePatientsWithoutMspP5;
    }

    public String getUniquePatientsSinceOpeningP5() {
        return uniquePatientsSinceOpeningP5;
    }

    public void setUniquePatientsSinceOpeningP5(String uniquePatientsSinceOpeningP5) {
        this.uniquePatientsSinceOpeningP5 = uniquePatientsSinceOpeningP5;
    }

    public String getUnattachedP6() {
        return unattachedP6;
    }

    public void setUnattachedP6(String unattachedP6) {
        this.unattachedP6 = unattachedP6;
    }

    public String getUniquePatientsP6() {
        return uniquePatientsP6;
    }

    public void setUniquePatientsP6(String uniquePatientsP6) {
        this.uniquePatientsP6 = uniquePatientsP6;
    }

    public String getDeliveredVirtuallyP6() {
        return deliveredVirtuallyP6;
    }

    public void setDeliveredVirtuallyP6(String deliveredVirtuallyP6) {
        this.deliveredVirtuallyP6 = deliveredVirtuallyP6;
    }

    public String getAttachedToTheClinicP6() {
        return attachedToTheClinicP6;
    }

    public void setAttachedToTheClinicP6(String attachedToTheClinicP6) {
        this.attachedToTheClinicP6 = attachedToTheClinicP6;
    }

    public String getPatientEncountersFpP6() {
        return patientEncountersFpP6;
    }

    public void setPatientEncountersFpP6(String patientEncountersFpP6) {
        this.patientEncountersFpP6 = patientEncountersFpP6;
    }

    public String getPatientEncountersNpP6() {
        return patientEncountersNpP6;
    }

    public void setPatientEncountersNpP6(String patientEncountersNpP6) {
        this.patientEncountersNpP6 = patientEncountersNpP6;
    }

    public String getPatientEncountersRnP6() {
        return patientEncountersRnP6;
    }

    public void setPatientEncountersRnP6(String patientEncountersRnP6) {
        this.patientEncountersRnP6 = patientEncountersRnP6;
    }

    public String getOutsideBusinessHoursP6() {
        return outsideBusinessHoursP6;
    }

    public void setOutsideBusinessHoursP6(String outsideBusinessHoursP6) {
        this.outsideBusinessHoursP6 = outsideBusinessHoursP6;
    }

    public String getPatientEncountersLpnP6() {
        return patientEncountersLpnP6;
    }

    public void setPatientEncountersLpnP6(String patientEncountersLpnP6) {
        this.patientEncountersLpnP6 = patientEncountersLpnP6;
    }

    public String getAttachedNotToTheClinicP6() {
        return attachedNotToTheClinicP6;
    }

    public void setAttachedNotToTheClinicP6(String attachedNotToTheClinicP6) {
        this.attachedNotToTheClinicP6 = attachedNotToTheClinicP6;
    }

    public String getPatientEncountersOtherP6() {
        return patientEncountersOtherP6;
    }

    public void setPatientEncountersOtherP6(String patientEncountersOtherP6) {
        this.patientEncountersOtherP6 = patientEncountersOtherP6;
    }

    public String getUniquePatientsWithoutMspP6() {
        return uniquePatientsWithoutMspP6;
    }

    public void setUniquePatientsWithoutMspP6(String uniquePatientsWithoutMspP6) {
        this.uniquePatientsWithoutMspP6 = uniquePatientsWithoutMspP6;
    }

    public String getUniquePatientsSinceOpeningP6() {
        return uniquePatientsSinceOpeningP6;
    }

    public void setUniquePatientsSinceOpeningP6(String uniquePatientsSinceOpeningP6) {
        this.uniquePatientsSinceOpeningP6 = uniquePatientsSinceOpeningP6;
    }

    public String getUnattachedP7() {
        return unattachedP7;
    }

    public void setUnattachedP7(String unattachedP7) {
        this.unattachedP7 = unattachedP7;
    }

    public String getUniquePatientsP7() {
        return uniquePatientsP7;
    }

    public void setUniquePatientsP7(String uniquePatientsP7) {
        this.uniquePatientsP7 = uniquePatientsP7;
    }

    public String getDeliveredVirtuallyP7() {
        return deliveredVirtuallyP7;
    }

    public void setDeliveredVirtuallyP7(String deliveredVirtuallyP7) {
        this.deliveredVirtuallyP7 = deliveredVirtuallyP7;
    }

    public String getAttachedToTheClinicP7() {
        return attachedToTheClinicP7;
    }

    public void setAttachedToTheClinicP7(String attachedToTheClinicP7) {
        this.attachedToTheClinicP7 = attachedToTheClinicP7;
    }

    public String getPatientEncountersFpP7() {
        return patientEncountersFpP7;
    }

    public void setPatientEncountersFpP7(String patientEncountersFpP7) {
        this.patientEncountersFpP7 = patientEncountersFpP7;
    }

    public String getPatientEncountersNpP7() {
        return patientEncountersNpP7;
    }

    public void setPatientEncountersNpP7(String patientEncountersNpP7) {
        this.patientEncountersNpP7 = patientEncountersNpP7;
    }

    public String getPatientEncountersRnP7() {
        return patientEncountersRnP7;
    }

    public void setPatientEncountersRnP7(String patientEncountersRnP7) {
        this.patientEncountersRnP7 = patientEncountersRnP7;
    }

    public String getOutsideBusinessHoursP7() {
        return outsideBusinessHoursP7;
    }

    public void setOutsideBusinessHoursP7(String outsideBusinessHoursP7) {
        this.outsideBusinessHoursP7 = outsideBusinessHoursP7;
    }

    public String getPatientEncountersLpnP7() {
        return patientEncountersLpnP7;
    }

    public void setPatientEncountersLpnP7(String patientEncountersLpnP7) {
        this.patientEncountersLpnP7 = patientEncountersLpnP7;
    }

    public String getAttachedNotToTheClinicP7() {
        return attachedNotToTheClinicP7;
    }

    public void setAttachedNotToTheClinicP7(String attachedNotToTheClinicP7) {
        this.attachedNotToTheClinicP7 = attachedNotToTheClinicP7;
    }

    public String getPatientEncountersOtherP7() {
        return patientEncountersOtherP7;
    }

    public void setPatientEncountersOtherP7(String patientEncountersOtherP7) {
        this.patientEncountersOtherP7 = patientEncountersOtherP7;
    }

    public String getUniquePatientsWithoutMspP7() {
        return uniquePatientsWithoutMspP7;
    }

    public void setUniquePatientsWithoutMspP7(String uniquePatientsWithoutMspP7) {
        this.uniquePatientsWithoutMspP7 = uniquePatientsWithoutMspP7;
    }

    public String getUniquePatientsSinceOpeningP7() {
        return uniquePatientsSinceOpeningP7;
    }

    public void setUniquePatientsSinceOpeningP7(String uniquePatientsSinceOpeningP7) {
        this.uniquePatientsSinceOpeningP7 = uniquePatientsSinceOpeningP7;
    }

    public String getUnattachedP8() {
        return unattachedP8;
    }

    public void setUnattachedP8(String unattachedP8) {
        this.unattachedP8 = unattachedP8;
    }

    public String getUniquePatientsP8() {
        return uniquePatientsP8;
    }

    public void setUniquePatientsP8(String uniquePatientsP8) {
        this.uniquePatientsP8 = uniquePatientsP8;
    }

    public String getDeliveredVirtuallyP8() {
        return deliveredVirtuallyP8;
    }

    public void setDeliveredVirtuallyP8(String deliveredVirtuallyP8) {
        this.deliveredVirtuallyP8 = deliveredVirtuallyP8;
    }

    public String getAttachedToTheClinicP8() {
        return attachedToTheClinicP8;
    }

    public void setAttachedToTheClinicP8(String attachedToTheClinicP8) {
        this.attachedToTheClinicP8 = attachedToTheClinicP8;
    }

    public String getPatientEncountersFpP8() {
        return patientEncountersFpP8;
    }

    public void setPatientEncountersFpP8(String patientEncountersFpP8) {
        this.patientEncountersFpP8 = patientEncountersFpP8;
    }

    public String getPatientEncountersNpP8() {
        return patientEncountersNpP8;
    }

    public void setPatientEncountersNpP8(String patientEncountersNpP8) {
        this.patientEncountersNpP8 = patientEncountersNpP8;
    }

    public String getPatientEncountersRnP8() {
        return patientEncountersRnP8;
    }

    public void setPatientEncountersRnP8(String patientEncountersRnP8) {
        this.patientEncountersRnP8 = patientEncountersRnP8;
    }

    public String getOutsideBusinessHoursP8() {
        return outsideBusinessHoursP8;
    }

    public void setOutsideBusinessHoursP8(String outsideBusinessHoursP8) {
        this.outsideBusinessHoursP8 = outsideBusinessHoursP8;
    }

    public String getPatientEncountersLpnP8() {
        return patientEncountersLpnP8;
    }

    public void setPatientEncountersLpnP8(String patientEncountersLpnP8) {
        this.patientEncountersLpnP8 = patientEncountersLpnP8;
    }

    public String getAttachedNotToTheClinicP8() {
        return attachedNotToTheClinicP8;
    }

    public void setAttachedNotToTheClinicP8(String attachedNotToTheClinicP8) {
        this.attachedNotToTheClinicP8 = attachedNotToTheClinicP8;
    }

    public String getPatientEncountersOtherP8() {
        return patientEncountersOtherP8;
    }

    public void setPatientEncountersOtherP8(String patientEncountersOtherP8) {
        this.patientEncountersOtherP8 = patientEncountersOtherP8;
    }

    public String getUniquePatientsWithoutMspP8() {
        return uniquePatientsWithoutMspP8;
    }

    public void setUniquePatientsWithoutMspP8(String uniquePatientsWithoutMspP8) {
        this.uniquePatientsWithoutMspP8 = uniquePatientsWithoutMspP8;
    }

    public String getUniquePatientsSinceOpeningP8() {
        return uniquePatientsSinceOpeningP8;
    }

    public void setUniquePatientsSinceOpeningP8(String uniquePatientsSinceOpeningP8) {
        this.uniquePatientsSinceOpeningP8 = uniquePatientsSinceOpeningP8;
    }

    public String getUnattachedP9() {
        return unattachedP9;
    }

    public void setUnattachedP9(String unattachedP9) {
        this.unattachedP9 = unattachedP9;
    }

    public String getUniquePatientsP9() {
        return uniquePatientsP9;
    }

    public void setUniquePatientsP9(String uniquePatientsP9) {
        this.uniquePatientsP9 = uniquePatientsP9;
    }

    public String getDeliveredVirtuallyP9() {
        return deliveredVirtuallyP9;
    }

    public void setDeliveredVirtuallyP9(String deliveredVirtuallyP9) {
        this.deliveredVirtuallyP9 = deliveredVirtuallyP9;
    }

    public String getAttachedToTheClinicP9() {
        return attachedToTheClinicP9;
    }

    public void setAttachedToTheClinicP9(String attachedToTheClinicP9) {
        this.attachedToTheClinicP9 = attachedToTheClinicP9;
    }

    public String getPatientEncountersFpP9() {
        return patientEncountersFpP9;
    }

    public void setPatientEncountersFpP9(String patientEncountersFpP9) {
        this.patientEncountersFpP9 = patientEncountersFpP9;
    }

    public String getPatientEncountersNpP9() {
        return patientEncountersNpP9;
    }

    public void setPatientEncountersNpP9(String patientEncountersNpP9) {
        this.patientEncountersNpP9 = patientEncountersNpP9;
    }

    public String getPatientEncountersRnP9() {
        return patientEncountersRnP9;
    }

    public void setPatientEncountersRnP9(String patientEncountersRnP9) {
        this.patientEncountersRnP9 = patientEncountersRnP9;
    }

    public String getOutsideBusinessHoursP9() {
        return outsideBusinessHoursP9;
    }

    public void setOutsideBusinessHoursP9(String outsideBusinessHoursP9) {
        this.outsideBusinessHoursP9 = outsideBusinessHoursP9;
    }

    public String getPatientEncountersLpnP9() {
        return patientEncountersLpnP9;
    }

    public void setPatientEncountersLpnP9(String patientEncountersLpnP9) {
        this.patientEncountersLpnP9 = patientEncountersLpnP9;
    }

    public String getAttachedNotToTheClinicP9() {
        return attachedNotToTheClinicP9;
    }

    public void setAttachedNotToTheClinicP9(String attachedNotToTheClinicP9) {
        this.attachedNotToTheClinicP9 = attachedNotToTheClinicP9;
    }

    public String getPatientEncountersOtherP9() {
        return patientEncountersOtherP9;
    }

    public void setPatientEncountersOtherP9(String patientEncountersOtherP9) {
        this.patientEncountersOtherP9 = patientEncountersOtherP9;
    }

    public String getUniquePatientsWithoutMspP9() {
        return uniquePatientsWithoutMspP9;
    }

    public void setUniquePatientsWithoutMspP9(String uniquePatientsWithoutMspP9) {
        this.uniquePatientsWithoutMspP9 = uniquePatientsWithoutMspP9;
    }

    public String getUniquePatientsSinceOpeningP9() {
        return uniquePatientsSinceOpeningP9;
    }

    public void setUniquePatientsSinceOpeningP9(String uniquePatientsSinceOpeningP9) {
        this.uniquePatientsSinceOpeningP9 = uniquePatientsSinceOpeningP9;
    }

    public String getUnattachedP10() {
        return unattachedP10;
    }

    public void setUnattachedP10(String unattachedP10) {
        this.unattachedP10 = unattachedP10;
    }

    public String getUniquePatientsP10() {
        return uniquePatientsP10;
    }

    public void setUniquePatientsP10(String uniquePatientsP10) {
        this.uniquePatientsP10 = uniquePatientsP10;
    }

    public String getDeliveredVirtuallyP10() {
        return deliveredVirtuallyP10;
    }

    public void setDeliveredVirtuallyP10(String deliveredVirtuallyP10) {
        this.deliveredVirtuallyP10 = deliveredVirtuallyP10;
    }

    public String getAttachedToTheClinicP10() {
        return attachedToTheClinicP10;
    }

    public void setAttachedToTheClinicP10(String attachedToTheClinicP10) {
        this.attachedToTheClinicP10 = attachedToTheClinicP10;
    }

    public String getPatientEncountersFpP10() {
        return patientEncountersFpP10;
    }

    public void setPatientEncountersFpP10(String patientEncountersFpP10) {
        this.patientEncountersFpP10 = patientEncountersFpP10;
    }

    public String getPatientEncountersNpP10() {
        return patientEncountersNpP10;
    }

    public void setPatientEncountersNpP10(String patientEncountersNpP10) {
        this.patientEncountersNpP10 = patientEncountersNpP10;
    }

    public String getPatientEncountersRnP10() {
        return patientEncountersRnP10;
    }

    public void setPatientEncountersRnP10(String patientEncountersRnP10) {
        this.patientEncountersRnP10 = patientEncountersRnP10;
    }

    public String getOutsideBusinessHoursP10() {
        return outsideBusinessHoursP10;
    }

    public void setOutsideBusinessHoursP10(String outsideBusinessHoursP10) {
        this.outsideBusinessHoursP10 = outsideBusinessHoursP10;
    }

    public String getPatientEncountersLpnP10() {
        return patientEncountersLpnP10;
    }

    public void setPatientEncountersLpnP10(String patientEncountersLpnP10) {
        this.patientEncountersLpnP10 = patientEncountersLpnP10;
    }

    public String getAttachedNotToTheClinicP10() {
        return attachedNotToTheClinicP10;
    }

    public void setAttachedNotToTheClinicP10(String attachedNotToTheClinicP10) {
        this.attachedNotToTheClinicP10 = attachedNotToTheClinicP10;
    }

    public String getPatientEncountersOtherP10() {
        return patientEncountersOtherP10;
    }

    public void setPatientEncountersOtherP10(String patientEncountersOtherP10) {
        this.patientEncountersOtherP10 = patientEncountersOtherP10;
    }

    public String getUniquePatientsWithoutMspP10() {
        return uniquePatientsWithoutMspP10;
    }

    public void setUniquePatientsWithoutMspP10(String uniquePatientsWithoutMspP10) {
        this.uniquePatientsWithoutMspP10 = uniquePatientsWithoutMspP10;
    }

    public String getUniquePatientsSinceOpeningP10() {
        return uniquePatientsSinceOpeningP10;
    }

    public void setUniquePatientsSinceOpeningP10(String uniquePatientsSinceOpeningP10) {
        this.uniquePatientsSinceOpeningP10 = uniquePatientsSinceOpeningP10;
    }

    public String getUnattachedP11() {
        return unattachedP11;
    }

    public void setUnattachedP11(String unattachedP11) {
        this.unattachedP11 = unattachedP11;
    }

    public String getUniquePatientsP11() {
        return uniquePatientsP11;
    }

    public void setUniquePatientsP11(String uniquePatientsP11) {
        this.uniquePatientsP11 = uniquePatientsP11;
    }

    public String getDeliveredVirtuallyP11() {
        return deliveredVirtuallyP11;
    }

    public void setDeliveredVirtuallyP11(String deliveredVirtuallyP11) {
        this.deliveredVirtuallyP11 = deliveredVirtuallyP11;
    }

    public String getAttachedToTheClinicP11() {
        return attachedToTheClinicP11;
    }

    public void setAttachedToTheClinicP11(String attachedToTheClinicP11) {
        this.attachedToTheClinicP11 = attachedToTheClinicP11;
    }

    public String getPatientEncountersFpP11() {
        return patientEncountersFpP11;
    }

    public void setPatientEncountersFpP11(String patientEncountersFpP11) {
        this.patientEncountersFpP11 = patientEncountersFpP11;
    }

    public String getPatientEncountersNpP11() {
        return patientEncountersNpP11;
    }

    public void setPatientEncountersNpP11(String patientEncountersNpP11) {
        this.patientEncountersNpP11 = patientEncountersNpP11;
    }

    public String getPatientEncountersRnP11() {
        return patientEncountersRnP11;
    }

    public void setPatientEncountersRnP11(String patientEncountersRnP11) {
        this.patientEncountersRnP11 = patientEncountersRnP11;
    }

    public String getOutsideBusinessHoursP11() {
        return outsideBusinessHoursP11;
    }

    public void setOutsideBusinessHoursP11(String outsideBusinessHoursP11) {
        this.outsideBusinessHoursP11 = outsideBusinessHoursP11;
    }

    public String getPatientEncountersLpnP11() {
        return patientEncountersLpnP11;
    }

    public void setPatientEncountersLpnP11(String patientEncountersLpnP11) {
        this.patientEncountersLpnP11 = patientEncountersLpnP11;
    }

    public String getAttachedNotToTheClinicP11() {
        return attachedNotToTheClinicP11;
    }

    public void setAttachedNotToTheClinicP11(String attachedNotToTheClinicP11) {
        this.attachedNotToTheClinicP11 = attachedNotToTheClinicP11;
    }

    public String getPatientEncountersOtherP11() {
        return patientEncountersOtherP11;
    }

    public void setPatientEncountersOtherP11(String patientEncountersOtherP11) {
        this.patientEncountersOtherP11 = patientEncountersOtherP11;
    }

    public String getUniquePatientsWithoutMspP11() {
        return uniquePatientsWithoutMspP11;
    }

    public void setUniquePatientsWithoutMspP11(String uniquePatientsWithoutMspP11) {
        this.uniquePatientsWithoutMspP11 = uniquePatientsWithoutMspP11;
    }

    public String getUniquePatientsSinceOpeningP11() {
        return uniquePatientsSinceOpeningP11;
    }

    public void setUniquePatientsSinceOpeningP11(String uniquePatientsSinceOpeningP11) {
        this.uniquePatientsSinceOpeningP11 = uniquePatientsSinceOpeningP11;
    }

    public String getUnattachedP12() {
        return unattachedP12;
    }

    public void setUnattachedP12(String unattachedP12) {
        this.unattachedP12 = unattachedP12;
    }

    public String getUniquePatientsP12() {
        return uniquePatientsP12;
    }

    public void setUniquePatientsP12(String uniquePatientsP12) {
        this.uniquePatientsP12 = uniquePatientsP12;
    }

    public String getDeliveredVirtuallyP12() {
        return deliveredVirtuallyP12;
    }

    public void setDeliveredVirtuallyP12(String deliveredVirtuallyP12) {
        this.deliveredVirtuallyP12 = deliveredVirtuallyP12;
    }

    public String getAttachedToTheClinicP12() {
        return attachedToTheClinicP12;
    }

    public void setAttachedToTheClinicP12(String attachedToTheClinicP12) {
        this.attachedToTheClinicP12 = attachedToTheClinicP12;
    }

    public String getPatientEncountersFpP12() {
        return patientEncountersFpP12;
    }

    public void setPatientEncountersFpP12(String patientEncountersFpP12) {
        this.patientEncountersFpP12 = patientEncountersFpP12;
    }

    public String getPatientEncountersNpP12() {
        return patientEncountersNpP12;
    }

    public void setPatientEncountersNpP12(String patientEncountersNpP12) {
        this.patientEncountersNpP12 = patientEncountersNpP12;
    }

    public String getPatientEncountersRnP12() {
        return patientEncountersRnP12;
    }

    public void setPatientEncountersRnP12(String patientEncountersRnP12) {
        this.patientEncountersRnP12 = patientEncountersRnP12;
    }

    public String getOutsideBusinessHoursP12() {
        return outsideBusinessHoursP12;
    }

    public void setOutsideBusinessHoursP12(String outsideBusinessHoursP12) {
        this.outsideBusinessHoursP12 = outsideBusinessHoursP12;
    }

    public String getPatientEncountersLpnP12() {
        return patientEncountersLpnP12;
    }

    public void setPatientEncountersLpnP12(String patientEncountersLpnP12) {
        this.patientEncountersLpnP12 = patientEncountersLpnP12;
    }

    public String getAttachedNotToTheClinicP12() {
        return attachedNotToTheClinicP12;
    }

    public void setAttachedNotToTheClinicP12(String attachedNotToTheClinicP12) {
        this.attachedNotToTheClinicP12 = attachedNotToTheClinicP12;
    }

    public String getPatientEncountersOtherP12() {
        return patientEncountersOtherP12;
    }

    public void setPatientEncountersOtherP12(String patientEncountersOtherP12) {
        this.patientEncountersOtherP12 = patientEncountersOtherP12;
    }

    public String getUniquePatientsWithoutMspP12() {
        return uniquePatientsWithoutMspP12;
    }

    public void setUniquePatientsWithoutMspP12(String uniquePatientsWithoutMspP12) {
        this.uniquePatientsWithoutMspP12 = uniquePatientsWithoutMspP12;
    }

    public String getUniquePatientsSinceOpeningP12() {
        return uniquePatientsSinceOpeningP12;
    }

    public void setUniquePatientsSinceOpeningP12(String uniquePatientsSinceOpeningP12) {
        this.uniquePatientsSinceOpeningP12 = uniquePatientsSinceOpeningP12;
    }

    public String getUnattachedP13() {
        return unattachedP13;
    }

    public void setUnattachedP13(String unattachedP13) {
        this.unattachedP13 = unattachedP13;
    }

    public String getUniquePatientsP13() {
        return uniquePatientsP13;
    }

    public void setUniquePatientsP13(String uniquePatientsP13) {
        this.uniquePatientsP13 = uniquePatientsP13;
    }

    public String getDeliveredVirtuallyP13() {
        return deliveredVirtuallyP13;
    }

    public void setDeliveredVirtuallyP13(String deliveredVirtuallyP13) {
        this.deliveredVirtuallyP13 = deliveredVirtuallyP13;
    }

    public String getAttachedToTheClinicP13() {
        return attachedToTheClinicP13;
    }

    public void setAttachedToTheClinicP13(String attachedToTheClinicP13) {
        this.attachedToTheClinicP13 = attachedToTheClinicP13;
    }

    public String getPatientEncountersFpP13() {
        return patientEncountersFpP13;
    }

    public void setPatientEncountersFpP13(String patientEncountersFpP13) {
        this.patientEncountersFpP13 = patientEncountersFpP13;
    }

    public String getPatientEncountersNpP13() {
        return patientEncountersNpP13;
    }

    public void setPatientEncountersNpP13(String patientEncountersNpP13) {
        this.patientEncountersNpP13 = patientEncountersNpP13;
    }

    public String getPatientEncountersRnP13() {
        return patientEncountersRnP13;
    }

    public void setPatientEncountersRnP13(String patientEncountersRnP13) {
        this.patientEncountersRnP13 = patientEncountersRnP13;
    }

    public String getOutsideBusinessHoursP13() {
        return outsideBusinessHoursP13;
    }

    public void setOutsideBusinessHoursP13(String outsideBusinessHoursP13) {
        this.outsideBusinessHoursP13 = outsideBusinessHoursP13;
    }

    public String getPatientEncountersLpnP13() {
        return patientEncountersLpnP13;
    }

    public void setPatientEncountersLpnP13(String patientEncountersLpnP13) {
        this.patientEncountersLpnP13 = patientEncountersLpnP13;
    }

    public String getAttachedNotToTheClinicP13() {
        return attachedNotToTheClinicP13;
    }

    public void setAttachedNotToTheClinicP13(String attachedNotToTheClinicP13) {
        this.attachedNotToTheClinicP13 = attachedNotToTheClinicP13;
    }

    public String getPatientEncountersOtherP13() {
        return patientEncountersOtherP13;
    }

    public void setPatientEncountersOtherP13(String patientEncountersOtherP13) {
        this.patientEncountersOtherP13 = patientEncountersOtherP13;
    }

    public String getUniquePatientsWithoutMspP13() {
        return uniquePatientsWithoutMspP13;
    }

    public void setUniquePatientsWithoutMspP13(String uniquePatientsWithoutMspP13) {
        this.uniquePatientsWithoutMspP13 = uniquePatientsWithoutMspP13;
    }

    public String getUniquePatientsSinceOpeningP13() {
        return uniquePatientsSinceOpeningP13;
    }

    public void setUniquePatientsSinceOpeningP13(String uniquePatientsSinceOpeningP13) {
        this.uniquePatientsSinceOpeningP13 = uniquePatientsSinceOpeningP13;
    }

    @Override
    public String toString() {
        return "RootDataSubmission [access=" + access + ", patientVolumes=" + patientVolumes + ", teamBasedCareService="
                + teamBasedCareService + ", accessNotes=" + accessNotes + ", submissionNotes=" + submissionNotes
                + ", ftesHiredToDateFp=" + ftesHiredToDateFp + ", ftesHiredToDateNp=" + ftesHiredToDateNp
                + ", ftesHiredToDateRn=" + ftesHiredToDateRn + ", ftesHiredToDateLpn=" + ftesHiredToDateLpn
                + ", patientVolumesNotes=" + patientVolumesNotes + ", ftesHiredToDateOther=" + ftesHiredToDateOther
                + ", currentApprovedFtEsFp=" + currentApprovedFtEsFp + ", currentApprovedFtEsNp="
                + currentApprovedFtEsNp + ", currentApprovedFtEsRn=" + currentApprovedFtEsRn
                + ", currentApprovedFtEsLpn=" + currentApprovedFtEsLpn + ", currentApprovedFtEsOther="
                + currentApprovedFtEsOther + ", teamBasedCareServiceNotes=" + teamBasedCareServiceNotes
                + ", unattachedP1=" + unattachedP1 + ", uniquePatientsP1=" + uniquePatientsP1
                + ", deliveredVirtuallyP1=" + deliveredVirtuallyP1 + ", attachedToTheClinicP1=" + attachedToTheClinicP1
                + ", patientEncountersFpP1=" + patientEncountersFpP1 + ", patientEncountersNpP1="
                + patientEncountersNpP1 + ", patientEncountersRnP1=" + patientEncountersRnP1
                + ", outsideBusinessHoursP1=" + outsideBusinessHoursP1 + ", patientEncountersLpnP1="
                + patientEncountersLpnP1 + ", attachedNotToTheClinicP1=" + attachedNotToTheClinicP1
                + ", patientEncountersOtherP1=" + patientEncountersOtherP1 + ", uniquePatientsWithoutMspP1="
                + uniquePatientsWithoutMspP1 + ", uniquePatientsSinceOpeningP1=" + uniquePatientsSinceOpeningP1
                + ", unattachedP2=" + unattachedP2 + ", uniquePatientsP2=" + uniquePatientsP2
                + ", deliveredVirtuallyP2=" + deliveredVirtuallyP2 + ", attachedToTheClinicP2=" + attachedToTheClinicP2
                + ", patientEncountersFpP2=" + patientEncountersFpP2 + ", patientEncountersNpP2="
                + patientEncountersNpP2 + ", patientEncountersRnP2=" + patientEncountersRnP2
                + ", outsideBusinessHoursP2=" + outsideBusinessHoursP2 + ", patientEncountersLpnP2="
                + patientEncountersLpnP2 + ", attachedNotToTheClinicP2=" + attachedNotToTheClinicP2
                + ", patientEncountersOtherP2=" + patientEncountersOtherP2 + ", uniquePatientsWithoutMspP2="
                + uniquePatientsWithoutMspP2 + ", uniquePatientsSinceOpeningP2=" + uniquePatientsSinceOpeningP2
                + ", unattachedP3=" + unattachedP3 + ", uniquePatientsP3=" + uniquePatientsP3
                + ", deliveredVirtuallyP3=" + deliveredVirtuallyP3 + ", attachedToTheClinicP3=" + attachedToTheClinicP3
                + ", patientEncountersFpP3=" + patientEncountersFpP3 + ", patientEncountersNpP3="
                + patientEncountersNpP3 + ", patientEncountersRnP3=" + patientEncountersRnP3
                + ", outsideBusinessHoursP3=" + outsideBusinessHoursP3 + ", patientEncountersLpnP3="
                + patientEncountersLpnP3 + ", attachedNotToTheClinicP3=" + attachedNotToTheClinicP3
                + ", patientEncountersOtherP3=" + patientEncountersOtherP3 + ", uniquePatientsWithoutMspP3="
                + uniquePatientsWithoutMspP3 + ", uniquePatientsSinceOpeningP3=" + uniquePatientsSinceOpeningP3
                + ", unattachedP4=" + unattachedP4 + ", uniquePatientsP4=" + uniquePatientsP4
                + ", deliveredVirtuallyP4=" + deliveredVirtuallyP4 + ", attachedToTheClinicP4=" + attachedToTheClinicP4
                + ", patientEncountersFpP4=" + patientEncountersFpP4 + ", patientEncountersNpP4="
                + patientEncountersNpP4 + ", patientEncountersRnP4=" + patientEncountersRnP4
                + ", outsideBusinessHoursP4=" + outsideBusinessHoursP4 + ", patientEncountersLpnP4="
                + patientEncountersLpnP4 + ", attachedNotToTheClinicP4=" + attachedNotToTheClinicP4
                + ", patientEncountersOtherP4=" + patientEncountersOtherP4 + ", uniquePatientsWithoutMspP4="
                + uniquePatientsWithoutMspP4 + ", uniquePatientsSinceOpeningP4=" + uniquePatientsSinceOpeningP4
                + ", unattachedP5=" + unattachedP5 + ", uniquePatientsP5=" + uniquePatientsP5
                + ", deliveredVirtuallyP5=" + deliveredVirtuallyP5 + ", attachedToTheClinicP5=" + attachedToTheClinicP5
                + ", patientEncountersFpP5=" + patientEncountersFpP5 + ", patientEncountersNpP5="
                + patientEncountersNpP5 + ", patientEncountersRnP5=" + patientEncountersRnP5
                + ", outsideBusinessHoursP5=" + outsideBusinessHoursP5 + ", patientEncountersLpnP5="
                + patientEncountersLpnP5 + ", attachedNotToTheClinicP5=" + attachedNotToTheClinicP5
                + ", patientEncountersOtherP5=" + patientEncountersOtherP5 + ", uniquePatientsWithoutMspP5="
                + uniquePatientsWithoutMspP5 + ", uniquePatientsSinceOpeningP5=" + uniquePatientsSinceOpeningP5
                + ", unattachedP6=" + unattachedP6 + ", uniquePatientsP6=" + uniquePatientsP6
                + ", deliveredVirtuallyP6=" + deliveredVirtuallyP6 + ", attachedToTheClinicP6=" + attachedToTheClinicP6
                + ", patientEncountersFpP6=" + patientEncountersFpP6 + ", patientEncountersNpP6="
                + patientEncountersNpP6 + ", patientEncountersRnP6=" + patientEncountersRnP6
                + ", outsideBusinessHoursP6=" + outsideBusinessHoursP6 + ", patientEncountersLpnP6="
                + patientEncountersLpnP6 + ", attachedNotToTheClinicP6=" + attachedNotToTheClinicP6
                + ", patientEncountersOtherP6=" + patientEncountersOtherP6 + ", uniquePatientsWithoutMspP6="
                + uniquePatientsWithoutMspP6 + ", uniquePatientsSinceOpeningP6=" + uniquePatientsSinceOpeningP6
                + ", unattachedP7=" + unattachedP7 + ", uniquePatientsP7=" + uniquePatientsP7
                + ", deliveredVirtuallyP7=" + deliveredVirtuallyP7 + ", attachedToTheClinicP7=" + attachedToTheClinicP7
                + ", patientEncountersFpP7=" + patientEncountersFpP7 + ", patientEncountersNpP7="
                + patientEncountersNpP7 + ", patientEncountersRnP7=" + patientEncountersRnP7
                + ", outsideBusinessHoursP7=" + outsideBusinessHoursP7 + ", patientEncountersLpnP7="
                + patientEncountersLpnP7 + ", attachedNotToTheClinicP7=" + attachedNotToTheClinicP7
                + ", patientEncountersOtherP7=" + patientEncountersOtherP7 + ", uniquePatientsWithoutMspP7="
                + uniquePatientsWithoutMspP7 + ", uniquePatientsSinceOpeningP7=" + uniquePatientsSinceOpeningP7
                + ", unattachedP8=" + unattachedP8 + ", uniquePatientsP8=" + uniquePatientsP8
                + ", deliveredVirtuallyP8=" + deliveredVirtuallyP8 + ", attachedToTheClinicP8=" + attachedToTheClinicP8
                + ", patientEncountersFpP8=" + patientEncountersFpP8 + ", patientEncountersNpP8="
                + patientEncountersNpP8 + ", patientEncountersRnP8=" + patientEncountersRnP8
                + ", outsideBusinessHoursP8=" + outsideBusinessHoursP8 + ", patientEncountersLpnP8="
                + patientEncountersLpnP8 + ", attachedNotToTheClinicP8=" + attachedNotToTheClinicP8
                + ", patientEncountersOtherP8=" + patientEncountersOtherP8 + ", uniquePatientsWithoutMspP8="
                + uniquePatientsWithoutMspP8 + ", uniquePatientsSinceOpeningP8=" + uniquePatientsSinceOpeningP8
                + ", unattachedP9=" + unattachedP9 + ", uniquePatientsP9=" + uniquePatientsP9
                + ", deliveredVirtuallyP9=" + deliveredVirtuallyP9 + ", attachedToTheClinicP9=" + attachedToTheClinicP9
                + ", patientEncountersFpP9=" + patientEncountersFpP9 + ", patientEncountersNpP9="
                + patientEncountersNpP9 + ", patientEncountersRnP9=" + patientEncountersRnP9
                + ", outsideBusinessHoursP9=" + outsideBusinessHoursP9 + ", patientEncountersLpnP9="
                + patientEncountersLpnP9 + ", attachedNotToTheClinicP9=" + attachedNotToTheClinicP9
                + ", patientEncountersOtherP9=" + patientEncountersOtherP9 + ", uniquePatientsWithoutMspP9="
                + uniquePatientsWithoutMspP9 + ", uniquePatientsSinceOpeningP9=" + uniquePatientsSinceOpeningP9
                + ", unattachedP10=" + unattachedP10 + ", uniquePatientsP10=" + uniquePatientsP10
                + ", deliveredVirtuallyP10=" + deliveredVirtuallyP10 + ", attachedToTheClinicP10="
                + attachedToTheClinicP10 + ", patientEncountersFpP10=" + patientEncountersFpP10
                + ", patientEncountersNpP10=" + patientEncountersNpP10 + ", patientEncountersRnP10="
                + patientEncountersRnP10 + ", outsideBusinessHoursP10=" + outsideBusinessHoursP10
                + ", patientEncountersLpnP10=" + patientEncountersLpnP10 + ", attachedNotToTheClinicP10="
                + attachedNotToTheClinicP10 + ", patientEncountersOtherP10=" + patientEncountersOtherP10
                + ", uniquePatientsWithoutMspP10=" + uniquePatientsWithoutMspP10 + ", uniquePatientsSinceOpeningP10="
                + uniquePatientsSinceOpeningP10 + ", unattachedP11=" + unattachedP11 + ", uniquePatientsP11="
                + uniquePatientsP11 + ", deliveredVirtuallyP11=" + deliveredVirtuallyP11 + ", attachedToTheClinicP11="
                + attachedToTheClinicP11 + ", patientEncountersFpP11=" + patientEncountersFpP11
                + ", patientEncountersNpP11=" + patientEncountersNpP11 + ", patientEncountersRnP11="
                + patientEncountersRnP11 + ", outsideBusinessHoursP11=" + outsideBusinessHoursP11
                + ", patientEncountersLpnP11=" + patientEncountersLpnP11 + ", attachedNotToTheClinicP11="
                + attachedNotToTheClinicP11 + ", patientEncountersOtherP11=" + patientEncountersOtherP11
                + ", uniquePatientsWithoutMspP11=" + uniquePatientsWithoutMspP11 + ", uniquePatientsSinceOpeningP11="
                + uniquePatientsSinceOpeningP11 + ", unattachedP12=" + unattachedP12 + ", uniquePatientsP12="
                + uniquePatientsP12 + ", deliveredVirtuallyP12=" + deliveredVirtuallyP12 + ", attachedToTheClinicP12="
                + attachedToTheClinicP12 + ", patientEncountersFpP12=" + patientEncountersFpP12
                + ", patientEncountersNpP12=" + patientEncountersNpP12 + ", patientEncountersRnP12="
                + patientEncountersRnP12 + ", outsideBusinessHoursP12=" + outsideBusinessHoursP12
                + ", patientEncountersLpnP12=" + patientEncountersLpnP12 + ", attachedNotToTheClinicP12="
                + attachedNotToTheClinicP12 + ", patientEncountersOtherP12=" + patientEncountersOtherP12
                + ", uniquePatientsWithoutMspP12=" + uniquePatientsWithoutMspP12 + ", uniquePatientsSinceOpeningP12="
                + uniquePatientsSinceOpeningP12 + ", unattachedP13=" + unattachedP13 + ", uniquePatientsP13="
                + uniquePatientsP13 + ", deliveredVirtuallyP13=" + deliveredVirtuallyP13 + ", attachedToTheClinicP13="
                + attachedToTheClinicP13 + ", patientEncountersFpP13=" + patientEncountersFpP13
                + ", patientEncountersNpP13=" + patientEncountersNpP13 + ", patientEncountersRnP13="
                + patientEncountersRnP13 + ", outsideBusinessHoursP13=" + outsideBusinessHoursP13
                + ", patientEncountersLpnP13=" + patientEncountersLpnP13 + ", attachedNotToTheClinicP13="
                + attachedNotToTheClinicP13 + ", patientEncountersOtherP13=" + patientEncountersOtherP13
                + ", uniquePatientsWithoutMspP13=" + uniquePatientsWithoutMspP13 + ", uniquePatientsSinceOpeningP13="
                + uniquePatientsSinceOpeningP13 + "]";
    }
}
