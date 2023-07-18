package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LTCStaffingHrs implements IModel{
	
	private String confirmationId;
	private String staffingPlanNum;
	private String staffHrsPosType;
	private String staffHrsPosShiftType;
	private String staffHrsMon;
	private String staffHrsTue;
	private String staffHrsWed;
	private String staffHrsThurs;
	private String staffHrsFri;
	private String staffHrsSat;
	private String staffHrsSun;
	private String staffHrsWkTotal;
	private String staffHrsAnnual;
	
	/* repeated field 4.1*/
	private String rn247;
	
	

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

	public String getStaffHrsPosType() {
		return staffHrsPosType;
	}

	public void setStaffHrsPosType(String staffHrsPosType) {
		this.staffHrsPosType = staffHrsPosType;
	}

	public String getStaffHrsPosShiftType() {
		return staffHrsPosShiftType;
	}

	public void setStaffHrsPosShiftType(String staffHrsPosShiftType) {
		this.staffHrsPosShiftType = staffHrsPosShiftType;
	}

	public String getStaffHrsMon() {
		return staffHrsMon;
	}

	public void setStaffHrsMon(String staffHrsMon) {
		this.staffHrsMon = staffHrsMon;
	}

	public String getStaffHrsTue() {
		return staffHrsTue;
	}

	public void setStaffHrsTue(String staffHrsTue) {
		this.staffHrsTue = staffHrsTue;
	}

	public String getStaffHrsWed() {
		return staffHrsWed;
	}

	public void setStaffHrsWed(String staffHrsWed) {
		this.staffHrsWed = staffHrsWed;
	}

	public String getStaffHrsThurs() {
		return staffHrsThurs;
	}

	public void setStaffHrsThurs(String staffHrsThurs) {
		this.staffHrsThurs = staffHrsThurs;
	}

	public String getStaffHrsFri() {
		return staffHrsFri;
	}

	public void setStaffHrsFri(String staffHrsFri) {
		this.staffHrsFri = staffHrsFri;
	}

	public String getStaffHrsSat() {
		return staffHrsSat;
	}

	public void setStaffHrsSat(String staffHrsSat) {
		this.staffHrsSat = staffHrsSat;
	}

	public String getStaffHrsSun() {
		return staffHrsSun;
	}

	public void setStaffHrsSun(String staffHrsSun) {
		this.staffHrsSun = staffHrsSun;
	}

	public String getStaffHrsWkTotal() {
		return staffHrsWkTotal;
	}

	public void setStaffHrsWkTotal(String staffHrsWkTotal) {
		this.staffHrsWkTotal = staffHrsWkTotal;
	}

	public String getStaffHrsAnnual() {
		return staffHrsAnnual;
	}

	public void setStaffHrsAnnual(String staffHrsAnnual) {
		this.staffHrsAnnual = staffHrsAnnual;
	}

	public String getRn247() {
		return rn247;
	}

	public void setRn247(String rn247) {
		this.rn247 = rn247;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_STAFFING_HRS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.confirmationId);
		elements.add(this.staffingPlanNum);
		elements.add(this.staffHrsPosType);
		elements.add(this.staffHrsPosShiftType);
		elements.add(this.staffHrsMon);
		elements.add(this.staffHrsTue);
		elements.add(this.staffHrsWed);
		elements.add(this.staffHrsThurs);
		elements.add(this.staffHrsFri);
		elements.add(this.staffHrsSat);
		elements.add(this.staffHrsSun);
		elements.add(this.staffHrsWkTotal);
		elements.add(this.staffHrsAnnual);
		elements.add(this.rn247);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}