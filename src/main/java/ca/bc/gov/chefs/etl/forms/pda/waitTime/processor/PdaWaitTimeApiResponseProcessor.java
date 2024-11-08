package ca.bc.gov.chefs.etl.forms.pda.waitTime.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.Exchange;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PDAConstants;
import ca.bc.gov.chefs.etl.core.json.Form;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pda.waitTime.json.Root;
import ca.bc.gov.chefs.etl.forms.pda.waitTime.json.SubmissionData;
import ca.bc.gov.chefs.etl.forms.pda.waitTime.model.PdaWaitTimeData;
import ca.bc.gov.chefs.etl.forms.pda.waitTime.model.PdaWaitTimeSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PdaWaitTimeApiResponseProcessor extends BaseApiResponseProcessor {
    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        payload = JsonUtil.normalizeEmptyStringArrays(payload);
        payload = JsonUtil.fixUnicodeCharacters(payload);

        ObjectMapper mapper = new ObjectMapper();
        List<Root> waitTimeModels = mapper.readValue(payload, new TypeReference<List<Root>>() {
        });
        List<PdaWaitTimeSubmission> waitTimeSubmissions = parseWaitTimeRequest(waitTimeModels);

        validateRecordCount(waitTimeModels, waitTimeSubmissions);

        List<IModel> iModels = (List<IModel>) (List<?>) waitTimeSubmissions;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map, PDAConstants.PDA_WAIT_TIME_DIR, isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<PdaWaitTimeSubmission> parseWaitTimeRequest(List<Root> waitTimePayloads) {
        List<PdaWaitTimeSubmission> waitTimeSubmissions = new ArrayList<>();
        for (Root root : waitTimePayloads) {
            PdaWaitTimeSubmission waitTimeSubmission = new PdaWaitTimeSubmission();

            Form form = root.getForm();
            waitTimeSubmission.setSubmissionId(UUID.randomUUID().toString());
            waitTimeSubmission.setCreatedAt(CSVUtil.formatDate(form.getCreatedAt()));
            waitTimeSubmission.setLateEntry(root.getLateEntry());
            waitTimeSubmission.setSubmitterFullName(form.getFullName());
            waitTimeSubmission.setSubmitterUserName(form.getUsername());
            waitTimeSubmission.setSubmitterEmail(form.getEmail());
            waitTimeSubmission.setSubmissionStatus(form.getStatus());
            waitTimeSubmission.setSubmissionVersion(Integer.toString(form.getVersion()));
            waitTimeSubmission.setSubmissionFormName(form.getFormName());
            waitTimeSubmission.setPeriod(root.getPeriod());
            waitTimeSubmission.setFacility(root.getFacility());
            waitTimeSubmission.setFiscalYear(root.getFiscalYear());

            List<PdaWaitTimeData> pdaWaitTimeDataList = new ArrayList<>();

            for (SubmissionData submissionData : root.getSubmission()) {
                PdaWaitTimeData pdaWaitTimeData = new PdaWaitTimeData();
                pdaWaitTimeData.setSubmissionId(waitTimeSubmission.getSubmissionId());
                pdaWaitTimeData.setPdaWaitTimeDataId(UUID.randomUUID().toString());
                pdaWaitTimeData.setHealthAuthority(submissionData.getHealthAuthority());
                pdaWaitTimeData.setFacility(root.getFacility());
                pdaWaitTimeData.setRegion(submissionData.getRegion());
                pdaWaitTimeData.setPriority(submissionData.getPriority());
                pdaWaitTimeData.setPatientRef(submissionData.getPatientRef());
                pdaWaitTimeData.setSleepIssue(submissionData.getSleepIssue());
                pdaWaitTimeData.setReferralDate(CSVUtil.formatDate(submissionData.getReferralDate()));
                pdaWaitTimeData.setLevel1StudyDate(CSVUtil.formatDate(submissionData.getLevel1StudyDate()));
                pdaWaitTimeData.setSpecialistConsultDate(CSVUtil.formatDate(submissionData.getSpecialistConsultDate()));
                pdaWaitTimeData.setConsultToStudyWaitTime(submissionData.getConsultToStudyWait2());
                pdaWaitTimeData.setReferralToConsultWaitTime(submissionData.getReferralToConsultWait1());
                pdaWaitTimeData.setTotalWaitTime(submissionData.getTotalWaitTime());
                pdaWaitTimeData.setSelectComment(submissionData.getSelectComment());
                pdaWaitTimeData
                        .setOtherComment(CSVUtil.replaceCarriageReturnLineFeed(submissionData.getOtherComment()));
                pdaWaitTimeDataList.add(pdaWaitTimeData);
            }

            waitTimeSubmission.setPdaWaitTimeData(pdaWaitTimeDataList);

            waitTimeSubmissions.add(waitTimeSubmission);
        }
        return waitTimeSubmissions;
    }
}
