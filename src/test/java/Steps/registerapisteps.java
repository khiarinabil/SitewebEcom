package Steps;

import org.testng.Assert;

import Pages.Loginoage;
import Pages.homebage;
import Pages.registerpage;
import Tests.testbase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class registerapisteps  extends testbase{
	homebage homeobject;
	registerpage regiterobject;
	Loginoage loginobject;
	
	@Given("^the user in the home page$")
	public void the_user_in_the_home_page() throws Throwable {
		homeobject = new homebage(driver); 
		homeobject.commencerenregistrement();
	}
	@When("^I click on register link$")
	public void i_click_on_register_link()  {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("^I entered \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, String email, String password) {
		regiterobject = new registerpage(driver);
		regiterobject.Userenregister(firstname,lastname, email, password);
		
		loginobject= new Loginoage(driver);
		loginobject.AccessLogine(email, password);
		
		
	}
	
	@Then("^The registration page displayed successfully$")
	public void the_registration_page_displayed_successfully() {
		
		loginobject = new Loginoage(driver);
		loginobject.logaoutlink.click();
	}

}
