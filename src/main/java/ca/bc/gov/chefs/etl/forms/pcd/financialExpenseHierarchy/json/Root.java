package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.json.Form;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public Form form;
    public RootCHC chc;
    public RootPCN pcn;
    public RootUPCC upcc;
    public String lateEntry;
    public String expenseItemOptions;
    public String expenseItemSubTypesOptions;
    
    public String getCreatedAt(){
        return form.getCreatedAt();
    }
    public Form getForm() {
        return form;
    }
    public void setForm(Form form) {
        this.form = form;
    }
    public RootCHC getChc() {
        return chc;
    }
    public void setChc(RootCHC chc) {
        this.chc = chc;
    }
    public RootPCN getPcn() {
        return pcn;
    }
    public void setPcn(RootPCN pcn) {
        this.pcn = pcn;
    }
    public RootUPCC getUpcc() {
        return upcc;
    }
    public void setUpcc(RootUPCC upcc) {
        this.upcc = upcc;
    }
    public String getLateEntry() {
        return lateEntry;
    }
    public void setLateEntry(String lateEntry) {
        this.lateEntry = lateEntry;
    }
    public String getExpenseItemOptions() {
        return expenseItemOptions;
    }
    public void setExpenseItemOptions(String expenseItemOptions) {
        this.expenseItemOptions = expenseItemOptions;
    }
    public String getExpenseItemSubTypesOptions() {
        return expenseItemSubTypesOptions;
    }
    public void setExpenseItemSubTypesOptions(String expenseItemSubTypesOptions) {
        this.expenseItemSubTypesOptions = expenseItemSubTypesOptions;
    }

}
