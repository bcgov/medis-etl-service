package ca.bc.gov.chefs.etl.forms.pcd.nppcc.financialReporting.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdNppccFRApiProcessor extends BaseApiProcessor {
    public PcdNppccFRApiProcessor() {
        this.formPropertyName = PCDConstants.PCD_NPPCC_FR_PROPERTY;
    }
}
