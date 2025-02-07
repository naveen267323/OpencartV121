package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

//constructors
	
	public HomePage(WebDriver driver) {
		super(driver);

	}

//Locators

	By myaccount = By.xpath("//span[normalize-space()='My Account']");// My Account Xpath
	By register = By.xpath("//a[normalize-space()='Register']"); // Register Xpath
	By login = By.xpath("(//a[normalize-space()='Login'])[1]"); // Login Page Xpath

//Actions

	public void myaccountdropdown() {
		driver.findElement(myaccount).click();
	}

	public void register() {
		driver.findElement(register).click();
	}

	public void login(){
		driver.findElement(login).click();
	}
	
	
}
