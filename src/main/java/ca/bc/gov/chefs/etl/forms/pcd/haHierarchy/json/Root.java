package ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public String healthAuthority;
    public String lateEntry;
    public List<CommunityData> communities;
    public Form getForm() {
        return form;
    }
    public void setForm(Form form) {
        this.form = form;
    }
    public String getHealthAuthority() {
        return healthAuthority;
    }
    public void setHealthAuthority(String healthAuthority) {
        this.healthAuthority = healthAuthority;
    }
    public String getLateEntry() {
        return lateEntry;
    }
    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }
    public List<CommunityData> getCommunities() {
        return communities;
    }
    public void setCommunities(List<CommunityData> communities) {
        this.communities = communities;
    }
}
