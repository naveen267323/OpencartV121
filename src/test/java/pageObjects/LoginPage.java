package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

//constuctors

	public LoginPage(WebDriver driver) {
		super(driver);
	}

//Locators

	By giveemail = By.xpath("//input[@id='input-email']");

	By givepassword = By.xpath("//input[@id='input-password']");

	By hitloginbutton = By.xpath("//input[@value='Login']");

	By invalidcred = By.xpath("//*[contains(text(),'No match')]");

//Actions

	public void giveemail(String email) {
		driver.findElement(giveemail).sendKeys(email);
	}

	public void givepassword(String pass) {
		driver.findElement(givepassword).sendKeys(pass);
	}

	public void hitloginbutton() {
		driver.findElement(hitloginbutton).click();
	}

	public String invalidcred() {
		return driver.findElement(invalidcred).getText();
	}

}
