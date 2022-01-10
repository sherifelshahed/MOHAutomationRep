package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PCY_Dispense_Medication.*;
import PCY_Pages.*;

public class IP_TC_845 {
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

		Login_EM_IPD_Pharmacist login = new Login_EM_IPD_Pharmacist();
		login.login(driver);

		Deliver dispense3 = new Deliver();
		dispense3.deliver(driver);

	}

	@AfterTest
	public void close_browser() {
//		driver.close();
	}

}
