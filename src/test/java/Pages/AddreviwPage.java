package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddreviwPage extends pagebase {

	public AddreviwPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "AddProductReview_Title")
	public WebElement reviwtitle;
	@FindBy(id = "AddProductReview_ReviewText")
	public WebElement rvadtxt;
	@FindBy(name ="add-review")
	WebElement submitrv ; 
	@FindBy(css = "div.result")
	public  WebElement reviewNotification;
	
	public void remplirreviw(String title, String rmptxt) {
		reviwtitle.sendKeys(title);
		rvadtxt.sendKeys(rmptxt);
		submitrv.click();
		
	}
}
