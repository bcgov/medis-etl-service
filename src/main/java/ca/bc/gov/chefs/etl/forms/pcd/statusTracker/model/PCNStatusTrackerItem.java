package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import java.util.List;

import ca.bc.gov.chefs.etl.core.model.IModel;

public class PCNStatusTrackerItem implements IModel {
    private String submissionId;
    private String issueId;
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

    @Override
    public String getFileName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFileName'");
    }

    @Override
    public String getFormType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFormType'");
    }

    @Override
    public List<String> getCsvElements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCsvElements'");
    }

    @Override
    public List<IModel> getObjects() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getObjects'");
    }

}
