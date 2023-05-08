package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetaillePage extends pagebase {

	public ProductDetaillePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement item;
	@FindBy(id = "add-to-cart-button-4")
	public WebElement item2;
	@FindBy(css=".button-2.email-a-friend-button")
	WebElement emailFriendBtn ; 
	@FindBy(linkText = "Add your review")
	WebElement addrvlink;
	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn ; 

public void ouvresendmsg() {
	emailFriendBtn.click();
}
public void adrviwcl() {
	addrvlink.click();
}
  public void ajoutercomparer() {
	  addToCompareBtn.click();
  }
}
