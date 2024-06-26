package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.processor.PcdDecisionLogApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.processor.PcdDecisionLogApiResponseProcessor;

public class DecisionLogRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(DecisionLogRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded Decision Log Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/decision-log").routeId("pcd-decision-log-form")
				.log("CHEFS-ETL received a request for Decision Log Form extraction")
				.to("direct:pcd-decision-log").end();

		from("direct:pcd-decision-log")
				// to the http uri
				.process(new PcdDecisionLogApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdDecisionLogApiResponseProcessor()).end();
	}

}
