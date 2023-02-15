package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchProductCatalogue;
import pageObjects.ShoppingCartPage;
import testBase.TestBase;

public class TC_006_CheckoutTest extends TestBase{

	String productToSearch = "MacBook";
	String number = "3";
	String expectedPrice="$1,806.00";
	
	@Test
	public void CheckoutTest() throws InterruptedException
	{

		logger.info(" Starting TC_006_CheckoutTest ");
		HomePage hp=new HomePage(driver);
		hp.enterProductName(productToSearch);
		hp.clickSearch();
		logger.info(" Clicked on Search ");
	
		//*******************Search Page*******************
		SearchProductCatalogue searchpage = new SearchProductCatalogue(driver);
		if(searchpage.isProductPresent(productToSearch))
		{
				logger.info(" Product present Successful ");
				searchpage.selectProduct(productToSearch);
				searchpage.changeQuantity(number);
				searchpage.addToCart();
				logger.info(" Product added to cart ");
				Thread.sleep(5000);
		}
		Assert.assertEquals(searchpage.checkConfirmationMessage(),"Success: You have added "+ productToSearch +" to your shopping cart!");
		
		
		//*******************Shopping cart*******************
		ShoppingCartPage sc=new ShoppingCartPage(driver);
		sc.itemsListinCart();
		sc.clickViewCart();
		Thread.sleep(3000);
		String totalprice=sc.getTotalPrice();
		System.out.println("total price is shopping cart: "+totalprice);
		Assert.assertEquals(totalprice, expectedPrice);  
	
		sc.clickOnCheckout();
		logger.info(" Clicked on checkout ");
		
		//*******************Checkout cart *******************
		CheckoutPage cp = new CheckoutPage(driver);
		cp.setGuestOption();
		cp.setfirstName("Prajwal");
		cp.setlastName("N");
		cp.setEmail("abc@gmail.com");
		cp.setCompany("Praj");
		cp.setaddress1("Praj");
		cp.setcity("Bangalore");
		cp.setpin("560060");
		cp.setCountry("India");
		cp.setState("Karnataka");
		logger.info(" Entered billing details for Checkout ");
		
		logger.info(" Finished TC_006_CheckoutTest ");
	}
}
