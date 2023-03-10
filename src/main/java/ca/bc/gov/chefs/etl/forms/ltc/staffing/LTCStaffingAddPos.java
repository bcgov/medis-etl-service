package ca.bc.gov.chefs.etl.forms.ltc.staffing;

import java.util.List;

import ca.bc.gov.chefs.etl.parser.IModel;

public class LTCStaffingAddPos implements IModel {

	/* Contracted Services Provider*/
	private String confirmationId;
	private String staffingPlanNum;
	private String staffingHrsPosType;
	private String staffHrsServiceContractOut;
	private String staffHrsLegalNameContractService;
	private String staffHoursPercentServiceContractOut;
	
	
	
	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getStaffingPlanNum() {
		return staffingPlanNum;
	}

	public void setStaffingPlanNum(String staffingPlanNum) {
		this.staffingPlanNum = staffingPlanNum;
	}

	public String getStaffingHrsPosType() {
		return staffingHrsPosType;
	}

	public void setStaffingHrsPosType(String staffingHrsPosType) {
		this.staffingHrsPosType = staffingHrsPosType;
	}

	public String getStaffHrsServiceContractOut() {
		return staffHrsServiceContractOut;
	}

	public void setStaffHrsServiceContractOut(String staffHrsServiceContractOut) {
		this.staffHrsServiceContractOut = staffHrsServiceContractOut;
	}

	public String getStaffHrsLegalNameContractService() {
		return staffHrsLegalNameContractService;
	}

	public void setStaffHrsLegalNameContractService(String staffHrsLegalNameContractService) {
		this.staffHrsLegalNameContractService = staffHrsLegalNameContractService;
	}

	public String getStaffHoursPercentServiceContractOut() {
		return staffHoursPercentServiceContractOut;
	}

	public void setStaffHoursPercentServiceContractOut(String staffHoursPercentServiceContractOut) {
		this.staffHoursPercentServiceContractOut = staffHoursPercentServiceContractOut;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCsvElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IModel> getObjects() {
		// TODO Auto-generated method stub
		return null;
	}

}