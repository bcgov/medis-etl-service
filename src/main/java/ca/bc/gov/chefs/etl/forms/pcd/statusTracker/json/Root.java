package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json;

import ca.bc.gov.chefs.etl.core.json.Form;

import java.util.List;

public class Root {
    private Form form;

    public String lateEntry;

    private String pcnName;

    private List<String> pcnNames;

    private String healthAuthority;

    private String typeOfInitiative;

    private String communityName;

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

    private String forecastedImplementationYear;

    private String otherPcIsIncluded;

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

    private String nppccfundingSourcesAndPartnershipStructure;

    private String initiativeName;

    private String hsiarServicePlanGapAnalysis;

    private String announcementDate;

    private RootPCNNameWithType pcnNameWithType;

    private List<RootPCNNameWithType> pcnNamesWithType;

    private List<RootIssueAndRisk> issuesAndRisks;

    private String additionalDetails;

    private String firstNationOrganizationLead;

    private String upccTypeOfCare;

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getPcnName() {
        return pcnName;
    }

    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
    }

    public String getLateEntry() {
        return lateEntry;
    }

    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getTypeOfInitiative() {
        return typeOfInitiative;
    }

    public void setTypeOfInitiative(String typeOfInitiative) {
        this.typeOfInitiative = typeOfInitiative;
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

    public String getForecastedImplementationYear() {
        return forecastedImplementationYear;
    }

    public void setForecastedImplementationYear(String forecastedImplementationYear) {
        this.forecastedImplementationYear = forecastedImplementationYear;
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

    public String getNppccfundingSourcesAndPartnershipStructure() {
        return nppccfundingSourcesAndPartnershipStructure;
    }

    public void setNppccfundingSourcesAndPartnershipStructure(String nppccfundingSourcesAndPartnershipStructure) {
        this.nppccfundingSourcesAndPartnershipStructure = nppccfundingSourcesAndPartnershipStructure;
    }

    public String getInitiativeName() {
        return initiativeName;
    }

    public void setInitiativeName(String initiativeName) {
        this.initiativeName = initiativeName;
    }

    public void setPcnNameWithType(RootPCNNameWithType pcnNameWithType) {
        this.pcnNameWithType = pcnNameWithType;
    }

    public RootPCNNameWithType getPcnNameWithType() {
        return pcnNameWithType;
    }

    public List<RootPCNNameWithType> getPcnNamesWithType() {
        return pcnNamesWithType;
    }

    public void setPcnNamesWithType(List<RootPCNNameWithType> pcnNamesWithType) {
        this.pcnNamesWithType = pcnNamesWithType;
    }

    public List<RootIssueAndRisk> getIssuesAndRisks() {
        return issuesAndRisks;
    }

    public void setIssuesAndRisks(List<RootIssueAndRisk> issuesAndRisks) {
        this.issuesAndRisks = issuesAndRisks;
    }

    public List<String> getPcnNames() {
        return pcnNames;
    }

    public void setPcnNames(List<String> pcnNames) {
        this.pcnNames = pcnNames;
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

    public String getReasonForExceptionInDate() {
        return reasonForExceptionInDate;
    }

    public void setReasonForExceptionInDate(String reasonForExceptionInDate) {
        this.reasonForExceptionInDate = reasonForExceptionInDate;
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
}
