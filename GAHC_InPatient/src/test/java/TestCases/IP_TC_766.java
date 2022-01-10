package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DOC_Initiate_discharge.*;
import DOC_Pages.*;
public class IP_TC_766 {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		// System Property for Edge Driver
		System.setProperty("webdriver.edge.driver", "D:\\Automation testing tools\\Edgedriver\\msedgedriver.exe");
		// Initialize Edge Driver
		driver = new EdgeDriver();
		driver.navigate().to("http://10.209.1.140/healthplug/#/user/leads");
		driver.manage().window().maximize();
	}

	@Test
	public void navigate_to_login() {

		DOC_Login_HP Login = new DOC_Login_HP();
		Login.login_Edge(driver);

		Initiate_discharge in = new Initiate_discharge();
		in.Initiate(driver);

	}

//	@AfterTest
//	public void close() {
//		driver.close();
//	}
}
