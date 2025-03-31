package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PCNStatusTrackerItem implements IModel {
    private String submissionId;
    private String pcnId;
    private String allClinicsImpacted;
    private String hsiarServicePlanGapAnlys;
    private String hsiarServPlGapAnlysDate;
    private String otherPcisIncluded;
    private String pcnImEstFndPrelncDate;
    private String pcnImEstFndPrelncNotes;
    private String pcnImSerPubLnchDate;
    private String pcnImSerPubLnchNotes;
    private String pcnImStbStdStaDate;
    private String pcnImStbStdStaNotes;
    private String pcnInEoiAppDate;
    private String pcnInEoiAppNotes;
    private String pcnInEoiSubDate;
    private String pcnInEoiSubNotes;
    private String pcnPlComAppMtgDate;
    private String pcnPlComAppMtgNotes;
    private String pcnPlFunPkgAppDate;
    private String pcnPlFunPkgAppNotes;
    private String pcnPlFunPkgPenDate;
    private String pcnPlFunPkgPenNotes;
    private String pcnPlSerPlnEdrDate;
    private String pcnPlSerPlnEdrNotes;
    private String pcnPlSerPlnRevDate;
    private String pcnPlSerPlnRevNotes;
    private String implementationYear;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getPcnId() {
        return pcnId;
    }

    public void setPcnId(String pcnId) {
        this.pcnId = pcnId;
    }

    public String getAllClinicsImpacted() {
        return allClinicsImpacted;
    }

    public void setAllClinicsImpacted(String allClinicsImpacted) {
        this.allClinicsImpacted = allClinicsImpacted;
    }

    public String getHsiarServicePlanGapAnlys() {
        return hsiarServicePlanGapAnlys;
    }

    public void setHsiarServicePlanGapAnlys(String hsiarServicePlanGapAnlys) {
        this.hsiarServicePlanGapAnlys = hsiarServicePlanGapAnlys;
    }

    public String getHsiarServPlGapAnlysDate() {
        return hsiarServPlGapAnlysDate;
    }

    public void setHsiarServPlGapAnlysDate(String hsiarServPlGapAnlysDate) {
        this.hsiarServPlGapAnlysDate = hsiarServPlGapAnlysDate;
    }

    public String getOtherPcisIncluded() {
        return otherPcisIncluded;
    }

    public void setOtherPcisIncluded(String otherPcisIncluded) {
        this.otherPcisIncluded = otherPcisIncluded;
    }

    public String getPcnImEstFndPrelncDate() {
        return pcnImEstFndPrelncDate;
    }

    public void setPcnImEstFndPrelncDate(String pcnImEstFndPrelncDate) {
        this.pcnImEstFndPrelncDate = pcnImEstFndPrelncDate;
    }

    public String getPcnImEstFndPrelncNotes() {
        return pcnImEstFndPrelncNotes;
    }

    public void setPcnImEstFndPrelncNotes(String pcnImEstFndPrelncNotes) {
        this.pcnImEstFndPrelncNotes = pcnImEstFndPrelncNotes;
    }

    public String getPcnImSerPubLnchDate() {
        return pcnImSerPubLnchDate;
    }

    public void setPcnImSerPubLnchDate(String pcnImSerPubLnchDate) {
        this.pcnImSerPubLnchDate = pcnImSerPubLnchDate;
    }

    public String getPcnImSerPubLnchNotes() {
        return pcnImSerPubLnchNotes;
    }

    public void setPcnImSerPubLnchNotes(String pcnImSerPubLnchNotes) {
        this.pcnImSerPubLnchNotes = pcnImSerPubLnchNotes;
    }

    public String getPcnImStbStdStaDate() {
        return pcnImStbStdStaDate;
    }

    public void setPcnImStbStdStaDate(String pcnImStbStdStaDate) {
        this.pcnImStbStdStaDate = pcnImStbStdStaDate;
    }

    public String getPcnImStbStdStaNotes() {
        return pcnImStbStdStaNotes;
    }

    public void setPcnImStbStdStaNotes(String pcnImStbStdStaNotes) {
        this.pcnImStbStdStaNotes = pcnImStbStdStaNotes;
    }

    public String getPcnInEoiAppDate() {
        return pcnInEoiAppDate;
    }

    public void setPcnInEoiAppDate(String pcnInEoiAppDate) {
        this.pcnInEoiAppDate = pcnInEoiAppDate;
    }

    public String getPcnInEoiAppNotes() {
        return pcnInEoiAppNotes;
    }

    public void setPcnInEoiAppNotes(String pcnInEoiAppNotes) {
        this.pcnInEoiAppNotes = pcnInEoiAppNotes;
    }

    public String getPcnInEoiSubDate() {
        return pcnInEoiSubDate;
    }

    public void setPcnInEoiSubDate(String pcnInEoiSubDate) {
        this.pcnInEoiSubDate = pcnInEoiSubDate;
    }

    public String getPcnInEoiSubNotes() {
        return pcnInEoiSubNotes;
    }

    public void setPcnInEoiSubNotes(String pcnInEoiSubNotes) {
        this.pcnInEoiSubNotes = pcnInEoiSubNotes;
    }

    public String getPcnPlComAppMtgDate() {
        return pcnPlComAppMtgDate;
    }

    public void setPcnPlComAppMtgDate(String pcnPlComAppMtgDate) {
        this.pcnPlComAppMtgDate = pcnPlComAppMtgDate;
    }

    public String getPcnPlComAppMtgNotes() {
        return pcnPlComAppMtgNotes;
    }

    public void setPcnPlComAppMtgNotes(String pcnPlComAppMtgNotes) {
        this.pcnPlComAppMtgNotes = pcnPlComAppMtgNotes;
    }

    public String getPcnPlFunPkgAppDate() {
        return pcnPlFunPkgAppDate;
    }

    public void setPcnPlFunPkgAppDate(String pcnPlFunPkgAppDate) {
        this.pcnPlFunPkgAppDate = pcnPlFunPkgAppDate;
    }

    public String getPcnPlFunPkgAppNotes() {
        return pcnPlFunPkgAppNotes;
    }

    public void setPcnPlFunPkgAppNotes(String pcnPlFunPkgAppNotes) {
        this.pcnPlFunPkgAppNotes = pcnPlFunPkgAppNotes;
    }

    public String getPcnPlFunPkgPenDate() {
        return pcnPlFunPkgPenDate;
    }

    public void setPcnPlFunPkgPenDate(String pcnPlFunPkgPenDate) {
        this.pcnPlFunPkgPenDate = pcnPlFunPkgPenDate;
    }

    public String getPcnPlFunPkgPenNotes() {
        return pcnPlFunPkgPenNotes;
    }

    public void setPcnPlFunPkgPenNotes(String pcnPlFunPkgPenNotes) {
        this.pcnPlFunPkgPenNotes = pcnPlFunPkgPenNotes;
    }

    public String getPcnPlSerPlnEdrDate() {
        return pcnPlSerPlnEdrDate;
    }

    public void setPcnPlSerPlnEdrDate(String pcnPlSerPlnEdrDate) {
        this.pcnPlSerPlnEdrDate = pcnPlSerPlnEdrDate;
    }

    public String getPcnPlSerPlnEdrNotes() {
        return pcnPlSerPlnEdrNotes;
    }

    public void setPcnPlSerPlnEdrNotes(String pcnPlSerPlnEdrNotes) {
        this.pcnPlSerPlnEdrNotes = pcnPlSerPlnEdrNotes;
    }

    public String getPcnPlSerPlnRevDate() {
        return pcnPlSerPlnRevDate;
    }

    public void setPcnPlSerPlnRevDate(String pcnPlSerPlnRevDate) {
        this.pcnPlSerPlnRevDate = pcnPlSerPlnRevDate;
    }

    public String getPcnPlSerPlnRevNotes() {
        return pcnPlSerPlnRevNotes;
    }

    public void setPcnPlSerPlnRevNotes(String pcnPlSerPlnRevNotes) {
        this.pcnPlSerPlnRevNotes = pcnPlSerPlnRevNotes;
    }

    public String getImplementationYear() {
        return implementationYear;
    }

    public void setImplementationYear(String implementationYear) {
        this.implementationYear = implementationYear;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.PCD_STATUS_TRACKER_PCN;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(pcnId);
        elements.add(allClinicsImpacted);
        elements.add(hsiarServicePlanGapAnlys);
        elements.add(hsiarServPlGapAnlysDate);
        elements.add(otherPcisIncluded);
        elements.add(pcnImEstFndPrelncDate);
        elements.add(pcnImEstFndPrelncNotes);
        elements.add(pcnImSerPubLnchDate);
        elements.add(pcnImSerPubLnchNotes);
        elements.add(pcnImStbStdStaDate);
        elements.add(pcnImStbStdStaNotes);
        elements.add(pcnInEoiAppDate);
        elements.add(pcnInEoiAppNotes);
        elements.add(pcnInEoiSubDate);
        elements.add(pcnInEoiSubNotes);
        elements.add(pcnPlComAppMtgDate);
        elements.add(pcnPlComAppMtgNotes);
        elements.add(pcnPlFunPkgAppDate);
        elements.add(pcnPlFunPkgAppNotes);
        elements.add(pcnPlFunPkgPenDate);
        elements.add(pcnPlFunPkgPenNotes);
        elements.add(pcnPlSerPlnEdrDate);
        elements.add(pcnPlSerPlnEdrNotes);
        elements.add(pcnPlSerPlnRevDate);
        elements.add(pcnPlSerPlnRevNotes);
        elements.add(implementationYear);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
}
