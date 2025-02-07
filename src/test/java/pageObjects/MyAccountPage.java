package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {

		super(driver);
	}

//Locators
	By myaccountpageinfo = By.xpath("//h2[normalize-space()='My Account']");
	By logout = By.xpath("(//*[contains(text(),'Logout')])[1]"); // Logout xpath
	By invalidcred = By.xpath("//*[contains(text(),'No match')]"); //xpath for invalid credentails

//Actions

	public String myaccountpagemsg() {
		return driver.findElement(myaccountpageinfo).getText();// to get the text - my account
	}

	public void logout_button() {
		driver.findElement(logout).click(); // get hit on logout button
	}

	public String invalidcred() {
		return driver.findElement(invalidcred).getText();
	}

}
