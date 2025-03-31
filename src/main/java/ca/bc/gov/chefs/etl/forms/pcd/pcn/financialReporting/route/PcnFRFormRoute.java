package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.processor.ChefsPayloadProcessor;
import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.haMapping.aggregation.HaMappingAggregationStrategy;
import ca.bc.gov.chefs.etl.forms.pcd.haMapping.processor.PcdHAMappingApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.processor.PcdPcnFRApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.processor.PcdPcnFRApiResponseProcessor;

public class PcnFRFormRoute extends BaseRoute{
    private static final Logger logger = LoggerFactory.getLogger(PcnFRFormRoute.class);
	
    @Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded PCN Financial Reporting Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/pcn-financial-reporting").routeId("pcd-pcn-financial-reporting-form")
				.log("CHEFS-ETL received a request for PCN Financial Reporting Form extraction")
				.process(new ChefsPayloadProcessor())
				.to("direct:pcd-pcn-financial-reporting").end();

		from("direct:pcd-pcn-financial-reporting")
				// to the http uri
				.process(new PcdPcnFRApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				
				// Enrich with HA Mapping data
				.enrich("direct:ha-hierarchy-mapping-pcn", new HaMappingAggregationStrategy())
				.process(new PcdPcnFRApiResponseProcessor())

				// Clean up the headers returned to the caller
				.removeHeaders("*")				
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
				.end();
		
		from("direct:ha-hierarchy-mapping-pcn")
				// to the http uri
				.process(new PcdHAMappingApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.end();	
	}
}
