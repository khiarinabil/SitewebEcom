package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetaillePage;
import Pages.SearchPage;
import Pages.WishlistPage;
import Pages.homebage;

public class AddproducttowishlistTest extends testbase{

	String productname="Apple MacBook Pro 13-inch";
	SearchPage srcpg;
	ProductDetaillePage pdp;
	homebage hmp;
	WishlistPage wlpg;
	String itemname="mac";
	@Test(priority = 1)
	public void searchviaitem() {
		
		srcpg=new SearchPage(driver);
		pdp=new ProductDetaillePage(driver);
		srcpg.itemrecherche(itemname);
		Assert.assertTrue(pdp.item2.isDisplayed());
	}
@Test(dependsOnMethods = {"searchviaitem"})
public void addwishlistttest() {
	hmp= new homebage(driver);
	hmp.addproduct();
	driver.get("https://demo.nopcommerce.com/wishlist");
	wlpg=new WishlistPage(driver);
	Assert.assertTrue(wlpg.updtbtn.isDisplayed());
	
}
	@Test(dependsOnMethods = {"addwishlistttest"})
	public void removeproduct() {
		wlpg=new WishlistPage(driver);
		wlpg.viderpanier();
		Assert.assertTrue(wlpg.EmptyCartLbl.getText().contains("The wishlist is empty"));
		
	}
}
