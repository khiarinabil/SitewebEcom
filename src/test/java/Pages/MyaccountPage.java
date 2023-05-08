package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends pagebase{

	public MyaccountPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(linkText ="Change password")
	WebElement changepswlink;
	@FindBy(id = "OldPassword")
	WebElement ancienpsw;
	@FindBy(id = "NewPassword")
	WebElement nvpsw;
	@FindBy(id = "ConfirmNewPassword")
	WebElement cnnvpsw;
	@FindBy(css = ".button-1.change-password-button")
	WebElement btnchangepsw;
	@FindBy(css = ".close")
	 public WebElement msgsucces;
	
	public void ChangeMotdePasse(String ancps ,String nvps) {
		changepswlink.click();
		ancienpsw.sendKeys(ancps);
		nvpsw.sendKeys(nvps);
		cnnvpsw.sendKeys(nvps);
		btnchangepsw.click();
	
	
	}
	

}
