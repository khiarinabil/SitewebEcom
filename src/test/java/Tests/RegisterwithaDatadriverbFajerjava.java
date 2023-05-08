package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.Loginoage;
import Pages.homebage;
import Pages.registerpage;

public class RegisterwithaDatadriverbFajerjava extends testbase{
	Loginoage lgp;
	registerpage rgsp;
	homebage hmpg;
	
	Faker fkrdata= new Faker();
	String firstname =fkrdata.name().firstName();
	String lastname= fkrdata.name().lastName();
	String email= fkrdata.internet().emailAddress();
	String password=fkrdata.internet().password();
	@Test(priority =1,alwaysRun= true)
	public void succesenregister() {
		hmpg=new homebage(driver);
		hmpg.commencerenregistrement();
		rgsp=new registerpage(driver);
		rgsp.Userenregister(firstname, lastname, email, password);
		Assert.assertTrue(rgsp.messgaerg.getText().contains("Your registration completed"));
		lgp = new Loginoage(driver);
		lgp.AccessLogine(email,password);
		Assert.assertTrue(lgp.logaoutlink.getText().equals("Log out"));
		lgp.userlogaout();
	}

	}
