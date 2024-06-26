package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdCompSalTotals implements IModel {

	private String confirmationId;
	private String compSalType;
	private String totalCompSalStaffYTD;
	private String totalCompSalContractServicesYTD;
	private String totalCompSalTotalCostYTD;

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}

	public String getCompSalType() {
		return compSalType;
	}

	public void setCompSalType(String compSalType) {
		this.compSalType = StringUtils.defaultIfEmpty(compSalType, Constants.DEFAULT_STRING_VALUE);
	}

	public String getTotalCompSalStaffYTD() {
		return StringUtils.isBlank(totalCompSalStaffYTD) ? "0" : totalCompSalStaffYTD;
	}

	public void setTotalCompSalStaffYTD(String totalCompSalStaffYTD) {
		this.totalCompSalStaffYTD = totalCompSalStaffYTD;
	}

	public String getTotalCompSalContractServicesYTD() {
		return StringUtils.isBlank(totalCompSalContractServicesYTD) ? "0" : totalCompSalContractServicesYTD;
	}

	public void setTotalCompSalContractServicesYTD(String totalCompSalContractServicesYTD) {
		this.totalCompSalContractServicesYTD = totalCompSalContractServicesYTD;
	}

	public String getTotalCompSalTotalCostYTD() {
		 return StringUtils.isBlank(totalCompSalTotalCostYTD) ? "0" : totalCompSalTotalCostYTD;
	}

	public void setTotalCompSalTotalCostYTD(String totalCompSalTotalCostYTD) {
		this.totalCompSalTotalCostYTD = totalCompSalTotalCostYTD;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_YTD_COMP_SAL_TOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getCompSalType());
		elements.add(this.getTotalCompSalStaffYTD());
		elements.add(this.getTotalCompSalContractServicesYTD());
		elements.add(this.getTotalCompSalTotalCostYTD());

		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
