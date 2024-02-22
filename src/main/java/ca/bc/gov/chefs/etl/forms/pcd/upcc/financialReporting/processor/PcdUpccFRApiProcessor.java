package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdUpccFRApiProcessor extends BaseApiProcessor{
    public PcdUpccFRApiProcessor(){
        this.formPropertyName = PCDConstants.PCD_UPCC_FR_PROPERTY;
    }
}
