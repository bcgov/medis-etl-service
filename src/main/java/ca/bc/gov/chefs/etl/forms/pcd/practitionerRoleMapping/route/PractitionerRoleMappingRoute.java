package ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.processor.PcdPractitionerRoleMappingApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.processor.PcdPractitionerRoleMappingApiResponseProcessor;

public class PractitionerRoleMappingRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(PractitionerRoleMappingRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded Practitioner Role Mapping Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/practitioner-role-mapping").routeId("pcd-practitioner-role-mapping-form")
				.log("CHEFS-ETL received a request for Practitioner Role Mapping Form extraction")
				.to("direct:pcd-practitioner-role-mapping").end();

		from("direct:pcd-practitioner-role-mapping")
				// to the http uri
				.process(new PcdPractitionerRoleMappingApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdPractitionerRoleMappingApiResponseProcessor()).end();
	}

}
