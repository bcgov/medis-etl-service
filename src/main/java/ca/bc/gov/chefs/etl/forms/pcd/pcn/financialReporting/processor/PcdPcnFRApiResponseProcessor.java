package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json.RootBudget;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json.RootFinancial;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.json.RootTotals;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnFinancialSubTotals;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnFinancialTotals;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnItemizedBudget;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnItemizedFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdPcnFRApiResponseProcessor extends BaseApiResponseProcessor {
	private static final String EXPENSE_CATEGORY_DOFP = "Division Of Family Practice";
	private static final String EXPENSE_SUBCATEGORY_DOFP = "DoFP Resources & Items";
	private static final String EXPENSE_CATEGORY_HA = "Health Authority";
	private static final String EXPENSE_SUBCATEGORY_CLINICAL = "Clinical & Traditional Wellness Resources";
	private static final String EXPENSE_SUBCATEGORY_OVERHEAD = "Overhead";
	private static final String EXPENSE_SUBCATEGORY_OTF = "One-Time Funding";
	private static final String EXPENSE_CATEGORY_CM = "Change Management";
	private static final String EXPENSE_CATEGORY_FP = "Family Physicians";

	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.fixExpenseItemSubType(payload);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> pcnFRModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<FRPcnSubmission> parsedPcnFR = parsePcnFRRequest(pcnFRModels);

		validateRecordCount(pcnFRModels, parsedPcnFR);

		List<IModel> iModels = (List<IModel>) (List<?>) parsedPcnFR;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_PCN_FR_DIR, isHeaderAdded);

		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setFiles(filesGenerated);
		exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}

	private List<FRPcnSubmission> parsePcnFRRequest(List<Root> pcnFRModels) {
		List<FRPcnSubmission> financialReportingPCN = new ArrayList<>();

		for (Root root : pcnFRModels) {
			FRPcnSubmission frPcnSubmission = new FRPcnSubmission();
			List<FRPcnFinancialData> pcnFinancialData = new ArrayList<>();
			List<FRPcnItemizedBudget> pcnItemizedBudget = new ArrayList<>();
			List<FRPcnFinancialTotals> pcnTotals = new ArrayList<>();
			List<FRPcnFinancialSubTotals> pcnSubTotals = new ArrayList<>();

			/** mapping FRPcnSubmission */
			frPcnSubmission.setSubmissionId(root.getForm().getSubmissionId());
			frPcnSubmission.setCreatedAt(root.getForm().getCreatedAt());
			frPcnSubmission.setLateEntry(root.getLateEntry());
			frPcnSubmission.setSubmitterFullName(root.getForm().getFullName());
			frPcnSubmission.setSubmitterUserName(root.getForm().getUsername());
			frPcnSubmission.setSubmitterEmail(root.getForm().getEmail());
			frPcnSubmission.setSubmissionStatus(root.getForm().getStatus());
			frPcnSubmission.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
			frPcnSubmission.setSubmissionFormName(root.getForm().getFormName());
			frPcnSubmission.setHealthAuthority(root.getHealthAuthority());
			frPcnSubmission.setCommunityName(root.getCommunityName());
			frPcnSubmission.setFiscalYear(root.getFiscalYear());
			frPcnSubmission.setPeriodReported(root.getPeriodReported());
			frPcnSubmission.setReasonForExceptionPeriodReported(root.getReasonForExceptionInPeriodReported());
			frPcnSubmission.setAdditionalNotes(root.getFinancialData().getNotes());

			/** DOFP */
			if (root.getFinancialData().getDofp().getTotals() != null) {
				FRPcnFinancialTotals dofpTotals = mapTotals(root.getForm().getSubmissionId(),
						root.getFinancialData().getDofp().getTotals(), EXPENSE_CATEGORY_DOFP);
				pcnTotals.add(dofpTotals);
			}
			/* DOFP resources */
			if (root.getFinancialData().getDofp().getResource() != null) {
				if (root.getFinancialData().getDofp().getResource().getSubtotals() != null) {
					FRPcnFinancialSubTotals dofpResourceSubtotal = mapSubTotal(root.getForm().getSubmissionId(),
							root.getFinancialData().getDofp().getResource().getSubtotals(), EXPENSE_CATEGORY_DOFP,
							EXPENSE_SUBCATEGORY_DOFP);
					pcnSubTotals.add(dofpResourceSubtotal);
				}
				if (isValidFinancial(root.getFinancialData().getDofp().getResource().getFinancials())) {
					for (RootFinancial resourceFinancial : root.getFinancialData().getDofp().getResource()
							.getFinancials()) {
						if (isValidExpenseItem(resourceFinancial.getExpenseItem())) {
							FRPcnFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
									resourceFinancial);
							pcnFinancialData.add(newFinancialData);
						}
					}
				}
			}
			/* DOFP One Time Funding */
			if (root.getFinancialData().getDofp().getOneTimeFunding() != null) {
				if (root.getFinancialData().getDofp().getOneTimeFunding().getSubtotals() != null) {
					FRPcnFinancialSubTotals dofpOTPSubtotal = mapSubTotal(root.getForm().getSubmissionId(),
							root.getFinancialData().getDofp().getOneTimeFunding().getSubtotals(), EXPENSE_CATEGORY_DOFP,
							EXPENSE_SUBCATEGORY_OTF);
					pcnSubTotals.add(dofpOTPSubtotal);
				}
				if (isValidFinancial(root.getFinancialData().getDofp().getOneTimeFunding().getFinancials())) {
					for (RootFinancial dofpOTFinancial : root.getFinancialData().getDofp().getOneTimeFunding()
							.getFinancials()) {
						if (isValidExpenseItem(dofpOTFinancial.getExpenseItem())) {
							FRPcnFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
									dofpOTFinancial);
							pcnFinancialData.add(newFinancialData);
						}
					}
				}
			}
			/* DOFP Overhead */
			if (root.getFinancialData().getDofp().getOverhead() != null) {
				if (root.getFinancialData().getDofp().getOverhead().getSubtotals() != null) {
					FRPcnFinancialSubTotals dofpOverheadSubtotals = mapSubTotal(root.getForm().getSubmissionId(),
							root.getFinancialData().getDofp().getOverhead().getSubtotals(), EXPENSE_CATEGORY_DOFP,
							EXPENSE_SUBCATEGORY_OVERHEAD);
					pcnSubTotals.add(dofpOverheadSubtotals);
				}
				if (root.getFinancialData().getDofp().getOverhead().getBudget() != null) {
					RootBudget rootBudget = root.getFinancialData().getDofp().getOverhead().getBudget();
					List<FRPcnItemizedFinancialData> dofpOverheadFinancialData = new ArrayList<>();
					FRPcnItemizedBudget dofpOverheadBudget = mapItemizedBudget(root.getForm().getSubmissionId(),
							rootBudget, EXPENSE_CATEGORY_DOFP, EXPENSE_SUBCATEGORY_OVERHEAD, null);
					if (isValidFinancial(root.getFinancialData().getDofp().getOverhead().getFinancials())) {
						for (RootFinancial dofpOverheadFinancial : root.getFinancialData().getDofp().getOverhead()
								.getFinancials()) {
							if (isValidExpenseItem(dofpOverheadFinancial.getExpenseItem())) {
								FRPcnItemizedFinancialData newItemizedFinancialData = mapItemizedFinancialData(
										dofpOverheadBudget.getBudgetId(), dofpOverheadFinancial);
								dofpOverheadFinancialData.add(newItemizedFinancialData);
							}
						}
					}

					dofpOverheadBudget.setPcnItemizedFinancialData(dofpOverheadFinancialData);
					pcnItemizedBudget.add(dofpOverheadBudget);
				}
			}
			/* Health Authority */
			if (root.getFinancialData().getHealthAuthority().getTotals() != null) {
				FRPcnFinancialTotals dofpTotals = mapTotals(root.getForm().getSubmissionId(),
						root.getFinancialData().getHealthAuthority().getTotals(), EXPENSE_CATEGORY_HA);
				pcnTotals.add(dofpTotals);
			}
			/* HA Clinical */
			if (root.getFinancialData().getHealthAuthority().getClinical() != null) {
				if (root.getFinancialData().getHealthAuthority().getClinical().getSubtotals() != null) {
					FRPcnFinancialSubTotals haResourceSubtotal = mapSubTotal(root.getForm().getSubmissionId(),
							root.getFinancialData().getHealthAuthority().getClinical().getSubtotals(),
							EXPENSE_CATEGORY_HA,
							EXPENSE_SUBCATEGORY_CLINICAL);
					pcnSubTotals.add(haResourceSubtotal);
				}
				if (isValidFinancial(root.getFinancialData().getHealthAuthority().getClinical().getFinancials())) {
					for (RootFinancial clinicalFinancial : root.getFinancialData().getHealthAuthority().getClinical()
							.getFinancials()) {
						if (isValidExpenseItem(clinicalFinancial.getExpenseItem())) {
							FRPcnFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
									clinicalFinancial);
							pcnFinancialData.add(newFinancialData);
						}
					}
				}
			}
			/* HA One Time Funding */
			if (root.getFinancialData().getHealthAuthority().getOneTimeFunding() != null) {
				if (root.getFinancialData().getHealthAuthority().getOneTimeFunding().getSubtotals() != null) {
					FRPcnFinancialSubTotals clinicalOTPSubtotal = mapSubTotal(root.getForm().getSubmissionId(),
							root.getFinancialData().getHealthAuthority().getOneTimeFunding().getSubtotals(),
							EXPENSE_CATEGORY_HA,
							EXPENSE_SUBCATEGORY_OTF);
					pcnSubTotals.add(clinicalOTPSubtotal);
				}
				if (isValidFinancial(
						root.getFinancialData().getHealthAuthority().getOneTimeFunding().getFinancials())) {
					for (RootFinancial clinicalOTFinancial : root.getFinancialData().getHealthAuthority()
							.getOneTimeFunding()
							.getFinancials()) {
						if (isValidExpenseItem(clinicalOTFinancial.getExpenseItem())) {
							FRPcnFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
									clinicalOTFinancial);
							pcnFinancialData.add(newFinancialData);
						}
					}
				}
			}
			/* HA Overhead */
			if (root.getFinancialData().getHealthAuthority().getOverhead() != null) {
				if (root.getFinancialData().getHealthAuthority().getOverhead().getSubtotals() != null) {
					FRPcnFinancialSubTotals haOverheadSubtotals = mapSubTotal(root.getForm().getSubmissionId(),
							root.getFinancialData().getHealthAuthority().getOverhead().getSubtotals(),
							EXPENSE_CATEGORY_HA,
							EXPENSE_SUBCATEGORY_OVERHEAD);
					pcnSubTotals.add(haOverheadSubtotals);
				}
				if (root.getFinancialData().getHealthAuthority().getOverhead().getBudget() != null) {
					RootBudget rootBudget = root.getFinancialData().getHealthAuthority().getOverhead().getBudget();
					List<FRPcnItemizedFinancialData> haOverheadFinancialData = new ArrayList<>();
					FRPcnItemizedBudget haOverheadBudget = mapItemizedBudget(root.getForm().getSubmissionId(),
							rootBudget, EXPENSE_CATEGORY_HA, EXPENSE_SUBCATEGORY_OVERHEAD, null);
					if (isValidFinancial(root.getFinancialData().getHealthAuthority().getOverhead().getFinancials())) {
						for (RootFinancial haOverheadFinancial : root.getFinancialData().getHealthAuthority()
								.getOverhead()
								.getFinancials()) {
							if (isValidExpenseItem(haOverheadFinancial.getExpenseItem())) {
								FRPcnItemizedFinancialData newItemizedFinancialData = mapItemizedFinancialData(
										haOverheadBudget.getBudgetId(), haOverheadFinancial);
								haOverheadFinancialData.add(newItemizedFinancialData);
							}
						}
					}
					haOverheadBudget.setPcnItemizedFinancialData(haOverheadFinancialData);
					pcnItemizedBudget.add(haOverheadBudget);
				}
			}
			/* Change Management */
			if (root.getFinancialData().getChangeManagement() != null) {
				if (root.getFinancialData().getChangeManagement().getTotals() != null) {
					FRPcnFinancialTotals changeManagementTotals = mapTotals(root.getForm().getSubmissionId(),
							root.getFinancialData().getChangeManagement().getTotals(), EXPENSE_CATEGORY_CM);
					pcnTotals.add(changeManagementTotals);
				}
				if (root.getFinancialData().getChangeManagement().getBudget() != null) {
					RootBudget rootBudget = root.getFinancialData().getChangeManagement().getBudget();
					List<FRPcnItemizedFinancialData> changeManagementFinancialData = new ArrayList<>();
					FRPcnItemizedBudget changeManagementBudget = mapItemizedBudget(
							root.getForm().getSubmissionId(),
							rootBudget, EXPENSE_CATEGORY_DOFP, EXPENSE_SUBCATEGORY_DOFP, EXPENSE_CATEGORY_CM);
					if (isValidFinancial(root.getFinancialData().getChangeManagement().getFinancials())) {
						for (RootFinancial changeManagementFinancial : root.getFinancialData().getChangeManagement()
								.getFinancials()) {
							if (isValidExpenseItem(changeManagementFinancial.getExpenseItem())) {
								FRPcnItemizedFinancialData newItemizedFinancialData = mapItemizedFinancialData(
										changeManagementBudget.getBudgetId(), changeManagementFinancial);
								changeManagementFinancialData.add(newItemizedFinancialData);
							}
						}
					}
					changeManagementBudget.setPcnItemizedFinancialData(changeManagementFinancialData);
					pcnItemizedBudget.add(changeManagementBudget);
				}
			}
			/* Family physicians */
			if(root.getFinancialData().getFamilyPhysicians() != null){
				if (root.getFinancialData().getFamilyPhysicians().getTotals() != null) {
					FRPcnFinancialTotals fpTotals = mapTotals(root.getForm().getSubmissionId(),
							root.getFinancialData().getFamilyPhysicians().getTotals(), EXPENSE_CATEGORY_FP);
					pcnTotals.add(fpTotals);
				}

				if (isValidFinancial(root.getFinancialData().getFamilyPhysicians().getFinancials())) {
					for (RootFinancial fpFinancial : root.getFinancialData().getFamilyPhysicians()
							.getFinancials()) {
						if (isValidExpenseItem(fpFinancial.getExpenseItem())) {
							FRPcnFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
									fpFinancial);
							pcnFinancialData.add(newFinancialData);
						}
					}
				}
			}
			frPcnSubmission.setPcnFinancialData(pcnFinancialData);
			frPcnSubmission.setPcnItemizedBudget(pcnItemizedBudget);
			frPcnSubmission.setPcnSubTotals(pcnSubTotals);
			frPcnSubmission.setPcnTotals(pcnTotals);

			financialReportingPCN.add(frPcnSubmission);
		}

		return financialReportingPCN;
	}

	private boolean isValidFinancial(List<RootFinancial> financials) {
		return financials != null && !financials.isEmpty();
	}

	private boolean isValidExpenseItem(String expenseItem) {
		return expenseItem != null && !expenseItem.isEmpty();
	}

	private FRPcnFinancialTotals mapTotals(String submissionId, RootTotals rootTotal, String expenseCategory) {
		FRPcnFinancialTotals financialTotal = new FRPcnFinancialTotals();
		financialTotal.setSubmissionId(submissionId);
		financialTotal.setExpenseCategory(expenseCategory);
		financialTotal.setAnnualBudget(rootTotal.getAnnualBudget());
		financialTotal.setApproved4YearFtes(rootTotal.getApproved4yearFtes());
		financialTotal.setFtesHiredToDate(rootTotal.getFtesHiredToDate());
		financialTotal.setFyExpenseForecast(rootTotal.getFyExpenseForecast());
		financialTotal.setProratedYtdBudget(rootTotal.getProratedYtdBudget());
		financialTotal.setYtdExpenseVariance(rootTotal.getYtdExpenseVariance());
		financialTotal.setFtesInclRelief(rootTotal.getFtesInclRelief());
		financialTotal.setTotalActualYtdExpenses(rootTotal.getTotalActualYtdExpenses());
		financialTotal.setP1(rootTotal.getP1());
		financialTotal.setP2(rootTotal.getP2());
		financialTotal.setP3(rootTotal.getP3());
		financialTotal.setP4(rootTotal.getP4());
		financialTotal.setP5(rootTotal.getP5());
		financialTotal.setP6(rootTotal.getP6());
		financialTotal.setP7(rootTotal.getP7());
		financialTotal.setP8(rootTotal.getP8());
		financialTotal.setP9(rootTotal.getP9());
		financialTotal.setP10(rootTotal.getP10());
		financialTotal.setP11(rootTotal.getP11());
		financialTotal.setP12(rootTotal.getP12());
		financialTotal.setP13(rootTotal.getP13());
		financialTotal.setTotalBudgetAllocation(rootTotal.getTotalBudgetAllocation());

		return financialTotal;
	}

	private FRPcnFinancialSubTotals mapSubTotal(String submissionId, RootTotals rootSubtotal, String expenseCategory,
			String expenseSubCategory) {
		FRPcnFinancialSubTotals financialSubTotal = new FRPcnFinancialSubTotals();
		financialSubTotal.setSubmissionId(submissionId);
		financialSubTotal.setExpenseCategory(expenseCategory);
		financialSubTotal.setExpenseSubCategory(expenseSubCategory);
		financialSubTotal.setAnnualBudget(rootSubtotal.getAnnualBudget());
		financialSubTotal.setApproved4YearFtes(rootSubtotal.getApproved4yearFtes());
		financialSubTotal.setFtesHiredToDate(rootSubtotal.getFtesHiredToDate());
		financialSubTotal.setFyExpenseForecast(rootSubtotal.getFyExpenseForecast());
		financialSubTotal.setProratedYtdBudget(rootSubtotal.getProratedYtdBudget());
		financialSubTotal.setYtdExpenseVariance(rootSubtotal.getYtdExpenseVariance());
		financialSubTotal.setFtesInclRelief(rootSubtotal.getFtesInclRelief());
		financialSubTotal.setTotalActualYtdExpenses(rootSubtotal.getTotalActualYtdExpenses());
		financialSubTotal.setFyEstimatedSurplus(rootSubtotal.getFyEstimatedSurplus());
		financialSubTotal.setFyExpenseVariance(rootSubtotal.getFyExpenseVariance());
		financialSubTotal.setP1(rootSubtotal.getP1());
		financialSubTotal.setP2(rootSubtotal.getP2());
		financialSubTotal.setP3(rootSubtotal.getP3());
		financialSubTotal.setP4(rootSubtotal.getP4());
		financialSubTotal.setP5(rootSubtotal.getP5());
		financialSubTotal.setP6(rootSubtotal.getP6());
		financialSubTotal.setP7(rootSubtotal.getP7());
		financialSubTotal.setP8(rootSubtotal.getP8());
		financialSubTotal.setP9(rootSubtotal.getP9());
		financialSubTotal.setP10(rootSubtotal.getP10());
		financialSubTotal.setP11(rootSubtotal.getP11());
		financialSubTotal.setP12(rootSubtotal.getP12());
		financialSubTotal.setP13(rootSubtotal.getP13());
		financialSubTotal.setTotalBudgetAllocation(rootSubtotal.getTotalBudgetAllocation());
		return financialSubTotal;
	}

	private FRPcnFinancialData mapFinancialData(String submissionId, RootFinancial financial) {
		FRPcnFinancialData newFinancialData = new FRPcnFinancialData();
		newFinancialData.setSubmissionId(submissionId);
		newFinancialData.setExpenseId(UUID.randomUUID().toString());
		newFinancialData.setAnnualBudget(financial.getAnnualBudget());
		newFinancialData.setApproved4YearFtes(financial.getApproved4YearFtEs());
		newFinancialData.setFtesInclRelief(financial.getFtesInclRelief());
		newFinancialData.setExpenseCategory(financial.getExpenseCategory());
		newFinancialData.setExpenseSubCategory(financial.getExpenseSubCategory());
		newFinancialData.setExpenseItem(financial.getExpenseItem());
		newFinancialData.setExpenseItemSubType(financial.getExpenseItemSubType());
		newFinancialData.setSpecialty(financial.getSpecialty());
		newFinancialData.setOtherSpecialty(financial.getOtherSpecialty());
		newFinancialData.setFtesHiredToDate(financial.getFtesHiredToDate());
		newFinancialData.setFyExpenseForecast(financial.getFyExpenseForecast());
		newFinancialData.setFyEstimatedSurplus(financial.getFyEstimatedSurplus());
		newFinancialData.setFyExpenseVariance(financial.getFyExpenseVariance());
		newFinancialData.setFyExpenseVarianceNote(financial.getFyExpenseVarianceNote());
		newFinancialData.setP1(financial.getP1());
		newFinancialData.setP2(financial.getP2());
		newFinancialData.setP3(financial.getP3());
		newFinancialData.setP4(financial.getP4());
		newFinancialData.setP5(financial.getP5());
		newFinancialData.setP6(financial.getP6());
		newFinancialData.setP7(financial.getP7());
		newFinancialData.setP8(financial.getP8());
		newFinancialData.setP9(financial.getP9());
		newFinancialData.setP10(financial.getP10());
		newFinancialData.setP11(financial.getP11());
		newFinancialData.setP12(financial.getP12());
		newFinancialData.setP13(financial.getP13());
		newFinancialData.setProratedYtdBudget(financial.getProratedYtdBudget());
		newFinancialData.setTotalActualYtdExpenses(financial.getTotalActualYtdExpenses());
		newFinancialData.setTotalBudgetAllocation(financial.getTotalBudgetAllocation());
		newFinancialData.setYtdExpenseVariance(financial.getYtdExpenseVariance());
		newFinancialData.setYtdExpenseVarianceNote(financial.getYtdExpenseVarianceNote());
		newFinancialData.setFiscalYearAllocation(financial.getFiscalYearAllocation());
		newFinancialData.setOtherItems(financial.getOtherItems());
		newFinancialData.setTypesOfTraining(financial.getTypesOfTraining());
		newFinancialData.setListOfRolesTitles(financial.getListOfRolesTitles());

		return newFinancialData;
	}

	private FRPcnItemizedBudget mapItemizedBudget(String submissionId, RootBudget rootBudget, String expenseCategory,
			String expenseSubCategory, String expenseItem) {
		FRPcnItemizedBudget newBudget = new FRPcnItemizedBudget();
		newBudget.setSubmissionId(submissionId);
		newBudget.setBudgetId(UUID.randomUUID().toString());
		newBudget.setExpenseCategory(expenseCategory);
		newBudget.setExpenseSubCategory(expenseSubCategory);
		newBudget.setExpenseItem(expenseItem);
		newBudget.setTotalBudgetAllocation(rootBudget.getTotalBudgetAllocation());
		newBudget.setFyExpenseVariance(rootBudget.getFyExpenseVariance());
		newBudget.setProratedYtdBudget(rootBudget.getProratedYtdBudget());
		newBudget.setFyEstimatedSurplus(rootBudget.getFyEstimatedSurplus());
		newBudget.setYtdExpenseVariance(rootBudget.getYtdExpenseVariance());
		newBudget.setFyExpenseVarianceNote(rootBudget.getFyExpenseVarianceNote());
		newBudget.setYtdExpenseVarianceNote(rootBudget.getYtdExpenseVarianceNote());
		newBudget.setAnnualBudget(rootBudget.getAnnualBudget());
		newBudget.setFiscalYearAllocation(rootBudget.getFiscalYearAllocation());
		newBudget.setFyExpenseForecast(rootBudget.getFyExpenseForecast());

		return newBudget;
	}

	private FRPcnItemizedFinancialData mapItemizedFinancialData(String budgetId, RootFinancial financial) {
		FRPcnItemizedFinancialData newItemizedFinancialData = new FRPcnItemizedFinancialData();
		newItemizedFinancialData.setBudgetId(budgetId);
		newItemizedFinancialData.setExpenseId(UUID.randomUUID().toString());
		newItemizedFinancialData.setExpenseItem(financial.getExpenseItem());
		newItemizedFinancialData.setExpenseItemSubType(financial.getExpenseItemSubType());
		newItemizedFinancialData.setFyExpenseForecast(financial.getFyExpenseForecast());
		newItemizedFinancialData.setP1(financial.getP1());
		newItemizedFinancialData.setP2(financial.getP2());
		newItemizedFinancialData.setP3(financial.getP3());
		newItemizedFinancialData.setP4(financial.getP4());
		newItemizedFinancialData.setP5(financial.getP5());
		newItemizedFinancialData.setP6(financial.getP6());
		newItemizedFinancialData.setP7(financial.getP7());
		newItemizedFinancialData.setP8(financial.getP8());
		newItemizedFinancialData.setP9(financial.getP9());
		newItemizedFinancialData.setP10(financial.getP10());
		newItemizedFinancialData.setP11(financial.getP11());
		newItemizedFinancialData.setP12(financial.getP12());
		newItemizedFinancialData.setP13(financial.getP13());
		newItemizedFinancialData.setTotalActualYtdExpenses(financial.getTotalActualYtdExpenses());
		newItemizedFinancialData.setSpecialty(financial.getSpecialty());
		newItemizedFinancialData.setOtherSpecialty(financial.getOtherSpecialty());
		newItemizedFinancialData.setOtherItems(financial.getOtherItems());
		newItemizedFinancialData.setTypesOfTraining(financial.getTypesOfTraining());
		newItemizedFinancialData.setListOfRolesTitles(financial.getListOfRolesTitles());
		return newItemizedFinancialData;
	}
}
