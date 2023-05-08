package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetaillePage;
import Pages.SearchPage;

public class SearchTest extends testbase {
	String productname="Apple MacBook Pro 13-inch";
	SearchPage srcpg;
	ProductDetaillePage pdp;
	@Test
	public void rechercheprodui() {
		srcpg= new SearchPage(driver);
		srcpg.rechercherproduct(productname);
		pdp=new ProductDetaillePage(driver);
		Assert.assertTrue(pdp.item.isDisplayed());
	}
	

}
