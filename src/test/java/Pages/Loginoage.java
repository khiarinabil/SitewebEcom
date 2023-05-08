package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginoage  extends pagebase{

	public Loginoage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id ="Email")
	WebElement lgmail;
	@FindBy(id ="Password")
	WebElement lgpasword;
	@FindBy(css=".button-1.login-button")
	WebElement logbttn;
	@FindBy(linkText = "Log out")
	public WebElement logaoutlink;
	@FindBy(linkText = "My account")
	WebElement clickmyaccount;

	public void AccessLogine(String mail , String paswordd) {
		clickmyaccount.click();
		lgmail.sendKeys(mail);
		lgpasword.sendKeys(paswordd);
		logbttn.click();
		
	}
	public void userlogaout() {
		logaoutlink.click();
	}
}
