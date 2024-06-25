package ca.bc.gov.chefs.etl.forms.pcd.hrRecords.processor;

import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.json.Root;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdHRRecordsApiResponseProcessor extends BaseApiResponseProcessor {

    @SuppressWarnings("unchecked")
    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        ObjectMapper mapper = new ObjectMapper();

        List<Root> hrRecordsModels = mapper.readValue(payload,
                new TypeReference<List<Root>>() {
                });
        System.out.println("hrRecordsModels: " + hrRecordsModels);

        // List<Root> parsedhrRecords = parseHRRecordsRequest(hrRecordsModels);

        // validateRecordCount(hrRecordsModels, parsedhrRecords);

        // List<IModel> iModels = (List<IModel>) (List<?>) parsedhrRecords;
        // Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

        // boolean isHeaderAdded = (boolean)
        // exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        // List<String> filesGenerated = FileUtil.writeToCSVFile(map,
        // PCDConstants.PCD_HR_RECORDS_DIR, isHeaderAdded);

        // SuccessResponse successResponse = new SuccessResponse();
        // successResponse.setFiles(filesGenerated);
        // exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

}
