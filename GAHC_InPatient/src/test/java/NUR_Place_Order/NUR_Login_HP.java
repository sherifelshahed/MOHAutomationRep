package NUR_Place_Order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NUR_Login_HP {

	public void login_Edge(WebDriver driver) {

		// Login to HP Web
		By username = By.id("user-id");
		driver.findElement(username).sendKeys("NURIPD01");

		By password = By.id("his-password");
		driver.findElement(password).sendKeys("egy123");

		By login_button = By.xpath("/html/body/app-root/app-common-login/div/div[2]/div[2]/form/button");
		driver.findElement(login_button).click();
	}

}
