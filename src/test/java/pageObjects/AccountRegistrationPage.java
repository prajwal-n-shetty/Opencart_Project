package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Elements
		@FindBy(name = "firstname")
		WebElement txtFirstname;

		@FindBy(name = "lastname")
		WebElement txtLasttname;

		@FindBy(name = "email")
		WebElement txtEmail;

		@FindBy(name = "password")
		WebElement txtPassword;

		@FindBy(xpath = "//input[@name='agree']")
		WebElement chkdPolicy;

		@FindBy(xpath = "//button[@type='submit']")
		WebElement btnContinue;

		@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement msgConfirmation;
			

		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);

		}

		public void setLastName(String lname) {
			txtLasttname.sendKeys(lname);

		}

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}

		public void setPrivacyPolicy() throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement flag = driver.findElement(By.xpath("//input[@name='agree']"));
			js.executeScript("arguments[0].scrollIntoView();",flag);
			Thread.sleep(2000);
			
			chkdPolicy.click();

		}

		public void clickContinue() throws InterruptedException {
			btnContinue.click();
		}

		public String getConfirmationMsg() {
			
			try 
			{
				return (msgConfirmation.getText());
			} 
			catch (Exception e) 
			{
				return (e.getMessage());

			}

		}
		

		
}