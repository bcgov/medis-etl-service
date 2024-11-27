package ca.bc.gov.chefs.etl.core.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ca.bc.gov.chefs.etl.core.model.ChefsRequestPayload;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class ChefsPayloadProcessor implements Processor {
	public void process(Exchange exchange) throws Exception {
		ChefsRequestPayload payload =  JsonUtil.parseJsonString(exchange.getIn().getBody(String.class), ChefsRequestPayload.class); 
		
		// Store the payload for future processors
		exchange.setProperty("chefsPayload", payload);
	}

}
