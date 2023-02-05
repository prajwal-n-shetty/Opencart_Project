package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MyAccountPage extends BasePage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//div[@id='narbar-menu']//a[text()='Components']")
	WebElement componentSection;

	@FindBy(xpath ="//div[@id='narbar-menu']//a[contains(text(), 'Monitor')]")
	WebElement monitors;
	
	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement lnkLogout;
	

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
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
	
	//My old code
	/*
	public ProductCataloguePage viewAvailableComponents(String componentName) throws InterruptedException
	{
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(componentSection).perform();
		WebElement elementName = driver.findElement (By.xpath("//div[@id='narbar-menu']//a[contains(text(), '"+componentName+"')]"));
		elementName.click();
		//Thread.sleep(3000);
		
		ProductCataloguePage productCatalogue = new ProductCataloguePage(driver);
		return productCatalogue;
	}
	*/
}
