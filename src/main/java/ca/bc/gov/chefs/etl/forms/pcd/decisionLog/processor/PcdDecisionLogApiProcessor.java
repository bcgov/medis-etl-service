package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.processor;

import static ca.bc.gov.chefs.etl.constant.Constants.PROPERTY_CHEFS_PAYLOAD;
import static ca.bc.gov.chefs.etl.constant.Constants.PROPERTY_STATUS;

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
		ChefsRequestPayload payload = exchange.getProperty(PROPERTY_CHEFS_PAYLOAD, ChefsRequestPayload.class);

		payload.setStatus((String) exchange.getProperty(PROPERTY_STATUS));

		return payload;
	}
}