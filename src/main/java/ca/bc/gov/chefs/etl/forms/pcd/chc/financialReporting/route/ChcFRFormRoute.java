package ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.processor.ChefsPayloadProcessor;
import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.processor.PcdChcFRApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.processor.PcdChcFRApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.haMapping.aggregation.HaMappingAggregationStrategy;
import ca.bc.gov.chefs.etl.forms.pcd.haMapping.processor.PcdHAMappingApiProcessor;

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
				.process(new ChefsPayloadProcessor())
				.to("direct:pcd-chc-financial-reporting").end();

		from("direct:pcd-chc-financial-reporting")
				// to the http uri
				.process(new PcdChcFRApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				
				// Enrich with HA Mapping data
				.enrich("direct:ha-hierarchy-mapping-chc", new HaMappingAggregationStrategy())
				.process(new PcdChcFRApiResponseProcessor())
				
				// Clean up the headers returned to the caller
				.removeHeaders("*")				
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
				.end();
		
		from("direct:ha-hierarchy-mapping-chc")
				// to the http uri
				.process(new PcdHAMappingApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.end();	
	}
}
