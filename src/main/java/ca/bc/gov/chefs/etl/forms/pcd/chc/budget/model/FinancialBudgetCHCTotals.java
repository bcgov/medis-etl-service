package ca.bc.gov.chefs.etl.forms.pcd.chc.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetCHCTotals implements IModel {

    public String submissionId;
    public String totalApprovedFtes;
    public String totalApprovedBudget;
    public String clinicalApprovedFtes;
    public String clinicalApprovedBudget;
    public String overheadApprovedBudget;
    public String otherResourcesApprovedFtes;
    public String otherResourcesApprovedBudget;
    public String oneTimeFundingApprovedBudget;

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

    public String getOverheadApprovedBudget() {
        return overheadApprovedBudget;
    }

    public void setOverheadApprovedBudget(String overheadApprovedBudget) {
        this.overheadApprovedBudget = overheadApprovedBudget;
    }

    public String getOtherResourcesApprovedFtes() {
        return otherResourcesApprovedFtes;
    }

    public void setOtherResourcesApprovedFtes(String otherResourcesApprovedFtes) {
        this.otherResourcesApprovedFtes = otherResourcesApprovedFtes;
    }

    public String getOtherResourcesApprovedBudget() {
        return otherResourcesApprovedBudget;
    }

    public void setOtherResourcesApprovedBudget(String otherResourcesApprovedBudget) {
        this.otherResourcesApprovedBudget = otherResourcesApprovedBudget;
    }

    public String getOneTimeFundingApprovedBudget() {
        return oneTimeFundingApprovedBudget;
    }

    public void setOneTimeFundingApprovedBudget(String oneTimeFundingApprovedBudget) {
        this.oneTimeFundingApprovedBudget = oneTimeFundingApprovedBudget;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public String getFormType() {
        return PCDConstants.FINANCIAL_BUDGET_CHC_TOTALS;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(totalApprovedFtes);
        elements.add(totalApprovedBudget);
        elements.add(clinicalApprovedFtes);
        elements.add(clinicalApprovedBudget);
        elements.add(overheadApprovedBudget);
        elements.add(otherResourcesApprovedFtes);
        elements.add(otherResourcesApprovedBudget);
        elements.add(oneTimeFundingApprovedBudget);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
}
