package ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.json;

import java.util.List;

public class RootAdditionalSchedule1Info {
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
