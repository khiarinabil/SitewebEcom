package Tests;

import java.time.Duration;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.helper;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;



public class testbase extends AbstractTestNGCucumberTests {
	
	public static WebDriver driver;
	
	@Parameters({"browser"})

	@BeforeSuite
	
	public void startDriver(@Optional("chrome")  String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("WebDriver.Firefox.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		
		}
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com");


	}
	@AfterSuite
	public void stopdriver() {
		driver.quit();
	}


	
	
	
	@AfterMethod
	public void screenchotenfailure(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("failure ");
			System.out.println("taking screenshots..... ");
			helper.captureScreenshot(driver, result.getName());
		}
		
	}
}
