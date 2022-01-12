package TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Discharge_Patient_Process.*;
import Utilities.*;

public class GroupL {
	WebDriver driver;

	@Test(dataProvider = "test_data", priority = 2)
	public void navigate_to_Prepare_Discharge_Advice(String Patient_ID) {

		// System Property for IE Driver
		System.setProperty("webdriver.ie.driver",
				"D:\\Automation testing tools\\IEDriverServer\\IEDriver\\IE\\New folder\\IEDriverServer.exe");
		// Initialize InternetExplorer
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();

		NUR_Login_EM login = new NUR_Login_EM();
		login.login(driver);

		NUR_Prepare_Discharge_Advice advice = new NUR_Prepare_Discharge_Advice();
		advice.Prepare_Discharge_Advice_Edge(driver, Patient_ID);

		driver.quit();
	}

	@AfterTest
	public void close_browser() {
//		driver.close();
	}

	@DataProvider
	public String[][] test_data() throws InvalidFormatException, IOException {

		read_excel_data_EM_GroupC obj = new read_excel_data_EM_GroupC();
		return obj.read_sheet();
	}

}
