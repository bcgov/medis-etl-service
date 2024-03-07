package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FRUpccItemizedFinancialData implements IModel{

    public String budgetId;
    public String expenseItem;
    public String expenseItemSubtype;
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
    public String totalActualYtdExpenses;


    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getExpenseItem() {
        return expenseItem;
    }

    public void setExpenseItem(String expenseItem) {
        this.expenseItem = expenseItem;
    }

    public String getExpenseItemSubtype() {
        return expenseItemSubtype;
    }

    public void setExpenseItemSubtype(String expenseItemSubtype) {
        this.expenseItemSubtype = expenseItemSubtype;
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

    public String getTotalActualYtdExpenses() {
        return totalActualYtdExpenses;
    }

    public void setTotalActualYtdExpenses(String totalActualYtdExpenses) {
        this.totalActualYtdExpenses = totalActualYtdExpenses;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FR_UPCC_ITEMIZED_FINANCIAL_DATA;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(budgetId);
        elements.add(expenseItem);
        elements.add(expenseItemSubtype);
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
        elements.add(totalActualYtdExpenses);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
