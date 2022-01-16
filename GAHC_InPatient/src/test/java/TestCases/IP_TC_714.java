package TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import DOC_Pages.*;
import DOC_Prescribe_Medications.*;
import Utilities.read_excel_data_HP;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IP_TC_714 {

	WebDriver driver;

	@BeforeTest
	public void setup() {

//		// System Property for Edge Driver
//		String EdgePath = System.getProperty("user.dir") + "\\test\\msedgedriver.exe";
//		System.setProperty("webdriver.edge.driver", EdgePath);

		// Edge Driver
		WebDriverManager.edgedriver().setup();

		// Initialize Edge Driver
		driver = new EdgeDriver();

//		driver.navigate().to("https://utasks-main.web.app/login");
//		driver.manage().window().maximize();

		driver.navigate().to("http://10.209.1.140/healthplug/#/user/leads");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "test_data")
	public void navigate_to_Prescribe_Medications(String Patient_ID) {

		DOC_Login_HP Login = new DOC_Login_HP();
		Login.login_Edge(driver);

		DOC_SelectPatientIP select_patient = new DOC_SelectPatientIP();
		select_patient.selectpatientIP_Edge(driver, Patient_ID);

		SelectForm Form = new SelectForm();
		Form.select_form(driver);

		Prescribe_Medications order = new Prescribe_Medications();
		order.Physicians_Prescribe_Medications_Edge(driver);
	}

	@AfterTest
	public void close() {
//		driver.close();
	}

	@DataProvider
	public String[][] test_data() throws InvalidFormatException, IOException {

		read_excel_data_HP obj = new read_excel_data_HP();
		return obj.read_sheet();
	}
}
