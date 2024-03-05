package ca.bc.gov.chefs.etl.forms.pcd.chc.budget.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.processor.PcdChcBudgetApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.processor.PcdChcBudgetApiResponseProcessor;

public class ChcBudgetFormRoute extends BaseRoute {
	private static final Logger logger = LoggerFactory.getLogger(ChcBudgetFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded CHC Budget Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/chc-budget").routeId("pcd-chc-budget-form")
				.log("CHEFS-ETL received a request for CHC Budget Form extraction")
				.to("direct:pcd-chc-budget").end();

		from("direct:pcd-chc-budget")
				// to the http uri
				.process(new PcdChcBudgetApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdChcBudgetApiResponseProcessor()).end();
	}
    
}
