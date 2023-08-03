package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

import java.util.ArrayList;
import java.util.List;

public class PCNName implements IModel {

    private String confirmationId;

    private String pcnName;

    private String type;

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = confirmationId;
    }

    public String getPcnName() {
        return pcnName;
    }

    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return Constants.PCD_STATUS_TRACKER_PCN_NAME;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(getConfirmationId());
        elements.add(getPcnName());
        elements.add(getType());

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
}
