package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[contains(text(), 'item')]")
	WebElement btnItemsList;

	@FindBy(xpath = "//strong[normalize-space()='View Cart']")
	WebElement lnkViewCart;

	@FindBy(xpath = "//tfoot[@id='checkout-total']//td//strong[text()='Total']//following::td")
	WebElement lblTotalPrice;

	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement btnCheckout;

	public void itemsListinCart() {
		btnItemsList.click();
	}

	public void clickViewCart() {
		lnkViewCart.click();
	}

	public String getTotalPrice() {
		return lblTotalPrice.getText();
	}

	public void clickOnCheckout() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement flag = driver.findElement(By.xpath("//a[text()='Checkout']"));
		js.executeScript("arguments[0].scrollIntoView();", flag);
		Thread.sleep(2000);
		btnCheckout.click();
	}
}
