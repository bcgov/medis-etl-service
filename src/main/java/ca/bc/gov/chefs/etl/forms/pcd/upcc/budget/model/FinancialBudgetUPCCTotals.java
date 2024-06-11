package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model;

import static ca.bc.gov.chefs.etl.util.CSVUtil.formatBigDecimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetUPCCTotals implements IModel {

	public String submissionId;
	public BigDecimal clinicalApprovedFtes = BigDecimal.ZERO;;
	public BigDecimal clinicalApprovedBudget = BigDecimal.ZERO;;
	public BigDecimal overheadApprovedBudget = BigDecimal.ZERO;;
	public BigDecimal oneTimeFundingApprovedBudget = BigDecimal.ZERO;;

	public FinancialBudgetUPCCTotals(String submissionId) {
		super();
		this.submissionId = submissionId;
	}

	public String getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	public BigDecimal getClinicalApprovedFtes() {
		return clinicalApprovedFtes;
	}

	public void setClinicalApprovedFtes(BigDecimal clinicalApprovedFtes) {
		this.clinicalApprovedFtes = clinicalApprovedFtes;
	}

	public BigDecimal getClinicalApprovedBudget() {
		return clinicalApprovedBudget;
	}

	public void setClinicalApprovedBudget(BigDecimal clinicalApprovedBudget) {
		this.clinicalApprovedBudget = clinicalApprovedBudget;
	}

	public BigDecimal getOverheadApprovedBudget() {
		return overheadApprovedBudget;
	}

	public void setOverheadApprovedBudget(BigDecimal overheadApprovedBudget) {
		this.overheadApprovedBudget = overheadApprovedBudget;
	}

	public BigDecimal getOneTimeFundingApprovedBudget() {
		return oneTimeFundingApprovedBudget;
	}

	public void setOneTimeFundingApprovedBudget(BigDecimal oneTimeFundingApprovedBudget) {
		this.oneTimeFundingApprovedBudget = oneTimeFundingApprovedBudget;
	}

	@Override
	public String getFileName() {
		return null;
	}

	@Override
	public String getFormType() {
		return PCDConstants.FINANCIAL_BUDGET_UPCC_TOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(submissionId);
		elements.add(formatBigDecimal(clinicalApprovedFtes));
		elements.add(formatBigDecimal(clinicalApprovedBudget));
		elements.add(formatBigDecimal(overheadApprovedBudget));
		elements.add(formatBigDecimal(oneTimeFundingApprovedBudget));
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
}
