package ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.processor;

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
import ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.model.PCPSChcSubmission;
import ca.bc.gov.chefs.etl.forms.pcd.chc.pcPatientServices.model.PCPSChcSubmissionData;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import static ca.bc.gov.chefs.etl.util.JsonUtil.getPeriodicField;

public class PcdChcPCPSApiResponseProcessor extends BaseApiResponseProcessor {
    @SuppressWarnings("unchecked")
    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Root> pcpsChcModels = mapper.readValue(payload, new TypeReference<List<Root>>() {
        });
        List<PCPSChcSubmission> parsedChcPCPS = parsePCPSRequest(pcpsChcModels);

        validateRecordCount(pcpsChcModels, parsedChcPCPS);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedChcPCPS;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_CHC_PCPS_DIR,
                isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private Boolean isPeriodEmpty(Object o, Integer index)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
            SecurityException {
        return getPeriodicField(o, "uniquePatients", index) == null
                && getPeriodicField(o, "uniquePatientsSinceOpening", index) == null
                && getPeriodicField(o, "attachedToTheClinic", index) == null
                && getPeriodicField(o, "attachedNotToTheClinic", index) == null
                && getPeriodicField(o, "unattached", index) == null
                && getPeriodicField(o, "deliveredVirtuallyPrac", index) == null
                && getPeriodicField(o, "duringBusinessHoursPrac", index) == null
                && getPeriodicField(o, "outsideBusinessHoursPrac", index) == null
                && getPeriodicField(o, "deliveredVirtuallyNonPrac", index) == null
                && getPeriodicField(o, "duringBusinessHoursNonPrac", index) == null
                && getPeriodicField(o, "outsideBusinessHoursNonPrac", index) == null;
    }

    private List<PCPSChcSubmission> parsePCPSRequest(List<Root> pcpsModels)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
            SecurityException {
        List<PCPSChcSubmission> parsedChcPCPS = new ArrayList<>();
        for (Root root : pcpsModels) {
            PCPSChcSubmission pcpsSubmission = new PCPSChcSubmission();

            pcpsSubmission.setSubmissionId(root.getForm().getSubmissionId());
            pcpsSubmission.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
            pcpsSubmission.setLateEntry(root.getLateEntry());
            pcpsSubmission.setSubmitterFullName(root.getForm().getFullName());
            pcpsSubmission.setSubmitterUserName(root.getForm().getUsername());
            pcpsSubmission.setSubmitterEmail(root.getForm().getEmail());
            pcpsSubmission.setSubmissionStatus(root.getForm().getStatus());
            pcpsSubmission.setSubmissionVersion("" + root.getForm().getVersion());
            pcpsSubmission.setSubmissionFormName(root.getForm().getFormName());
            pcpsSubmission.setChcName(root.getChcName());
            pcpsSubmission.setPcnCommunityName(root.getPcnCommunity());
            pcpsSubmission.setHealthAuthority(root.getHealthAuthority());
            pcpsSubmission.setFiscalYear(root.getFiscalYear());
            pcpsSubmission.setPeriodReported(root.getPeriodReported());
            pcpsSubmission.setReasonForExceptPeriodRep(root.getReasonForExceptionInPeriodReported());
            pcpsSubmission.setNotes(root.getDataSubmission().getNotes());
            List<PCPSChcSubmissionData> pcpsSubmissionDataList = new ArrayList<>();

            for (Integer i = 1; i <= 13; i++) {
                PCPSChcSubmissionData pcpsSubmissionData = new PCPSChcSubmissionData();
                // Object to use for dynamically accessing fields
                Object dataSubmissionObject = root.getDataSubmission();

                // Check if all fields are null then skip the record
                if (isPeriodEmpty(dataSubmissionObject, i)) {
                    continue;
                }

                pcpsSubmissionData.setSubmissionId(root.getForm().getSubmissionId());
                pcpsSubmissionData.setPcPatientServicesRecordId(java.util.UUID.randomUUID().toString());
                pcpsSubmissionData.setPeriodForDataEntry(i.toString());

                if (getPeriodicField(dataSubmissionObject, "uniquePatients", i) != null) {
                    pcpsSubmissionData
                            .setUniquePatients(getPeriodicField(dataSubmissionObject, "uniquePatients", i));
                }
                if (getPeriodicField(dataSubmissionObject, "uniquePatientsSinceOpening", i) != null) {
                    pcpsSubmissionData.setUniquePatientsSinceOpen(
                            getPeriodicField(dataSubmissionObject, "uniquePatientsSinceOpening", i));
                }
                if (getPeriodicField(dataSubmissionObject, "attachedToTheClinic", i) != null) {
                    pcpsSubmissionData.setPvAttachedToClinic(
                            getPeriodicField(dataSubmissionObject, "attachedToTheClinic", i));
                }
                if (getPeriodicField(dataSubmissionObject, "attachedNotToTheClinic", i) != null) {
                    pcpsSubmissionData.setPvAttachedNotToClinic(
                            getPeriodicField(dataSubmissionObject, "attachedNotToTheClinic", i));
                }
                if (getPeriodicField(dataSubmissionObject, "unattached", i) != null) {
                    pcpsSubmissionData.setPvUnattached(
                            getPeriodicField(dataSubmissionObject, "unattached", i));
                }
                if (getPeriodicField(dataSubmissionObject, "deliveredVirtuallyPrac", i) != null) {
                    pcpsSubmissionData.setPeVirtuallyPrac(
                            getPeriodicField(dataSubmissionObject, "deliveredVirtuallyPrac", i));
                }
                if (getPeriodicField(dataSubmissionObject, "duringBusinessHoursPrac", i) != null) {
                    pcpsSubmissionData.setPeDuringBusHrsPrac(
                            getPeriodicField(dataSubmissionObject, "duringBusinessHoursPrac", i));
                }
                if (getPeriodicField(dataSubmissionObject, "outsideBusinessHoursPrac", i) != null) {
                    pcpsSubmissionData.setPeOutsideBusHrsPrac(
                            getPeriodicField(dataSubmissionObject, "outsideBusinessHoursPrac", i));
                }
                if (getPeriodicField(dataSubmissionObject, "deliveredVirtuallyNonPrac", i) != null) {
                    pcpsSubmissionData.setPeVirtuallyNonPrac(
                            getPeriodicField(dataSubmissionObject, "deliveredVirtuallyNonPrac", i));
                }
                if (getPeriodicField(dataSubmissionObject, "duringBusinessHoursNonPrac", i) != null) {
                    pcpsSubmissionData.setPeDuringBusHrsNonPrac(
                            getPeriodicField(dataSubmissionObject, "duringBusinessHoursNonPrac", i));
                }
                if (getPeriodicField(dataSubmissionObject, "outsideBusinessHoursNonPrac", i) != null) {
                    pcpsSubmissionData.setPeOutsideBusHrsNonPrac(
                            getPeriodicField(dataSubmissionObject, "outsideBusinessHoursNonPrac", i));
                }
                pcpsSubmissionDataList.add(pcpsSubmissionData);
            }

            pcpsSubmission.setPcpsSubmissionData(pcpsSubmissionDataList);
            parsedChcPCPS.add(pcpsSubmission);
        }
        return parsedChcPCPS;
    }
}
