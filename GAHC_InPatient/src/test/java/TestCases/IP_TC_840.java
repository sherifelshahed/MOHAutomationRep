package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PCY_Pages.*;
import PCY_Return_Medication.*;

public class IP_TC_840 {
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

		Login_EM_Pharmacy_Management login = new Login_EM_Pharmacy_Management();
		login.login(driver);

		Accept_Return_Medication med = new Accept_Return_Medication();
		med.Medication(driver);

	}

	@AfterTest
	public void close_browser() {
//		driver.close();
	}

}
