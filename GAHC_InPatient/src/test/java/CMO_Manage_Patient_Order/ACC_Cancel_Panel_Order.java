package CMO_Manage_Patient_Order;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ACC_Cancel_Panel_Order {

	public void Order(WebDriver driver) {

		try {

			WebElement Manage_Patient_Order = driver.findElement(By.id("sd17"));
			Manage_Patient_Order.click();

			Thread.sleep(500);

			System.out.println("Accountant is Navigated to Manage Patient Order Page Successfully");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("content");
			driver.switchTo().frame("BLChargePatientQueryFrame");
			driver.switchTo().frame("search_frame");

			WebElement Patient_ID = driver.findElement(By.name("patient_id"));
			try {
				Patient_ID.clear();
			} catch (Exception e) {
			}
			Patient_ID.sendKeys("A200000518");

			WebElement SearchBTN = driver.findElement(By.name("search_button"));
			SearchBTN.click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame("content");
			driver.switchTo().frame("BLChargePatientQueryFrame");
			driver.switchTo().frame("result_frame");
			Thread.sleep(2000);
			WebElement PatID = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[4]/a"));
//			assertEquals(Patient, PatID.getText());
			System.out.println("Search button is working and result is displaying: " + PatID.getText());
			PatID.click();
			Thread.sleep(1000);

			Set<String> windows1 = driver.getWindowHandles();
			for (String window1 : windows1) {
				driver.switchTo().window(window1);
				if (driver.getTitle().contains("Charge Patient")) {

					driver.switchTo().parentFrame();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("BLChargePatientEncounterTab");
					Thread.sleep(1000);
					WebElement NewOrder = driver.findElement(By.id("NewOrder"));
					NewOrder.click();

					driver.switchTo().parentFrame();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("BLChargePatientEncounterTabPage");

					WebElement PanelBox = driver.findElement(By.id("serviceOrPanel"));
					PanelBox.click();

					WebElement Search = driver.findElement(By.name("add_mod"));
					Search.click();
				}
			}
			Set<String> windows2 = driver.getWindowHandles();
			for (String window2 : windows2) {
				driver.switchTo().window(window2);
				if (driver.getTitle().contains("Charge Patient")) {
					driver.switchTo().parentFrame();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("BLChargePatientEncounterTab");

					System.out.println(driver.getCurrentUrl());
					WebElement ExistingOrder = driver.findElement(By.id("ExistingOrder"));
					ExistingOrder.click();

					driver.switchTo().parentFrame();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("BLChargePatientEncounterTabPage");

					WebElement Search = driver.findElement(By.name("add_mod"));
					Search.click();

					driver.switchTo().parentFrame();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("BLChargePatientExisOrderServDetails");

					WebElement GRPCode = driver.findElement(By.id("serv_grp_code0"));
					GRPCode.click();

					driver.switchTo().parentFrame();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("BLChargePatientExisOrderServEdit");

					WebElement DocRefNo = driver.findElement(By.id("selAllChk"));
					DocRefNo.click();

					WebElement Cancel = driver.findElement(By.id("cancelAll"));
					Cancel.click();

					Thread.sleep(1000);

					org.openqa.selenium.Alert alert = driver.switchTo().alert();
					Thread.sleep(1000);
					alert.accept();
					Thread.sleep(2000);

					String currentWindow = driver.getWindowHandle();
					Set<String> windowsc = driver.getWindowHandles();
					for (String windowc : windowsc) {
						driver.switchTo().window(windowc);
						if (driver.getTitle().contains("Error / Warnings")) {

							WebElement Close = driver.findElement(By.id("btnClose"));
							Close.click();

							Thread.sleep(500);
							driver.switchTo().window(currentWindow);
							Thread.sleep(1000);

						}
					}

					Thread.sleep(500);
					try {
						org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
						String alertMessage1 = driver.switchTo().alert().getText();
						System.out.println(alertMessage1);
						Thread.sleep(1000);
						alert1.accept();
						Thread.sleep(2000);

					} catch (Exception e) {

					}
					System.out.println("Panel cancelled Successfully");

				}
			}

		} catch (InterruptedException ex) {
			Logger.getLogger(ACC_Cancel_Panel_Order.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}