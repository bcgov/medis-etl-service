package ca.bc.gov.chefs.etl.forms.pda.facilityMapping.processor;

import ca.bc.gov.chefs.etl.constant.PDAConstants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class PdaFacilityMappingApiProcessor extends BaseApiProcessor {
    public PdaFacilityMappingApiProcessor() {
        this.formPropertyName = PDAConstants.PDA_FACILITY_MAPPING_PROPERTY;
    }

}
