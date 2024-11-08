package ca.bc.gov.chefs.etl.forms.pda.facilityMapping.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PDAConstants;
import ca.bc.gov.chefs.etl.core.json.Form;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pda.facilityMapping.json.FacilityMapping;
import ca.bc.gov.chefs.etl.forms.pda.facilityMapping.model.PdaFacilityMappingData;
import ca.bc.gov.chefs.etl.forms.pda.facilityMapping.model.PdaFacilityMappingSubmission;
import ca.bc.gov.chefs.etl.forms.pda.facilityMapping.json.Root;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PdaFacilityMappingApiResponseProcessor extends BaseApiResponseProcessor {
    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        payload = JsonUtil.normalizeEmptyStringArrays(payload);
        payload = JsonUtil.fixUnicodeCharacters(payload);

        ObjectMapper mapper = new ObjectMapper();
        List<Root> facilityMappingModels = mapper.readValue(payload, new TypeReference<List<Root>>() {
        });
        List<PdaFacilityMappingSubmission> facilityMappingSubmissions = parseFacilityMappingRequest(
                facilityMappingModels);

        validateRecordCount(facilityMappingModels, facilityMappingSubmissions);

        List<IModel> iModels = (List<IModel>) (List<?>) facilityMappingSubmissions;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PDAConstants.PDA_FACILITY_MAPPING_DIR,
                isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<PdaFacilityMappingSubmission> parseFacilityMappingRequest(List<Root> facilityMappingPayloads) {
        List<PdaFacilityMappingSubmission> facilityMappingSubmissions = new ArrayList<>();
        for (Root root : facilityMappingPayloads) {
            PdaFacilityMappingSubmission facilityMappingSubmission = new PdaFacilityMappingSubmission();

            Form form = root.getForm();
            facilityMappingSubmission.setSubmissionId(UUID.randomUUID().toString());
            facilityMappingSubmission.setCreatedAt(CSVUtil.formatDate(form.getCreatedAt()));
            facilityMappingSubmission.setLateEntry(root.getLateEntry());
            facilityMappingSubmission.setSubmitterFullName(form.getFullName());
            facilityMappingSubmission.setSubmitterUserName(form.getUsername());
            facilityMappingSubmission.setSubmitterEmail(form.getEmail());
            facilityMappingSubmission.setSubmissionStatus(form.getStatus());
            facilityMappingSubmission.setSubmissionVersion(Integer.toString(form.getVersion()));
            facilityMappingSubmission.setSubmissionFormName(form.getFormName());

            List<PdaFacilityMappingData> pdaFacilityMappingData = new ArrayList<>();
            for (FacilityMapping facilityMapping : root.getFacilityMapping()) {
                PdaFacilityMappingData data = new PdaFacilityMappingData();
                data.setSubmissionId(facilityMappingSubmission.getSubmissionId());
                data.setPdaFacilityMappingDataId(UUID.randomUUID().toString());
                data.setFacilityName(facilityMapping.getFacilityValue());
                data.setFacilityId(facilityMapping.getFacilityId());
                pdaFacilityMappingData.add(data);
            }
            facilityMappingSubmission.setPdaFacilityMappingData(pdaFacilityMappingData);
            facilityMappingSubmissions.add(facilityMappingSubmission);
        }
        return facilityMappingSubmissions;

    }
}
