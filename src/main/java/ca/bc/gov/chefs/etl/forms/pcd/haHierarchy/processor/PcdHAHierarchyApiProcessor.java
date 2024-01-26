package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdHAHierarchyApiProcessor extends BaseApiProcessor {
	public PcdHAHierarchyApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_HA_HIERARCHY_PROPERTY;
	}
}