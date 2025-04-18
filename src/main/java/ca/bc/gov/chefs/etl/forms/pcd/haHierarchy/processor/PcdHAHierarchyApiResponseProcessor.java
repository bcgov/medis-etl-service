package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.INITIATIVE_TYPE_CHC;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.INITIATIVE_TYPE_FNPCC;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.INITIATIVE_TYPE_NPPCC;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.INITIATIVE_TYPE_UPCC;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json.CHC;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json.ClinicData;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json.CommunityData;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json.FNPCC;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json.NPPCC;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json.PCN;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json.UPCC;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model.Clinic;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model.Community;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model.HealthAuthority;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model.PrimaryCareInitiative;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model.PrimaryCareNetwork;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdHAHierarchyApiResponseProcessor extends BaseApiResponseProcessor {

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.fixUnicodeCharacters(payload);

		ObjectMapper mapper = new ObjectMapper();

		List<Root> haHierarchyModels = mapper.readValue(payload, new TypeReference<List<Root>>() {});
		List<HealthAuthority> parsedHaHierarchy = parseHaHierarchyRequest(haHierarchyModels);

		validateRecordCount(haHierarchyModels, parsedHaHierarchy);

		List<IModel> iModels = (List<IModel>) (List<?>) parsedHaHierarchy;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_HA_HIERARCHY_DIR, isHeaderAdded);

		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setFiles(filesGenerated);
		exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}

	private List<HealthAuthority> parseHaHierarchyRequest(List<Root> healthAuthorityPayloads) {
		List<HealthAuthority> haHierarchySubmissions = new ArrayList<>();
		for (Root root : healthAuthorityPayloads) {
			HealthAuthority haHierarchySubmission = new HealthAuthority();

			// mapping HealthAuthority table
			haHierarchySubmission.setSubmissionId(root.getForm().getSubmissionId());
			haHierarchySubmission.setLateEntry(root.getLateEntry());
			haHierarchySubmission.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
			haHierarchySubmission.setSubmitterFullName(root.getForm().getFullName());
			haHierarchySubmission.setSubmitterUserName(root.getForm().getUsername());
			haHierarchySubmission.setSubmitterEmail(root.getForm().getEmail());
			haHierarchySubmission.setSubmissionStatus(root.getForm().getStatus());
			haHierarchySubmission.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
			haHierarchySubmission.setSubmissionFormName(root.getForm().getFormName());
			haHierarchySubmission.setHealthAuthority(root.getHealthAuthority());
			haHierarchySubmission.setHealthAuthorityCode(root.getHealthAuthorityId());

			List<Community> haHierarchyCommunities = new ArrayList<>();
			haHierarchySubmission.setCommunities(haHierarchyCommunities);
			haHierarchySubmissions.add(haHierarchySubmission);

			for (CommunityData community : root.getCommunities()) {
				// mapping Community Table
				Community newCommunity = new Community();
				newCommunity.setSubmissionId(root.getForm().getSubmissionId());
				newCommunity.setCommunityId(UUID.randomUUID().toString());
				newCommunity.setCommunityName(community.getCommunityName());
				newCommunity.setHsiarServicePlanGapAnalysis(community.getHsiarServicePlanGapAnalysis());
				newCommunity.setHsiarServicePlanGapAnalysisDate(CSVUtil.formatDate(community.getHsiarServicePlanGapAnalysisDate()));
				newCommunity.setCommunityCode(community.getPcnCommunityId());

				List<PrimaryCareNetwork> primaryCareNetworks = new ArrayList<>();
				newCommunity.setPrimaryCareNetworks(primaryCareNetworks);

				haHierarchyCommunities.add(newCommunity);

				// mapping PrimaryCareNetwork table
				if (community.getPcn() != null) {
					for (PCN pcn : community.getPcn()) {
						PrimaryCareNetwork primaryCareNetwork = new PrimaryCareNetwork();
						primaryCareNetwork.setCommunityId(newCommunity.getCommunityId());
						primaryCareNetwork.setPrimaryCareNetworkId(UUID.randomUUID().toString());
						primaryCareNetwork.setPcnName(pcn.getPcnName());
						primaryCareNetwork.setPcnType(pcn.getPcnType());
						primaryCareNetwork.setPcnCode(pcn.getPcnNameId());

						List<PrimaryCareInitiative> primaryCareInitiatives = new ArrayList<>();
						primaryCareNetwork.setPrimaryCareInitiatives(primaryCareInitiatives);

						List<Clinic> clinics = new ArrayList<>();
						primaryCareNetwork.setClinics(clinics);

						primaryCareNetworks.add(primaryCareNetwork);

						// mapping Clinic
						clinics.addAll(createPCNClinics(primaryCareNetwork, pcn.getPcnClinic()));

						// mapping PrimaryCareInitiatives table
						if (pcn.getChc() != null) {
							for (CHC chc : pcn.getChc()) {
								PrimaryCareInitiative newInitiative =
										createPrimaryCareInitiative(primaryCareNetwork.getPrimaryCareNetworkId(), INITIATIVE_TYPE_CHC, chc.getChcName(), null, chc.getChcNameId());
								primaryCareInitiatives.add(newInitiative);
							}
						}
						if (pcn.getUpcc() != null) {
							for (UPCC upcc : pcn.getUpcc()) {
								PrimaryCareInitiative newInitiative =
										createPrimaryCareInitiative(primaryCareNetwork.getPrimaryCareNetworkId(), INITIATIVE_TYPE_UPCC, upcc.getUpccName(), upcc.getTypeOfCare(), upcc.getUpccNameId());
								primaryCareInitiatives.add(newInitiative);
							}
						}
						if (pcn.getFnpcc() != null) {
							for (FNPCC fnpcc : pcn.getFnpcc()) {
								PrimaryCareInitiative newInitiative =
										createPrimaryCareInitiative(primaryCareNetwork.getPrimaryCareNetworkId(), INITIATIVE_TYPE_FNPCC, fnpcc.getFnpccName(), null, fnpcc.getFnpccNameId());
								primaryCareInitiatives.add(newInitiative);
							}
						}
						if (pcn.getNppcc() != null) {
							for (NPPCC nppcc : pcn.getNppcc()) {
								PrimaryCareInitiative newInitiative =
										createPrimaryCareInitiative(primaryCareNetwork.getPrimaryCareNetworkId(), INITIATIVE_TYPE_NPPCC, nppcc.getNppccName(), null, nppcc.getNppccNameId());
								primaryCareInitiatives.add(newInitiative);
							}
						}
					}
				}

			}
		}

		return haHierarchySubmissions;
	}

	private PrimaryCareInitiative createPrimaryCareInitiative(String primaryCareNetworkId, String initiativeType, String initiativeName, String typeOfCare, String initiativeCode) {
		PrimaryCareInitiative initiative = new PrimaryCareInitiative();
		initiative.setPrimaryCareNetworkId(primaryCareNetworkId);
		initiative.setPrimaryCareInitiativeId(UUID.randomUUID().toString());
		initiative.setInitiativeName(initiativeName);
		initiative.setInitiativeType(initiativeType);
		initiative.setTypeOfCare(typeOfCare);
		initiative.setInitiativeCode(initiativeCode);

		return initiative;
	}

	private List<Clinic> createPCNClinics(PrimaryCareNetwork primaryCareNetwork, List<ClinicData> clinics) {
		return createClinics(primaryCareNetwork, null, clinics);
	}

	private List<Clinic> createClinics(PrimaryCareNetwork primaryCareNetwork, PrimaryCareInitiative primaryCareInitiative, List<ClinicData> clinics) {
		List<Clinic> newClinics = new ArrayList<>();
		if (clinics == null) {
			return newClinics;
		}
		for (ClinicData clinic : clinics) {
			// Skip empty Clinics
			if (StringUtils.isBlank(clinic.getClinicName())) {
				continue;
			}
			Clinic newClinic = new Clinic();
			if (primaryCareNetwork != null) {
				newClinic.setPrimaryCareNetworkId(primaryCareNetwork.getPrimaryCareNetworkId());
			}
			newClinic.setClinicId(UUID.randomUUID().toString());
			newClinic.setClinicName(clinic.getClinicName());
			newClinic.setClinicType(clinic.getClinicType());
			newClinics.add(newClinic);
		}
		return newClinics;
	}

}
