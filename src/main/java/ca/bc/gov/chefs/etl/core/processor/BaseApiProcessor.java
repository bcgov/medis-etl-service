package ca.bc.gov.chefs.etl.core.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.ChefsRequestPayload;
import ca.bc.gov.chefs.etl.util.AuthUtil;
import ca.bc.gov.chefs.etl.util.CommonUtils;
import ca.bc.gov.chefs.etl.util.JsonUtil;
import ca.bc.gov.chefs.etl.util.PropertiesUtil;

public class BaseApiProcessor implements Processor {
    
    protected String formPropertyName;
	

	@Override
	public void process(Exchange exchange) throws Exception {
		ChefsRequestPayload payload = loadChefsPayload(exchange);
		
		String FORM_USERNAME = PropertiesUtil.buildFormProperty(formPropertyName, payload.getHealthAuthority(), true);
		String FORM_PASSWORD = PropertiesUtil.buildFormProperty(formPropertyName, payload.getHealthAuthority(), false);
		String uri = CommonUtils.generateRequestUri(payload, FORM_USERNAME);

		exchange.getIn().setHeader("RequestUri", uri);
		exchange.getIn().setHeader("CamelHttpMethod", "GET");
		exchange.getIn().setHeader("Content-Type", "application/json");
		exchange.getIn().setHeader("accept", "application/json");
		exchange.getIn().setHeader("Authorization",
				AuthUtil.getBasicAuth(PropertiesUtil.getValue(FORM_USERNAME),
						PropertiesUtil.getValue(FORM_PASSWORD)));
		
		exchange.setProperty(Constants.IS_HEADER_ADDED, payload.isHeaderAdded());
	}
	
	protected ChefsRequestPayload loadChefsPayload(Exchange exchange) throws Exception {
		return JsonUtil.parseJsonString(exchange.getIn().getBody(String.class), ChefsRequestPayload.class);
	}
}
