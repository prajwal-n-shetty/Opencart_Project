package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
		//C
		// initialization
		//this.driver = driver;
		//PageFactory.initElements(driver, this);

	}

	WebDriver driver;
	
	@FindBy(css ="#input-email")
	WebElement userEmail;

	@FindBy(css ="#input-password")
	WebElement userPassword;
	
	@FindBy(css="button[type='submit']")
	WebElement	loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;

	
	//SDET IMPLEMENTED
	public void setEmail(String email) {
		userEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		userPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		loginButton.click();
	}

	//C
	/*public MyAccountPage loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		return myAccountPage;
	}*/
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
