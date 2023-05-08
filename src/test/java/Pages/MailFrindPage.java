package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailFrindPage  extends pagebase{

	public MailFrindPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "FriendEmail")
    private WebElement emailFriendTxt;
	@FindBy(id = "YourEmailAddress")
WebElement yourmailtxt;
    @FindBy(id = "PersonalMessage")
    private WebElement personalMessageTxt;

    @FindBy(name = "send-email")
    private WebElement sendEmailBtn;
    
    @FindBy(css = "div.result")
    public WebElement messageNotification;
    
    public void sendmailfrinds(String mfr,String msg) {
    	emailFriendTxt.sendKeys(mfr);
    	
    	personalMessageTxt.sendKeys(msg);
    	sendEmailBtn.click();
    }

}
