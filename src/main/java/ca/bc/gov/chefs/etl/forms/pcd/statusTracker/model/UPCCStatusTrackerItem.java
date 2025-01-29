package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class UPCCStatusTrackerItem implements IModel {
    private String submissionId;
    private String upccId;
    private String upccName;
    private String upccTypeOfCare;
    private String upccAddress;
    private String upccChangesToService;
    private String upccChangesToServiceDate;
    private String upccServiceDeliveryMode;
    private String upccImFndNotOpnDate;
    private String upccImFndNotOpnNotes;
    private String upccImSerPubOpnDate;
    private String upccImSerPubOpnNotes;
    private String upccImStbFullOprDate;
    private String upccImStbFullOprNotes;
    private String upccInComSelDate;
    private String upccInComSelNotes;
    private String upccInConSumAccDate;
    private String upccInConSumAccNotes;
    private String upccInConSumSubDate;
    private String upccInConSumSubNotes;
    private String upccPlFunPkgAppDate;
    private String upccPlFunPkgAppNotes;
    private String upccPlFunPkgPenDate;
    private String upccPlFunPkgPenNotes;
    private String upccPlSerPlnEdrDate;
    private String upccPlSerPlnEdrNotes;
    private String upccPlSerPlnRevDate;
    private String upccPlSerPlnRevNotes;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getUpccId() {
        return upccId;
    }

    public void setUpccId(String upccId) {
        this.upccId = upccId;
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

    public String getUpccAddress() {
        return CSVUtil.replaceCarriageReturnLineFeed(upccAddress);
    }

    public void setUpccAddress(String upccAddress) {
        this.upccAddress = upccAddress;
    }

    public String getUpccChangesToService() {
        return upccChangesToService;
    }

    public void setUpccChangesToService(String upccChangesToService) {
        this.upccChangesToService = upccChangesToService;
    }

    public String getUpccChangesToServiceDate() {
        return upccChangesToServiceDate;
    }

    public void setUpccChangesToServiceDate(String upccChangesToServiceDate) {
        this.upccChangesToServiceDate = upccChangesToServiceDate;
    }

    public String getUpccServiceDeliveryMode() {
        return upccServiceDeliveryMode;
    }

    public void setUpccServiceDeliveryMode(String upccServiceDeliveryMode) {
        this.upccServiceDeliveryMode = upccServiceDeliveryMode;
    }

    public String getUpccImFndNotOpnDate() {
        return upccImFndNotOpnDate;
    }

    public void setUpccImFndNotOpnDate(String upccImFndNotOpnDate) {
        this.upccImFndNotOpnDate = upccImFndNotOpnDate;
    }

    public String getUpccImFndNotOpnNotes() {
        return upccImFndNotOpnNotes;
    }

    public void setUpccImFndNotOpnNotes(String upccImFndNotOpnNotes) {
        this.upccImFndNotOpnNotes = upccImFndNotOpnNotes;
    }

    public String getUpccImSerPubOpnDate() {
        return upccImSerPubOpnDate;
    }

    public void setUpccImSerPubOpnDate(String upccImSerPubOpnDate) {
        this.upccImSerPubOpnDate = upccImSerPubOpnDate;
    }

    public String getUpccImSerPubOpnNotes() {
        return upccImSerPubOpnNotes;
    }

    public void setUpccImSerPubOpnNotes(String upccImSerPubOpnNotes) {
        this.upccImSerPubOpnNotes = upccImSerPubOpnNotes;
    }

    public String getUpccImStbFullOprDate() {
        return upccImStbFullOprDate;
    }

    public void setUpccImStbFullOprDate(String upccImStbFullOprDate) {
        this.upccImStbFullOprDate = upccImStbFullOprDate;
    }

    public String getUpccImStbFullOprNotes() {
        return upccImStbFullOprNotes;
    }

    public void setUpccImStbFullOprNotes(String upccImStbFullOprNotes) {
        this.upccImStbFullOprNotes = upccImStbFullOprNotes;
    }

    public String getUpccInComSelDate() {
        return upccInComSelDate;
    }

    public void setUpccInComSelDate(String upccInComSelDate) {
        this.upccInComSelDate = upccInComSelDate;
    }

    public String getUpccInComSelNotes() {
        return upccInComSelNotes;
    }

    public void setUpccInComSelNotes(String upccInComSelNotes) {
        this.upccInComSelNotes = upccInComSelNotes;
    }

    public String getUpccInConSumAccDate() {
        return upccInConSumAccDate;
    }

    public void setUpccInConSumAccDate(String upccInConSumAccDate) {
        this.upccInConSumAccDate = upccInConSumAccDate;
    }

    public String getUpccInConSumAccNotes() {
        return upccInConSumAccNotes;
    }

    public void setUpccInConSumAccNotes(String upccInConSumAccNotes) {
        this.upccInConSumAccNotes = upccInConSumAccNotes;
    }

    public String getUpccInConSumSubDate() {
        return upccInConSumSubDate;
    }

    public void setUpccInConSumSubDate(String upccInConSumSubDate) {
        this.upccInConSumSubDate = upccInConSumSubDate;
    }

    public String getUpccInConSumSubNotes() {
        return upccInConSumSubNotes;
    }

    public void setUpccInConSumSubNotes(String upccInConSumSubNotes) {
        this.upccInConSumSubNotes = upccInConSumSubNotes;
    }

    public String getUpccPlFunPkgAppDate() {
        return upccPlFunPkgAppDate;
    }

    public void setUpccPlFunPkgAppDate(String upccPlFunPkgAppDate) {
        this.upccPlFunPkgAppDate = upccPlFunPkgAppDate;
    }

    public String getUpccPlFunPkgAppNotes() {
        return upccPlFunPkgAppNotes;
    }

    public void setUpccPlFunPkgAppNotes(String upccPlFunPkgAppNotes) {
        this.upccPlFunPkgAppNotes = upccPlFunPkgAppNotes;
    }

    public String getUpccPlFunPkgPenDate() {
        return upccPlFunPkgPenDate;
    }

    public void setUpccPlFunPkgPenDate(String upccPlFunPkgPenDate) {
        this.upccPlFunPkgPenDate = upccPlFunPkgPenDate;
    }

    public String getUpccPlFunPkgPenNotes() {
        return upccPlFunPkgPenNotes;
    }

    public void setUpccPlFunPkgPenNotes(String upccPlFunPkgPenNotes) {
        this.upccPlFunPkgPenNotes = upccPlFunPkgPenNotes;
    }

    public String getUpccPlSerPlnEdrDate() {
        return upccPlSerPlnEdrDate;
    }

    public void setUpccPlSerPlnEdrDate(String upccPlSerPlnEdrDate) {
        this.upccPlSerPlnEdrDate = upccPlSerPlnEdrDate;
    }

    public String getUpccPlSerPlnEdrNotes() {
        return upccPlSerPlnEdrNotes;
    }

    public void setUpccPlSerPlnEdrNotes(String upccPlSerPlnEdrNotes) {
        this.upccPlSerPlnEdrNotes = upccPlSerPlnEdrNotes;
    }

    public String getUpccPlSerPlnRevDate() {
        return upccPlSerPlnRevDate;
    }

    public void setUpccPlSerPlnRevDate(String upccPlSerPlnRevDate) {
        this.upccPlSerPlnRevDate = upccPlSerPlnRevDate;
    }

    public String getUpccPlSerPlnRevNotes() {
        return upccPlSerPlnRevNotes;
    }

    public void setUpccPlSerPlnRevNotes(String upccPlSerPlnRevNotes) {
        this.upccPlSerPlnRevNotes = upccPlSerPlnRevNotes;
    }


    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.PCD_STATUS_TRACKER_UPCC;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(submissionId);
        elements.add(upccId);
        elements.add(upccName);
        elements.add(upccTypeOfCare);
        elements.add(getUpccAddress());
        elements.add(upccChangesToService);
        elements.add(upccChangesToServiceDate);
        elements.add(upccServiceDeliveryMode);
        elements.add(upccImFndNotOpnDate);
        elements.add(upccImFndNotOpnNotes);
        elements.add(upccImSerPubOpnDate);
        elements.add(upccImSerPubOpnNotes);
        elements.add(upccImStbFullOprDate);
        elements.add(upccImStbFullOprNotes);
        elements.add(upccInComSelDate);
        elements.add(upccInComSelNotes);
        elements.add(upccInConSumAccDate);
        elements.add(upccInConSumAccNotes);
        elements.add(upccInConSumSubDate);
        elements.add(upccInConSumSubNotes);
        elements.add(upccPlFunPkgAppDate);
        elements.add(upccPlFunPkgAppNotes);
        elements.add(upccPlFunPkgPenDate);
        elements.add(upccPlFunPkgPenNotes);
        elements.add(upccPlSerPlnEdrDate);
        elements.add(upccPlSerPlnEdrNotes);
        elements.add(upccPlSerPlnRevDate);
        elements.add(upccPlSerPlnRevNotes);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }

}
