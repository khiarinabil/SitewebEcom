package Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;



import Utilities.helper;

public class testbase2 {
	
	
	String baseurl ="https://demo.nopcommerce.com/";
	protected ThreadLocal<RemoteWebDriver> driver=null;
	@BeforeClass
	@org.testng.annotations.Parameters(value= {"browser"})
	public void setUp(@Optional("chrome") String browser) throws MalformedURLException 
	{
		driver = new ThreadLocal<>(); 
		DesiredCapabilities caps = new DesiredCapabilities(); 
		caps.setCapability("browserName", browser);
		
		// SeleniuUm Grid Local
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
		
		// Run on SauceLabs on Cloud
		//driver.set(new RemoteWebDriver(new URL(sauceURL),caps));
		
		getDriver().navigate().to(baseurl);
	}

	public WebDriver getDriver() 
	{
		return driver.get(); 
	}

	@AfterClass
	public void stopDriver() 
	{
		getDriver().quit();
		driver.remove();
	}

	@AfterMethod
	public void screenchotenfailure(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("failure ");
			System.out.println("taking screenshots..... ");
			helper.captureScreenshot(getDriver(), result.getName());
		}
	}

}
