package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model;

import static ca.bc.gov.chefs.etl.util.CSVUtil.formatBigDecimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FRPcnFinancialTotals implements IModel {

	private String submissionId;
	private String expenseCategory;
	private String expenseSubCategory;
	private BigDecimal approvedBudget = BigDecimal.ZERO;
	private BigDecimal totalBudgetAllocation = BigDecimal.ZERO;
	private BigDecimal approved4YearFtes = BigDecimal.ZERO;
	private BigDecimal ftesHiredToDate = BigDecimal.ZERO;
	private BigDecimal fyExpenseForecast = BigDecimal.ZERO;

	private BigDecimal p1 = BigDecimal.ZERO;
	private BigDecimal p2 = BigDecimal.ZERO;
	private BigDecimal p3 = BigDecimal.ZERO;
	private BigDecimal p4 = BigDecimal.ZERO;
	private BigDecimal p5 = BigDecimal.ZERO;
	private BigDecimal p6 = BigDecimal.ZERO;
	private BigDecimal p7 = BigDecimal.ZERO;
	private BigDecimal p8 = BigDecimal.ZERO;
	private BigDecimal p9 = BigDecimal.ZERO;
	private BigDecimal p10 = BigDecimal.ZERO;
	private BigDecimal p11 = BigDecimal.ZERO;
	private BigDecimal p12 = BigDecimal.ZERO;
	private BigDecimal p13 = BigDecimal.ZERO;

	public FRPcnFinancialTotals(String submissionId, String expenseCategory, String expenseSubCategory) {
		super();
		this.submissionId = submissionId;
		this.expenseCategory = expenseCategory;
		this.expenseSubCategory = expenseSubCategory;
	}

	public String getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	public String getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	public String getExpenseSubCategory() {
		return expenseSubCategory;
	}

	public void setExpenseSubCategory(String expenseSubCategory) {
		this.expenseSubCategory = expenseSubCategory;
	}

	public BigDecimal getApprovedBudget() {
		return approvedBudget;
	}

	public void setApprovedBudget(BigDecimal approvedBudget) {
		this.approvedBudget = approvedBudget;
	}

	public BigDecimal getTotalBudgetAllocation() {
		return totalBudgetAllocation;
	}

	public void setTotalBudgetAllocation(BigDecimal totalBudgetAllocation) {
		this.totalBudgetAllocation = totalBudgetAllocation;
	}

	public BigDecimal getApproved4YearFtes() {
		return approved4YearFtes;
	}

	public void setApproved4YearFtes(BigDecimal approved4YearFtes) {
		this.approved4YearFtes = approved4YearFtes;
	}

	public BigDecimal getFtesHiredToDate() {
		return ftesHiredToDate;
	}

	public void setFtesHiredToDate(BigDecimal ftesHiredToDate) {
		this.ftesHiredToDate = ftesHiredToDate;
	}

	public BigDecimal getFyExpenseForecast() {
		return fyExpenseForecast;
	}

	public void setFyExpenseForecast(BigDecimal fyExpenseForecast) {
		this.fyExpenseForecast = fyExpenseForecast;
	}

	public BigDecimal getP1() {
		return p1;
	}

	public void setP1(BigDecimal p1) {
		this.p1 = p1;
	}

	public BigDecimal getP2() {
		return p2;
	}

	public void setP2(BigDecimal p2) {
		this.p2 = p2;
	}

	public BigDecimal getP3() {
		return p3;
	}

	public void setP3(BigDecimal p3) {
		this.p3 = p3;
	}

	public BigDecimal getP4() {
		return p4;
	}

	public void setP4(BigDecimal p4) {
		this.p4 = p4;
	}

	public BigDecimal getP5() {
		return p5;
	}

	public void setP5(BigDecimal p5) {
		this.p5 = p5;
	}

	public BigDecimal getP6() {
		return p6;
	}

	public void setP6(BigDecimal p6) {
		this.p6 = p6;
	}

	public BigDecimal getP7() {
		return p7;
	}

	public void setP7(BigDecimal p7) {
		this.p7 = p7;
	}

	public BigDecimal getP8() {
		return p8;
	}

	public void setP8(BigDecimal p8) {
		this.p8 = p8;
	}

	public BigDecimal getP9() {
		return p9;
	}

	public void setP9(BigDecimal p9) {
		this.p9 = p9;
	}

	public BigDecimal getP10() {
		return p10;
	}

	public void setP10(BigDecimal p10) {
		this.p10 = p10;
	}

	public BigDecimal getP11() {
		return p11;
	}

	public void setP11(BigDecimal p11) {
		this.p11 = p11;
	}

	public BigDecimal getP12() {
		return p12;
	}

	public void setP12(BigDecimal p12) {
		this.p12 = p12;
	}

	public BigDecimal getP13() {
		return p13;
	}

	public void setP13(BigDecimal p13) {
		this.p13 = p13;
	}

	@Override
	public String getFileName() {
		return null;
	}

	@Override
	public String getFormType() {
		return PCDConstants.FR_PCN_FINANCIAL_TOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(submissionId);
		elements.add(expenseCategory);
		elements.add(expenseSubCategory);
		elements.add(formatBigDecimal(approvedBudget));
		elements.add(formatBigDecimal(approved4YearFtes));
		elements.add(formatBigDecimal(ftesHiredToDate));
		elements.add(formatBigDecimal(fyExpenseForecast));
		elements.add(formatBigDecimal(totalBudgetAllocation));
		elements.add(formatBigDecimal(p1));
		elements.add(formatBigDecimal(p2));
		elements.add(formatBigDecimal(p3));
		elements.add(formatBigDecimal(p4));
		elements.add(formatBigDecimal(p5));
		elements.add(formatBigDecimal(p6));
		elements.add(formatBigDecimal(p7));
		elements.add(formatBigDecimal(p8));
		elements.add(formatBigDecimal(p9));
		elements.add(formatBigDecimal(p10));
		elements.add(formatBigDecimal(p11));
		elements.add(formatBigDecimal(p12));
		elements.add(formatBigDecimal(p13));
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
