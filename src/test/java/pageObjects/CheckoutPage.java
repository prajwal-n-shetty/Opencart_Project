package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-guest")
	WebElement radioGuest;

	@FindBy(id = "input-firstname")
	WebElement txtfirstName;

	@FindBy(id = "input-lastname")
	WebElement txtlastName;

	@FindBy(id = "input-email")
	WebElement txtemail;

	@FindBy(id = "input-shipping-company")
	WebElement txtCompany;

	@FindBy(id = "input-shipping-address-1")
	WebElement txtshippingAddress;

	@FindBy(id = "input-shipping-city")
	WebElement txtshippingCity;

	@FindBy(id = "input-shipping-postcode")
	WebElement txtpincode;

	@FindBy(id = "input-shipping-country")
	WebElement drpCountry;

	@FindBy(id = "input-shipping-zone")
	WebElement drpState;

	@FindBy(id = "input-newsletter")
	WebElement checkboxWish;

	@FindBy(id = "button-register")
	WebElement btnContinue;

	public void setGuestOption() {
		radioGuest.click();
	}

	public void setfirstName(String firstName) {
		txtfirstName.sendKeys(firstName);
	}

	public void setlastName(String lastName) {
		txtlastName.sendKeys(lastName);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setCompany(String company) {
		txtCompany.sendKeys(company);
	}

	public void setaddress1(String address1) {
		txtshippingAddress.sendKeys(address1);
	}

	public void setcity(String city) {
		txtshippingCity.sendKeys(city);
	}

	public void setpin(String pin) {
		txtpincode.sendKeys(pin);
	}

	public void setCountry(String Country) {
		new Select(drpCountry).selectByVisibleText(Country);
	}

	public void setState(String State) {
		new Select(drpState).selectByVisibleText(State);
	}

	public void clickOnContinueAfterBillingAddress() {
		btnContinue.click();
	}

}