package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;
import ca.bc.gov.chefs.etl.util.CSVUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    // Form/submission fields
    private Form form;
    private String lateEntry;

    // Header fields
    private String typeOfInitiative;
    private String healthAuthority;
    private String communityName;
    private String pcnName;
    private List<String> pcnNames;
    private RootPCNNameWithType pcnNameWithType;
    private List<RootPCNNameWithType> pcnNamesWithType;
    private String setSelectedInitiative;

    // PCN
    private String allClinicsImpacted;
    private List<String> clinicNames;
    private String hsiarServicePlanGapAnalysis;
    private String hsiarServicePlanGapAnalysisDate;
    private String pcnForecastedImplementationDate;
    private String otherPcIsIncluded;
    private String pcnInEoiAppDate;
    private String pcnInEoiSubDate;
    private String pcnInEoiAppNotes;
    private String pcnInEoiSubNotes;
    private String pcnImStbStdStaDate;
    private String pcnPlComAppMtgDate;
    private String pcnImStbStdStaNotes;
    private String pcnPlComAppMtgNotes;
    private String pcnImEstFndPreLncDate;
    private String pcnPlFunPkgAppIssDate;
    private String pcnPlFunPkgAppPenDate;
    private String pcnImEstFndPreLncNotes;
    private String pcnPlFunPkgAppIssNotes;
    private String pcnPlFunPkgAppPenNotes;
    private String pcnImSerPubBldCapLncDate;
    private String pcnPlSerPlnOprBudEdrDate;
    private String pcnImSerPubBldCapLncNotes;
    private String pcnPlSerPlnOprBudEdrNotes;
    private String pcnPlSerPlnOprBudSubUndRevDate;
    private String pcnPlSerPlnOprBudSubUndRevNotes;

    // UPCC
    private String upccName;
    private String upccAddress;
    private String upccTypeOfCare;
    private String upccCovidTestSite;
    private String upccInComSelDate;
    private String upccInComSelNotes;
    private String upccImStbFulOprDate;
    private String upccInConSumSubDate;
    private String upccImStbFulOprNotes;
    private String upccInConSumSubNotes;
    private String upccInConSumAccCfmDate;
    private String upccPlFunPkgAppIssDate;
    private String upccPlFunPkgAppPenDate;
    private String upccInConSumAccCfmNotes;
    private String upccPlFunPkgAppIssNotes;
    private String upccPlFunPkgAppPenNotes;
    private String upccImEstFndAppNotOpnDate;
    private String upccPlSerPlnOprBudEdrDate;
    private String upccImEstFndAppNotOpnNotes;
    private String upccPlSerPlnOprBudEdrNotes;
    private String upccImSerPubBldCapDrsOpnDate;
    private String upccImSerPubBldCapDrsOpnNotes;
    private String upccPlSerPlnOprBudSubUndRevDate;
    private String upccPlSerPlnOprBudSubUndRevNotes;
    private String upccChangesToService;
    private String upccChangeToServiceDate;
    private String upccServiceDeliveryMode;

    // CHC
    private String chcName;
    private String chcAddress;
    private String chcKeyAttributes;
    private String chcFundingSources;
    private String chcPlProEdrDate;
    private String chcPlProSubDate;
    private String chcPlProEdrNotes;
    private String chcPlProSubNotes;
    private String chcImStbFulOprDate;
    private String chcInConSumSubDate;
    private String chcImStbFulOprNotes;
    private String chcInConSumSubNotes;
    private String chcImplementationType;
    private String chcInConSumAccCfmDate;
    private String chcPlFunPkgAppIssDate;
    private String chcPlFunPkgAppPenDate;
    private String chcInConSumAccCfmNotes;
    private String chcPlFunPkgAppIssNotes;
    private String chcPlFunPkgAppPenNotes;
    private String chcImEstFndAppNotOpnDate;
    private String chcImEstFndAppNotOpnNotes;
    private String chcImSerPubBldCapDrsOpnDate;
    private String chcImSerPubBldCapDrsOpnNotes;

    // FNPCC
    private String fnpccName;
    private String fnpccForecastedImplementationDate;
    private String fnpccImplementationType;
    private String fnpccAddress;
    private String fnpccFirstNationOrganizationLead;
    private String fnpccAdditionalDetails;
    private String fnpccInPreAnlRepCfmDate;
    private String fnpccInPreAnlRepSubDate;
    private String fnpccPlFunPkgAppIssDate;
    private String fnpccPlFunPkgAppPenDate;
    private String fnpccPlTrgSerPlnRevDate;
    private String fnpccInPreAnlRepCfmNotes;
    private String fnpccInPreAnlRepSubNotes;
    private String fnpccPlFunPkgAppIssNotes;
    private String fnpccPlFunPkgAppPenNotes;
    private String fnpccPlTrgSerPlnRevNotes;
    private String fnpccImEstFndAppNotOpnDate;
    private String fnpccPlMinFnhSerPlnRevDate;
    private String fnpccPlSerPlnAwtFnhEndDate;
    private String fnpccPlSerPlnAwtMinEndDate;
    private String fnpccPlSerPlnOprBudEdrDate;
    private String fnpccImEstFndAppNotOpnNotes;
    private String fnpccPlMinFnhSerPlnRevNotes;
    private String fnpccPlSerPlnAwtFnhEndNotes;
    private String fnpccPlSerPlnAwtMinEndNotes;
    private String fnpccPlSerPlnOprBudEdrNotes;
    private String fnpccImStbFulOprDate;
    private String fnpccImStbFulOprNotes;
    private String fnpccPlSerPlnAwtFnhAppDate;
    private String fnpccPlSerPlnAwtMinAppDate;
    private String fnpccImSerPubBldCapDrsOpnDate;
    private String fnpccImSerPubBldCapDrsOpnNotes;
    private String fnpccPlSerPlnOprBudSubUndRevDate;
    private String fnpccPlSerPlnOprBudSubUndRevNotes;
    private String fnpccfundingSourcesAndPartnershipStructure;

    // NPPCC
    private String nppccName;
    private String nppccAddress;
    private String nppccKeyAttributes;
    private String nppccfundingSourcesAndPartnershipStructure;
    private String nppccPlProEdrDate;
    private String nppccPlProSubDate;
    private String nppccPlProEdrNotes;
    private String nppccPlProSubNotes;
    private String nppccImStbFulOprDate;
    private String nppccImStbFulOprNotes;
    private String nppccImplementationType;
    private String nppccPlFunPkgAppIssDate;
    private String nppccPlFunPkgAppPenDate;
    private String nppccPlFunPkgAppIssNotes;
    private String nppccPlFunPkgAppPenNotes;
    private String nppccImEstFndAppNotOpnDate;
    private String nppccImEstFndAppNotOpnNotes;
    private String nppccImSerPubBldCapDrsOpnDate;
    private String nppccImSerPubBldCapDrsOpnNotes;

    // Status
    private String currentFiscalYear;
    private String statusUpdate;
    private String currentStatus;
    private String currentPhase;
    private String currentStage;

    // Initiative Dates
    private String eoiSubmissionDate;
    private String eoiApprovalDate;
    private String spSubmissionDate;

    private String spApprovalDate;
    private String implementationDate;
    private String implementationYear;
    private String announcementPending;
    private String announcementDate;
    private String actualAnnouncementDate;
    private String proposedAnnouncementDate;
    private String proposedImplementationDate;

    private String scaleUpResources;
    private String openDateForScaleUpResources;
    private String actualLaunchOpenDate;
    private String targetLaunchOpenDate;

    private String reasonForDelay;
    private String reasonForExceptionInDate;

    // Issues and/or Risks
    private String anyIssuesRisk;
    private List<RootIssueAndRisk> issuesAndRisks;

    // Comments
    private String dateComments;

    // FTEs and numbers
    private String currentApprovedFtEs;
    private String currentApprovedBudget;
    private String currentApprovedAttachmentTarget;

    // Deprecated
    // XXX These fields are deprecated/renamed and won't be mapped to the export
    private String forecastedImplementationYear;
    private String fnpccFiscalYearAndQuarterLaunch;



    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getLateEntry() {
        return lateEntry;
    }

    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
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

    public List<String> getPcnNames() {
        return pcnNames;
    }

    public void setPcnNames(List<String> pcnNames) {
        this.pcnNames = pcnNames;
    }

    public RootPCNNameWithType getPcnNameWithType() {
        return pcnNameWithType;
    }

    public void setPcnNameWithType(RootPCNNameWithType pcnNameWithType) {
        this.pcnNameWithType = pcnNameWithType;
    }

    public List<RootPCNNameWithType> getPcnNamesWithType() {
        return pcnNamesWithType;
    }

    public void setPcnNamesWithType(List<RootPCNNameWithType> pcnNamesWithType) {
        this.pcnNamesWithType = pcnNamesWithType;
    }

    public String getAllClinicsImpacted() {
        return allClinicsImpacted;
    }

    public void setAllClinicsImpacted(String allClinicsImpacted) {
        this.allClinicsImpacted = allClinicsImpacted;
    }

    public List<String> getClinicNames() {
        return clinicNames;
    }

    public void setClinicNames(List<String> clinicNames) {
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
        this.pcnForecastedImplementationDate = CSVUtil.formatDate(pcnForecastedImplementationDate);
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
        return CSVUtil.replaceCarriageReturnLineFeed(upccChangesToService);
    }

    public void setUpccChangesToService(String upccChangesToService) {
        this.upccChangesToService = upccChangesToService;
    }

    public String getUpccChangeToServiceDate() {
        return upccChangeToServiceDate;
    }

    public void setUpccChangeToServiceDate(String upccChangeToServiceDate) {
        this.upccChangeToServiceDate = CSVUtil.formatDate(upccChangeToServiceDate);
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
        return CSVUtil.replaceCarriageReturnLineFeed(chcAddress);
    }

    public void setChcAddress(String chcAddress) {
        this.chcAddress = chcAddress;
    }

    public String getChcKeyAttributes() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcKeyAttributes);
    }

    public void setChcKeyAttributes(String chcKeyAttributes) {
        this.chcKeyAttributes = chcKeyAttributes;
    }

    public String getChcFundingSources() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcFundingSources);
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
        this.fnpccForecastedImplementationDate =
                CSVUtil.formatDate(fnpccForecastedImplementationDate);
    }

    public String getFnpccImplementationType() {
        return fnpccImplementationType;
    }

    public void setFnpccImplementationType(String fnpccImplementationType) {
        this.fnpccImplementationType = fnpccImplementationType;
    }

    public String getFnpccAddress() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccAddress);
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
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccAdditionalDetails);
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
        return CSVUtil.replaceCarriageReturnLineFeed(nppccAddress);
    }

    public void setNppccAddress(String nppccAddress) {
        this.nppccAddress = nppccAddress;
    }

    public String getNppccKeyAttributes() {
        return CSVUtil.replaceCarriageReturnLineFeed(nppccKeyAttributes);
    }

    public void setNppccKeyAttributes(String nppccKeyAttributes) {
        this.nppccKeyAttributes = nppccKeyAttributes;
    }

    public String getNppccfundingSourcesAndPartnershipStructure() {
        return CSVUtil.replaceCarriageReturnLineFeed(nppccfundingSourcesAndPartnershipStructure);
    }

    public void setNppccfundingSourcesAndPartnershipStructure(
            String nppccfundingSourcesAndPartnershipStructure) {
        this.nppccfundingSourcesAndPartnershipStructure =
                nppccfundingSourcesAndPartnershipStructure;
    }

    public String getCurrentFiscalYear() {
        return currentFiscalYear;
    }

    public void setCurrentFiscalYear(String currentFiscalYear) {
        this.currentFiscalYear = currentFiscalYear;
    }

    public String getStatusUpdate() {
        return CSVUtil.replaceCarriageReturnLineFeed(statusUpdate);
    }

    public void setStatusUpdate(String statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public String getEoiSubmissionDate() {
        return eoiSubmissionDate;
    }

    public void setEoiSubmissionDate(String eoiSubmissionDate) {
        this.eoiSubmissionDate = CSVUtil.formatDate(eoiSubmissionDate);
    }

    public String getEoiApprovalDate() {
        return eoiApprovalDate;
    }

    public void setEoiApprovalDate(String eoiApprovalDate) {
        this.eoiApprovalDate = CSVUtil.formatDate(eoiApprovalDate);
    }

    public String getSpSubmissionDate() {
        return spSubmissionDate;
    }

    public void setSpSubmissionDate(String spSubmissionDate) {
        this.spSubmissionDate = CSVUtil.formatDate(spSubmissionDate);
    }

    public String getSpApprovalDate() {
        return spApprovalDate;
    }

    public void setSpApprovalDate(String spApprovalDate) {
        this.spApprovalDate = CSVUtil.formatDate(spApprovalDate);
    }

    public String getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(String implementationDate) {
        this.implementationDate = CSVUtil.formatDate(implementationDate);
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
        this.announcementDate = CSVUtil.formatDate(announcementDate);
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
        this.openDateForScaleUpResources = CSVUtil.formatDate(openDateForScaleUpResources);
    }

    public String getReasonForDelay() {
        return CSVUtil.replaceCarriageReturnLineFeed(reasonForDelay);
    }

    public void setReasonForDelay(String reasonForDelay) {
        this.reasonForDelay = reasonForDelay;
    }

    public String getReasonForExceptionInDate() {
        return CSVUtil.replaceCarriageReturnLineFeed(reasonForExceptionInDate);
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

    public List<RootIssueAndRisk> getIssuesAndRisks() {
        return issuesAndRisks;
    }

    public void setIssuesAndRisks(List<RootIssueAndRisk> issuesAndRisks) {
        this.issuesAndRisks = issuesAndRisks;
    }

    public String getForecastedImplementationYear() {
        return forecastedImplementationYear;
    }

    public void setForecastedImplementationYear(String forecastedImplementationYear) {
        this.forecastedImplementationYear = forecastedImplementationYear;
    }

    public String getFnpccFiscalYearAndQuarterLaunch() {
        return fnpccFiscalYearAndQuarterLaunch;
    }

    public void setFnpccFiscalYearAndQuarterLaunch(String fnpccFiscalYearAndQuarterLaunch) {
        this.fnpccFiscalYearAndQuarterLaunch = fnpccFiscalYearAndQuarterLaunch;
    }

    public String getSetSelectedInitiative() {
        return setSelectedInitiative;
    }

    public void setSetSelectedInitiative(String setSelectedInitiative) {
        this.setSelectedInitiative = setSelectedInitiative;
    }

    public String getPcnInEoiAppDate() {
        return pcnInEoiAppDate;
    }

    public void setPcnInEoiAppDate(String pcnInEoiAppDate) {
        this.pcnInEoiAppDate = CSVUtil.formatDate(pcnInEoiAppDate);
    }

    public String getPcnInEoiSubDate() {
        return pcnInEoiSubDate;
    }

    public void setPcnInEoiSubDate(String pcnInEoiSubDate) {
        this.pcnInEoiSubDate = CSVUtil.formatDate(pcnInEoiSubDate);
    }

    public String getPcnInEoiAppNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(pcnInEoiAppNotes);
    }

    public void setPcnInEoiAppNotes(String pcnInEoiAppNotes) {
        this.pcnInEoiAppNotes = pcnInEoiAppNotes;
    }

    public String getPcnInEoiSubNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(pcnInEoiSubNotes);
    }

    public void setPcnInEoiSubNotes(String pcnInEoiSubNotes) {
        this.pcnInEoiSubNotes = pcnInEoiSubNotes;
    }

    public String getPcnImStbStdStaDate() {
        return pcnImStbStdStaDate;
    }

    public void setPcnImStbStdStaDate(String pcnImStbStdStaDate) {
        this.pcnImStbStdStaDate = CSVUtil.formatDate(pcnImStbStdStaDate);
    }

    public String getPcnPlComAppMtgDate() {
        return pcnPlComAppMtgDate;
    }

    public void setPcnPlComAppMtgDate(String pcnPlComAppMtgDate) {
        this.pcnPlComAppMtgDate = CSVUtil.formatDate(pcnPlComAppMtgDate);
    }

    public String getPcnImStbStdStaNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(pcnImStbStdStaNotes);
    }

    public void setPcnImStbStdStaNotes(String pcnImStbStdStaNotes) {
        this.pcnImStbStdStaNotes = pcnImStbStdStaNotes;
    }

    public String getPcnPlComAppMtgNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(pcnPlComAppMtgNotes);
    }

    public void setPcnPlComAppMtgNotes(String pcnPlComAppMtgNotes) {
        this.pcnPlComAppMtgNotes = pcnPlComAppMtgNotes;
    }

    public String getPcnImEstFndPreLncDate() {
        return pcnImEstFndPreLncDate;
    }

    public void setPcnImEstFndPreLncDate(String pcnImEstFndPreLncDate) {
        this.pcnImEstFndPreLncDate = CSVUtil.formatDate(pcnImEstFndPreLncDate);
    }

    public String getPcnPlFunPkgAppIssDate() {
        return pcnPlFunPkgAppIssDate;
    }

    public void setPcnPlFunPkgAppIssDate(String pcnPlFunPkgAppIssDate) {
        this.pcnPlFunPkgAppIssDate = CSVUtil.formatDate(pcnPlFunPkgAppIssDate);
    }

    public String getPcnPlFunPkgAppPenDate() {
        return pcnPlFunPkgAppPenDate;
    }

    public void setPcnPlFunPkgAppPenDate(String pcnPlFunPkgAppPenDate) {
        this.pcnPlFunPkgAppPenDate = CSVUtil.formatDate(pcnPlFunPkgAppPenDate);
    }

    public String getPcnImEstFndPreLncNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(pcnImEstFndPreLncNotes);
    }

    public void setPcnImEstFndPreLncNotes(String pcnImEstFndPreLncNotes) {
        this.pcnImEstFndPreLncNotes = pcnImEstFndPreLncNotes;
    }

    public String getPcnPlFunPkgAppIssNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(pcnPlFunPkgAppIssNotes);
    }

    public void setPcnPlFunPkgAppIssNotes(String pcnPlFunPkgAppIssNotes) {
        this.pcnPlFunPkgAppIssNotes = pcnPlFunPkgAppIssNotes;
    }

    public String getPcnPlFunPkgAppPenNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(pcnPlFunPkgAppPenNotes);
    }

    public void setPcnPlFunPkgAppPenNotes(String pcnPlFunPkgAppPenNotes) {
        this.pcnPlFunPkgAppPenNotes = pcnPlFunPkgAppPenNotes;
    }

    public String getPcnImSerPubBldCapLncDate() {
        return pcnImSerPubBldCapLncDate;
    }

    public void setPcnImSerPubBldCapLncDate(String pcnImSerPubBldCapLncDate) {
        this.pcnImSerPubBldCapLncDate = CSVUtil.formatDate(pcnImSerPubBldCapLncDate);
    }

    public String getPcnPlSerPlnOprBudEdrDate() {
        return pcnPlSerPlnOprBudEdrDate;
    }

    public void setPcnPlSerPlnOprBudEdrDate(String pcnPlSerPlnOprBudEdrDate) {
        this.pcnPlSerPlnOprBudEdrDate = CSVUtil.formatDate(pcnPlSerPlnOprBudEdrDate);
    }

    public String getPcnImSerPubBldCapLncNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(pcnImSerPubBldCapLncNotes);
    }

    public void setPcnImSerPubBldCapLncNotes(String pcnImSerPubBldCapLncNotes) {
        this.pcnImSerPubBldCapLncNotes = pcnImSerPubBldCapLncNotes;
    }

    public String getPcnPlSerPlnOprBudEdrNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(pcnPlSerPlnOprBudEdrNotes);
    }

    public void setPcnPlSerPlnOprBudEdrNotes(String pcnPlSerPlnOprBudEdrNotes) {
        this.pcnPlSerPlnOprBudEdrNotes = pcnPlSerPlnOprBudEdrNotes;
    }

    public String getPcnPlSerPlnOprBudSubUndRevNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(pcnPlSerPlnOprBudSubUndRevNotes);
    }

    public void setPcnPlSerPlnOprBudSubUndRevNotes(String pcnPlSerPlnOprBudSubUndRevNotes) {
        this.pcnPlSerPlnOprBudSubUndRevNotes = pcnPlSerPlnOprBudSubUndRevNotes;
    }

    public String getUpccAddress() {
        return upccAddress;
    }

    public void setUpccAddress(String upccAddress) {
        this.upccAddress = upccAddress;
    }

    public String getUpccInComSelDate() {
        return upccInComSelDate;
    }

    public void setUpccInComSelDate(String upccInComSelDate) {
        this.upccInComSelDate = CSVUtil.formatDate(upccInComSelDate);
    }

    public String getUpccInComSelNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccInComSelNotes);
    }

    public void setUpccInComSelNotes(String upccInComSelNotes) {
        this.upccInComSelNotes = upccInComSelNotes;
    }

    public String getUpccImStbFulOprDate() {
        return upccImStbFulOprDate;
    }

    public void setUpccImStbFulOprDate(String upccImStbFulOprDate) {
        this.upccImStbFulOprDate = CSVUtil.formatDate(upccImStbFulOprDate);
    }

    public String getUpccInConSumSubDate() {
        return upccInConSumSubDate;
    }

    public void setUpccInConSumSubDate(String upccInConSumSubDate) {
        this.upccInConSumSubDate = CSVUtil.formatDate(upccInConSumSubDate);
    }

    public String getUpccImStbFulOprNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccImStbFulOprNotes);
    }

    public void setUpccImStbFulOprNotes(String upccImStbFulOprNotes) {
        this.upccImStbFulOprNotes = upccImStbFulOprNotes;
    }

    public String getUpccInConSumSubNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccInConSumSubNotes);
    }

    public void setUpccInConSumSubNotes(String upccInConSumSubNotes) {
        this.upccInConSumSubNotes = upccInConSumSubNotes;
    }

    public String getUpccInConSumAccCfmDate() {
        return upccInConSumAccCfmDate;
    }

    public void setUpccInConSumAccCfmDate(String upccInConSumAccCfmDate) {
        this.upccInConSumAccCfmDate = CSVUtil.formatDate(upccInConSumAccCfmDate);
    }

    public String getUpccPlFunPkgAppIssDate() {
        return upccPlFunPkgAppIssDate;
    }

    public void setUpccPlFunPkgAppIssDate(String upccPlFunPkgAppIssDate) {
        this.upccPlFunPkgAppIssDate = CSVUtil.formatDate(upccPlFunPkgAppIssDate);
    }

    public String getUpccPlFunPkgAppPenDate() {
        return upccPlFunPkgAppPenDate;
    }

    public void setUpccPlFunPkgAppPenDate(String upccPlFunPkgAppPenDate) {
        this.upccPlFunPkgAppPenDate = CSVUtil.formatDate(upccPlFunPkgAppPenDate);
    }

    public String getUpccInConSumAccCfmNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccInConSumAccCfmNotes);
    }

    public void setUpccInConSumAccCfmNotes(String upccInConSumAccCfmNotes) {
        this.upccInConSumAccCfmNotes = upccInConSumAccCfmNotes;
    }

    public String getUpccPlFunPkgAppIssNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccPlFunPkgAppIssNotes);
    }

    public void setUpccPlFunPkgAppIssNotes(String upccPlFunPkgAppIssNotes) {
        this.upccPlFunPkgAppIssNotes = upccPlFunPkgAppIssNotes;
    }

    public String getUpccPlFunPkgAppPenNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccPlFunPkgAppPenNotes);
    }

    public void setUpccPlFunPkgAppPenNotes(String upccPlFunPkgAppPenNotes) {
        this.upccPlFunPkgAppPenNotes = upccPlFunPkgAppPenNotes;
    }

    public String getUpccImEstFndAppNotOpnDate() {
        return upccImEstFndAppNotOpnDate;
    }

    public void setUpccImEstFndAppNotOpnDate(String upccImEstFndAppNotOpnDate) {
        this.upccImEstFndAppNotOpnDate = CSVUtil.formatDate(upccImEstFndAppNotOpnDate);
    }

    public String getUpccPlSerPlnOprBudEdrDate() {
        return upccPlSerPlnOprBudEdrDate;
    }

    public void setUpccPlSerPlnOprBudEdrDate(String upccPlSerPlnOprBudEdrDate) {
        this.upccPlSerPlnOprBudEdrDate = CSVUtil.formatDate(upccPlSerPlnOprBudEdrDate);
    }

    public String getUpccImEstFndAppNotOpnNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccImEstFndAppNotOpnNotes);
    }

    public void setUpccImEstFndAppNotOpnNotes(String upccImEstFndAppNotOpnNotes) {
        this.upccImEstFndAppNotOpnNotes = upccImEstFndAppNotOpnNotes;
    }

    public String getUpccPlSerPlnOprBudEdrNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccPlSerPlnOprBudEdrNotes);
    }

    public void setUpccPlSerPlnOprBudEdrNotes(String upccPlSerPlnOprBudEdrNotes) {
        this.upccPlSerPlnOprBudEdrNotes = upccPlSerPlnOprBudEdrNotes;
    }

    public String getUpccImSerPubBldCapDrsOpnDate() {
        return upccImSerPubBldCapDrsOpnDate;
    }

    public void setUpccImSerPubBldCapDrsOpnDate(String upccImSerPubBldCapDrsOpnDate) {
        this.upccImSerPubBldCapDrsOpnDate = CSVUtil.formatDate(upccImSerPubBldCapDrsOpnDate);
    }

    public String getUpccImSerPubBldCapDrsOpnNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccImSerPubBldCapDrsOpnNotes);
    }

    public void setUpccImSerPubBldCapDrsOpnNotes(String upccImSerPubBldCapDrsOpnNotes) {
        this.upccImSerPubBldCapDrsOpnNotes = upccImSerPubBldCapDrsOpnNotes;
    }

    public String getUpccPlSerPlnOprBudSubUndRevDate() {
        return upccPlSerPlnOprBudSubUndRevDate;
    }

    public void setUpccPlSerPlnOprBudSubUndRevDate(String upccPlSerPlnOprBudSubUndRevDate) {
        this.upccPlSerPlnOprBudSubUndRevDate = CSVUtil.formatDate(upccPlSerPlnOprBudSubUndRevDate);
    }

    public String getUpccPlSerPlnOprBudSubUndRevNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccPlSerPlnOprBudSubUndRevNotes);
    }

    public void setUpccPlSerPlnOprBudSubUndRevNotes(String upccPlSerPlnOprBudSubUndRevNotes) {
        this.upccPlSerPlnOprBudSubUndRevNotes = upccPlSerPlnOprBudSubUndRevNotes;
    }

    public String getChcPlProEdrDate() {
        return chcPlProEdrDate;
    }

    public void setChcPlProEdrDate(String chcPlProEdrDate) {
        this.chcPlProEdrDate = CSVUtil.formatDate(chcPlProEdrDate);
    }

    public String getChcPlProSubDate() {
        return chcPlProSubDate;
    }

    public void setChcPlProSubDate(String chcPlProSubDate) {
        this.chcPlProSubDate = CSVUtil.formatDate(chcPlProSubDate);
    }

    public String getChcPlProEdrNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcPlProEdrNotes);
    }

    public void setChcPlProEdrNotes(String chcPlProEdrNotes) {
        this.chcPlProEdrNotes = chcPlProEdrNotes;
    }

    public String getChcPlProSubNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcPlProSubNotes);
    }

    public void setChcPlProSubNotes(String chcPlProSubNotes) {
        this.chcPlProSubNotes = chcPlProSubNotes;
    }

    public String getChcImStbFulOprDate() {
        return chcImStbFulOprDate;
    }

    public void setChcImStbFulOprDate(String chcImStbFulOprDate) {
        this.chcImStbFulOprDate = CSVUtil.formatDate(chcImStbFulOprDate);
    }

    public String getChcInConSumSubDate() {
        return chcInConSumSubDate;
    }

    public void setChcInConSumSubDate(String chcInConSumSubDate) {
        this.chcInConSumSubDate = CSVUtil.formatDate(chcInConSumSubDate);
    }

    public String getChcImStbFulOprNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcImStbFulOprNotes);
    }

    public void setChcImStbFulOprNotes(String chcImStbFulOprNotes) {
        this.chcImStbFulOprNotes = chcImStbFulOprNotes;
    }

    public String getChcInConSumSubNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcInConSumSubNotes);
    }

    public void setChcInConSumSubNotes(String chcInConSumSubNotes) {
        this.chcInConSumSubNotes = chcInConSumSubNotes;
    }

    public String getChcImplementationType() {
        return chcImplementationType;
    }

    public void setChcImplementationType(String chcImplementationType) {
        this.chcImplementationType = chcImplementationType;
    }

    public String getChcInConSumAccCfmDate() {
        return chcInConSumAccCfmDate;
    }

    public void setChcInConSumAccCfmDate(String chcInConSumAccCfmDate) {
        this.chcInConSumAccCfmDate = CSVUtil.formatDate(chcInConSumAccCfmDate);
    }

    public String getChcPlFunPkgAppIssDate() {
        return chcPlFunPkgAppIssDate;
    }

    public void setChcPlFunPkgAppIssDate(String chcPlFunPkgAppIssDate) {
        this.chcPlFunPkgAppIssDate = CSVUtil.formatDate(chcPlFunPkgAppIssDate);
    }

    public String getChcPlFunPkgAppPenDate() {
        return chcPlFunPkgAppPenDate;
    }

    public void setChcPlFunPkgAppPenDate(String chcPlFunPkgAppPenDate) {
        this.chcPlFunPkgAppPenDate = CSVUtil.formatDate(chcPlFunPkgAppPenDate);
    }

    public String getChcInConSumAccCfmNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcInConSumAccCfmNotes);
    }

    public void setChcInConSumAccCfmNotes(String chcInConSumAccCfmNotes) {
        this.chcInConSumAccCfmNotes = chcInConSumAccCfmNotes;
    }

    public String getChcPlFunPkgAppIssNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcPlFunPkgAppIssNotes);
    }

    public void setChcPlFunPkgAppIssNotes(String chcPlFunPkgAppIssNotes) {
        this.chcPlFunPkgAppIssNotes = chcPlFunPkgAppIssNotes;
    }

    public String getChcPlFunPkgAppPenNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcPlFunPkgAppPenNotes);
    }

    public void setChcPlFunPkgAppPenNotes(String chcPlFunPkgAppPenNotes) {
        this.chcPlFunPkgAppPenNotes = chcPlFunPkgAppPenNotes;
    }

    public String getChcImEstFndAppNotOpnDate() {
        return chcImEstFndAppNotOpnDate;
    }

    public void setChcImEstFndAppNotOpnDate(String chcImEstFndAppNotOpnDate) {
        this.chcImEstFndAppNotOpnDate = CSVUtil.formatDate(chcImEstFndAppNotOpnDate);
    }

    public String getChcImEstFndAppNotOpnNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcImEstFndAppNotOpnNotes);
    }

    public void setChcImEstFndAppNotOpnNotes(String chcImEstFndAppNotOpnNotes) {
        this.chcImEstFndAppNotOpnNotes = chcImEstFndAppNotOpnNotes;
    }

    public String getChcImSerPubBldCapDrsOpnDate() {
        return chcImSerPubBldCapDrsOpnDate;
    }

    public void setChcImSerPubBldCapDrsOpnDate(String chcImSerPubBldCapDrsOpnDate) {
        this.chcImSerPubBldCapDrsOpnDate = CSVUtil.formatDate(chcImSerPubBldCapDrsOpnDate);
    }

    public String getChcImSerPubBldCapDrsOpnNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(chcImSerPubBldCapDrsOpnNotes);
    }

    public void setChcImSerPubBldCapDrsOpnNotes(String chcImSerPubBldCapDrsOpnNotes) {
        this.chcImSerPubBldCapDrsOpnNotes = chcImSerPubBldCapDrsOpnNotes;
    }

    public String getFnpccInPreAnlRepCfmDate() {
        return fnpccInPreAnlRepCfmDate;
    }

    public void setFnpccInPreAnlRepCfmDate(String fnpccInPreAnlRepCfmDate) {
        this.fnpccInPreAnlRepCfmDate = CSVUtil.formatDate(fnpccInPreAnlRepCfmDate);
    }

    public String getFnpccInPreAnlRepSubDate() {
        return fnpccInPreAnlRepSubDate;
    }

    public void setFnpccInPreAnlRepSubDate(String fnpccInPreAnlRepSubDate) {
        this.fnpccInPreAnlRepSubDate = CSVUtil.formatDate(fnpccInPreAnlRepSubDate);
    }

    public String getFnpccPlFunPkgAppIssDate() {
        return fnpccPlFunPkgAppIssDate;
    }

    public void setFnpccPlFunPkgAppIssDate(String fnpccPlFunPkgAppIssDate) {
        this.fnpccPlFunPkgAppIssDate = CSVUtil.formatDate(fnpccPlFunPkgAppIssDate);
    }

    public String getFnpccPlFunPkgAppPenDate() {
        return fnpccPlFunPkgAppPenDate;
    }

    public void setFnpccPlFunPkgAppPenDate(String fnpccPlFunPkgAppPenDate) {
        this.fnpccPlFunPkgAppPenDate = CSVUtil.formatDate(fnpccPlFunPkgAppPenDate);
    }

    public String getFnpccPlTrgSerPlnRevDate() {
        return fnpccPlTrgSerPlnRevDate;
    }

    public void setFnpccPlTrgSerPlnRevDate(String fnpccPlTrgSerPlnRevDate) {
        this.fnpccPlTrgSerPlnRevDate = CSVUtil.formatDate(fnpccPlTrgSerPlnRevDate);
    }

    public String getFnpccInPreAnlRepCfmNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccInPreAnlRepCfmNotes);
    }

    public void setFnpccInPreAnlRepCfmNotes(String fnpccInPreAnlRepCfmNotes) {
        this.fnpccInPreAnlRepCfmNotes = fnpccInPreAnlRepCfmNotes;
    }

    public String getFnpccInPreAnlRepSubNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccInPreAnlRepSubNotes);
    }

    public void setFnpccInPreAnlRepSubNotes(String fnpccInPreAnlRepSubNotes) {
        this.fnpccInPreAnlRepSubNotes = fnpccInPreAnlRepSubNotes;
    }

    public String getFnpccPlFunPkgAppIssNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccPlFunPkgAppIssNotes);
    }

    public void setFnpccPlFunPkgAppIssNotes(String fnpccPlFunPkgAppIssNotes) {
        this.fnpccPlFunPkgAppIssNotes = fnpccPlFunPkgAppIssNotes;
    }

    public String getFnpccPlFunPkgAppPenNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccPlFunPkgAppPenNotes);
    }

    public void setFnpccPlFunPkgAppPenNotes(String fnpccPlFunPkgAppPenNotes) {
        this.fnpccPlFunPkgAppPenNotes = fnpccPlFunPkgAppPenNotes;
    }

    public String getFnpccPlTrgSerPlnRevNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccPlTrgSerPlnRevNotes);
    }

    public void setFnpccPlTrgSerPlnRevNotes(String fnpccPlTrgSerPlnRevNotes) {
        this.fnpccPlTrgSerPlnRevNotes = fnpccPlTrgSerPlnRevNotes;
    }

    public String getFnpccImEstFndAppNotOpnDate() {
        return fnpccImEstFndAppNotOpnDate;
    }

    public void setFnpccImEstFndAppNotOpnDate(String fnpccImEstFndAppNotOpnDate) {
        this.fnpccImEstFndAppNotOpnDate = CSVUtil.formatDate(fnpccImEstFndAppNotOpnDate);
    }

    public String getFnpccPlMinFnhSerPlnRevDate() {
        return fnpccPlMinFnhSerPlnRevDate;
    }

    public void setFnpccPlMinFnhSerPlnRevDate(String fnpccPlMinFnhSerPlnRevDate) {
        this.fnpccPlMinFnhSerPlnRevDate = CSVUtil.formatDate(fnpccPlMinFnhSerPlnRevDate);
    }

    public String getFnpccPlSerPlnAwtFnhEndDate() {
        return fnpccPlSerPlnAwtFnhEndDate;
    }

    public void setFnpccPlSerPlnAwtFnhEndDate(String fnpccPlSerPlnAwtFnhEndDate) {
        this.fnpccPlSerPlnAwtFnhEndDate = CSVUtil.formatDate(fnpccPlSerPlnAwtFnhEndDate);
    }

    public String getFnpccPlSerPlnAwtMinEndDate() {
        return fnpccPlSerPlnAwtMinEndDate;
    }

    public void setFnpccPlSerPlnAwtMinEndDate(String fnpccPlSerPlnAwtMinEndDate) {
        this.fnpccPlSerPlnAwtMinEndDate = CSVUtil.formatDate(fnpccPlSerPlnAwtMinEndDate);
    }

    public String getFnpccPlSerPlnOprBudEdrDate() {
        return fnpccPlSerPlnOprBudEdrDate;
    }

    public void setFnpccPlSerPlnOprBudEdrDate(String fnpccPlSerPlnOprBudEdrDate) {
        this.fnpccPlSerPlnOprBudEdrDate = CSVUtil.formatDate(fnpccPlSerPlnOprBudEdrDate);
    }

    public String getFnpccImEstFndAppNotOpnNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccImEstFndAppNotOpnNotes);
    }

    public void setFnpccImEstFndAppNotOpnNotes(String fnpccImEstFndAppNotOpnNotes) {
        this.fnpccImEstFndAppNotOpnNotes = fnpccImEstFndAppNotOpnNotes;
    }

    public String getFnpccPlMinFnhSerPlnRevNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccPlMinFnhSerPlnRevNotes);
    }

    public void setFnpccPlMinFnhSerPlnRevNotes(String fnpccPlMinFnhSerPlnRevNotes) {
        this.fnpccPlMinFnhSerPlnRevNotes = fnpccPlMinFnhSerPlnRevNotes;
    }

    public String getFnpccPlSerPlnAwtFnhEndNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccPlSerPlnAwtFnhEndNotes);
    }

    public void setFnpccPlSerPlnAwtFnhEndNotes(String fnpccPlSerPlnAwtFnhEndNotes) {
        this.fnpccPlSerPlnAwtFnhEndNotes = fnpccPlSerPlnAwtFnhEndNotes;
    }

    public String getFnpccPlSerPlnAwtMinEndNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccPlSerPlnAwtMinEndNotes);
    }

    public void setFnpccPlSerPlnAwtMinEndNotes(String fnpccPlSerPlnAwtMinEndNotes) {
        this.fnpccPlSerPlnAwtMinEndNotes = fnpccPlSerPlnAwtMinEndNotes;
    }

    public String getFnpccPlSerPlnOprBudEdrNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccPlSerPlnOprBudEdrNotes);
    }

    public void setFnpccPlSerPlnOprBudEdrNotes(String fnpccPlSerPlnOprBudEdrNotes) {
        this.fnpccPlSerPlnOprBudEdrNotes = fnpccPlSerPlnOprBudEdrNotes;
    }

    public String getFnpccImSerPubBldCapDrsOpnDate() {
        return fnpccImSerPubBldCapDrsOpnDate;
    }

    public void setFnpccImSerPubBldCapDrsOpnDate(String fnpccImSerPubBldCapDrsOpnDate) {
        this.fnpccImSerPubBldCapDrsOpnDate = CSVUtil.formatDate(fnpccImSerPubBldCapDrsOpnDate);
    }

    public String getFnpccImSerPubBldCapDrsOpnNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccImSerPubBldCapDrsOpnNotes);
    }

    public void setFnpccImSerPubBldCapDrsOpnNotes(String fnpccImSerPubBldCapDrsOpnNotes) {
        this.fnpccImSerPubBldCapDrsOpnNotes = fnpccImSerPubBldCapDrsOpnNotes;
    }

    public String getFnpccPlSerPlnOprBudSubUndRevDate() {
        return fnpccPlSerPlnOprBudSubUndRevDate;
    }

    public void setFnpccPlSerPlnOprBudSubUndRevDate(String fnpccPlSerPlnOprBudSubUndRevDate) {
        this.fnpccPlSerPlnOprBudSubUndRevDate =
                CSVUtil.formatDate(fnpccPlSerPlnOprBudSubUndRevDate);
    }

    public String getFnpccPlSerPlnOprBudSubUndRevNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccPlSerPlnOprBudSubUndRevNotes);
    }

    public void setFnpccPlSerPlnOprBudSubUndRevNotes(String fnpccPlSerPlnOprBudSubUndRevNotes) {
        this.fnpccPlSerPlnOprBudSubUndRevNotes = fnpccPlSerPlnOprBudSubUndRevNotes;
    }

    public String getFnpccfundingSourcesAndPartnershipStructure() {
        return fnpccfundingSourcesAndPartnershipStructure;
    }

    public void setFnpccfundingSourcesAndPartnershipStructure(
            String fnpccfundingSourcesAndPartnershipStructure) {
        this.fnpccfundingSourcesAndPartnershipStructure =
                fnpccfundingSourcesAndPartnershipStructure;
    }

    public String getNppccPlProEdrDate() {
        return nppccPlProEdrDate;
    }

    public void setNppccPlProEdrDate(String nppccPlProEdrDate) {
        this.nppccPlProEdrDate = CSVUtil.formatDate(nppccPlProEdrDate);
    }

    public String getNppccPlProSubDate() {
        return nppccPlProSubDate;
    }

    public void setNppccPlProSubDate(String nppccPlProSubDate) {
        this.nppccPlProSubDate = CSVUtil.formatDate(nppccPlProSubDate);
    }

    public String getNppccPlProEdrNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(nppccPlProEdrNotes);
    }

    public void setNppccPlProEdrNotes(String nppccPlProEdrNotes) {
        this.nppccPlProEdrNotes = nppccPlProEdrNotes;
    }

    public String getNppccPlProSubNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(nppccPlProSubNotes);
    }

    public void setNppccPlProSubNotes(String nppccPlProSubNotes) {
        this.nppccPlProSubNotes = nppccPlProSubNotes;
    }

    public String getNppccImStbFulOprDate() {
        return nppccImStbFulOprDate;
    }

    public void setNppccImStbFulOprDate(String nppccImStbFulOprDate) {
        this.nppccImStbFulOprDate = CSVUtil.formatDate(nppccImStbFulOprDate);
    }

    public String getNppccImStbFulOprNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(nppccImStbFulOprNotes);
    }

    public void setNppccImStbFulOprNotes(String nppccImStbFulOprNotes) {
        this.nppccImStbFulOprNotes = nppccImStbFulOprNotes;
    }

    public String getNppccImplementationType() {
        return nppccImplementationType;
    }

    public void setNppccImplementationType(String nppccImplementationType) {
        this.nppccImplementationType = nppccImplementationType;
    }

    public String getNppccPlFunPkgAppIssDate() {
        return nppccPlFunPkgAppIssDate;
    }

    public void setNppccPlFunPkgAppIssDate(String nppccPlFunPkgAppIssDate) {
        this.nppccPlFunPkgAppIssDate = CSVUtil.formatDate(nppccPlFunPkgAppIssDate);
    }

    public String getNppccPlFunPkgAppPenDate() {
        return nppccPlFunPkgAppPenDate;
    }

    public void setNppccPlFunPkgAppPenDate(String nppccPlFunPkgAppPenDate) {
        this.nppccPlFunPkgAppPenDate = CSVUtil.formatDate(nppccPlFunPkgAppPenDate);
    }

    public String getNppccPlFunPkgAppIssNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(nppccPlFunPkgAppIssNotes);
    }

    public void setNppccPlFunPkgAppIssNotes(String nppccPlFunPkgAppIssNotes) {
        this.nppccPlFunPkgAppIssNotes = nppccPlFunPkgAppIssNotes;
    }

    public String getNppccPlFunPkgAppPenNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(nppccPlFunPkgAppPenNotes);
    }

    public void setNppccPlFunPkgAppPenNotes(String nppccPlFunPkgAppPenNotes) {
        this.nppccPlFunPkgAppPenNotes = nppccPlFunPkgAppPenNotes;
    }

    public String getNppccImEstFndAppNotOpnDate() {
        return nppccImEstFndAppNotOpnDate;
    }

    public void setNppccImEstFndAppNotOpnDate(String nppccImEstFndAppNotOpnDate) {
        this.nppccImEstFndAppNotOpnDate = CSVUtil.formatDate(nppccImEstFndAppNotOpnDate);
    }

    public String getNppccImSerPubBldCapDrsOpnDate() {
        return nppccImSerPubBldCapDrsOpnDate;
    }

    public void setNppccImSerPubBldCapDrsOpnDate(String nppccImSerPubBldCapDrsOpnDate) {
        this.nppccImSerPubBldCapDrsOpnDate = CSVUtil.formatDate(nppccImSerPubBldCapDrsOpnDate);
    }

    public String getNppccImSerPubBldCapDrsOpnNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(nppccImSerPubBldCapDrsOpnNotes);
    }

    public void setNppccImSerPubBldCapDrsOpnNotes(String nppccImSerPubBldCapDrsOpnNotes) {
        this.nppccImSerPubBldCapDrsOpnNotes = nppccImSerPubBldCapDrsOpnNotes;
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

    public String getImplementationYear() {
        return implementationYear;
    }

    public void setImplementationYear(String implementationYear) {
        this.implementationYear = implementationYear;
    }

    public String getActualAnnouncementDate() {
        return actualAnnouncementDate;
    }

    public void setActualAnnouncementDate(String actualAnnouncementDate) {
        this.actualAnnouncementDate = CSVUtil.formatDate(actualAnnouncementDate);
    }

    public String getProposedAnnouncementDate() {
        return proposedAnnouncementDate;
    }

    public void setProposedAnnouncementDate(String proposedAnnouncementDate) {
        this.proposedAnnouncementDate = CSVUtil.formatDate(proposedAnnouncementDate);
    }

    public String getProposedImplementationDate() {
        return proposedImplementationDate;
    }

    public void setProposedImplementationDate(String proposedImplementationDate) {
        this.proposedImplementationDate = CSVUtil.formatDate(proposedImplementationDate);
    }

    public String getActualLaunchOpenDate() {
        return actualLaunchOpenDate;
    }

    public void setActualLaunchOpenDate(String actualLaunchOpenDate) {
        this.actualLaunchOpenDate = CSVUtil.formatDate(actualLaunchOpenDate);
    }

    public String getTargetLaunchOpenDate() {
        return targetLaunchOpenDate;
    }

    public void setTargetLaunchOpenDate(String targetLaunchOpenDate) {
        this.targetLaunchOpenDate = CSVUtil.formatDate(targetLaunchOpenDate);
    }

    public String getDateComments() {
        return CSVUtil.replaceCarriageReturnLineFeed(dateComments);
    }

    public void setDateComments(String dateComments) {
        this.dateComments = dateComments;
    }

    public String getCurrentApprovedFtEs() {
        return currentApprovedFtEs;
    }

    public void setCurrentApprovedFtEs(String currentApprovedFtEs) {
        this.currentApprovedFtEs = currentApprovedFtEs;
    }

    public String getCurrentApprovedBudget() {
        return currentApprovedBudget;
    }

    public void setCurrentApprovedBudget(String currentApprovedBudget) {
        this.currentApprovedBudget = currentApprovedBudget;
    }

    public String getCurrentApprovedAttachmentTarget() {
        return currentApprovedAttachmentTarget;
    }

    public void setCurrentApprovedAttachmentTarget(String currentApprovedAttachmentTarget) {
        this.currentApprovedAttachmentTarget = currentApprovedAttachmentTarget;
    }

    public String getPcnPlSerPlnOprBudSubUndRevDate() {
        return pcnPlSerPlnOprBudSubUndRevDate;
    }

    public void setPcnPlSerPlnOprBudSubUndRevDate(String pcnPlSerPlnOprBudSubUndRevDate) {
        this.pcnPlSerPlnOprBudSubUndRevDate = CSVUtil.formatDate(pcnPlSerPlnOprBudSubUndRevDate);
    }

    public String getNppccImEstFndAppNotOpnNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(nppccImEstFndAppNotOpnNotes);
    }

    public void setNppccImEstFndAppNotOpnNotes(String nppccImEstFndAppNotOpnNotes) {
        this.nppccImEstFndAppNotOpnNotes = nppccImEstFndAppNotOpnNotes;
    }

    public String getFnpccImStbFulOprDate() {
        return fnpccImStbFulOprDate;
    }

    public void setFnpccImStbFulOprDate(String fnpccImStbFulOprDate) {
        this.fnpccImStbFulOprDate = CSVUtil.formatDate(fnpccImStbFulOprDate);
    }

    public String getFnpccImStbFulOprNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(fnpccImStbFulOprNotes);
    }

    public void setFnpccImStbFulOprNotes(String fnpccImStbFulOprNotes) {
        this.fnpccImStbFulOprNotes = fnpccImStbFulOprNotes;
    }

    public String getFnpccPlSerPlnAwtFnhAppDate() {
        return fnpccPlSerPlnAwtFnhAppDate;
    }

    public void setFnpccPlSerPlnAwtFnhAppDate(String fnpccPlSerPlnAwtFnhAppDate) {
        this.fnpccPlSerPlnAwtFnhAppDate = CSVUtil.formatDate(fnpccPlSerPlnAwtFnhAppDate);
    }

    public String getFnpccPlSerPlnAwtMinAppDate() {
        return fnpccPlSerPlnAwtMinAppDate;
    }

    public void setFnpccPlSerPlnAwtMinAppDate(String fnpccPlSerPlnAwtMinAppDate) {
        this.fnpccPlSerPlnAwtMinAppDate = CSVUtil.formatDate(fnpccPlSerPlnAwtMinAppDate);
    }

    public String getHsiarServicePlanGapAnalysisDate() {
        return hsiarServicePlanGapAnalysisDate;
    }

    public void setHsiarServicePlanGapAnalysisDate(String hsiarServicePlanGapAnalysisDate) {
        this.hsiarServicePlanGapAnalysisDate = CSVUtil.formatDate(hsiarServicePlanGapAnalysisDate);
    }

}
