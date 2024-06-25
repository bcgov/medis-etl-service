package ca.bc.gov.chefs.etl.forms.pcd.hrRecords.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdHRRecordsApiProcessor extends BaseApiProcessor {
	public PcdHRRecordsApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_HR_RECORDS_PROPERTY;
	}
}