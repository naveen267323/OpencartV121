package testCases;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import utilities.TestListener;




public class TC001_AccountRegistrationTest extends BaseClass {
	

	@Test
	public void Home_AccountRegistration() throws InterruptedException {

		
		// Logging in Extent Report
        TestListener.getTest().log(Status.INFO, "Login started");
		
		logger.info("***********Started the TC001_AccountRegistrationTest*************");
		HomePage hmpage = new HomePage(driver);

		logger.info("***********clicked on myaccountdropdown*************");
		hmpage.myaccountdropdown();

		logger.info("***********clicked on register*************");
		hmpage.register();
		
	//	logger.info("***********clicked on register*************");
	//	hmpage.register();
		
		

		AccountRegistrationPage accregpage = new AccountRegistrationPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		accregpage.firstname(p.getProperty("firstname")); // reading the firstname from the properties files

		accregpage.lastname(p.getProperty("lastname"));
		accregpage.email(randomStringemail() + "@gmail.com");

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		accregpage.telephone(p.getProperty("telephone"));
		accregpage.password(p.getProperty("password"));
		accregpage.confirmpassword(p.getProperty("confirmpassword"));
		accregpage.privacypolicycheckbox();
		accregpage.continuebutton();
		String msgconfreg = accregpage.msgconfirmation();

		Assert.assertEquals(msgconfreg, "Your Account Has Been Created!");
		System.out.println(msgconfreg);

		logger.info("***********Started the TC001_AccountRegistrationTest*************");
	}

	
	
}
