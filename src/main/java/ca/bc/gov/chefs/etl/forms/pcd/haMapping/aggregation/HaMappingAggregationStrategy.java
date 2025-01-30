package ca.bc.gov.chefs.etl.forms.pcd.haMapping.aggregation;

import static ca.bc.gov.chefs.etl.constant.Constants.PROPERTY_HA_MAPPING;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.forms.pcd.haMapping.json.Root;

public class HaMappingAggregationStrategy implements AggregationStrategy {
	
	private static final Logger log = LoggerFactory.getLogger(HaMappingAggregationStrategy.class);

	public Exchange aggregate(Exchange original, Exchange resource) {
		// Store the mapping for use in processing
		ObjectMapper mapper = new ObjectMapper();
		
		String payload = resource.getIn().getBody(String.class);
       
        List<Root> haMapping = new ArrayList<Root>();
		try {
			haMapping = mapper.readValue(payload, new TypeReference<List<Root>>() {});
		} catch (JsonProcessingException e) {
			log.error("Could not load HA Mappings", e);
		}
        
        // There should only be a single submission
		original.getProperties().put(PROPERTY_HA_MAPPING, haMapping.get(0).getHaMappings());

		return original;
	}

}