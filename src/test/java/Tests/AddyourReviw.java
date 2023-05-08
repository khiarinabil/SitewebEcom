package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddreviwPage;
import Pages.Loginoage;
import Pages.ProductDetaillePage;
import Pages.SearchPage;
import Pages.homebage;
import Pages.registerpage;

public class AddyourReviw  extends testbase{
	
	registerpage rgsp;
	Loginoage lgp;
	AddreviwPage adrv;
	SearchPage srcp;
	homebage hmpg;
	ProductDetaillePage pdp;
	AddreviwPage arp;
	String ancienmotdepasse="123456";
	String nouveaumotdepasse="12345678";
	String prenon="nabil";
	String nom="khiari";
	String maill="khazzriiwahbiii@gmail.com";
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
	public void adreviwtest() {
		pdp=new ProductDetaillePage(driver);
		pdp.adrviwcl();
		arp=new AddreviwPage(driver);
		arp.remplirreviw("saha", "brow");
		Assert.assertTrue(arp.reviewNotification.isDisplayed());
		
		
	}

}
