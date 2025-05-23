package ca.bc.gov.chefs.etl.forms.pcd.hrRecords.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Form form;
    private String pcnName;
    private String addGroup;
    private String clinicID;
    private String lateEntry;
    private String clinicName;
    private String clinicType;
    private String showBanner;
    private String pcnCommunity;
    private String initiativeType;
    private String addPractitioner;
    private String healthAuthority;
    private String selectTheReportingLevel;
    private List<ClinicRecordDetails> clinicRecordDetails = new ArrayList<>();

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

    public String getPcnName() {
        return pcnName;
    }

    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
    }

    public String getAddGroup() {
        return addGroup;
    }

    public void setAddGroup(String addGroup) {
        this.addGroup = addGroup;
    }

    public String getClinicID() {
        return clinicID;
    }

    public void setClinicID(String clinicID) {
        this.clinicID = clinicID;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }

    public String getShowBanner() {
        return showBanner;
    }

    public void setShowBanner(String showBanner) {
        this.showBanner = showBanner;
    }

    public String getPcnCommunity() {
        return pcnCommunity;
    }

    public void setPcnCommunity(String pcnCommunity) {
        this.pcnCommunity = pcnCommunity;
    }

    public String getInitiativeType() {
        return initiativeType;
    }

    public void setInitiativeType(String initiativeType) {
        this.initiativeType = initiativeType;
    }

    public String getAddPractitioner() {
        return addPractitioner;
    }

    public void setAddPractitioner(String addPractitioner) {
        this.addPractitioner = addPractitioner;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getSelectTheReportingLevel() {
        return selectTheReportingLevel;
    }

    public void setSelectTheReportingLevel(String selectTheReportingLevel) {
        this.selectTheReportingLevel = selectTheReportingLevel;
    }

    public List<ClinicRecordDetails> getClinicRecordDetails() {
        return clinicRecordDetails;
    }

    public void setClinicRecordDetails(List<ClinicRecordDetails> clinicRecordDetails) {
        this.clinicRecordDetails = clinicRecordDetails;
    }

    @Override
    public String toString() {
        return "Root [form=" + form + ", pcnName=" + pcnName + ", addGroup=" + addGroup + ", clinicID=" + clinicID
                + ", lateEntry=" + lateEntry + ", clinicName=" + clinicName + ", clinicType=" + clinicType
                + ", showBanner=" + showBanner + ", pcnCommunity=" + pcnCommunity + ", initiativeType=" + initiativeType
                + ", addPractitioner=" + addPractitioner + ", healthAuthority=" + healthAuthority
                + ", selectTheReportingLevel=" + selectTheReportingLevel + ", clinicRecordDetails="
                + clinicRecordDetails + "]";
    }
}
