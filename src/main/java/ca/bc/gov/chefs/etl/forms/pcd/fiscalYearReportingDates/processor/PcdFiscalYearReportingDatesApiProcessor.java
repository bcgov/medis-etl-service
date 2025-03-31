package ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.processor;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PcdFiscalYearReportingDatesApiProcessor extends BaseApiProcessor {
    public PcdFiscalYearReportingDatesApiProcessor() {
        this.formPropertyName = PCDConstants.PCD_FISCAL_YEAR_REPORTING_DATES_PROPERTY;
    }
}