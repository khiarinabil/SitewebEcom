package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends pagebase {

	public SearchPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(id = "small-searchterms")
	WebElement recherche;

	@FindBy(css =".button-1.search-box-button")
	WebElement BTNrecherche;
	@FindBy(id = "ui-id-1")
	List<WebElement> autoseggsion;
	@FindBy(css = ".price.actual-price")
	public WebElement flouss;
	public void rechercherproduct(String productname) {
		recherche.sendKeys(productname);
		BTNrecherche.click();
	}
	public void itemrecherche(String itemname) {
		recherche.sendKeys(itemname);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		autoseggsion.get(0).click();
	}
}
