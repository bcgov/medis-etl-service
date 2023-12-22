package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommunityData {
    public String communityName;
    public String hsiarServicePlanGapAnalysis;
    public List<PCN> pcn;
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
    public List<PCN> getPcn() {
        return pcn;
    }
    public void setPcn(List<PCN> pcn) {
        this.pcn = pcn;
    }

}
