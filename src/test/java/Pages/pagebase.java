package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pagebase {

	
    public  WebDriverManager driver;
	public JavascriptExecutor js;
	public Actions act;
	

	public pagebase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void scrolletobaton() {
		js.executeScript("scrollBy(0,2500)"); 
		
	}
}
