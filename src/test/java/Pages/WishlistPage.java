package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends pagebase {

	public WishlistPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "updatecart")
	 public WebElement updtbtn;
	@FindBy(name = "updatecart")
     WebElement removefromCartCheck;
	
	@FindBy(css = "div.no-data")
    public WebElement EmptyCartLbl;
	
	
	public void viderpanier() {
		removefromCartCheck.click();
		
		
	}

}
