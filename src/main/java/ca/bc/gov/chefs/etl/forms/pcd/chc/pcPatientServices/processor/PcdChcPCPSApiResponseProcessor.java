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
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdChcPCPSApiResponseProcessor extends BaseApiResponseProcessor {
  @SuppressWarnings("unchecked")
  @Override
  public void process(Exchange exchange) throws Exception {
    String payload = exchange.getIn().getBody(String.class);
    payload = JsonUtil.roundDigitsNumber(payload);
    ObjectMapper mapper = new ObjectMapper();
    List<Root> pcpsChcModels = mapper.readValue(payload, new TypeReference<List<Root>>() {
    });
    List<PCPSChcSubmission> parsedChcPCPS = parsePCPSRequest(pcpsChcModels);

    validateRecordCount(pcpsChcModels, parsedChcPCPS);

    List<IModel> iModels = (List<IModel>) (List<?>) parsedChcPCPS;
    Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

    boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
    List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_CHC_PCPS_DIR, isHeaderAdded);

    SuccessResponse successResponse = new SuccessResponse();
    successResponse.setFiles(filesGenerated);
    exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
  }

  private List<PCPSChcSubmission> parsePCPSRequest(List<Root> pcpsModels)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
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

      for (Integer i = 0; i < 13; i++) {
        PCPSChcSubmissionData pcpsSubmissionData = new PCPSChcSubmissionData();
        Object o = root.getDataSubmission(); // The object you want to inspect
        Class<?> c = o.getClass();

        // Check if all fields are null then skip the record
        if (c.getDeclaredField("uniquePatientsP" + (i + 1)).get(o) == null
            && c.getDeclaredField("uniquePatientsSinceOpeningP" + (i + 1)).get(o) == null
            && c.getDeclaredField("attachedToTheClinicP" + (i + 1)).get(o) == null
            && c.getDeclaredField("attachedNotToTheClinicP" + (i + 1)).get(o) == null
            && c.getDeclaredField("unattachedP" + (i + 1)).get(o) == null
            && c.getDeclaredField("deliveredVirtuallyPracP" + (i + 1)).get(o) == null
            && c.getDeclaredField("duringBusinessHoursPracP" + (i + 1)).get(o) == null
            && c.getDeclaredField("outsideBusinessHoursPracP" + (i + 1)).get(o) == null
            && c.getDeclaredField("deliveredVirtuallyNonPracP" + (i + 1)).get(o) == null
            && c.getDeclaredField("duringBusinessHoursNonPracP" + (i + 1)).get(o) == null
            && c.getDeclaredField("outsideBusinessHoursNonPracP" + (i + 1)).get(o) == null) {
          continue;
        }

        pcpsSubmissionData.setSubmissionId(root.getForm().getSubmissionId());
        pcpsSubmissionData.setPcPatientServicesRecordId(java.util.UUID.randomUUID().toString());
        pcpsSubmissionData.setPeriodForDataEntry("P" + (i + 1));

        if (c.getDeclaredField("uniquePatientsP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData.setUniquePatients(c.getDeclaredField("uniquePatientsP" + (i + 1)).get(o).toString());
        }
        if (c.getDeclaredField("uniquePatientsSinceOpeningP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData
              .setUniquePatientsSinceOpen(
                  c.getDeclaredField("uniquePatientsSinceOpeningP" + (i + 1)).get(o).toString());
        }
        if (c.getDeclaredField("attachedToTheClinicP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData
              .setPvAttachedToClinic(c.getDeclaredField("attachedToTheClinicP" + (i + 1)).get(o).toString());
        }
        if (c.getDeclaredField("attachedNotToTheClinicP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData
              .setPvAttachedNotToClinic(c.getDeclaredField("attachedNotToTheClinicP" + (i + 1)).get(o).toString());
        }
        if (c.getDeclaredField("unattachedP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData.setPvUnattached(c.getDeclaredField("unattachedP" + (i + 1)).get(o).toString());
        }
        if (c.getDeclaredField("deliveredVirtuallyPracP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData
              .setPeVirtuallyPrac(c.getDeclaredField("deliveredVirtuallyPracP" + (i + 1)).get(o).toString());
        }
        if (c.getDeclaredField("duringBusinessHoursPracP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData
              .setPeDuringBusHrsPrac(c.getDeclaredField("duringBusinessHoursPracP" + (i + 1)).get(o).toString());
        }
        if (c.getDeclaredField("outsideBusinessHoursPracP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData
              .setPeOutsideBusHrsPrac(c.getDeclaredField("outsideBusinessHoursPracP" + (i + 1)).get(o).toString());
        }
        if (c.getDeclaredField("deliveredVirtuallyNonPracP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData
              .setPeVirtuallyNonPrac(c.getDeclaredField("deliveredVirtuallyNonPracP" + (i + 1)).get(o).toString());
        }
        if (c.getDeclaredField("duringBusinessHoursNonPracP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData
              .setPeDuringBusHrsNonPrac(c.getDeclaredField("duringBusinessHoursNonPracP" + (i + 1)).get(o).toString());
        }
        if (c.getDeclaredField("outsideBusinessHoursNonPracP" + (i + 1)).get(o) != null) {
          pcpsSubmissionData
              .setPeOutsideBusHrsNonPrac(
                  c.getDeclaredField("outsideBusinessHoursNonPracP" + (i + 1)).get(o).toString());
        }
        pcpsSubmissionDataList.add(pcpsSubmissionData);
      }

      pcpsSubmission.setPcpsSubmissionData(pcpsSubmissionDataList);
      parsedChcPCPS.add(pcpsSubmission);
    }
    return parsedChcPCPS;
  }
}
