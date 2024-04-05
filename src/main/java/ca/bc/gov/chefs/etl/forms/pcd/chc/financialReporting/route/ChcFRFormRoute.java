package ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.processor.PcdChcFRApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.processor.PcdChcFRApiResponseProcessor;

public class ChcFRFormRoute extends BaseRoute{
	private static final Logger logger = LoggerFactory.getLogger(ChcFRFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded CHC Financial Reporting Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/chc-financial-reporting").routeId("pcd-chc-financial-reporting-form")
				.log("CHEFS-ETL received a request for CHC Financial Reporting Form extraction")
				.to("direct:pcd-chc-financial-reporting").end();

		from("direct:pcd-chc-financial-reporting")
				// to the http uri
				.process(new PcdChcFRApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdChcFRApiResponseProcessor()).end();
	}
}
