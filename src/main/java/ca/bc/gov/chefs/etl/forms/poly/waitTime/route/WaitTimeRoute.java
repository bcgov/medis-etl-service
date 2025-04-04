package ca.bc.gov.chefs.etl.forms.poly.waitTime.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.poly.waitTime.processor.PolyWaitTimeApiProcessor;
import ca.bc.gov.chefs.etl.forms.poly.waitTime.processor.PolyWaitTimeApiResponseProcessor;

public class WaitTimeRoute extends BaseRoute {
    private static final Logger logger = LoggerFactory.getLogger(WaitTimeRoute.class);

    @Override
    public void configure() throws Exception {
        super.configure();
        logger.info("Loaded POLY Wait Time Route");

        /**
         * receive JSON payload, parse and set to make an API call
         */
        // trigger
        from("jetty:http://{{hostname}}:{{port}}/poly/wait-time").routeId("poly-wait-time-form")
                .log("CHEFS-ETL received a request for POLY Wait Time Report Form extraction")
                .to("direct:poly-wait-time-form").end();

        // process
        from("direct:poly-wait-time-form").routeId("poly-wait-time-form-processor")
                .process(new PolyWaitTimeApiProcessor())
                .toD("${header.RequestUri}")
                .log("This is the status code from the response: ${header.CamelHttpResponseCode}")
                .log("Trying to convert the received body OK").convertBodyTo(String.class)
                .process(new PolyWaitTimeApiResponseProcessor()).end();
    }

}
