package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.processor;

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
import ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.model.PCPSUpccSubmission;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.model.PCPSUpccSubmissionData;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdUpccPCPSApiResponseProcessor extends BaseApiResponseProcessor {

    @SuppressWarnings("unchecked")
    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Root> pcpsModels = mapper.readValue(payload, new TypeReference<List<Root>>() {
        });
        List<PCPSUpccSubmission> parsedUpccPCPS = parsePCPSRequest(pcpsModels);

        validateRecordCount(pcpsModels, parsedUpccPCPS);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedUpccPCPS;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_UPCC_PCPS_DIR,
                isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private Boolean isPeriodEmpty(Object o, Integer index)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
            SecurityException {
        return JsonUtil.getPeriodicField(o, "uniquePatients", index) == null
                && JsonUtil.getPeriodicField(o, "uniquePatientsSinceOpening", index) == null
                && JsonUtil.getPeriodicField(o, "attachedToTheClinic", index) == null
                && JsonUtil.getPeriodicField(o, "attachedNotToTheClinic", index) == null
                && JsonUtil.getPeriodicField(o, "unattached", index) == null
                && JsonUtil.getPeriodicField(o, "deliveredVirtuallyPrac", index) == null
                && JsonUtil.getPeriodicField(o, "duringBusinessHoursPrac", index) == null
                && JsonUtil.getPeriodicField(o, "outsideBusinessHoursPrac", index) == null
                && JsonUtil.getPeriodicField(o, "deliveredVirtuallyNonPrac", index) == null
                && JsonUtil.getPeriodicField(o, "duringBusinessHoursNonPrac", index) == null
                && JsonUtil.getPeriodicField(o, "outsideBusinessHoursNonPrac", index) == null;
    }

    private List<PCPSUpccSubmission> parsePCPSRequest(List<Root> pcpsModels)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
            SecurityException {
        List<PCPSUpccSubmission> parsedUpccPCPS = new ArrayList<>();
        for (Root root : pcpsModels) {
            PCPSUpccSubmission pcpsSubmission = new PCPSUpccSubmission();

            pcpsSubmission.setSubmissionId(root.getForm().getSubmissionId());
            pcpsSubmission.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
            pcpsSubmission.setLateEntry(root.getLateEntry());
            pcpsSubmission.setSubmitterFullName(root.getForm().getFullName());
            pcpsSubmission.setSubmitterUserName(root.getForm().getUsername());
            pcpsSubmission.setSubmitterEmail(root.getForm().getEmail());
            pcpsSubmission.setSubmissionStatus(root.getForm().getStatus());
            pcpsSubmission.setSubmissionVersion("" + root.getForm().getVersion());
            pcpsSubmission.setSubmissionFormName(root.getForm().getFormName());
            pcpsSubmission.setUpccName(root.getUpccName());
            pcpsSubmission.setPcnCommunityName(root.getPcnCommunity());
            pcpsSubmission.setHealthAuthority(root.getHealthAuthority());
            pcpsSubmission.setUpccTypeOfCare(root.getUpccTypeOfCare());
            pcpsSubmission.setFiscalYear(root.getFiscalYear());
            pcpsSubmission.setPeriodReported(root.getPeriodReported());
            pcpsSubmission.setReasonForExceptPeriodRep(root.getReasonForExceptionInPeriodReported());
            pcpsSubmission.setNotes(root.getDataSubmission().getNotes());

            List<PCPSUpccSubmissionData> pcpsSubmissionDataList = new ArrayList<>();

            for (Integer i = 1; i <= 13; i++) {
                PCPSUpccSubmissionData pcpsSubmissionData = new PCPSUpccSubmissionData();
                // Object to use for dynamically accessing fields
                Object dataSubmissionObject = root.getDataSubmission();

                // Check if all fields are null then skip the record
                if (isPeriodEmpty(dataSubmissionObject, i)) {
                    continue;
                }

                pcpsSubmissionData.setSubmissionId(root.getForm().getSubmissionId());
                pcpsSubmissionData.setPcPatientServicesRecordId(java.util.UUID.randomUUID().toString());
                pcpsSubmissionData.setPeriodForDataEntry(i.toString());

                if (JsonUtil.getPeriodicField(dataSubmissionObject, "uniquePatients", i) != null) {
                    pcpsSubmissionData
                            .setUniquePatients(JsonUtil.getPeriodicField(dataSubmissionObject, "uniquePatients", i));
                }
                if (JsonUtil.getPeriodicField(dataSubmissionObject, "uniquePatientsSinceOpening", i) != null) {
                    pcpsSubmissionData.setUniquePatientsSinceOpen(
                            JsonUtil.getPeriodicField(dataSubmissionObject, "uniquePatientsSinceOpening", i));
                }
                if (JsonUtil.getPeriodicField(dataSubmissionObject, "attachedToTheClinic", i) != null) {
                    pcpsSubmissionData.setPvAttachedToClinic(
                            JsonUtil.getPeriodicField(dataSubmissionObject, "attachedToTheClinic", i));
                }
                if (JsonUtil.getPeriodicField(dataSubmissionObject, "attachedNotToTheClinic", i) != null) {
                    pcpsSubmissionData.setPvAttachedNotToClinic(
                            JsonUtil.getPeriodicField(dataSubmissionObject, "attachedNotToTheClinic", i));
                }
                if (JsonUtil.getPeriodicField(dataSubmissionObject, "unattached", i) != null) {
                    pcpsSubmissionData.setPvUnattached(
                            JsonUtil.getPeriodicField(dataSubmissionObject, "unattached", i));
                }
                if (JsonUtil.getPeriodicField(dataSubmissionObject, "deliveredVirtuallyPrac", i) != null) {
                    pcpsSubmissionData.setPeVirtuallyPrac(
                            JsonUtil.getPeriodicField(dataSubmissionObject, "deliveredVirtuallyPrac", i));
                }
                if (JsonUtil.getPeriodicField(dataSubmissionObject, "duringBusinessHoursPrac", i) != null) {
                    pcpsSubmissionData.setPeDuringBusHrsPrac(
                            JsonUtil.getPeriodicField(dataSubmissionObject, "duringBusinessHoursPrac", i));
                }
                if (JsonUtil.getPeriodicField(dataSubmissionObject, "outsideBusinessHoursPrac", i) != null) {
                    pcpsSubmissionData.setPeOutsideBusHrsPrac(
                            JsonUtil.getPeriodicField(dataSubmissionObject, "outsideBusinessHoursPrac", i));
                }
                if (JsonUtil.getPeriodicField(dataSubmissionObject, "deliveredVirtuallyNonPrac", i) != null) {
                    pcpsSubmissionData.setPeVirtuallyNonPrac(
                            JsonUtil.getPeriodicField(dataSubmissionObject, "deliveredVirtuallyNonPrac", i));
                }
                if (JsonUtil.getPeriodicField(dataSubmissionObject, "duringBusinessHoursNonPrac", i) != null) {
                    pcpsSubmissionData.setPeDuringBusHrsNonPrac(
                            JsonUtil.getPeriodicField(dataSubmissionObject, "duringBusinessHoursNonPrac", i));
                }
                if (JsonUtil.getPeriodicField(dataSubmissionObject, "outsideBusinessHoursNonPrac", i) != null) {
                    pcpsSubmissionData.setPeOutsideBusHrsNonPrac(
                            JsonUtil.getPeriodicField(dataSubmissionObject, "outsideBusinessHoursNonPrac", i));
                }
                pcpsSubmissionDataList.add(pcpsSubmissionData);
            }
            pcpsSubmission.setPcpsSubmissionData(pcpsSubmissionDataList);
            parsedUpccPCPS.add(pcpsSubmission);
        }
        return parsedUpccPCPS;
    }
}
