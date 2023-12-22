package ca.bc.gov.chefs.etl.constant;

import ca.bc.gov.chefs.etl.util.FileUtil;

/**
 * Constants specific to PCD BI Modernization project.
 */
public class PCDConstants extends Constants {
 	/** Decision Log Form */
	public final static String PCD_DECISION_LOG_PROPERTY = "pcd.decision.log.";
	public final static String PROPERTIES_PCD_DECISION_LOG = "pcd-decision-log-dir";
	public final static String PCD_DECISION_LOG_DIR = FileUtil.getDirectoryName(PROPERTIES_PCD_DECISION_LOG);
	public static final String PCD_DECISION_LOG_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_DECISION_LOG, false);
	public static final String PCD_DECISION_LOG_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_DECISION_LOG, true);
	
	public final static String DECISION_LOG_SUBMISSIONS = "DECISION_LOG_SUBMISSIONS";
	public final static String DECISION_LOG_CHANGE_REQUEST_FILE_UPLOAD = "DECISION_LOG_CHANGE_REQUEST_FILE_UPLOAD";
	public final static String DECISION_LOG_PCN_NAMES = "DECISION_LOG_PCN_NAMES";
	public final static String DECISION_LOG_COMMENTS = "DECISION_LOG_COMMENTS";
	public final static String DECISION_LOG_INITIATIVES = "DECISION_LOG_INITIATIVES";
	
	/** Status Tracker Form */
	public final static String PCD_STATUS_TRACKER_PROPERTY = "pcd.status_tracker.";
    public final static String PROPERTIES_PCD_STATUS_TRACKER_DIR = "pcd-status-tracker-dir";
    public final static String PCD_STATUS_TRACKER_DIR = FileUtil.getDirectoryName(PROPERTIES_PCD_STATUS_TRACKER_DIR);
    public static final String PCD_STATUS_TRACKER_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_STATUS_TRACKER_DIR, false);
    public static final String PCD_STATUS_TRACKER_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_STATUS_TRACKER_DIR, true);

    public final static String PCD_STATUS_TRACKER_SUBMISSION = "PCD_STATUS_TRACKER_SUBMISSION";
    public final static String PCD_STATUS_TRACKER_PCN_NAME = "PCD_STATUS_TRACKER_PCN_NAME";
    public final static String PCD_STATUS_TRACKER_ISSUE_AND_RISK = "PCD_STATUS_TRACKER_ISSUE_AND_RISK";
    public final static String PCD_STATUS_TRACKER_ISSUE_AND_RISK_TYPE = "PCD_STATUS_TRACKER_ISSUE_AND_RISK_TYPE";
    public static final String PCD_STATUS_TRACKER_CLINIC_NAME = "PCD_STATUS_TRACKER_CLINIC_NAME";   

	/** HA Hierarchy Form */
	public final static String PCD_HA_HIERARCHY_PROPERTY = "pcd.ha.hierarchy.";
	public final static String PROPERTIES_HA_HIERARCHY = "pcd-ha-hierarchy-dir";
	public final static String PCD_HA_HIERARCHY_DIR = FileUtil.getDirectoryName(PROPERTIES_HA_HIERARCHY);
	public static final String PCD_HA_HIERARCHY_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_HA_HIERARCHY, false);
	public static final String PCD_HA_HIERARCHY_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_HA_HIERARCHY, true);

	public final static String HA_HIERARCHY_HEALTH_AUTHORITY = "HA_HIERARCHY_HEALTH_AUTHORITY";
	public final static String HA_HIERARCHY_COMMUNITY = "HA_HIERARCHY_COMMUNITY";
	public final static String HA_HIERARCHY_PRIMARY_CARE_NETWORK = "HA_HIERARCHY_PRIMARY_CARE_NETWORK";
	public final static String HA_HIERARCHY_PRIMARY_CARE_INITIATIVES = "HA_HIERARCHY_PRIMARY_CARE_INITIATIVES";

	static {
		UNENC_FILE_PATH.put(PCD_DECISION_LOG_DIR, PCD_DECISION_LOG_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_STATUS_TRACKER_DIR, PCD_STATUS_TRACKER_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_HA_HIERARCHY_DIR, PCD_HA_HIERARCHY_UNENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_DECISION_LOG_DIR, PCD_DECISION_LOG_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_STATUS_TRACKER_DIR, PCD_STATUS_TRACKER_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_HA_HIERARCHY_DIR, PCD_HA_HIERARCHY_ENCRYPTED_FP);

		/** Decision Log */
		HEADERS.put(DECISION_LOG_SUBMISSIONS, new String[] { 
			"SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME","SUBMITTER_USER_NAME",
			"SUBMITTER_EMAIL", "SUBMISSION_STATUS", "SUBMISSION_VERSION",
			"SUBMISSION_FORM_NAME", "HEALTH_AUTHORITY", "COMMUNITY_NAME", "TYPE_OF_INITIATIVE",
			"REQUEST_NUMBER", "SUBMITTED_DATE", "DESCRIPTION", "REQUEST_CATEGORY",
			"REQUEST_STATUS", "RECOMMENDED_DOCUMENTATION_TYPE", "OTHER_DOCUMENTS",
			"DATE_DECISION_MADE", "COMMENTS_RECOMMENDATIONS", "FINAL_DECISION_COMMENTS",
			"DECISION_MADE_BY", "FINAL_DECISION", "FINAL_DOCUMENTS_RECEIVED", "PRECEDENT_SETTING",
			"UPDATED_APPROVAL_TRACKER", "UPDATED_FINANCIAL_REPORT", "NOT_ALL_PCNS"
			});
		HEADERS.put(DECISION_LOG_CHANGE_REQUEST_FILE_UPLOAD, new String[] { 
			"ID", "URL", "SIZE","STORAGE", "ORIGINAL_NAME", "SUBMISSION_ID"
			});
		HEADERS.put(DECISION_LOG_PCN_NAMES, new String[] { 
			"SUBMISSION_ID", "PCN_NAME", "TYPE"
			});
		HEADERS.put(DECISION_LOG_COMMENTS, new String[] { 
			"SUBMISSION_ID", "COMMENT", "COMMENT_DATE"
			});
		HEADERS.put(DECISION_LOG_INITIATIVES, new String[] { 
			"SUBMISSION_ID", "INITIATIVE_NAME", "INITIATIVE_TYPE"
			});	

		/** HA Hierarchy */
		HEADERS.put(HA_HIERARCHY_HEALTH_AUTHORITY, new String[] { 
			"HEALTH_AUTHORITY", "SUBMISSION_ID", "CREATED_AT","SUBMITTER_EMAIL", "SUBMISSION_STATUS",
			"SUBMITTER_USER_NAME","SUBMITTER_FULL_NAME","SUBMISSION_VERSION", "SUBMISSION_FORM_NAME"
			});	
		HEADERS.put(HA_HIERARCHY_COMMUNITY, new String[] { 
			"COMMUNITY_NAME", "HEALTH_AUTHORITY", "HSIAR_SERVICE_PLAN_GAP_ANALYSIS"
			});	
		HEADERS.put(HA_HIERARCHY_PRIMARY_CARE_NETWORK, new String[] { 
			"PCN_NAME", "PCN_TYPE", "COMMUNITY_NAME"
			});	
		HEADERS.put(HA_HIERARCHY_PRIMARY_CARE_INITIATIVES, new String[] { 
			"INITIATIVE_NAME", "INITIATIVE_TYPE", "PCN_NAME","TYPE_OF_CARE"
			});	
		
		/** Status Tracker */
        HEADERS.put(PCD_STATUS_TRACKER_SUBMISSION, new String[] {
            // Form/Submission fields
            "SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME", "SUBMITTER_USER_NAME", "SUBMITTER_EMAIL",
            "SUBMISSION_STATUS","SUBMISSION_VERSION", "SUBMISSION_FORM_NAME",
            // Header fields
            "TYPE_OF_INITIATIVE", "HEALTH_AUTHORITY", "COMMUNITY_NAME",
            // PCN
            "ALL_CLINICS_IMPACTED","HSIAR_SERVICE_PLAN_GAP_ANALYSIS", "PCN_FORECASTED_IMPLEMENTATION_DATE","OTHER_PCIS_INCLUDED",
            // UPCC
            "UPCC_NAME", "UPCC_TYPE_OF_CARE", "UPCC_COVID_TEST_SITE", "UPCC_CHANGES_TO_SERVICE", "UPCC_CHANGES_TO_SERVICE_DATE", "UPCC_SERVICE_DELIVERY_MODE",
            // CHC
            "CHC_NAME", "CHC_ADDRESS", "CHC_KEY_ATTRIBUTES", "CHC_FUNDING_SOURCES",
            // FNPCC
            "FNPCC_NAME", "FNPCC_FORECASTED_IMPLEMENTATION_DATE","FNPCC_IMPLEMENTATION_TYPE", "FNPCC_ADDRESS", "FNPCC_FIRST_NATION_ORGANIZATION_LEAD", "FNPCC_ADDITIONAL_DETAILS",
            // NPPCC
            "NPPCC_NAME", "NPPCC_ADDRESS", "NPPCC_KEY_ATTRIBUTES", "NPPCC_FUNDING_SOURCES_AND_PARTNERSHIP_STRUCTURE",
            // Status
            "CURRENT_FISCAL_YEAR", "INITIATIVE_STATUS", "PHASE", "STATUS_UPDATE",
            // Implementation Dates
            "EOI_SUBMISSION_DATE", "EOI_APPROVAL_DATE", "SP_SUBMISSION_DATE", "SP_APPROVAL_DATE", "IMPLEMENTATION_DATE", "ANNOUNCEMENT_PENDING", "ANNOUNCEMENT_DATE",
            "TARGET_OPENING_DATE", "ACTUAL_OPENING_DATE", "SCALE_UP_RESOURCES", "OPEN_DATE_FOR_SCALE_UP_RESOURCES", "REASON_FOR_DELAY", "REASON_FOR_EXCEPTION",
            // Issues and/or Risks
            "ANY_ISSUES_RISKS"
        });

        HEADERS.put(PCD_STATUS_TRACKER_PCN_NAME, new String[] {
            "SUBMISSION_ID",
            "PCN_NAME",
            "TYPE"
        });
        
        HEADERS.put(PCD_STATUS_TRACKER_CLINIC_NAME, new String[] {
            "SUBMISSION_ID", "CLINIC_NAME"
        });

        HEADERS.put(PCD_STATUS_TRACKER_ISSUE_AND_RISK, new String[] {
            "SUBMISSION_ID",
            "ISSUE_ID",
            "ISSUE_RAISED_DATE",
            "RELEVANT_SITES",
            "ISSUE_CLOSED_DATE",
            "RISK_CATEGORY",
            "ISSUE_AND_RISK",
            "DATE_MITIGATION_PLAN_COMMENCES",
            "MITIGATION_STRATEGY",
            "ISSUES_NOTES",
        });

        HEADERS.put(PCD_STATUS_TRACKER_ISSUE_AND_RISK_TYPE, new String[] {
            "ISSUE_ID",
            "TYPE_OF_ISSUE"
        });
	}
}
