package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.RootIssueAndRisk;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.RootPCNNameWithType;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.ClinicName;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.IssueAndRisk;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.IssueAndRiskType;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.PCNName;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.model.StatusTrackerSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class StatusTrackerFormApiResponseProcessor implements Processor {
    
    private static final String INITIATIVE_TYPE_PCN = "PCN";

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

		boolean isHeaderAdded = (boolean) exchange.getProperties().get(PCDConstants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map,PCDConstants.PCD_STATUS_TRACKER_DIR, isHeaderAdded);

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
            mapper.map(src -> src.getForm().getCreatedAt(),
                    StatusTrackerSubmission::setCreatedAt);
            mapper.map(src -> src.getForm().getFullName(),
                    StatusTrackerSubmission::setSubmitterFullName);
            mapper.map(src -> src.getForm().getUsername(),
                    StatusTrackerSubmission::setSubmitterUserName);
            mapper.map(src -> src.getForm().getEmail(),
                    StatusTrackerSubmission::setSubmitterEmail);
            mapper.map(src -> src.getForm().getStatus(),
                    StatusTrackerSubmission::setSubmissionStatus);
            mapper.map(src -> src.getForm().getVersion(),
                    StatusTrackerSubmission::setSubmissionVersion);
            mapper.map(src -> src.getForm().getFormName(),
                    StatusTrackerSubmission::setSubmissionFormName);
          });
		
		for (Root root : statusTracker) {
			
			StatusTrackerSubmission hiStatusTracker = modelMapper.map(root, StatusTrackerSubmission.class);

            // Handle PCN Names   
	        List<PCNName> pcnNames = new ArrayList<>();
	        // PCN has multiple
	        if (StringUtils.equals(root.getTypeOfInitiative(), INITIATIVE_TYPE_PCN)) {
	            if (root.getPcnNamesWithType() != null) {
	                for (RootPCNNameWithType pcnNameWithType: root.getPcnNamesWithType()) {
	                    pcnNames.add(convertPCNName(root.getForm().getSubmissionId(), pcnNameWithType));    
	                }
	            }    
	        } else {
	            // Others have single
	            if (root.getPcnNameWithType() != null) {
	                pcnNames.add(convertPCNName(root.getForm().getSubmissionId(), root.getPcnNameWithType()));              
	            }	            
	        }
			hiStatusTracker.setPcnNames(pcnNames);    
			
			// Handle Clinic Names
			List<ClinicName> clinicNames = new ArrayList<>();
			if (root.getClinicNames() != null) {
			    for (String clinic: root.getClinicNames()) {
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
				    
					// generate issueID
					String issueId = UUID.randomUUID().toString();
					issueAndRisk.setIssueId(issueId);

					// Handle IssueAndRiskTypes
					List<IssueAndRiskType> issueAndRiskTypes = new ArrayList<IssueAndRiskType>();
					for (String issueType : issue.getTypeOfIssue()) {
					    IssueAndRiskType issueAndRiskType = new IssueAndRiskType();
					    issueAndRiskType.setIssueId(issueId);
					    issueAndRiskType.setTypeOfIssue(issueType);
						issueAndRiskTypes.add(issueAndRiskType);
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
