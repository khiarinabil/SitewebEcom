package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactPage;
import Pages.homebage;

public class ContactUsTest  extends testbase{

	homebage mopg;
	ContactPage cnctpg;
	String fn="nabil";
	String ml="mlu@gmail.com";
	String qr="claire";
	@Test
	public void contactusregister() {
		mopg=new homebage(driver);
		mopg.opencontactuspage();
		cnctpg=new ContactPage(driver);
		cnctpg.cntctusenter(fn, ml, qr);
		Assert.assertTrue(cnctpg.successMessage.isDisplayed());
	}
}
