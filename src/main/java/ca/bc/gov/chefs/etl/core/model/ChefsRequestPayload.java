package ca.bc.gov.chefs.etl.core.model;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChefsRequestPayload {

	private String version;
	private String startDate;
	private String endDate;
	private String updatedMinDate;
	private String updatedMaxDate;
	private boolean draft;
	private boolean deleted;
	private String status;
	private String healthAuthority;
	private boolean isHeaderAdded = true;

	public boolean isDraft() {
		return draft;
	}

	@JsonProperty("draft")
	public void setDraft(boolean draft) {
		this.draft = Boolean.valueOf(draft);
	}

	public boolean isDeleted() {
		return deleted;
	}

	@JsonProperty("deleted")
	public void setDeleted(boolean deleted) {
		this.deleted = Boolean.valueOf(deleted);
	}

	public boolean isHeaderAdded() {
		return isHeaderAdded;
	}

	@JsonProperty("isHeaderAdded")
	public void setHeaderAdded(boolean isHeaderAdded) {
		this.isHeaderAdded = Boolean.valueOf(isHeaderAdded);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getUpdatedMinDate() {
		return updatedMinDate;
	}

	public void setUpdatedMinDate(String updatedMinDate) {
		this.updatedMinDate = updatedMinDate;
	}

	public String getUpdatedMaxDate() {
		return updatedMaxDate;
	}

	public void setUpdatedMaxDate(String updatedMaxDate) {
		this.updatedMaxDate = updatedMaxDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHealthAuthority() {
		return healthAuthority;
	}

	public void setHealthAuthority(String healthAuthority) {
		this.healthAuthority = healthAuthority;
	}

	public boolean isEmpty() {
		return StringUtils.isEmpty(version) && StringUtils.isEmpty(startDate) && StringUtils.isEmpty(endDate)
				&& StringUtils.isEmpty(updatedMinDate) && StringUtils.isEmpty(updatedMaxDate)
				&& StringUtils.isEmpty(status) && StringUtils.isEmpty(healthAuthority);
	}

	@Override
	public String toString() {
		return "ChefsRequestPayload [version=" + version + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", updatedMinDate=" + updatedMinDate + ", updatedMaxDate=" + updatedMaxDate + ", draft=" + draft
				+ ", deleted=" + deleted + ", status=" + status + ", healthAuthority=" + healthAuthority
				+ ", isHeaderAdded=" + isHeaderAdded + "]";
	}

}
