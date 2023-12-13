package ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.processor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.eclipse.jetty.server.RequestLog.Collection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.json.Root;
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.model.ChangeRequestFileUpload;
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.model.DecisionLogComments;
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.model.DecisionLogInitiatives;
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.model.DecisionLogSubmissions;
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.model.PCNNames;
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.model.PrimaryCareInitiatives;
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.model.SubmissionStatusHistory;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.CommonUtils;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdDecisionLogApiResponseProcessor implements Processor {

	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		payload = JsonUtil.normalizeEmptyStringArrays(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> decisionLogModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<DecisionLogSubmissions> parsedDecisionLog = parseDecisionLogRequest(decisionLogModels);
		List<IModel> iModels = (List<IModel>) (List<?>) parsedDecisionLog;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map,Constants.PCD_DECISION_LOG_DIR, isHeaderAdded);

		// TODO remove successReponse or uncomment
		// SuccessResponse successResponse = new SuccessResponse();
		// successResponse.setFiles(filesGenerated);
		// exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
		
	private List<DecisionLogSubmissions> parseDecisionLogRequest(List<Root> decisionLogPayloads) {
		List<DecisionLogSubmissions> decisionLogSubmissions = new ArrayList<>();
		for (Root root : decisionLogPayloads) {
			DecisionLogSubmissions decisionLogSubmission = new DecisionLogSubmissions();
			List<ChangeRequestFileUpload> changeRequestFileUpload = new ArrayList<>();
			List<DecisionLogComments> decisionLogComments = new ArrayList<>();
			List<DecisionLogInitiatives> decisionLogInitiatives = new ArrayList<>();
			List<PCNNames> PCNNames = new ArrayList<>();
			List<PrimaryCareInitiatives> primaryCareInitiatives = new ArrayList<>();
			List<SubmissionStatusHistory> SubmissionStatusHistory = new ArrayList<>();

			//Mapping decisionLogSubmission
			decisionLogSubmission.setConfirmationId(root.getForm().getConfirmationId());
			decisionLogSubmission.setCreatedAt(root.getForm().getCreatedAt());
			decisionLogSubmission.setSubmitterFullName(root.getForm().getFullName());
			decisionLogSubmission.setSubmitterUserName(root.getForm().getUsername());
			decisionLogSubmission.setSubmitterEmail(root.getForm().getEmail());
			decisionLogSubmission.setSubmissionStatus(root.getForm().getStatus());
			decisionLogSubmission.setSubmissionversion(Integer.toString(root.getForm().getVersion()));
			decisionLogSubmission.setSubmissionformName(root.getForm().getFormName());
			decisionLogSubmission.setHealthAuthority(root.getHealthAuthority());
			decisionLogSubmission.setCommunityName(root.getCommunityName());
			decisionLogSubmission.setTypeOfInitiative(root.getTypeOfInitiative());
			decisionLogSubmission.setRequestNumber(root.getRequestNumber());
			decisionLogSubmission.setSubmittedDate(root.getSubmittedDate());
			decisionLogSubmission.setDescription(root.getDescription());
			decisionLogSubmission.setRequestCategory(root.getRequestCategory());
			decisionLogSubmission.setRequestStatus(root.getRequestStatus());
			decisionLogSubmission.setRecommendedDocumentationType(root.getRecommendedDocumentationType());
			decisionLogSubmission.setOtherDocuments(null);
			decisionLogSubmission.setDateDecisionMade(null);
			decisionLogSubmission.setCommentsRecommendations(null);
			decisionLogSubmission.setFinalDecisionComments(null);
			decisionLogSubmission.setDecisionMadeBy(null);
			decisionLogSubmission.setFinalDecision(null);
			decisionLogSubmission.setFinalDocumentsReceived(null);
			decisionLogSubmission.setPrecedentSetting(null);
			decisionLogSubmission.setUpdatedApprovalTracker(null);
			decisionLogSubmission.setUpdatedFinancialReport(null);
			decisionLogSubmission.setNotAllPcns(null);

			decisionLogSubmission.setChangeRequestFileUpload(changeRequestFileUpload);
			decisionLogSubmission.setDecisionLogComments(decisionLogComments);
			decisionLogSubmission.setDecisionLogInitiatives(decisionLogInitiatives);
			decisionLogSubmission.setPCNNames(PCNNames);
			decisionLogSubmission.setPrimaryCareInitiatives(primaryCareInitiatives);
			decisionLogSubmission.setSubmissionStatusHistory(SubmissionStatusHistory);
			decisionLogSubmissions.add(decisionLogSubmission);
		}

		return decisionLogSubmissions;
	}
}
