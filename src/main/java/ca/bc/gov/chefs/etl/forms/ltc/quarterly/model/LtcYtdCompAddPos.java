package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdCompAddPos implements IModel{

	private String confirmationId;
	private String addPosType;
	private String addPosName;
	private String addPosContractedOutYtd;
	private String addPosLegalNameContractServiceYtd;
	private String addPosPercentServiceContractOutYtd;
	private String addPosAnotherName = "";
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getAddPosType() {
		return addPosType;
	}
	public void setAddPosType(String addPosType) {
		this.addPosType = addPosType;
	}
	public String getAddPosName() {
		return addPosName;
	}
	public void setAddPosName(String addPosName) {
		this.addPosName = addPosName;
	}
	public String getAddPosContractedOutYtd() {
		return this.addPosContractedOutYtd;
	}
	// TODO set to Constant.DEFAULT_BOOLEAN_VALUE if needed 
	public void setAddPosContractedOutYtd(String addPosContractedOutYtd) {
		this.addPosContractedOutYtd = StringUtils.defaultIfEmpty(addPosContractedOutYtd, Constants.DEFAULT_STRING_VALUE);
	}
	public String getAddPosLegalNameContractServiceYtd() {
		return addPosLegalNameContractServiceYtd;
	}
	public void setAddPosLegalNameContractServiceYtd(String addPosLegalNameContractServiceYtd) {
		this.addPosLegalNameContractServiceYtd = addPosLegalNameContractServiceYtd;
	}
	public String getAddPosPercentServiceContractOutYtd() {
		return addPosPercentServiceContractOutYtd;
	}
	public void setAddPosPercentServiceContractOutYtd(String addPosPercentServiceContractOutYtd) {
		this.addPosPercentServiceContractOutYtd = addPosPercentServiceContractOutYtd;
	}
	public String getAddPosAnotherName() {
		return addPosAnotherName;
	}
	public void setAddPosAnotherName(String addPosAnotherName) {
		this.addPosAnotherName = addPosAnotherName;
	}

	public void determineAddPosContractedOutYtd() {
		if(this.addPosLegalNameContractServiceYtd != null && !this.addPosLegalNameContractServiceYtd.trim().isEmpty()){
			this.setAddPosContractedOutYtd("Y");
		} else {
			this.setAddPosContractedOutYtd("N");
		}
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_COMP_ADD_POS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getAddPosType());
		elements.add(this.getAddPosName());
		elements.add(this.getAddPosContractedOutYtd());
		elements.add(this.getAddPosLegalNameContractServiceYtd());
		elements.add(this.getAddPosPercentServiceContractOutYtd());
		elements.add(this.getAddPosAnotherName());
		
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
