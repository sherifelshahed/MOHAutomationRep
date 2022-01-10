package NUR_Transfer_Practitioner;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nurse_Transfer_practitioner {

	public void Transfer(WebDriver driver) {

		try {

			WebElement Transfer_Practitioner_btn = driver.findElement(By.id("sd10"));
			Transfer_Practitioner_btn.click();

			Thread.sleep(500);
			System.out.println("Nurse is Navigated to  Transfer Practitioner Page Successfully");
			driver.switchTo().defaultContent();
			driver.switchTo().frame(2);
			driver.switchTo().frame("f_query_add_mod");

			WebElement patientId = driver.findElement(By.name("patient_id"));
			patientId.sendKeys("A200000403");
			WebElement SearchBtn = driver.findElement(By.name("search"));
			SearchBtn.click();

			driver.switchTo().defaultContent();

			driver.switchTo().frame(2);
			driver.switchTo().frame("f_query_add_mod1");

			WebElement Encounter_ID_hyperlink = driver.findElement(By.partialLinkText("1000"));
			Encounter_ID_hyperlink.click();

			String currentWindow = driver.getWindowHandle();
			for (String window1 : driver.getWindowHandles()) {
				driver.switchTo().window(window1);
				// System.out.println(driver.getTitle());
				if (driver.getTitle().contains("Practitioner Transfer")) {
					// System.out.println(driver.getCurrentUrl());
					driver.switchTo().defaultContent();
					driver.switchTo().frame("Transfer_frame");
					WebElement TransferTypeDDL = driver.findElement(By.name("transfer_type"));
					TransferTypeDDL.click();
					TransferTypeDDL.sendKeys(Keys.ARROW_DOWN);
					TransferTypeDDL.sendKeys(Keys.TAB);
					// to select a practitioner
					WebElement PractitionerLookupBtn = driver.findElement(By.name("pract_id_search"));
					String current = driver.getWindowHandle();
					PractitionerLookupBtn.click();

					Set<String> winds = driver.getWindowHandles();
					for (String wind : winds) {
						driver.switchTo().window(wind);
						System.out.println(driver.getTitle());

						if (driver.getTitle().equals("Practitioner")) {
							System.out.println(driver.getCurrentUrl());
							driver.switchTo().frame("result_frame");
							WebElement PractitionerCodeLink = driver
									.findElement(By.partialLinkText("Doctor El Zohour Inpatient 01"));
							PractitionerCodeLink.click();
							Thread.sleep(5000);

						}
						driver.switchTo().window(current);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("Transfer_frame");
						WebElement transferBtn = driver.findElement(By.name("transfer"));
						transferBtn.click();
						Thread.sleep(5000);
						driver.switchTo().alert().getText();
					}

				}
			}
		} catch (InterruptedException ex) {
			Logger.getLogger(Nurse_Transfer_practitioner.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
