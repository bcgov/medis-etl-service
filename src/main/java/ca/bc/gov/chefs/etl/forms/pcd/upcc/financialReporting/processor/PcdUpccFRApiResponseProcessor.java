package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.processor;

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
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FinancialReportingUpccSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdUpccFRApiResponseProcessor extends BaseApiResponseProcessor{

	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> upccFRModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<FinancialReportingUpccSubmission> parsedUpccFR = parseUpccFRRequest(upccFRModels);
		
		validateRecordCount(upccFRModels, parsedUpccFR);
		
		List<IModel> iModels = (List<IModel>) (List<?>) parsedUpccFR;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_UPCC_FR_DIR, isHeaderAdded);

		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setFiles(filesGenerated);
		exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
    
    private List<FinancialReportingUpccSubmission> parseUpccFRRequest(List<Root> upccFRPayloads){
        List<FinancialReportingUpccSubmission> parsedUpccFR = new ArrayList<>();
        for(Root root : upccFRPayloads){
            FinancialReportingUpccSubmission financialReportingUpccSubmission = new FinancialReportingUpccSubmission();
            List<FRUpccFinancialData> upccFinancialData = new ArrayList<>();

            /** mapping FinancialReprotingUPCCSubmission */
            financialReportingUpccSubmission.setSubmissionId(root.getForm().getSubmissionId());
            financialReportingUpccSubmission.setCreatedAt(root.getForm().getCreatedAt());
            financialReportingUpccSubmission.setLateEntry(root.getLateEntry());
            financialReportingUpccSubmission.setSubmitterFullName(root.getForm().getFullName());
            financialReportingUpccSubmission.setSubmitterUserName(root.getForm().getUsername());
            financialReportingUpccSubmission.setSubmitterEmail(root.getForm().getEmail());
            financialReportingUpccSubmission.setSubmissionStatus(root.getForm().getStatus());
            financialReportingUpccSubmission.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
            financialReportingUpccSubmission.setSubmissionFormName(root.getForm().getFormName());
            financialReportingUpccSubmission.setHealthAuthority(root.getHealthAuthority());
            financialReportingUpccSubmission.setCommunityName(root.getCommunityName());
            financialReportingUpccSubmission.setUppcName(root.getUpccName());
            financialReportingUpccSubmission.setFiscalYear(root.getFiscalYear());
            financialReportingUpccSubmission.setInterimReported(root.getPeriodReported());
            financialReportingUpccSubmission.setReasonForExceptionInPeriodReported(root.getReasonForExceptionInPeriodReported());
            financialReportingUpccSubmission.setAdditionalNotes(root.getFinancialData().getAdditionalNotes());

            /** mapping FRUpccFinancialData */

            financialReportingUpccSubmission.setFrUpccFinancialData(upccFinancialData);
        }

        return parsedUpccFR;
    }
}
