package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.ExcelUtility;

public class CheckoutPage extends BasePage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		//c
		//this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	//NOT USED
	@FindBy(xpath = "//div[@class='dropdown d-grid']")
	WebElement cartButton;

	//NOT USED
	@FindBy(xpath = "//p[@class='text-end']//a[2]")
	WebElement checkoutButton;

	@FindBy(xpath = "//input[@id='input-shipping-new']")
	WebElement newAddress;

	@FindBy(id = "input-shipping-firstname")
	WebElement txtfirstName;

	@FindBy(id = "input-shipping-lastname")
	WebElement txtlastName;

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

	@FindBy(id = "button-shipping-address")
	WebElement btncontinueBillingAddress;
	
	@FindBy(xpath="//textarea[@name='comment']")
	WebElement txtDeliveryMethod;

	@FindBy(id = "input-shipping-method")
	WebElement drpshippingMethod;

	@FindBy(id = "input-payment-method")
	WebElement drppaymentMethod;
	
	@FindBy(xpath = "//tr[3]//td//strong[text()='Total']//following::td")
	WebElement lbltotalPrice;

	@FindBy(xpath="//input[@id='button-confirm']")
	WebElement btnConfOrder;
	
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement lblorderPlaced;
	
	//@FindBy(xpath ="//button[contains(text(),'Confirm Order')]")
	//WebElement checkOutButton;

	
	//NOT USED
	@FindBy(xpath = "//div[contains(text(),'shipping')]")
	WebElement shippingAlertMessage;
	
	//NOT USED
	@FindBy(xpath = "//div[contains(text(),'payment')]")
	WebElement paymentAlertMessage;

;
	
	//SDET CODE Start here
	public void setfirstName(String firstName) {
		txtfirstName.sendKeys(firstName);
	}


	public void setlastName(String lastName) {
		txtlastName.sendKeys(lastName);
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
	
	public void clickOnContinueAfterBillingAddress()
	{
		btncontinueBillingAddress.click();
	}
	
	
	public void flatRateMethod(String flatRateOption)
	{
		new Select(drpshippingMethod).selectByVisibleText(flatRateOption);
	}
	
	
	public void paymentMethod(String paymentOption)
	{
		new Select(drppaymentMethod).selectByVisibleText(paymentOption);
	}
	
	
	public void setDeliveryMethodComment(String deliverymsg)
	{
		txtDeliveryMethod.sendKeys(deliverymsg);
		
	}
	
	public String  getTotalPriceBeforeConfOrder()
	{
		return lbltotalPrice.getText(); //$207.00
		
	}
	
	public void clickOnConfirmOrder() {
		btnConfOrder.click();
	}
	
	
	public boolean isShippingChanged() throws InterruptedException
	{
		try
		{
		waitForWebElementToAppear(shippingAlertMessage);
		String shipMessage = shippingAlertMessage.getText();
	
		if(shipMessage.equals("Success: You have changed shipping method!"))
			return true;
		else
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	//my old code
	public String confirmYourOrder()
	{
		String confirmationMessageString = lblorderPlaced.getText();
		return confirmationMessageString;
	}
	
	public boolean isOrderPlaced() throws InterruptedException
	{
		try
		{
		//btnConfOrder.click();
		//Thread.sleep(3000);
		if(lblorderPlaced.getText().equals("Your order has been placed!"))
			return true;
		else
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//My CODE Starte here
/*
	
	public void productCheckout() throws InterruptedException 
	{
		cartButton.click();
		waitForWebElementToAppear(checkoutButton);
		//Thread.sleep(1000);
		checkoutButton.click();
		waitForWebElementToAppear(newAddress);
		//Thread.sleep(5000);
		newAddress.click();
		//Thread.sleep(1000);
	}

	public OrderConfirmationPage feedNewAddress(String testCaseName) throws IOException, InterruptedException 
	{
		
		ArrayList dataExcel = getExcelData(testCaseName);

		String firstNameValue = (String) dataExcel.get(1);
		firstName.sendKeys(firstNameValue);

		String lastNameValue = (String) dataExcel.get(2);
		lastName.sendKeys(lastNameValue);

		String address1Value = (String) dataExcel.get(3);
		shippingAddress.sendKeys(address1Value);

		String cityValue = (String) dataExcel.get(4);
		shippingCity.sendKeys(cityValue);

		String countryValue = (String) dataExcel.get(5);
		Select countryDropdown = new Select(country);
		countryDropdown.selectByVisibleText(countryValue);
	

		String stateValue = (String) dataExcel.get(6);
		Select stateDropdown = new Select(state);
		stateDropdown.selectByVisibleText(stateValue);
		

		String shipMethodValue = (String) dataExcel.get(7);
		Select shipMethodDropdown = new Select(shippingMethod);
		shipMethodDropdown.selectByVisibleText(shipMethodValue);
		waitForWebElementToAppear(shippingAlertMessage);
		//Thread.sleep(3000);

		String shipMessage = shippingAlertMessage.getText();
		Assert.assertEquals(shipMessage,"Success: You have changed shipping method!");
		waitForWebElementToAppear(paymentMethod);
		//Thread.sleep(5000);
		
		String paymentMethodValue = (String) dataExcel.get(8);
		Select paymentMethodDropdown = new Select(paymentMethod);
		paymentMethodDropdown.selectByVisibleText(paymentMethodValue);
		waitForWebElementToAppear(paymentAlertMessage);
		//Thread.sleep(3000);
		
		String paymentMessage = paymentAlertMessage.getText();
		Assert.assertEquals(paymentMessage,"Success: You have changed payment method!");
		Thread.sleep(5000);
		

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
		//waitForElementToAppear(By.id("button-confirm"));

//		Thread.sleep(2000);
//		Boolean bool = checkOutButton.isEnabled();
//		System.out.println(bool);
//		
		
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
//		By by = By.xpath("//button[contains(text(),'Confirm Order'");
//		WebElement element = w.until(ExpectedConditions.elementToBeClickable(by));
//		element.click();
////		
		
		//waitForWebElementToGetEnabled(By.id("button-confirm"));

		//driver.findElement(By.id("button-confirm")).click();
		//checkOutButton.click();

		//Thread.sleep(3000);

		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement flag = driver.findElement(By.xpath("//button[contains(text(),'Confirm Order')]"));
		js.executeScript("arguments[0].scrollIntoView();",flag);
		
		waitForWebElementToAppear(checkOutButton);
		//Thread.sleep(5000);
		
		
		String firstNamePresent = firstName.getAttribute("value");
		String lastNamePresent = lastName.getAttribute("value");
		
		if(firstNamePresent.isEmpty() || lastNamePresent.isEmpty())
		{
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(firstName.getText(), "First Name must be between 1 and 32 characters!");
			softAssert.assertEquals(lastName.getText(), "Last Name must be between 1 and 32 characters!");
			softAssert.assertAll();
		}
		else 
		{
			checkOutButton.click();
		}
		
		
		Thread.sleep(5000);

		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		return orderConfirmationPage;
	}
*/
