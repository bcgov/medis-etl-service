package ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor;

import static ca.bc.gov.chefs.etl.constant.Constants.PROPERTY_CHEFS_PAYLOAD;
import static ca.bc.gov.chefs.etl.constant.Constants.STATUS_SUBMITTED;

import org.apache.camel.Exchange;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.ChefsRequestPayload;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class LtcQuarterlyYtdSubmittedApiProcessor extends BaseApiProcessor {

	public LtcQuarterlyYtdSubmittedApiProcessor() {
		this.formPropertyName = Constants.LTC_YTD_PROPERTY;
	}

	@Override
	protected ChefsRequestPayload loadChefsPayload(Exchange exchange) {
		ChefsRequestPayload payload = exchange.getProperty(PROPERTY_CHEFS_PAYLOAD, ChefsRequestPayload.class);
		// Only ever return SUBMITTED data
		payload.setStatus(STATUS_SUBMITTED);

		return payload;
	}
}
