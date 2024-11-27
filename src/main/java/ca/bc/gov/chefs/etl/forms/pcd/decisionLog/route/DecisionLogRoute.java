package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.route;

import static ca.bc.gov.chefs.etl.constant.Constants.PROPERTY_STATUS;
import static ca.bc.gov.chefs.etl.constant.Constants.STATUS_ASSIGNED;
import static ca.bc.gov.chefs.etl.constant.Constants.STATUS_COMPLETED;
import static ca.bc.gov.chefs.etl.constant.Constants.STATUS_SUBMITTED;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.processor.ChefsPayloadProcessor;
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
				.process(new ChefsPayloadProcessor())
				.multicast(new GroupedExchangeAggregationStrategy())
					.to("direct:pcd-decision-log-assigned")
					.to("direct:pcd-decision-log-completed")
					.to("direct:pcd-decision-log-submitted")
				.end()
				.process(new PcdDecisionLogApiResponseProcessor())
				// Clean up the headers returned to the caller
				.removeHeaders("*")				
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
				.end();
		
		from("direct:pcd-decision-log-assigned")
				// to the http uri
				.setProperty(PROPERTY_STATUS).simple(STATUS_ASSIGNED)
				.process(new PcdDecisionLogApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.end();		
		
		from("direct:pcd-decision-log-completed")
				// to the http uri
				.setProperty(PROPERTY_STATUS).simple(STATUS_COMPLETED)
				.process(new PcdDecisionLogApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.end();

		from("direct:pcd-decision-log-submitted")
				// to the http uri
				.setProperty(PROPERTY_STATUS).simple(STATUS_SUBMITTED)
				.process(new PcdDecisionLogApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.end();

	}

}
