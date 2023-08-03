package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.processor;

import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;
import java.util.Map;

public class StatusTrackerFormApiProcessor extends BaseApiProcessor {

	public StatusTrackerFormApiProcessor(Map<String, String> sharedData, String formPropertyName) {

		this.sharedData = sharedData;
		this.formPropertyName = formPropertyName;
	}

}
