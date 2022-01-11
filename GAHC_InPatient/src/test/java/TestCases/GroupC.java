package TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Discharge_Patient_Process.*;
import NUR_Cancel_Discharge_Advice.Nurse_Cancel_Discharge_Advice;
import NUR_Cancel_Discharge_Advice.Nurse_Cancel_Discharge_Advice_Form_UI;
import NUR_Cancel_Discharge_Advice.Nurse_Cancel_Discharge_Advice_UI;
import NUR_Pages.NUR_Login_EM;
import NUR_Pages.NUR_Select_Form_EM;
import NUR_Discharge_Advice.Nurse_Prepare_Discharge_Advice;
import NUR_Discharge_Advice.Nurse_Prepare_Discharge_Advice_UI;
import NUR_Release_Blocked.Nurse_Check_Unblock_Bed_UI;
import Utilities.*;

public class GroupC {
	WebDriver driver;

	// IP_TC_766

	@Test(dataProvider = "test_data", priority = 1)
	public void navigate_to_Initiate_discharge(String Patient_ID) {

		// System Property for Edge Driver
		String EdgePath = System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgePath);

		// Initialize Edge Driver
		driver = new EdgeDriver();
		driver.navigate().to("http://10.209.1.140/healthplug/#/user/leads");
		driver.manage().window().maximize();

		DOC_Login_HP Login = new DOC_Login_HP();
		Login.login_Edge(driver);

		DOC_Initiate_Discharge in = new DOC_Initiate_Discharge();
		in.Initiate(driver, Patient_ID);

		driver.close();

	}

	// IP_TC_643

	@Test(dataProvider = "test_data", priority = 2)
	public void navigate_to_Nurse_Prepare_Discharge_Advice_UI(String Patient_ID) {

		NUR_Login_EM login = new NUR_Login_EM();
		login.login(driver);

		NUR_Select_Form_EM form = new NUR_Select_Form_EM();
		form.select_form(driver);

		Nurse_Prepare_Discharge_Advice_UI discharge = new Nurse_Prepare_Discharge_Advice_UI();
		discharge.discharge_advice(driver, Patient_ID);

		driver.close();

	}

	// IP_TC_644

	@Test(dataProvider = "test_data", priority = 3)
	public void navigate_to_Nurse_Prepare_Discharge_Advice(String Patient_ID) {

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

		Nurse_Prepare_Discharge_Advice discharge = new Nurse_Prepare_Discharge_Advice();
		discharge.Prepare_Discharge_Advice(driver, Patient_ID);

		driver.close();
	}

	// IP_TC_654

	@Test(dataProvider = "test_data", priority = 4)

	public void navigate_to_Nurse_Cancel_Discharge_Advice_UI(String Patient_ID) {

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

		Nurse_Cancel_Discharge_Advice_UI UI = new Nurse_Cancel_Discharge_Advice_UI();
		UI.discharge_advice(driver, Patient_ID);

		driver.close();
	}

	// IP_TC_661

	@Test(dataProvider = "test_data", priority = 5)

	public void navigate_to_Nurse_Cancel_Discharge_Advice_Form_UI(String Patient_ID) {

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

		Nurse_Cancel_Discharge_Advice_Form_UI UI = new Nurse_Cancel_Discharge_Advice_Form_UI();
		UI.discharge_advice(driver, Patient_ID);

		driver.close();
	}

	// IP_TC_662

	@Test(dataProvider = "test_data", priority = 6)

	public void navigate_to_Nurse_Cancel_Discharge_Advice(String Patient_ID) {

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

		Nurse_Cancel_Discharge_Advice cancel = new Nurse_Cancel_Discharge_Advice();
		cancel.discharge_advice(driver, Patient_ID);

		driver.close();
	}

	// IP_TC_644

	@Test(dataProvider = "test_data", priority = 7)
	public void navigate_to_Nurse_Prepare_Discharge_Advice2(String Patient_ID) {

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

		Nurse_Prepare_Discharge_Advice discharge = new Nurse_Prepare_Discharge_Advice();
		discharge.Prepare_Discharge_Advice(driver, Patient_ID);

		driver.close();
	}

	// IP_TC_770 tttttttttffffffffff

	@Test(dataProvider = "test_data", priority = 8)
	public void navigate_to_Discharge_Summary(String Patient_ID) {

		// System Property for Edge Driver
		String EdgePath = System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgePath);

		// Initialize Edge Driver
		driver = new EdgeDriver();
		driver.navigate().to("http://10.209.1.140/healthplug/#/user/leads");
		driver.manage().window().maximize();

		DOC_Login_HP Login = new DOC_Login_HP();
		Login.login_Edge(driver);

		DOC_Discharge_Summary summary = new DOC_Discharge_Summary();
		summary.Physicians_Discharge_Summary_Edge(driver, Patient_ID);

		driver.quit();

	}

	@Test(dataProvider = "test_data", priority = 4)
	public void navigate_to_ACC_Add_Service(String Patient_ID) {

		// System Property for IE Driver
		String InterExploPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", InterExploPath);

		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();

		CMO_Login_EM login = new CMO_Login_EM();
		login.login(driver);

		ACC_AddSeparateService service = new ACC_AddSeparateService();
		service.Add_Separate_Service(driver, Patient_ID);

		driver.quit();
	}

	@Test(dataProvider = "test_data", priority = 5)
	public void navigate_to_Bill_Generation(String Patient_ID) {

		// System Property for IE Driver
		String InterExploPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", InterExploPath);

		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();

		CMO_Login_EM login = new CMO_Login_EM();
		login.login(driver);

		CMO_Generate_Bill bill = new CMO_Generate_Bill();
		bill.generate_bill(driver, Patient_ID);

		driver.quit();
	}

	@Test(dataProvider = "test_data", priority = 6)
	public void navigate_to_Discharge_Patient(String Patient_ID) {

		// System Property for IE Driver
		String InterExploPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", InterExploPath);

		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();

		CMO_Login_EM login = new CMO_Login_EM();
		login.login(driver);

		CMO_Discharge_Patient dis = new CMO_Discharge_Patient();
		dis.discharge_patient(driver, Patient_ID);

		driver.quit();
	}

	///////////

	@AfterTest
	public void close_browser() {
//		driver.close();
	}

	@DataProvider
	public String[][] test_data() throws InvalidFormatException, IOException {

		read_excel_data_EM_GroupC obj = new read_excel_data_EM_GroupC();
		return obj.read_sheet();
	}

}
