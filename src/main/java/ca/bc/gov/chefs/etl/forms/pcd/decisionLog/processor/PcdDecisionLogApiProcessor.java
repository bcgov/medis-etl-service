package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdDecisionLogApiProcessor extends BaseApiProcessor {
	public PcdDecisionLogApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_DECISION_LOG_PROPERTY;
	}
}