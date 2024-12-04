package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.route;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.processor.PcdUpccPCPSApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.processor.PcdUpccPCPSApiResponseProcessor;

public class UpccPcpsFormRoute extends BaseRoute{
	private static final Logger logger = LoggerFactory.getLogger(UpccPcpsFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded UPCC Primary Care Patient Services Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/upcc-pcps").routeId("pcd-upcc-pcps-form")
				.log("CHEFS-ETL received a request for UPCC Primary Care Patient Services Form extraction")
				.to("direct:pcd-upcc-pcps-form").end();

		// process
		from("direct:pcd-upcc-pcps-form").routeId("pcd-upcc-pcps-form-processor")
				.process(new PcdUpccPCPSApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdUpccPCPSApiResponseProcessor())
				.removeHeaders("*")				
				.setHeader(Exchange.CONTENT_TYPE, constant("text/json;charset=utf-8"))
				.end();
	}
}