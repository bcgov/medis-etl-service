package ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.processor;

import static ca.bc.gov.chefs.etl.constant.PCDConstants.CATEGORY_DOFP;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.CATEGORY_FAMILY_PYHSICIANS;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.CATEGORY_HEALTH_AUTHORITY;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_DOFP_RESOURCES;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_FAMILY_PHYSICIAN;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_HEALTH_CLINICAL;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_ONE_TIME_FUNDING;
import static ca.bc.gov.chefs.etl.constant.PCDConstants.SUB_CATEGORY_OVERHEAD;
import static ca.bc.gov.chefs.etl.util.CSVUtil.isNonZero;
import static ca.bc.gov.chefs.etl.util.CSVUtil.parseBigDecimal;

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
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnFinancialTotals;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnItemizedBudget;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnItemizedFinancialData;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.model.FRPcnSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdPcnFRApiResponseProcessor extends BaseApiResponseProcessor {

	private static final String EXPENSE_ITEM_CM = "Change Management";

	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.fixExpenseItemAndSubType(payload);
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
			
			 String submissionId = root.getForm().getSubmissionId();

			/** mapping FRPcnSubmission */
			frPcnSubmission.setSubmissionId(submissionId);
			frPcnSubmission.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
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

			/* DOFP resources */
			FRPcnFinancialTotals dofpResourcesTotals = new FRPcnFinancialTotals(submissionId, CATEGORY_DOFP, SUB_CATEGORY_DOFP_RESOURCES);
			if (root.getFinancialData().getDofp().getResource() != null) {
				if (isValidFinancial(root.getFinancialData().getDofp().getResource().getFinancials())) {
					for (RootFinancial resourceFinancial : root.getFinancialData().getDofp().getResource()
							.getFinancials()) {
						if (isValidExpenseItem(resourceFinancial.getExpenseItem()) && isNonZero(resourceFinancial.getTotalBudgetAllocation())) {
							FRPcnFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
									resourceFinancial);
							pcnFinancialData.add(newFinancialData);
							
							populateTotals(dofpResourcesTotals, resourceFinancial);
						}
					}
				}
			}
			/* DOFP One Time Funding */
			FRPcnFinancialTotals dofpOneTimeFundingTotals = new FRPcnFinancialTotals(submissionId, CATEGORY_DOFP, SUB_CATEGORY_ONE_TIME_FUNDING);
			if (root.getFinancialData().getDofp().getOneTimeFunding() != null) {
				if (isValidFinancial(root.getFinancialData().getDofp().getOneTimeFunding().getFinancials())) {
					for (RootFinancial dofpOTFinancial : root.getFinancialData().getDofp().getOneTimeFunding()
							.getFinancials()) {
						if (isValidExpenseItem(dofpOTFinancial.getExpenseItem()) && isNonZero(dofpOTFinancial.getTotalBudgetAllocation())) {
							FRPcnFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
									dofpOTFinancial);
							pcnFinancialData.add(newFinancialData);
							
							populateTotals(dofpOneTimeFundingTotals, dofpOTFinancial);
						}
					}
				}
			}
			/* DOFP Overhead */
			FRPcnFinancialTotals dofpOverheadTotals = new FRPcnFinancialTotals(submissionId, CATEGORY_DOFP, SUB_CATEGORY_OVERHEAD);
			if (root.getFinancialData().getDofp().getOverhead() != null) {

				RootBudget budget =root.getFinancialData().getDofp().getOverhead().getBudget();				
				if (budget != null && isNonZero(budget.getTotalBudgetAllocation())) {
					RootBudget rootBudget = root.getFinancialData().getDofp().getOverhead().getBudget();
					List<FRPcnItemizedFinancialData> dofpOverheadFinancialData = new ArrayList<>();
					FRPcnItemizedBudget dofpOverheadBudget = mapItemizedBudget(root.getForm().getSubmissionId(),
							rootBudget, CATEGORY_DOFP, SUB_CATEGORY_OVERHEAD, null);
					
					populateTotals(dofpOverheadTotals, rootBudget);
					if (isValidFinancial(root.getFinancialData().getDofp().getOverhead().getFinancials())) {
						for (RootFinancial dofpOverheadFinancial : root.getFinancialData().getDofp().getOverhead()
								.getFinancials()) {
							if (isValidExpenseItem(dofpOverheadFinancial.getExpenseItem()) && isNonZero(dofpOverheadFinancial.getTotalBudgetAllocation())) {
								FRPcnItemizedFinancialData newItemizedFinancialData = mapItemizedFinancialData(
										dofpOverheadBudget.getBudgetId(), dofpOverheadFinancial);
								dofpOverheadFinancialData.add(newItemizedFinancialData);
								
								populateTotals(dofpOverheadTotals, dofpOverheadFinancial);
							}
						}
					}

					dofpOverheadBudget.setPcnItemizedFinancialData(dofpOverheadFinancialData);
					pcnItemizedBudget.add(dofpOverheadBudget);
				}
			}
	         /* DoFP Change Management */
            if (root.getFinancialData().getChangeManagement() != null) {
                /* We will not capture Change Management totals as they are already captured by/included in the subtotals of DOFP Resources */
            	RootBudget budget = root.getFinancialData().getChangeManagement().getBudget();
                if (budget != null && isNonZero(budget.getTotalBudgetAllocation())) {
                    RootBudget rootBudget = root.getFinancialData().getChangeManagement().getBudget();
                    List<FRPcnItemizedFinancialData> changeManagementFinancialData = new ArrayList<>();
                    FRPcnItemizedBudget changeManagementBudget = mapItemizedBudget(
                            root.getForm().getSubmissionId(),
                            rootBudget, CATEGORY_DOFP, SUB_CATEGORY_DOFP_RESOURCES, EXPENSE_ITEM_CM);
                    
                    populateTotals(dofpResourcesTotals, rootBudget);
                    
                    if (isValidFinancial(root.getFinancialData().getChangeManagement().getFinancials())) {
                        for (RootFinancial changeManagementFinancial : root.getFinancialData().getChangeManagement()
                                .getFinancials()) {
                            if (isValidExpenseItem(changeManagementFinancial.getExpenseItem()) && isNonZero(changeManagementFinancial.getTotalBudgetAllocation())) {
                                // FY Expense Forecast is captured at the budget level. Ignore erroneous data from bulk upload.
                                changeManagementFinancial.setFyExpenseForecast(null);
                                
                                FRPcnItemizedFinancialData newItemizedFinancialData = mapItemizedFinancialData(
                                        changeManagementBudget.getBudgetId(), changeManagementFinancial);

                                changeManagementFinancialData.add(newItemizedFinancialData);
                                
                                populateTotals(dofpResourcesTotals, changeManagementFinancial);

                            }
                        }
                    }
                    changeManagementBudget.setPcnItemizedFinancialData(changeManagementFinancialData);
                    pcnItemizedBudget.add(changeManagementBudget);
                }
            }
            
			/* Health Authority */
			
			/* HA Clinical */
			FRPcnFinancialTotals haClinicalTotals = new FRPcnFinancialTotals(submissionId, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_HEALTH_CLINICAL);
			if (root.getFinancialData().getHealthAuthority().getClinical() != null) {

				if (isValidFinancial(root.getFinancialData().getHealthAuthority().getClinical().getFinancials())) {
					for (RootFinancial clinicalFinancial : root.getFinancialData().getHealthAuthority().getClinical()
							.getFinancials()) {
						if (isValidExpenseItem(clinicalFinancial.getExpenseItem()) && isNonZero(clinicalFinancial.getTotalBudgetAllocation())) {
							FRPcnFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
									clinicalFinancial);
							pcnFinancialData.add(newFinancialData);
							
	                         populateTotals(haClinicalTotals, clinicalFinancial);

						}
					}
				}
			}
			/* HA One Time Funding */
			FRPcnFinancialTotals haOneTimeFundingTotals = new FRPcnFinancialTotals(submissionId, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_ONE_TIME_FUNDING);
			if (root.getFinancialData().getHealthAuthority().getOneTimeFunding() != null) {
				if (isValidFinancial(
						root.getFinancialData().getHealthAuthority().getOneTimeFunding().getFinancials())) {
					for (RootFinancial clinicalOTFinancial : root.getFinancialData().getHealthAuthority()
							.getOneTimeFunding()
							.getFinancials()) {
						if (isValidExpenseItem(clinicalOTFinancial.getExpenseItem()) && isNonZero(clinicalOTFinancial.getTotalBudgetAllocation())) {
							FRPcnFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
									clinicalOTFinancial);
							pcnFinancialData.add(newFinancialData);
							
							populateTotals(haOneTimeFundingTotals, clinicalOTFinancial);
						}
					}
				}
			}
			/* HA Overhead */
			FRPcnFinancialTotals haOverheadTotals = new FRPcnFinancialTotals(submissionId, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_OVERHEAD);
			if (root.getFinancialData().getHealthAuthority().getOverhead() != null) {
				
				RootBudget budget = root.getFinancialData().getHealthAuthority().getOverhead().getBudget();
				if (budget != null && isNonZero(budget.getTotalBudgetAllocation())) {
					
					List<FRPcnItemizedFinancialData> haOverheadFinancialData = new ArrayList<>();
					FRPcnItemizedBudget haOverheadBudget = mapItemizedBudget(root.getForm().getSubmissionId(),
							budget, CATEGORY_HEALTH_AUTHORITY, SUB_CATEGORY_OVERHEAD, null);
					
					populateTotals(haOverheadTotals, budget);
					
					if (isValidFinancial(root.getFinancialData().getHealthAuthority().getOverhead().getFinancials())) {
						for (RootFinancial haOverheadFinancial : root.getFinancialData().getHealthAuthority()
								.getOverhead()
								.getFinancials()) {
							if (isValidExpenseItem(haOverheadFinancial.getExpenseItem())) {
								FRPcnItemizedFinancialData newItemizedFinancialData = mapItemizedFinancialData(
										haOverheadBudget.getBudgetId(), haOverheadFinancial);
								haOverheadFinancialData.add(newItemizedFinancialData);
								
								populateTotals(haOverheadTotals, haOverheadFinancial);
							}
						}
					}
					haOverheadBudget.setPcnItemizedFinancialData(haOverheadFinancialData);
					pcnItemizedBudget.add(haOverheadBudget);
				}
			}

			
			/* Family physicians */
			FRPcnFinancialTotals familyPhysiciansTotals = new FRPcnFinancialTotals(submissionId, CATEGORY_FAMILY_PYHSICIANS, SUB_CATEGORY_FAMILY_PHYSICIAN);

			if (root.getFinancialData().getFamilyPhysicians() != null) {
				if (isValidFinancial(root.getFinancialData().getFamilyPhysicians().getFinancials())) {
					for (RootFinancial fpFinancial : root.getFinancialData().getFamilyPhysicians()
							.getFinancials()) {
						if (isValidExpenseItem(fpFinancial.getExpenseItem()) && isNonZero(fpFinancial.getTotalBudgetAllocation())) {
							FRPcnFinancialData newFinancialData = mapFinancialData(root.getForm().getSubmissionId(),
									fpFinancial);
							pcnFinancialData.add(newFinancialData);
							
							populateTotals(familyPhysiciansTotals, fpFinancial);
						}
					}
				}
			}
			frPcnSubmission.setPcnFinancialData(pcnFinancialData);
			frPcnSubmission.setPcnItemizedBudget(pcnItemizedBudget);
			frPcnSubmission.setPcnTotals(pcnTotals);

			financialReportingPCN.add(frPcnSubmission);
			
            // Finalize the totals
			pcnTotals.add(dofpResourcesTotals);
			pcnTotals.add(dofpOneTimeFundingTotals);
			pcnTotals.add(dofpOverheadTotals);
			pcnTotals.add(haClinicalTotals);
			pcnTotals.add(haOneTimeFundingTotals);
			pcnTotals.add(haOverheadTotals);
			pcnTotals.add(familyPhysiciansTotals);
		}

		return financialReportingPCN;
	}

	private boolean isValidFinancial(List<RootFinancial> financials) {
		return financials != null && !financials.isEmpty();
	}

	private boolean isValidExpenseItem(String expenseItem) {
		return expenseItem != null && !expenseItem.isEmpty();
	}
	
    private void populateTotals(FRPcnFinancialTotals totals, RootFinancial financial) {
        totals.setApprovedBudget(totals.getApprovedBudget().add(parseBigDecimal(financial.getAnnualBudget())));
        totals.setTotalBudgetAllocation(totals.getTotalBudgetAllocation().add(parseBigDecimal(financial.getTotalBudgetAllocation())));
        totals.setApproved4YearFtes(totals.getApproved4YearFtes().add(parseBigDecimal(financial.getApproved4YearFtEs())));
        totals.setFtesHiredToDate(totals.getFtesHiredToDate().add(parseBigDecimal(financial.getFtesHiredToDate())));
        totals.setFyExpenseForecast(totals.getFyExpenseForecast().add(parseBigDecimal(financial.getFyExpenseForecast())));

        totals.setP1(totals.getP1().add(parseBigDecimal(financial.getP1())));
        totals.setP2(totals.getP2().add(parseBigDecimal(financial.getP2())));
        totals.setP3(totals.getP3().add(parseBigDecimal(financial.getP3())));
        totals.setP4(totals.getP4().add(parseBigDecimal(financial.getP4())));
        totals.setP5(totals.getP5().add(parseBigDecimal(financial.getP5())));
        totals.setP6(totals.getP6().add(parseBigDecimal(financial.getP6())));
        totals.setP7(totals.getP7().add(parseBigDecimal(financial.getP7())));
        totals.setP8(totals.getP8().add(parseBigDecimal(financial.getP8())));
        totals.setP9(totals.getP9().add(parseBigDecimal(financial.getP9())));
        totals.setP10(totals.getP10().add(parseBigDecimal(financial.getP10())));
        totals.setP11(totals.getP11().add(parseBigDecimal(financial.getP11())));
        totals.setP12(totals.getP12().add(parseBigDecimal(financial.getP12())));
        totals.setP13(totals.getP13().add(parseBigDecimal(financial.getP13())));
    }
    
    private void populateTotals(FRPcnFinancialTotals totals, RootBudget budget) {
        totals.setApprovedBudget(totals.getApprovedBudget().add(parseBigDecimal(budget.getAnnualBudget())));
        totals.setTotalBudgetAllocation(totals.getTotalBudgetAllocation().add(parseBigDecimal(budget.getTotalBudgetAllocation())));
        totals.setFyExpenseForecast(totals.getFyExpenseForecast().add(parseBigDecimal(budget.getFyExpenseForecast())));
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
		newItemizedFinancialData.setOtherItems(financial.getOtherItems());
		newItemizedFinancialData.setTypesOfTraining(financial.getTypesOfTraining());
		newItemizedFinancialData.setListOfRolesTitles(financial.getListOfRolesTitles());
		return newItemizedFinancialData;
	}
	
}
