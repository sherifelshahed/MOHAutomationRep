package TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DOC_Pages.*;
import DOC_Progress_Notes.*;
import Utilities.read_excel_data_HP;

public class IP_TC_721 {

	WebDriver driver;

	@BeforeTest
	public void setup() {

		// System Property for Edge Driver
		String EdgePath = System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgePath);

		// Initialize Edge Driver
		driver = new EdgeDriver();
		driver.navigate().to("http://10.209.1.140/healthplug/#/user/leads");
		driver.manage().window().maximize();

	}

	@Test(dataProvider = "test_data")
	public void navigate_to_Doctor_Submit_Progress_Notes(String Patient_ID) {

		DOC_Login_HP Login = new DOC_Login_HP();
		Login.login_Edge(driver);

		DOC_SelectPatientIP select_patient = new DOC_SelectPatientIP();
		select_patient.selectpatientIP(driver, Patient_ID);

		SelectForm_progress_note Form = new SelectForm_progress_note();
		Form.select_form(driver);

		Progress_Notes note = new Progress_Notes();
		note.Physicians_progress_note_Edge(driver);

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
