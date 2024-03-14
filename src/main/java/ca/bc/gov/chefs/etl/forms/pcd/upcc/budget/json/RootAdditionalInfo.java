package ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootAdditionalInfo {
    public String strategyTitle;
    public List<String> primaryTargetPopulation;
    
    public String getStrategyTitle() {
        return strategyTitle;
    }
    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle;
    }
    public List<String> getPrimaryTargetPopulation() {
        return primaryTargetPopulation;
    }
    public void setPrimaryTargetPopulation(List<String> primaryTargetPopulation) {
        this.primaryTargetPopulation = primaryTargetPopulation;
    }
}
