package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import java.util.ArrayList;
import java.util.List;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class CHCStatusTrackerItem implements IModel {
    private String submissionId;
    private String chcId;
    private String chcName;
    private String chcAddress;
    private String chcKeyAttributes;
    private String chcFundingSources;
    private String chcImplementationType;
    private String chcImFndNotOpnDate;
    private String chcImFndNotOpnNotes;
    private String chcImSerPubOpnDate;
    private String chcImSerPubOpnNotes;
    private String chcImStbFullOprDate;
    private String chcImStbFullOprNotes;
    private String chcInConSumAccDate;
    private String chcInConSumAccNotes;
    private String chcInConSumSubDate;
    private String chcInConSumSubNotes;
    private String chcPlFunPkgAppDate;
    private String chcPlFunPkgAppNotes;
    private String chcPlFunPkgPenDate;
    private String chcPlFunPkgPenNotes;
    private String chcPlProEdrDate;
    private String chcPlProEdrNotes;
    private String chcPlProSubDate;
    private String chcPlProSubNotes;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getChcId() {
        return chcId;
    }

    public void setChcId(String chcId) {
        this.chcId = chcId;
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

    public String getChcImplementationType() {
        return chcImplementationType;
    }

    public void setChcImplementationType(String chcImplementationType) {
        this.chcImplementationType = chcImplementationType;
    }

    public String getChcImFndNotOpnDate() {
        return chcImFndNotOpnDate;
    }

    public void setChcImFndNotOpnDate(String chcImFndNotOpnDate) {
        this.chcImFndNotOpnDate = chcImFndNotOpnDate;
    }

    public String getChcImFndNotOpnNotes() {
        return chcImFndNotOpnNotes;
    }

    public void setChcImFndNotOpnNotes(String chcImFndNotOpnNotes) {
        this.chcImFndNotOpnNotes = chcImFndNotOpnNotes;
    }

    public String getChcImSerPubOpnDate() {
        return chcImSerPubOpnDate;
    }

    public void setChcImSerPubOpnDate(String chcImSerPubOpnDate) {
        this.chcImSerPubOpnDate = chcImSerPubOpnDate;
    }

    public String getChcImSerPubOpnNotes() {
        return chcImSerPubOpnNotes;
    }

    public void setChcImSerPubOpnNotes(String chcImSerPubOpnNotes) {
        this.chcImSerPubOpnNotes = chcImSerPubOpnNotes;
    }

    public String getChcImStbFullOprDate() {
        return chcImStbFullOprDate;
    }

    public void setChcImStbFullOprDate(String chcImStbFullOprDate) {
        this.chcImStbFullOprDate = chcImStbFullOprDate;
    }

    public String getChcImStbFullOprNotes() {
        return chcImStbFullOprNotes;
    }

    public void setChcImStbFullOprNotes(String chcImStbFullOprNotes) {
        this.chcImStbFullOprNotes = chcImStbFullOprNotes;
    }

    public String getChcInConSumAccDate() {
        return chcInConSumAccDate;
    }

    public void setChcInConSumAccDate(String chcInConSumAccDate) {
        this.chcInConSumAccDate = chcInConSumAccDate;
    }

    public String getChcInConSumAccNotes() {
        return chcInConSumAccNotes;
    }

    public void setChcInConSumAccNotes(String chcInConSumAccNotes) {
        this.chcInConSumAccNotes = chcInConSumAccNotes;
    }

    public String getChcInConSumSubDate() {
        return chcInConSumSubDate;
    }

    public void setChcInConSumSubDate(String chcInConSumSubDate) {
        this.chcInConSumSubDate = chcInConSumSubDate;
    }

    public String getChcInConSumSubNotes() {
        return chcInConSumSubNotes;
    }

    public void setChcInConSumSubNotes(String chcInConSumSubNotes) {
        this.chcInConSumSubNotes = chcInConSumSubNotes;
    }

    public String getChcPlFunPkgAppDate() {
        return chcPlFunPkgAppDate;
    }

    public void setChcPlFunPkgAppDate(String chcPlFunPkgAppDate) {
        this.chcPlFunPkgAppDate = chcPlFunPkgAppDate;
    }

    public String getChcPlFunPkgAppNotes() {
        return chcPlFunPkgAppNotes;
    }

    public void setChcPlFunPkgAppNotes(String chcPlFunPkgAppNotes) {
        this.chcPlFunPkgAppNotes = chcPlFunPkgAppNotes;
    }

    public String getChcPlFunPkgPenDate() {
        return chcPlFunPkgPenDate;
    }

    public void setChcPlFunPkgPenDate(String chcPlFunPkgPenDate) {
        this.chcPlFunPkgPenDate = chcPlFunPkgPenDate;
    }

    public String getChcPlFunPkgPenNotes() {
        return chcPlFunPkgPenNotes;
    }

    public void setChcPlFunPkgPenNotes(String chcPlFunPkgPenNotes) {
        this.chcPlFunPkgPenNotes = chcPlFunPkgPenNotes;
    }

    public String getChcPlProEdrDate() {
        return chcPlProEdrDate;
    }

    public void setChcPlProEdrDate(String chcPlProEdrDate) {
        this.chcPlProEdrDate = chcPlProEdrDate;
    }

    public String getChcPlProEdrNotes() {
        return chcPlProEdrNotes;
    }

    public void setChcPlProEdrNotes(String chcPlProEdrNotes) {
        this.chcPlProEdrNotes = chcPlProEdrNotes;
    }

    public String getChcPlProSubDate() {
        return chcPlProSubDate;
    }

    public void setChcPlProSubDate(String chcPlProSubDate) {
        this.chcPlProSubDate = chcPlProSubDate;
    }

    public String getChcPlProSubNotes() {
        return chcPlProSubNotes;
    }

    public void setChcPlProSubNotes(String chcPlProSubNotes) {
        this.chcPlProSubNotes = chcPlProSubNotes;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.PCD_STATUS_TRACKER_CHC;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(submissionId);
        elements.add(chcId);
        elements.add(chcName);
        elements.add(chcAddress);
        elements.add(chcKeyAttributes);
        elements.add(chcFundingSources);
        elements.add(chcImplementationType);
        elements.add(chcImFndNotOpnDate);
        elements.add(chcImFndNotOpnNotes);
        elements.add(chcImSerPubOpnDate);
        elements.add(chcImSerPubOpnNotes);
        elements.add(chcImStbFullOprDate);
        elements.add(chcImStbFullOprNotes);
        elements.add(chcInConSumAccDate);
        elements.add(chcInConSumAccNotes);
        elements.add(chcInConSumSubDate);
        elements.add(chcInConSumSubNotes);
        elements.add(chcPlFunPkgAppDate);
        elements.add(chcPlFunPkgAppNotes);
        elements.add(chcPlFunPkgPenDate);
        elements.add(chcPlFunPkgPenNotes);
        elements.add(chcPlProEdrDate);
        elements.add(chcPlProEdrNotes);
        elements.add(chcPlProSubDate);
        elements.add(chcPlProSubNotes);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
}
