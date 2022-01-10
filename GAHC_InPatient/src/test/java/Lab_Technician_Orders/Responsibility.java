package Lab_Technician_Orders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Responsibility {
	public void responsibility(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		By OKButton = By.id("loginID");
		driver.findElement(OKButton).click();
	}
}
