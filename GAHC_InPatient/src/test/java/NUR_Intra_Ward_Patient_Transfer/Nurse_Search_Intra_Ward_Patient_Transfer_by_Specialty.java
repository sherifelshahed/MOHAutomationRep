package NUR_Intra_Ward_Patient_Transfer;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nurse_Search_Intra_Ward_Patient_Transfer_by_Specialty {
	public void transfer(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			WebElement Transfer_Patient_Intra_btn = driver.findElement(By.id("sd2"));
			Transfer_Patient_Intra_btn.click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(2);
			driver.switchTo().frame("commontoolbarFrame");
			WebElement page_title = driver.findElement(By.id("cmnToolBarFuncName"));
			if (page_title.isDisplayed()) {
				System.out.println("we are at 'Intra-Ward Patient Transfer' function");
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame(2);
			driver.switchTo().frame("f_query_add_mod");
			WebElement specialty_txt = driver.findElement(By.name("specialty_desc"));
			specialty_txt.sendKeys("Gen Surg Splty");
			WebElement specialty_search_btn = driver.findElement(By.name("specialty_lookup"));
			specialty_search_btn.click();
			WebElement SearchBtn = driver.findElement(By.name("search"));
			SearchBtn.click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(2);
			driver.switchTo().frame("f_query_add_mod1");

			WebElement Encounter_ID_hyperlink = driver.findElement(By.partialLinkText("1000"));
			if (Encounter_ID_hyperlink.isDisplayed()) {
				System.out.println("the search result is Displayed and some Encounter IDs are Displayed");
				System.out.println("Nurse can search in 'Intra Ward Patient Transfer' by Specialty Successfully ");

			}
			Thread.sleep(10000);

		} catch (

		InterruptedException ex) {
			Logger.getLogger(Nurse_Search_Intra_Ward_Patient_Transfer_by_Specialty.class.getName())
					.log(Level.SEVERE, null, ex);
		}
	}
}