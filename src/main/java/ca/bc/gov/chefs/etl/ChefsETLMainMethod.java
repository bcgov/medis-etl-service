package ca.bc.gov.chefs.etl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Security;

import org.apache.camel.main.Main;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.forms.aims.route.AIMSFormRoute;
import ca.bc.gov.chefs.etl.forms.ltc.budget.route.LtcAnnualBudgetRoute;
import ca.bc.gov.chefs.etl.forms.ltc.facility.route.FacilityFormRoute;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.route.LtcQuarterlyYtdRoute;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.route.LtcStaffingPlanRoute;
import ca.bc.gov.chefs.etl.forms.pcd.chc.budget.route.ChcBudgetFormRoute;
import ca.bc.gov.chefs.etl.forms.pcd.chc.financialReporting.route.ChcFRFormRoute;
import ca.bc.gov.chefs.etl.forms.pcd.decisionLog.route.DecisionLogRoute;
import ca.bc.gov.chefs.etl.forms.pcd.financialExpenseHierarchy.route.FinancialExpenseFormRoute;
import ca.bc.gov.chefs.etl.forms.pcd.haHierarchy.route.HAHierarchyRoute;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.budget.route.PcnBudgetFormRoute;
import ca.bc.gov.chefs.etl.forms.pcd.pcn.financialReporting.route.PcnFRFormRoute;
import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.route.StatusTrackerFormRoute;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.budget.route.UpccBudgetFormRoute;
import ca.bc.gov.chefs.etl.forms.pcd.upcc.financialReporting.route.UpccFRFormRoute;
/**
 * Camel Class runner.
 * */
public class ChefsETLMainMethod {
	
	static {
		/* Creating Necessary Directories for ETL */
		
		/* Encrypted and Non-Encrypted Directories */
		try {
			Files.createDirectories(Paths.get(Constants.DATA_DIRECTORY));
			Files.createDirectories(Paths.get(Constants.ENCRYPTED_DATA_DIRECTORY));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String... args) throws Exception {
		Main main = new Main();
		Security.addProvider(new BouncyCastleProvider());
		main.configure().addRoutesBuilder(AIMSFormRoute.class);
		main.configure().addRoutesBuilder(FacilityFormRoute.class);
		main.configure().addRoutesBuilder(LtcQuarterlyYtdRoute.class);
		main.configure().addRoutesBuilder(LtcStaffingPlanRoute.class);
		main.configure().addRoutesBuilder(LtcAnnualBudgetRoute.class);
		
		/* --------------PCDBI ROUTES --------------- */
		main.configure().addRoutesBuilder(DecisionLogRoute.class);
		main.configure().addRoutesBuilder(HAHierarchyRoute.class);
		main.configure().addRoutesBuilder(StatusTrackerFormRoute.class);
		main.configure().addRoutesBuilder(UpccBudgetFormRoute.class);
		main.configure().addRoutesBuilder(UpccFRFormRoute.class);
		main.configure().addRoutesBuilder(PcnBudgetFormRoute.class);
		main.configure().addRoutesBuilder(PcnFRFormRoute.class);
		main.configure().addRoutesBuilder(FinancialExpenseFormRoute.class);
		main.configure().addRoutesBuilder(ChcBudgetFormRoute.class);
		main.configure().addRoutesBuilder(ChcFRFormRoute.class);
		main.run(args);
	}
}
