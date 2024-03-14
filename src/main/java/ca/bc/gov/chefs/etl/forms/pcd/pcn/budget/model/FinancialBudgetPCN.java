package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model;

import java.util.List;

import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetPCN implements IModel{

    private String submissionId;
    private String createdAt;
    private String lateEntry;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionVersion;
    private String submissionFormName;
    private String healthAuthority;
    private String communityName;
    private String fiscalYear;
    
    @Override
    public String getFileName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFileName'");
    }

    @Override
    public String getFormType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFormType'");
    }

    @Override
    public List<String> getCsvElements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCsvElements'");
    }

    @Override
    public List<IModel> getObjects() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getObjects'");
    }
    
}
