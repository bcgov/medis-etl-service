package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdUpccBudgetApiProcessor extends BaseApiProcessor {
	public PcdUpccBudgetApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_UPCC_BUDGET_PROPERTY;
	}
    
}
