package Tests;



import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Pages.Loginoage;
import Pages.homebage;
import Pages.registerpage;



public class RegisterwithaDataDriverCsv extends testbase
{
	homebage  homeObject;
	registerpage registerObject;
    Loginoage loginObject;
	CSVReader reader ; 

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() throws IOException, CsvValidationException 
	{
		// get path of CSV file 
		String CSV_file = System.getProperty("user.dir")+"/src/test/java/data/Classeur2.CSV";
		reader = new CSVReader(new FileReader(CSV_file)); 

		String[] csvCell ; 

	
		while((csvCell = reader.readNext()) != null)
		{
			String firstname = csvCell[0]; 
			String lastName = csvCell[1]; 
			String email = csvCell[2]; 
			String password = csvCell[3]; 

			homeObject = new homebage(driver); 
			homeObject.commencerenregistrement();
			registerObject = new registerpage(driver); 
			registerObject.Userenregister(firstname,lastName, email, password);
			Assert.assertTrue(registerObject.messgaerg.getText().contains("Your registration completed"));
			loginObject.userlogaout();
			registerObject.Userlogin();
			loginObject = new Loginoage(driver); 
			loginObject.AccessLogine(email, password);
			Assert.assertTrue(registerObject.messgaerg.getText().contains("Your registration completed"));
			loginObject.userlogaout();
		}
	}
}
