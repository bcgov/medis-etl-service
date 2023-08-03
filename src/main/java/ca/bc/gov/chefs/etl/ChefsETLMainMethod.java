package ca.bc.gov.chefs.etl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Security;

import ca.bc.gov.chefs.etl.forms.pcd.statusTracker.route.StatusTrackerFormRoute;
import org.apache.camel.main.Main;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.forms.ltc.facility.route.FacilityFormRoute;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.route.LtcQuarterlyYtdRoute;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.route.LtcStaffingPlanRoute;
import ca.bc.gov.chefs.etl.forms.aims.route.AIMSFormRoute;
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
		// TODO : remove next line, for testing purposes only 
		//FileUtil.decryptAllFiles("encrypted/ltc-quarterly/230414140122", "encrypted/ltc-quarterly/230414140122/test");
		main.configure().addRoutesBuilder(AIMSFormRoute.class);
		main.configure().addRoutesBuilder(FacilityFormRoute.class);
		main.configure().addRoutesBuilder(LtcQuarterlyYtdRoute.class);
		main.configure().addRoutesBuilder(LtcStaffingPlanRoute.class);
		main.configure().addRoutesBuilder(StatusTrackerFormRoute.class);
		main.run(args);
	}
}
