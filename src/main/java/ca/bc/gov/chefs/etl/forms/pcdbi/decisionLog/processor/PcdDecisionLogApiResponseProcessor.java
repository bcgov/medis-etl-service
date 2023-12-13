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
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.json.ChangeRequestFileUploadData;
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.json.Comments;
import ca.bc.gov.chefs.etl.forms.pcdbi.decisionLog.json.PcnNameWithType;
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
			//List<SubmissionStatusHistory> SubmissionStatusHistory = new ArrayList<>();

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
			decisionLogSubmission.setOtherDocuments(root.getOtherDocuments());
			decisionLogSubmission.setDateDecisionMade(root.getDateDecisionMade());
			decisionLogSubmission.setCommentsRecommendations(root.getCommentsRecommendations());
			decisionLogSubmission.setFinalDecisionComments(root.getFinalDecisionComments());
			decisionLogSubmission.setDecisionMadeBy(root.getDecisionMadeBy());
			decisionLogSubmission.setFinalDecision(root.getFinalDecision());
			decisionLogSubmission.setFinalDocumentsReceived(root.getFinalDocumentsReceived());
			decisionLogSubmission.setPrecedentSetting(root.getPrecedentSetting());
			decisionLogSubmission.setUpdatedApprovalTracker(root.getUpdatedApprovalTracker());
			decisionLogSubmission.setUpdatedFinancialReport(root.getUpdatedFinancialReport());
			decisionLogSubmission.setNotAllPcns(root.getNotAllPcns());

			//mapping changeRequestFileUpload
			for(ChangeRequestFileUploadData changeRequestFileUploadData : root.getChangeRequestFileUpload()){
				ChangeRequestFileUpload changeRequestFileUploadElement= new ChangeRequestFileUpload();
				changeRequestFileUploadElement.setConfirmationId(root.getForm().getConfirmationId());
				changeRequestFileUploadElement.setId(changeRequestFileUploadData.getId());
				changeRequestFileUploadElement.setUrl(changeRequestFileUploadData.getUrl());
				changeRequestFileUploadElement.setSize(changeRequestFileUploadData.getSize());
				changeRequestFileUploadElement.setStorage(changeRequestFileUploadData.getStorage());
				changeRequestFileUploadElement.setOriginalName(changeRequestFileUploadData.getOriginalName());

				Collections.addAll(changeRequestFileUpload, changeRequestFileUploadElement);
			}

			//mapping DecisionLogComments
			if(root.getComments() != null){
				for(Comments comment : root.getComments()){
					DecisionLogComments newComment = new DecisionLogComments();
					newComment.setConfirmationId(root.getForm().getConfirmationId());
					newComment.setComment(comment.getComment());
					newComment.setCommentDate(comment.getCommentDate());
	
					Collections.addAll(decisionLogComments, newComment);
				}
			}

			//mapping DecisionLogInitiatives
			//mapping PrimaryCareInitiatives
			switch(root.getTypeOfInitiative()){
				case "PCN":
				for(String name : root.getPcnNames()){
					Collections.addAll(decisionLogInitiatives,
					mapDecisionLogInitiative(root.getForm().getConfirmationId(), name, root.getTypeOfInitiative()));
					Collections.addAll(primaryCareInitiatives, 
					mapPrimaryCareInitiative(name, root.getTypeOfInitiative(), root.getPcnName()));
				}
				break;
				case "UPCC":
				for(String name : root.getUpccName()){
					Collections.addAll(decisionLogInitiatives,
					mapDecisionLogInitiative(root.getForm().getConfirmationId(), name, root.getTypeOfInitiative()));
					Collections.addAll(primaryCareInitiatives, 
					mapPrimaryCareInitiative(name, root.getTypeOfInitiative(), root.getPcnName()));
				}
				break;
				case "NPPCC":
				for(String name : root.getNppccName()){
					Collections.addAll(decisionLogInitiatives,
					mapDecisionLogInitiative(root.getForm().getConfirmationId(), name, root.getTypeOfInitiative()));
					Collections.addAll(primaryCareInitiatives, 
					mapPrimaryCareInitiative(name, root.getTypeOfInitiative(), root.getPcnName()));
				}
				break;
				case "CHC":
				for(String name : root.getChcName()){
					Collections.addAll(decisionLogInitiatives,
					mapDecisionLogInitiative(root.getForm().getConfirmationId(), name, root.getTypeOfInitiative()));
					Collections.addAll(primaryCareInitiatives, 
					mapPrimaryCareInitiative(name, root.getTypeOfInitiative(), root.getPcnName()));
				}
				break;
				case "FNPCC":
				for(String name : root.getFnpccName()){
					Collections.addAll(decisionLogInitiatives,
					mapDecisionLogInitiative(root.getForm().getConfirmationId(), name, root.getTypeOfInitiative()));
					Collections.addAll(primaryCareInitiatives, 
					mapPrimaryCareInitiative(name, root.getTypeOfInitiative(), root.getPcnName()));
				}
				break;
				default:
					System.out.println("Type of Initiative unrecognised");
			}

			//mapping PCNNAMES
			if(root.getPcnNamesWithType() != null){
				for(PcnNameWithType pcnName : root.getPcnNamesWithType()){
					PCNNames pcnnames = new PCNNames();
					pcnnames.setConfirmationId(root.getForm().getConfirmationId());
					pcnnames.setPcnName(pcnName.name);
					pcnnames.setType(pcnName.type);
		
					Collections.addAll(PCNNames, pcnnames);
				}
			}

			//mapping SubmissionStatusHistory --- table is to be droped
			// SubmissionStatusHistory subStatusHistory = new SubmissionStatusHistory();
			// subStatusHistory.setConfirmationId(root.getForm().getConfirmationId());
			// subStatusHistory.setDateStatusChanged(root.getForm().getUpdatedAt());
			// subStatusHistory.setAssignee(null);
			// subStatusHistory.setUpdatedBy(null);

			// Collections.addAll(SubmissionStatusHistory, subStatusHistory);

			decisionLogSubmission.setChangeRequestFileUpload(changeRequestFileUpload);
			decisionLogSubmission.setDecisionLogComments(decisionLogComments);
			decisionLogSubmission.setDecisionLogInitiatives(decisionLogInitiatives);
			decisionLogSubmission.setPCNNames(PCNNames);
			decisionLogSubmission.setPrimaryCareInitiatives(primaryCareInitiatives);
			// decisionLogSubmission.setSubmissionStatusHistory(SubmissionStatusHistory);
			decisionLogSubmissions.add(decisionLogSubmission);
		}

		return decisionLogSubmissions;
	}

	private DecisionLogInitiatives mapDecisionLogInitiative(String confirmationId, String name, String type){
		DecisionLogInitiatives decisionLogInitiative = new DecisionLogInitiatives();
		decisionLogInitiative.setConfirmationId(confirmationId);
		decisionLogInitiative.setInitiativeName(name);
		decisionLogInitiative.setInitiativeType(type);

		return decisionLogInitiative;
	}

	private PrimaryCareInitiatives mapPrimaryCareInitiative(String name, String typeofInitiative, String pcnName){
		PrimaryCareInitiatives primaryCareInitiative = new PrimaryCareInitiatives();
		primaryCareInitiative.setInitiativeName(name);
		primaryCareInitiative.setInitiativeType(typeofInitiative);
		primaryCareInitiative.setPcnName(pcnName);
		// primaryCareInitiative.setTypeOfCare(typeofCare);

		return primaryCareInitiative;
	}
}
