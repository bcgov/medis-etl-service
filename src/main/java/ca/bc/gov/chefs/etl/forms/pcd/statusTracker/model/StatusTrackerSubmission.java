package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class StatusTrackerSubmission implements IModel {

    // Form/submission fields
    private String submissionId;
    private String confirmationId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;

    // Header fields
    private String typeOfInitiative;
    private String healthAuthority;
    private String communityName;
    private String pcnName;
    private List<PCNName> pcnNames;

    // PCN
    private String allClinicsImpacted;
    private List<ClinicName> clinicNames;
    private String hsiarServicePlanGapAnalysis;
    private String pcnForecastedImplementationDate;
    private String otherPcIsIncluded;

    // UPCC
    private String upccName;
    private String upccTypeOfCare;
    private String upccCovidTestSite;
    private String upccChangesToService;
    private String upccChangeToServiceDate;
    private String upccServiceDeliveryMode;

    // CHC
    private String chcName;
    private String chcAddress;
    private String chcKeyAttributes;
    private String chcFundingSources;

    // FNPCC
    private String fnpccName;
    private String fnpccForecastedImplementationDate;
    private String fnpccImplementationType;
    private String fnpccAddress;
    private String fnpccFirstNationOrganizationLead;
    private String fnpccAdditionalDetails;

    // NPPCC
    private String nppccName;
    private String nppccAddress;
    private String nppccKeyAttributes;
    private String nppccFundingSourcesAndPartnershipStructure;

    // Status
    private String currentFiscalYear;
    private String initiativeStatus;
    private String phase;
    private String statusUpdate;

    // Initiative Dates
    private String eoiSubmissionDate;
    private String eoiApprovalDate;
    private String spSubmissionDate;

    private String spApprovalDate;
    private String implementationDate;
    private String announcementPending;
    private String announcementDate;

    private String targetOpeningDate;
    private String actualOpeningDate;
    private String scaleUpResources;
    private String openDateForScaleUpResources;

    private String reasonForDelay;
    private String reasonForExceptionInDate;

    // Issues and/or Risks
    private String anyIssuesRisk;
    private List<IssueAndRisk> issueAndRisks;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = confirmationId;
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
        this.lateEntry = lateEntry;
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

    public String getPcnName() {
        return pcnName;
    }

    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
    }

    public List<PCNName> getPcnNames() {
        return pcnNames;
    }

    public void setPcnNames(List<PCNName> pcnNames) {
        this.pcnNames = pcnNames;
    }

    public String getAllClinicsImpacted() {
        return allClinicsImpacted;
    }

    public void setAllClinicsImpacted(String allClinicsImpacted) {
        this.allClinicsImpacted = allClinicsImpacted;
    }

    public List<ClinicName> getClinicNames() {
        return clinicNames;
    }

    public void setClinicNames(List<ClinicName> clinicNames) {
        this.clinicNames = clinicNames;
    }

    public String getHsiarServicePlanGapAnalysis() {
        return hsiarServicePlanGapAnalysis;
    }

    public void setHsiarServicePlanGapAnalysis(String hsiarServicePlanGapAnalysis) {
        this.hsiarServicePlanGapAnalysis = hsiarServicePlanGapAnalysis;
    }

    public String getPcnForecastedImplementationDate() {
        return pcnForecastedImplementationDate;
    }

    public void setPcnForecastedImplementationDate(String pcnForecastedImplementationDate) {
        this.pcnForecastedImplementationDate = pcnForecastedImplementationDate;
    }

    public String getOtherPcIsIncluded() {
        return otherPcIsIncluded;
    }

    public void setOtherPcIsIncluded(String otherPcIsIncluded) {
        this.otherPcIsIncluded = otherPcIsIncluded;
    }

    public String getUpccName() {
        return upccName;
    }

    public void setUpccName(String upccName) {
        this.upccName = upccName;
    }

    public String getUpccTypeOfCare() {
        return upccTypeOfCare;
    }

    public void setUpccTypeOfCare(String upccTypeOfCare) {
        this.upccTypeOfCare = upccTypeOfCare;
    }

    public String getUpccCovidTestSite() {
        return upccCovidTestSite;
    }

    public void setUpccCovidTestSite(String upccCovidTestSite) {
        this.upccCovidTestSite = upccCovidTestSite;
    }

    public String getUpccChangesToService() {
        return upccChangesToService;
    }

    public void setUpccChangesToService(String upccChangesToService) {
        this.upccChangesToService = upccChangesToService;
    }

    public String getUpccChangeToServiceDate() {
        return upccChangeToServiceDate;
    }

    public void setUpccChangeToServiceDate(String upccChangeToServiceDate) {
        this.upccChangeToServiceDate = upccChangeToServiceDate;
    }

    public String getUpccServiceDeliveryMode() {
        return upccServiceDeliveryMode;
    }

    public void setUpccServiceDeliveryMode(String upccServiceDeliveryMode) {
        this.upccServiceDeliveryMode = upccServiceDeliveryMode;
    }

    public String getChcName() {
        return chcName;
    }

    public void setChcName(String chcName) {
        this.chcName = chcName;
    }

    public String getChcAddress() {
        return chcAddress;
    }

    public void setChcAddress(String chcAddress) {
        this.chcAddress = chcAddress;
    }

    public String getChcKeyAttributes() {
        return chcKeyAttributes;
    }

    public void setChcKeyAttributes(String chcKeyAttributes) {
        this.chcKeyAttributes = chcKeyAttributes;
    }

    public String getChcFundingSources() {
        return chcFundingSources;
    }

    public void setChcFundingSources(String chcFundingSources) {
        this.chcFundingSources = chcFundingSources;
    }

    public String getFnpccName() {
        return fnpccName;
    }

    public void setFnpccName(String fnpccName) {
        this.fnpccName = fnpccName;
    }

    public String getFnpccForecastedImplementationDate() {
        return fnpccForecastedImplementationDate;
    }

    public void setFnpccForecastedImplementationDate(String fnpccForecastedImplementationDate) {
        this.fnpccForecastedImplementationDate = fnpccForecastedImplementationDate;
    }

    public String getFnpccImplementationType() {
        return fnpccImplementationType;
    }

    public void setFnpccImplementationType(String fnpccImplementationType) {
        this.fnpccImplementationType = fnpccImplementationType;
    }

    public String getFnpccAddress() {
        return fnpccAddress;
    }

    public void setFnpccAddress(String fnpccAddress) {
        this.fnpccAddress = fnpccAddress;
    }

    public String getFnpccFirstNationOrganizationLead() {
        return fnpccFirstNationOrganizationLead;
    }

    public void setFnpccFirstNationOrganizationLead(String fnpccFirstNationOrganizationLead) {
        this.fnpccFirstNationOrganizationLead = fnpccFirstNationOrganizationLead;
    }

    public String getFnpccAdditionalDetails() {
        return fnpccAdditionalDetails;
    }

    public void setFnpccAdditionalDetails(String fnpccAdditionalDetails) {
        this.fnpccAdditionalDetails = fnpccAdditionalDetails;
    }

    public String getNppccName() {
        return nppccName;
    }

    public void setNppccName(String nppccName) {
        this.nppccName = nppccName;
    }

    public String getNppccAddress() {
        return nppccAddress;
    }

    public void setNppccAddress(String nppccAddress) {
        this.nppccAddress = nppccAddress;
    }

    public String getNppccKeyAttributes() {
        return nppccKeyAttributes;
    }

    public void setNppccKeyAttributes(String nppccKeyAttributes) {
        this.nppccKeyAttributes = nppccKeyAttributes;
    }

    public String getNppccFundingSourcesAndPartnershipStructure() {
        return nppccFundingSourcesAndPartnershipStructure;
    }

    public void setNppccFundingSourcesAndPartnershipStructure(String nppccFundingSourcesAndPartnershipStructure) {
        this.nppccFundingSourcesAndPartnershipStructure = nppccFundingSourcesAndPartnershipStructure;
    }

    public String getCurrentFiscalYear() {
        return currentFiscalYear;
    }

    public void setCurrentFiscalYear(String currentFiscalYear) {
        this.currentFiscalYear = currentFiscalYear;
    }

    public String getInitiativeStatus() {
        return initiativeStatus;
    }

    public void setInitiativeStatus(String initiativeStatus) {
        this.initiativeStatus = initiativeStatus;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(String statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public String getEoiSubmissionDate() {
        return eoiSubmissionDate;
    }

    public void setEoiSubmissionDate(String eoiSubmissionDate) {
        this.eoiSubmissionDate = eoiSubmissionDate;
    }

    public String getEoiApprovalDate() {
        return eoiApprovalDate;
    }

    public void setEoiApprovalDate(String eoiApprovalDate) {
        this.eoiApprovalDate = eoiApprovalDate;
    }

    public String getSpSubmissionDate() {
        return spSubmissionDate;
    }

    public void setSpSubmissionDate(String spSubmissionDate) {
        this.spSubmissionDate = spSubmissionDate;
    }

    public String getSpApprovalDate() {
        return spApprovalDate;
    }

    public void setSpApprovalDate(String spApprovalDate) {
        this.spApprovalDate = spApprovalDate;
    }

    public String getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(String implementationDate) {
        this.implementationDate = implementationDate;
    }

    public String getAnnouncementPending() {
        return announcementPending;
    }

    public void setAnnouncementPending(String announcementPending) {
        this.announcementPending = announcementPending;
    }

    public String getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(String announcementDate) {
        this.announcementDate = announcementDate;
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

    public String getScaleUpResources() {
        return scaleUpResources;
    }

    public void setScaleUpResources(String scaleUpResources) {
        this.scaleUpResources = scaleUpResources;
    }

    public String getOpenDateForScaleUpResources() {
        return openDateForScaleUpResources;
    }

    public void setOpenDateForScaleUpResources(String openDateForScaleUpResources) {
        this.openDateForScaleUpResources = openDateForScaleUpResources;
    }

    public String getReasonForDelay() {
        return reasonForDelay;
    }

    public void setReasonForDelay(String reasonForDelay) {
        this.reasonForDelay = reasonForDelay;
    }

    public String getReasonForExceptionInDate() {
        return reasonForExceptionInDate;
    }

    public void setReasonForExceptionInDate(String reasonForExceptionInDate) {
        this.reasonForExceptionInDate = reasonForExceptionInDate;
    }

    public String getAnyIssuesRisk() {
        return anyIssuesRisk;
    }

    public void setAnyIssuesRisk(String anyIssuesRisk) {
        this.anyIssuesRisk = anyIssuesRisk;
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
        return Constants.PCD_STATUS_TRACKER_SUBMISSION;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(confirmationId);
        elements.add(createdAt);
        elements.add(lateEntry);
        elements.add(submitterFullName);
        elements.add(submitterUserName);
        elements.add(submitterEmail);
        elements.add(submissionStatus);
        elements.add(submissionVersion);
        elements.add(submissionFormName);

        // Header fields
        elements.add(typeOfInitiative);
        elements.add(healthAuthority);
        elements.add(communityName);

        // PCN
        elements.add(allClinicsImpacted);
        elements.add(hsiarServicePlanGapAnalysis);
        elements.add(pcnForecastedImplementationDate);
        elements.add(otherPcIsIncluded);

        // UPCC
        elements.add(upccName);
        elements.add(upccTypeOfCare);
        elements.add(upccCovidTestSite);
        elements.add(upccChangesToService);
        elements.add(upccChangeToServiceDate);
        elements.add(upccServiceDeliveryMode);

        // CHC
        elements.add(chcName);
        elements.add(chcAddress);
        elements.add(chcKeyAttributes);
        elements.add(chcFundingSources);

        // FNPCC
        elements.add(fnpccName);
        elements.add(fnpccForecastedImplementationDate);
        elements.add(fnpccImplementationType);
        elements.add(fnpccAddress);
        elements.add(fnpccFirstNationOrganizationLead);
        elements.add(fnpccAdditionalDetails);

        // NPPCC
        elements.add(nppccName);
        elements.add(nppccAddress);
        elements.add(nppccKeyAttributes);
        elements.add(nppccFundingSourcesAndPartnershipStructure);

        // Status
        elements.add(currentFiscalYear);
        elements.add(initiativeStatus);
        elements.add(phase);
        elements.add(statusUpdate);

        // Initiative Dates
        elements.add(eoiSubmissionDate);
        elements.add(eoiApprovalDate);
        elements.add(spSubmissionDate);

        elements.add(spApprovalDate);
        elements.add(implementationDate);
        elements.add(announcementPending);
        elements.add(announcementDate);

        elements.add(targetOpeningDate);
        elements.add(actualOpeningDate);
        elements.add(scaleUpResources);
        elements.add(openDateForScaleUpResources);

        elements.add(reasonForDelay);
        elements.add(reasonForExceptionInDate);
        
        // Issues and/or Risks
        elements.add(anyIssuesRisk);

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

        return pcdStatusTrackerSubmissionIModels;
    }
}
