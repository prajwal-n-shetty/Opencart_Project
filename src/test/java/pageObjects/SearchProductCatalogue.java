package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductCatalogue extends BasePage {

	public SearchProductCatalogue(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='product-list']//div[@class='col']//h4//a")
	List<WebElement> displayedProducts;

	@FindBy(xpath = "//div[@id='product-list']//img")
	List<WebElement> image;

	@FindBy(id = "input-quantity")
	WebElement quantityText;

	@FindBy(id = "button-cart")
	WebElement btnCart;

	@FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
	WebElement cnfMsg;

	public boolean isProductPresent(String prodName) {
		boolean flag = false;

		for (WebElement product : displayedProducts) {

			if (product.getText().equalsIgnoreCase(prodName)) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	public void selectProduct(String prodName) {
		for (int i = 0; i < displayedProducts.size(); i++) {
			String xyz = displayedProducts.get(i).getText();
			System.out.println(xyz);
			if (xyz.equals(prodName)) {
				image.get(i).click();
				break;
			}
		}
	}

	public void changeQuantity(String quantity) {
		quantityText.clear();
		quantityText.sendKeys(quantity);

	}

	public void addToCart() {
		btnCart.click();
	}

	public String checkConfirmationMessage() {
		System.out.println(cnfMsg.getText());
		return cnfMsg.getText();
	}

}
