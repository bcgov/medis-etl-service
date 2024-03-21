package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdPcnFRApiProcessor extends BaseApiProcessor{
    public PcdPcnFRApiProcessor(){
        this.formPropertyName = PCDConstants.PCD_PCN_FR_PROPERTY;
    }
}
