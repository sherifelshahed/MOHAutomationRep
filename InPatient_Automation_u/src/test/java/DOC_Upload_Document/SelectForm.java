package DOC_Upload_Document;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectForm {
	public void select_form(WebDriver driver) {

		try {

			Thread.sleep(7000);

			// Click on Action
			By Action = By.xpath("//div[text()='Actions ']");
			driver.findElement(Action).click();

			Thread.sleep(4000);

			// Select Upload_Document
			By Upload_Document = By.xpath("/html/body/app-root/app-crm/div/div/app-patient-view/app-lead-actions-popover/div/div/div[3]/div");
			driver.findElement(Upload_Document).click();
			Thread.sleep(1000);
			By SelectDocument = By.xpath("/html/body/app-root/app-crm/div/div/app-patient-view/app-crm-forms-list/div/div[2]/div[2]/div[2]/div[4]");
			driver.findElement(SelectDocument).click();

		} catch (InterruptedException ex) {
			Logger.getLogger(SelectForm.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
