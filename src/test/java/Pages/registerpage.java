package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class registerpage  extends pagebase {

	public registerpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FirstName")
	WebElement nom;
	@FindBy(id = "LastName")
	WebElement prenom;
	@FindBy(id = "Email")
	WebElement mail;
	@FindBy(id = "Password")
	WebElement motpasse;
	@FindBy(id = "ConfirmPassword")
	WebElement confimdp;
	@FindBy(id = "register-button")
	WebElement btnrgstr;
	@FindBy(css =  "div.result")
	public WebElement messgaerg;
	@FindBy(linkText = "Log in")
	public	WebElement loginlnk;

	public void  Userenregister(String fn , String ln, String ml,String mp) 
	{
		nom.sendKeys(fn);
		prenom.sendKeys(ln);
		mail.sendKeys(ml);
		motpasse.sendKeys(mp);
		confimdp.sendKeys(mp);
		btnrgstr.click();

	}

	public void Userlogin() {
		loginlnk.click();
	}

}
