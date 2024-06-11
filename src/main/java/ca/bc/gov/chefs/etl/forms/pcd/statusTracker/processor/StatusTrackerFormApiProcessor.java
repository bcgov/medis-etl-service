package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class StatusTrackerFormApiProcessor extends BaseApiProcessor {

	public StatusTrackerFormApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_STATUS_TRACKER_PROPERTY;
	}

}
