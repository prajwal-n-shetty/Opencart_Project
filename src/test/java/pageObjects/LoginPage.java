package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	WebDriver driver;

	@FindBy(css = "#input-email")
	WebElement userEmail;

	@FindBy(css = "#input-password")
	WebElement userPassword;

	@FindBy(css = "button[type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;

	public void setEmail(String email) {
		userEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		userPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
