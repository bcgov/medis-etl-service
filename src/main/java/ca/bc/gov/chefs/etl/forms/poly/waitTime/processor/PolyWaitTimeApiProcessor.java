package ca.bc.gov.chefs.etl.forms.poly.waitTime.processor;

import ca.bc.gov.chefs.etl.constant.POLYConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PolyWaitTimeApiProcessor extends BaseApiProcessor {
    public PolyWaitTimeApiProcessor() {
        this.formPropertyName = POLYConstants.POLY_WAIT_TIME_PROPERTY;
    }
}
