package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCataloguePage extends BasePage {

	WebDriver driver;

	@FindBy(xpath = "//div[@id='product-list']//div[@class='col']")
	List<WebElement> productsList;

	By productsListBy = By.xpath("//div[@id='product-list']//div[@class='col']");

	@FindBy(xpath = "//div[@class='description']//a")
	List<WebElement> productnames;

	@FindBy(id = "input-quantity")
	WebElement quantityField;

	@FindBy(id = "button-cart")
	WebElement cartButton;

	@FindBy(xpath = "//div[@id='alert']//div")
	WebElement successToast;

	By successToastBy = By.xpath("//div[@id='alert']//div");

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsListBy);
		return productsList;
	}

	public String scanDesiredProduct(String productName, String productQuantity) throws InterruptedException {
		for (int i = 0; i < productnames.size(); i++) {
			String xyz = productnames.get(i).getText();
			if (xyz.equalsIgnoreCase(productName)) {
				productnames.get(i).click();
				break;
			}
		}

		quantityField.clear();
		quantityField.sendKeys(productQuantity);
		cartButton.click();

		waitForElementToAppear(successToastBy);
		System.out.println(driver.findElement(By.xpath("//div[@id='alert']//div")).getText());
		String check = successToast.getText();
		return check;

	}

}
