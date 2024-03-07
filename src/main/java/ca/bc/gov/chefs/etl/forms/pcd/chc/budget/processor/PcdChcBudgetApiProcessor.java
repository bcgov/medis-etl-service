package ca.bc.gov.chefs.etl.forms.pcd.chc.budget.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdChcBudgetApiProcessor extends BaseApiProcessor {
	public PcdChcBudgetApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_CHC_BUDGET_PROPERTY;
	}
    
}
