package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.processor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.json.Form;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.json.ChangeRequestFileUploadData;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.json.Comments;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.json.PcnNameWithType;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.model.ChangeRequestFileUpload;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.model.DecisionLogComments;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.model.DecisionLogInitiatives;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.model.DecisionLogSubmissions;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.model.PCNNames;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdDecisionLogApiResponseProcessor extends BaseApiResponseProcessor {

	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		payload = JsonUtil.normalizeEmptyStringArrays(payload);
		payload = JsonUtil.fixPcnName(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> decisionLogModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<DecisionLogSubmissions> parsedDecisionLog = parseDecisionLogRequest(decisionLogModels);
		
		validateRecordCount(decisionLogModels, parsedDecisionLog);
		
		List<IModel> iModels = (List<IModel>) (List<?>) parsedDecisionLog;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_DECISION_LOG_DIR, isHeaderAdded);

		 SuccessResponse successResponse = new SuccessResponse();
		 successResponse.setFiles(filesGenerated);
		 exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
		
	private List<DecisionLogSubmissions> parseDecisionLogRequest(List<Root> decisionLogPayloads) {
		List<DecisionLogSubmissions> decisionLogSubmissions = new ArrayList<>();
		for (Root root : decisionLogPayloads) {
			DecisionLogSubmissions decisionLogSubmission = new DecisionLogSubmissions();
			List<ChangeRequestFileUpload> changeRequestFileUpload = new ArrayList<>();
			List<DecisionLogComments> decisionLogComments = new ArrayList<>();
			List<DecisionLogInitiatives> decisionLogInitiatives = new ArrayList<>();
			List<PCNNames> PCNNames = new ArrayList<>();

			// Mapping decisionLogSubmission
			Form form = root.getForm();
			decisionLogSubmission.setSubmissionId(form.getSubmissionId());
			decisionLogSubmission.setCreatedAt(CSVUtil.formatDate(form.getCreatedAt()));
			decisionLogSubmission.setSubmitterFullName(form.getFullName());
			decisionLogSubmission.setSubmitterUserName(form.getUsername());
			decisionLogSubmission.setSubmitterEmail(form.getEmail());
			decisionLogSubmission.setSubmissionStatus(form.getStatus());
			decisionLogSubmission.setSubmissionversion(Integer.toString(form.getVersion()));
			decisionLogSubmission.setSubmissionformName(form.getFormName());
			decisionLogSubmission.setLateEntry(root.getLateEntry());
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
			decisionLogSubmission.setCommentsRecommendations(StringUtils.defaultString(root.getCommentsRecommendations(), Boolean.FALSE.toString()));
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
				changeRequestFileUploadElement.setSubmissionId(root.getForm().getSubmissionId());
				changeRequestFileUploadElement.setId(changeRequestFileUploadData.getId());
				changeRequestFileUploadElement.setUrl(changeRequestFileUploadData.getUrl());
				changeRequestFileUploadElement.setSize(changeRequestFileUploadData.getSize());
				changeRequestFileUploadElement.setStorage(changeRequestFileUploadData.getStorage());
				changeRequestFileUploadElement.setOriginalName(changeRequestFileUploadData.getOriginalName());

				Collections.addAll(changeRequestFileUpload, changeRequestFileUploadElement);
			}

			//mapping DecisionLogComments
            if (root.getComments() != null) {
                for (Comments comment : root.getComments()) {
                    // Ignore empty comments
                    if (StringUtils.isBlank(comment.getComment())) {
                        continue;
                    }
                    DecisionLogComments newComment = new DecisionLogComments();
                    newComment.setSubmissionId(root.getForm().getSubmissionId());
                    newComment.setCommentId(UUID.randomUUID().toString());
                    newComment.setComment(comment.getComment());
                    newComment.setCommentDate(comment.getCommentDate());

                    decisionLogComments.add(newComment);
                }
            }

			//mapping DecisionLogInitiatives
			switch(root.getTypeOfInitiative()){
				case "PCN":
				// no records created if initiative is PCN
				break;
				case "UPCC":
				for(String name : root.getUpccName()){
					Collections.addAll(decisionLogInitiatives,
					mapDecisionLogInitiative(root.getForm().getSubmissionId(), name, root.getTypeOfInitiative()));
				}
				break;
				case "NPPCC":
				for(String name : root.getNppccName()){
					Collections.addAll(decisionLogInitiatives,
					mapDecisionLogInitiative(root.getForm().getSubmissionId(), name, root.getTypeOfInitiative()));
				}
				break;
				case "CHC":
				for(String name : root.getChcName()){
					Collections.addAll(decisionLogInitiatives,
					mapDecisionLogInitiative(root.getForm().getSubmissionId(), name, root.getTypeOfInitiative()));
				}
				break;
				case "FNPCC":
				for(String name : root.getFnpccName()){
					Collections.addAll(decisionLogInitiatives,
					mapDecisionLogInitiative(root.getForm().getSubmissionId(), name, root.getTypeOfInitiative()));
				}
				break;
				default:
					System.out.println("Type of Initiative unrecognised: " + root.getTypeOfInitiative());
			}

			//mapping PCNNAMES
			if(root.getTypeOfInitiative().equals("PCN")){
				if(root.getPcnNamesWithType() != null){
					for(PcnNameWithType pcnName : root.getPcnNamesWithType()) {
					    // Ignore empty PcnName values which seems to be a possibility
					    if (StringUtils.isBlank(pcnName.getName())) {
					        continue;
					    }
						PCNNames pcnnames = new PCNNames();
						pcnnames.setSubmissionId(root.getForm().getSubmissionId());
						pcnnames.setPcnName(pcnName.getName());
						pcnnames.setType(pcnName.getType());
						Collections.addAll(PCNNames, pcnnames);
					}
				}		
			} else {
				if(root.getPcnNameWithType() != null){
                    // Ignore empty PcnName values which seems to be a possibility
                    if (StringUtils.isBlank(root.getPcnNameWithType().getName())) {
                        continue;
                    }
					PCNNames pcnname = new PCNNames();
					pcnname.setSubmissionId(root.getForm().getSubmissionId());
					pcnname.setPcnName(root.getPcnNameWithType().getName());
					pcnname.setType(root.getPcnNameWithType().getType());
					Collections.addAll(PCNNames, pcnname);
				}
			}


			decisionLogSubmission.setChangeRequestFileUpload(changeRequestFileUpload);
			decisionLogSubmission.setDecisionLogComments(decisionLogComments);
			decisionLogSubmission.setDecisionLogInitiatives(decisionLogInitiatives);
			decisionLogSubmission.setPCNNames(PCNNames);
			decisionLogSubmissions.add(decisionLogSubmission);
		}

		return decisionLogSubmissions;
	}

	private DecisionLogInitiatives mapDecisionLogInitiative(String submissionId, String name, String type){
		DecisionLogInitiatives decisionLogInitiative = new DecisionLogInitiatives();
		decisionLogInitiative.setSubmissionId(submissionId);
		decisionLogInitiative.setInitiativeName(name);
		decisionLogInitiative.setInitiativeType(type);

		return decisionLogInitiative;
	}

}
