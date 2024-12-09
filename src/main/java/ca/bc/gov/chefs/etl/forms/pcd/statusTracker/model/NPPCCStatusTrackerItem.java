package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import java.util.ArrayList;
import java.util.List;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class NPPCCStatusTrackerItem implements IModel {
    private String submissionId;
    private String issueId;
    private String nppccName;
    private String nppccImplementationType;
    private String nppccAddress;
    private String nppccKeyAttributes;
    private String nppccImFndNotOpnDate;
    private String nppccImFndNotOpnNotes;
    private String nppccImSerPubOpnDate;
    private String nppccImSerPubOpnNotes;
    private String nppccImStbFullOprDate;
    private String nppccImStbFullOprNotes;
    private String nppccPlFunPkgAppDate;
    private String nppccPlFunPkgAppNotes;
    private String nppccPlFunPkgPenDate;
    private String nppccPlFunPkgPenNotes;
    private String nppccPlProEdrDate;
    private String nppccPlProEdrNotes;
    private String nppccPlProSubDate;
    private String nppccPlProSubNotes;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getNppccName() {
        return nppccName;
    }

    public void setNppccName(String nppccName) {
        this.nppccName = nppccName;
    }

    public String getNppccImplementationType() {
        return nppccImplementationType;
    }

    public void setNppccImplementationType(String nppccImplementationType) {
        this.nppccImplementationType = nppccImplementationType;
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

    public String getNppccImFndNotOpnDate() {
        return nppccImFndNotOpnDate;
    }

    public void setNppccImFndNotOpnDate(String nppccImFndNotOpnDate) {
        this.nppccImFndNotOpnDate = nppccImFndNotOpnDate;
    }

    public String getNppccImFndNotOpnNotes() {
        return nppccImFndNotOpnNotes;
    }

    public void setNppccImFndNotOpnNotes(String nppccImFndNotOpnNotes) {
        this.nppccImFndNotOpnNotes = nppccImFndNotOpnNotes;
    }

    public String getNppccImSerPubOpnDate() {
        return nppccImSerPubOpnDate;
    }

    public void setNppccImSerPubOpnDate(String nppccImSerPubOpnDate) {
        this.nppccImSerPubOpnDate = nppccImSerPubOpnDate;
    }

    public String getNppccImSerPubOpnNotes() {
        return nppccImSerPubOpnNotes;
    }

    public void setNppccImSerPubOpnNotes(String nppccImSerPubOpnNotes) {
        this.nppccImSerPubOpnNotes = nppccImSerPubOpnNotes;
    }

    public String getNppccImStbFullOprDate() {
        return nppccImStbFullOprDate;
    }

    public void setNppccImStbFullOprDate(String nppccImStbFullOprDate) {
        this.nppccImStbFullOprDate = nppccImStbFullOprDate;
    }

    public String getNppccImStbFullOprNotes() {
        return nppccImStbFullOprNotes;
    }

    public void setNppccImStbFullOprNotes(String nppccImStbFullOprNotes) {
        this.nppccImStbFullOprNotes = nppccImStbFullOprNotes;
    }

    public String getNppccPlFunPkgAppDate() {
        return nppccPlFunPkgAppDate;
    }

    public void setNppccPlFunPkgAppDate(String nppccPlFunPkgAppDate) {
        this.nppccPlFunPkgAppDate = nppccPlFunPkgAppDate;
    }

    public String getNppccPlFunPkgAppNotes() {
        return nppccPlFunPkgAppNotes;
    }

    public void setNppccPlFunPkgAppNotes(String nppccPlFunPkgAppNotes) {
        this.nppccPlFunPkgAppNotes = nppccPlFunPkgAppNotes;
    }

    public String getNppccPlFunPkgPenDate() {
        return nppccPlFunPkgPenDate;
    }

    public void setNppccPlFunPkgPenDate(String nppccPlFunPkgPenDate) {
        this.nppccPlFunPkgPenDate = nppccPlFunPkgPenDate;
    }

    public String getNppccPlFunPkgPenNotes() {
        return nppccPlFunPkgPenNotes;
    }

    public void setNppccPlFunPkgPenNotes(String nppccPlFunPkgPenNotes) {
        this.nppccPlFunPkgPenNotes = nppccPlFunPkgPenNotes;
    }

    public String getNppccPlProEdrDate() {
        return nppccPlProEdrDate;
    }

    public void setNppccPlProEdrDate(String nppccPlProEdrDate) {
        this.nppccPlProEdrDate = nppccPlProEdrDate;
    }

    public String getNppccPlProEdrNotes() {
        return nppccPlProEdrNotes;
    }

    public void setNppccPlProEdrNotes(String nppccPlProEdrNotes) {
        this.nppccPlProEdrNotes = nppccPlProEdrNotes;
    }

    public String getNppccPlProSubDate() {
        return nppccPlProSubDate;
    }

    public void setNppccPlProSubDate(String nppccPlProSubDate) {
        this.nppccPlProSubDate = nppccPlProSubDate;
    }

    public String getNppccPlProSubNotes() {
        return nppccPlProSubNotes;
    }

    public void setNppccPlProSubNotes(String nppccPlProSubNotes) {
        this.nppccPlProSubNotes = nppccPlProSubNotes;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.PCD_STATUS_TRACKER_NPPCC;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(submissionId);
        elements.add(issueId);
        elements.add(nppccName);
        elements.add(nppccImplementationType);
        elements.add(nppccAddress);
        elements.add(nppccKeyAttributes);
        elements.add(nppccImFndNotOpnDate);
        elements.add(nppccImFndNotOpnNotes);
        elements.add(nppccImSerPubOpnDate);
        elements.add(nppccImSerPubOpnNotes);
        elements.add(nppccImStbFullOprDate);
        elements.add(nppccImStbFullOprNotes);
        elements.add(nppccPlFunPkgAppDate);
        elements.add(nppccPlFunPkgAppNotes);
        elements.add(nppccPlFunPkgPenDate);
        elements.add(nppccPlFunPkgPenNotes);
        elements.add(nppccPlProEdrDate);
        elements.add(nppccPlProEdrNotes);
        elements.add(nppccPlProSubDate);
        elements.add(nppccPlProSubNotes);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
}
