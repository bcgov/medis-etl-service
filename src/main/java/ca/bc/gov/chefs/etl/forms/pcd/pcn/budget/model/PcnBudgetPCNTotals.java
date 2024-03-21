package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class PcnBudgetPCNTotals implements IModel{

    private String submissionId;
    private String totalApprovedFtes;
    private String totalApprovedBudget;
    private String totalFtesInclRelief;
    private String totalTotalBudgetAllocation;
    private String clinicalApprovedFtes;
    private String clinicalApprovedBudget;
    private String clinicalFiscalYearFtes;
    private String clinicalBudgetAllocation;
    private String dofpApprovedFtes;
    private String dofpApprovedBudget;
    private String dofpFiscalYearFtes;
    private String dofpBudgetAllocation;
    private String dofpResourcesApprovedFtes;
    private String dofpResourcesApprovedBudget;
    private String dofpResourcesFiscalYearFtes;
    private String dofpResourcesAllocation;
    private String physicianApprovedFtes;
    private String physicianApprovedBudget;
    private String physicianFiscalYearFtes;
    private String physicianBudgetAllocation;
    private String healthAuthorityApprovedFtes;
    private String healthAuthorityApprovedBudget;
    private String healthAuthorityFiscalYearFtes;
    private String healthAuthorityBudgetAllocation;
    private String overheadApprovedBudget;
    private String overheadBudgetAllocation;
    private String overheadDofpApprovedBudget;
    private String overheadDofpBudgetAllocation;
    private String oneTimeFundingBudgetAllocation;
    private String oneTimeFundingDofpAllocation;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getTotalApprovedFtes() {
        return totalApprovedFtes;
    }

    public void setTotalApprovedFtes(String totalApprovedFtes) {
        this.totalApprovedFtes = totalApprovedFtes;
    }

    public String getTotalApprovedBudget() {
        return totalApprovedBudget;
    }

    public void setTotalApprovedBudget(String totalApprovedBudget) {
        this.totalApprovedBudget = totalApprovedBudget;
    }

    public String getTotalFtesInclRelief() {
        return totalFtesInclRelief;
    }

    public void setTotalFtesInclRelief(String totalFtesInclRelief) {
        this.totalFtesInclRelief = totalFtesInclRelief;
    }

    public String getTotalTotalBudgetAllocation() {
        return totalTotalBudgetAllocation;
    }

    public void setTotalTotalBudgetAllocation(String totalTotalBudgetAllocation) {
        this.totalTotalBudgetAllocation = totalTotalBudgetAllocation;
    }

    public String getClinicalApprovedFtes() {
        return clinicalApprovedFtes;
    }

    public void setClinicalApprovedFtes(String clinicalApprovedFtes) {
        this.clinicalApprovedFtes = clinicalApprovedFtes;
    }

    public String getClinicalApprovedBudget() {
        return clinicalApprovedBudget;
    }

    public void setClinicalApprovedBudget(String clinicalApprovedBudget) {
        this.clinicalApprovedBudget = clinicalApprovedBudget;
    }

    public String getClinicalFiscalYearFtes() {
        return clinicalFiscalYearFtes;
    }

    public void setClinicalFiscalYearFtes(String clinicalFiscalYearFtes) {
        this.clinicalFiscalYearFtes = clinicalFiscalYearFtes;
    }

    public String getClinicalBudgetAllocation() {
        return clinicalBudgetAllocation;
    }

    public void setClinicalBudgetAllocation(String clinicalBudgetAllocation) {
        this.clinicalBudgetAllocation = clinicalBudgetAllocation;
    }

    public String getDofpApprovedFtes() {
        return dofpApprovedFtes;
    }

    public void setDofpApprovedFtes(String dofpApprovedFtes) {
        this.dofpApprovedFtes = dofpApprovedFtes;
    }

    public String getDofpApprovedBudget() {
        return dofpApprovedBudget;
    }

    public void setDofpApprovedBudget(String dofpApprovedBudget) {
        this.dofpApprovedBudget = dofpApprovedBudget;
    }

    public String getDofpFiscalYearFtes() {
        return dofpFiscalYearFtes;
    }

    public void setDofpFiscalYearFtes(String dofpFiscalYearFtes) {
        this.dofpFiscalYearFtes = dofpFiscalYearFtes;
    }

    public String getDofpBudgetAllocation() {
        return dofpBudgetAllocation;
    }

    public void setDofpBudgetAllocation(String dofpBudgetAllocation) {
        this.dofpBudgetAllocation = dofpBudgetAllocation;
    }

    public String getDofpResourcesApprovedFtes() {
        return dofpResourcesApprovedFtes;
    }

    public void setDofpResourcesApprovedFtes(String dofpResourcesApprovedFtes) {
        this.dofpResourcesApprovedFtes = dofpResourcesApprovedFtes;
    }

    public String getDofpResourcesApprovedBudget() {
        return dofpResourcesApprovedBudget;
    }

    public void setDofpResourcesApprovedBudget(String dofpResourcesApprovedBudget) {
        this.dofpResourcesApprovedBudget = dofpResourcesApprovedBudget;
    }

    public String getDofpResourcesFiscalYearFtes() {
        return dofpResourcesFiscalYearFtes;
    }

    public void setDofpResourcesFiscalYearFtes(String dofpResourcesFiscalYearFtes) {
        this.dofpResourcesFiscalYearFtes = dofpResourcesFiscalYearFtes;
    }

    public String getDofpResourcesAllocation() {
        return dofpResourcesAllocation;
    }

    public void setDofpResourcesAllocation(String dofpResourcesAllocation) {
        this.dofpResourcesAllocation = dofpResourcesAllocation;
    }

    public String getPhysicianApprovedFtes() {
        return physicianApprovedFtes;
    }

    public void setPhysicianApprovedFtes(String physicianApprovedFtes) {
        this.physicianApprovedFtes = physicianApprovedFtes;
    }

    public String getPhysicianApprovedBudget() {
        return physicianApprovedBudget;
    }

    public void setPhysicianApprovedBudget(String physicianApprovedBudget) {
        this.physicianApprovedBudget = physicianApprovedBudget;
    }

    public String getPhysicianFiscalYearFtes() {
        return physicianFiscalYearFtes;
    }

    public void setPhysicianFiscalYearFtes(String physicianFiscalYearFtes) {
        this.physicianFiscalYearFtes = physicianFiscalYearFtes;
    }

    public String getPhysicianBudgetAllocation() {
        return physicianBudgetAllocation;
    }

    public void setPhysicianBudgetAllocation(String physicianBudgetAllocation) {
        this.physicianBudgetAllocation = physicianBudgetAllocation;
    }

    public String getHealthAuthorityApprovedFtes() {
        return healthAuthorityApprovedFtes;
    }

    public void setHealthAuthorityApprovedFtes(String healthAuthorityApprovedFtes) {
        this.healthAuthorityApprovedFtes = healthAuthorityApprovedFtes;
    }

    public String getHealthAuthorityApprovedBudget() {
        return healthAuthorityApprovedBudget;
    }

    public void setHealthAuthorityApprovedBudget(String healthAuthorityApprovedBudget) {
        this.healthAuthorityApprovedBudget = healthAuthorityApprovedBudget;
    }

    public String getHealthAuthorityFiscalYearFtes() {
        return healthAuthorityFiscalYearFtes;
    }

    public void setHealthAuthorityFiscalYearFtes(String healthAuthorityFiscalYearFtes) {
        this.healthAuthorityFiscalYearFtes = healthAuthorityFiscalYearFtes;
    }

    public String getHealthAuthorityBudgetAllocation() {
        return healthAuthorityBudgetAllocation;
    }

    public void setHealthAuthorityBudgetAllocation(String healthAuthorityBudgetAllocation) {
        this.healthAuthorityBudgetAllocation = healthAuthorityBudgetAllocation;
    }

    public String getOverheadApprovedBudget() {
        return overheadApprovedBudget;
    }

    public void setOverheadApprovedBudget(String overheadApprovedBudget) {
        this.overheadApprovedBudget = overheadApprovedBudget;
    }

    public String getOverheadBudgetAllocation() {
        return overheadBudgetAllocation;
    }

    public void setOverheadBudgetAllocation(String overheadBudgetAllocation) {
        this.overheadBudgetAllocation = overheadBudgetAllocation;
    }

    public String getOverheadDofpApprovedBudget() {
        return overheadDofpApprovedBudget;
    }

    public void setOverheadDofpApprovedBudget(String overheadDofpApprovedBudget) {
        this.overheadDofpApprovedBudget = overheadDofpApprovedBudget;
    }

    public String getOverheadDofpBudgetAllocation() {
        return overheadDofpBudgetAllocation;
    }

    public void setOverheadDofpBudgetAllocation(String overheadDofpBudgetAllocation) {
        this.overheadDofpBudgetAllocation = overheadDofpBudgetAllocation;
    }

    public String getOneTimeFundingBudgetAllocation() {
        return oneTimeFundingBudgetAllocation;
    }

    public void setOneTimeFundingBudgetAllocation(String oneTimeFundingBudgetAllocation) {
        this.oneTimeFundingBudgetAllocation = oneTimeFundingBudgetAllocation;
    }

    public String getOneTimeFundingDofpAllocation() {
        return oneTimeFundingDofpAllocation;
    }

    public void setOneTimeFundingDofpAllocation(String oneTimeFundingDofpAllocation) {
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
        elements.add(totalApprovedFtes);
        elements.add(totalApprovedBudget);
        elements.add(totalFtesInclRelief);
        elements.add(totalTotalBudgetAllocation);
        elements.add(clinicalApprovedFtes);
        elements.add(clinicalApprovedBudget);
        elements.add(clinicalFiscalYearFtes);
        elements.add(clinicalBudgetAllocation);
        elements.add(dofpApprovedFtes);
        elements.add(dofpApprovedBudget);
        elements.add(dofpFiscalYearFtes);
        elements.add(dofpBudgetAllocation);
        elements.add(dofpResourcesApprovedFtes);
        elements.add(dofpResourcesApprovedBudget);
        elements.add(dofpResourcesFiscalYearFtes);
        elements.add(dofpResourcesAllocation);
        elements.add(physicianApprovedFtes);
        elements.add(physicianApprovedBudget);
        elements.add(physicianFiscalYearFtes);
        elements.add(physicianBudgetAllocation);
        elements.add(healthAuthorityApprovedFtes);
        elements.add(healthAuthorityApprovedBudget);
        elements.add(healthAuthorityFiscalYearFtes);
        elements.add(healthAuthorityBudgetAllocation);
        elements.add(overheadApprovedBudget);
        elements.add(overheadBudgetAllocation);
        elements.add(overheadDofpApprovedBudget);
        elements.add(overheadDofpBudgetAllocation);
        elements.add(oneTimeFundingBudgetAllocation);
        elements.add(oneTimeFundingDofpAllocation);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
    
}
