package ca.bc.gov.chefs.etl.forms.pcd.haMapping.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
	public Form form;
	public String lateEntry;

	@JsonProperty("haMapping")
	public List<HaMapping> haMappings = new ArrayList<>();

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getLateEntry() {
		return lateEntry;
	}

	public void setLateEntry(String lateEntry) {
		this.lateEntry = lateEntry;
	}

	public List<HaMapping> getHaMappings() {
		return haMappings;
	}

	public void setHaMappings(List<HaMapping> haMappings) {
		this.haMappings = haMappings;
	}

}
