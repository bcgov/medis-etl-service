package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.RootIssueAndRisk;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.RootPCNNameWithType;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.CHCStatusTrackerItem;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.ClinicName;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.FNPCCStatusTrackerItem;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.IssueAndRisk;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.IssueAndRiskType;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.NPPCCStatusTrackerItem;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.PCNName;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.PCNStatusTrackerItem;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.StatusTrackerSubmission;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.UPCCStatusTrackerItem;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class StatusTrackerFormApiResponseProcessor extends BaseApiResponseProcessor {

	private static final String DEFAULT_EMAIL = "pcdbi-status-tracker-data-loader@gov.bc.ca";

	private static final String INITIATIVE_TYPE_PCN = "PCN";
	private static final String INITIATIVE_TYPE_CHC = "CHC";
	private static final String INITIATIVE_TYPE_FNPCC = "FNPCC";
	private static final String INITIATIVE_TYPE_NPPCC = "NPPCC";
	private static final String INITIATIVE_TYPE_UPCC = "UPCC";

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);

		// Round digits
		payload = JsonUtil.roundDigitsNumber(payload);

		ObjectMapper mapper = new ObjectMapper();

		List<Root> statusTrackerModels =
				mapper.readValue(payload, new TypeReference<List<Root>>() {});
		List<StatusTrackerSubmission> parsedStatusTracker = parseStatusTracker(statusTrackerModels);

		validateRecordCount(statusTrackerModels, parsedStatusTracker);

		List<IModel> iModels = (List<IModel>) (List<?>) parsedStatusTracker;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

		boolean isHeaderAdded =
				(boolean) exchange.getProperties().get(PCDConstants.IS_HEADER_ADDED);
		List<String> filesGenerated =
				FileUtil.writeToCSVFile(map, PCDConstants.PCD_STATUS_TRACKER_DIR, isHeaderAdded);

		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setFiles(filesGenerated);
		exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}

	private List<StatusTrackerSubmission> parseStatusTracker(List<Root> statusTracker) {
		List<StatusTrackerSubmission> statusTrackerParsed = new ArrayList<>();

		// Use ModelMapper to handle the basic conversion
		ModelMapper modelMapper = new ModelMapper();

		// Define nested mappings
		modelMapper.typeMap(Root.class, StatusTrackerSubmission.class).addMappings(mapper -> {
			mapper.map(src -> src.getForm().getSubmissionId(),
					StatusTrackerSubmission::setSubmissionId);
			mapper.map(src -> src.getForm().getFullName(),
					StatusTrackerSubmission::setSubmitterFullName);
			mapper.map(src -> src.getForm().getUsername(),
					StatusTrackerSubmission::setSubmitterUserName);
			mapper.map(src -> src.getForm().getEmail(), StatusTrackerSubmission::setSubmitterEmail);
			mapper.map(src -> src.getForm().getStatus(),
					StatusTrackerSubmission::setSubmissionStatus);
			mapper.map(src -> src.getForm().getVersion(),
					StatusTrackerSubmission::setSubmissionVersion);
			mapper.map(src -> src.getForm().getFormName(),
					StatusTrackerSubmission::setSubmissionFormName);
			mapper.map(src -> src.getTargetLaunchOpenDate(),
					StatusTrackerSubmission::setTargetOpeningDate);
			mapper.map(src -> src.getActualLaunchOpenDate(),
					StatusTrackerSubmission::setActualOpeningDate);
		});

		ModelMapper InitiativeMapper = new ModelMapper();
		InitiativeMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		for (Root root : statusTracker) {

			StatusTrackerSubmission hiStatusTracker =
					modelMapper.map(root, StatusTrackerSubmission.class);

			// Default the email for bulk uploaded records
			if (StringUtils.isBlank(hiStatusTracker.getSubmitterEmail())) {
				hiStatusTracker.setSubmitterEmail(DEFAULT_EMAIL);
			}

			// Set the values not parsed by ModelMapper
			hiStatusTracker.setLateEntry(root.getLateEntry());
			hiStatusTracker.setAnyIssuesRisks(root.getAnyIssuesRisk());
			hiStatusTracker.setDatesComments(root.getDateComments());
			hiStatusTracker.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));

			// Handle PCN Names
			List<PCNName> pcnNames = new ArrayList<>();
			// PCN has multiple
			if (StringUtils.equals(root.getTypeOfInitiative(), INITIATIVE_TYPE_PCN)) {
				if (root.getPcnNamesWithType() != null) {
					for (RootPCNNameWithType pcnNameWithType : root.getPcnNamesWithType()) {
						pcnNames.add(
								convertPCNName(root.getForm().getSubmissionId(), pcnNameWithType));
					}
				}
			} else {
				// Others have single
				if (root.getPcnNameWithType() != null) {
					pcnNames.add(convertPCNName(root.getForm().getSubmissionId(),
							root.getPcnNameWithType()));
				}
			}
			hiStatusTracker.setPcnNames(pcnNames);

			// Handle Clinic Names
			List<ClinicName> clinicNames = new ArrayList<>();
			if (root.getClinicNames() != null) {
				for (String clinic : root.getClinicNames()) {
					// Ignore empty clinic names which seems to be a possibility
					if (StringUtils.isBlank(clinic)) {
						continue;
					}
					ClinicName clinicName = new ClinicName();
					clinicName.setSubmissionId(root.getForm().getSubmissionId());
					clinicName.setClinicName(clinic);
					clinicNames.add(clinicName);
				}
				hiStatusTracker.setClinicNames(clinicNames);
			}

			// Handle specific initiative cases
			switch (root.getTypeOfInitiative()) {
				case INITIATIVE_TYPE_PCN -> {
					InitiativeMapper.typeMap(Root.class, PCNStatusTrackerItem.class)
							.addMappings(mapper -> {
								mapper.map(src -> src.getForm().getSubmissionId(),
										PCNStatusTrackerItem::setSubmissionId);
								mapper.map(src -> src.getHsiarServicePlanGapAnalysis(),
										PCNStatusTrackerItem::setHsiarServicePlanGapAnlys);
								mapper.map(src -> src.getHsiarServicePlanGapAnalysisDate(),
										PCNStatusTrackerItem::setHsiarServPlGapAnlysDate);
								mapper.map(src -> src.getOtherPcIsIncluded(),
										PCNStatusTrackerItem::setOtherPcisIncluded);
								mapper.map(src -> src.getPcnImEstFndPreLncDate(),
										PCNStatusTrackerItem::setPcnImEstFndPrelncDate);
								mapper.map(src -> src.getPcnImEstFndPreLncNotes(),
										PCNStatusTrackerItem::setPcnImEstFndPrelncNotes);
								mapper.map(src -> src.getPcnImSerPubBldCapLncDate(),
										PCNStatusTrackerItem::setPcnImSerPubLnchDate);
								mapper.map(src -> src.getPcnImSerPubBldCapLncNotes(),
										PCNStatusTrackerItem::setPcnImSerPubLnchNotes);
								mapper.map(src -> src.getPcnPlFunPkgAppIssDate(),
										PCNStatusTrackerItem::setPcnPlFunPkgAppDate);
								mapper.map(src -> src.getPcnPlFunPkgAppIssNotes(),
										PCNStatusTrackerItem::setPcnPlFunPkgAppNotes);
								mapper.map(src -> src.getPcnPlFunPkgAppPenDate(),
										PCNStatusTrackerItem::setPcnPlFunPkgPenDate);
								mapper.map(src -> src.getPcnPlFunPkgAppPenNotes(),
										PCNStatusTrackerItem::setPcnPlFunPkgPenNotes);
								mapper.map(src -> src.getPcnPlSerPlnOprBudEdrDate(),
										PCNStatusTrackerItem::setPcnPlSerPlnEdrDate);
								mapper.map(src -> src.getPcnPlSerPlnOprBudEdrNotes(),
										PCNStatusTrackerItem::setPcnPlSerPlnEdrNotes);
								mapper.map(src -> src.getPcnPlSerPlnOprBudSubUndRevDate(),
										PCNStatusTrackerItem::setPcnPlSerPlnRevDate);
								mapper.map(src -> src.getPcnPlSerPlnOprBudSubUndRevNotes(),
										PCNStatusTrackerItem::setPcnPlSerPlnRevNotes);
							});
					PCNStatusTrackerItem pcnStatusTrackerItem =
							InitiativeMapper.map(root, PCNStatusTrackerItem.class);
					pcnStatusTrackerItem.setPcnId(java.util.UUID.randomUUID().toString());
					pcnStatusTrackerItem.setAllClinicsImpacted(root.getAllClinicsImpacted());
					hiStatusTracker.setStatusTrackerPcn(pcnStatusTrackerItem);
				}
				case INITIATIVE_TYPE_CHC -> {
					InitiativeMapper.typeMap(Root.class, CHCStatusTrackerItem.class)
							.addMappings(mapper -> {
								mapper.map(src -> src.getForm().getSubmissionId(),
										CHCStatusTrackerItem::setSubmissionId);
								mapper.map(src -> src.getChcImEstFndAppNotOpnDate(),
										CHCStatusTrackerItem::setChcImFndNotOpnDate);
								mapper.map(src -> src.getChcImEstFndAppNotOpnNotes(),
										CHCStatusTrackerItem::setChcImFndNotOpnNotes);
								mapper.map(src -> src.getChcImSerPubBldCapDrsOpnDate(),
										CHCStatusTrackerItem::setChcImSerPubOpnDate);
								mapper.map(src -> src.getChcImSerPubBldCapDrsOpnNotes(),
										CHCStatusTrackerItem::setChcImSerPubOpnNotes);
								mapper.map(src -> src.getChcImStbFulOprDate(),
										CHCStatusTrackerItem::setChcImStbFullOprDate);
								mapper.map(src -> src.getChcImStbFulOprNotes(),
										CHCStatusTrackerItem::setChcImStbFullOprNotes);
								mapper.map(src -> src.getChcInConSumAccCfmDate(),
										CHCStatusTrackerItem::setChcInConSumAccDate);
								mapper.map(src -> src.getChcInConSumAccCfmNotes(),
										CHCStatusTrackerItem::setChcInConSumAccNotes);
								mapper.map(src -> src.getChcPlFunPkgAppIssDate(),
										CHCStatusTrackerItem::setChcPlFunPkgAppDate);
								mapper.map(src -> src.getChcPlFunPkgAppIssNotes(),
										CHCStatusTrackerItem::setChcPlFunPkgAppNotes);
								mapper.map(src -> src.getChcPlFunPkgAppPenDate(),
										CHCStatusTrackerItem::setChcPlFunPkgPenDate);
								mapper.map(src -> src.getChcPlFunPkgAppPenNotes(),
										CHCStatusTrackerItem::setChcPlFunPkgPenNotes);
							});
					CHCStatusTrackerItem chcStatusTrackerItem =
							InitiativeMapper.map(root, CHCStatusTrackerItem.class);
					chcStatusTrackerItem.setChcId(java.util.UUID.randomUUID().toString());
					hiStatusTracker.setStatusTrackerChc(chcStatusTrackerItem);
				}
				case INITIATIVE_TYPE_NPPCC -> {
					InitiativeMapper.typeMap(Root.class, NPPCCStatusTrackerItem.class)
							.addMappings(mapper -> {
								mapper.map(src -> src.getForm().getSubmissionId(),
										NPPCCStatusTrackerItem::setSubmissionId);
								mapper.map(src -> src.getNppccImEstFndAppNotOpnDate(),
										NPPCCStatusTrackerItem::setNppccImFndNotOpnDate);
								mapper.map(src -> src.getNppccImEstFndAppNotOpnNotes(),
										NPPCCStatusTrackerItem::setNppccImFndNotOpnNotes);
								mapper.map(src -> src.getNppccImSerPubBldCapDrsOpnDate(),
										NPPCCStatusTrackerItem::setNppccImSerPubOpnDate);
								mapper.map(src -> src.getNppccImSerPubBldCapDrsOpnNotes(),
										NPPCCStatusTrackerItem::setNppccImSerPubOpnNotes);
								mapper.map(src -> src.getNppccImStbFulOprDate(),
										NPPCCStatusTrackerItem::setNppccImStbFullOprDate);
								mapper.map(src -> src.getNppccImStbFulOprNotes(),
										NPPCCStatusTrackerItem::setNppccImStbFullOprNotes);
								mapper.map(src -> src.getNppccPlFunPkgAppIssDate(),
										NPPCCStatusTrackerItem::setNppccPlFunPkgAppDate);
								mapper.map(src -> src.getNppccPlFunPkgAppIssNotes(),
										NPPCCStatusTrackerItem::setNppccPlFunPkgAppNotes);
								mapper.map(src -> src.getNppccPlFunPkgAppPenDate(),
										NPPCCStatusTrackerItem::setNppccPlFunPkgPenDate);
								mapper.map(src -> src.getNppccPlFunPkgAppPenNotes(),
										NPPCCStatusTrackerItem::setNppccPlFunPkgPenNotes);
							});
					NPPCCStatusTrackerItem nppccStatusTrackerItem =
							InitiativeMapper.map(root, NPPCCStatusTrackerItem.class);
					nppccStatusTrackerItem.setNppccId(java.util.UUID.randomUUID().toString());
					hiStatusTracker.setStatusTrackerNppcc(nppccStatusTrackerItem);
				}
				case INITIATIVE_TYPE_UPCC -> {
					InitiativeMapper.typeMap(Root.class, UPCCStatusTrackerItem.class)
							.addMappings(mapper -> {
								mapper.map(src -> src.getForm().getSubmissionId(),
										UPCCStatusTrackerItem::setSubmissionId);
								mapper.map(src -> src.getUpccChangeToServiceDate(),
										UPCCStatusTrackerItem::setUpccChangesToServiceDate);
								mapper.map(src -> src.getUpccImEstFndAppNotOpnDate(),
										UPCCStatusTrackerItem::setUpccImFndNotOpnDate);
								mapper.map(src -> src.getUpccImEstFndAppNotOpnNotes(),
										UPCCStatusTrackerItem::setUpccImFndNotOpnNotes);
								mapper.map(src -> src.getUpccImSerPubBldCapDrsOpnDate(),
										UPCCStatusTrackerItem::setUpccImSerPubOpnDate);
								mapper.map(src -> src.getUpccImSerPubBldCapDrsOpnNotes(),
										UPCCStatusTrackerItem::setUpccImSerPubOpnNotes);
								mapper.map(src -> src.getUpccImStbFulOprDate(),
										UPCCStatusTrackerItem::setUpccImStbFullOprDate);
								mapper.map(src -> src.getUpccImStbFulOprNotes(),
										UPCCStatusTrackerItem::setUpccImStbFullOprNotes);
								mapper.map(src -> src.getUpccInConSumAccCfmDate(),
										UPCCStatusTrackerItem::setUpccInConSumAccDate);
								mapper.map(src -> src.getUpccInConSumAccCfmNotes(),
										UPCCStatusTrackerItem::setUpccInConSumAccNotes);
								mapper.map(src -> src.getUpccPlFunPkgAppIssDate(),
										UPCCStatusTrackerItem::setUpccPlFunPkgAppDate);
								mapper.map(src -> src.getUpccPlFunPkgAppIssNotes(),
										UPCCStatusTrackerItem::setUpccPlFunPkgAppNotes);
								mapper.map(src -> src.getUpccPlFunPkgAppPenDate(),
										UPCCStatusTrackerItem::setUpccPlFunPkgPenDate);
								mapper.map(src -> src.getUpccPlFunPkgAppPenNotes(),
										UPCCStatusTrackerItem::setUpccPlFunPkgPenNotes);
								mapper.map(src -> src.getUpccPlSerPlnOprBudEdrDate(),
										UPCCStatusTrackerItem::setUpccPlSerPlnEdrDate);
								mapper.map(src -> src.getUpccPlSerPlnOprBudEdrNotes(),
										UPCCStatusTrackerItem::setUpccPlSerPlnEdrNotes);
								mapper.map(src -> src.getUpccPlSerPlnOprBudSubUndRevDate(),
										UPCCStatusTrackerItem::setUpccPlSerPlnRevDate);
								mapper.map(src -> src.getUpccPlSerPlnOprBudSubUndRevNotes(),
										UPCCStatusTrackerItem::setUpccPlSerPlnRevNotes);
							});
					UPCCStatusTrackerItem upccStatusTrackerItem =
							InitiativeMapper.map(root, UPCCStatusTrackerItem.class);

					upccStatusTrackerItem.setUpccId(java.util.UUID.randomUUID().toString());
					hiStatusTracker.setStatusTrackerUpcc(upccStatusTrackerItem);
				}
				case INITIATIVE_TYPE_FNPCC -> {
					InitiativeMapper.typeMap(Root.class, FNPCCStatusTrackerItem.class)
							.addMappings(mapper -> {
								mapper.map(src -> src.getForm().getSubmissionId(),
										FNPCCStatusTrackerItem::setSubmissionId);
								mapper.map(
										src -> src.getFnpccfundingSourcesAndPartnershipStructure(),
										FNPCCStatusTrackerItem::setFnpccFundingSources);
								mapper.map(src -> src.getFnpccFirstNationOrganizationLead(),
										FNPCCStatusTrackerItem::setFnpccFirstNationOrgLead);
								mapper.map(src -> src.getFnpccImEstFndAppNotOpnDate(),
										FNPCCStatusTrackerItem::setFnpccImFndNotOpnDate);
								mapper.map(src -> src.getFnpccImEstFndAppNotOpnDate(),
										FNPCCStatusTrackerItem::setFnpccImFndNotOpnDate);
								mapper.map(src -> src.getFnpccImEstFndAppNotOpnNotes(),
										FNPCCStatusTrackerItem::setFnpccImFndNotOpnNotes);
								mapper.map(src -> src.getFnpccImSerPubBldCapDrsOpnDate(),
										FNPCCStatusTrackerItem::setFnpccImSerPubOpnDate);
								mapper.map(src -> src.getFnpccImSerPubBldCapDrsOpnNotes(),
										FNPCCStatusTrackerItem::setFnpccImSerPubOpnNotes);
								mapper.map(src -> src.getFnpccImStbFulOprDate(),
										FNPCCStatusTrackerItem::setFnpccImStbFullOprDate);
								mapper.map(src -> src.getFnpccImStbFulOprNotes(),
										FNPCCStatusTrackerItem::setFnpccImStbFullOprNotes);
								mapper.map(src -> src.getFnpccInPreAnlRepCfmDate(),
										FNPCCStatusTrackerItem::setFnpccInPreAnlCfmDate);
								mapper.map(src -> src.getFnpccInPreAnlRepCfmNotes(),
										FNPCCStatusTrackerItem::setFnpccInPreAnlCfmNotes);
								mapper.map(src -> src.getFnpccInPreAnlRepSubDate(),
										FNPCCStatusTrackerItem::setFnpccInPreAnlSubDate);
								mapper.map(src -> src.getFnpccInPreAnlRepSubNotes(),
										FNPCCStatusTrackerItem::setFnpccInPreAnlSubNotes);
								mapper.map(src -> src.getFnpccPlFunPkgAppIssDate(),
										FNPCCStatusTrackerItem::setFnpccPlFunPkgAppDate);
								mapper.map(src -> src.getFnpccPlFunPkgAppIssNotes(),
										FNPCCStatusTrackerItem::setFnpccPlFunPkgAppNotes);
								mapper.map(src -> src.getFnpccPlFunPkgAppPenDate(),
										FNPCCStatusTrackerItem::setFnpccPlFunPkgPenDate);
								mapper.map(src -> src.getFnpccPlFunPkgAppPenNotes(),
										FNPCCStatusTrackerItem::setFnpccPlFunPkgPenNotes);
								mapper.map(src -> src.getFnpccPlMinFnhSerPlnRevDate(),
										FNPCCStatusTrackerItem::setFnpccPlMinPlnRevDate);
								mapper.map(src -> src.getFnpccPlMinFnhSerPlnRevNotes(),
										FNPCCStatusTrackerItem::setFnpccPlMinPlnRevNotes);
								mapper.map(src -> src.getFnpccPlSerPlnAwtFnhEndDate(),
										FNPCCStatusTrackerItem::setFnpccPlPlnAwtFnhDate);
								mapper.map(src -> src.getFnpccPlSerPlnAwtFnhEndNotes(),
										FNPCCStatusTrackerItem::setFnpccPlPlnAwtFnhNotes);
								mapper.map(src -> src.getFnpccPlSerPlnAwtMinEndDate(),
										FNPCCStatusTrackerItem::setFnpccPlPlnAwtMinDate);
								mapper.map(src -> src.getFnpccPlSerPlnAwtMinEndNotes(),
										FNPCCStatusTrackerItem::setFnpccPlPlnAwtMinNotes);
								mapper.map(src -> src.getFnpccPlSerPlnOprBudEdrDate(),
										FNPCCStatusTrackerItem::setFnpccPlSerPlnEdrDate);
								mapper.map(src -> src.getFnpccPlSerPlnOprBudEdrNotes(),
										FNPCCStatusTrackerItem::setFnpccPlSerPlnEdrNotes);
								mapper.map(src -> src.getFnpccPlSerPlnOprBudSubUndRevDate(),
										FNPCCStatusTrackerItem::setFnpccPlSerPlnRevDate);
								mapper.map(src -> src.getFnpccPlSerPlnOprBudSubUndRevNotes(),
										FNPCCStatusTrackerItem::setFnpccPlSerPlnRevNotes);
								mapper.map(src -> src.getFnpccPlTrgSerPlnRevDate(),
										FNPCCStatusTrackerItem::setFnpccPlTrgPlnRevDate);
								mapper.map(src -> src.getFnpccPlTrgSerPlnRevNotes(),
										FNPCCStatusTrackerItem::setFnpccPlTrgPlnRevNotes);
							});
					FNPCCStatusTrackerItem fnpccStatusTrackerItem =
							InitiativeMapper.map(root, FNPCCStatusTrackerItem.class);
					fnpccStatusTrackerItem.setFnpccId(java.util.UUID.randomUUID().toString());
					hiStatusTracker.setStatusTrackerFnpcc(fnpccStatusTrackerItem);
				}
				default -> {
				}
			}

			// Issues And Risks
			List<IssueAndRisk> issuesAndRisks = new ArrayList<>();
			if (root.getIssuesAndRisks() != null) {
				for (RootIssueAndRisk issue : root.getIssuesAndRisks()) {
					// Ignore empty IssueAndRisk values which seems to be a possibility
					if (StringUtils.isBlank(issue.getIssueRaisedDate())) {
						continue;
					}

					IssueAndRisk issueAndRisk = modelMapper.map(issue, IssueAndRisk.class);
					issueAndRisk.setSubmissionId(root.getForm().getSubmissionId());
					issueAndRisk.setDateMitigationPlanComms(issue.getDateMitigationPlanCommences());

					// generate issueID
					String issueId = UUID.randomUUID().toString();
					issueAndRisk.setIssueId(issueId);

					// Handle IssueAndRiskTypes
					List<IssueAndRiskType> issueAndRiskTypes = new ArrayList<IssueAndRiskType>();
					if (issue.getIssueRiskCategory() != null) {
						for (String issueType : issue.getIssueRiskCategory()) {
							IssueAndRiskType issueAndRiskType = new IssueAndRiskType();
							issueAndRiskType.setIssueId(issueId);
							issueAndRiskType.setCategoryOfIssue(issueType);
							issueAndRiskTypes.add(issueAndRiskType);
						}
					}
					issueAndRisk.setIssueAndRiskTypes(issueAndRiskTypes);

					issuesAndRisks.add(issueAndRisk);
				}
				hiStatusTracker.setIssueAndRisks(issuesAndRisks);
			}

			statusTrackerParsed.add(hiStatusTracker);
		}

		return statusTrackerParsed;
	}

	private PCNName convertPCNName(String submissionId, RootPCNNameWithType pcnNameWithType) {
		PCNName pcnName = new PCNName();
		pcnName.setSubmissionId(submissionId);
		pcnName.setPcnName(pcnNameWithType.getName());
		pcnName.setType(pcnNameWithType.getType());

		return pcnName;
	}

}
