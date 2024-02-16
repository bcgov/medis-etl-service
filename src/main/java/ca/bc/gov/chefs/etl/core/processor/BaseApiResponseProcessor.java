package ca.bc.gov.chefs.etl.core.processor;

import java.util.List;

import org.apache.camel.CamelException;
import org.apache.camel.Processor;

public abstract class BaseApiResponseProcessor implements Processor {
    
    /**
     * Validates that the number of input records matches the number of parsed records.
     * Note the number of parsed records isn't necessarily the same as the number of
     * output records as post-processing to remove records may happen.
     * 
     * @param inputRecords
     * @param parsedRecords
     * @throws CamelException
     */
    protected void validateRecordCount(List<?> inputRecords, List<?> parsedRecords) throws CamelException {
        int inputCount = inputRecords.size();
        int parsedCount = parsedRecords.size();
        
        // Validate that all records were parsed
        if (inputCount != parsedCount) {
           throw new CamelException(String.format("Processing error. Input (%s) and parsed (%s) record counts don't match", inputCount, parsedCount));
        }
    }
}
