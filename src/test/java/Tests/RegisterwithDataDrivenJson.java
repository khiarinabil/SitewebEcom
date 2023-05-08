package Tests;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Data.JsonDataReader;
import Pages.Loginoage;
import Pages.homebage;
import Pages.registerpage;





public class RegisterwithDataDrivenJson extends testbase
{
	
	homebage homeObject ; 
	registerpage registerObject ; 
	Loginoage loginObject ; 

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() throws FileNotFoundException, IOException, ParseException 
	{
		JsonDataReader jdr = new JsonDataReader();
		jdr.JsonReader();
		
		homeObject = new homebage(driver); 
		homeObject.commencerenregistrement();
		registerObject = new registerpage(driver); 
		registerObject.Userenregister(jdr.firstname, jdr.lastname, jdr.email, jdr.password);
		Assert.assertTrue(registerObject.messgaerg.getText().contains("Your registration completed"));
		registerObject.Userlogin();
		
		loginObject = new Loginoage(driver); 
		
		loginObject.AccessLogine(jdr.email,jdr.password);
		Assert.assertTrue(loginObject.logaoutlink.getText().equals("Log out"));
		loginObject.userlogaout();
	}
}
