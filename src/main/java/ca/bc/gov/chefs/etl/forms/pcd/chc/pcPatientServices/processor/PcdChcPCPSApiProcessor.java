package ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdChcPCPSApiProcessor extends BaseApiProcessor {
	public PcdChcPCPSApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_CHC_PCPS_PROPERTY;
	}
}
