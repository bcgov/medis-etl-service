package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.processor;

import java.util.ArrayList;
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
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdPcnFRApiResponseProcessor extends BaseApiResponseProcessor{

    @Override
	@SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> pcnFRModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<FRPcnSubmission> parsedPcnFR = parsePcnFRRequest(pcnFRModels);
		
		validateRecordCount(pcnFRModels, parsedPcnFR);
		
		List<IModel> iModels = (List<IModel>) (List<?>) parsedPcnFR;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_PCN_FR_DIR, isHeaderAdded);

		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setFiles(filesGenerated);
		exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }
    
        private List<FRPcnSubmission> parsePcnFRRequest(List<Root> pcnFRModels){
            List<FRPcnSubmission> financialReportingPCN = new ArrayList<>();

            return financialReportingPCN;
        }
}
