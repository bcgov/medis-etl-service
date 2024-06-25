package ca.bc.gov.chefs.etl.constant;

import ca.bc.gov.chefs.etl.util.FileUtil;

/**
 * Constants specific to PCD BI Modernization project.
 */
public class PCDConstants extends Constants {
    /** General Constants */
    public static final String CATEGORY_DOFP = "Division Of Family Practice";
    public static final String CATEGORY_FAMILY_PYHSICIANS = "Family Physicians";
    public static final String CATEGORY_HEALTH_AUTHORITY = "Health Authority";
    public static final String SUB_CATEGORY_CLINICAL = "Clinical & Traditional Wellness Resources";
    public static final String SUB_CATEGORY_DOFP_RESOURCES = "DoFP Resources & Items";
    public static final String SUB_CATEGORY_FAMILY_PHYSICIAN = "Family Physician";
    public static final String SUB_CATEGORY_HEALTH_CLINICAL = "Health Clinical Traditional Wellness Resources";
    public static final String SUB_CATEGORY_ONE_TIME_FUNDING = "One-Time Funding";
    public static final String SUB_CATEGORY_OTHER_RESOURCES = "Other Resources & Items";
    public static final String SUB_CATEGORY_OVERHEAD = "Overhead";
    
    
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
	public final static String HA_HIERARCHY_PRIMARY_CARE_INITIATIVES = "HA_HIERARCHY_PRIMARY_CARE_INITIATIVE";
	public final static String HA_HIERARCHY_CLINIC = "HA_HIERARCHY_CLINIC_NAME";

	/** HR Records Form */
	public final static String PCD_HR_RECORDS_PROPERTY = "pcd.hr.records.";
	public final static String PROPERTIES_HR_RECORDS = "pcd-hr-records-dir";
	public final static String PCD_HR_RECORDS_DIR = FileUtil.getDirectoryName(PROPERTIES_HR_RECORDS);
	public static final String PCD_HR_RECORDS_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_HR_RECORDS, false);
	public static final String PCD_HR_RECORDS_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_HR_RECORDS, true);

	public final static String HR_RECORDS_SUBMISSION = "HR_RECORDS_SUBMISSION";
	public final static String HR_RECORDS_DATA = "HR_RECORDS_DATA";

	/** UPCC Budget Form */
	public final static String PCD_UPCC_BUDGET_PROPERTY = "pcd.upcc.budget.";
	public final static String PROPERTIES_PCD_UPCC_BUDGET = "pcd-upcc-budget-dir";
	public final static String PCD_UPCC_BUDGET_DIR = FileUtil.getDirectoryName(PROPERTIES_PCD_UPCC_BUDGET);
	public static final String PCD_UPCC_BUDGET_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_UPCC_BUDGET, false);
	public static final String PCD_UPCC_BUDGET_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_UPCC_BUDGET, true);

	public final static String FINANCIAL_BUDGET_UPCC = "FINANCIAL_BUDGET_UPCC";
	public final static String FINANCIAL_BUDGET_UPCC_EXPENSE = "FINANCIAL_BUDGET_UPCC_EXPENSE";
	public final static String FINANCIAL_BUDGET_UPCC_TOTALS = "FINANCIAL_BUDGET_UPCC_TOTALS";

	/** UPCC Financial Reporting Form */
	public final static String PCD_UPCC_FR_PROPERTY = "pcd.upcc.financial.reporting.";
	public final static String PROPERTIES_PCD_UPCC_FR = "pcd-upcc-financial-reporting-dir";
	public final static String PCD_UPCC_FR_DIR = FileUtil.getDirectoryName(PROPERTIES_PCD_UPCC_FR);
	public static final String PCD_UPCC_FR_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_UPCC_FR, false);
	public static final String PCD_UPCC_FR_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_UPCC_FR, true);

	public final static String FR_UPCC_SUBMISSION = "FR_UPCC_SUBMISSION";
	public final static String FR_UPCC_FINANCIAL_DATA = "FR_UPCC_FINANCIAL_DATA";
	public final static String FR_UPCC_ITEMIZED_BUDGET = "FR_UPCC_ITEMIZED_BUDGET";
	public final static String FR_UPCC_ITEMIZED_FINANCIAL_DATA = "FR_UPCC_ITEMIZED_FINANCIAL_DATA";
	public final static String FR_UPCC_FINANCIAL_TOTALS = "FR_UPCC_FINANCIAL_TOTALS";
	public final static String FR_UPCC_FINANCIAL_SUB_TOTALS = "FR_UPCC_FINANCIAL_SUB_TOTALS";

	/** PCN Budget Form */
	public final static String PCD_PCN_BUDGET_PROPERTY = "pcd.pcn.budget.";
	public final static String PROPERTIES_PCD_PCN_BUDGET = "pcd-pcn-budget-dir";
	public final static String PCD_PCN_BUDGET_DIR = FileUtil.getDirectoryName(PROPERTIES_PCD_PCN_BUDGET);
	public static final String PCD_PCN_BUDGET_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_PCN_BUDGET, false);
	public static final String PCD_PCN_BUDGET_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_PCN_BUDGET, true);

	public final static String FINANCIAL_BUDGET_PCN = "FINANCIAL_BUDGET_PCN";
	public final static String FINANCIAL_BUDGET_PCN_EXPENSE = "FINANCIAL_BUDGET_PCN_EXPENSE";
	public final static String FINANCIAL_BUDGET_PCN_TOTALS = "FINANCIAL_BUDGET_PCN_TOTALS";

	/** PCN Financial Reporting Form */
	public final static String PCD_PCN_FR_PROPERTY = "pcd.pcn.financial.reporting.";
	public final static String PROPERTIES_PCD_PCN_FR = "pcd-pcn-fiancial-reporting-dir";
	public final static String PCD_PCN_FR_DIR = FileUtil.getDirectoryName(PROPERTIES_PCD_PCN_FR);
	public static final String PCD_PCN_FR_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_PCN_FR, false);
	public static final String PCD_PCN_FR_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_PCN_FR, true);
	
	public final static String FR_PCN_SUBMISSION = "FR_PCN_SUBMISSION";
	public final static String FR_PCN_FINANCIAL_DATA = "FR_PCN_FINANCIAL_DATA";
	public final static String FR_PCN_ITEMIZED_BUDGET = "FR_PCN_ITEMIZED_BUDGET";
	public final static String FR_PCN_ITEMIZED_FINANCIAL_DATA = "FR_PCN_ITEMIZED_FINANCIAL_DATA";
	public final static String FR_PCN_FINANCIAL_TOTALS = "FR_PCN_FINANCIAL_TOTALS";

	/** Financial Expense Hierarchy Form */
	public final static String PCD_FINANCIAL_EXPENSE_PROPERTY = "pcd.financial.expense.";
	public final static String PROPERTIES_PCD_FINANCIAL_EXPENSE = "pcd-financial-expense-dir";
	public final static String PCD_FINANCIAL_EXPENSE_DIR = FileUtil.getDirectoryName(PROPERTIES_PCD_FINANCIAL_EXPENSE);
	public static final String PCD_FINANCIAL_EXPENSE_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_FINANCIAL_EXPENSE, false);
	public static final String PCD_FINANCIAL_EXPENSE_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_FINANCIAL_EXPENSE, true);

    public final static String EXPENSE_HIERARCHY_SUBMISSION = "EXPENSE_HIERARCHY_SUBMISSION";
    public final static String EXPENSE_HIERARCHY_CATEGORY = "EXPENSE_HIERARCHY_CATEGORY";
    public final static String EXPENSE_HIERARCHY_SUB_CATEGORY = "EXPENSE_HIERARCHY_SUB_CATEGORY";
    public final static String EXPENSE_HIERARCHY_ITEM = "EXPENSE_HIERARCHY_ITEM";
    public final static String EXPENSE_HIERARCHY_ITEM_SUB_TYPE = "EXPENSE_HIERARCHY_ITEM_SUB_TYPE";
	
	/** CHC Budget Form */
    public final static String PCD_CHC_BUDGET_PROPERTY = "pcd.chc.budget.";
    public final static String PROPERTIES_PCD_CHC_BUDGET = "pcd-chc-budget-dir";
    public final static String PCD_CHC_BUDGET_DIR = FileUtil.getDirectoryName(PROPERTIES_PCD_CHC_BUDGET);
    public static final String PCD_CHC_BUDGET_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_CHC_BUDGET, false);
    public static final String PCD_CHC_BUDGET_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_CHC_BUDGET, true);
    
    public final static String FINANCIAL_BUDGET_CHC = "FINANCIAL_BUDGET_CHC";
    public final static String FINANCIAL_BUDGET_CHC_EXPENSE = "FINANCIAL_BUDGET_CHC_EXPENSE";
    public final static String FINANCIAL_BUDGET_CHC_TOTALS = "FINANCIAL_BUDGET_CHC_TOTALS";
    
    /** CHC Financial Reporting Form */
    public final static String PCD_CHC_FR_PROPERTY = "pcd.chc.financial.reporting.";
    public final static String PROPERTIES_PCD_CHC_FR = "pcd-chc-financial-reporting-dir";
    public final static String PCD_CHC_FR_DIR = FileUtil.getDirectoryName(PROPERTIES_PCD_CHC_FR);
    public static final String PCD_CHC_FR_UNENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_CHC_FR, false);
    public static final String PCD_CHC_FR_ENCRYPTED_FP = FileUtil.buildDestinationPath(PROPERTIES_PCD_CHC_FR, true);

    public final static String FR_CHC_SUBMISSION = "FR_CHC_SUBMISSION";
    public final static String FR_CHC_FINANCIAL_DATA = "FR_CHC_FINANCIAL_DATA";
    public final static String FR_CHC_ITEMIZED_BUDGET = "FR_CHC_ITEMIZED_BUDGET";
    public final static String FR_CHC_ITEMIZED_FINANCIAL_DATA = "FR_CHC_ITEMIZED_FINANCIAL_DATA";
    public final static String FR_CHC_FINANCIAL_TOTALS = "FR_CHC_FINANCIAL_TOTALS";
    public final static String FR_CHC_FINANCIAL_SUB_TOTALS = "FR_CHC_FINANCIAL_SUB_TOTALS";

	static {
		UNENC_FILE_PATH.put(PCD_DECISION_LOG_DIR, PCD_DECISION_LOG_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_STATUS_TRACKER_DIR, PCD_STATUS_TRACKER_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_HA_HIERARCHY_DIR, PCD_HA_HIERARCHY_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_UPCC_BUDGET_DIR, PCD_UPCC_BUDGET_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_UPCC_FR_DIR, PCD_UPCC_FR_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_PCN_BUDGET_DIR, PCD_PCN_BUDGET_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_PCN_FR_DIR, PCD_PCN_FR_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_FINANCIAL_EXPENSE_DIR, PCD_FINANCIAL_EXPENSE_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_CHC_BUDGET_DIR, PCD_CHC_BUDGET_UNENCRYPTED_FP);
		UNENC_FILE_PATH.put(PCD_CHC_FR_DIR, PCD_CHC_FR_UNENCRYPTED_FP);
		
		ENC_FILE_PATH.put(PCD_DECISION_LOG_DIR, PCD_DECISION_LOG_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_STATUS_TRACKER_DIR, PCD_STATUS_TRACKER_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_HA_HIERARCHY_DIR, PCD_HA_HIERARCHY_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_UPCC_BUDGET_DIR, PCD_UPCC_BUDGET_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_UPCC_FR_DIR, PCD_UPCC_FR_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_PCN_BUDGET_DIR, PCD_PCN_BUDGET_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_PCN_FR_DIR, PCD_PCN_FR_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_FINANCIAL_EXPENSE_DIR, PCD_FINANCIAL_EXPENSE_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_CHC_BUDGET_DIR, PCD_CHC_BUDGET_ENCRYPTED_FP);
		ENC_FILE_PATH.put(PCD_CHC_FR_DIR, PCD_CHC_FR_ENCRYPTED_FP);

		/** Decision Log */
		HEADERS.put(DECISION_LOG_SUBMISSIONS, new String[] { 
			"SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME","SUBMITTER_USER_NAME",
			"SUBMITTER_EMAIL", "SUBMISSION_STATUS", "SUBMISSION_VERSION",
			"SUBMISSION_FORM_NAME", "HEALTH_AUTHORITY", "COMMUNITY_NAME", "TYPE_OF_INITIATIVE",
			"REQUEST_NUMBER", "SUBMITTED_DATE", "DESCRIPTION", "REQUEST_CATEGORY",
			"REQUEST_STATUS", "RECOMMENDED_DOCUMENTATION_TYPE", "OTHER_DOCUMENTS",
			"DATE_DECISION_MADE", "COMMENTS_RECOMMENDATIONS", "FINAL_DECISION_COMMENTS",
			"DECISION_MADE_BY", "FINAL_DECISION", "FINAL_DOCUMENTS_RECEIVED", "PRECEDENT_SETTING",
			"UPDATED_APPROVAL_TRACKER", "UPDATED_FINANCIAL_REPORT", "NOT_ALL_PCNS", "RSN_FOR_EXC_IN_BDGT_CHG_DT"
			});
		HEADERS.put(DECISION_LOG_CHANGE_REQUEST_FILE_UPLOAD, new String[] { 
			"ID", "URL", "SIZE","STORAGE", "ORIGINAL_NAME", "SUBMISSION_ID"
			});
		HEADERS.put(DECISION_LOG_PCN_NAMES, new String[] { 
			"SUBMISSION_ID", "PCN_NAME", "TYPE"
			});
		HEADERS.put(DECISION_LOG_COMMENTS, new String[] { 
			"SUBMISSION_ID", "COMMENT_ID", "COMMENT", "COMMENT_DATE"
			});
		HEADERS.put(DECISION_LOG_INITIATIVES, new String[] { 
			"SUBMISSION_ID", "INITIATIVE_NAME", "INITIATIVE_TYPE"
			});	

		/** HA Hierarchy */
		HEADERS.put(HA_HIERARCHY_HEALTH_AUTHORITY, new String[] { 
			"SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME", "SUBMITTER_USER_NAME", 
			"SUBMITTER_EMAIL", "SUBMISSION_STATUS", "SUBMISSION_VERSION", "SUBMISSION_FORM_NAME", "HEALTH_AUTHORITY"
			});	
		HEADERS.put(HA_HIERARCHY_COMMUNITY, new String[] { 
		    "SUBMISSION_ID", "COMMUNITY_ID", "COMMUNITY_NAME", "HSIAR_SERVICE_PLAN_GAP_ANALYSIS"
			});	
		HEADERS.put(HA_HIERARCHY_PRIMARY_CARE_NETWORK, new String[] { 
			"COMMUNITY_ID", "PRIMARY_CARE_NETWORK_ID", "PCN_NAME", "PCN_TYPE",
			});	
		HEADERS.put(HA_HIERARCHY_PRIMARY_CARE_INITIATIVES, new String[] { 
		    "PRIMARY_CARE_NETWORK_ID", "PRIMARY_CARE_INITIATIVE_ID", "INITIATIVE_NAME", "INITIATIVE_TYPE", "TYPE_OF_CARE"
			});	
		HEADERS.put(HA_HIERARCHY_CLINIC, new String[] { 
		        "PRIMARY_CARE_NETWORK_ID", "PRIMARY_CARE_INITIATIVE_ID", "CLINIC_ID", "CLINIC_NAME", "CLINIC_TYPE"
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

		/** UPCC Budget */
		HEADERS.put(FINANCIAL_BUDGET_UPCC, new String[] {
			"SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME",
			"SUBMITTER_USER_NAME", "SUBMITTER_EMAIL", "SUBMISSION_STATUS", 
			"SUBMISSION_VERSION", "SUBMISSION_FORM_NAME", "HEALTH_AUTHORITY", 
			"COMMUNITY_NAME", "FISCAL_YEAR", "UPCC_NAME"
        });

		HEADERS.put(FINANCIAL_BUDGET_UPCC_EXPENSE, new String[] {
            "SUBMISSION_ID",
            "EXPENSE_ID",
            "EXPENSE_CATEGORY",
            "EXPENSE_SUB_CATEGORY",
			"TYPE_OF_CARE",
			"EXPENSE_ITEM",
			"EXPENSE_ITEM_SUB_TYPE",
			"APPROVED_BUDGET",
			"APPROVED_FTES_INCL_RELIEF",
			"APPROVED_ATTACHMENT_TARGET"
        });

		HEADERS.put(FINANCIAL_BUDGET_UPCC_TOTALS, new String[] {
            "SUBMISSION_ID",
            "CLINICAL_APPROVED_FTES",
            "CLINICAL_APPROVED_BUDGET",
			"OVERHEAD_APPROVED_BUDGET",
			"ONE_TIME_FUNDING_APPROVED_BUDGET"
        });

		/** UPCC Financial Reporting */
		HEADERS.put(FR_UPCC_SUBMISSION, new String[] {
			"SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME",
			"SUBMITTER_USER_NAME", "SUBMITTER_EMAIL", "SUBMISSION_STATUS", 
			"SUBMISSION_VERSION", "SUBMISSION_FORM_NAME", "HEALTH_AUTHORITY", 
			"COMMUNITY_NAME", "UPCC_NAME", "FISCAL_YEAR", "PERIOD_REPORTED",
			"REASON_FOR_EXCEPTION_IN_PERIOD_REPORTED","ADDITIONAL_NOTES"
        });

		HEADERS.put(FR_UPCC_FINANCIAL_DATA, new String[] {
			"SUBMISSION_ID", "EXPENSE_ID", "APPROVED_BUDGET","APPROVED_FTES_INCL_RELIEF","EXPENSE_CATEGORY",
			"EXPENSE_SUB_CATEGORY", "EXPENSE_ITEM","EXPENSE_ITEM_SUB_TYPE", 
			"FTES_HIRED_TO_DATE","FY_EXPENSE_FORECAST","FY_ESTIMATED_SURPLUS", "FY_EXPENSE_VARIANCE",
			"FY_EXPENSE_VARIANCE_NOTE","P1","P2","P3","P4","P5","P6","P7",
			"P8","P9","P10","P11","P12","P13","PRORATED_YTD_BUDGET","TOTAL_ACTUAL_YTD_EXPENSES",
			"TYPE_OF_CARE","YTD_EXPENSE_VARIANCE","YTD_EXPENSE_VARIANCE_NOTE"
        });

		HEADERS.put(FR_UPCC_ITEMIZED_BUDGET, new String[] {
			"SUBMISSION_ID", "BUDGET_ID", "EXPENSE_CATEGORY", "EXPENSE_SUB_CATEGORY",
			"APPROVED_BUDGET", "FY_EXPENSE_VARIANCE", "PRORATED_YTD_BUDGET", "FY_ESTIMATED_SURPLUS",
			"YTD_EXPENSE_VARIANCE", "FY_EXPENSE_VARIANCE_NOTE", "YTD_EXPENSE_VARIANCE_NOTE"
        });

		HEADERS.put(FR_UPCC_ITEMIZED_FINANCIAL_DATA, new String[] {
			"BUDGET_ID", "EXPENSE_ID", "EXPENSE_ITEM", "EXPENSE_ITEM_SUBTYPE", "FY_EXPENSE_FORECAST",
			"P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "P13",
			"TOTAL_ACTUAL_YTD_EXPENSES"
        });

		HEADERS.put(FR_UPCC_FINANCIAL_TOTALS, new String[] {
			"SUBMISSION_ID", "EXPENSE_CATEGORY", "EXPENSE_SUB_CATEGORY", "APPROVED_BUDGET",
			"APPROVED_FTES_INCL_RELIEF", "FTES_HIRED_TO_DATE", "FY_EXPENSE_FORECAST", 
			 "P1", "P2", "P3", "P4", "P5", "P6",
			"P7", "P8", "P9", "P10", "P11", "P12", "P13"

        });

		HEADERS.put(FR_UPCC_FINANCIAL_SUB_TOTALS, new String[] {
			"SUBMISSION_ID", "EXPENSE_CATEGORY", "EXPENSE_SUB_CATEGORY", "TYPE_OF_CARE",
			"APPROVED_BUDGET", "FTES_HIRED_TO_DATE", "FY_EXPENSE_FORECAST", "FY_EXPENSE_VARIANCE",
			"FY_ESTIMATED_SURPLUS", "PRORATED_YTD_BUDGET", "YTD_EXPENSE_VARIANCE", 
			"APPROVED_FTES_INCL_RELIEF", "TOTAL_ACTUAL_YTD_EXPENSE", "P1", "P2", "P3", "P4",
			"P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "P13"
        });

		/** PCN Budget */
		HEADERS.put(FINANCIAL_BUDGET_PCN, new String[] {
			"SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME",
			"SUBMITTER_USER_NAME", "SUBMITTER_EMAIL", "SUBMISSION_STATUS", 
			"SUBMISSION_VERSION", "SUBMISSION_FORM_NAME", "HEALTH_AUTHORITY", 
			"COMMUNITY_NAME", "FISCAL_YEAR"
        });

		HEADERS.put(FINANCIAL_BUDGET_PCN_EXPENSE, new String[] {
			"SUBMISSION_ID", 
			"EXPENSE_ID", 
			"EXPENSE_CATEGORY", 
			"EXPENSE_SUB_CATEGORY", 
			"EXPENSE_ITEM", 
			"EXPENSE_ITEM_SUBTYPE", 
			"TOTAL_BUDGET_ALLOCATION", 
			"ANNUAL_BUDGET", 
			"FTES_INCL_RELIEF", 
			"APPROVED_4_YEARS_FTES", 
			"FISCAL_YEAR_ALLOCATION",
			"APPROVED_ATTACHMENT_TARGET"
        });

		HEADERS.put(FINANCIAL_BUDGET_PCN_TOTALS, new String[] {
			"SUBMISSION_ID",
			"CLINICAL_APPROVED_FTES",
			"CLINICAL_APPROVED_BUDGET",
			"CLINICAL_FISCAL_YEAR_FTES",
			"CLINICAL_BUDGET_ALLOCATION",
			"DOFP_RESOURCES_APPROVED_FTES",
			"DOFP_RESOURCES_APPROVED_BUDGET",
			"DOFP_RESOURCES_FISCAL_YEAR_FTES",
			"DOFP_RESOURCES_ALLOCATION",
			"PHYSICIAN_APPROVED_FTES",
			"PHYSICIAN_APPROVED_BUDGET",
			"PHYSICIAN_FISCAL_YEAR_FTES",
			"PHYSICIAN_BUDGET_ALLOCATION",
			"OVERHEAD_APPROVED_BUDGET",
			"OVERHEAD_BUDGET_ALLOCATION",
			"OVERHEAD_DOFP_APPROVED_BUDGET",
			"OVERHEAD_DOFP_BUDGET_ALLOCATION",
			"ONE_TIME_FUNDING_BUDGET_ALLOCATION",
			"ONE_TIME_FUNDING_DOFP_ALLOCATION"			
        });

		/** PCN Financial Reporting */
		HEADERS.put(FR_PCN_SUBMISSION, new String[] {
			"SUBMISSION_ID",
			"CREATED_AT",
			"LATE_ENTRY",
			"SUBMITTER_FULL_NAME",
			"SUBMITTER_USER_NAME",
			"SUBMITTER_EMAIL",
			"SUBMISSION_STATUS",
			"SUBMISSION_VERSION",
			"SUBMISSION_FORM_NAME",
			"HEALTH_AUTHORITY",
			"COMMUNITY_NAME",
			"FISCAL_YEAR",
			"PERIOD_REPORTED",
			"REASON_FOR_EXCEPTION_PERIOD_REPORTED",
			"ADDITIONAL_NOTES"			
		});
		
		HEADERS.put(FR_PCN_FINANCIAL_DATA, new String[] {
			"SUBMISSION_ID",
			"EXPENSE_ID",
			"ANNUAL_BUDGET",
			"APPROVED_4_YEAR_FTES",
			"FTES_INCL_RELIEF",
			"EXPENSE_CATEGORY",
			"EXPENSE_SUB_CATEGORY",
			"EXPENSE_ITEM",
			"EXPENSE_ITEM_SUBTYPE",
			"FTES_HIRED_TO_DATE",
			"FY_EXPENSE_FORECAST",
			"FY_ESTIMATED_SURPLUS",
			"FY_EXPENSE_VARIANCE",
			"FY_EXPENSE_VARIANCE_NOTE",
			"P1",
			"P2",
			"P3",
			"P4",
			"P5",
			"P6",
			"P7",
			"P8",
			"P9",
			"P10",
			"P11",
			"P12",
			"P13",
			"PRORATED_YTD_BUDGET",
			"TOTAL_ACTUAL_YTD_EXPENSES",
			"TOTAL_BUDGET_ALLOCATION",
			"YTD_EXPENSE_VARIANCE",
			"YTD_EXPENSE_VARIANCE_NOTE",
			"FISCAL_YEAR_ALLOCATION"		
		});

		HEADERS.put(FR_PCN_ITEMIZED_BUDGET, new String[] {
			"SUBMISSION_ID",
			"BUDGET_ID",
			"EXPENSE_CATEGORY",
			"EXPENSE_SUB_CATEGORY",
			"EXPENSE_ITEM",
			"TOTAL_BUDGET_ALLOCATION",
			"FY_EXPENSE_VARIANCE",
			"PRORATED_YTD_BUDGET",
			"FY_ESTIMATED_SURPLUS",
			"YTD_EXPENSE_VARIANCE",
			"FY_EXPENSE_VARIANCE_NOTE",
			"YTD_EXPENSE_VARIANCE_NOTE",
			"ANNUAL_BUDGET",
			"FISCAL_YEAR_ALLOCATION",
			"FY_EXPENSE_FORECAST"			
		});

		HEADERS.put(FR_PCN_ITEMIZED_FINANCIAL_DATA, new String[] {
			"BUDGET_ID",
			"EXPENSE_ID",
			"EXPENSE_ITEM",
			"EXPENSE_ITEM_SUBTYPE",
			"FY_EXPENSE_FORECAST",
			"P1",
			"P2",
			"P3",
			"P4",
			"P5",
			"P6",
			"P7",
			"P8",
			"P9",
			"P10",
			"P11",
			"P12",
			"P13",
			"TOTAL_ACTUAL_YTD_EXPENSES",
			"OTHER_ITEMS",
			"TYPES_OF_TRAINING",
			"LIST_OF_ROLES_TITLES"			
		});

		HEADERS.put(FR_PCN_FINANCIAL_TOTALS, new String[] {
			"SUBMISSION_ID",
			"EXPENSE_CATEGORY",
			"EXPENSE_SUB_CATEGORY",
			"APPROVED_BUDGET",
			"APPROVED_4_YEAR_FTES",
			"FTES_HIRED_TO_DATE",
			"FY_EXPENSE_FORECAST",
	        "TOTAL_BUDGET_ALLOCATION",
			"P1",
			"P2",
			"P3",
			"P4",
			"P5",
			"P6",
			"P7",
			"P8",
			"P9",
			"P10",
			"P11",
			"P12",
			"P13",			
		});
		
		/** Financial Expense Hierarchy */
		HEADERS.put(EXPENSE_HIERARCHY_SUBMISSION, new String[] {
			"SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME",
			"SUBMITTER_USER_NAME", "SUBMITTER_EMAIL", "SUBMISSION_STATUS", 
			"SUBMISSION_VERSION", "SUBMISSION_FORM_NAME"
        });

		HEADERS.put(EXPENSE_HIERARCHY_CATEGORY, new String[] {
			"SUBMISSION_ID", "EXPENSE_CATEGORY_ID", "INITIATIVE_TYPE", "EXPENSE_CATEGORY"
        });

		HEADERS.put(EXPENSE_HIERARCHY_SUB_CATEGORY, new String[] {
			"EXPENSE_CATEGORY_ID", "EXPENSE_SUB_CATEGORY_ID", "EXPENSE_SUB_CATEGORY"
        });

		HEADERS.put(EXPENSE_HIERARCHY_ITEM, new String[] {
			"EXPENSE_SUB_CATEGORY_ID", "EXPENSE_ITEM_ID", "EXPENSE_ITEM",
			"RESOURCE_CATEGORY", "POSITION_TYPE", "TYPE_OF_CARE"
        });
		HEADERS.put(EXPENSE_HIERARCHY_ITEM_SUB_TYPE, new String[] {
			"EXPENSE_ITEM_ID", "EXPENSE_ITEM_SUB_TYPE"
        });
		
	    /** CHC Budget */
        HEADERS.put(FINANCIAL_BUDGET_CHC, new String[] {
            "SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME",
            "SUBMITTER_USER_NAME", "SUBMITTER_EMAIL", "SUBMISSION_STATUS", 
            "SUBMISSION_VERSION", "SUBMISSION_FORM_NAME", "HEALTH_AUTHORITY", 
            "COMMUNITY_NAME", "FISCAL_YEAR", "CHC_NAME"
        });

        HEADERS.put(FINANCIAL_BUDGET_CHC_EXPENSE, new String[] {
            "SUBMISSION_ID",
            "EXPENSE_ID",
            "EXPENSE_CATEGORY",
            "EXPENSE_SUB_CATEGORY",
            "EXPENSE_ITEM",
            "EXPENSE_ITEM_SUB_TYPE",
            "APPROVED_BUDGET",
            "APPROVED_FTES",           
            "APPROVED_ATTACHMENT_TARGET"
        });
        
        HEADERS.put(FINANCIAL_BUDGET_CHC_TOTALS, new String[] {
                "SUBMISSION_ID",
                "CLINICAL_APPROVED_FTES",
                "CLINICAL_APPROVED_BUDGET",
                "OVERHEAD_APPROVED_BUDGET",
                "OTHER_RESOURCES_APPROVED_FTES",
                "OTHER_RESOURCES_APPROVED_BUDGET",
                "ONE_TIME_FUNDING_APPROVED_BUDGET"
            });
        
        /** CHC Financial Reporting */
        HEADERS.put(FR_CHC_SUBMISSION, new String[] {
            "SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME",
            "SUBMITTER_USER_NAME", "SUBMITTER_EMAIL", "SUBMISSION_STATUS", 
            "SUBMISSION_VERSION", "SUBMISSION_FORM_NAME", "HEALTH_AUTHORITY", 
            "COMMUNITY_NAME", "CHC_NAME", "FISCAL_YEAR", "PERIOD_REPORTED",
            "REASON_FOR_EXCEPTION_IN_PERIOD_REPORTED","ADDITIONAL_NOTES"
        });


        HEADERS.put(FR_CHC_FINANCIAL_DATA, new String[] {
            "SUBMISSION_ID", "EXPENSE_ID","EXPENSE_CATEGORY","EXPENSE_SUB_CATEGORY", "EXPENSE_ITEM",
            "EXPENSE_ITEM_SUB_TYPE", "APPROVED_BUDGET", "APPROVED_FTES",
            "FTES_HIRED_TO_DATE","FY_EXPENSE_FORECAST","FY_ESTIMATED_SURPLUS", "FY_EXPENSE_VARIANCE",
            "FY_EXPENSE_VARIANCE_NOTE","PRORATED_YTD_BUDGET","TOTAL_ACTUAL_YTD_EXPENSES",
            "YTD_EXPENSE_VARIANCE","YTD_EXPENSE_VARIANCE_NOTE","P1","P2","P3","P4","P5","P6","P7",
            "P8","P9","P10","P11","P12","P13"
        });

        HEADERS.put(FR_CHC_ITEMIZED_BUDGET, new String[] {
            "SUBMISSION_ID", "BUDGET_ID", "EXPENSE_CATEGORY", "EXPENSE_SUB_CATEGORY",
            "APPROVED_BUDGET", "FY_EXPENSE_VARIANCE", "PRORATED_YTD_BUDGET", "FY_ESTIMATED_SURPLUS",
            "YTD_EXPENSE_VARIANCE", "FY_EXPENSE_VARIANCE_NOTE", "YTD_EXPENSE_VARIANCE_NOTE"
        });

        HEADERS.put(FR_CHC_ITEMIZED_FINANCIAL_DATA, new String[] {
            "BUDGET_ID", "EXPENSE_ID", "EXPENSE_ITEM", "EXPENSE_ITEM_SUBTYPE", "FY_EXPENSE_FORECAST",
            "TOTAL_ACTUAL_YTD_EXPENSES", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "P13",
            
        });
        
        HEADERS.put(FR_CHC_FINANCIAL_TOTALS, new String[] {
            "SUBMISSION_ID", "EXPENSE_CATEGORY", "EXPENSE_SUB_CATEGORY", "APPROVED_BUDGET", "APPROVED_FTES",
            "FTES_HIRED_TO_DATE", "FY_EXPENSE_FORECAST", "P1", "P2", "P3", "P4", "P5", "P6",
            "P7", "P8", "P9", "P10", "P11", "P12", "P13"

        });

	}
}
