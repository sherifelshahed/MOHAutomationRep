package NUR_Upload_Document;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectForm {
	public void select_form(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			Thread.sleep(7000);
			// Click on Action
			By Action = By.xpath("/html/body/app-root/app-crm/div/div/app-patient-view/div/div/div[2]/div/div[7]");
			driver.findElement(Action).click();

			Thread.sleep(13000);

			// Select Upload_Document
			By Upload_Document = By.xpath("/html/body/app-root/app-crm/div/div/app-patient-view/app-lead-actions-popover/div/div/div[3]/div");
			driver.findElement(Upload_Document).click();
			Thread.sleep(3000);
			
			By Select_Document = By.xpath("/html/body/app-root/app-crm/div/div/app-patient-view/app-crm-forms-list/div/div[2]/div[2]/div[2]/div[4]");
			driver.findElement(Select_Document).click();
			
		} catch (InterruptedException ex) {
			Logger.getLogger(SelectForm.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
