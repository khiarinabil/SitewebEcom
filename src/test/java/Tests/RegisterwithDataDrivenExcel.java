package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExelReader;
import Pages.Loginoage;
import Pages.homebage;
import Pages.registerpage;

public class RegisterwithDataDrivenExcel extends testbase{
	Loginoage lgp;
	registerpage rgsp;
	homebage hmpg;
	
	@DataProvider(name="exceldata")
	public Object [][] userRegisterData() throws IOException{
		
		ExelReader exr = new ExelReader();
				
					return exr.getExcelData();
				
	}
	
	@Test(priority =1,alwaysRun= true, dataProvider = "exceldata")
	public void succesenregister(String fnn,String lnn,String eml,String psswr) {
		hmpg=new homebage(driver);
		hmpg.commencerenregistrement();
		rgsp=new registerpage(driver);
		rgsp.Userenregister(fnn, lnn, eml, psswr);
		Assert.assertTrue(rgsp.messgaerg.getText().contains("Your registration completed"));
		rgsp.Userlogin();
		lgp = new Loginoage(driver);
		lgp.AccessLogine(eml, psswr);
	   
		Assert.assertTrue(lgp.logaoutlink.getText().equals("Log out"));
		lgp.userlogaout();
	}

	}
