package TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import CMO_AssignBed_MarkPatientArrival.*;
import CMO_Cancel_Admission.*;
import CMO_Pages.*;
import NUR_Intra_Ward_Patient_Transfer.*;
import NUR_Pages.*;
import Utilities.*;

public class GroupA {
	WebDriver driver;

	// IP_TC_188_197_218

	@Test(dataProvider = "test_data", priority = 2)
	public void navigate_to_Verify_Assign_Bed(String Patient_ID) {

		// System Property for IE Driver
		String InterExploPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", InterExploPath);

		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();

		CMO_Login_EM login = new CMO_Login_EM();
		login.login(driver);

		CMO_Select_Form form = new CMO_Select_Form();
		form.select_form(driver);

		Assign_Bed_Verify_Encounter_ID_hyperlink_is_working bed = new Assign_Bed_Verify_Encounter_ID_hyperlink_is_working();
		bed.assign_bed(driver, Patient_ID);

		driver.close();

	}

	// IP_TC_270

	@Test(dataProvider = "test_data", priority = 3)
	public void navigate_to_Assign_Bed_Mark_Patient_Arrival(String Patient_ID) {

		// System Property for IE Driver
		String InterExploPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", InterExploPath);

		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();

		CMO_Login_EM login = new CMO_Login_EM();
		login.login(driver);

		CMO_Select_Form form = new CMO_Select_Form();
		form.select_form(driver);

		Assign_Bed_Mark_Patient_Arrival bed = new Assign_Bed_Mark_Patient_Arrival();
		bed.assign_bed(driver, Patient_ID);

		driver.close();

	}

	// IP_TC_

	@Test(dataProvider = "test_data", priority = 0)
	public void navigate_to_ransfer_patients_within_the_same_nursing_unit(String Patient_ID) {

		// System Property for IE Driver
		String InterExploPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", InterExploPath);

		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();

		NUR_Login_EM login = new NUR_Login_EM();
		login.login(driver);

		NUR_Select_Form_EM form = new NUR_Select_Form_EM();
		form.select_form(driver);

		Nurse_Transfer_patients_within_the_same_nursing_unit trans = new Nurse_Transfer_patients_within_the_same_nursing_unit();
		trans.transfer(driver, Patient_ID);

		driver.close();

	}

	// IP_TC_141_149_153_156_172_187_270

	@Test(dataProvider = "test_data", priority = 0)
	public void navigate_to_Cancel_Admission(String Patient_ID) {

		// System Property for IE Driver
		String InterExploPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", InterExploPath);

		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();

		CMO_Login_EM login = new CMO_Login_EM();
		login.login(driver);

		CMO_Select_Form form = new CMO_Select_Form();
		form.select_form(driver);

		Cancel_Admission admission = new Cancel_Admission();
		admission.cancel(driver, Patient_ID);

		driver.close();

	}

	@AfterTest
	public void close_browser() {
//		driver.close();
	}

	@DataProvider
	public String[][] test_data() throws InvalidFormatException, IOException {

		read_excel_data_EM_GroupA obj = new read_excel_data_EM_GroupA();
		return obj.read_sheet();
	}

}
