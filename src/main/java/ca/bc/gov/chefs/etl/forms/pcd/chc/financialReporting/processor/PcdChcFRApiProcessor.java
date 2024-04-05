package ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdChcFRApiProcessor extends BaseApiProcessor {
    public PcdChcFRApiProcessor() {
        this.formPropertyName = PCDConstants.PCD_CHC_FR_PROPERTY;
    }
}
