package ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
	public Form form;
	public RootNppccTotals totals;
	public String nppccName;
	public String lateEntry;
	public String fiscalYear;
	public List<RootNppccBudget> nppccBudget;
	public String communityName;
	public String healthAuthority;

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public RootNppccTotals getTotals() {
		return totals;
	}

	public void setTotals(RootNppccTotals totals) {
		this.totals = totals;
	}

	public String getNppccName() {
		return nppccName;
	}

	public void setNppccName(String nppccName) {
		this.nppccName = nppccName;
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

	public List<RootNppccBudget> getNppccBudget() {
		return nppccBudget;
	}

	public void setNppccBudget(List<RootNppccBudget> nppccBudget) {
		this.nppccBudget = nppccBudget;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getHealthAuthority() {
		return healthAuthority;
	}

	public void setHealthAuthority(String healthAuthority) {
		this.healthAuthority = healthAuthority;
	}

	@Override
	public String toString() {
		return "Root [form=" + form + ", totals=" + totals + ", nppccName=" + nppccName + ", lateEntry=" + lateEntry + ", fiscalYear=" + fiscalYear + ", nppccBudget=" + nppccBudget
				+ ", communityName=" + communityName + ", healthAuthority=" + healthAuthority + "]";
	}

}
