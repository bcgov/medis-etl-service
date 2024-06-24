package ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.processor.PcdChcPCPSApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.processor.PcdChcPCPSApiResponseProcessor;

public class ChcPcpsFormRoute extends BaseRoute{
	private static final Logger logger = LoggerFactory.getLogger(ChcPcpsFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded CHC Primary Care Patient Services Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/chc-pcps").routeId("pcd-chc-pcps-form")
				.log("CHEFS-ETL received a request for CHC Primary Care Patient Services Form extraction")
				.to("direct:pcd-chc-pcps").end();

		// process
		from("direct:pcd-chc-pcps").routeId("pcd-chc-pcps-form-processor")
				.process(new PcdChcPCPSApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdChcPCPSApiResponseProcessor()).end();
	}
}