package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CMO_Manage_Patient_Order.*;
import CMO_Pages.*;

public class IP_TC_881 {
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

		ACC_Cancel_Panel_Order order = new ACC_Cancel_Panel_Order();
		order.Order(driver);

	}

	@AfterTest
	public void close_browser() {
//		driver.close();
	}

}
