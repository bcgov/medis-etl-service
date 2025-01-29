package ca.bc.gov.chefs.etl.util;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;

public class HaMappingAggregationStrategy implements AggregationStrategy {

	public Exchange aggregate(Exchange original, Exchange resource) {
		original.getProperties().put("haMapping", resource.getIn().getBody(String.class));

		return original;
	}

}