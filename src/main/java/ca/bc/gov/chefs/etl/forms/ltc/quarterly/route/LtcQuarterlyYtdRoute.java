package ca.bc.gov.chefs.etl.forms.ltc.quarterly.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor.LtcQuarterlyYtdApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor.LtcQuarterlyYtdApiProcessor;

public class LtcQuarterlyYtdRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(LtcQuarterlyYtdRoute.class);

	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded LTC QYTD Form (Completed) Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 * 
		 * 
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/ltc-quarterly-ytd")
				.routeId("ltc-quarterly-ytd-form")
				.log("CHEFS-ETL received a request for LTCQ Form extraction")
				.to("direct:ltc-quarterly-ytd").end();

		from("direct:ltc-quarterly-ytd")
				// to the http uri
				.process(new LtcQuarterlyYtdApiProcessor()).toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new LtcQuarterlyYtdApiResponseProcessor()).removeHeaders("*")
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8")).end();

		// file conversion
		/*
		 * from("direct:ltc-quarterly-csv-processing").routeId("")
		 * .log("CHEFS ETL received a request to encrypt files") .process()
		 */
	}

}
