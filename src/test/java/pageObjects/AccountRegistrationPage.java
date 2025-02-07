package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountRegistrationPage extends BasePage {

//constructors

//	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

//Locators

	By firstname = By.xpath("//input[@id='input-firstname']");
	By lastname = By.xpath("//input[@id='input-lastname']");
	By email = By.xpath("//input[@id='input-email']");
	By telephone = By.xpath("//input[@id='input-telephone']");
	By password = By.xpath("//input[@id='input-password']");
	By confirmpassword = By.xpath("//input[@id='input-confirm']");
	By privacypolicycheckbox = By.xpath("//input[@name='agree']");
	By continuebutton = By.xpath("//input[@value='Continue']");
	By	messageconfirmation = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
	
		
//		Your Account Has Been Created!
	
//Actions

	public void firstname(String fname) {
		driver.findElement(firstname).sendKeys(fname);
	}

	public void lastname(String lname) {
		driver.findElement(lastname).sendKeys(lname);
	}

	public void email(String emailid) {
		driver.findElement(email).sendKeys(emailid);
	}

	public void telephone(String tel) {
		driver.findElement(telephone).sendKeys(tel);
	}

	public void password(String passwrd) {
		driver.findElement(password).sendKeys(passwrd);
	}

	public void confirmpassword(String confirmpass) {
		driver.findElement(confirmpassword).sendKeys(confirmpass);
	}

	public void privacypolicycheckbox() {
		driver.findElement(privacypolicycheckbox).click();
	}

	public void continuebutton() {
		driver.findElement(continuebutton).click();
	}

	public String msgconfirmation() {
		return driver.findElement(messageconfirmation).getText();

	
	}
	
	
}
