package TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CMO_AssignBed_MarkPatientArrival.*;
import CMO_Pages.*;
import Utilities.read_excel_data_EM_GroupA;

public class IP_TC_270 {
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

	@Test(dataProvider = "test_data")
	public void navigate_to_Assign_Bed_Mark_Patient_Arrival(String Patient_ID) {

		CMO_Login_EM login = new CMO_Login_EM();
		login.login(driver);

		CMO_Select_Form form = new CMO_Select_Form();
		form.select_form(driver);

		Assign_Bed_Mark_Patient_Arrival bed = new Assign_Bed_Mark_Patient_Arrival();
		bed.assign_bed(driver, Patient_ID);

	}

	@AfterTest
	public void close_browser() {
		driver.close();
	}

	@DataProvider
	public String[][] test_data() throws InvalidFormatException, IOException {

		read_excel_data_EM_GroupA obj = new read_excel_data_EM_GroupA();
		return obj.read_sheet();
	}

}
