package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Loginoage;
import Pages.MailFrindPage;
import Pages.MyaccountPage;
import Pages.ProductDetaillePage;
import Pages.SearchPage;
import Pages.homebage;
import Pages.registerpage;

public class MailfriendTest  extends testbase{
	MailFrindPage mfp;
	registerpage rgsp;
	MyaccountPage myacp;
	Loginoage lgp;
	homebage hmpg;
	ProductDetaillePage pdp;
	String ancienmotdepasse="123456";
	String nouveaumotdepasse="12345678";
	String prenon="nabil";
	String nom="khiari";
	String maill="khzzrinhoboo@gmail.com";
	String mailf="bolbol@gmail.com";
	String msgamigo="merci de voir cette article";
	SearchPage srcpg;
	String productname="Apple MacBook Pro 13-inch";
	SearchProductUsingAutosegesion spat;
	
	@Test(priority =1,alwaysRun= true)
	public void succesenregister() {
		hmpg=new homebage(driver);
		hmpg.commencerenregistrement();
		rgsp=new registerpage(driver);
		rgsp.Userenregister(prenon ,nom, maill, ancienmotdepasse);
		Assert.assertTrue(rgsp.messgaerg.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = {"succesenregister"})
	public void loginenter() {
		
		rgsp.Userlogin();
		lgp = new Loginoage(driver);
		lgp.AccessLogine(maill, ancienmotdepasse);
		Assert.assertTrue(lgp.logaoutlink.getText().equals("Log out"));
}
	
	@Test(dependsOnMethods = {"loginenter"})
	public void searchviaitem() {
		
		srcpg=new SearchPage(driver);
		pdp=new ProductDetaillePage(driver);
		srcpg.itemrecherche(productname);
		Assert.assertTrue(pdp.item2.isDisplayed());
	}
	
	
	@Test(dependsOnMethods = {"searchviaitem"})
	public void sendmailamigo() {
		pdp=new ProductDetaillePage(driver);
		pdp.ouvresendmsg();
		mfp=new MailFrindPage(driver);
		mfp.sendmailfrinds(mailf, msgamigo);
		Assert.assertTrue(mfp.messageNotification.isDisplayed());
	}
	@Test(dependsOnMethods = {"sendmailamigo"} )
	public void usercanlogaout() {
		lgp=new Loginoage(driver);
		lgp.userlogaout();
		rgsp=new registerpage(driver);
		Assert.assertTrue(rgsp.loginlnk.isDisplayed());
	}

}
