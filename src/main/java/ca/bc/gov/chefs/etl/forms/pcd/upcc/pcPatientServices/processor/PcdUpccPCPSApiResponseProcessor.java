package ca.bc.gov.chefs.etl.forms.pcd.upcc.pcPatientServices.processor;

import static ca.bc.gov.chefs.etl.constant.PCDConstants.HA_MAPPING_TYPE_UPCC;
import static ca.bc.gov.chefs.etl.util.JsonUtil.getPeriodicField;

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
import ca.bc.gov.chefs.etl.forms.pcd.haMapping.json.HaMapping;
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
        payload = JsonUtil.fixUnicodeCharacters(payload);
        
        ObjectMapper mapper = new ObjectMapper();
        List<Root> pcpsModels = mapper.readValue(payload, new TypeReference<List<Root>>() {});
        
        List<HaMapping> haMappings = (List<HaMapping>)exchange.getProperties().get(Constants.PROPERTY_HA_MAPPING);
        List<PCPSUpccSubmission> parsedUpccPCPS = parsePCPSRequest(pcpsModels, haMappings);

        validateRecordCount(pcpsModels, parsedUpccPCPS);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedUpccPCPS;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated =
                FileUtil.writeToCSVFile(map, PCDConstants.PCD_UPCC_PCPS_DIR, isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private Boolean isPeriodEmpty(Object o, Integer index) throws IllegalArgumentException,
            IllegalAccessException, NoSuchFieldException, SecurityException {
        return getPeriodicField(o, "uniquePatients", index) == null
                && getPeriodicField(o, "uniquePatientsSinceOpening", index) == null
                && getPeriodicField(o, "uniquePatientsWithoutMsp", index) == null
                && getPeriodicField(o, "attachedToTheClinic", index) == null
                && getPeriodicField(o, "attachedNotToTheClinic", index) == null
                && getPeriodicField(o, "unattached", index) == null
                && getPeriodicField(o, "patientEncountersFp", index) == null
                && getPeriodicField(o, "patientEncountersNp", index) == null
                && getPeriodicField(o, "patientEncountersRn", index) == null
                && getPeriodicField(o, "patientEncountersLpn", index) == null
                && getPeriodicField(o, "patientEncountersOther", index) == null
                && getPeriodicField(o, "deliveredVirtually", index) == null
                && getPeriodicField(o, "outsideBusinessHours", index) == null;
    }

    private List<PCPSUpccSubmission> parsePCPSRequest(List<Root> pcpsModels, List<HaMapping> haMappings)
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
            String upccCode = StringUtils.defaultIfBlank(root.getUpccId(), JsonUtil.fixHierarchyCode(haMappings, HA_MAPPING_TYPE_UPCC, root.getUpccName()));
            pcpsSubmission.setUpccCode(upccCode);
            pcpsSubmission.setPcnCommunityName(root.getPcnCommunity());
            pcpsSubmission.setHealthAuthority(root.getHealthAuthority());
            pcpsSubmission.setUpccTypeOfCare(root.getUpccTypeOfCare());
            pcpsSubmission.setFiscalYear(root.getFiscalYear());
            pcpsSubmission.setPeriodReported(root.getPeriodReported());
            pcpsSubmission
                    .setCurrentApprovedFtesFp(root.getDataSubmission().getCurrentApprovedFtEsFp());
            pcpsSubmission
                    .setCurrentApprovedFtesNp(root.getDataSubmission().getCurrentApprovedFtEsNp());
            pcpsSubmission
                    .setCurrentApprovedFtesRn(root.getDataSubmission().getCurrentApprovedFtEsRn());
            pcpsSubmission.setCurrentApprovedFtesLpn(
                    root.getDataSubmission().getCurrentApprovedFtEsLpn());
            pcpsSubmission.setCurrentApprovedFtesOther(
                    root.getDataSubmission().getCurrentApprovedFtEsOther());
            pcpsSubmission.setFtesHiredToDateFp(root.getDataSubmission().getFtesHiredToDateFp());
            pcpsSubmission.setFtesHiredToDateNp(root.getDataSubmission().getFtesHiredToDateNp());
            pcpsSubmission.setFtesHiredToDateRn(root.getDataSubmission().getFtesHiredToDateRn());
            pcpsSubmission.setFtesHiredToDateLpn(root.getDataSubmission().getFtesHiredToDateLpn());
            pcpsSubmission
                    .setFtesHiredToDateOther(root.getDataSubmission().getFtesHiredToDateOther());
            pcpsSubmission
                    .setReasonForExceptPeriodRep(root.getReasonForExceptionInPeriodReported());
            pcpsSubmission.setNotes(CSVUtil
                    .replaceCarriageReturnLineFeed(root.getDataSubmission().getSubmissionNotes()));
            pcpsSubmission.setAccessNotes(CSVUtil
                    .replaceCarriageReturnLineFeed(root.getDataSubmission().getAccessNotes()));
            pcpsSubmission.setPatientVolumesNotes(CSVUtil.replaceCarriageReturnLineFeed(
                    root.getDataSubmission().getPatientVolumesNotes()));
            pcpsSubmission.setTeamBasedCareServiceNotes(CSVUtil.replaceCarriageReturnLineFeed(
                    root.getDataSubmission().getTeamBasedCareServiceNotes()));

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
                pcpsSubmissionData
                        .setPcPatientServicesRecordId(java.util.UUID.randomUUID().toString());
                pcpsSubmissionData.setPeriodForDataEntry(i.toString());

                if (getPeriodicField(dataSubmissionObject, "uniquePatients", i) != null) {
                    pcpsSubmissionData.setUniquePatients(
                            getPeriodicField(dataSubmissionObject, "uniquePatients", i));
                }
                if (getPeriodicField(dataSubmissionObject, "uniquePatientsSinceOpening",
                        i) != null) {
                    pcpsSubmissionData.setUniquePatientsSinceOpen(getPeriodicField(
                            dataSubmissionObject, "uniquePatientsSinceOpening", i));
                }
                if (getPeriodicField(dataSubmissionObject, "uniquePatientsWithoutMsp", i) != null) {
                    pcpsSubmissionData.setUniquePatientsWithoutMsp(
                            getPeriodicField(dataSubmissionObject, "uniquePatientsWithoutMsp", i));
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
                if (getPeriodicField(dataSubmissionObject, "patientEncountersFp", i) != null) {
                    pcpsSubmissionData.setPatientEncFp(
                            getPeriodicField(dataSubmissionObject, "patientEncountersFp", i));
                }
                if (getPeriodicField(dataSubmissionObject, "patientEncountersNp", i) != null) {
                    pcpsSubmissionData.setPatientEncNp(
                            getPeriodicField(dataSubmissionObject, "patientEncountersNp", i));
                }
                if (getPeriodicField(dataSubmissionObject, "patientEncountersRn", i) != null) {
                    pcpsSubmissionData.setPatientEncRn(
                            getPeriodicField(dataSubmissionObject, "patientEncountersRn", i));
                }
                if (getPeriodicField(dataSubmissionObject, "patientEncountersLpn", i) != null) {
                    pcpsSubmissionData.setPatientEncLpn(
                            getPeriodicField(dataSubmissionObject, "patientEncountersLpn", i));
                }
                if (getPeriodicField(dataSubmissionObject, "patientEncountersOther", i) != null) {
                    pcpsSubmissionData.setPatientEncOther(
                            getPeriodicField(dataSubmissionObject, "patientEncountersOther", i));
                }
                if (getPeriodicField(dataSubmissionObject, "deliveredVirtually", i) != null) {
                    pcpsSubmissionData.setPatientEncVirtually(
                            getPeriodicField(dataSubmissionObject, "deliveredVirtually", i));
                }
                if (getPeriodicField(dataSubmissionObject, "outsideBusinessHours", i) != null) {
                    pcpsSubmissionData.setPatientEncOutsideBusHrs(
                            getPeriodicField(dataSubmissionObject, "outsideBusinessHours", i));
                }
                pcpsSubmissionDataList.add(pcpsSubmissionData);
            }
            pcpsSubmission.setPcpsSubmissionData(pcpsSubmissionDataList);
            parsedUpccPCPS.add(pcpsSubmission);
        }
        return parsedUpccPCPS;
    }
}
