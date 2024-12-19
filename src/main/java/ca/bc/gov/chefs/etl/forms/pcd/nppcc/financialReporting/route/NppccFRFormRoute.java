package ca.bc.gov.chefs.etl.forms.pcd.nppcc.financialReporting.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.nppcc.financialReporting.processor.PcdNppccFRApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.nppcc.financialReporting.processor.PcdNppccFRApiResponseProcessor;

public class NppccFRFormRoute extends BaseRoute{
	private static final Logger logger = LoggerFactory.getLogger(NppccFRFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded NPPCC Financial Reporting Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/nppcc-financial-reporting").routeId("pcd-nppcc-financial-reporting-form")
				.log("CHEFS-ETL received a request for NPPCC Financial Reporting Form extraction")
				.to("direct:pcd-nppcc-financial-reporting").end();

		from("direct:pcd-nppcc-financial-reporting")
				// to the http uri
				.process(new PcdNppccFRApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdNppccFRApiResponseProcessor())
				// Clean up the headers returned to the caller
				.removeHeaders("*")				
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
				.end();
	}
}
