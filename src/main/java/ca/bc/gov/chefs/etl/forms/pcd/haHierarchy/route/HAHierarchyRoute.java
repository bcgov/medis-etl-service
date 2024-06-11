package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.processor.PcdHAHierarchyApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.processor.PcdHAHierarchyApiResponseProcessor;

public class HAHierarchyRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(HAHierarchyRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded HA Hierarchy Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/pcd/ha-hierarchy").routeId("pcd-ha-hierarchy-form")
				.log("CHEFS-ETL received a request for HA Hierarchy Form extraction")
				.to("direct:pcd-ha-hierarchy").end();

		from("direct:pcd-ha-hierarchy")
				// to the http uri
				.process(new PcdHAHierarchyApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new PcdHAHierarchyApiResponseProcessor()).end();
	}

}
