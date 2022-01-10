package CMO_Admit_Patient;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register_Patient2 {

	public void register_patient(WebDriver driver) {

//		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {

			String currentWindow1 = driver.getWindowHandle();
			Set<String> windows1 = driver.getWindowHandles();
			for (String window1 : windows1) {
				driver.switchTo().window(window1);
				System.out.println(driver.getTitle());
			}
			if (driver.getTitle().contains("Register Patient")) {

				driver.switchTo().defaultContent();
				driver.switchTo().frame(1);
				driver.switchTo().frame("patient_sub");

				By national_id = By.name("national_id_no");
				driver.findElement(national_id).sendKeys("123456789");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("commontoolbarFrame");

				Thread.sleep(1000);

				By Apply_button = By.name("apply");
				driver.findElement(Apply_button).click();

				Thread.sleep(200);
			}

		} catch (InterruptedException ex) {
			Logger.getLogger(Register_Patient2.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}