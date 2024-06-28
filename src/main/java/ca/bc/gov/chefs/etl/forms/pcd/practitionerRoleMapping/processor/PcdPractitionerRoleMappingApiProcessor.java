package ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdPractitionerRoleMappingApiProcessor extends BaseApiProcessor {
    	public PcdPractitionerRoleMappingApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_PRACTITIONER_ROLE_MAPPING_PROPERTY;
	}
}
