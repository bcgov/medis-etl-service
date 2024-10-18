package ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.PCDConstants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.core.processor.BaseApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.json.InterimReportingDates;
import ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.json.PeriodReportingDates;
import ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.json.QuarterReportingDates;
import ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.json.Root;
import ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.model.FiscalYearInterimDates;
import ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.model.FiscalYearPeriodDates;
import ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.model.FiscalYearQuarterDates;
import ca.bc.gov.chefs.etl.forms.pcd.fiscalYearReportingDates.model.FiscalYearReportingDatesSubmission;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;

public class PcdFiscalYearReportingDatesApiResponseProcessor extends BaseApiResponseProcessor {

    @SuppressWarnings("unchecked")
    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        ObjectMapper mapper = new ObjectMapper();

        List<Root> fiscalYearReportingDatesModels = mapper.readValue(payload,
                new TypeReference<List<Root>>() {
                });
        List<FiscalYearReportingDatesSubmission> parsedFiscalYearReportingDates = parseFiscalYearReportingDatesRequest(
                fiscalYearReportingDatesModels);

        validateRecordCount(fiscalYearReportingDatesModels, parsedFiscalYearReportingDates);

        List<IModel> iModels = (List<IModel>) (List<?>) parsedFiscalYearReportingDates;
        Map<String, List<List<String>>> map = CSVUtil.provider(iModels);

        boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
        List<String> filesGenerated = FileUtil.writeToCSVFile(map,
                PCDConstants.PCD_FISCAL_YEAR_REPORTING_DATES_DIR,
                isHeaderAdded);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setFiles(filesGenerated);
        exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
    }

    private List<FiscalYearReportingDatesSubmission> parseFiscalYearReportingDatesRequest(
            List<Root> fiscalYearReportingDatesModels) {
        List<FiscalYearReportingDatesSubmission> parsedFiscalYearReportingDatesSubmission = new ArrayList<>();
        // Use ModelMapper to handle the basic conversion
        ModelMapper modelMapper = new ModelMapper();

        // Define nested mappings
        modelMapper.typeMap(Root.class, FiscalYearReportingDatesSubmission.class).addMappings(mapper -> {
            mapper.map(src -> src.getForm().getSubmissionId(),
                    FiscalYearReportingDatesSubmission::setSubmissionId);
            mapper.map(src -> src.getForm().getFullName(),
                    FiscalYearReportingDatesSubmission::setSubmitterFullName);
            mapper.map(src -> src.getForm().getUsername(),
                    FiscalYearReportingDatesSubmission::setSubmitterUserName);
            mapper.map(src -> src.getForm().getEmail(),
                    FiscalYearReportingDatesSubmission::setSubmitterEmail);
            mapper.map(src -> src.getForm().getStatus(),
                    FiscalYearReportingDatesSubmission::setSubmissionStatus);
            mapper.map(src -> src.getForm().getVersion(),
                    FiscalYearReportingDatesSubmission::setSubmissionVersion);
            mapper.map(src -> src.getForm().getFormName(),
                    FiscalYearReportingDatesSubmission::setSubmissionFormName);

        });
        for (Root root : fiscalYearReportingDatesModels) {
            FiscalYearReportingDatesSubmission fiscalYearReportingDates = modelMapper.map(root,
                    FiscalYearReportingDatesSubmission.class);
            fiscalYearReportingDates.setCreatedAt(CSVUtil.formatDate(root.getForm().getCreatedAt()));
            System.out.println("Fiscal Year Reporting Dates Submission: " + root);

            List<FiscalYearInterimDates> interimReportingDates = new ArrayList<>();
            for (InterimReportingDates interimReportingDate : root.getInterimReportingDates()) {
                FiscalYearInterimDates fiscalYearInterimDate = new FiscalYearInterimDates();
                fiscalYearInterimDate.setSubmissionId(root.getForm().getSubmissionId());
                fiscalYearInterimDate.setInterim(interimReportingDate.getInterim());
                fiscalYearInterimDate.setInterimId(java.util.UUID.randomUUID().toString());
                fiscalYearInterimDate.setStartDate(CSVUtil.formatDate(interimReportingDate.getStartDate()));
                fiscalYearInterimDate.setEndDate(CSVUtil.formatDate(interimReportingDate.getEndDate()));
                fiscalYearInterimDate
                        .setSubmissionDueDate(CSVUtil.formatDate(interimReportingDate.getSubmissionDueDate()));
                fiscalYearInterimDate
                        .setValidationDueDate(CSVUtil.formatDate(interimReportingDate.getValidationDueDate()));
                interimReportingDates.add(fiscalYearInterimDate);
            }
            fiscalYearReportingDates.setFiscalYearInterimDates(interimReportingDates);

            List<FiscalYearPeriodDates> fiscalYearPeriodDates = new ArrayList<>();
            for (PeriodReportingDates periodDate : root.getPeriodReportingDates()) {
                FiscalYearPeriodDates fiscalYearPeriodDate = new FiscalYearPeriodDates();
                fiscalYearPeriodDate.setSubmissionId(root.getForm().getSubmissionId());
                fiscalYearPeriodDate.setPeriodId(java.util.UUID.randomUUID().toString());
                fiscalYearPeriodDate.setPeriod(periodDate.getPeriod());
                fiscalYearPeriodDate.setStartDate(CSVUtil.formatDate(periodDate.getStartDate()));
                fiscalYearPeriodDate.setEndDate(CSVUtil.formatDate(periodDate.getEndDate()));
                fiscalYearPeriodDate.setSubmissionDueDate(CSVUtil.formatDate(periodDate.getSubmissionDueDate()));
                fiscalYearPeriodDate.setValidationDueDate(CSVUtil.formatDate(periodDate.getValidationDueDate()));
                fiscalYearPeriodDates.add(fiscalYearPeriodDate);
            }
            fiscalYearReportingDates.setFiscalYearPeriodDates(fiscalYearPeriodDates);

            List<FiscalYearQuarterDates> fiscalYearQuarterDates = new ArrayList<>();
            for (QuarterReportingDates quarter : root.getQuarterReportingDates()) {
                FiscalYearQuarterDates fiscalYearQuarterDate = new FiscalYearQuarterDates();
                fiscalYearQuarterDate.setSubmissionId(root.getForm().getSubmissionId());
                fiscalYearQuarterDate.setQuarterId(java.util.UUID.randomUUID().toString());
                fiscalYearQuarterDate.setQuarter(quarter.getQuarter());
                fiscalYearQuarterDate.setStartDate(CSVUtil.formatDate(quarter.getStartDate()));
                fiscalYearQuarterDate.setEndDate(CSVUtil.formatDate(quarter.getEndDate()));
                fiscalYearQuarterDate.setSubmissionDueDate(CSVUtil.formatDate(quarter.getSubmissionDueDate()));
                fiscalYearQuarterDate.setValidationDueDate(CSVUtil.formatDate(quarter.getValidationDueDate()));
                fiscalYearQuarterDates.add(fiscalYearQuarterDate);
            }
            fiscalYearReportingDates.setFiscalYearQuarterDates(fiscalYearQuarterDates);

            parsedFiscalYearReportingDatesSubmission.add(fiscalYearReportingDates);
        }
        return parsedFiscalYearReportingDatesSubmission;
    }

}
