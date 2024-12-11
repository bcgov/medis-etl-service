package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class Community implements IModel {
    private String submissionId;
    private String communityId;
    private String communityName;
    private String hsiarServicePlanGapAnalysis;
    private String hsiarServicePlanGapAnalysisDate;
    private String pcnCommunityCode;

    private List<PrimaryCareNetwork> primaryCareNetworks = new ArrayList<>();

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getHsiarServicePlanGapAnalysis() {
        return hsiarServicePlanGapAnalysis;
    }

    public void setHsiarServicePlanGapAnalysis(String hsiarServicePlanGapAnalysis) {
        this.hsiarServicePlanGapAnalysis = hsiarServicePlanGapAnalysis;
    }

    public List<PrimaryCareNetwork> getPrimaryCareNetworks() {
        return primaryCareNetworks;
    }

    public void setPrimaryCareNetworks(List<PrimaryCareNetwork> primaryCareNetworks) {
        this.primaryCareNetworks = primaryCareNetworks;
    }

    public String getHsiarServicePlanGapAnalysisDate() {
        return hsiarServicePlanGapAnalysisDate;
    }

    public void setHsiarServicePlanGapAnalysisDate(String hsiarServicePlanGapAnalysisDate) {
        this.hsiarServicePlanGapAnalysisDate = hsiarServicePlanGapAnalysisDate;
    }

    @Override
    public String getFileName() {
        return null;
    }

    public String getPcnCommunityCode() {
        return pcnCommunityCode;
    }

    public void setPcnCommunityCode(String pcnCommunityCode) {
        this.pcnCommunityCode = pcnCommunityCode;
    }

    @Override
    public String getFormType() {
        return PCDConstants.HA_HIERARCHY_COMMUNITY;
    }

    @Override
    public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();

        elements.add(submissionId);
        elements.add(communityId);
        elements.add(communityName);
        elements.add(hsiarServicePlanGapAnalysis);
        elements.add(hsiarServicePlanGapAnalysisDate);
        elements.add(pcnCommunityCode);

        return elements;
    }

    @Override
    public List<IModel> getObjects() {
        List<IModel> communityModels = new ArrayList<>();
        communityModels.addAll(primaryCareNetworks);
        return communityModels;
    }

}
