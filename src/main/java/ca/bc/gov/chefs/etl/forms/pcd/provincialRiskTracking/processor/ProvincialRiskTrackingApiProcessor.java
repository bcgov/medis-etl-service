package ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class ProvincialRiskTrackingApiProcessor extends BaseApiProcessor {
    public ProvincialRiskTrackingApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_PROVINCIAL_RISK_TRACKING_PROPERTY;
	}
}
