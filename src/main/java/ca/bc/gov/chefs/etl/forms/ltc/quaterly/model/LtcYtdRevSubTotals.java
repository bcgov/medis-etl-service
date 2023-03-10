package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;

public class LtcYtdRevSubTotals implements IModel {

	private String confirmationId;
	private String revType;
	private String subTotalRevYtd;
	
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getRevType() {
		return revType;
	}
	public void setRevType(String revType) {
		this.revType = revType;
	}
	public String getSubTotalRevYtd() {
		return subTotalRevYtd;
	}
	public void setSubTotalRevYtd(String subTotalRevYtd) {
		this.subTotalRevYtd = subTotalRevYtd;
	}
	
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_REV_SUB_TOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getRevType());
		elements.add(this.getSubTotalRevYtd());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}