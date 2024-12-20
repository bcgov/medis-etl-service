package ca.bc.gov.chefs.etl.core.processor;

import static ca.bc.gov.chefs.etl.constant.Constants.PROPERTY_CHEFS_PAYLOAD;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ca.bc.gov.chefs.etl.core.model.ChefsRequestPayload;
import ca.bc.gov.chefs.etl.util.JsonUtil;

/**
 * Stores the input payload for re-use within multiple Processors. E.g. in a
 * multicast scenario.
 */
public class ChefsPayloadProcessor implements Processor {
	public void process(Exchange exchange) throws Exception {
		ChefsRequestPayload payload = JsonUtil.parseJsonString(exchange.getIn().getBody(String.class), ChefsRequestPayload.class);

		exchange.setProperty(PROPERTY_CHEFS_PAYLOAD, payload);
	}

}