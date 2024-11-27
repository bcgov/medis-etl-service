package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.processor;

import org.apache.camel.Exchange;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.ChefsRequestPayload;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdDecisionLogApiProcessor extends BaseApiProcessor {

	public PcdDecisionLogApiProcessor() {
		this.formPropertyName = PCDConstants.PCD_DECISION_LOG_PROPERTY;
	}
	
	@Override
	protected ChefsRequestPayload loadChefsPayload(Exchange exchange) {		
		ChefsRequestPayload payload =  exchange.getProperty("chefsPayload", ChefsRequestPayload.class);
		
		payload.setStatus((String)exchange.getProperty("status"));
		
		return payload;
	}
}