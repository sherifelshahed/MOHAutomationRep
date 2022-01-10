package CMO_Admit_Patient;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register_Patient {

	public void register_patient(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(2);
			driver.switchTo().frame("f_query_add_mod");

			driver.switchTo().frame("Select_frame");

			By Patient_ID = By.name("patient_id_search");
			driver.findElement(Patient_ID).click();

			String currentWindow = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			for (String window : windows) {
				driver.switchTo().window(window);
//			System.out.println(driver.getTitle());
			}
			if (driver.getTitle().contains("Search Patient")) {

				driver.switchTo().defaultContent();
				driver.switchTo().frame("Pat_Search_Criteria_Frame");

				By Patient_ID2 = By.name("Patient_Id");
				driver.findElement(Patient_ID2).sendKeys("757");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("Pat_Search_Toolbar_Frame");

				By Search = By.name("Search");
				driver.findElement(Search).click();

				By Rregister_Patient = By.name("register");
				driver.findElement(Rregister_Patient).click();
				Thread.sleep(10);
			}
		} catch (InterruptedException ex) {
			Logger.getLogger(Register_Patient.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}