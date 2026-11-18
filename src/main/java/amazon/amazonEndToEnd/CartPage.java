package amazon.amazonEndToEnd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "(//span[@class='a-icon a-icon-small-add'])[1]")
	private WebElement add;
	
	@FindBy(xpath = "(//span[@class='a-icon a-icon-small-remove'])[1]")
	private WebElement remove;
	
	@FindBy(id = "sc-subtotal-label-activecart")
	private WebElement subtotalAssertion;
	
	@FindBy(id = "desktop-ptc-button-")
	private WebElement proceedToPay;
	
	@FindBy(id="a-autoid-3-announce")
	private WebElement viewuritem;
	
	@FindBy(name = "proceedToRetailCheckout")
	private WebElement proceedToBuy;
	
	@FindBy(xpath = "//a[contains(text(),'Cart')]")
	private WebElement GoToCart;
	
	@FindBy(xpath = "//div[@class='a-column a-span12']/h2")
	private WebElement ShoppingCart;

	public void addOneQty() {
		wait.until(ExpectedConditions.elementToBeClickable(add));
		add.click();
	}
	public void removeOneQty() {
		wait.until(ExpectedConditions.elementToBeClickable(remove));
		remove.click();
	}
	public void clickProceed() {
		wait.until(ExpectedConditions.elementToBeClickable(proceedToPay));
		proceedToPay.click();
	}
	
	public String actualBehaviour_subTotal() {
		wait.until(ExpectedConditions.visibilityOf(subtotalAssertion));
		String msg = subtotalAssertion.getText();
		return msg;
	}
		public void viewuritem() {
			wait.until(ExpectedConditions.elementToBeClickable(viewuritem));
			viewuritem.click();
		}
		public void clickonProceedBuy() {
			wait.until(ExpectedConditions.elementToBeClickable(proceedToBuy));
			proceedToBuy.click();
		}
		public void clickonGoToCart() {
			wait.until(ExpectedConditions.elementToBeClickable(GoToCart));
			GoToCart.click();
		}
		public String Cart_Assertion() {
			wait.until(ExpectedConditions.visibilityOf(ShoppingCart));
			return ShoppingCart.getText();
		}
	// Intialization of elements under constructor using Pagefactory class
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	}