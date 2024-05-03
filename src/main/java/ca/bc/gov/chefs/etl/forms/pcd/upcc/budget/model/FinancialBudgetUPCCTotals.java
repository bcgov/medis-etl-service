package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class FinancialBudgetUPCCTotals implements IModel {

    public String submissionId;
    public String clinicalApprovedFtes;
    public String clinicalApprovedBudget;
    public String overheadApprovedBudget;
    public String oneTimeFundingApprovedBudget;

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
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
        return PCDConstants.FINANCIAL_BUDGET_UPCC_TOTALS;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
        elements.add(submissionId);
        elements.add(clinicalApprovedFtes);
        elements.add(clinicalApprovedBudget);
        elements.add(overheadApprovedBudget);
        elements.add(oneTimeFundingApprovedBudget);
        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        return new ArrayList<>();
    }
}
