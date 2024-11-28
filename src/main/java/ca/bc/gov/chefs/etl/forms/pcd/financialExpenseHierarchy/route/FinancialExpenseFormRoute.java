package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.processor.PcdFinancialExpenseApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.processor.PcdFinancialExpenseApiResponseProcessor;

public class FinancialExpenseFormRoute extends BaseRoute {
	private static final Logger logger = LoggerFactory.getLogger(FinancialExpenseFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded Financial Expense Hierarchy Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/financial-expense").routeId("pcd-financial-expense-form")
				.log("CHEFS-ETL received a request for UPCC Budget Form extraction")
				.to("direct:pcd-financial-expense").end();

		from("direct:pcd-financial-expense")
				// to the http uri
				.process(new PcdFinancialExpenseApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdFinancialExpenseApiResponseProcessor())
				// Clean up the headers returned to the caller
				.removeHeaders("*")				
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
				.end();
	}
    
}
