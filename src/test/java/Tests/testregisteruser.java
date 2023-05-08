package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Loginoage;
import Pages.homebage;
import Pages.registerpage;

public class testregisteruser extends testbase{
	Loginoage lgp;
	registerpage rgsp;
	homebage hmpg;
	@Test(priority =1,alwaysRun= true)
	public void succesenregister() {
		hmpg=new homebage(driver);
		hmpg.commencerenregistrement();
		rgsp=new registerpage(driver);
		rgsp.Userenregister("khiari", "nabil", "Rcga@gmail.com", "123456");
		Assert.assertTrue(rgsp.messgaerg.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = {"succesenregister"})
	public void loginenter() {
		
		rgsp.Userlogin();
		lgp = new Loginoage(driver);
		lgp.AccessLogine("Rcga@gmail.com", "123456");
		Assert.assertTrue(lgp.logaoutlink.getText().equals("Log out"));
}}
