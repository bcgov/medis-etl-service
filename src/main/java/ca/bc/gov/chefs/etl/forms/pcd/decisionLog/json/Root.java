package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.json;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ca.bc.gov.chefs.etl.core.json.Form;
import ca.bc.gov.chefs.etl.util.CSVUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public List<Comments> comments;
    public List<ChangeRequestFileUploadData> changeRequestFileUpload = new ArrayList<>();
    public PcnNameWithType pcnNameWithType;
    public List<PcnNameWithType> pcnNamesWithType;
    public String[] pcnNames;
    public String[] nppccName;
    public String[] fnpccName;
    public String[] chcName;
    public String[] upccName;

    public String pcnName;
    public String description;
    public String communityName;
    public String finalDecision;
    public String requestNumber;
    public String requestStatus;
    public String submittedDate;
    public String decisionMadeBy;
    public String healthAuthority;
    public String requestCategory;
    public String dateDecisionMade;
    public String typeOfInitiative;
    public String finalDecisionComments;
    public String updatedApprovalTracker;
    public String updatedFinancialReport;
    public String recommendedDocumentationType;
    public String lateEntry;
    public String commentsRecommendations;
    public String precedentSetting;
    public String finalDocumentsReceived;
    public String notAllPcns;
    public String otherDocuments;

    public String getOtherDocuments() {
        return CSVUtil.replaceCarriageReturnLineFeed(otherDocuments);
    }

    public void setOtherDocuments(String otherDocuments) {
        this.otherDocuments = otherDocuments;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<ChangeRequestFileUploadData> getChangeRequestFileUpload() {
        return changeRequestFileUpload;
    }

    public void setChangeRequestFileUpload(List<ChangeRequestFileUploadData> changeRequestFileUpload) {
        this.changeRequestFileUpload = changeRequestFileUpload;
    }

    public PcnNameWithType getPcnNameWithType() {
        return pcnNameWithType;
    }

    public void setPcnNameWithType(PcnNameWithType pcnNameWithType) {
        this.pcnNameWithType = pcnNameWithType;
    }

    public List<PcnNameWithType> getPcnNamesWithType() {
        return pcnNamesWithType;
    }

    public void setPcnNamesWithType(List<PcnNameWithType> pcnNamesWithType) {
        this.pcnNamesWithType = pcnNamesWithType;
    }

    public String[] getPcnNames() {
        return pcnNames;
    }

    public void setPcnNames(String[] pcnNames) {
        this.pcnNames = pcnNames;
    }

    public String[] getNppccName() {
        return nppccName;
    }

    public void setNppccName(String[] nppccName) {
        this.nppccName = nppccName;
    }

    public String[] getFnpccName() {
        return fnpccName;
    }

    public void setFnpccName(String[] fnpccName) {
        this.fnpccName = fnpccName;
    }

    public String[] getChcName() {
        return chcName;
    }

    public void setChcName(String[] chcName) {
        this.chcName = chcName;
    }

    public String[] getUpccName() {
        return upccName;
    }

    public void setUpccName(String[] upccName) {
        this.upccName = upccName;
    }

    public String getPcnName() {
        return pcnName;
    }

    public void setPcnName(String pcnName) {
        this.pcnName = pcnName;
    }

    public String getDescription() {
        return CSVUtil.replaceCarriageReturnLineFeed(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getFinalDecision() {
        return finalDecision;
    }

    public void setFinalDecision(String finalDecision) {
        this.finalDecision = finalDecision;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = CSVUtil.getFormattedDate(submittedDate);
    }

    public String getDecisionMadeBy() {
        return decisionMadeBy;
    }

    public void setDecisionMadeBy(String decisionMadeBy) {
        this.decisionMadeBy = decisionMadeBy;
    }

    public String getHealthAuthority() {
        return healthAuthority;
    }

    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }

    public String getRequestCategory() {
        return requestCategory;
    }

    public void setRequestCategory(String requestCategory) {
        this.requestCategory = requestCategory;
    }

    public String getDateDecisionMade() {
        return dateDecisionMade;
    }

    public void setDateDecisionMade(String dateDecisionMade) {
        this.dateDecisionMade = CSVUtil.getFormattedDate(dateDecisionMade);
    }

    public String getTypeOfInitiative() {
        return typeOfInitiative;
    }

    public void setTypeOfInitiative(String typeOfInitiative) {
        this.typeOfInitiative = typeOfInitiative;
    }

    public String getFinalDecisionComments() {
        return CSVUtil.replaceCarriageReturnLineFeed(finalDecisionComments);
    }

    public void setFinalDecisionComments(String finalDecisionComments) {
        this.finalDecisionComments = finalDecisionComments;
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

    public String getRecommendedDocumentationType() {
        return recommendedDocumentationType;
    }

    public void setRecommendedDocumentationType(String recommendedDocumentationType) {
        this.recommendedDocumentationType = recommendedDocumentationType;
    }

    public String getLateEntry() {
        return lateEntry;
    }

    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }

    public String getCommentsRecommendations() {
        return commentsRecommendations;
    }

    public void setCommentsRecommendations(String commentsRecommendations) {
        this.commentsRecommendations = commentsRecommendations;
    }

    public String getPrecedentSetting() {
        return precedentSetting;
    }

    public void setPrecedentSetting(String precedentSetting) {
        this.precedentSetting = precedentSetting;
    }

    public String getFinalDocumentsReceived() {
        return finalDocumentsReceived;
    }

    public void setFinalDocumentsReceived(String finalDocumentsReceived) {
        this.finalDocumentsReceived = finalDocumentsReceived;
    }

    public String getNotAllPcns() {
        return notAllPcns;
    }

    public void setNotAllPcns(String notAllPcns) {
        this.notAllPcns = notAllPcns;
    }
}
