package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.processor;
import java.util.Map;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdDecisionLogApiProcessor extends BaseApiProcessor {
	public PcdDecisionLogApiProcessor() {
		this.formPropertyName = Constants.PCD_DECISION_LOG_PROPERTY;
	}
}