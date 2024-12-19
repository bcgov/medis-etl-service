package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.processor.PcdPcnBudgetApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.processor.PcdPcnBudgetApiResponseProcessor;

public class PcnBudgetFormRoute extends BaseRoute{
    private static final Logger logger = LoggerFactory.getLogger(PcnBudgetFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded PCN Budget Route");
		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/pcn-budget").routeId("pcd-pcn-budget-form")
				.log("CHEFS-ETL received a request for PCN Budget Form extraction")
				.to("direct:pcd-pcn-budget").end();

		from("direct:pcd-pcn-budget")
				// to the http uri
				.process(new PcdPcnBudgetApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdPcnBudgetApiResponseProcessor())
				// Clean up the headers returned to the caller
				.removeHeaders("*")				
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
				.end();
	}
    
}
