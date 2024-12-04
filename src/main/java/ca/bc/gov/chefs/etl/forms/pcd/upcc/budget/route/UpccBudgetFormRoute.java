package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.processor.PcdUpccBudgetApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.processor.PcdUpccBudgetApiResponseProcessor;

public class UpccBudgetFormRoute extends BaseRoute {
	private static final Logger logger = LoggerFactory.getLogger(UpccBudgetFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded UPCC Budget Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/upcc-budget").routeId("pcd-upcc-budget-form")
				.log("CHEFS-ETL received a request for UPCC Budget Form extraction")
				.to("direct:pcd-upcc-budget").end();

		from("direct:pcd-upcc-budget")
				// to the http uri
				.process(new PcdUpccBudgetApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdUpccBudgetApiResponseProcessor())
				.removeHeaders("*")				
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
				.end();
	}
    
}
