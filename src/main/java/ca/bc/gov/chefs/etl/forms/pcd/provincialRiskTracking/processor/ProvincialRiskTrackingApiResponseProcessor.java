package ca.bc.gov.chefs.etl.forms.pcd.provincialRiskTracking.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.modelmapper.ModelMapper;

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

public class ProvincialRiskTrackingApiResponseProcessor extends BaseApiResponseProcessor {

    @SuppressWarnings("unchecked")
    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        payload = JsonUtil.fixUnicodeCharacters(payload);
        ObjectMapper mapper = new ObjectMapper();

        List<Root> provincialRiskTrackingModels = mapper.readValue(payload,
                new TypeReference<List<Root>>() {
                });
        List<ProvincialRiskTracking> parsedProvincialRiskTracking = parseProvincialRiskTrackingRequest(
                provincialRiskTrackingModels);

        validateRecordCount(provincialRiskTrackingModels, parsedProvincialRiskTracking);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedProvincialRiskTracking;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map,
                PCDConstants.PCD_PROVINCIAL_RISK_TRACKING_DIR,
                isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<ProvincialRiskTracking> parseProvincialRiskTrackingRequest(
            List<Root> provincialRiskTrackingModels) {
        List<ProvincialRiskTracking> parsedProvincialRiskTracking = new ArrayList<>();
        // Use ModelMapper to handle the basic conversion
        ModelMapper modelMapper = new ModelMapper();

        // Define nested mappings
        modelMapper.typeMap(Root.class, ProvincialRiskTracking.class).addMappings(mapper -> {
            mapper.map(src -> src.getForm().getSubmissionId(),
                    ProvincialRiskTracking::setSubmissionId);
            mapper.map(src -> src.getLateEntry().toString(),
                    ProvincialRiskTracking::setLateEntry);
            mapper.map(src -> src.getForm().getFullName(),
                    ProvincialRiskTracking::setSubmitterFullName);
            mapper.map(src -> src.getForm().getUsername(),
                    ProvincialRiskTracking::setSubmitterUserName);
            mapper.map(src -> src.getForm().getEmail(),
                    ProvincialRiskTracking::setSubmitterEmail);
            mapper.map(src -> src.getForm().getStatus(),
                    ProvincialRiskTracking::setSubmissionStatus);
            mapper.map(src -> src.getForm().getVersion(),
                    ProvincialRiskTracking::setSubmissionVersion);
            mapper.map(src -> src.getForm().getFormName(),
                    ProvincialRiskTracking::setSubmissionFormName);
            mapper.map(src -> src.getDescriptionOfIssueOrRisk(),
                    ProvincialRiskTracking::setIssueAndRiskDescription);
            mapper.map(src -> src.getIssueRiskTitle(),
                    ProvincialRiskTracking::setIssueAndRiskTitle);

        });

        for (Root root : provincialRiskTrackingModels) {
            ProvincialRiskTracking provincialRiskTracking = modelMapper.map(root,
                    ProvincialRiskTracking.class);
            provincialRiskTracking.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
            provincialRiskTracking.setIssueRaisedDate(CSVUtil.formatDate(root.getIssueRaisedDate()));
            provincialRiskTracking.setIssueClosedDate(CSVUtil.formatDate(root.getIssueClosedDate()));
            provincialRiskTracking
                    .setDateMitigationPlanComms(CSVUtil.formatDate(root.getDateMitigationPlanCommences()));

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
