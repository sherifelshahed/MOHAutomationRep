package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import NUR_Intra_Ward_Patient_Transfer.*;
import NUR_Pages.*;

public class IP_TC_584 {
	WebDriver driver;

	@BeforeTest
	public void setup() {

		// System Property for IE Driver
		String InterExploPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", InterExploPath);

		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();
	}

	@Test
	public void navigate_to_ransfer_patients_within_the_same_nursing_unit(String Patient_ID) {

		NUR_Login_EM login = new NUR_Login_EM();
		login.login(driver);

		NUR_Select_Form_EM form = new NUR_Select_Form_EM();
		form.select_form(driver);

		Nurse_Transfer_patients_within_the_same_nursing_unit trans = new Nurse_Transfer_patients_within_the_same_nursing_unit();
		trans.transfer(driver, Patient_ID);

	}

	@AfterTest
	public void close_browser() {
//		driver.close();
	}

}
