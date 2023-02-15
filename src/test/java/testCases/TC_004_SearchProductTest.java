package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchProductCatalogue;
import testBase.TestBase;

@Test
public class TC_004_SearchProductTest extends TestBase {

	public void test_pruductSearch() throws InterruptedException {
		logger.info(" Starting TC_004_SearchProductTest ");

		try {
			
			HomePage hm=new HomePage(driver);
			
			hm.enterProductName("mac");
			logger.info("Entered Product name");
			
			hm.clickSearch();
			
			SearchProductCatalogue sp=new SearchProductCatalogue(driver);
			sp.isProductPresent("MacBook");
			
			Assert.assertEquals(sp.isProductPresent("MacBook"),true);
			logger.info("Product existance verified");

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}
