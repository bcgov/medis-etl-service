package ca.bc.gov.chefs.etl.forms.pda.waitTime.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pda.waitTime.processor.PdaWaitTimeApiProcessor;
import ca.bc.gov.chefs.etl.forms.pda.waitTime.processor.PdaWaitTimeApiResponseProcessor;

public class WaitTimeRoute extends BaseRoute {
    private static final Logger logger = LoggerFactory.getLogger(WaitTimeRoute.class);

    @Override
    public void configure() throws Exception {
        super.configure();
        logger.info("Loaded PDA Wait Time Route");

        /**
         * receive JSON payload, parse and set to make an API call
         */
        // trigger
        from("jetty:http://{{hostname}}:{{port}}/pda/wait-time").routeId("pda-wait-time-form")
                .log("CHEFS-ETL received a request for PDA Wait Time Report Form extraction")
                .to("direct:pda-wait-time-form").end();

        // process
        from("direct:pda-wait-time-form").routeId("pda-wait-time-form-processor")
                .process(new PdaWaitTimeApiProcessor())
                .toD("${header.RequestUri}")
                .log("This is the status code from the response: ${header.CamelHttpResponseCode}")
                .log("Trying to convert the received body OK").convertBodyTo(String.class)
                .process(new PdaWaitTimeApiResponseProcessor()).end();
    }

}
