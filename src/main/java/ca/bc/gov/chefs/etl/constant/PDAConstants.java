package ca.bc.gov.chefs.etl.constant;

import ca.bc.gov.chefs.etl.util.FileUtil;

/**
 * Constants specific to Polysomnography Data Automation project.
 */
public class PDAConstants extends Constants {

    /** Wait Time Report Form */
    public final static String PDA_WAIT_TIME_PROPERTY = "pda.wait.time.";
    public final static String PROPERTIES_PDA_WAIT_TIME = "pda-wait-time-dir";
    public final static String PDA_WAIT_TIME_DIR = FileUtil.getDirectoryName(PROPERTIES_PDA_WAIT_TIME);
    public static final String PDA_WAIT_TIME_UNENCRYPTED_FP = FileUtil
            .buildDestinationPath(PROPERTIES_PDA_WAIT_TIME, false);
    public static final String PDA_WAIT_TIME_ENCRYPTED_FP = FileUtil.buildDestinationPath(
            PROPERTIES_PDA_WAIT_TIME,
            true);

    public final static String PDA_WAIT_TIME_SUBMISSION = "PDA_WAIT_TIME_SUBMISSION";
    public final static String PDA_WAIT_TIME_DATA = "PDA_WAIT_TIME_DATA";

    /** Facility Mapping Form */
    public final static String PDA_FACILITY_MAPPING_PROPERTY = "pda.facility.mapping.";
    public final static String PROPERTIES_PDA_FACILITY_MAPPING = "pda-facility-mapping-dir";
    public final static String PDA_FACILITY_MAPPING_DIR = FileUtil.getDirectoryName(PROPERTIES_PDA_FACILITY_MAPPING);
    public static final String PDA_FACILITY_MAPPING_UNENCRYPTED_FP = FileUtil
            .buildDestinationPath(PROPERTIES_PDA_FACILITY_MAPPING, false);
    public static final String PDA_FACILITY_MAPPING_ENCRYPTED_FP = FileUtil.buildDestinationPath(
            PROPERTIES_PDA_FACILITY_MAPPING,
            true);

    public final static String PDA_FACILITY_MAPPING_SUBMISSION = "PDA_FACILITY_MAPPING_SUBMISSION";
    public final static String PDA_FACILITY_MAPPING_DATA = "PDA_FACILITY_MAPPING_DATA";

    static {
        UNENC_FILE_PATH.put(PDA_WAIT_TIME_DIR, PDA_WAIT_TIME_UNENCRYPTED_FP);
        UNENC_FILE_PATH.put(PDA_FACILITY_MAPPING_DIR, PDA_FACILITY_MAPPING_UNENCRYPTED_FP);

        ENC_FILE_PATH.put(PDA_WAIT_TIME_DIR, PDA_WAIT_TIME_ENCRYPTED_FP);
        ENC_FILE_PATH.put(PDA_FACILITY_MAPPING_DIR, PDA_FACILITY_MAPPING_ENCRYPTED_FP);

        /** Wait Time Report Form */
        HEADERS.put(PDA_WAIT_TIME_SUBMISSION,
                new String[] { "SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME",
                        "SUBMITTER_USER_NAME", "SUBMITTER_EMAIL", "SUBMISSION_STATUS",
                        "SUBMISSION_VERSION", "SUBMISSION_FORM_NAME", "PERIOD", "FACILITY", "FISCAL_YEAR" });
        HEADERS.put(PDA_WAIT_TIME_DATA,
                new String[] { "SUBMISSION_ID", "PDA_WAIT_TIME_DATA_ID", "FACILITY", "HEALTH_AUTHORITY", "REGION",
                        "PRIORITY", "PATIENT_REF", "SLEEP_ISSUE", "REFERRAL_DATE",
                        "LEVEL_1_STUDY_DATE", "SPECIALIST_CONSULT_DATE", "CONSULT_TO_STUDY_WAIT_TIME",
                        "REFERRAL_TO_CONSULT_WAIT_TIME", "TOTAL_WAIT_TIME", "SELECT_COMMENT", "OTHER_COMMENT" });

        /** Facility Mapping Form */
        HEADERS.put(PDA_FACILITY_MAPPING_SUBMISSION,
                new String[] { "SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY", "SUBMITTER_FULL_NAME",
                        "SUBMITTER_USER_NAME", "SUBMITTER_EMAIL", "SUBMISSION_STATUS",
                        "SUBMISSION_VERSION", "SUBMISSION_FORM_NAME" });
        HEADERS.put(PDA_FACILITY_MAPPING_DATA,
                new String[] {
                        "SUBMISSION_ID", "PDA_FACILITY_MAPPING_ID", "FACILITY_NAME", "FACILITY_ID"
                });

    }

}
