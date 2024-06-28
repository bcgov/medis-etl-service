package ca.bc.gov.chefs.etl.forms.pcd.hrRecords.processor;

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
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.json.ClinicRecordsDetails;
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.model.HRRecordsData;
import ca.bc.gov.chefs.etl.forms.pcd.hrRecords.model.HRRecordsSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;

public class PcdHRRecordsApiResponseProcessor extends BaseApiResponseProcessor {

    @SuppressWarnings("unchecked")
    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        ObjectMapper mapper = new ObjectMapper();

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
            hrRecordsSubmission.setSubmitterEmail(root.getForm().email);
            hrRecordsSubmission.setSubmissionStatus(root.getForm().status);
            hrRecordsSubmission.setSubmissionVersion("" + root.getForm().getVersion());
            hrRecordsSubmission.setSubmissionFormName(root.getForm().getFormName());
            hrRecordsSubmission.setReportingLevel(root.getSelectTheReportingLevel());
            hrRecordsSubmission.setClinicId(root.getClinicID());
            hrRecordsSubmission.setHealthAuthority(root.getHealthAuthority());
            hrRecordsSubmission.setPcnCommunityName(root.getPcnCommunity());
            hrRecordsSubmission.setPcnName(root.getPcnName());
            hrRecordsSubmission.setInitiativeType(root.getInitiativeType());
            hrRecordsSubmission.setClinicName(root.getClinicName());
            hrRecordsSubmission.setClinicType(root.getClinicType());

            List<HRRecordsData> hrRecordsDataList = new ArrayList<>();
            for (ClinicRecordsDetails clinicRecordsDetail : root.getClinicRecordDetails()) {
                HRRecordsData hrRecordsData = new HRRecordsData();
                hrRecordsData.setSubmissionId(root.getForm().getSubmissionId());
                hrRecordsData.setHrRecordId(java.util.UUID.randomUUID().toString());
                hrRecordsData.setPractitionerType(clinicRecordsDetail.getPractitionerType());
                hrRecordsData.setPractitionerName(clinicRecordsDetail.getPractitionerName());
                hrRecordsData.setPractitionerFirstName(clinicRecordsDetail.getPractitionerFirstName());
                hrRecordsData.setPractitionerLastName(clinicRecordsDetail.getPractitionerLastName());
                hrRecordsData.setPractitionerRole(clinicRecordsDetail.getPractitionerRole());
                hrRecordsData.setPractitionerBillingNumber(clinicRecordsDetail.getPractitionerBillingNumber());
                hrRecordsData.setPractitionerBillingNumberNotAvailable(
                        clinicRecordsDetail.getPractitionerBillingNumberNotAvailable());
                hrRecordsData.setSpecialty(clinicRecordsDetail.getSpecialty());
                hrRecordsData.setOtherSpecialty(clinicRecordsDetail.getOtherSpecialty());
                hrRecordsData.setGroupRole(clinicRecordsDetail.getGroupRole());
                hrRecordsData.setAdditionalGroupDetails(clinicRecordsDetail.getAdditionalGroupDetails());
                hrRecordsData.setDuration(clinicRecordsDetail.getDuration());
                hrRecordsData.setFteEquivalent(clinicRecordsDetail.getFteEquivalent());
                hrRecordsData.setPaymentModality(clinicRecordsDetail.getPaymentModality());
                hrRecordsData.setDateHired(CSVUtil.formatDate(clinicRecordsDetail.getDateHired()));
                hrRecordsData.setFiscalYear(clinicRecordsDetail.getFiscalYear());
                hrRecordsData.setPeriod(clinicRecordsDetail.getPeriod());
                hrRecordsData.setEmploymentStatus(clinicRecordsDetail.getEmploymentStatus());
                hrRecordsData.setDateEmploymentStatusChanged(
                        CSVUtil.formatDate(clinicRecordsDetail.getDateEmploymentStatusChanged()));
                hrRecordsData.setRecordCreationDate(CSVUtil.formatDate(clinicRecordsDetail.getRecordCreatedDate()));
                hrRecordsData.setNotes(clinicRecordsDetail.getNotes());
                hrRecordsData.setLegacyWebformId(clinicRecordsDetail.getLegacyWebformId());
                hrRecordsDataList.add(hrRecordsData);
            }
            hrRecordsSubmission.setHrRecordsData(hrRecordsDataList);
            hrRecordsSubmissions.add(hrRecordsSubmission);
        }

        return hrRecordsSubmissions;
    }

}
