package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CMO_OPD_Create_consultation_visit.*;

public class IP_TC_519 {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		// System Property for Edge Driver
		System.setProperty("webdriver.edge.driver", "D:\\Data\\Automation\\msedgedriver.exe");// Initialize Edge Driver
		driver = new EdgeDriver();
		driver.navigate().to("http://10.209.1.140/healthplug/#/user/leads");
		driver.manage().window().maximize();
	}

	@Test
	public void navigate_to_login() throws InterruptedException {

		Login_HP Login = new Login_HP();
		Login.login_Edge(driver);

		Thread.sleep(1000);
		
		By SelectLogin = By.xpath(
				"/html/body/app-root/app-common-login/div/div[2]/div[2]/div[2]/div/div/div/div[2]/label");
		driver.findElement(SelectLogin).click();
		
		By ContinueBTN = By.xpath(
				"/html/body/app-root/app-common-login/div/div[2]/div[2]/div[3]/button");
		driver.findElement(ContinueBTN).click();
		
		SelectForm Form = new SelectForm();
		Form.select_form(driver);

		Create_consultation_visit form = new Create_consultation_visit();
		form.select_form(driver);
	}

	@AfterTest
	public void close() {
//		driver.close();
	}
}
