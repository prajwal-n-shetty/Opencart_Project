package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='narbar-menu']//a[text()='Components']")
	WebElement componentSection;

	@FindBy(xpath = "//div[@id='narbar-menu']//a[contains(text(), 'Monitor')]")
	WebElement monitors;

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement lnkLogout;

	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		myAccount.click();
		lnkLogout.click();

	}

}
