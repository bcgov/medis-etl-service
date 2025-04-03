package ca.bc.gov.chefs.etl.constant;

import ca.bc.gov.chefs.etl.util.FileUtil;

/**
 * Constants specific to Polysomnography Data Automation project.
 */
public class POLYConstants extends Constants {

    /* Public Encryption Key - POLY */
    public final static String POLY_PUBLIC_KEY_NAME_PROPERTY = "poly-public-key-file-name";
    public final static String POLY_PUBLIC_KEY_PATH = FileUtil.buildPublicKeyPath(POLY_PUBLIC_KEY_NAME_PROPERTY);

    /** Wait Time Report Form */
    public final static String POLY_WAIT_TIME_PROPERTY = "poly.wait.time.";
    public final static String PROPERTIES_POLY_WAIT_TIME = "poly-wait-time-dir";

    public final static String POLY_WAIT_TIME_DIR = FileUtil.getDirectoryName(PROPERTIES_POLY_WAIT_TIME);
    public static final String POLY_WAIT_TIME_UNENCRYPTED_FP = FileUtil
            .buildDestinationPath(PROPERTIES_POLY_WAIT_TIME, false);
    public static final String POLY_WAIT_TIME_ENCRYPTED_FP = FileUtil
            .buildDestinationPath(PROPERTIES_POLY_WAIT_TIME, true);

    public final static String POLY_WAIT_TIME_SUBMISSION = "POLY_WAIT_TIME_SUBMISSION";
    public final static String POLY_WAIT_TIME_DATA = "POLY_WAIT_TIME_DATA";
    public final static String POLY_WAIT_TIME_DATA_MANUAL = "POLY_WAIT_TIME_DATA_MANUAL";

    static {
        UNENC_FILE_PATH.put(POLY_WAIT_TIME_DIR, POLY_WAIT_TIME_UNENCRYPTED_FP);

        ENC_FILE_PATH.put(POLY_WAIT_TIME_DIR, POLY_WAIT_TIME_ENCRYPTED_FP);

        /** Wait Time Report Form */
        HEADERS.put(POLY_WAIT_TIME_SUBMISSION, new String[] { "SUBMISSION_ID", "CREATED_AT", "LATE_ENTRY",
                "SUBMITTER_FULL_NAME", "SUBMITTER_USER_NAME", "SUBMITTER_EMAIL", "SUBMISSION_STATUS",
                "SUBMISSION_VERSION", "SUBMISSION_FORM_NAME", "PERIOD", "FACILITY", "FISCAL_YEAR" });
        HEADERS.put(POLY_WAIT_TIME_DATA,
                new String[] { "SUBMISSION_ID", "POLY_WAIT_TIME_DATA_ID", "FACILITY",
                        "HEALTH_AUTHORITY", "REGION", "PRIORITY", "PATIENT_REF", "SLEEP_ISSUE",
                        "REFERRAL_DATE",
                        "LEVEL_1_STUDY_DATE", "SPECIALIST_CONSULT_DATE",
                        "CONSULT_TO_STUDY_WAIT_TIME", "REFERRAL_TO_CONSULT_WAIT_TIME",
                        "TOTAL_WAIT_TIME", "SELECT_COMMENT",
                        "OTHER_COMMENT" });
        HEADERS.put(POLY_WAIT_TIME_DATA_MANUAL, new String[] { "FISCAL_YEAR", "PERIOD", "FACILITY_ID", "ORIGIN",
                "REFERRAL_DATE", "CONSULT_DATE", "ISSUE", "PRIORITY", "STUDY_DATE",
                "REFERRAL_TO_CONSULT_WAIT_TIME", "CONSULT_TO_STUDY_WAIT_TIME", "TOTAL_WAIT_TIME" });

    }

}
