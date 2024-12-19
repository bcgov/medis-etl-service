package ca.bc.gov.chefs.etl.forms.pcd.nppcc.budget.model;

import static ca.bc.gov.chefs.etl.util.CSVUtil.formatBigDecimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetNPPCCTotals implements IModel {

	private String submissionId;
	private BigDecimal clinicalApprovedFtes = BigDecimal.ZERO;
	private BigDecimal clinicalApprovedBudget = BigDecimal.ZERO;
	private BigDecimal overheadApprovedBudget = BigDecimal.ZERO;
	private BigDecimal otherResourcesApprovedFtes = BigDecimal.ZERO;
	private BigDecimal otherResourcesApprovedBudget = BigDecimal.ZERO;
	private BigDecimal oneTimeFundingApprovedBudget = BigDecimal.ZERO;

	public FinancialBudgetNPPCCTotals(String submissionId) {
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

	public BigDecimal getOtherResourcesApprovedFtes() {
		return otherResourcesApprovedFtes;
	}

	public void setOtherResourcesApprovedFtes(BigDecimal otherResourcesApprovedFtes) {
		this.otherResourcesApprovedFtes = otherResourcesApprovedFtes;
	}

	public BigDecimal getOtherResourcesApprovedBudget() {
		return otherResourcesApprovedBudget;
	}

	public void setOtherResourcesApprovedBudget(BigDecimal otherResourcesApprovedBudget) {
		this.otherResourcesApprovedBudget = otherResourcesApprovedBudget;
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
		return PCDConstants.FINANCIAL_BUDGET_NPPCC_TOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(submissionId);
		elements.add(formatBigDecimal(clinicalApprovedFtes));
		elements.add(formatBigDecimal(clinicalApprovedBudget));
		elements.add(formatBigDecimal(overheadApprovedBudget));
		elements.add(formatBigDecimal(otherResourcesApprovedFtes));
		elements.add(formatBigDecimal(otherResourcesApprovedBudget));
		elements.add(formatBigDecimal(oneTimeFundingApprovedBudget));
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
}
