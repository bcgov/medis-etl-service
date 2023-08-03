package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

import java.util.ArrayList;
import java.util.List;

public class StatusTrackerSubmission implements IModel {

    private String confirmationId;

    private String createdAt;


    public String lateEntry;

    private String submitterFullName;

    private String submitterUserName;

    private String submitterEmail;

    private String submissionStatus;

    private String typeOfInitiative;

    private String healthAuthority;

    private String communityName;

    private String pcnName;

    private String currentFiscalYear;

    private String initiativeStatus;

    private String phase;

    private String statusUpdate;

    private String eoiSubmissionDate;

    private String eoiApprovalDate;

    private String spSubmissionDate;

    private String spApprovalDate;

    private String implementationDate;

    private String announcementPending;

    private String targetOpeningDate;

    private String actualOpeningDate;

    private String openDateForScaleUpResources;

    private String reasonForDelay;

    private String reasonForExceptionInDate;

    private String anyIssuesRisk;

    private String attachmentGap;

    private String forecastImplementationYear;

    private String otherPCIsIncluded;

    private String upccName;

    private String upccCovidTestSite;

    private String upccServiceDeliveryMode;

    private String upccChangesToService;

    private String upccChangeToServiceDate;

    private String chcName;

    private String chcAddress;

    private String chcKeyAttributes;

    private String chcFundingSources;

    private String fnpccName;

    private String fnpccFiscalYearAndQuarterLaunch;

    private String fnpccImplementationType;

    private String fnpccAddress;

    private String nppccName;

    private String nppccAddress;

    private String nppccKeyAttributes;

    private String nppccFundingSourcesAndPartnershipStructure;

    private String initiativeName;

    private List<PCNName> pcnNames;

    private List<IssueAndRisk> issueAndRisks;

    private PCNName pcnNameWithType;

    private List<PCNName> pcnNamesWithType;

    private String hsiarServicePlanGapAnalysis;

    private String announcementDate;

    private String additionalDetails;

    private String firstNationOrganizationLead;

    private String upccTypeOfCare;

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = confirmationId;
    }

    public String getLateEntry() {
        return lateEntry;
    }

    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public String getPcnName() {
        return pcnName;
    }

    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
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

    public String getAttachmentGap() {
        return attachmentGap;
    }

    public void setAttachmentGap(String attachmentGap) {
        this.attachmentGap = attachmentGap;
    }

    public String getForecastImplementationYear() {
        return forecastImplementationYear;
    }

    public void setForecastImplementationYear(String forecastImplementationYear) {
        this.forecastImplementationYear = forecastImplementationYear;
    }

    public String getOtherPCIsIncluded() {
        return otherPCIsIncluded;
    }

    public void setOtherPCIsIncluded(String otherPCIsIncluded) {
        this.otherPCIsIncluded = otherPCIsIncluded;
    }

    public String getUpccName() {
        return upccName;
    }

    public void setUpccName(String upccName) {
        this.upccName = upccName;
    }

    public String getUpccCovidTestSite() {
        return upccCovidTestSite;
    }

    public void setUpccCovidTestSite(String upccCovidTestSite) {
        this.upccCovidTestSite = upccCovidTestSite;
    }

    public String getUpccServiceDeliveryMode() {
        return upccServiceDeliveryMode;
    }

    public void setUpccServiceDeliveryMode(String upccServiceDeliveryMode) {
        this.upccServiceDeliveryMode = upccServiceDeliveryMode;
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

    public String getFnpccFiscalYearAndQuarterLaunch() {
        return fnpccFiscalYearAndQuarterLaunch;
    }

    public void setFnpccFiscalYearAndQuarterLaunch(String fnpccFiscalYearAndQuarterLaunch) {
        this.fnpccFiscalYearAndQuarterLaunch = fnpccFiscalYearAndQuarterLaunch;
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

    public String getInitiativeName() {
        return initiativeName;
    }

    public void setInitiativeName(String initiativeName) {
        this.initiativeName = initiativeName;
    }

    public List<PCNName> getPcnNames() {
        return pcnNames;
    }

    public void setPcnNames(List<PCNName> pcnNames) {
        this.pcnNames = pcnNames;
    }

    public List<IssueAndRisk> getIssueAndRisks() {
        return issueAndRisks;
    }

    public void setIssueAndRisks(List<IssueAndRisk> issueAndRisks) {
        this.issueAndRisks = issueAndRisks;
    }

    public PCNName getPcnNameWithType() {
        return pcnNameWithType;
    }

    public void setPcnNameWithType(PCNName pcnNameWithType) {
        this.pcnNameWithType = pcnNameWithType;
    }

    public List<PCNName> getPcnNamesWithType() {
        return pcnNamesWithType;
    }

    public void setPcnNamesWithType(List<PCNName> pcnNamesWithType) {
        this.pcnNamesWithType = pcnNamesWithType;
    }

    public String getHsiarServicePlanGapAnalysis() {
        return hsiarServicePlanGapAnalysis;
    }

    public void setHsiarServicePlanGapAnalysis(String hsiarServicePlanGapAnalysis) {
        this.hsiarServicePlanGapAnalysis = hsiarServicePlanGapAnalysis;
    }

    public String getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(String announcementDate) {
        this.announcementDate = announcementDate;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public String getFirstNationOrganizationLead() {
        return firstNationOrganizationLead;
    }

    public void setFirstNationOrganizationLead(String firstNationOrganizationLead) {
        this.firstNationOrganizationLead = firstNationOrganizationLead;
    }

    public String getUpccTypeOfCare() {
        return upccTypeOfCare;
    }

    public void setUpccTypeOfCare(String upccTypeOfCare) {
        this.upccTypeOfCare = upccTypeOfCare;
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

        elements.add(getPcnName());
        elements.add(getConfirmationId());
        elements.add(getCreatedAt());
        elements.add(getSubmitterFullName());
        elements.add(getSubmitterUserName());
        elements.add(getSubmitterEmail());
        elements.add(getSubmissionStatus());
        elements.add(getTypeOfInitiative());
        elements.add(getHealthAuthority());
        elements.add(getCommunityName());
        elements.add(getCurrentFiscalYear());
        elements.add(getInitiativeStatus());
        elements.add(getPhase());
        elements.add(getStatusUpdate());
        elements.add(getEoiSubmissionDate());
        elements.add(getEoiApprovalDate());
        elements.add(getSpSubmissionDate());
        elements.add(getSpApprovalDate());
        elements.add(getImplementationDate());
        elements.add(getAnnouncementPending());
        elements.add(getTargetOpeningDate());
        elements.add(getActualOpeningDate());
        elements.add(getOpenDateForScaleUpResources());
        elements.add(getReasonForDelay());
        elements.add(getReasonForExceptionInDate());
        elements.add(getAnyIssuesRisk());
        elements.add(getAttachmentGap());
        elements.add(getForecastImplementationYear());
        elements.add(getOtherPCIsIncluded());
        elements.add(getUpccName());
        elements.add(getUpccCovidTestSite());
        elements.add(getUpccServiceDeliveryMode());
        elements.add(getUpccChangesToService());
        elements.add(getUpccChangeToServiceDate());
        elements.add(getChcName());
        elements.add(getChcAddress());
        elements.add(getChcKeyAttributes());
        elements.add(getChcFundingSources());
        elements.add(getFnpccName());
        elements.add(getFnpccFiscalYearAndQuarterLaunch());
        elements.add(getFnpccImplementationType());
        elements.add(getFnpccAddress());
        elements.add(getNppccName());
        elements.add(getNppccAddress());
        elements.add(getNppccKeyAttributes());
        elements.add(getNppccFundingSourcesAndPartnershipStructure());
        elements.add(getInitiativeName());
        elements.add(getHsiarServicePlanGapAnalysis());
        elements.add(getAnnouncementDate());
        elements.add(getAdditionalDetails());
        elements.add(getFirstNationOrganizationLead());
        elements.add(getUpccTypeOfCare());

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> pcdStatusTrackerSubmissionIModels = new ArrayList<>();

        if (getPcnNamesWithType() != null) {
            pcdStatusTrackerSubmissionIModels.addAll(getPcnNamesWithType());
        }

        if (getIssueAndRisks() != null) {
            pcdStatusTrackerSubmissionIModels.addAll(getIssueAndRisks());
        }

        return pcdStatusTrackerSubmissionIModels;
    }
}
