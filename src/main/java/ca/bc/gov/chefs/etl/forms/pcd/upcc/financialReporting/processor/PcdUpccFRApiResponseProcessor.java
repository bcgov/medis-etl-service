package ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.json.RootFinancial;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FRUpccFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.model.FinancialReportingUpccSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdUpccFRApiResponseProcessor extends BaseApiResponseProcessor{

    private static final String FINANCIAL_CATEGORY_CLINICAL = "clinical";
    private static final String FINANCIAL_CATEGORY_OVERHEAD = "overhead";
    private static final String FINANCIAL_CATEGORY_OTF = "oneTimeFunding";
    private static final String FINANCIAL_SUBCATEGORY_LC = "longitudinalCare";
    private static final String FINANCIAL_SUBCATEGORY_UC = "urgentCare";
    private static final String FINANCIAL_SUBCATEGORY_MS = "mixedStream";

	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> upccFRModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<FinancialReportingUpccSubmission> parsedUpccFR = parseUpccFRRequest(upccFRModels);
		
		validateRecordCount(upccFRModels, parsedUpccFR);
		
		List<IModel> iModels = (List<IModel>) (List<?>) parsedUpccFR;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_UPCC_FR_DIR, isHeaderAdded);

		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setFiles(filesGenerated);
		exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
    
    private List<FinancialReportingUpccSubmission> parseUpccFRRequest(List<Root> upccFRPayloads){
        List<FinancialReportingUpccSubmission> parsedUpccFR = new ArrayList<>();
        for(Root root : upccFRPayloads){
            FinancialReportingUpccSubmission financialReportingUpccSubmission = new FinancialReportingUpccSubmission();
            List<FRUpccFinancialData> upccFinancialData = new ArrayList<>();

            /** mapping FinancialReprotingUPCCSubmission */
            financialReportingUpccSubmission.setSubmissionId(root.getForm().getSubmissionId());
            financialReportingUpccSubmission.setCreatedAt(root.getForm().getCreatedAt());
            financialReportingUpccSubmission.setLateEntry(root.getLateEntry());
            financialReportingUpccSubmission.setSubmitterFullName(root.getForm().getFullName());
            financialReportingUpccSubmission.setSubmitterUserName(root.getForm().getUsername());
            financialReportingUpccSubmission.setSubmitterEmail(root.getForm().getEmail());
            financialReportingUpccSubmission.setSubmissionStatus(root.getForm().getStatus());
            financialReportingUpccSubmission.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
            financialReportingUpccSubmission.setSubmissionFormName(root.getForm().getFormName());
            financialReportingUpccSubmission.setHealthAuthority(root.getHealthAuthority());
            financialReportingUpccSubmission.setCommunityName(root.getCommunityName());
            financialReportingUpccSubmission.setUppcName(root.getUpccName());
            financialReportingUpccSubmission.setFiscalYear(root.getFiscalYear());
            financialReportingUpccSubmission.setInterimReported(root.getPeriodReported());
            financialReportingUpccSubmission.setReasonForExceptionInPeriodReported(root.getReasonForExceptionInPeriodReported());
            financialReportingUpccSubmission.setAdditionalNotes(root.getFinancialData().getAdditionalNotes());

            /** mapping FRUpccFinancialData */
            for(RootFinancial ucFinancial : root.getFinancialData().getClinical().getUrgentCare().getFinancials()){
                if(!ucFinancial.getExpenseItem().isEmpty() && ucFinancial.getExpenseItem() != null){
                    FRUpccFinancialData newFinancialData = new FRUpccFinancialData();
                    newFinancialData.setSubmissionId(root.getForm().getSubmissionId());
                    newFinancialData.setFinancialSection(FINANCIAL_CATEGORY_CLINICAL);
                    newFinancialData.setFinancialSubSection(FINANCIAL_SUBCATEGORY_UC);
                    newFinancialData.setApprovedBudget(ucFinancial.getApprovedBudget());
                    newFinancialData.setApprovedFtesInclRelief(ucFinancial.getApprovedFtesInclRelief());
                    newFinancialData.setExpenseCategory(ucFinancial.getExpenseCategory());
                    newFinancialData.setExpenseItem(ucFinancial.getExpenseItem());
                    newFinancialData.setExpenseItemSubType(ucFinancial.getExpenseItemSubType());
                    newFinancialData.setExpenseSubCategory(ucFinancial.getExpenseSubCategory());
                    newFinancialData.setFtesHiredToDate(ucFinancial.getFtesHiredToDate());
                    newFinancialData.setFyExpenseForecast(ucFinancial.getFyExpenseForecast());
                    newFinancialData.setFyEstimatedSurplus(ucFinancial.getFyEstimatedSurplus());
                    newFinancialData.setFyExpenseVariance(ucFinancial.getFyExpenseVariance());
                    newFinancialData.setFyExpenseVarianceNote(ucFinancial.getFyExpenseVarianceNote());
                    newFinancialData.setP1(ucFinancial.getP1());
                    newFinancialData.setP2(ucFinancial.getP2());
                    newFinancialData.setP3(ucFinancial.getP3());
                    newFinancialData.setP4(ucFinancial.getP4());
                    newFinancialData.setP5(ucFinancial.getP5());
                    newFinancialData.setP6(ucFinancial.getP6());
                    newFinancialData.setP7(ucFinancial.getP7());
                    newFinancialData.setP8(ucFinancial.getP8());
                    newFinancialData.setP9(ucFinancial.getP9());
                    newFinancialData.setP10(ucFinancial.getP10());
                    newFinancialData.setP11(ucFinancial.getP11());
                    newFinancialData.setP12(ucFinancial.getP12());
                    newFinancialData.setP13(ucFinancial.getP13());
                    newFinancialData.setProratedYtdBudget(ucFinancial.getProratedYtdBudget());
                    newFinancialData.setTotalActualYtdExpenses(ucFinancial.getTotalActualYtdExpenses());
                    newFinancialData.setTypeOfCare(ucFinancial.getTypeOfCare());
                    newFinancialData.setYtdExpenseVariance(ucFinancial.getYtdExpenseVariance());
                    newFinancialData.setYtdExpenseVarianceNote(ucFinancial.getYtdExpenseVarianceNote());
    
                    upccFinancialData.add(newFinancialData);
                }
            }
            
            for(RootFinancial lcFinancial : root.getFinancialData().getClinical().getLongitudinalCare().getFinancials()){
                if(!lcFinancial.getExpenseItem().isEmpty() && lcFinancial.getExpenseItem() != null){
                    FRUpccFinancialData newFinancialData = new FRUpccFinancialData();
                    newFinancialData.setSubmissionId(root.getForm().getSubmissionId());
                    newFinancialData.setFinancialSection(FINANCIAL_CATEGORY_CLINICAL);
                    newFinancialData.setFinancialSubSection(FINANCIAL_SUBCATEGORY_LC);
                    newFinancialData.setApprovedBudget(lcFinancial.getApprovedBudget());
                    newFinancialData.setApprovedFtesInclRelief(lcFinancial.getApprovedFtesInclRelief());
                    newFinancialData.setExpenseCategory(lcFinancial.getExpenseCategory());
                    newFinancialData.setExpenseItem(lcFinancial.getExpenseItem());
                    newFinancialData.setExpenseItemSubType(lcFinancial.getExpenseItemSubType());
                    newFinancialData.setExpenseSubCategory(lcFinancial.getExpenseSubCategory());
                    newFinancialData.setFtesHiredToDate(lcFinancial.getFtesHiredToDate());
                    newFinancialData.setFyExpenseForecast(lcFinancial.getFyExpenseForecast());
                    newFinancialData.setFyEstimatedSurplus(lcFinancial.getFyEstimatedSurplus());
                    newFinancialData.setFyExpenseVariance(lcFinancial.getFyExpenseVariance());
                    newFinancialData.setFyExpenseVarianceNote(lcFinancial.getFyExpenseVarianceNote());
                    newFinancialData.setP1(lcFinancial.getP1());
                    newFinancialData.setP2(lcFinancial.getP2());
                    newFinancialData.setP3(lcFinancial.getP3());
                    newFinancialData.setP4(lcFinancial.getP4());
                    newFinancialData.setP5(lcFinancial.getP5());
                    newFinancialData.setP6(lcFinancial.getP6());
                    newFinancialData.setP7(lcFinancial.getP7());
                    newFinancialData.setP8(lcFinancial.getP8());
                    newFinancialData.setP9(lcFinancial.getP9());
                    newFinancialData.setP10(lcFinancial.getP10());
                    newFinancialData.setP11(lcFinancial.getP11());
                    newFinancialData.setP12(lcFinancial.getP12());
                    newFinancialData.setP13(lcFinancial.getP13());
                    newFinancialData.setProratedYtdBudget(lcFinancial.getProratedYtdBudget());
                    newFinancialData.setTotalActualYtdExpenses(lcFinancial.getTotalActualYtdExpenses());
                    newFinancialData.setTypeOfCare(lcFinancial.getTypeOfCare());
                    newFinancialData.setYtdExpenseVariance(lcFinancial.getYtdExpenseVariance());
                    newFinancialData.setYtdExpenseVarianceNote(lcFinancial.getYtdExpenseVarianceNote());
    
                    upccFinancialData.add(newFinancialData);
                }
            }

            for(RootFinancial msFinancial : root.getFinancialData().getClinical().getMixedStream().getFinancials()){
                if(!msFinancial.getExpenseItem().isEmpty() && msFinancial.getExpenseItem() != null){
                    FRUpccFinancialData newFinancialData = new FRUpccFinancialData();
                    newFinancialData.setSubmissionId(root.getForm().getSubmissionId());
                    newFinancialData.setFinancialSection(FINANCIAL_CATEGORY_CLINICAL);
                    newFinancialData.setFinancialSubSection(FINANCIAL_SUBCATEGORY_MS);
                    newFinancialData.setApprovedBudget(msFinancial.getApprovedBudget());
                    newFinancialData.setApprovedFtesInclRelief(msFinancial.getApprovedFtesInclRelief());
                    newFinancialData.setExpenseCategory(msFinancial.getExpenseCategory());
                    newFinancialData.setExpenseItem(msFinancial.getExpenseItem());
                    newFinancialData.setExpenseItemSubType(msFinancial.getExpenseItemSubType());
                    newFinancialData.setExpenseSubCategory(msFinancial.getExpenseSubCategory());
                    newFinancialData.setFtesHiredToDate(msFinancial.getFtesHiredToDate());
                    newFinancialData.setFyExpenseForecast(msFinancial.getFyExpenseForecast());
                    newFinancialData.setFyEstimatedSurplus(msFinancial.getFyEstimatedSurplus());
                    newFinancialData.setFyExpenseVariance(msFinancial.getFyExpenseVariance());
                    newFinancialData.setFyExpenseVarianceNote(msFinancial.getFyExpenseVarianceNote());
                    newFinancialData.setP1(msFinancial.getP1());
                    newFinancialData.setP2(msFinancial.getP2());
                    newFinancialData.setP3(msFinancial.getP3());
                    newFinancialData.setP4(msFinancial.getP4());
                    newFinancialData.setP5(msFinancial.getP5());
                    newFinancialData.setP6(msFinancial.getP6());
                    newFinancialData.setP7(msFinancial.getP7());
                    newFinancialData.setP8(msFinancial.getP8());
                    newFinancialData.setP9(msFinancial.getP9());
                    newFinancialData.setP10(msFinancial.getP10());
                    newFinancialData.setP11(msFinancial.getP11());
                    newFinancialData.setP12(msFinancial.getP12());
                    newFinancialData.setP13(msFinancial.getP13());
                    newFinancialData.setProratedYtdBudget(msFinancial.getProratedYtdBudget());
                    newFinancialData.setTotalActualYtdExpenses(msFinancial.getTotalActualYtdExpenses());
                    newFinancialData.setTypeOfCare(msFinancial.getTypeOfCare());
                    newFinancialData.setYtdExpenseVariance(msFinancial.getYtdExpenseVariance());
                    newFinancialData.setYtdExpenseVarianceNote(msFinancial.getYtdExpenseVarianceNote());
    
                    upccFinancialData.add(newFinancialData);
                }
            }

            for(RootFinancial otfFinancial : root.getFinancialData().getOneTimeFunding().getFinancials()){
                if(!otfFinancial.getExpenseItem().isEmpty() && otfFinancial.getExpenseItem() != null){
                    FRUpccFinancialData newFinancialData = new FRUpccFinancialData();
                    newFinancialData.setSubmissionId(root.getForm().getSubmissionId());
                    newFinancialData.setFinancialSection(FINANCIAL_CATEGORY_OTF);
                    newFinancialData.setFinancialSubSection(null);
                    newFinancialData.setApprovedBudget(otfFinancial.getApprovedBudget());
                    newFinancialData.setApprovedFtesInclRelief(otfFinancial.getApprovedFtesInclRelief());
                    newFinancialData.setExpenseCategory(otfFinancial.getExpenseCategory());
                    newFinancialData.setExpenseItem(otfFinancial.getExpenseItem());
                    newFinancialData.setExpenseItemSubType(otfFinancial.getExpenseItemSubType());
                    newFinancialData.setExpenseSubCategory(otfFinancial.getExpenseSubCategory());
                    newFinancialData.setFtesHiredToDate(otfFinancial.getFtesHiredToDate());
                    newFinancialData.setFyExpenseForecast(otfFinancial.getFyExpenseForecast());
                    newFinancialData.setFyEstimatedSurplus(otfFinancial.getFyEstimatedSurplus());
                    newFinancialData.setFyExpenseVariance(otfFinancial.getFyExpenseVariance());
                    newFinancialData.setFyExpenseVarianceNote(otfFinancial.getFyExpenseVarianceNote());
                    newFinancialData.setP1(otfFinancial.getP1());
                    newFinancialData.setP2(otfFinancial.getP2());
                    newFinancialData.setP3(otfFinancial.getP3());
                    newFinancialData.setP4(otfFinancial.getP4());
                    newFinancialData.setP5(otfFinancial.getP5());
                    newFinancialData.setP6(otfFinancial.getP6());
                    newFinancialData.setP7(otfFinancial.getP7());
                    newFinancialData.setP8(otfFinancial.getP8());
                    newFinancialData.setP9(otfFinancial.getP9());
                    newFinancialData.setP10(otfFinancial.getP10());
                    newFinancialData.setP11(otfFinancial.getP11());
                    newFinancialData.setP12(otfFinancial.getP12());
                    newFinancialData.setP13(otfFinancial.getP13());
                    newFinancialData.setProratedYtdBudget(otfFinancial.getProratedYtdBudget());
                    newFinancialData.setTotalActualYtdExpenses(otfFinancial.getTotalActualYtdExpenses());
                    newFinancialData.setTypeOfCare(otfFinancial.getTypeOfCare());
                    newFinancialData.setYtdExpenseVariance(otfFinancial.getYtdExpenseVariance());
                    newFinancialData.setYtdExpenseVarianceNote(otfFinancial.getYtdExpenseVarianceNote());
    
                    upccFinancialData.add(newFinancialData);
                }
            }

            for(RootFinancial overheadFinancial : root.getFinancialData().getOneTimeFunding().getFinancials()){
                if(!overheadFinancial.getExpenseItem().isEmpty() && overheadFinancial.getExpenseItem() != null){
                    FRUpccFinancialData newFinancialData = new FRUpccFinancialData();
                    newFinancialData.setSubmissionId(root.getForm().getSubmissionId());
                    newFinancialData.setFinancialSection(FINANCIAL_CATEGORY_OVERHEAD);
                    newFinancialData.setFinancialSubSection(null);
                    newFinancialData.setApprovedBudget(overheadFinancial.getApprovedBudget());
                    newFinancialData.setApprovedFtesInclRelief(overheadFinancial.getApprovedFtesInclRelief());
                    newFinancialData.setExpenseCategory(overheadFinancial.getExpenseCategory());
                    newFinancialData.setExpenseItem(overheadFinancial.getExpenseItem());
                    newFinancialData.setExpenseItemSubType(overheadFinancial.getExpenseItemSubType());
                    newFinancialData.setExpenseSubCategory(overheadFinancial.getExpenseSubCategory());
                    newFinancialData.setFtesHiredToDate(overheadFinancial.getFtesHiredToDate());
                    newFinancialData.setFyExpenseForecast(overheadFinancial.getFyExpenseForecast());
                    newFinancialData.setFyEstimatedSurplus(overheadFinancial.getFyEstimatedSurplus());
                    newFinancialData.setFyExpenseVariance(overheadFinancial.getFyExpenseVariance());
                    newFinancialData.setFyExpenseVarianceNote(overheadFinancial.getFyExpenseVarianceNote());
                    newFinancialData.setP1(overheadFinancial.getP1());
                    newFinancialData.setP2(overheadFinancial.getP2());
                    newFinancialData.setP3(overheadFinancial.getP3());
                    newFinancialData.setP4(overheadFinancial.getP4());
                    newFinancialData.setP5(overheadFinancial.getP5());
                    newFinancialData.setP6(overheadFinancial.getP6());
                    newFinancialData.setP7(overheadFinancial.getP7());
                    newFinancialData.setP8(overheadFinancial.getP8());
                    newFinancialData.setP9(overheadFinancial.getP9());
                    newFinancialData.setP10(overheadFinancial.getP10());
                    newFinancialData.setP11(overheadFinancial.getP11());
                    newFinancialData.setP12(overheadFinancial.getP12());
                    newFinancialData.setP13(overheadFinancial.getP13());
                    newFinancialData.setProratedYtdBudget(overheadFinancial.getProratedYtdBudget());
                    newFinancialData.setTotalActualYtdExpenses(overheadFinancial.getTotalActualYtdExpenses());
                    newFinancialData.setTypeOfCare(overheadFinancial.getTypeOfCare());
                    newFinancialData.setYtdExpenseVariance(overheadFinancial.getYtdExpenseVariance());
                    newFinancialData.setYtdExpenseVarianceNote(overheadFinancial.getYtdExpenseVarianceNote());
    
                    upccFinancialData.add(newFinancialData);
                }
            }

            financialReportingUpccSubmission.setFrUpccFinancialData(upccFinancialData);
        }

        return parsedUpccFR;
    }
}
