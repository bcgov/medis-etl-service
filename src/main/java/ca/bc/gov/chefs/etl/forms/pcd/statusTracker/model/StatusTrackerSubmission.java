package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class StatusTrackerSubmission implements IModel {

    private String submissionId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;
    private String typeOfInitiative;
    private String healthAuthority;
    private String communityName;
    private String currentFiscalYear;
    private String currentStatus;
    private String currentPhase;
    private String currentStage;
    private String statusUpdate;
    private String proposedAnnouncementDate;
    private String actualAnnouncementDate;
    private String targetOpeningDate;
    private String actualOpeningDate;
    private String proposedImplementationDate;
    private String implementationDate;
    private String datesComments;
    private String anyIssuesRisks;
    private String currentApprovedAttachmentTarget;
    private String currentApprovedBudget;
    private String currentApprovedFtes;

    private PCNStatusTrackerItem statusTrackerPcn;
    private CHCStatusTrackerItem statusTrackerChc;
    private NPPCCStatusTrackerItem statusTrackerNppcc;
    private UPCCStatusTrackerItem statusTrackerUpcc;
    private FNPCCStatusTrackerItem statusTrackerFnpcc;

    private List<PCNName> pcnNames;
    private List<ClinicName> clinicNames;
    private List<IssueAndRisk> issueAndRisks;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLateEntry() {
        return lateEntry;
    }

    public void setLateEntry(String lateEntry) {
        this.lateEntry = StringUtils.defaultIfEmpty(lateEntry, PCDConstants.DEFAULT_BOOLEAN_FALSE);
    }

    public String getSubmitterFullName() {
        return submitterFullName;
    }

    public void setSubmitterFullName(String submitterFullName) {
        this.submitterFullName = submitterFullName;
    }

    public String getSubmitterUserName() {
        return submitterUserName;
    }

    public void setSubmitterUserName(String submitterUserName) {
        this.submitterUserName = submitterUserName;
    }

    public String getSubmitterEmail() {
        return submitterEmail;
    }

    public void setSubmitterEmail(String submitterEmail) {
        this.submitterEmail = submitterEmail;
    }

    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public String getSubmissionVersion() {
        return submissionVersion;
    }

    public void setSubmissionVersion(String submissionVersion) {
        this.submissionVersion = submissionVersion;
    }

    public String getSubmissionFormName() {
        return submissionFormName;
    }

    public void setSubmissionFormName(String submissionFormName) {
        this.submissionFormName = submissionFormName;
    }

    public String getTypeOfInitiative() {
        return typeOfInitiative;
    }

    public void setTypeOfInitiative(String typeOfInitiative) {
        this.typeOfInitiative = typeOfInitiative;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCurrentFiscalYear() {
        return currentFiscalYear;
    }

    public void setCurrentFiscalYear(String currentFiscalYear) {
        this.currentFiscalYear = currentFiscalYear;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(String currentPhase) {
        this.currentPhase = currentPhase;
    }

    public String getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(String statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public String getProposedAnnouncementDate() {
        return proposedAnnouncementDate;
    }

    public void setProposedAnnouncementDate(String proposedAnnouncementDate) {
        this.proposedAnnouncementDate = proposedAnnouncementDate;
    }

    public String getActualAnnouncementDate() {
        return actualAnnouncementDate;
    }

    public void setActualAnnouncementDate(String actualAnnouncementDate) {
        this.actualAnnouncementDate = actualAnnouncementDate;
    }

    public String getTargetOpeningDate() {
        return targetOpeningDate;
    }

    public void setTargetOpeningDate(String targetOpeningDate) {
        this.targetOpeningDate = targetOpeningDate;
    }

    public String getActualOpeningDate() {
        return actualOpeningDate;
    }

    public void setActualOpeningDate(String actualOpeningDate) {
        this.actualOpeningDate = actualOpeningDate;
    }

    public String getProposedImplementationDate() {
        return proposedImplementationDate;
    }

    public void setProposedImplementationDate(String proposedImplementationDate) {
        this.proposedImplementationDate = proposedImplementationDate;
    }

    public String getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(String implementationDate) {
        this.implementationDate = implementationDate;
    }

    public String getDatesComments() {
        return datesComments;
    }

    public void setDatesComments(String datesComments) {
        this.datesComments = datesComments;
    }

    public String getAnyIssuesRisks() {
        return anyIssuesRisks;
    }

    public void setAnyIssuesRisks(String anyIssuesRisks) {
        this.anyIssuesRisks = anyIssuesRisks;
    }

    public String getCurrentApprovedAttachmentTarget() {
        return currentApprovedAttachmentTarget;
    }

    public void setCurrentApprovedAttachmentTarget(String currentApprovedAttachmentTarget) {
        this.currentApprovedAttachmentTarget = currentApprovedAttachmentTarget;
    }

    public String getCurrentApprovedBudget() {
        return currentApprovedBudget;
    }

    public void setCurrentApprovedBudget(String currentApprovedBudget) {
        this.currentApprovedBudget = currentApprovedBudget;
    }

    public String getCurrentApprovedFtes() {
        return currentApprovedFtes;
    }

    public void setCurrentApprovedFtes(String currentApprovedFtes) {
        this.currentApprovedFtes = currentApprovedFtes;
    }

    public PCNStatusTrackerItem getStatusTrackerPcn() {
        return statusTrackerPcn;
    }

    public void setStatusTrackerPcn(PCNStatusTrackerItem statusTrackerPcn) {
        this.statusTrackerPcn = statusTrackerPcn;
    }

    public CHCStatusTrackerItem getStatusTrackerChc() {
        return statusTrackerChc;
    }

    public void setStatusTrackerChc(CHCStatusTrackerItem statusTrackerChc) {
        this.statusTrackerChc = statusTrackerChc;
    }

    public NPPCCStatusTrackerItem getStatusTrackerNppcc() {
        return statusTrackerNppcc;
    }

    public void setStatusTrackerNppcc(NPPCCStatusTrackerItem statusTrackerNppcc) {
        this.statusTrackerNppcc = statusTrackerNppcc;
    }

    public UPCCStatusTrackerItem getStatusTrackerUpcc() {
        return statusTrackerUpcc;
    }

    public void setStatusTrackerUpcc(UPCCStatusTrackerItem statusTrackerUpcc) {
        this.statusTrackerUpcc = statusTrackerUpcc;
    }

    public FNPCCStatusTrackerItem getStatusTrackerFnpcc() {
        return statusTrackerFnpcc;
    }

    public void setStatusTrackerFnpcc(FNPCCStatusTrackerItem statusTrackerFnpcc) {
        this.statusTrackerFnpcc = statusTrackerFnpcc;
    }

    public List<PCNName> getPcnNames() {
        return pcnNames;
    }

    public void setPcnNames(List<PCNName> pcnNames) {
        this.pcnNames = pcnNames;
    }

    public List<ClinicName> getClinicNames() {
        return clinicNames;
    }

    public void setClinicNames(List<ClinicName> clinicNames) {
        this.clinicNames = clinicNames;
    }

    public List<IssueAndRisk> getIssueAndRisks() {
        return issueAndRisks;
    }

    public void setIssueAndRisks(List<IssueAndRisk> issueAndRisks) {
        this.issueAndRisks = issueAndRisks;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.PCD_STATUS_TRACKER_SUBMISSION;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(createdAt);
        elements.add(lateEntry);
        elements.add(submitterFullName);
        elements.add(submitterUserName);
        elements.add(submitterEmail);
        elements.add(submissionStatus);
        elements.add(submissionVersion);
        elements.add(submissionFormName);
        elements.add(typeOfInitiative);
        elements.add(healthAuthority);
        elements.add(communityName);
        elements.add(currentFiscalYear);
        elements.add(currentStatus);
        elements.add(currentPhase);
        elements.add(currentStage);
        elements.add(statusUpdate);
        elements.add(proposedAnnouncementDate);
        elements.add(actualAnnouncementDate);
        elements.add(targetOpeningDate);
        elements.add(actualOpeningDate);
        elements.add(proposedImplementationDate);
        elements.add(implementationDate);
        elements.add(datesComments);
        elements.add(anyIssuesRisks);
        elements.add(currentApprovedAttachmentTarget);
        elements.add(currentApprovedBudget);
        elements.add(currentApprovedFtes);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> pcdStatusTrackerSubmissionIModels = new ArrayList<>();

        if (pcnNames != null) {
            pcdStatusTrackerSubmissionIModels.addAll(pcnNames);
        }

        if (clinicNames != null) {
            pcdStatusTrackerSubmissionIModels.addAll(clinicNames);
        }

        if (issueAndRisks != null) {
            pcdStatusTrackerSubmissionIModels.addAll(issueAndRisks);
        }

        // Handle specific initiative cases
        switch (typeOfInitiative) {
            case "PCN" -> {
                pcdStatusTrackerSubmissionIModels.add(statusTrackerPcn);
            }
            case "CHC" -> {
                pcdStatusTrackerSubmissionIModels.add(statusTrackerChc);
            }
            case "NPPCC" -> {
                pcdStatusTrackerSubmissionIModels.add(statusTrackerNppcc);
            }
            case "UPCC" -> {
                pcdStatusTrackerSubmissionIModels.add(statusTrackerUpcc);
            }
            case "FNPCC" -> {
                pcdStatusTrackerSubmissionIModels.add(statusTrackerFnpcc);
            }
            default -> {
            }
        }
        return pcdStatusTrackerSubmissionIModels;
    }

}
