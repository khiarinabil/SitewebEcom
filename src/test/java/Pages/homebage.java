package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class homebage extends pagebase {
	

	public homebage(WebDriver driver) {
		super(driver);
		js= (JavascriptExecutor) driver;
		act=new Actions(driver);

	}
	@FindBy(linkText = "Register")
	WebElement rgstrlnk;
	@FindBy(linkText="Contact us")
	WebElement contactUsLink ; 
	@FindBy(id ="customerCurrency")
	WebElement curyncydropdown ; 
	@FindBy(linkText="Computers")
	WebElement ComputerMenu; 
	
	@FindBy(linkText="Notebooks")
	WebElement NotbooksMenu; 
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement adwishlistlink;
	@FindBy(linkText = "wishlist")
	public WebElement msgwishlist;
	@FindBy(css = "wishlist-label")
	public WebElement panier;
	public  void commencerenregistrement() {

		rgstrlnk.click();
	}
public void opencontactuspage() {
	scrolletobaton();
	contactUsLink.click();
}
public void curuncychange() {
	Select bourse= new Select(curyncydropdown);
	bourse.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
}
public void selectNotebooksMenu() 
{
	act
	.moveToElement(ComputerMenu).build().perform();
	act.moveToElement(NotbooksMenu)
	.click()
	.build()
	.perform();
}
public void addproduct() {
	adwishlistlink.click();
}
}