package ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.processor;

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
import ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.json.RoleMappings;
import ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.model.PractitionerRoleMappingData;
import ca.bc.gov.chefs.etl.forms.pcd.practitionerRoleMapping.model.PractitionerRoleMappingSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;

public class PcdPractitionerRoleMappingApiResponseProcessor extends BaseApiResponseProcessor {
    @SuppressWarnings("unchecked")
    @Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> pracRoleMappingsModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<PractitionerRoleMappingSubmission> parsedPracRoleMappings = parsePracRoleMappingsRequest(pracRoleMappingsModels);
		
		validateRecordCount(pracRoleMappingsModels, parsedPracRoleMappings);
		
		List<IModel> iModels = (List<IModel>) (List<?>) parsedPracRoleMappings;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_PRACTITIONER_ROLE_MAPPING_DIR, isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}

    private List<PractitionerRoleMappingSubmission> parsePracRoleMappingsRequest(List<Root> pracRoleMappingsModels) {
        List<PractitionerRoleMappingSubmission> parsedPracRoleMappings = new ArrayList<>();
        for (Root root : pracRoleMappingsModels) {
            PractitionerRoleMappingSubmission pracRoleMapping = new PractitionerRoleMappingSubmission();
            pracRoleMapping.setSubmissionId(root.getForm().getSubmissionId());
            pracRoleMapping.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
            pracRoleMapping.setLateEntry(root.getLateEntry());
            pracRoleMapping.setSubmitterFullName(root.getForm().getFullName());
            pracRoleMapping.setSubmitterUserName(root.getForm().getUsername());
            pracRoleMapping.setSubmitterEmail(root.getForm().getEmail());
            pracRoleMapping.setSubmissionStatus(root.getForm().getStatus());
            pracRoleMapping.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
            pracRoleMapping.setSubmissionFormName(root.getForm().getFormName());
            List<PractitionerRoleMappingData> pracRoleMappingData = new ArrayList<>();
            for (RoleMappings mappings : root.getMappings()) {
                PractitionerRoleMappingData data = new PractitionerRoleMappingData();
                data.setSubmissionId(root.getForm().getSubmissionId());
                data.setPracRoleRecordId(java.util.UUID.randomUUID().toString());
                data.setPractitionerRole(mappings.getPractitionerRole());
                data.setPositionType(mappings.getPositionType());
                data.setResourceCategory(mappings.getResourceCategory());
                pracRoleMappingData.add(data);
            }
            pracRoleMapping.setPractitionerRoleMappingData(pracRoleMappingData);

            parsedPracRoleMappings.add(pracRoleMapping);
        }
        return parsedPracRoleMappings;
    }
}
