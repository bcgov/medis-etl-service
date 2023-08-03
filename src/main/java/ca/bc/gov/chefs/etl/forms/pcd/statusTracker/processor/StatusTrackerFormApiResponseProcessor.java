package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.processor;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.RootIssueAndRisk;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.RootPCNNameWithType;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.IssueAndRisk;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.IssueAndRiskType;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.PCNName;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.StatusTrackerSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class StatusTrackerFormApiResponseProcessor implements Processor {

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);

		ObjectMapper mapper = new ObjectMapper();

		List<Root> statusTrackerModels = mapper.readValue(payload, new TypeReference<List<Root>>() {});
		List<StatusTrackerSubmission> parsedStatusTracker = parseStatusTracker(statusTrackerModels);

		List<IModel> iModels = (List<IModel>) (List<?>) parsedStatusTracker;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map,Constants.PCD_STATUS_TRACKER_DIR, isHeaderAdded);

		 SuccessResponse successResponse = new SuccessResponse();
		 successResponse.setFiles(filesGenerated);
		 exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}

	private List<StatusTrackerSubmission> parseStatusTracker(List<Root> statusTracker) {
		List<StatusTrackerSubmission> statusTrackerParsed = new ArrayList<>();

		for(Root root : statusTracker) {

			StatusTrackerSubmission statusTrackerMainEntity = new StatusTrackerSubmission();
			List<PCNName> pcnNames = new ArrayList<>();
			List<IssueAndRisk> issuesAndRisks = new ArrayList<>();

			// CHEF form data
			statusTrackerMainEntity.setConfirmationId(root.getForm().getConfirmationId());
			statusTrackerMainEntity.setCreatedAt(root.getForm().getCreatedAt());
			statusTrackerMainEntity.setSubmitterFullName(root.getForm().getFullName());
			statusTrackerMainEntity.setSubmitterUserName(root.getForm().getUsername());
			statusTrackerMainEntity.setSubmitterEmail(root.getForm().getEmail());
			statusTrackerMainEntity.setSubmissionStatus(root.getForm().getStatus());

			//Status Tracker data
			statusTrackerMainEntity.setPcnName(root.getPcnName());
			statusTrackerMainEntity.setLateEntry(root.getLateEntry());
			statusTrackerMainEntity.setTypeOfInitiative(root.getTypeOfInitiative());
			statusTrackerMainEntity.setHealthAuthority(root.getHealthAuthority());
			statusTrackerMainEntity.setCommunityName(root.getCommunityName());
			statusTrackerMainEntity.setCurrentFiscalYear(root.getCurrentFiscalYear());
			statusTrackerMainEntity.setInitiativeStatus(root.getInitiativeStatus());
			statusTrackerMainEntity.setPhase(root.getPhase());
			statusTrackerMainEntity.setStatusUpdate(root.getStatusUpdate());
			statusTrackerMainEntity.setEoiSubmissionDate(root.getEoiSubmissionDate());
			statusTrackerMainEntity.setEoiApprovalDate(root.getEoiApprovalDate());
			statusTrackerMainEntity.setSpSubmissionDate(root.getSpSubmissionDate());
			statusTrackerMainEntity.setSpApprovalDate(root.getSpApprovalDate());
			statusTrackerMainEntity.setImplementationDate(root.getImplementationDate());
			statusTrackerMainEntity.setAnnouncementPending(root.getAnnouncementPending());
			statusTrackerMainEntity.setTargetOpeningDate(root.getTargetOpeningDate());
			statusTrackerMainEntity.setActualOpeningDate(root.getActualOpeningDate());
			statusTrackerMainEntity.setOpenDateForScaleUpResources(root.getOpenDateForScaleUpResources());
			statusTrackerMainEntity.setReasonForDelay(root.getReasonForDelay());
			statusTrackerMainEntity.setReasonForExceptionInDate(root.getReasonForExceptionInDate());
			statusTrackerMainEntity.setAnyIssuesRisk(root.getAnyIssuesRisk());
			statusTrackerMainEntity.setAttachmentGap(root.getAttachmentGap());
			statusTrackerMainEntity.setForecastImplementationYear(root.getForecastedImplementationYear());
			statusTrackerMainEntity.setOtherPCIsIncluded(root.getOtherPcIsIncluded());
			statusTrackerMainEntity.setUpccName(root.getUpccName());
			statusTrackerMainEntity.setUpccCovidTestSite(root.getUpccCovidTestSite());
			statusTrackerMainEntity.setUpccChangesToService(root.getUpccChangesToService());
			statusTrackerMainEntity.setUpccChangeToServiceDate(root.getUpccChangeToServiceDate());
			statusTrackerMainEntity.setUpccServiceDeliveryMode(root.getUpccServiceDeliveryMode());
			statusTrackerMainEntity.setChcName(root.getChcName());
			statusTrackerMainEntity.setChcAddress(root.getChcAddress());
			statusTrackerMainEntity.setChcKeyAttributes(root.getChcKeyAttributes());
			statusTrackerMainEntity.setChcFundingSources(root.getChcFundingSources());
			statusTrackerMainEntity.setFnpccName(root.getFnpccName());
			statusTrackerMainEntity.setFnpccAddress(root.getFnpccAddress());
			statusTrackerMainEntity.setFnpccImplementationType(root.getFnpccImplementationType());
			statusTrackerMainEntity.setFnpccFiscalYearAndQuarterLaunch(root.getFnpccFiscalYearAndQuarterLaunch());
			statusTrackerMainEntity.setNppccName(root.getNppccName());
			statusTrackerMainEntity.setNppccAddress(root.getNppccAddress());
			statusTrackerMainEntity.setNppccKeyAttributes(root.getNppccKeyAttributes());
			statusTrackerMainEntity.setNppccFundingSourcesAndPartnershipStructure(root.getNppccfundingSourcesAndPartnershipStructure());
			statusTrackerMainEntity.setInitiativeName(root.getInitiativeName());
			statusTrackerMainEntity.setHsiarServicePlanGapAnalysis(root.getHsiarServicePlanGapAnalysis());
			statusTrackerMainEntity.setAnnouncementDate(root.getAnnouncementDate());
			statusTrackerMainEntity.setAdditionalDetails(root.getAdditionalDetails());
			statusTrackerMainEntity.setFirstNationOrganizationLead(root.getFirstNationOrganizationLead());
			statusTrackerMainEntity.setUpccTypeOfCare(root.getUpccTypeOfCare());


			if (root.getPcnNameWithType() != null
					&& root.getPcnNameWithType().getName() != null
					&& root.getPcnNameWithType().getType() != null) {
				var pcnNameType = new PCNName();
				pcnNameType.setConfirmationId(root.getForm().getConfirmationId());
				pcnNameType.setPcnName(root.getPcnNameWithType().getName());
				pcnNameType.setType(root.getPcnNameWithType().getType());

				pcnNames.add(pcnNameType);
				statusTrackerMainEntity.setPcnNamesWithType(pcnNames);
			}

			// Add Lists
			// PCN Name
			if (root.getPcnNamesWithType() != null) {
				for (RootPCNNameWithType pcn : root.getPcnNamesWithType()) {
					if (pcn.getName() != null && pcn.getType() != null) {
						var pcnNameType = new PCNName();
						pcnNameType.setConfirmationId(root.getForm().getConfirmationId());
						pcnNameType.setPcnName(pcn.getName());
						pcnNameType.setType(pcn.getType());

						pcnNames.add(pcnNameType);
					}
				}
				statusTrackerMainEntity.setPcnNamesWithType(pcnNames);
			}

			// Issues And Risks
			if (root.getIssuesAndRisks() != null) {
				int index = 0;
				for (RootIssueAndRisk issue : root.getIssuesAndRisks()) {
					//generate issueID
					var issueId = Integer.toString(index++);

					var issueAndRisk = new IssueAndRisk();
					issueAndRisk.setConfirmationId(root.getForm().getConfirmationId());
					issueAndRisk.setIssueId(issueId);
					issueAndRisk.setIssueRaisedDate(issue.getIssueRaisedDate());
					issueAndRisk.setIssueClosedDate(issue.getIssueClosedDate());
					issueAndRisk.setRelevantSites(issue.getRelevantSites());
					issueAndRisk.setRiskCategory(issue.getRiskCategory());
					issueAndRisk.setIssueAndRisk(issue.getIssueAndRisk());
					issueAndRisk.setMitigationStrategy(issue.getMitigationStrategy());
					issueAndRisk.setDateMitigationPlanCommences(issue.getDateMitigationPlanCommences());
					issueAndRisk.setIssuesNotes(issue.getIssuesNotes());

					//Handle IssueAndRiskTypes
					List<IssueAndRiskType> issueAndRiskTypes = new ArrayList<IssueAndRiskType>();
					for (String issueType : issue.getTypeOfIssue()) {
						var issueAndRiskType = new IssueAndRiskType();
						issueAndRiskType.setIssueId(issueId);
						issueAndRiskType.setTypeOfIssue(issueType);

						issueAndRiskTypes.add(issueAndRiskType);
					}
					issueAndRisk.setTypeOfIssue(issueAndRiskTypes);

					issuesAndRisks.add(issueAndRisk);
				}
				statusTrackerMainEntity.setIssueAndRisks(issuesAndRisks);
			}

			statusTrackerParsed.add(statusTrackerMainEntity);
		}

		return statusTrackerParsed;
	}

}
