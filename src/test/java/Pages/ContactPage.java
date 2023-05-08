package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage  extends pagebase{

	public ContactPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "FullName")
	WebElement fullnametxt;
	@FindBy(id = "Email")
	WebElement emltxt;
	@FindBy(id = "Enquiry")
	WebElement eqrytxt;
	@FindBy(name =  "send-email")
	WebElement submbtn;
	@FindBy(css = "div.result")
    public WebElement successMessage;

public void cntctusenter( String nom, String email, String eqr) {
	fullnametxt.sendKeys(nom);
	emltxt.sendKeys(email);
	eqrytxt.sendKeys(eqr);
	submbtn.click();
}
}
