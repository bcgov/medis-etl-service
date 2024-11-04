package ca.bc.gov.chefs.etl.forms.pda.waitTime.processor;

import ca.bc.gov.chefs.etl.constant.PDAConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PdaWaitTimeApiProcessor extends BaseApiProcessor {
    public PdaWaitTimeApiProcessor() {
        this.formPropertyName = PDAConstants.PDA_WAIT_TIME_PROPERTY;
    }

}