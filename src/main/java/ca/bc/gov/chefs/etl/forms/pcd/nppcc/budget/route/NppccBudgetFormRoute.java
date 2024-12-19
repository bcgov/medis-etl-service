package ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.processor.PcdNppccBudgetApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.processor.PcdNppccBudgetApiResponseProcessor;

public class NppccBudgetFormRoute extends BaseRoute {
	private static final Logger logger = LoggerFactory.getLogger(NppccBudgetFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded NPPCC Budget Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/nppcc-budget").routeId("pcd-nppcc-budget-form")
				.log("CHEFS-ETL received a request for NPPCC Budget Form extraction")
				.to("direct:pcd-nppcc-budget").end();

		from("direct:pcd-nppcc-budget")
				// to the http uri
				.process(new PcdNppccBudgetApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdNppccBudgetApiResponseProcessor())
				// Clean up the headers returned to the caller
				.removeHeaders("*")				
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
				.end();
	}
    
}
