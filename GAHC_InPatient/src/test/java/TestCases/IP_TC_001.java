package TestCases;

import Outpatient_OP_consultation.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IP_TC_001 {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		// System Property for Edge Driver
		String EdgePath = System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgePath);// Initialize Edge Driver
		// Initialize Edge Driver
		driver = new EdgeDriver();
		driver.navigate().to("http://10.209.1.140/healthplug/#/user/leads");
		driver.manage().window().maximize();
	}

	@Test
	public void navigate_to_login() {

		Login_HP Login = new Login_HP();
		Login.login_Edge(driver);

		SelectPatientIP select_patient = new SelectPatientIP();
		select_patient.selectpatientID_Edge(driver);

		SelectForm Form = new SelectForm();
		Form.select_form(driver);

		OP_consultation_form form = new OP_consultation_form();
		form.Physicians_consultation_Edge(driver);

	}

	@AfterTest
	public void close() {
//		driver.close();
	}
}
