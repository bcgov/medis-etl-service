package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.processor.ChefsPayloadProcessor;
import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.haMapping.aggregation.HaMappingAggregationStrategy;
import ca.bc.gov.chefs.etl.forms.pcd.haMapping.processor.PcdHAMappingApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.processor.PcdUpccFRApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.processor.PcdUpccFRApiResponseProcessor;

public class UpccFRFormRoute extends BaseRoute{
	private static final Logger logger = LoggerFactory.getLogger(UpccFRFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded UPCC Financial Reporting Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/upcc-financial-reporting").routeId("pcd-upcc-financial-reporting-form")
				.log("CHEFS-ETL received a request for UPCC Financial Reporting Form extraction")
				.process(new ChefsPayloadProcessor())
				.to("direct:pcd-upcc-financial-reporting").end();

		from("direct:pcd-upcc-financial-reporting")
				// to the http uri
				.process(new PcdUpccFRApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				
				// Enrich with HA Mapping data
				.enrich("direct:ha-hierarchy-mapping-upcc", new HaMappingAggregationStrategy())
				
				.process(new PcdUpccFRApiResponseProcessor())
				.removeHeaders("*")				
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
				.end();
		
		from("direct:ha-hierarchy-mapping-upcc")
			// to the http uri
			.process(new PcdHAMappingApiProcessor())
			.toD("${header.RequestUri}")
			.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
			.log("Trying to convert the received body OK").convertBodyTo(String.class)
			.end();	
	}
}
