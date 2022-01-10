package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Lab_Technician_Orders.*;

public class IP_TC_520 {
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
		Login_EM login = new Login_EM();
		login.login(driver);

		Responsibility res = new Responsibility();
		res.responsibility(driver);

		Select_Form form = new Select_Form();
		form.select_form(driver);

		Register_Order Order = new Register_Order();
		Order.Register(driver);

	}

	@AfterTest
	public void close_browser() {
//		driver.close();
	}

}
