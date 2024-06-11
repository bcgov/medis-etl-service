package ca.bc.gov.chefs.etl.forms.pcd.pcps.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;

public class PcpsFormRoute extends BaseRoute{
	private static final Logger logger = LoggerFactory.getLogger(PcpsFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded Primary Care Patient Services Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/pcps").routeId("pcd-pcps-form")
				.log("CHEFS-ETL received a request for Primary Care Patient Services Form extraction")
				.to("direct:pcd-pcps").end();

		// from("direct:pcd-upcc-financial-reporting")
		// 		// to the http uri
		// 		.process(new PcdUpccFRApiProcessor())
		// 		.toD("${header.RequestUri}")
		// 		.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
		// 		.log("Trying to convert the received body OK").convertBodyTo(String.class)
		// 		.process(new PcdUpccFRApiResponseProcessor()).end();
	}
}