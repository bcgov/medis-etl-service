package ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.processor;

import java.util.ArrayList;
import java.util.Comparator;
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
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json.RootExpenseCategory;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json.RootExpenseCategoryUPCC;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json.RootExpenseItem;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json.RootExpenseSubCategory;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json.RootExpenseSubCategoryUPCC;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.json.RootTypeOfCare;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.model.ExpenseHierarchyCategory;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.model.ExpenseHierarchyItem;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.model.ExpenseHierarchyItemSubType;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.model.ExpenseHierarchySubCategory;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.model.ExpenseHierarchySubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class PcdFinancialExpenseApiResponseProcessor extends BaseApiResponseProcessor {
    
	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.fixUnicodeCharacters(payload);
		
		ObjectMapper mapper = new ObjectMapper();

		List<Root> FinancialExpenseModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<ExpenseHierarchySubmission> parsedFinancialExpense = parseFinancialExpenseRequest(FinancialExpenseModels);

		validateRecordCount(FinancialExpenseModels, parsedFinancialExpense);

		List<IModel> iModels = (List<IModel>) (List<?>) parsedFinancialExpense;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map, PCDConstants.PCD_FINANCIAL_EXPENSE_DIR, isHeaderAdded);

		 SuccessResponse successResponse = new SuccessResponse();
		 successResponse.setFiles(filesGenerated);
		 exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}

    private List<ExpenseHierarchySubmission> parseFinancialExpenseRequest(List<Root> ExpenseHierarchyPayloads) {
        List<ExpenseHierarchySubmission> parsedExpenseCodeHierarchies = new ArrayList<>();
		List<ExpenseHierarchyCategory> expenseHierarchyCategories = new ArrayList<>();
		List<ExpenseHierarchySubCategory> expenseHierarchySubCategories = new ArrayList<>();
		List<ExpenseHierarchyItem> expenseHierarchyItems = new ArrayList<>();
		List<ExpenseHierarchyItemSubType> expenseHierarchyItemSubTypes = new ArrayList<>();

		for(Root root : ExpenseHierarchyPayloads){
			/** mapping expenseHierarchySubmission  */
			ExpenseHierarchySubmission expenseHierarchySubmission = new ExpenseHierarchySubmission();
			expenseHierarchySubmission.setSubmissionId(root.getForm().getSubmissionId());
			expenseHierarchySubmission.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
			expenseHierarchySubmission.setLateEntry(root.getLateEntry());
			expenseHierarchySubmission.setSubmitterFullName(root.getForm().getFullName());
			expenseHierarchySubmission.setSubmitterUserName(root.getForm().getUsername());
			expenseHierarchySubmission.setSubmitterEmail(root.getForm().getEmail());
			expenseHierarchySubmission.setSubmissionStatus(root.getForm().getStatus());
			expenseHierarchySubmission.setSubmissionVersion(Integer.toString(root.getForm().getVersion()));
			expenseHierarchySubmission.setSubmissionFormName(root.getForm().getFormName());
	
			/** mapping CHC */		
			for(RootExpenseCategory categoryCHC : root.getChc().getExpenseCategories()){
				ExpenseHierarchyCategory expenseHierarchyCategoryCHC = new ExpenseHierarchyCategory();
				expenseHierarchyCategoryCHC.setSubmissionId(root.getForm().getSubmissionId());
				expenseHierarchyCategoryCHC.setExpenseCategoryId(UUID.randomUUID().toString());
				expenseHierarchyCategoryCHC.setInitiativeType(root.getChc().getInitiativeType());
				expenseHierarchyCategoryCHC.setExpenseCategory(categoryCHC.getExpenseCategory());
	
				expenseHierarchyCategories.add(expenseHierarchyCategoryCHC);
	
				for(RootExpenseSubCategory subCategoryCHC : categoryCHC.getExpenseSubCategories()){
					ExpenseHierarchySubCategory expenseHierarchySubCategoryCHC = new ExpenseHierarchySubCategory();
					expenseHierarchySubCategoryCHC.setExpenseCategoryId(expenseHierarchyCategoryCHC.getExpenseCategoryId());
					expenseHierarchySubCategoryCHC.setExpenseSubCategoryId(UUID.randomUUID().toString());
					expenseHierarchySubCategoryCHC.setExpenseSubCategory(subCategoryCHC.getExpenseSubCategory());
	
					expenseHierarchySubCategories.add(expenseHierarchySubCategoryCHC);
					
					if(subCategoryCHC.getExpenseItems() != null && !subCategoryCHC.getExpenseItems().isEmpty()){
						for(RootExpenseItem expenseItemCHC : subCategoryCHC.getExpenseItems()){
							ExpenseHierarchyItem expenseHierarchyItemCHC = new ExpenseHierarchyItem();
							expenseHierarchyItemCHC.setExpenseSubCategoryId(expenseHierarchySubCategoryCHC.getExpenseSubCategoryId());
							expenseHierarchyItemCHC.setExpenseItemId(UUID.randomUUID().toString());
							expenseHierarchyItemCHC.setExpenseItem(expenseItemCHC.getExpenseItem());
							expenseHierarchyItemCHC.setResourceCategory(expenseItemCHC.getResourceCategory());
							expenseHierarchyItemCHC.setPositionType(expenseItemCHC.getPositionType());
							expenseHierarchyItemCHC.setTypeOfCare(null);
		
							expenseHierarchyItems.add(expenseHierarchyItemCHC);
							if(expenseItemCHC.getExpenseItemSubTypes() != null && !expenseItemCHC.getExpenseItemSubTypes().isEmpty()){
								for(String itemSubTypeCHC : expenseItemCHC.getExpenseItemSubTypes()){
									ExpenseHierarchyItemSubType expenseHierarchyItemSubTypeCHC = new ExpenseHierarchyItemSubType();
									expenseHierarchyItemSubTypeCHC.setExpenseItemId(expenseHierarchyItemCHC.getExpenseItemId());
									expenseHierarchyItemSubTypeCHC.setExpenseItemSubType(itemSubTypeCHC);
			
									expenseHierarchyItemSubTypes.add(expenseHierarchyItemSubTypeCHC);
								}
							}
						}
					}
				}
			}

			/**mapping PCN  */
			for(RootExpenseCategory categoryPCN : root.getPcn().getExpenseCategories()){
				ExpenseHierarchyCategory expenseHierarchyCategoryPCN = new ExpenseHierarchyCategory();
				expenseHierarchyCategoryPCN.setSubmissionId(root.getForm().getSubmissionId());
				expenseHierarchyCategoryPCN.setExpenseCategoryId(UUID.randomUUID().toString());
				expenseHierarchyCategoryPCN.setInitiativeType(root.getPcn().getPcnInitiativeType());
				expenseHierarchyCategoryPCN.setExpenseCategory(categoryPCN.getExpenseCategory());
	
				expenseHierarchyCategories.add(expenseHierarchyCategoryPCN);

				for(RootExpenseSubCategory subCategoryPCN : categoryPCN.getExpenseSubCategories()){
					ExpenseHierarchySubCategory expenseHierarchySubCategoryPCN = new ExpenseHierarchySubCategory();
					expenseHierarchySubCategoryPCN.setExpenseCategoryId(expenseHierarchyCategoryPCN.getExpenseCategoryId());
					expenseHierarchySubCategoryPCN.setExpenseSubCategoryId(UUID.randomUUID().toString());
					expenseHierarchySubCategoryPCN.setExpenseSubCategory(subCategoryPCN.getExpenseSubCategory());
	
					expenseHierarchySubCategories.add(expenseHierarchySubCategoryPCN);

					if(subCategoryPCN.getExpenseItems() != null && !subCategoryPCN.getExpenseItems().isEmpty()){
						for(RootExpenseItem expenseItemPCN : subCategoryPCN.getExpenseItems()){
							ExpenseHierarchyItem expenseHierarchyItemPCN = new ExpenseHierarchyItem();
							expenseHierarchyItemPCN.setExpenseSubCategoryId(expenseHierarchySubCategoryPCN.getExpenseSubCategoryId());
							expenseHierarchyItemPCN.setExpenseItemId(UUID.randomUUID().toString());
							expenseHierarchyItemPCN.setExpenseItem(expenseItemPCN.getExpenseItem());
							expenseHierarchyItemPCN.setResourceCategory(expenseItemPCN.getResourceCategory());
							expenseHierarchyItemPCN.setPositionType(expenseItemPCN.getPositionType());
							expenseHierarchyItemPCN.setTypeOfCare(null);
		
							expenseHierarchyItems.add(expenseHierarchyItemPCN);
	
							if(expenseItemPCN.getExpenseItemSubTypes() != null && !expenseItemPCN.getExpenseItemSubTypes().isEmpty()){
								for(String itemSubTypePCN : expenseItemPCN.getExpenseItemSubTypes()){
									ExpenseHierarchyItemSubType expenseHierarchyItemSubTypePCN = new ExpenseHierarchyItemSubType();
									expenseHierarchyItemSubTypePCN.setExpenseItemId(expenseHierarchyItemPCN.getExpenseItemId());
									expenseHierarchyItemSubTypePCN.setExpenseItemSubType(itemSubTypePCN);
			
									expenseHierarchyItemSubTypes.add(expenseHierarchyItemSubTypePCN);
								}
							}
						}
					}
				}
			}

			/** mapping UPCC */
			for(RootExpenseCategoryUPCC expenseCategoryUPCC : root.getUpcc().getExpenseCategories()){
				ExpenseHierarchyCategory expenseHierarchyCategoryUPCC = new ExpenseHierarchyCategory();
				expenseHierarchyCategoryUPCC.setSubmissionId(root.getForm().getSubmissionId());
				expenseHierarchyCategoryUPCC.setExpenseCategoryId(UUID.randomUUID().toString());
				expenseHierarchyCategoryUPCC.setInitiativeType(root.getUpcc().getInitiativeType());
				expenseHierarchyCategoryUPCC.setExpenseCategory(expenseCategoryUPCC.getExpenseCategory());
	
				expenseHierarchyCategories.add(expenseHierarchyCategoryUPCC);

				for(RootExpenseSubCategoryUPCC subCategoryUPCC : expenseCategoryUPCC.getExpenseSubCategories()){
					ExpenseHierarchySubCategory expenseHierarchySubCategoryUPCC = new ExpenseHierarchySubCategory();
					expenseHierarchySubCategoryUPCC.setExpenseCategoryId(expenseHierarchyCategoryUPCC.getExpenseCategoryId());
					expenseHierarchySubCategoryUPCC.setExpenseSubCategoryId(UUID.randomUUID().toString());
					expenseHierarchySubCategoryUPCC.setExpenseSubCategory(subCategoryUPCC.getExpenseSubCategory());
	
					expenseHierarchySubCategories.add(expenseHierarchySubCategoryUPCC);

					for(RootTypeOfCare typeOfCareUPCC : subCategoryUPCC.getTypesOfCare()){
						if(typeOfCareUPCC.getExpenseItems() != null && !typeOfCareUPCC.getExpenseItems().isEmpty()){
							for(RootExpenseItem expenseItemUPCC : typeOfCareUPCC.getExpenseItems()){
								ExpenseHierarchyItem expenseHierarchyItemUPCC = new ExpenseHierarchyItem();
								expenseHierarchyItemUPCC.setExpenseSubCategoryId(expenseHierarchySubCategoryUPCC.getExpenseSubCategoryId());
								expenseHierarchyItemUPCC.setExpenseItemId(UUID.randomUUID().toString());
								expenseHierarchyItemUPCC.setExpenseItem(expenseItemUPCC.getExpenseItem());
								expenseHierarchyItemUPCC.setResourceCategory(expenseItemUPCC.getResourceCategory());
								expenseHierarchyItemUPCC.setPositionType(expenseItemUPCC.getPositionType());
								expenseHierarchyItemUPCC.setTypeOfCare(typeOfCareUPCC.getTypeOfCare());
			
								expenseHierarchyItems.add(expenseHierarchyItemUPCC);
								if(expenseItemUPCC.getExpenseItemSubTypes() != null && !expenseItemUPCC.getExpenseItemSubTypes().isEmpty()){
									for(String itemSubTypeUPCC : expenseItemUPCC.getExpenseItemSubTypes()){
										ExpenseHierarchyItemSubType expenseHierarchyItemSubTypeUPCC = new ExpenseHierarchyItemSubType();
										expenseHierarchyItemSubTypeUPCC.setExpenseItemId(expenseHierarchyItemUPCC.getExpenseItemId());
										expenseHierarchyItemSubTypeUPCC.setExpenseItemSubType(itemSubTypeUPCC);
				
										expenseHierarchyItemSubTypes.add(expenseHierarchyItemSubTypeUPCC);
									}
								}
							}
						}
					}
				}
			}

			expenseHierarchySubmission.setExpenseHierarchyCategories(expenseHierarchyCategories);
			expenseHierarchySubmission.setExpenseHierarchySubCategories(expenseHierarchySubCategories);
			expenseHierarchySubmission.setExpenseHierarchyItems(expenseHierarchyItems);
			expenseHierarchySubmission.setExpenseHierarchyItemSubTypes(expenseHierarchyItemSubTypes);
			parsedExpenseCodeHierarchies.add(expenseHierarchySubmission);
		}
        return parsedExpenseCodeHierarchies;
    }

	/** This is the method to be used if we want to filter the ETL only on the latest submission */
	private Root getLatestSubmission(List<Root> allSubmissions){
		Comparator<Root> submissionDateComparator = Comparator.comparing(Root::getCreatedAt);
		return allSubmissions.stream().max(submissionDateComparator).get();
	}
    
}
