package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import Data.LoadProperties;

import Pages.Loginoage;
import Pages.homebage;
import Pages.registerpage;

public class RegistrationwithDdtProperties extends testbase{
	Loginoage lgp;
	registerpage rgsp;
	homebage hmpg;
	String fn =LoadProperties.userData.getProperty("firstname");
	String ln =LoadProperties.userData.getProperty("lastname");
	String em =LoadProperties.userData.getProperty("mail");
	String pw =LoadProperties.userData.getProperty("password");
	
	
	@Test(priority =1,alwaysRun= true)
	public void succesenregister() {
		hmpg=new homebage(driver);
		hmpg.commencerenregistrement();
		rgsp=new registerpage(driver);
		rgsp.Userenregister(fn, ln, em, pw);
		Assert.assertTrue(rgsp.messgaerg.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = {"succesenregister"})
	public void loginenter() {
		
		rgsp.Userlogin();
		lgp = new Loginoage(driver);
		lgp.AccessLogine(em, pw);
		Assert.assertTrue(lgp.logaoutlink.getText().equals("Log out"));
}}
