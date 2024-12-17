package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootPatientCareItem {
    public String p1;
    public String p2;
    public String p3;
    public String p4;
    public String p5;
    public String p6;
    public String p7;
    public String p8;
    public String p9;
    public String p10;
    public String p11;
    public String p12;
    public String p13;
    public String patientCareService;
    public String patientCareServiceMeasure;
    public String patientCareServiceMeasureType;
    public String patientCareServiceMeasureSubtype;

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }

    public String getP6() {
        return p6;
    }

    public void setP6(String p6) {
        this.p6 = p6;
    }

    public String getP7() {
        return p7;
    }

    public void setP7(String p7) {
        this.p7 = p7;
    }

    public String getP8() {
        return p8;
    }

    public void setP8(String p8) {
        this.p8 = p8;
    }

    public String getP9() {
        return p9;
    }

    public void setP9(String p9) {
        this.p9 = p9;
    }

    public String getP10() {
        return p10;
    }

    public void setP10(String p10) {
        this.p10 = p10;
    }

    public String getP11() {
        return p11;
    }

    public void setP11(String p11) {
        this.p11 = p11;
    }

    public String getP12() {
        return p12;
    }

    public void setP12(String p12) {
        this.p12 = p12;
    }

    public String getP13() {
        return p13;
    }

    public void setP13(String p13) {
        this.p13 = p13;
    }

    public String getPatientCareService() {
        return patientCareService;
    }

    public void setPatientCareService(String patientCareService) {
        this.patientCareService = patientCareService;
    }

    public String getPatientCareServiceMeasure() {
        return patientCareServiceMeasure;
    }

    public void setPatientCareServiceMeasure(String patientCareServiceMeasure) {
        this.patientCareServiceMeasure = patientCareServiceMeasure;
    }

    public String getPatientCareServiceMeasureType() {
        return patientCareServiceMeasureType;
    }

    public void setPatientCareServiceMeasureType(String patientCareServiceMeasureType) {
        this.patientCareServiceMeasureType = patientCareServiceMeasureType;
    }

    public String getPatientCareServiceMeasureSubtype() {
        return patientCareServiceMeasureSubtype;
    }

    public void setPatientCareServiceMeasureSubtype(String patientCareServiceMeasureSubtype) {
        this.patientCareServiceMeasureSubtype = patientCareServiceMeasureSubtype;
    }

    @Override
    public String toString() {
        return "RootPatientCareItem [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + ", p5=" + p5 + ", p6="
                + p6
                + ", p7=" + p7 + ", p8=" + p8 + ", p9=" + p9 + ", p10=" + p10 + ", p11=" + p11 + ", p12=" + p12
                + ", p13=" + p13
                + ", patientCareService=" + patientCareService + ", patientCareServiceMeasure="
                + patientCareServiceMeasure
                + ", patientCareServiceMeasureType=" + patientCareServiceMeasureType
                + ", patientCareServiceMeasureSubtype="
                + patientCareServiceMeasureSubtype + "]";
    }
}
