package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FRUpccFinancialSubTotals implements IModel{

    public String submissionId;
    public String expenseCategory;
    public String expenseSubCategory;
    public String typeOfCare;
    public String approvedBudget;
    public String ftesHiredToDate;
    public String fyExpenseForecast;
    public String fyExpenseVariance;
    public String fyEstimatedSurplus;
    public String proratedYtdBudget;
    public String ytdExpenseVariance;
    public String approvedFtesInclRelief;
    public String totalActualYtdExpense;
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

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FR_UPCC_FINANCIAL_SUB_TOTALS;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(expenseCategory);
        elements.add(expenseSubCategory);
        elements.add(typeOfCare);
        elements.add(approvedBudget);
        elements.add(ftesHiredToDate);
        elements.add(fyExpenseForecast);
        elements.add(fyExpenseVariance);
        elements.add(fyEstimatedSurplus);
        elements.add(proratedYtdBudget);
        elements.add(ytdExpenseVariance);
        elements.add(approvedFtesInclRelief);
        elements.add(totalActualYtdExpense);
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
