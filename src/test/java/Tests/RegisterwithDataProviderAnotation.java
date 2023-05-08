package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Loginoage;
import Pages.homebage;
import Pages.registerpage;

public class RegisterwithDataProviderAnotation   extends testbase{
	
	
	Loginoage lgp;
	registerpage rgsp;
	homebage hmpg;
	
	@DataProvider(name="testdata")
public static Object [][] UserData(){
		return new Object [][]
			
		{
			
			{"khiari","nabil","khaaAbivlg1V4454@gmail.com","12345678"},
			{"nabli","boubou","laAAvampB54g@gmail.com","1234567"},
			{"club","africain","caa@gmail.com","1234567"}
			
		};
	}
	@Test(priority =1,alwaysRun= true,dataProvider = "testdata")
	public void succesenregister(String fnm,String lnm, String emm, String psw) {
		hmpg=new homebage(driver);
		hmpg.commencerenregistrement();
		rgsp=new registerpage(driver);
		rgsp.Userenregister(fnm , lnm , emm, psw);
		Assert.assertTrue(rgsp.messgaerg.getText().contains("Your registration completed"));
		rgsp.Userlogin();
		lgp = new Loginoage(driver);
		lgp.AccessLogine(emm,psw);
		
		Assert.assertTrue(lgp.logaoutlink.getText().equals("Log out"));
		lgp.userlogaout();
	}

	
}
