package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdUpccPCPSApiProcessor extends BaseApiProcessor {
	public PcdUpccPCPSApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_UPCC_PCPS_PROPERTY;
	}
}
