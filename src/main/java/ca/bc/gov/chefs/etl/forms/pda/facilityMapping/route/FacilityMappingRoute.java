package ca.bc.gov.chefs.etl.forms.pda.facilityMapping.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pda.facilityMapping.processor.PdaFacilityMappingApiProcessor;
import ca.bc.gov.chefs.etl.forms.pda.facilityMapping.processor.PdaFacilityMappingApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pda.waitTime.route.WaitTimeRoute;

public class FacilityMappingRoute extends BaseRoute {
    private static final Logger logger = LoggerFactory.getLogger(WaitTimeRoute.class);

    @Override
    public void configure() throws Exception {
        super.configure();
        logger.info("Loaded PDA Facility Mapping Route");

        /**
         * receive JSON payload, parse and set to make an API call
         */
        // trigger
        from("jetty:http://{{hostname}}:{{port}}/pda/facility-mapping").routeId("pda-facility-mapping-form")
                .log("CHEFS-ETL received a request for PDA Facility Mapping Report Form extraction")
                .to("direct:pda-facility-mapping-form").end();

        // process
        from("direct:pda-facility-mapping-form").routeId("pda-facility-mapping-form-processor")
                .process(new PdaFacilityMappingApiProcessor())
                .toD("${header.RequestUri}")
                .log("This is the status code from the response: ${header.CamelHttpResponseCode}")
                .log("Trying to convert the received body OK").convertBodyTo(String.class)
                .process(new PdaFacilityMappingApiResponseProcessor()).end();
    }
}
