package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdFinancialExpenseApiProcessor extends BaseApiProcessor {
    	public PcdFinancialExpenseApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_FINANCIAL_EXPENSE_PROPERTY;
	}
}
