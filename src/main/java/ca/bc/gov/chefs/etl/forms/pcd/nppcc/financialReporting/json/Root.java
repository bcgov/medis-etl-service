package ca.bc.gov.chefs.etl.forms.pcd.nppcc.financialReporting.json;

import ca.bc.gov.chefs.etl.core.json.Form;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
	public Form form;
	public String nppccName;
	public String nppccId;
	public String lateEntry;
	public String fiscalYear;
	public String communityName;
	public RootFinancialData financialData;
	public String periodReported;
	public String healthAuthority;
	public String reasonForExceptionInPeriodReported;

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getNppccName() {
		return nppccName;
	}

	public void setNppccName(String nppccName) {
		this.nppccName = nppccName;
	}

	public String getNppccId() {
		return nppccId;
	}

	public void setNppccId(String nppccId) {
		this.nppccId = nppccId;
	}

	public String getLateEntry() {
		return lateEntry;
	}

	public void setLateEntry(String lateEntry) {
		this.lateEntry = lateEntry;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public RootFinancialData getFinancialData() {
		return financialData;
	}

	public void setFinancialData(RootFinancialData financialData) {
		this.financialData = financialData;
	}

	public String getPeriodReported() {
		return periodReported;
	}

	public void setPeriodReported(String periodReported) {
		this.periodReported = periodReported;
	}

	public String getHealthAuthority() {
		return healthAuthority;
	}

	public void setHealthAuthority(String healthAuthority) {
		this.healthAuthority = healthAuthority;
	}

	public String getReasonForExceptionInPeriodReported() {
		return reasonForExceptionInPeriodReported;
	}

	public void setReasonForExceptionInPeriodReported(String reasonForExceptionInPeriodReported) {
		this.reasonForExceptionInPeriodReported = reasonForExceptionInPeriodReported;
	}
}
