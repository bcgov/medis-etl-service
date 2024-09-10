package ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.processor.ProvincialRiskTrackingApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.processor.ProvincialRiskTrackingApiReponseProcessor;

public class ProvincialRiskTrackingRoute extends BaseRoute {
	private static final Logger logger = LoggerFactory.getLogger(ProvincialRiskTrackingRoute.class);

	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded Provincial Risk Tracking Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/provincial-risk-tracking").routeId("provincial-risk-tracking")
				.log("CHEFS-ETL received a request for Provincial Risk Tracking Form extraction")
				.to("direct:pcd-provincial-risk-tracking").end();

		from("direct:pcd-provincial-risk-tracking")
				// to the http uri
				.process(new ProvincialRiskTrackingApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new ProvincialRiskTrackingApiReponseProcessor()).end();
	}
}
