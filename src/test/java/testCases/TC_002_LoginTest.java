package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBase;

public class TC_002_LoginTest extends TestBase {

	@Test(groups= {"Sanity","Master"})
	public void test_login()
	{
		try
		{
		logger.info("**** Starting TC_OO2_LoginTest *****");
	
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		
		hp.clickLogin();
		logger.info("Clicked on Login Link");
		
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing login details");
		
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		logger.info("clicked on Login button");
		
		MyAccountPage myAcc=new MyAccountPage(driver);
		boolean targetpage=myAcc.isMyAccountPageExists();
		Assert.assertEquals(targetpage,true,"Invalid login data");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest *****");
		
	}
}
