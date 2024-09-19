package ca.bc.gov.chefs.etl.forms.pcd.hrRecords.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class HRRecordsPractitioner implements IModel{
    private String submissionId;
    private String hrRecordId;
    private String practitionerType;
    private String practitionerName;
    private String practitionerFirstName;
    private String practitionerLastName;
    private String practitionerRole;
    private String practitionerBillingNumber;
    private String practitionerBillingNumberNotAvailable;
    private String specialty;
    private String otherSpecialty;
    private String groupRole;
    private String additionalGroupDetails;
    private String duration;
    private String fteEquivalent;
    private String paymentModality;
    private String dateHired;
    private String fiscalYear;
    private String period;
    private String employmentStatus;
    private String dateEmploymentStatusChanged;
    private String recordCreationDate;
    private String notes;
    private String legacyWebformId;

    public String getSubmissionId() {
        return submissionId;
    }
    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }
    public String getHrRecordId() {
        return hrRecordId;
    }
    public void setHrRecordId(String hrRecordId) {
        this.hrRecordId = hrRecordId;
    }
    public String getPractitionerType() {
        return practitionerType;
    }
    public void setPractitionerType(String practitionerType) {
        this.practitionerType = practitionerType;
    }
    public String getPractitionerName() {
        return practitionerName;
    }
    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }
    public String getPractitionerFirstName() {
        return practitionerFirstName;
    }
    public void setPractitionerFirstName(String practitionerFirstName) {
        this.practitionerFirstName = practitionerFirstName;
    }
    public String getPractitionerLastName() {
        return practitionerLastName;
    }
    public void setPractitionerLastName(String practitionerLastName) {
        this.practitionerLastName = practitionerLastName;
    }
    public String getPractitionerRole() {
        return practitionerRole;
    }
    public void setPractitionerRole(String practitionerRole) {
        this.practitionerRole = practitionerRole;
    }
    public String getPractitionerBillingNumber() {
        return practitionerBillingNumber;
    }
    public void setPractitionerBillingNumber(String practitionerBillingNumber) {
        this.practitionerBillingNumber = practitionerBillingNumber;
    }
    public String getPractitionerBillingNumberNotAvailable() {
        return practitionerBillingNumberNotAvailable;
    }
    public void setPractitionerBillingNumberNotAvailable(String practitionerBillingNumberNotAvailable) {
        this.practitionerBillingNumberNotAvailable = practitionerBillingNumberNotAvailable;
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
    public String getGroupRole() {
        return groupRole;
    }
    public void setGroupRole(String groupRole) {
        this.groupRole = groupRole;
    }
    public String getAdditionalGroupDetails() {
        return CSVUtil.replaceCarriageReturnLineFeed(additionalGroupDetails);
    }
    public void setAdditionalGroupDetails(String additionalGroupDetails) {
        this.additionalGroupDetails = additionalGroupDetails;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getFteEquivalent() {
        return fteEquivalent;
    }
    public void setFteEquivalent(String fteEquivalent) {
        this.fteEquivalent = fteEquivalent;
    }
    public String getPaymentModality() {
        return paymentModality;
    }
    public void setPaymentModality(String paymentModality) {
        this.paymentModality = paymentModality;
    }
    public String getDateHired() {
        return dateHired;
    }
    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }
    public String getFiscalYear() {
        return fiscalYear;
    }
    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }
    public String getEmploymentStatus() {
        return employmentStatus;
    }
    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
    public String getDateEmploymentStatusChanged() {
        return dateEmploymentStatusChanged;
    }
    public void setDateEmploymentStatusChanged(String dateEmploymentStatusChanged) {
        this.dateEmploymentStatusChanged = dateEmploymentStatusChanged;
    }
    public String getRecordCreationDate() {
        return recordCreationDate;
    }
    public void setRecordCreationDate(String recordCreationDate) {
        this.recordCreationDate = recordCreationDate;
    }
    public String getNotes() {
        return CSVUtil.replaceCarriageReturnLineFeed(notes);
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getLegacyWebformId() {
        return legacyWebformId;
    }
    public void setLegacyWebformId(String legacyWebformId) {
        this.legacyWebformId = legacyWebformId;
    }
    
    @Override
    public String getFileName() {
        return null;
    }
    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(hrRecordId);
        elements.add(practitionerType);
        elements.add(practitionerName);
        elements.add(practitionerFirstName);
        elements.add(practitionerLastName);
        elements.add(practitionerRole);
        elements.add(practitionerBillingNumber);
        elements.add(practitionerBillingNumberNotAvailable);
        elements.add(specialty);
        elements.add(otherSpecialty);
        elements.add(groupRole);
        elements.add(getAdditionalGroupDetails());
        elements.add(duration);
        elements.add(fteEquivalent);
        elements.add(paymentModality);
        elements.add(dateHired);
        elements.add(fiscalYear);
        elements.add(period);
        elements.add(employmentStatus);
        elements.add(dateEmploymentStatusChanged);
        elements.add(recordCreationDate);
        elements.add(getNotes());
        elements.add(legacyWebformId);
        return elements;
    }
    @Override
    public String getFormType() {
        return PCDConstants.HR_RECORDS_DATA;
    }
    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "HRRecordsData [submissionId=" + submissionId + ", hrRecordId=" + hrRecordId + ", practitionerType="
                + practitionerType + ", practitionerName=" + practitionerName + ", practitionerFirstName="
                + practitionerFirstName + ", practitionerLastName=" + practitionerLastName + ", practitionerRole="
                + practitionerRole + ", practitionerBillingNumber=" + practitionerBillingNumber
                + ", practitionerBillingNumberNotAvailable=" + practitionerBillingNumberNotAvailable + ", specialty="
                + specialty + ", otherSpecialty=" + otherSpecialty + ", groupRole=" + groupRole
                + ", additionalGroupDetails=" + additionalGroupDetails + ", duration=" + duration + ", fteEquivalent="
                + fteEquivalent + ", paymentModality=" + paymentModality + ", dateHired=" + dateHired + ", fiscalYear="
                + fiscalYear + ", period=" + period + ", employmentStatus=" + employmentStatus
                + ", dateEmploymentStatusChanged=" + dateEmploymentStatusChanged + ", recordCreationDate="
                + recordCreationDate + ", notes=" + notes + ", legacyWebformId=" + legacyWebformId + "]";
    }
}
