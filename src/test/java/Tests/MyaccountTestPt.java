package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Loginoage;
import Pages.MyaccountPage;
import Pages.homebage;
import Pages.registerpage;

public class MyaccountTestPt extends testbase2{
	
	registerpage rgsp;
	MyaccountPage myacp;
	Loginoage lgp;
	homebage hmpg;
	String ancienmotdepasse="123456";
	String nouveaumotdepasse="12345678";
	String prenon="nabil";
	String nom="khiari";
	String mail="khanBBBaX@gmail.com";
	
	@Test(priority =1,alwaysRun= true)
	public void succesenregister() {
		hmpg=new homebage(getDriver());
		hmpg.commencerenregistrement();
		rgsp=new registerpage(getDriver());
		rgsp.Userenregister(prenon ,nom, mail, ancienmotdepasse);
		Assert.assertTrue(rgsp.messgaerg.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = {"succesenregister"})
	public void loginenter() {
		
		rgsp.Userlogin();
		lgp = new Loginoage(getDriver());
		lgp.AccessLogine(mail, ancienmotdepasse);
		Assert.assertTrue(lgp.logaoutlink.getText().equals("Log out"));
}
	@Test(dependsOnMethods = {"loginenter"} )
	public void changpsw() {
		myacp=new MyaccountPage(getDriver());
		myacp.ChangeMotdePasse(ancienmotdepasse, nouveaumotdepasse);
		Assert.assertTrue(myacp.msgsucces.isDisplayed());
	}
	
	
	}

