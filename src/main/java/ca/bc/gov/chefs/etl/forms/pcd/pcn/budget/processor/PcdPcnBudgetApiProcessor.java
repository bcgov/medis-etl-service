package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdPcnBudgetApiProcessor extends BaseApiProcessor{
    public PcdPcnBudgetApiProcessor(){
        this.formPropertyName = PCDConstants.PCD_PCN_BUDGET_PROPERTY;
    }
}
