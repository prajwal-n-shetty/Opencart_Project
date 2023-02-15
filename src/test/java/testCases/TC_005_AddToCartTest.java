package testCases;


import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchProductCatalogue;
import testBase.TestBase;

public class TC_005_AddToCartTest extends TestBase{

	String productToSearch = "MacBook";
	String number = "3";
	
	@Test
	public void addToCartTest () throws InterruptedException
	{
		logger.info(" Starting TC_005_AddToCartTest ");
		HomePage homepage = new HomePage(driver);
		homepage.enterProductName(productToSearch);
		homepage.clickSearch();
		logger.info(" Clicked on Search");
		Thread.sleep(4000);
		
		SearchProductCatalogue searchpage = new SearchProductCatalogue(driver);
		searchpage.selectProduct(productToSearch);
		searchpage.changeQuantity(number);
		searchpage.addToCart();
		
		logger.info(" Finished TC_005_AddToCartTest ");
	}
}
