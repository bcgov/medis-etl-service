package ca.bc.gov.chefs.etl.forms.pcd.statusTracker.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.json.RootClinicName;
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
    
//    static PropertyMap<Root, StatusTrackerSubmission> statusTrackerMap = new PropertyMap<Root, StatusTrackerSubmission>() {
//        protected void configure() {
//          //map().setStreet(source.getAddress().getStreet());
//          map(source.getForm().getConfirmationId(), destination.getConfirmationId());
//          
////          
////          hiStatusTracker.setConfirmationId(form.getConfirmationId());
////          hiStatusTracker.setCreatedAt(form.getCreatedAt());
////          hiStatusTracker.setLateEntry(root.getLateEntry());
////          hiStatusTracker.setSubmitterFullName(form.getFullName());
////          hiStatusTracker.setSubmitterUserName(form.getUsername());
////          hiStatusTracker.setSubmitterEmail(form.getEmail());
////          hiStatusTracker.setSubmissionStatus(form.getStatus());
////          // TODO What value is the version?
////          hiStatusTracker.setSubmissionVersion(Integer.toString(form.getVersion()));
////          hiStatusTracker.setSubmissionFormName(form.getFormName());
//
//        }
//      };

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		
		// TODO Handle embedded quotes
		
		// TODO Is this required
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

		for (Root root : statusTracker) {
			// Use ModelMapper to handle the basic conversion
			ModelMapper modelMapper = new ModelMapper();

			// Define nested mappings
			modelMapper.typeMap(Root.class, StatusTrackerSubmission.class).addMappings(mapper -> {
			    mapper.map(src -> src.getForm().getConfirmationId(),
			        StatusTrackerSubmission::setConfirmationId);
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
//			
//			modelMapper.typeMap(RootIssueAndRisk.class, IssueAndRisk.class).addMappings(mapper -> {
//			    mapper.map(src -> src.getSubmissionId()),
//                        StatusTrackerSubmission::setSubmissionFormName);
//			});
			
			StatusTrackerSubmission hiStatusTracker = modelMapper.map(root, StatusTrackerSubmission.class);

            // Handle PCN Names            
	        List<PCNName> pcnNames = new ArrayList<>();
			if (root.getPcnNameWithType() != null) {
				pcnNames.add(convertPCNName(root.getForm().getSubmissionId(), root.getPcnNameWithType()));				
			}
			if (root.getPcnNamesWithType() != null) {
			    for (RootPCNNameWithType pcnNameWithType: root.getPcnNamesWithType()) {
			        pcnNames.add(convertPCNName(root.getForm().getSubmissionId(), pcnNameWithType));    
			    }
			}
			if (!pcnNames.isEmpty()) {
			    hiStatusTracker.setPcnNames(pcnNames);    
			}
			
			// Handle Clinic Names
			List<ClinicName> clinicNames = new ArrayList<>();
			if (root.getClinicNames() != null) {
			    for (RootClinicName clinic: root.getClinicNames()) {
			        ClinicName clinicName = modelMapper.map(clinic, ClinicName.class);
			        clinicNames.add(clinicName);
			    }
			    hiStatusTracker.setClinicNames(clinicNames);;
			}

			// Issues And Risks
	         List<IssueAndRisk> issuesAndRisks = new ArrayList<>();
			if (root.getIssuesAndRisks() != null) {
				for (RootIssueAndRisk issue : root.getIssuesAndRisks()) {
				    IssueAndRisk issueAndRisk = modelMapper.map(issue, IssueAndRisk.class);
				    
					// generate issueID
					String issueId = UUID.randomUUID().toString();
					issueAndRisk.setIssueId(issueId);

					// Handle IssueAndRiskTypes
					List<IssueAndRiskType> issueAndRiskTypes = new ArrayList<IssueAndRiskType>();
					for (String issueType : issue.getTypeOfIssue()) {
					    IssueAndRiskType issueAndRiskType = modelMapper.map(issueType, IssueAndRiskType.class);
						issueAndRiskTypes.add(issueAndRiskType);
					}
					issueAndRisk.setTypeOfIssue(issueAndRiskTypes);

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
