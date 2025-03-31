package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PCN {
    public String pcnName;
    public String pcnType;
    public List<ClinicData> pcnClinic;
    public List<CHC> chc;
    public List<UPCC> upcc;
    public List<FNPCC> fnpcc;
    public List<NPPCC> nppcc;
    public String pcnNameId;

    public String getPcnName() {
        return pcnName;
    }

    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
    }

    public String getPcnType() {
        return pcnType;
    }

    public void setPcnType(String pcnType) {
        this.pcnType = pcnType;
    }

    public List<ClinicData> getPcnClinic() {
        return pcnClinic;
    }

    public void setPcnClinic(List<ClinicData> pcnClinic) {
        this.pcnClinic = pcnClinic;
    }

    public List<CHC> getChc() {
        return chc;
    }

    public void setChc(List<CHC> chc) {
        this.chc = chc;
    }

    public List<UPCC> getUpcc() {
        return upcc;
    }

    public void setUpcc(List<UPCC> upcc) {
        this.upcc = upcc;
    }

    public List<FNPCC> getFnpcc() {
        return fnpcc;
    }

    public void setFnpcc(List<FNPCC> fnpcc) {
        this.fnpcc = fnpcc;
    }

    public List<NPPCC> getNppcc() {
        return nppcc;
    }

    public void setNppcc(List<NPPCC> nppcc) {
        this.nppcc = nppcc;
    }

    public String getPcnNameId() {
        return pcnNameId;
    }

    public void setPcnNameId(String pcnNameId) {
        this.pcnNameId = pcnNameId;
    }
}
