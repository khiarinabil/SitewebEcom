package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.homebage;

public class HoverMenuTest extends testbase {
	
homebage hpg;


@Test
public void UserCanSelectSubCategoryFromMainMenu() throws InterruptedException 
{
	hpg = new homebage(driver); 
	hpg.selectNotebooksMenu();
	Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
}
}