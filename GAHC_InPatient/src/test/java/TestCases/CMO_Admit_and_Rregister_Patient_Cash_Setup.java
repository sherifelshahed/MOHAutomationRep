package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CMO_Admit_Patient.*;
import CMO_Pages.*;

public class CMO_Admit_and_Rregister_Patient_Cash_Setup {
	WebDriver driver;

	@BeforeTest
	public void setup() {

		// System Property for IE Driver
		System.setProperty("webdriver.ie.driver",
				"D:\\Automation testing tools\\IEDriverServer\\IEDriver\\IE\\New folder\\IEDriverServer.exe");
		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();
	}

	@Test
	public void navigate_to_login() {

		CMO_Login_EM login = new CMO_Login_EM();
		login.login(driver);

		CMO_Select_Form form = new CMO_Select_Form();
		form.select_form(driver);

		Search_Patient search = new Search_Patient();
		search.search_patient(driver);

		Register_Patient register = new Register_Patient();
		register.register_patient(driver);

		Financial_Details_Cash financial = new Financial_Details_Cash();
		financial.financial_details(driver);

		Register_Patient2 register2 = new Register_Patient2();
		register2.register_patient(driver);

		Admit_Patient admit = new Admit_Patient();
		admit.admit_patient(driver);
	}

	@AfterTest
	public void close_browser() {
//		driver.close();
	}

}
