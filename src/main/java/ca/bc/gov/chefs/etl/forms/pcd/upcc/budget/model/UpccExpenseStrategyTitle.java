package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class UpccExpenseStrategyTitle implements IModel{

    private String expenseId;
    private String strategyTitleId;
    private String strategyTitle;

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getStrategyTitleId() {
        return strategyTitleId;
    }

    public void setStrategyTitleId(String strategyTitleId) {
        this.strategyTitleId = strategyTitleId;
    }

    public String getStrategyTitle() {
        return strategyTitle;
    }

    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.UPCC_EXPENSE_STRATEGY_TITLE;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(expenseId);
        elements.add(strategyTitleId);
        elements.add(strategyTitle);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
