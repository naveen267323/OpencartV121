package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.TestListener;

public class TC002_LoginPageTest extends BaseClass {

	@Test
	public void verify_login() throws InterruptedException {

		// Logging in Extent Report
//		TestListener.getTest().log(Status.INFO, "Login started");

		logger.info("************Login started****************");

//HomePage
		HomePage hmpage = new HomePage(driver);
		hmpage.myaccountdropdown();
		hmpage.login();

//LoginPage	
		LoginPage lp = new LoginPage(driver);

		lp.giveemail(p.getProperty("validemail"));
		lp.givepassword(p.getProperty("validpassword"));

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).build().perform();

		lp.hitloginbutton();
		
		Thread.sleep(2000);
		
		
		HomePage hmpage1 = new HomePage(driver);
		hmpage1.myaccountdropdown();
//MyAccount Page		
		MyAccountPage map = new MyAccountPage(driver);
		String confirm_msg_myacc = map.myaccountpagemsg();

		Assert.assertEquals(confirm_msg_myacc.trim(), "My Account");
		System.out.println(confirm_msg_myacc);

		logger.info("Login successful " + confirm_msg_myacc);

		
		logger.info("********Logout Started*******");
		map.logout_button();

		logger.info("********Logout successful*******");

		Thread.sleep(3000);

//invalid credentails

		logger.info("******** Testing Invalid Login *******");

// HomePage

		hmpage.myaccountdropdown();
		hmpage.login();

//invalid credentails login		

		LoginPage lp1 = new LoginPage(driver);
		lp1.giveemail(p.getProperty("invalidemail"));
		lp1.givepassword(p.getProperty("invalidpassword"));

		Actions action1 = new Actions(driver);
		action1.sendKeys(Keys.ARROW_DOWN).build().perform();
		action1.sendKeys(Keys.ARROW_DOWN).build().perform();

		lp1.hitloginbutton();

		String errormsg = lp1.invalidcred();

		System.out.println(errormsg);

		Assert.assertTrue(errormsg.contains("No match"), "Error message did not appear");

		logger.info("Invalid login test passed. Error Message: " + errormsg);

//HomePage

		hmpage.myaccountdropdown();
		hmpage.login();

	}

}
