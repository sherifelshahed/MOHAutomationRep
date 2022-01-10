package CMO_Admit_Patient;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Admit_Patient {

	public void admit_patient(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(2);
			driver.switchTo().frame("f_query_add_mod");
			driver.switchTo().frame("Select_frame");

			By Admission_For = By.name("admission_for");
			driver.findElement(Admission_For).click();
			driver.findElement(Admission_For).sendKeys(Keys.TAB);

			By Patient_ID = By.name("patient_id");
			driver.findElement(Patient_ID).sendKeys("A200000546" + Keys.ENTER);

			By click = By.name("booking_ref_no");
			driver.findElement(click).click();

			Thread.sleep(500);

			driver.switchTo().defaultContent();
			driver.switchTo().frame(2);
			driver.switchTo().frame("f_query_add_mod");
			driver.switchTo().frame("Main_frame");

			By Specialty = By.name("SplDesc");
			driver.findElement(Specialty).sendKeys("Gen Surg Splty" + Keys.ENTER);

			By Nursing_Unit = By.name("nursing_unit_desc");
			driver.findElement(Nursing_Unit).sendKeys("General Surgery" + Keys.ENTER);

			By Service = By.name("service");
			driver.findElement(Service).click();
			driver.findElement(Service).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(Service).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(Service).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(Service).sendKeys(Keys.TAB);

			By Bed_Class = By.name("Bedcode");
			driver.findElement(Bed_Class).click();
			driver.findElement(Bed_Class).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(Bed_Class).sendKeys(Keys.TAB);

			By Bed_Type = By.name("bed_type");
			driver.findElement(Bed_Type).click();
			driver.findElement(Bed_Type).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(Bed_Type).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(Bed_Type).sendKeys(Keys.TAB);

			By Admission_Type = By.name("visit_adm_type");
			driver.findElement(Admission_Type).click();
			driver.findElement(Admission_Type).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(Admission_Type).sendKeys(Keys.TAB);

			By Admitting_Practitioner = By.name("practid_desc");
			driver.findElement(Admitting_Practitioner).sendKeys("Doctor El Zohour Inpatient 01" + Keys.ENTER);

			By click2 = By.name("expecteddischargedate");
			driver.findElement(click2).click();

			driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(2);
			driver.switchTo().frame("commontoolbarFrame");

			// Apply button

			By Apply_button = By.name("apply");
			driver.findElement(Apply_button).click();

			Thread.sleep(1000);

			driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			WebElement Message = driver.findElement(By.xpath("/html/body/p"));
			System.out.println(Message.getText());
			assertTrue(Message.getText().contains("Operation Completed Successfully"));

		} catch (

		InterruptedException ex) {
			Logger.getLogger(Admit_Patient.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}