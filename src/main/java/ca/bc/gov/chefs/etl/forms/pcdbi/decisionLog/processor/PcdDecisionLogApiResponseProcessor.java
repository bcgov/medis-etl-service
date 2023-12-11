package ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.processor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.eclipse.jetty.server.RequestLog.Collection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.CommonUtils;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdDecisionLogApiResponseProcessor implements Processor {

	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		// List<Root> staffingPlanModels = mapper.readValue(payload,
		// 		new TypeReference<List<Root>>() {
		// 		});
		// List<LTCStaffingSubmission> parsedStaffingPlan = parseStaffingPlan(staffingPlanModels);
		// List<IModel> iModels = (List<IModel>) (List<?>) parsedStaffingPlan;
		// Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		// //map = CSVUtil.removeAllNullKeys(map);
		// boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		// List<String> filesGenerated = FileUtil.writeToCSVFile(map,Constants.LTC_STAFFING_PLAN_DIR, isHeaderAdded);


		// TODO remove successReponse or uncomment
		// SuccessResponse successResponse = new SuccessResponse();
		// successResponse.setFiles(filesGenerated);
		// exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
		
}
