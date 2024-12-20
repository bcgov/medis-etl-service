package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommunityData {
    private String communityName;
    private String hsiarServicePlanGapAnalysis;
    private String hsiarServicePlanGapAnalysisDate;
    private String pcnCommunityId;
    private List<PCN> pcn;

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

    public String getHsiarServicePlanGapAnalysisDate() {
        return hsiarServicePlanGapAnalysisDate;
    }

    public void setHsiarServicePlanGapAnalysisDate(String hsiarServicePlanGapAnalysisDate) {
        this.hsiarServicePlanGapAnalysisDate = hsiarServicePlanGapAnalysisDate;
    }

    public List<PCN> getPcn() {
        return pcn;
    }

    public void setPcn(List<PCN> pcn) {
        this.pcn = pcn;
    }

    public String getPcnCommunityId() {
        return pcnCommunityId;
    }

    public void setPcnCommunityId(String pcnCommunityId) {
        this.pcnCommunityId = pcnCommunityId;
    }

}
