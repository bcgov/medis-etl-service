package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class FNPCCStatusTrackerItem implements IModel {
    private String submissionId;
    private String fnpccId;
    private String fnpccName;
    private String fnpccFundingSources;
    private String fnpccImplementationType;
    private String fnpccAddress;
    private String fnpccFirstNationOrgLead;
    private String fnpccAdditionalDetails;
    private String fnpccImFndNotOpnDate;
    private String fnpccImFndNotOpnNotes;
    private String fnpccImSerPubOpnDate;
    private String fnpccImSerPubOpnNotes;
    private String fnpccImStbFullOprDate;
    private String fnpccImStbFullOprNotes;
    private String fnpccInPreAnlCfmDate;
    private String fnpccInPreAnlCfmNotes;
    private String fnpccInPreAnlSubDate;
    private String fnpccInPreAnlSubNotes;
    private String fnpccPlFunPkgAppDate;
    private String fnpccPlFunPkgAppNotes;
    private String fnpccPlFunPkgPenDate;
    private String fnpccPlFunPkgPenNotes;
    private String fnpccPlMinPlnRevDate;
    private String fnpccPlMinPlnRevNotes;
    private String fnpccPlPlnAwtFnhDate;
    private String fnpccPlPlnAwtFnhNotes;
    private String fnpccPlPlnAwtMinDate;
    private String fnpccPlPlnAwtMinNotes;
    private String fnpccPlSerPlnEdrDate;
    private String fnpccPlSerPlnEdrNotes;
    private String fnpccPlSerPlnRevNotes;
    private String fnpccPlSerPlnRevDate;
    private String fnpccPlTrgPlnRevDate;
    private String fnpccPlTrgPlnRevNotes;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getFnpccId() {
        return fnpccId;
    }

    public void setFnpccId(String fnpccId) {
        this.fnpccId = fnpccId;
    }

    public String getFnpccName() {
        return fnpccName;
    }

    public void setFnpccName(String fnpccName) {
        this.fnpccName = fnpccName;
    }

    public String getFnpccFundingSources() {
        return fnpccFundingSources;
    }

    public void setFnpccFundingSources(String fnpccFundingSources) {
        this.fnpccFundingSources = fnpccFundingSources;
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

    public String getFnpccFirstNationOrgLead() {
        return fnpccFirstNationOrgLead;
    }

    public void setFnpccFirstNationOrgLead(String fnpccFirstNationOrgLead) {
        this.fnpccFirstNationOrgLead = fnpccFirstNationOrgLead;
    }

    public String getFnpccAdditionalDetails() {
        return fnpccAdditionalDetails;
    }

    public void setFnpccAdditionalDetails(String fnpccAdditionalDetails) {
        this.fnpccAdditionalDetails = fnpccAdditionalDetails;
    }

    public String getFnpccImFndNotOpnDate() {
        return fnpccImFndNotOpnDate;
    }

    public void setFnpccImFndNotOpnDate(String fnpccImFndNotOpnDate) {
        this.fnpccImFndNotOpnDate = fnpccImFndNotOpnDate;
    }

    public String getFnpccImFndNotOpnNotes() {
        return fnpccImFndNotOpnNotes;
    }

    public void setFnpccImFndNotOpnNotes(String fnpccImFndNotOpnNotes) {
        this.fnpccImFndNotOpnNotes = fnpccImFndNotOpnNotes;
    }

    public String getFnpccImSerPubOpnDate() {
        return fnpccImSerPubOpnDate;
    }

    public void setFnpccImSerPubOpnDate(String fnpccImSerPubOpnDate) {
        this.fnpccImSerPubOpnDate = fnpccImSerPubOpnDate;
    }

    public String getFnpccImSerPubOpnNotes() {
        return fnpccImSerPubOpnNotes;
    }

    public void setFnpccImSerPubOpnNotes(String fnpccImSerPubOpnNotes) {
        this.fnpccImSerPubOpnNotes = fnpccImSerPubOpnNotes;
    }

    public String getFnpccImStbFullOprDate() {
        return fnpccImStbFullOprDate;
    }

    public void setFnpccImStbFullOprDate(String fnpccImStbFullOprDate) {
        this.fnpccImStbFullOprDate = fnpccImStbFullOprDate;
    }

    public String getFnpccImStbFullOprNotes() {
        return fnpccImStbFullOprNotes;
    }

    public void setFnpccImStbFullOprNotes(String fnpccImStbFullOprNotes) {
        this.fnpccImStbFullOprNotes = fnpccImStbFullOprNotes;
    }

    public String getFnpccInPreAnlCfmDate() {
        return fnpccInPreAnlCfmDate;
    }

    public void setFnpccInPreAnlCfmDate(String fnpccInPreAnlCfmDate) {
        this.fnpccInPreAnlCfmDate = fnpccInPreAnlCfmDate;
    }

    public String getFnpccInPreAnlCfmNotes() {
        return fnpccInPreAnlCfmNotes;
    }

    public void setFnpccInPreAnlCfmNotes(String fnpccInPreAnlCfmNotes) {
        this.fnpccInPreAnlCfmNotes = fnpccInPreAnlCfmNotes;
    }

    public String getFnpccInPreAnlSubDate() {
        return fnpccInPreAnlSubDate;
    }

    public void setFnpccInPreAnlSubDate(String fnpccInPreAnlSubDate) {
        this.fnpccInPreAnlSubDate = fnpccInPreAnlSubDate;
    }

    public String getFnpccInPreAnlSubNotes() {
        return fnpccInPreAnlSubNotes;
    }

    public void setFnpccInPreAnlSubNotes(String fnpccInPreAnlSubNotes) {
        this.fnpccInPreAnlSubNotes = fnpccInPreAnlSubNotes;
    }

    public String getFnpccPlFunPkgAppDate() {
        return fnpccPlFunPkgAppDate;
    }

    public void setFnpccPlFunPkgAppDate(String fnpccPlFunPkgAppDate) {
        this.fnpccPlFunPkgAppDate = fnpccPlFunPkgAppDate;
    }

    public String getFnpccPlFunPkgAppNotes() {
        return fnpccPlFunPkgAppNotes;
    }

    public void setFnpccPlFunPkgAppNotes(String fnpccPlFunPkgAppNotes) {
        this.fnpccPlFunPkgAppNotes = fnpccPlFunPkgAppNotes;
    }

    public String getFnpccPlFunPkgPenDate() {
        return fnpccPlFunPkgPenDate;
    }

    public void setFnpccPlFunPkgPenDate(String fnpccPlFunPkgPenDate) {
        this.fnpccPlFunPkgPenDate = fnpccPlFunPkgPenDate;
    }

    public String getFnpccPlFunPkgPenNotes() {
        return fnpccPlFunPkgPenNotes;
    }

    public void setFnpccPlFunPkgPenNotes(String fnpccPlFunPkgPenNotes) {
        this.fnpccPlFunPkgPenNotes = fnpccPlFunPkgPenNotes;
    }

    public String getFnpccPlMinPlnRevDate() {
        return fnpccPlMinPlnRevDate;
    }

    public void setFnpccPlMinPlnRevDate(String fnpccPlMinPlnRevDate) {
        this.fnpccPlMinPlnRevDate = fnpccPlMinPlnRevDate;
    }

    public String getFnpccPlMinPlnRevNotes() {
        return fnpccPlMinPlnRevNotes;
    }

    public void setFnpccPlMinPlnRevNotes(String fnpccPlMinPlnRevNotes) {
        this.fnpccPlMinPlnRevNotes = fnpccPlMinPlnRevNotes;
    }

    public String getFnpccPlPlnAwtFnhDate() {
        return fnpccPlPlnAwtFnhDate;
    }

    public void setFnpccPlPlnAwtFnhDate(String fnpccPlPlnAwtFnhDate) {
        this.fnpccPlPlnAwtFnhDate = fnpccPlPlnAwtFnhDate;
    }

    public String getFnpccPlPlnAwtFnhNotes() {
        return fnpccPlPlnAwtFnhNotes;
    }

    public void setFnpccPlPlnAwtFnhNotes(String fnpccPlPlnAwtFnhNotes) {
        this.fnpccPlPlnAwtFnhNotes = fnpccPlPlnAwtFnhNotes;
    }

    public String getFnpccPlPlnAwtMinDate() {
        return fnpccPlPlnAwtMinDate;
    }

    public void setFnpccPlPlnAwtMinDate(String fnpccPlPlnAwtMinDate) {
        this.fnpccPlPlnAwtMinDate = fnpccPlPlnAwtMinDate;
    }

    public String getFnpccPlPlnAwtMinNotes() {
        return fnpccPlPlnAwtMinNotes;
    }

    public void setFnpccPlPlnAwtMinNotes(String fnpccPlPlnAwtMinNotes) {
        this.fnpccPlPlnAwtMinNotes = fnpccPlPlnAwtMinNotes;
    }

    public String getFnpccPlSerPlnEdrDate() {
        return fnpccPlSerPlnEdrDate;
    }

    public void setFnpccPlSerPlnEdrDate(String fnpccPlSerPlnEdrDate) {
        this.fnpccPlSerPlnEdrDate = fnpccPlSerPlnEdrDate;
    }

    public String getFnpccPlSerPlnEdrNotes() {
        return fnpccPlSerPlnEdrNotes;
    }

    public void setFnpccPlSerPlnEdrNotes(String fnpccPlSerPlnEdrNotes) {
        this.fnpccPlSerPlnEdrNotes = fnpccPlSerPlnEdrNotes;
    }

    public String getFnpccPlSerPlnRevNotes() {
        return fnpccPlSerPlnRevNotes;
    }

    public void setFnpccPlSerPlnRevNotes(String fnpccPlSerPlnRevNotes) {
        this.fnpccPlSerPlnRevNotes = fnpccPlSerPlnRevNotes;
    }

    public String getFnpccPlSerPlnRevDate() {
        return fnpccPlSerPlnRevDate;
    }

    public void setFnpccPlSerPlnRevDate(String fnpccPlSerPlnRevDate) {
        this.fnpccPlSerPlnRevDate = fnpccPlSerPlnRevDate;
    }

    public String getFnpccPlTrgPlnRevDate() {
        return fnpccPlTrgPlnRevDate;
    }

    public void setFnpccPlTrgPlnRevDate(String fnpccPlTrgPlnRevDate) {
        this.fnpccPlTrgPlnRevDate = fnpccPlTrgPlnRevDate;
    }

    public String getFnpccPlTrgPlnRevNotes() {
        return fnpccPlTrgPlnRevNotes;
    }

    public void setFnpccPlTrgPlnRevNotes(String fnpccPlTrgPlnRevNotes) {
        this.fnpccPlTrgPlnRevNotes = fnpccPlTrgPlnRevNotes;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.PCD_STATUS_TRACKER_FNPCC;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(submissionId);
        elements.add(fnpccId);
        elements.add(fnpccName);
        elements.add(fnpccFundingSources);
        elements.add(fnpccImplementationType);
        elements.add(getFnpccAdditionalDetails());
        elements.add(fnpccFirstNationOrgLead);
        elements.add(fnpccAdditionalDetails);
        elements.add(fnpccImFndNotOpnDate);
        elements.add(fnpccImFndNotOpnNotes);
        elements.add(fnpccImSerPubOpnDate);
        elements.add(fnpccImSerPubOpnNotes);
        elements.add(fnpccImStbFullOprDate);
        elements.add(fnpccImStbFullOprNotes);
        elements.add(fnpccInPreAnlCfmDate);
        elements.add(fnpccInPreAnlCfmNotes);
        elements.add(fnpccInPreAnlSubDate);
        elements.add(fnpccInPreAnlSubNotes);
        elements.add(fnpccPlFunPkgAppDate);
        elements.add(fnpccPlFunPkgAppNotes);
        elements.add(fnpccPlFunPkgPenDate);
        elements.add(fnpccPlFunPkgPenNotes);
        elements.add(fnpccPlMinPlnRevDate);
        elements.add(fnpccPlMinPlnRevNotes);
        elements.add(fnpccPlPlnAwtFnhDate);
        elements.add(fnpccPlPlnAwtFnhNotes);
        elements.add(fnpccPlPlnAwtMinDate);
        elements.add(fnpccPlPlnAwtMinNotes);
        elements.add(fnpccPlSerPlnEdrDate);
        elements.add(fnpccPlSerPlnEdrNotes);
        elements.add(fnpccPlSerPlnRevNotes);
        elements.add(fnpccPlSerPlnRevDate);
        elements.add(fnpccPlTrgPlnRevDate);
        elements.add(fnpccPlTrgPlnRevNotes);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
}
