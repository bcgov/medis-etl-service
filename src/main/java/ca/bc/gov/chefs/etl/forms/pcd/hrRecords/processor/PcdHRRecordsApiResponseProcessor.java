package ca.bc.gov.chefs.etl.forms.pcd.hrRecords.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.json.ClinicRecordDetails;
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.model.HRRecordsPractitioner;
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.model.HRRecordsSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdHRRecordsApiResponseProcessor extends BaseApiResponseProcessor {
	
	private static final String DEFAULT_EMAIL = "pcdbi-hr-records-data-loader@gov.bc.ca";

    @SuppressWarnings("unchecked")
    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        ObjectMapper mapper = new ObjectMapper();

        payload = JsonUtil.fixPcnNameObject(payload);
        
        List<Root> hrRecordsModels = mapper.readValue(payload, new TypeReference<List<Root>>() {
        });

        List<HRRecordsSubmission> parsedhrRecords = parseHRRecordsRequest(hrRecordsModels);

        validateRecordCount(hrRecordsModels, parsedhrRecords);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedhrRecords;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_HR_RECORDS_DIR, isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<HRRecordsSubmission> parseHRRecordsRequest(List<Root> HRRecordsResponses) {
        List<HRRecordsSubmission> hrRecordsSubmissions = new ArrayList<>();
        for (Root root : HRRecordsResponses) {
            HRRecordsSubmission hrRecordsSubmission = new HRRecordsSubmission();
            hrRecordsSubmission.setSubmissionId(root.getForm().getSubmissionId());
            hrRecordsSubmission.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
            hrRecordsSubmission.setLateEntry(root.getLateEntry());
            hrRecordsSubmission.setSubmitterFullName(root.getForm().fullName);
            hrRecordsSubmission.setSubmitterUserName(root.getForm().username);
            
            // Default the email for bulk uploaded records
            if (StringUtils.isNotBlank(root.getForm().email)) {
            	hrRecordsSubmission.setSubmitterEmail(root.getForm().email);	
            } else {
            	hrRecordsSubmission.setSubmitterEmail(DEFAULT_EMAIL);
            }
            
            hrRecordsSubmission.setSubmissionStatus(root.getForm().status);
            hrRecordsSubmission.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
            hrRecordsSubmission.setSubmissionFormName(root.getForm().getFormName());
            hrRecordsSubmission.setReportingLevel(root.getSelectTheReportingLevel());
            hrRecordsSubmission.setClinicId(root.getClinicID());
            hrRecordsSubmission.setHealthAuthority(root.getHealthAuthority());
            hrRecordsSubmission.setPcnCommunityName(root.getPcnCommunity());
            hrRecordsSubmission.setPcnName(root.getPcnName());
            hrRecordsSubmission.setInitiativeType(root.getInitiativeType());
            hrRecordsSubmission.setClinicName(root.getClinicName());
            hrRecordsSubmission.setClinicType(root.getClinicType());

            List<HRRecordsPractitioner> hrRecordsPractitionerList = new ArrayList<>();
            for (ClinicRecordDetails clinicRecordsDetail : root.getClinicRecordDetails()) {
                HRRecordsPractitioner hrRecordsPractitioner = new HRRecordsPractitioner();
                hrRecordsPractitioner.setSubmissionId(root.getForm().getSubmissionId());
                hrRecordsPractitioner.setHrRecordId(java.util.UUID.randomUUID().toString());
                hrRecordsPractitioner.setPractitionerType(clinicRecordsDetail.getPractitionerType());
                hrRecordsPractitioner.setPractitionerName(clinicRecordsDetail.getPractitionerName());
                hrRecordsPractitioner.setPractitionerFirstName(clinicRecordsDetail.getPractitionerFirstName());
                hrRecordsPractitioner.setPractitionerLastName(clinicRecordsDetail.getPractitionerLastName());
                hrRecordsPractitioner.setPractitionerRole(clinicRecordsDetail.getPractitionerRole());
                hrRecordsPractitioner.setPractitionerBillingNumber(clinicRecordsDetail.getPractitionerBillingNumber());
                hrRecordsPractitioner.setPractitionerBillingNumberNotAvailable(
                        clinicRecordsDetail.getPractitionerBillingNumberNotAvailable());
                hrRecordsPractitioner.setSpecialty(clinicRecordsDetail.getSpecialty());
                hrRecordsPractitioner.setOtherSpecialty(clinicRecordsDetail.getOtherSpecialty());
                hrRecordsPractitioner.setGroupRole(clinicRecordsDetail.getGroupRole());
                hrRecordsPractitioner.setAdditionalGroupDetails(clinicRecordsDetail.getAdditionalGroupDetails());
                hrRecordsPractitioner.setDuration(clinicRecordsDetail.getDuration());
                hrRecordsPractitioner.setFteEquivalent(clinicRecordsDetail.getFteEquivalent());
                hrRecordsPractitioner.setPaymentModality(clinicRecordsDetail.getPaymentModality());
                hrRecordsPractitioner.setOtherPaymentModality(clinicRecordsDetail.getOtherPaymentModality());
                hrRecordsPractitioner.setDateHired(CSVUtil.formatDate(clinicRecordsDetail.getDateHired()));
                hrRecordsPractitioner.setFiscalYear(clinicRecordsDetail.getFiscalYear());
                hrRecordsPractitioner.setPeriod(clinicRecordsDetail.getPeriod());
                hrRecordsPractitioner.setEmploymentStatus(clinicRecordsDetail.getEmploymentStatus());
                hrRecordsPractitioner.setDateEmploymentStatusChanged(
                        CSVUtil.formatDate(clinicRecordsDetail.getDateEmploymentStatusChanged()));
                hrRecordsPractitioner
                        .setRecordCreationDate(CSVUtil.formatDate(clinicRecordsDetail.getRecordCreatedDate()));
                hrRecordsPractitioner.setNotes(clinicRecordsDetail.getNotes());
                hrRecordsPractitioner.setLegacyWebformId(clinicRecordsDetail.getLegacyWebformId());
                hrRecordsPractitionerList.add(hrRecordsPractitioner);
            }
            hrRecordsSubmission.setHrRecordsPractitioner(hrRecordsPractitionerList);
            hrRecordsSubmissions.add(hrRecordsSubmission);
        }
        return hrRecordsSubmissions;
    }

}
