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
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_UPCC_PCPS_DIR, isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private Object getPeriodicField(Object o, String name, String index)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        return o.getClass().getDeclaredField(name + "P" + index).get(o);
    }

    private Boolean isPeriodEmpty(Object o, String index)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        return getPeriodicField(o, "uniquePatients", index.toString()) == null
                && getPeriodicField(o, "uniquePatientsSinceOpening", index.toString()) == null
                && getPeriodicField(o, "attachedToTheClinic", index.toString()) == null
                && getPeriodicField(o, "attachedNotToTheClinic", index.toString()) == null
                && getPeriodicField(o, "unattached", index.toString()) == null
                && getPeriodicField(o, "deliveredVirtuallyPrac", index.toString()) == null
                && getPeriodicField(o, "duringBusinessHoursPrac", index.toString()) == null
                && getPeriodicField(o, "outsideBusinessHoursPrac", index.toString()) == null
                && getPeriodicField(o, "deliveredVirtuallyNonPrac", index.toString()) == null
                && getPeriodicField(o, "duringBusinessHoursNonPrac", index.toString()) == null
                && getPeriodicField(o, "outsideBusinessHoursNonPrac", index.toString()) == null;
    }

    private List<PCPSUpccSubmission> parsePCPSRequest(List<Root> pcpsModels)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
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
                if (isPeriodEmpty(dataSubmissionObject, i.toString())) {
                    continue;
                }

                pcpsSubmissionData.setSubmissionId(root.getForm().getSubmissionId());
                pcpsSubmissionData.setPcPatientServicesRecordId(java.util.UUID.randomUUID().toString());
                pcpsSubmissionData.setPeriodForDataEntry(i.toString());

                if (getPeriodicField(dataSubmissionObject, "uniquePatients", i.toString()) != null) {
                    pcpsSubmissionData
                            .setUniquePatients(
                                    getPeriodicField(dataSubmissionObject, "uniquePatients", i.toString()).toString());
                }
                if (getPeriodicField(dataSubmissionObject, "uniquePatientsSinceOpening", i.toString()) != null) {
                    pcpsSubmissionData
                            .setUniquePatientsSinceOpen(
                                    getPeriodicField(dataSubmissionObject, "uniquePatientsSinceOpening", i.toString())
                                            .toString());
                }
                if (getPeriodicField(dataSubmissionObject, "attachedToTheClinic", i.toString()) != null) {
                    pcpsSubmissionData
                            .setPvAttachedToClinic(
                                    getPeriodicField(dataSubmissionObject, "attachedToTheClinic", i.toString())
                                            .toString());
                }
                if (getPeriodicField(dataSubmissionObject, "attachedNotToTheClinic", i.toString()) != null) {
                    pcpsSubmissionData
                            .setPvAttachedNotToClinic(
                                    getPeriodicField(dataSubmissionObject, "attachedNotToTheClinic", i.toString())
                                            .toString());
                }
                if (getPeriodicField(dataSubmissionObject, "unattached", i.toString()) != null) {
                    pcpsSubmissionData.setPvUnattached(
                            getPeriodicField(dataSubmissionObject, "unattached", i.toString()).toString());
                }
                if (getPeriodicField(dataSubmissionObject, "deliveredVirtuallyPrac", i.toString()) != null) {
                    pcpsSubmissionData
                            .setPeVirtuallyPrac(
                                    getPeriodicField(dataSubmissionObject, "deliveredVirtuallyPrac", i.toString())
                                            .toString());
                }
                if (getPeriodicField(dataSubmissionObject, "duringBusinessHoursPrac", i.toString()) != null) {
                    pcpsSubmissionData
                            .setPeDuringBusHrsPrac(
                                    getPeriodicField(dataSubmissionObject, "duringBusinessHoursPrac", i.toString())
                                            .toString());
                }
                if (getPeriodicField(dataSubmissionObject, "outsideBusinessHoursPrac", i.toString()) != null) {
                    pcpsSubmissionData
                            .setPeOutsideBusHrsPrac(
                                    getPeriodicField(dataSubmissionObject, "outsideBusinessHoursPrac", i.toString())
                                            .toString());
                }
                if (getPeriodicField(dataSubmissionObject, "deliveredVirtuallyNonPrac", i.toString()) != null) {
                    pcpsSubmissionData
                            .setPeVirtuallyNonPrac(
                                    getPeriodicField(dataSubmissionObject, "deliveredVirtuallyNonPrac", i.toString())
                                            .toString());
                }
                if (getPeriodicField(dataSubmissionObject, "duringBusinessHoursNonPrac", i.toString()) != null) {
                    pcpsSubmissionData
                            .setPeDuringBusHrsNonPrac(
                                    getPeriodicField(dataSubmissionObject, "duringBusinessHoursNonPrac", i.toString())
                                            .toString());
                }
                if (getPeriodicField(dataSubmissionObject, "outsideBusinessHoursNonPrac", i.toString()) != null) {
                    pcpsSubmissionData
                            .setPeOutsideBusHrsNonPrac(
                                    getPeriodicField(dataSubmissionObject, "outsideBusinessHoursNonPrac", i.toString())
                                            .toString());
                }
                pcpsSubmissionDataList.add(pcpsSubmissionData);
            }
            pcpsSubmission.setPcpsSubmissionData(pcpsSubmissionDataList);
            parsedUpccPCPS.add(pcpsSubmission);
        }
        return parsedUpccPCPS;
    }
}
