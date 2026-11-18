package amazon.amazonEndToEnd;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	@FindBy(xpath = "//a[@aria-label='Change delivery address']")
	private WebElement change;
	
	@FindBy(xpath = "//div[@id='shipping-address-selection-panel']/descendant::i[4]")
	private WebElement selctaddress;
	
	@FindBy(xpath = "//input[@data-testid='bottom-continue-button']")
	private WebElement deliver;
	
	@FindBy(xpath = "//a[@data-csa-c-slot-id='checkout-change-payselect']")
	private WebElement changePay;
	
	@FindBy(xpath = "//input[@type='radio']")
	private List<WebElement> selectPay;

	@FindBy(xpath = "//span[@id='checkout-primary-continue-button-id']")
	private WebElement UsePay;
	
	@FindBy(xpath = "//a[@class='a-link-normal expand-panel-button']")
	private WebElement Review;
	
	@FindBy(xpath = "(//span[@data-shimmer-target='ordertotals-amount'])[1]")
	private WebElement Total_Assertion;

	public void clickonChange() {
		wait.until(ExpectedConditions.elementToBeClickable(change));
		change.click();
	}
	public void SelectAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(selctaddress));
		selctaddress.click();
	}
	public void deilverTothisAddress() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(deliver));
		deliver.click();
		Thread.sleep(10000);

	}
	public void clickChangePay() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(changePay));
		changePay.click();
		Thread.sleep(8000);

	}
	public void selectPayMethod() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(selectPay.get(5)));
		selectPay.get(5).click();
		Thread.sleep(8000);

	}
	public void clickUsethis() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(UsePay));
		UsePay.click();
		Thread.sleep(8000);

	}

	public void clickonReview() {
		wait.until(ExpectedConditions.elementToBeClickable(Review));
		Review.click();
	}
	public String actualBehaviour() {
		String title = Total_Assertion.getText();
		return title;
	}
	public boolean creditCard() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(selectPay.get(1)));
		selectPay.get(1).click();
		Thread.sleep(8000);
		return selectPay.get(1).isSelected();
	}
	public boolean amazonPayBalance() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(selectPay.get(0)));
		selectPay.get(0).click();
		Thread.sleep(8000);
		return selectPay.get(0).isSelected();
	}
	public boolean selectCashonDelivery() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(selectPay.get(5)));
		selectPay.get(5).click();
		Thread.sleep(8000);
		return selectPay.get(5).isSelected();
	}
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
