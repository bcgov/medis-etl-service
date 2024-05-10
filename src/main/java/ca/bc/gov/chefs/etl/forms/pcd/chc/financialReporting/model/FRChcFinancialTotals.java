package ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FRChcFinancialTotals implements IModel {

    public String submissionId;
    public String expenseCategory;
    public String expenseSubCategory;
    public String approvedFtes;
    public String approvedBudget;
    public String ftesHiredToDate;
    public String fyExpenseForecast;
    
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
    
    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getExpenseSubCategory() {
        return expenseSubCategory;
    }

    public void setExpenseSubCategory(String expenseSubCategory) {
        this.expenseSubCategory = expenseSubCategory;
    }

    public String getApprovedFtes() {
        return approvedFtes;
    }

    public void setApprovedFtes(String approvedFtes) {
        this.approvedFtes = approvedFtes;
    }

    public String getApprovedBudget() {
        return approvedBudget;
    }

    public void setApprovedBudget(String approvedBudget) {
        this.approvedBudget = approvedBudget;
    }

    public String getFtesHiredToDate() {
        return ftesHiredToDate;
    }

    public void setFtesHiredToDate(String ftesHiredToDate) {
        this.ftesHiredToDate = ftesHiredToDate;
    }

    public String getFyExpenseForecast() {
        return fyExpenseForecast;
    }

    public void setFyExpenseForecast(String fyExpenseForecast) {
        this.fyExpenseForecast = fyExpenseForecast;
    }


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

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FR_CHC_FINANCIAL_TOTALS;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(expenseCategory);
        elements.add(expenseSubCategory);
        elements.add(approvedBudget);
        elements.add(approvedFtes);
        elements.add(ftesHiredToDate);
        elements.add(fyExpenseForecast);
        elements.add(p1);
        elements.add(p2);
        elements.add(p3);
        elements.add(p4);
        elements.add(p5);
        elements.add(p6);
        elements.add(p7);
        elements.add(p8);
        elements.add(p9);
        elements.add(p10);
        elements.add(p11);
        elements.add(p12);
        elements.add(p13);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }

}
