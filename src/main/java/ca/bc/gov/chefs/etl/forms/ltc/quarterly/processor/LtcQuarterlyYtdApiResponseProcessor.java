package ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor;

import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;

public class LtcQuarterlyYtdApiResponseProcessor extends BaseLtcQuarterlyYtdApiResponseProcessor {

	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		List<LtcYtdSubmission> parsedLtycYtdSubmissions = parse(exchange);
		List<IModel> iModels = (List<IModel>) (List<?>) parsedLtycYtdSubmissions;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, Constants.LTC_QUARTERLY_DIR, isHeaderAdded);
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setFiles(filesGenerated);
		exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
}
