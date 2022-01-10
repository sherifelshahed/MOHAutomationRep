package Discharge_Patient_Process;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DOC_Initiate_Discharge {

	public void Initiate(WebDriver driver, String Patient_ID) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			Thread.sleep(1000);

			By searchText = By
					.xpath("/html/body/app-root/app-crm/div/div/app-crm-leads/app-crm-header/div/div/div[1]/input");
			driver.findElement(searchText).sendKeys(Patient_ID + Keys.ENTER);

			Thread.sleep(4000);

			// Mouse Hover action
			Actions action = new Actions(driver);
			WebElement edit = driver.findElement(By.xpath(
					"/html/body/app-root/app-crm/div/div/app-crm-leads/div[2]/div/div[2]/div/div/app-crm-patients-list/div/div[2]/div/div/div[1]"));
			action.moveToElement(edit).build().perform();

			Thread.sleep(3000);

			By three_point = By.xpath(
					"/html/body/app-root/app-crm/div/div/app-crm-leads/div[2]/div/div[2]/div/div/app-crm-patients-list/div/div[2]/div/div/div[7]/div[3]/img");
			driver.findElement(three_point).click();

			Thread.sleep(2000);

			By initiateDischarge = By.xpath(
					"/html/body/app-root/app-crm/div/div/app-crm-leads/div[2]/div/div[2]/div/div/app-crm-patients-list/div/div[2]/div/div/div[7]/div[4]/div[3]");
			driver.findElement(initiateDischarge).click();

//			By Intimation = By.xpath("http://html/body/app-root/app-toast/div/div/div/div/p");
//
//			By PatientName = By.xpath(
//					"/html/body/app-root/app-crm/div/div/app-crm-leads/div[2]/div/div[2]/div/div/app-crm-patients-list/div/div[2]/div/div/div[1]/div[2]/p[1]");
//			String getIntimation = driver.findElement(Intimation).getText();
//			assertEquals("Patient" + PatientName + "Discharge initimation cancelled", getIntimation);
//
//			String getPatientName = driver.findElement(PatientName).getText();
//			System.out.println("Patient Name : " + getPatientName);

		} catch (InterruptedException ex) {
			Logger.getLogger(DOC_Initiate_Discharge.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
