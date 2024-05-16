package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model;

import static ca.bc.gov.chefs.etl.util.CSVUtil.formatBigDecimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetPCNTotals implements IModel {

    private String submissionId;

    // Family Physicians
    private BigDecimal physicianApprovedFtes = BigDecimal.ZERO;
    private BigDecimal physicianApprovedBudget = BigDecimal.ZERO;
    private BigDecimal physicianFiscalYearFtes = BigDecimal.ZERO;
    private BigDecimal physicianBudgetAllocation = BigDecimal.ZERO;

    // Health Authority
    private BigDecimal clinicalApprovedFtes = BigDecimal.ZERO;
    private BigDecimal clinicalApprovedBudget = BigDecimal.ZERO;
    private BigDecimal clinicalFiscalYearFtes = BigDecimal.ZERO;
    private BigDecimal clinicalBudgetAllocation = BigDecimal.ZERO;

    private BigDecimal overheadApprovedBudget = BigDecimal.ZERO;
    private BigDecimal overheadBudgetAllocation = BigDecimal.ZERO;

    private BigDecimal oneTimeFundingBudgetAllocation = BigDecimal.ZERO;

    // Division of Family Practice
    private BigDecimal dofpResourcesApprovedFtes = BigDecimal.ZERO;
    private BigDecimal dofpResourcesApprovedBudget = BigDecimal.ZERO;
    private BigDecimal dofpResourcesFiscalYearFtes = BigDecimal.ZERO;
    private BigDecimal dofpResourcesAllocation = BigDecimal.ZERO;

    private BigDecimal overheadDofpApprovedBudget = BigDecimal.ZERO;
    private BigDecimal overheadDofpBudgetAllocation = BigDecimal.ZERO;

    private BigDecimal oneTimeFundingDofpAllocation = BigDecimal.ZERO;

    public FinancialBudgetPCNTotals(String submissionId) {
        super();
        this.submissionId = submissionId;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public BigDecimal getPhysicianApprovedFtes() {
        return physicianApprovedFtes;
    }

    public void setPhysicianApprovedFtes(BigDecimal physicianApprovedFtes) {
        this.physicianApprovedFtes = physicianApprovedFtes;
    }

    public BigDecimal getPhysicianApprovedBudget() {
        return physicianApprovedBudget;
    }

    public void setPhysicianApprovedBudget(BigDecimal physicianApprovedBudget) {
        this.physicianApprovedBudget = physicianApprovedBudget;
    }

    public BigDecimal getPhysicianFiscalYearFtes() {
        return physicianFiscalYearFtes;
    }

    public void setPhysicianFiscalYearFtes(BigDecimal physicianFiscalYearFtes) {
        this.physicianFiscalYearFtes = physicianFiscalYearFtes;
    }

    public BigDecimal getPhysicianBudgetAllocation() {
        return physicianBudgetAllocation;
    }

    public void setPhysicianBudgetAllocation(BigDecimal physicianBudgetAllocation) {
        this.physicianBudgetAllocation = physicianBudgetAllocation;
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

    public BigDecimal getClinicalFiscalYearFtes() {
        return clinicalFiscalYearFtes;
    }

    public void setClinicalFiscalYearFtes(BigDecimal clinicalFiscalYearFtes) {
        this.clinicalFiscalYearFtes = clinicalFiscalYearFtes;
    }

    public BigDecimal getClinicalBudgetAllocation() {
        return clinicalBudgetAllocation;
    }

    public void setClinicalBudgetAllocation(BigDecimal clinicalBudgetAllocation) {
        this.clinicalBudgetAllocation = clinicalBudgetAllocation;
    }

    public BigDecimal getOverheadApprovedBudget() {
        return overheadApprovedBudget;
    }

    public void setOverheadApprovedBudget(BigDecimal overheadApprovedBudget) {
        this.overheadApprovedBudget = overheadApprovedBudget;
    }

    public BigDecimal getOverheadBudgetAllocation() {
        return overheadBudgetAllocation;
    }

    public void setOverheadBudgetAllocation(BigDecimal overheadBudgetAllocation) {
        this.overheadBudgetAllocation = overheadBudgetAllocation;
    }

    public BigDecimal getOneTimeFundingBudgetAllocation() {
        return oneTimeFundingBudgetAllocation;
    }

    public void setOneTimeFundingBudgetAllocation(BigDecimal oneTimeFundingBudgetAllocation) {
        this.oneTimeFundingBudgetAllocation = oneTimeFundingBudgetAllocation;
    }

    public BigDecimal getDofpResourcesApprovedFtes() {
        return dofpResourcesApprovedFtes;
    }

    public void setDofpResourcesApprovedFtes(BigDecimal dofpResourcesApprovedFtes) {
        this.dofpResourcesApprovedFtes = dofpResourcesApprovedFtes;
    }

    public BigDecimal getDofpResourcesApprovedBudget() {
        return dofpResourcesApprovedBudget;
    }

    public void setDofpResourcesApprovedBudget(BigDecimal dofpResourcesApprovedBudget) {
        this.dofpResourcesApprovedBudget = dofpResourcesApprovedBudget;
    }

    public BigDecimal getDofpResourcesFiscalYearFtes() {
        return dofpResourcesFiscalYearFtes;
    }

    public void setDofpResourcesFiscalYearFtes(BigDecimal dofpResourcesFiscalYearFtes) {
        this.dofpResourcesFiscalYearFtes = dofpResourcesFiscalYearFtes;
    }

    public BigDecimal getDofpResourcesAllocation() {
        return dofpResourcesAllocation;
    }

    public void setDofpResourcesAllocation(BigDecimal dofpResourcesAllocation) {
        this.dofpResourcesAllocation = dofpResourcesAllocation;
    }

    public BigDecimal getOverheadDofpApprovedBudget() {
        return overheadDofpApprovedBudget;
    }

    public void setOverheadDofpApprovedBudget(BigDecimal overheadDofpApprovedBudget) {
        this.overheadDofpApprovedBudget = overheadDofpApprovedBudget;
    }

    public BigDecimal getOverheadDofpBudgetAllocation() {
        return overheadDofpBudgetAllocation;
    }

    public void setOverheadDofpBudgetAllocation(BigDecimal overheadDofpBudgetAllocation) {
        this.overheadDofpBudgetAllocation = overheadDofpBudgetAllocation;
    }

    public BigDecimal getOneTimeFundingDofpAllocation() {
        return oneTimeFundingDofpAllocation;
    }

    public void setOneTimeFundingDofpAllocation(BigDecimal oneTimeFundingDofpAllocation) {
        this.oneTimeFundingDofpAllocation = oneTimeFundingDofpAllocation;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FINANCIAL_BUDGET_PCN_TOTALS;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(formatBigDecimal(clinicalApprovedFtes));
        elements.add(formatBigDecimal(clinicalApprovedBudget));
        elements.add(formatBigDecimal(clinicalFiscalYearFtes));
        elements.add(formatBigDecimal(clinicalBudgetAllocation));
        elements.add(formatBigDecimal(dofpResourcesApprovedFtes));
        elements.add(formatBigDecimal(dofpResourcesApprovedBudget));
        elements.add(formatBigDecimal(dofpResourcesFiscalYearFtes));
        elements.add(formatBigDecimal(dofpResourcesAllocation));
        elements.add(formatBigDecimal(physicianApprovedFtes));
        elements.add(formatBigDecimal(physicianApprovedBudget));
        elements.add(formatBigDecimal(physicianFiscalYearFtes));
        elements.add(formatBigDecimal(physicianBudgetAllocation));
        elements.add(formatBigDecimal(overheadApprovedBudget));
        elements.add(formatBigDecimal(overheadBudgetAllocation));
        elements.add(formatBigDecimal(overheadDofpApprovedBudget));
        elements.add(formatBigDecimal(overheadDofpBudgetAllocation));
        elements.add(formatBigDecimal(oneTimeFundingBudgetAllocation));
        elements.add(formatBigDecimal(oneTimeFundingDofpAllocation));
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }

}
