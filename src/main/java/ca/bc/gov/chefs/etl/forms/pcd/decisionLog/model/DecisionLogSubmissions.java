package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class DecisionLogSubmissions implements IModel{

    private String submissionId;
    private String createdAt;
    private String submitterFullName;
    private String submitterUserName;
    private String submitterEmail;
    private String submissionStatus;
    private String submissionversion;
    private String submissionformName;
    private String lateEntry;
    private String healthAuthority;
    private String communityName;
    private String typeOfInitiative;
    private String requestNumber;
    private String submittedDate;
    private String description;
    private String requestCategory;
    private String requestStatus;
    private String recommendedDocumentationType;
    private String otherDocuments;
    private String dateDecisionMade;
    private String commentsRecommendations;
    private String finalDecisionComments;
    private String decisionMadeBy;
    private String finalDecision;
    private String finalDocumentsReceived;
    private String precedentSetting;
    private String updatedApprovalTracker;
    private String updatedFinancialReport;
    private String notAllPcns;

    private List<ChangeRequestFileUpload> ChangeRequestFileUpload;
    private List<DecisionLogComments> DecisionLogComments;
    private List<DecisionLogInitiatives> DecisionLogInitiatives;
    private List<PCNNames> PCNNames;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSubmitterFullName() {
        return submitterFullName;
    }

    public void setSubmitterFullName(String submitterFullName) {
        this.submitterFullName = submitterFullName;
    }

    public String getSubmitterUserName() {
        return submitterUserName;
    }

    public void setSubmitterUserName(String submitterUserName) {
        this.submitterUserName = submitterUserName;
    }

    public String getSubmitterEmail() {
        return submitterEmail;
    }

    public void setSubmitterEmail(String submitterEmail) {
        this.submitterEmail = submitterEmail;
    }

    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public String getSubmissionversion() {
        return submissionversion;
    }

    public void setSubmissionversion(String submissionversion) {
        this.submissionversion = submissionversion;
    }

    public String getSubmissionformName() {
        return submissionformName;
    }

    public void setSubmissionformName(String submissionformName) {
        this.submissionformName = submissionformName;
    }

    public String getLateEntry() {
        return lateEntry;
    }

    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getTypeOfInitiative() {
        return typeOfInitiative;
    }

    public void setTypeOfInitiative(String typeOfInitiative) {
        this.typeOfInitiative = typeOfInitiative;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestCategory() {
        return requestCategory;
    }

    public void setRequestCategory(String requestCategory) {
        this.requestCategory = requestCategory;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRecommendedDocumentationType() {
        return recommendedDocumentationType;
    }

    public void setRecommendedDocumentationType(String recommendedDocumentationType) {
        this.recommendedDocumentationType = recommendedDocumentationType;
    }

    public String getOtherDocuments() {
        return otherDocuments;
    }

    public void setOtherDocuments(String otherDocuments) {
        this.otherDocuments = otherDocuments;
    }

    public String getDateDecisionMade() {
        return dateDecisionMade;
    }

    public void setDateDecisionMade(String dateDecisionMade) {
        this.dateDecisionMade = dateDecisionMade;
    }

    public String getCommentsRecommendations() {
        return commentsRecommendations;
    }

    public void setCommentsRecommendations(String commentsRecommendations) {
        this.commentsRecommendations = commentsRecommendations;
    }

    public String getFinalDecisionComments() {
        return finalDecisionComments;
    }

    public void setFinalDecisionComments(String finalDecisionComments) {
        this.finalDecisionComments = finalDecisionComments;
    }

    public String getDecisionMadeBy() {
        return decisionMadeBy;
    }

    public void setDecisionMadeBy(String decisionMadeBy) {
        this.decisionMadeBy = decisionMadeBy;
    }

    public String getFinalDecision() {
        return finalDecision;
    }

    public void setFinalDecision(String finalDecision) {
        this.finalDecision = finalDecision;
    }

    public String getFinalDocumentsReceived() {
        return finalDocumentsReceived;
    }

    public void setFinalDocumentsReceived(String finalDocumentsReceived) {
        this.finalDocumentsReceived = finalDocumentsReceived;
    }

    public String getPrecedentSetting() {
        return precedentSetting;
    }

    public void setPrecedentSetting(String precedentSetting) {
        this.precedentSetting = precedentSetting;
    }

    public String getUpdatedApprovalTracker() {
        return updatedApprovalTracker;
    }

    public void setUpdatedApprovalTracker(String updatedApprovalTracker) {
        this.updatedApprovalTracker = updatedApprovalTracker;
    }

    public String getUpdatedFinancialReport() {
        return updatedFinancialReport;
    }

    public void setUpdatedFinancialReport(String updatedFinancialReport) {
        this.updatedFinancialReport = updatedFinancialReport;
    }

    public String getNotAllPcns() {
        return notAllPcns;
    }

    public void setNotAllPcns(String notAllPcns) {
        this.notAllPcns = notAllPcns;
    }

    public List<ChangeRequestFileUpload> getChangeRequestFileUpload() {
        return ChangeRequestFileUpload;
    }

    public void setChangeRequestFileUpload(List<ChangeRequestFileUpload> changeRequestFileUpload) {
        ChangeRequestFileUpload = changeRequestFileUpload;
    }

    public List<DecisionLogComments> getDecisionLogComments() {
        return DecisionLogComments;
    }

    public void setDecisionLogComments(List<DecisionLogComments> decisionLogComments) {
        DecisionLogComments = decisionLogComments;
    }

    public List<DecisionLogInitiatives> getDecisionLogInitiatives() {
        return DecisionLogInitiatives;
    }

    public void setDecisionLogInitiatives(List<DecisionLogInitiatives> decisionLogInitiatives) {
        DecisionLogInitiatives = decisionLogInitiatives;
    }

    public List<PCNNames> getPCNNames() {
        return PCNNames;
    }

    public void setPCNNames(List<PCNNames> pCNNames) {
        PCNNames = pCNNames;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.DECISION_LOG_SUBMISSIONS;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
		elements.add(this.submissionId);
		elements.add(this.createdAt);
		elements.add(this.lateEntry);
		elements.add(this.submitterFullName);
		elements.add(this.submitterUserName);
		elements.add(this.submitterEmail);
		elements.add(this.submissionStatus);
		elements.add(this.submissionversion);
		elements.add(this.submissionformName);
		elements.add(this.healthAuthority);
		elements.add(this.communityName);
		elements.add(this.typeOfInitiative);
		elements.add(this.requestNumber);
		elements.add(this.submittedDate);
		elements.add(this.description);
		elements.add(this.requestCategory);
		elements.add(this.requestStatus);
		elements.add(this.recommendedDocumentationType);
		elements.add(this.otherDocuments);
		elements.add(this.dateDecisionMade);
		elements.add(this.commentsRecommendations);
		elements.add(this.finalDecisionComments);
		elements.add(this.decisionMadeBy);
		elements.add(this.finalDecision);
		elements.add(this.finalDocumentsReceived);
		elements.add(this.precedentSetting);
		elements.add(this.updatedApprovalTracker);
		elements.add(this.updatedFinancialReport);
		elements.add(this.notAllPcns);
		return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> pcdDecisionLogIModels = new ArrayList<>();
        pcdDecisionLogIModels.addAll(this.getChangeRequestFileUpload());
        pcdDecisionLogIModels.addAll(this.getDecisionLogComments());
        pcdDecisionLogIModels.addAll(this.getDecisionLogInitiatives());
        pcdDecisionLogIModels.addAll(this.getPCNNames());
		return pcdDecisionLogIModels;
    }
    
}
