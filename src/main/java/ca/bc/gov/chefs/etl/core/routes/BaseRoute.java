package ca.bc.gov.chefs.etl.core.routes;

import java.util.Properties;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.hc.core5.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.core.model.ErrorResponse;
import ca.bc.gov.chefs.etl.util.PropertiesUtil;

public abstract class BaseRoute extends RouteBuilder {
	static Properties properties = PropertiesUtil.loadProperties();
	private static final Logger logger = LoggerFactory.getLogger(BaseRoute.class);

	@Override
	public void configure() throws Exception {
		onException(Exception.class)
		.handled(true)
		.process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
                logger.error("Processing error {}", exception.getLocalizedMessage());
								if (exception.getCause()!=null) {
									logger.error("Cause {}", exception.getCause().toString());
								}
								exception.printStackTrace();
				
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setMessage(exception.getLocalizedMessage());
				errorResponse.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
				errorResponse.setType("Error");
				
                ObjectMapper mapper = new ObjectMapper();
				exchange.getIn().setBody(mapper.writeValueAsString(errorResponse));
			}
			
		})
		.setHeader("Content-Type",constant("application/json"))
		.end();
	}
}
