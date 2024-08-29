package ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.processor;

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
import ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.model.ProvincialRiskCategory;
import ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.model.ProvincialRiskTracking;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class ProvincialRiskTrackingApiReponseProcessor extends BaseApiResponseProcessor {
    
    @SuppressWarnings("unchecked")
    @Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> provincialRiskTrackingModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<ProvincialRiskTracking> parsedProvincialRiskTracking = parseProvincialRiskTrackingRequest(provincialRiskTrackingModels);
		
		validateRecordCount(provincialRiskTrackingModels, parsedProvincialRiskTracking);
		
		List<IModel> iModels = (List<IModel>) (List<?>) parsedProvincialRiskTracking;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_PROVINCIAL_RISK_TRACKING_DIR, isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<ProvincialRiskTracking> parseProvincialRiskTrackingRequest(List<Root> provincialRiskTrackingModels) {
        List<ProvincialRiskTracking> parsedProvincialRiskTracking = new ArrayList<>();
        for (Root root : provincialRiskTrackingModels) {
            ProvincialRiskTracking provincialRiskTracking = new ProvincialRiskTracking();
            provincialRiskTracking.setSubmissionId(root.getForm().getSubmissionId());
            provincialRiskTracking.setCreatedAt(root.getForm().getCreatedAt());
            provincialRiskTracking.setLateEntry(root.getLateEntry().toString());
            provincialRiskTracking.setSubmitterFullName(root.getForm().getFullName());
            provincialRiskTracking.setSubmitterUserName(root.getForm().getUsername());
            provincialRiskTracking.setSubmitterEmail(root.getForm().getEmail());
            provincialRiskTracking.setSubmissionStatus(root.getForm().getStatus());
            provincialRiskTracking.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
            provincialRiskTracking.setSubmissionFormName(root.getForm().getFormName());
            provincialRiskTracking.setTypeOfInitative(root.getTypeOfInitiative());
            provincialRiskTracking.setIssueRaisedDate(root.getIssueRaisedDate());
            provincialRiskTracking.setRelevantSites(root.getRelevantSites());
            provincialRiskTracking.setIssueClosedDate(root.getIssueClosedDate());
            provincialRiskTracking.setIssueAndRiskDescription(root.getDescriptionOfIssueOrRisk());
            provincialRiskTracking.setDateMitigationPlanComms(root.getDateMitigationPlanCommences());
            provincialRiskTracking.setMitigationStrategy(root.getMitigationStrategy());
            provincialRiskTracking.setIsuesNotes(root.getIssuesNotes());
            provincialRiskTracking.setLevelOfRisk(root.getLevelOfRisk());
            provincialRiskTracking.setIssueAndRiskTitle(root.getIssueRiskTitle());

            List<ProvincialRiskCategory> provincialRiskCategories = new ArrayList<>();
            for (String category : root.getIssueRiskCategory()) {
                ProvincialRiskCategory provincialRiskCategory = new ProvincialRiskCategory();
                provincialRiskCategory.setSubmissionId(root.getForm().getSubmissionId());
                provincialRiskCategory.setCategoryOfIssue(category);
                provincialRiskCategories.add(provincialRiskCategory);
            }
            provincialRiskTracking.setProvincialRiskCategories(provincialRiskCategories);

            parsedProvincialRiskTracking.add(provincialRiskTracking);
        }
        return parsedProvincialRiskTracking;
    }
}
