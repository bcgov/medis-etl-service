package ca.bc.gov.chefs.etl.forms.pcd.hrRecords.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClinicRecordsDetails {
    public String notes;
    public String period;
    public String duration;
    public String dateHired;
    public String groupRole;
    public String specialty;
    public String otherSpecialty;
    public String fiscalYear;
    public String fteEquivalent ;
    public String legacyWebformId;
    public String paymentModality;
    public String employmentStatus;
    public String practitionerName;
    public String practitionerRole;
    public String practitionerType;
    public String recordCreatedDate;
    public String practitionerLastName;
    public String practitionerFirstName;
    public String additionalGroupDetails;
    public String practitionerBillingNumber;
    public String dateEmploymentStatusChanged;
    public String practitionerBillingNumberNotAvailable;
    
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getDateHired() {
        return dateHired;
    }
    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }
    public String getGroupRole() {
        return groupRole;
    }
    public void setGroupRole(String groupRole) {
        this.groupRole = groupRole;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getOtherSpecialty() {
        return otherSpecialty;
    }
    public void setOtherSpecialty(String otherSpecialty) {
        this.otherSpecialty = otherSpecialty;
    }
    public String getFiscalYear() {
        return fiscalYear;
    }
    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
    public String getFteEquivalent() {
        return fteEquivalent;
    }
    public void setFteEquivalent(String fteEquivalent) {
        this.fteEquivalent = fteEquivalent;
    }
    public String getLegacyWebformId() {
        return legacyWebformId;
    }
    public void setLegacyWebformId(String legacyWebformId) {
        this.legacyWebformId = legacyWebformId;
    }
    public String getPaymentModality() {
        return paymentModality;
    }
    public void setPaymentModality(String paymentModality) {
        this.paymentModality = paymentModality;
    }
    public String getEmploymentStatus() {
        return employmentStatus;
    }
    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
    public String getPractitionerName() {
        return practitionerName;
    }
    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }
    public String getPractitionerRole() {
        return practitionerRole;
    }
    public void setPractitionerRole(String practitionerRole) {
        this.practitionerRole = practitionerRole;
    }
    public String getPractitionerType() {
        return practitionerType;
    }
    public void setPractitionerType(String practitionerType) {
        this.practitionerType = practitionerType;
    }
    public String getRecordCreatedDate() {
        return recordCreatedDate;
    }
    public void setRecordCreatedDate(String recordCreatedDate) {
        this.recordCreatedDate = recordCreatedDate;
    }
    public String getPractitionerLastName() {
        return practitionerLastName;
    }
    public void setPractitionerLastName(String practitionerLastName) {
        this.practitionerLastName = practitionerLastName;
    }
    public String getPractitionerFirstName() {
        return practitionerFirstName;
    }
    public void setPractitionerFirstName(String practitionerFirstName) {
        this.practitionerFirstName = practitionerFirstName;
    }
    public String getAdditionalGroupDetails() {
        return additionalGroupDetails;
    }
    public void setAdditionalGroupDetails(String additionalGroupDetails) {
        this.additionalGroupDetails = additionalGroupDetails;
    }
    public String getPractitionerBillingNumber() {
        return practitionerBillingNumber;
    }
    public void setPractitionerBillingNumber(String practitionerBillingNumber) {
        this.practitionerBillingNumber = practitionerBillingNumber;
    }
    public String getDateEmploymentStatusChanged() {
        return dateEmploymentStatusChanged;
    }
    public void setDateEmploymentStatusChanged(String dateEmploymentStatusChanged) {
        this.dateEmploymentStatusChanged = dateEmploymentStatusChanged;
    }
    public String getPractitionerBillingNumberNotAvailable() {
        return practitionerBillingNumberNotAvailable;
    }
    public void setPractitionerBillingNumberNotAvailable(String practitionerBillingNumberNotAvailable) {
        this.practitionerBillingNumberNotAvailable = practitionerBillingNumberNotAvailable;
    }
    
    @Override
    public String toString() {
        return "ClinicRecordsDetails [notes=" + notes + ", period=" + period + ", duration=" + duration + ", dateHired="
                + dateHired + ", groupRole=" + groupRole + ", specialty=" + specialty + ", otherSpecialty="
                + otherSpecialty + ", fiscalYear=" + fiscalYear + ", fteEquivalent=" + fteEquivalent
                + ", legacyWebformId=" + legacyWebformId + ", paymentModality=" + paymentModality
                + ", employmentStatus=" + employmentStatus + ", practitionerName=" + practitionerName
                + ", practitionerRole=" + practitionerRole + ", practitionerType=" + practitionerType
                + ", recordCreatedDate=" + recordCreatedDate + ", practitionerLastName=" + practitionerLastName
                + ", practitionerFirstName=" + practitionerFirstName + ", additionalGroupDetails="
                + additionalGroupDetails + ", practitionerBillingNumber=" + practitionerBillingNumber
                + ", dateEmploymentStatusChanged=" + dateEmploymentStatusChanged
                + ", practitionerBillingNumberNotAvailable=" + practitionerBillingNumberNotAvailable + "]";
    }
}
