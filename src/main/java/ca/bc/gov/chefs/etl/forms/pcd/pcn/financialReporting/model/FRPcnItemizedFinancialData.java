package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model;

import static ca.bc.gov.chefs.etl.constant.Constants.DEFAULT_DECIMAL_VALUE;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class FRPcnItemizedFinancialData implements IModel{

    private String budgetId;
    private String expenseId;
    private String expenseItem;
    private String expenseItemSubType;
    private String fyExpenseForecast;
    private String p1;
    private String p2;
    private String p3;
    private String p4;
    private String p5;
    private String p6;
    private String p7;
    private String p8;
    private String p9;
    private String p10;
    private String p11;
    private String p12;
    private String p13;
    private String totalActualYtdExpenses;
    private String otherItems;
    private String typesOfTraining;
    private String listOfRolesTitles;
    
    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseItem() {
        return expenseItem;
    }

    public void setExpenseItem(String expenseItem) {
        this.expenseItem = expenseItem;
    }

    public String getExpenseItemSubType() {
        return expenseItemSubType;
    }

    public void setExpenseItemSubType(String expenseItemSubType) {
        this.expenseItemSubType = expenseItemSubType;
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
        this.totalActualYtdExpenses = StringUtils.defaultIfEmpty(totalActualYtdExpenses, DEFAULT_DECIMAL_VALUE);
    }

    public String getOtherItems() {
        return CSVUtil.replaceCarriageReturnLineFeed(otherItems);
    }

    public void setOtherItems(String otherItems) {
        this.otherItems = otherItems;
    }

    public String getTypesOfTraining() {
        return CSVUtil.replaceCarriageReturnLineFeed(typesOfTraining);
    }

    public void setTypesOfTraining(String typesOfTraining) {
        this.typesOfTraining = typesOfTraining;
    }

    public String getListOfRolesTitles() {
        return CSVUtil.replaceCarriageReturnLineFeed(listOfRolesTitles);
    }

    public void setListOfRolesTitles(String listOfRolesTitles) {
        this.listOfRolesTitles = listOfRolesTitles;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FR_PCN_ITEMIZED_FINANCIAL_DATA;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(budgetId);
        elements.add(expenseId);
        elements.add(expenseItem);
        elements.add(expenseItemSubType);
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
        elements.add(totalActualYtdExpenses);
        elements.add(getOtherItems());
        elements.add(getTypesOfTraining());
        elements.add(getListOfRolesTitles());
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
