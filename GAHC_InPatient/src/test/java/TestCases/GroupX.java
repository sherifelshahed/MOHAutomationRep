package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import CMO_AssignBed_MarkPatientArrival.Assign_Bed_Mark_Patient_Arrival;
import CMO_AssignBed_MarkPatientArrival.Assign_Bed_Verify_Encounter_ID_hyperlink_is_working;
import CMO_Pages.CMO_Login_EM;
import CMO_Pages.CMO_Select_Form;
import NUR_Block_Bed.Nurse_Check_Block_Bed_UI;
import NUR_Intra_Ward_Patient_Transfer.Nurse_Check_Intra_Ward_Patient_Transfer_UI;
import NUR_Pages.NUR_Login_EM;
import NUR_Pages.NUR_Select_Form_EM;

public class GroupX {

	WebDriver driver;

	// IP_TC_188_197_218

	@Test(dataProvider = "test_data", priority = 2)
	public void navigate_to_Verify_Assign_Bed_UI(String Patient_ID) {

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

		driver.quit();

	}

	@Test
	public void navigate_to_Nurse_Check_Block_Bed_UI() {

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

		Nurse_Check_Block_Bed_UI UI = new Nurse_Check_Block_Bed_UI();
		UI.bed(driver);

		driver.quit();

	}
	
	@Test(priority = 4)
	public void navigate_to_Nurse_Check_Intra_Ward_Patient_Transfer_UI() {

		// System Property for IE Driver
		String InterExploPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", InterExploPath);

		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();

		NUR_Login_EM login = new NUR_Login_EM();
		login.login(driver);

//		NUR_Select_Form_EM form = new NUR_Select_Form_EM();
//		form.select_form(driver);
//
//		Nurse_Check_Intra_Ward_Patient_Transfer_UI UI = new Nurse_Check_Intra_Ward_Patient_Transfer_UI();
//		UI.transfer(driver);

	driver.quit();

	}
	
}
