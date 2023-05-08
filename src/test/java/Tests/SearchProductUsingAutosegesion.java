package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetaillePage;
import Pages.SearchPage;

public class SearchProductUsingAutosegesion  extends testbase{
	String productname="Apple MacBook Pro 13-inch";
	SearchPage srcpg;
	ProductDetaillePage pdp;
	String itemname="mac";
	@Test
	public void searchviaitem() {
		
		srcpg=new SearchPage(driver);
		pdp=new ProductDetaillePage(driver);
		srcpg.itemrecherche(itemname);
		Assert.assertTrue(pdp.item2.isDisplayed());
	}

}
