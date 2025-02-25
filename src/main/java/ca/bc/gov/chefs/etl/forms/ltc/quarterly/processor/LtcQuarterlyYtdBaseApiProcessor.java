package ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class LtcQuarterlyYtdBaseApiProcessor extends BaseApiProcessor{

	public LtcQuarterlyYtdBaseApiProcessor() {
		this.formPropertyName = Constants.LTC_YTD_PROPERTY;
	}
}
