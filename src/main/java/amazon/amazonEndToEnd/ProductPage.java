package amazon.amazonEndToEnd;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
	private WebElement price;
	
	@FindBy(xpath = "//span[@id='acrCustomerReviewText']")
	private WebElement reviews;
	
	@FindBy(id = "voyagerATFTitle_feature_div")
	private WebElement description;
	
	@FindBy(id = "add-to-cart-button")
	private WebElement addToCart;

	@FindBy(xpath = "//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']")
	private WebElement addToCartAssertion;

	public void clickOnAddToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
	}

	public String actualBehaviour_AddedToCart() {
		String msg = addToCartAssertion.getText();
		return msg;
	}
	public boolean isPriceDisplayed() {
		return driver.findElement((By) price).isDisplayed();
	}

	public boolean isReviewDisplayed() {
		return driver.findElement((By) reviews).isDisplayed();
	}

	public boolean isProductDetailsDisplayed() {
		return driver.findElement((By) description).isDisplayed();
	}

	// Intialization of elements under constructor using Pagefactory class
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
