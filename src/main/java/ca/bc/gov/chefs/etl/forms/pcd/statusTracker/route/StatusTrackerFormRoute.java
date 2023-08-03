package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.route;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.processor.StatusTrackerFormApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.processor.StatusTrackerFormApiResponseProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatusTrackerFormRoute extends BaseRoute {

    private static final Logger logger = LoggerFactory.getLogger(StatusTrackerFormRoute.class);

    @Override
    public void configure() throws Exception {
        super.configure();
        logger.info("Loaded Status Tracker Form Route");

        /**
         * receive JSON payload, parse and set to make an API call
         *
         *
         */

        // trigger


        from("jetty:http://{{hostname}}:{{port}}/pcd/status-tracker").routeId("status-tracker-form")
                .log("CHEFS-ETL received a request for Status Tracker Form extraction")
                .process(exchange -> sharedData.put("body", exchange.getIn().getBody(String.class)))
                .to("direct:status-tracker-data").end();

        from("direct:status-tracker-data")
                // to the http uri
                .process(new StatusTrackerFormApiProcessor(sharedData, Constants.PCD_STATUS_TRACKER_PROPERTY))
                .toD("${header.RequestUri}")
                .log("This is the status code from the response: ${header.CamelHttpResponseCode}")
                .log("Trying to convert the received body OK").convertBodyTo(String.class)
                .process(new StatusTrackerFormApiResponseProcessor())
                .setHeader("Content-Type",constant("application/json"))
                .end();
        // database phase

        // file conversion

    }
}
