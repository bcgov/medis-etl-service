package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class UpccExpensePrimaryTargetPopulation implements IModel{

    private String expenseId;
    private String targetPopulation;

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getTargetPopulation() {
        return targetPopulation;
    }

    public void setTargetPopulation(String targetPopulation) {
        this.targetPopulation = targetPopulation;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.UPCC_EXPENSE_PRIMARY_TARGET_POPULATION;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(expenseId);
        elements.add(targetPopulation);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
