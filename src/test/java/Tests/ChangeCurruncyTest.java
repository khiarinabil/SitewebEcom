package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetaillePage;
import Pages.SearchPage;
import Pages.homebage;

public class ChangeCurruncyTest  extends testbase{
	homebage hmp;
	SearchPage srcp;
	ProductDetaillePage pdp;
	String productname="Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void changetesteuros() {
		hmp=new homebage(driver);
		hmp.curuncychange();
		srcp=new SearchPage(driver);
		
	}
	@Test(priority = 2)
	public void rechercheprodui() {
		srcp= new SearchPage(driver);
		srcp.rechercherproduct(productname);
		pdp=new ProductDetaillePage(driver);
		Assert.assertTrue(pdp.item.isDisplayed());
		Assert.assertTrue(srcp.flouss.getText().contains("€"));
	}

}
