package ca.bc.gov.chefs.etl.forms.pcd.haMapping.processor;

import static ca.bc.gov.chefs.etl.constant.Constants.PROPERTY_CHEFS_PAYLOAD;	
import org.apache.camel.Exchange;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.ChefsRequestPayload;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdHAMappingApiProcessor extends BaseApiProcessor {
	public PcdHAMappingApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_HA_MAPPING_PROPERTY;
	}
	
    
    @Override
    protected ChefsRequestPayload loadChefsPayload(Exchange exchange) {
        return exchange.getProperty(PROPERTY_CHEFS_PAYLOAD, ChefsRequestPayload.class);
    }
}