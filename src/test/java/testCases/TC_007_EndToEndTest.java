package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.AccountRegistrationPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchProductCatalogue;
import pageObjects.ShoppingCartPage;
import testBase.TestBase;
import utilities.DataProviders;

public class TC_007_EndToEndTest extends TestBase {

	@Test(dataProvider = "UserData", dataProviderClass = DataProviders.class)
	public void endToendTest(String firstName, String secondName, String email, String password, String address1,
			String address2, String city, String country, String productToSearch, String quantity, String expectedPrice)
			throws InterruptedException {

		logger.info(" Starting TC_006_CheckoutTest ");
		
		// Soft assertions
		SoftAssert myassert = new SoftAssert();

		// *******************Home Page*******************
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info(" Clicked on Register from Dropdown ");

		// *******************Account Registration*******************
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName(firstName);
		regpage.setLastName(secondName);
		regpage.setEmail(email);
		regpage.setPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info(" Entered Registration details ");
		Thread.sleep(3000);

		String confmsg = regpage.getConfirmationMsg();
		System.out.println(confmsg);
		myassert.assertEquals(confmsg, "Your Account Has Been Created!");

		// *******************MyAccountPage*******************
		MyAccountPage myacc = new MyAccountPage(driver);
		myacc.clickLogout();
		Thread.sleep(3000);

		hp.clickMyAccount();
		hp.clickLogin();

		// *******************Login Page*******************
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		System.out.println("Going to My Account Page? " + myacc.isMyAccountPageExists());
		myassert.assertEquals(myacc.isMyAccountPageExists(), true); // validation

		hp.enterProductName(productToSearch);
		hp.clickSearch();

		// *******************Search Page*******************
		SearchProductCatalogue searchpage = new SearchProductCatalogue(driver);
		if (searchpage.isProductPresent(productToSearch)) {
			searchpage.selectProduct(productToSearch);
			searchpage.changeQuantity(quantity);
			searchpage.addToCart();
		}

		Thread.sleep(3000);
		System.out.println("Added product to cart ? " + searchpage.checkConfirmationMessage());
		myassert.assertEquals(searchpage.checkConfirmationMessage(),
				"Success: You have added " + productToSearch + " to your shopping cart!");

		//*******************Shopping cart/*******************
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		sc.itemsListinCart();
		sc.clickViewCart();
		Thread.sleep(3000);

		String totalprice = sc.getTotalPrice();
		System.out.println("total price is shopping cart: " + totalprice);
		myassert.assertEquals(totalprice, expectedPrice); // validation
		Thread.sleep(2000);
		sc.clickOnCheckout();

		myassert.assertAll(); // conclusion
	}
}
