package ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.processor.PcdFiscalYearReportingDatesApiProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.processor.PcdFiscalYearReportingDatesApiResponseProcessor;

public class FiscalYearReportingDatesRoute extends BaseRoute {

    private static final Logger logger = LoggerFactory.getLogger(FiscalYearReportingDatesRoute.class);

    @Override
    public void configure() throws Exception {
        super.configure();
        logger.info("Loaded Fiscal Year Reporting Dates Route");

        /**
         * receive JSON payload, parse and set to make an API call
         */
        // trigger
        from("jetty:http://{{hostname}}:{{port}}/pcd/fiscal-year-reporting-dates")
                .routeId("pcd-fiscal-year-reporting-dates-form")
                .log("CHEFS-ETL received a request for Fiscal Year Reporting Dates Form extraction")
                .to("direct:pcd-fiscal-year-reporting-dates").end();

        // process
        from("direct:pcd-fiscal-year-reporting-dates")
                // to the http uri
                .process(new PcdFiscalYearReportingDatesApiProcessor())
                .toD("${header.RequestUri}")
                .log("This is the status code from the response: ${header.CamelHttpResponseCode}")
                .log("Trying to convert the received body OK").convertBodyTo(String.class)
                .process(new PcdFiscalYearReportingDatesApiResponseProcessor()).end();
    }

}
