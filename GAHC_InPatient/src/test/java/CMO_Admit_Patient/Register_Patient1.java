package CMO_Admit_Patient;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Register_Patient1 {

	public void register_patient(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

				By Patient_Series = By.name("pat_ser_grp_code");
				driver.findElement(Patient_Series).click();
				driver.findElement(Patient_Series).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(Patient_Series).sendKeys(Keys.ENTER);

				By First_Name = By.name("first_name");
				driver.findElement(First_Name).sendKeys("test");

				By Family_Name = By.name("family_name");
				driver.findElement(Family_Name).sendKeys("degital_blx");

				By First_Name_الاسم_الاول = By.name("first_name_oth_lang");
				driver.findElement(First_Name_الاسم_الاول).sendKeys("اختبار");

				By Family_Nameاسم_العائلة = By.name("family_name_oth_lang");
				driver.findElement(Family_Nameاسم_العائلة).sendKeys("بلوكس ديجتال");

				By Gender = By.name("sex");
				driver.findElement(Gender).click();
				driver.findElement(Gender).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(Gender).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(Gender).sendKeys(Keys.ENTER);

				By Birth_Date = By.name("date_of_birth");
				driver.findElement(Birth_Date).sendKeys("20/04/1990");

				driver.switchTo().defaultContent();
				driver.switchTo().frame(1);
				driver.switchTo().frame("patient_main");

				Thread.sleep(50);

				By Financial_Details = By.id("findtl_tabspan");
				driver.findElement(Financial_Details).click();

			}
//			
		} catch (InterruptedException ex) {
			Logger.getLogger(Register_Patient.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
