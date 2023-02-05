package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_001_AccountRegistrationTest extends TestBase {

		@Test(groups= {"Regression","Master"})
		public void test_account_Registration() throws InterruptedException
		{
			logger.debug("***** Application Logs Below *****");
			logger.info("***  Starting TC_001_AccountRegistrationTest ***");
			
			try
			{
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				logger.info("Clicked on My account link");
				
				hp.clickRegister();
				logger.info("Clicked on register link");
				
				AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
					
				logger.info("Providing customer data");
				regpage.setFirstName(randomeString().toUpperCase());
				regpage.setLastName(randomeString().toUpperCase());
				regpage.setEmail(randomeString()+"@gmail.com");
				String password=randomAlphaNumeric();
				regpage.setPassword(password);
	
				regpage.setPrivacyPolicy();
				logger.info("Clicked on privacy terms");
				
				regpage.clickContinue();
				logger.info("Clicked on continue");
				Thread.sleep(5000);
				
				String confmsg=regpage.getConfirmationMsg();
				
				logger.info("Validating expected message");
				Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed***");
			
			}
			
			catch(Exception e)
			{
				logger.error("test failed");
				Assert.fail();
			}
		
			logger.info("***  Finished TC_001_AccountRegistrationTest ***");		
		}
		
		
}

