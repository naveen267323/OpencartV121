package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;
import utilities.TestListener;

public class TC003_DDTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	// dataprovider name and dataproviders class details should be given

	public void verify_loginDDT(String email, String password) throws InterruptedException {

		logger.info("************Login started****************");

		// Logging in Extent Report
		TestListener.getTest().log(Status.INFO, "Login started for email: " + email);

//HomePage
		HomePage hmpage = new HomePage(driver);
		hmpage.myaccountdropdown();
		hmpage.login();

		/*
		 * LoginPage accepting the data from config.properties LoginPage lp = new
		 * LoginPage(driver); lp.giveemail(p.getProperty(emails));
		 * lp.givepassword(p.getProperty(password));
		 * 
		 * Actions action = new Actions(driver);
		 * action.sendKeys(Keys.ARROW_DOWN).build().perform();
		 * action.sendKeys(Keys.ARROW_DOWN).build().perform();
		 * 
		 * lp.hitloginbutton();
		 */

//LoginPage has to accept the data from excel
		LoginPage lp = new LoginPage(driver);
		lp.giveemail(email);
		lp.givepassword(password);

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).build().perform();

		lp.hitloginbutton();

//MyAccount Page		
		MyAccountPage map = new MyAccountPage(driver);
		try {
			String confirm_msg_myacc = map.myaccountpagemsg();
			Assert.assertEquals(confirm_msg_myacc.trim(), "My Account");
			System.out.println(confirm_msg_myacc);
			logger.info("Login successful: " + confirm_msg_myacc);
		} catch (Exception e) {
			Thread.sleep(2000);
			String errormsg = lp.invalidcred(); // Ensure this method captures the error message from UI
			Assert.assertTrue(errormsg.contains("No match"), "Expected error message not found.");

			logger.warn("❌ Login failed for user: " + email + ". Error: " + errormsg);
			TestListener.getTest().log(Status.FAIL, "Login failed for: " + email + ". Error: " + errormsg);
			return; // Stop execution here, no need to logout

		}

//		Actions action1 = new Actions(driver);
//		action1.sendKeys(Keys.PAGE_DOWN).build().perform();

		hmpage.myaccountdropdown();
		logger.info("********Logout successfully*******");
		map.logout_button();

		Thread.sleep(2000);

//		driver.close();

		// HomePage

		hmpage.myaccountdropdown();
		hmpage.login();

	}

}
