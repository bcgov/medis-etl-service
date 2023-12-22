package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.processor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
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
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model.PrimaryCareInitiatives;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model.PrimaryCareNetwork;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdHAHierarchyApiResponseProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> haHierarchyModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<HealthAuthority> parsedHaHierarchy = parseHaHierarchyRequest(haHierarchyModels);
		List<IModel> iModels = (List<IModel>) (List<?>) parsedHaHierarchy;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_HA_HIERARCHY_DIR, isHeaderAdded);

		// TODO remove successReponse or uncomment
		// SuccessResponse successResponse = new SuccessResponse();
		// successResponse.setFiles(filesGenerated);
		// exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
		
	private List<HealthAuthority> parseHaHierarchyRequest(List<Root> healthAuthorityPayloads) {
		List<HealthAuthority> haHierarchySubmissions = new ArrayList<>();
		for (Root root : healthAuthorityPayloads) {
			HealthAuthority haHierarchySubmission = new HealthAuthority();
			List<Community>  haHierarchyCommunities = new ArrayList<>();
			List<PrimaryCareNetwork>  haHierarchyPCN = new ArrayList<>();
			List<PrimaryCareInitiatives> haHierarchyPCI = new ArrayList<>();
			List<Clinic> haHierarchyClinic = new ArrayList<>();

			//mapping HealthAuthority table
			haHierarchySubmission.setHealthAuthority(root.getHealthAuthority());
			haHierarchySubmission.setSubmissionId(root.getForm().getSubmissionId());
			haHierarchySubmission.setCreatedAt(root.getForm().getCreatedAt());
			haHierarchySubmission.setSubmitterEmail(root.getForm().getEmail());
			haHierarchySubmission.setSubmissionStatus(root.getForm().getStatus());
			haHierarchySubmission.setSubmitterUserName(root.getForm().getUsername());
			haHierarchySubmission.setSubmitterFullName(root.getForm().getFullName());
			haHierarchySubmission.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
			haHierarchySubmission.setSubmissionFormName(root.getForm().getFormName());

			if(root.getCommunities() != null){
				for(CommunityData community : root.getCommunities()){
					//mapping Community Table
					Community newCommunity = new Community();
					newCommunity.setCommunityName(community.getCommunityName());
					newCommunity.setHealthAuthority(root.getHealthAuthority());
					newCommunity.setHsiarServicePlanGapAnalysis(community.getHsiarServicePlanGapAnalysis());

					Collections.addAll(haHierarchyCommunities, newCommunity);

					//mapping PrimaryCareNetwork table
					if(community.getPcn() != null){
						for(PCN pcn : community.getPcn()){
							PrimaryCareNetwork newPCN = new PrimaryCareNetwork();
							newPCN.setPcnName(pcn.getPcnName());
							newPCN.setPcnType(pcn.getPcnType());
							newPCN.setCommunityName(community.getCommunityName());

							Collections.addAll(haHierarchyPCN, newPCN);

							//mapping Clinic
							if(pcn.getPcnClinic() != null){
								for(ClinicData clinic : pcn.getPcnClinic()){
									Clinic newClinic = new Clinic();
									newClinic.setClinicName(clinic.getClinicName());
									newClinic.setClinicType(clinic.getClinicType());
									newClinic.setPcnName(pcn.getPcnName());
									if(newClinic.getClinicName() != null && !newClinic.getClinicName().isEmpty()){
										Collections.addAll(haHierarchyClinic, newClinic);
									}								
								}
							}

							//mapping PrimaryCareInitiatives table
							if(pcn.getChc() != null){
								for(CHC chc: pcn.getChc()){
									PrimaryCareInitiatives newInitiative = new PrimaryCareInitiatives();
									newInitiative.setInitiativeName(chc.getChcName());
									newInitiative.setInitiativeType("CHC");
									newInitiative.setPcnName(pcn.getPcnName());
									Collections.addAll(haHierarchyPCI, newInitiative);

									this.mapClinic(chc.getChcClinic(), chc.getChcName(), haHierarchyClinic);
								}
							}
							if(pcn.getUpcc() != null){
								for(UPCC upcc: pcn.getUpcc()){
									PrimaryCareInitiatives newInitiative = new PrimaryCareInitiatives();
									newInitiative.setInitiativeName(upcc.getUpccName());
									newInitiative.setInitiativeType("UPCC");
									newInitiative.setPcnName(pcn.getPcnName());
									newInitiative.setTypeOfCare(upcc.getTypeOfCare());
									Collections.addAll(haHierarchyPCI, newInitiative);

									this.mapClinic(upcc.getUpccClinic(), upcc.getUpccName(), haHierarchyClinic);

								}
							}
							if(pcn.getFnpcc() != null){
								for(FNPCC fnpcc: pcn.getFnpcc()){
									PrimaryCareInitiatives newInitiative = new PrimaryCareInitiatives();
									newInitiative.setInitiativeName(fnpcc.getFnpccName());
									newInitiative.setInitiativeType("FNPCC");
									newInitiative.setPcnName(pcn.getPcnName());
									Collections.addAll(haHierarchyPCI, newInitiative);

									this.mapClinic(fnpcc.getFnpccClinic(), fnpcc.getFnpccName(), haHierarchyClinic);
								
								}
							}
							if(pcn.getNppcc() != null){
								for(NPPCC nppcc: pcn.getNppcc()){
									PrimaryCareInitiatives newInitiative = new PrimaryCareInitiatives();
									newInitiative.setInitiativeName(nppcc.getNppccName());
									newInitiative.setInitiativeType("NPPCC");
									newInitiative.setPcnName(pcn.getPcnName());
									Collections.addAll(haHierarchyPCI, newInitiative);

									this.mapClinic(nppcc.getNppccClinic(), nppcc.getNppccName(), haHierarchyClinic);										
								}
							}
						}
					}
				}
			}

			haHierarchySubmission.setCommunity(haHierarchyCommunities);
			haHierarchySubmission.setPrimaryCareNetwork(haHierarchyPCN);
			haHierarchySubmission.setPrimaryCareInitiatives(haHierarchyPCI);
			haHierarchySubmission.setClinic(haHierarchyClinic);
			haHierarchySubmissions.add(haHierarchySubmission);
		}

		return haHierarchySubmissions;
	}

	private void mapClinic(List<ClinicData> clinics, String initiativeName, List<Clinic> destinationArray){
		if(clinics != null){
			for(ClinicData clinic : clinics){
				Clinic newClinic = new Clinic();
				newClinic.setClinicName(clinic.getClinicName());
				newClinic.setClinicType(clinic.getClinicType());
				newClinic.setInitiativeName(initiativeName);
	
				if(newClinic.getClinicName() != null && !newClinic.getClinicName().isEmpty()){
					Collections.addAll(destinationArray, newClinic);
				}
			}
		}
	}

}
