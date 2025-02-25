package ca.bc.gov.chefs.etl.forms.ltc.quarterly.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor.LtcQuarterlyYtdBaseApiProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor.LtcQuarterlyYtdSubmittedApiResponseProcessor;

public class LtcQuarterlyYtdSubmittedRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(LtcQuarterlyYtdSubmittedRoute.class);

	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded LTC QYTD Form (Submitted) Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 * 
		 * 
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/ltc-quarterly-ytd-submitted")
				.routeId("ltc-quarterly-ytd-submitted-form")
				.log("CHEFS-ETL received a request for LTCQ Form extraction")
				.to("direct:ltc-quarterly-ytd-submitted").end();

		from("direct:ltc-quarterly-ytd-submitted")
				// to the http uri
				.process(new LtcQuarterlyYtdBaseApiProcessor()).toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new LtcQuarterlyYtdSubmittedApiResponseProcessor()).removeHeaders("*")
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8")).end();

	}

}
