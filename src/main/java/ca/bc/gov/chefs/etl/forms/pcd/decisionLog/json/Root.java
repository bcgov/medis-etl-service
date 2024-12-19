package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ca.bc.gov.chefs.etl.core.json.Form;
import ca.bc.gov.chefs.etl.util.CSVUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
	private Form form;
	private List<Comments> comments;
	private List<ChangeRequestFileUploadData> changeRequestFileUpload = new ArrayList<>();
	private PcnNameWithType pcnNameWithType;
	private List<PcnNameWithType> pcnNamesWithType;
	private String[] pcnNames;
	private String[] nppccName;
	private String[] fnpccName;
	private String[] chcName;
	private String[] upccName;

	private String pcnName;
	private String description;
	private String communityName;
	private String finalDecision;
	private String requestNumber;
	private String requestStatus;
	private String submittedDate;
	private String decisionMadeBy;
	private String healthAuthority;
	private String requestCategory;
	private String dateDecisionMade;
	private String typeOfInitiative;
	private String finalDecisionComments;
	private String updatedApprovalTracker;
	private String updatedFinancialReport;
	private String recommendedDocumentationType;
	private String lateEntry;
	private String commentsRecommendations;
	private String precedentSetting;
	private String finalDocumentsReceived;
	private String notAllPcns;
	private String otherDocuments;
	private String reasonForExceptionInBudgetChangeDate;
	private String suggestedDueDateForDecision;
	private String fiscalYear;
	private String receivedByDsbFinance;
	private String budgetChange;
	private String budgetChangeDate;

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
		this.submittedDate = CSVUtil.formatDate(submittedDate);
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
		this.dateDecisionMade = CSVUtil.formatDate(dateDecisionMade);
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

	public String getReasonForExceptionInBudgetChangeDate() {
		return CSVUtil.replaceCarriageReturnLineFeed(reasonForExceptionInBudgetChangeDate);
	}

	public void setReasonForExceptionInBudgetChangeDate(String reasonForExceptionInBudgetChangeDate) {
		this.reasonForExceptionInBudgetChangeDate = reasonForExceptionInBudgetChangeDate;
	}

	public String getSuggestedDueDateForDecision() {
		return suggestedDueDateForDecision;
	}

	public void setSuggestedDueDateForDecision(String suggestedDueDateForDecision) {
		this.suggestedDueDateForDecision = CSVUtil.formatDate(suggestedDueDateForDecision);
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getReceivedByDsbFinance() {
		return receivedByDsbFinance;
	}

	public void setReceivedByDsbFinance(String receivedByDsbFinance) {
		this.receivedByDsbFinance = receivedByDsbFinance;
	}

	public String getBudgetChange() {
		return budgetChange;
	}

	public void setBudgetChange(String budgetChange) {
		this.budgetChange = budgetChange;
	}

	public String getBudgetChangeDate() {
		return budgetChangeDate;
	}

	public void setBudgetChangeDate(String budgetChangeDate) {
		this.budgetChangeDate = CSVUtil.formatDate(budgetChangeDate);
	}

	@Override
	public String toString() {
		return "Root [form=" + form + ", comments=" + comments + ", changeRequestFileUpload=" + changeRequestFileUpload
				+ ", pcnNameWithType=" + pcnNameWithType + ", pcnNamesWithType=" + pcnNamesWithType + ", pcnNames="
				+ Arrays.toString(pcnNames) + ", nppccName=" + Arrays.toString(nppccName) + ", fnpccName="
				+ Arrays.toString(fnpccName) + ", chcName=" + Arrays.toString(chcName) + ", upccName="
				+ Arrays.toString(upccName) + ", pcnName=" + pcnName + ", description=" + description
				+ ", communityName=" + communityName + ", finalDecision=" + finalDecision + ", requestNumber="
				+ requestNumber + ", requestStatus=" + requestStatus + ", submittedDate=" + submittedDate
				+ ", decisionMadeBy=" + decisionMadeBy + ", healthAuthority=" + healthAuthority + ", requestCategory="
				+ requestCategory + ", dateDecisionMade=" + dateDecisionMade + ", typeOfInitiative=" + typeOfInitiative
				+ ", finalDecisionComments=" + finalDecisionComments + ", updatedApprovalTracker="
				+ updatedApprovalTracker + ", updatedFinancialReport=" + updatedFinancialReport
				+ ", recommendedDocumentationType=" + recommendedDocumentationType + ", lateEntry=" + lateEntry
				+ ", commentsRecommendations=" + commentsRecommendations + ", precedentSetting=" + precedentSetting
				+ ", finalDocumentsReceived=" + finalDocumentsReceived + ", notAllPcns=" + notAllPcns
				+ ", otherDocuments=" + otherDocuments + ", reasonForExceptionInBudgetChangeDate="
				+ reasonForExceptionInBudgetChangeDate + ", suggestedDueDateForDecision=" + suggestedDueDateForDecision
				+ ", fiscalYear=" + fiscalYear + ", receivedByDsbFinance=" + receivedByDsbFinance + ", budgetChange="
				+ budgetChange + ", budgetChangeDate=" + budgetChangeDate + "]";
	}

}
