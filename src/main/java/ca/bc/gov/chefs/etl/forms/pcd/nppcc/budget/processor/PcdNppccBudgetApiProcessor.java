package ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdNppccBudgetApiProcessor extends BaseApiProcessor {
	public PcdNppccBudgetApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_NPPCC_BUDGET_PROPERTY;
	}
    
}
