package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public Logger logger;
	public Properties p;

// This is a reuseable method - called in different class whenever needed	

	public WebDriver driver;

	@BeforeClass
	public void startbrowser() throws IOException {

		// loading config.properties files
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass()); // log4j2 method

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}

// This method is used to generate the 5 alphabets and passed the stringrandom
// to the input of accregpage.email(randomStringemail() + "@gmail.com"); in the TC001 
// This is a reuseable method - called in different class whenever needed

	public String randomStringemail() {

		String randomemail = RandomStringUtils.randomAlphabetic(5);
		// System.out.println(randomemail +"@gmail.com");
		return randomemail;

	}

// This is a reuseable method - called in different class whenever needed

	@AfterClass
	public void teardown() throws InterruptedException {
		if (driver != null)

			driver.quit();
	}

}
