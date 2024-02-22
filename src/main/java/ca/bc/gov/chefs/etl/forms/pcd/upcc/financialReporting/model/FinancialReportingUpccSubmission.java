package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model;

import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialReportingUpccSubmission implements IModel{

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FINANCIAL_REPORTING_UPCC_SUBMISSION;
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
