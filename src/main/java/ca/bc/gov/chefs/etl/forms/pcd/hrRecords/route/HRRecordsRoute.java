package ca.bc.gov.chefs.etl.forms.pcd.hrRecords.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.processor.PcdHRRecordsApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.processor.PcdHRRecordsApiResponseProcessor;

public class HRRecordsRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(HRRecordsRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded HR Records Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/hr-records").routeId("pcd-hr-records-form")
				.log("CHEFS-ETL received a request for HR Records Form extraction")
				.to("direct:pcd-hr-records").end();

        // process
        from("direct:pcd-hr-records")
            // to the http uri
            .process(new PcdHRRecordsApiProcessor())
            .toD("${header.RequestUri}")
            .log("This is the status code from the response: ${header.CamelHttpResponseCode}")
            .log("Trying to convert the received body OK").convertBodyTo(String.class)
            .process(new PcdHRRecordsApiResponseProcessor())
			// Clean up the headers returned to the caller
			.removeHeaders("*")				
			.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
            .end();
	}

}
