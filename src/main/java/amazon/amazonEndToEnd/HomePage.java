package amazon.amazonEndToEnd;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	// synchronization
	 WebDriverWait wait;

//Locating components using FindBy annotation
	@FindBy(id = "nav-link-accountList")
	private WebElement AccountandList;

	@FindBy(xpath = "//span[text()='Sign Out']")
	private WebElement SignOut;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement SearchTextbox;

	@FindBy(xpath = "//a[@class='a-link-normal s-no-outline']")
	private List<WebElement> allProduct;
	
	@FindBy(xpath="//button[text()='Manage Profiles']")
	private WebElement ManageProfile;
	@FindBy(xpath="//div[@class='profile-picker-content']/ul")
	private WebElement AccountHolder;
	@FindBy(xpath="//div[@class='nav-line-1-container']")
	private WebElement AccountnList;
	
	@FindBy(xpath = "//a[text()='View']")
	private WebElement view;
	
	@FindBy(xpath = "//span[@class='editProfile']")
	private WebElement Editprofile;
	@FindBy(id = "editProfileNameInputId")
	private WebElement changeprofile;
	@FindBy(xpath = "//input[@class='a-button-input']")
	private WebElement Continue;
	@FindBy(xpath = "//div[@class='profile-name desktop']")
	private WebElement ProfileName;
	@FindBy(id="nav-cart")
	private WebElement Cart;

	@FindBy(id="nav-orders")
	private WebElement Orders;

	public void HoverOverAccountandList(WebDriver driver) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(AccountandList));
		Actions a1 = new Actions(driver);
		a1.moveToElement(AccountandList).perform();

	}

	public void clickingOnSignOut() {
		wait.until(ExpectedConditions.elementToBeClickable(SignOut));

		SignOut.click();
	}

	public void searchingtheProduct() {
		wait.until(ExpectedConditions.visibilityOf(SearchTextbox));
		SearchTextbox.sendKeys("shoe" + Keys.ENTER);
	}

	public int actualBehaviour_CountingProductCount() {
		int count = allProduct.size();
		return count;

	}
	public void clickingOnMangeProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(ManageProfile));
		ManageProfile.click();
	}
	public void clickingOnAccountHolder() {
		wait.until(ExpectedConditions.elementToBeClickable(AccountHolder));
		AccountHolder.click();
	}
	public void HoverOverAccountandList2(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);;
		wait.until(ExpectedConditions.visibilityOf(AccountnList));
		Actions a2 = new Actions(driver);
		a2.moveToElement(AccountnList).perform();

	}
	public void clickonView() {
		wait.until(ExpectedConditions.elementToBeClickable(view));
view.click();
	}
	
	public void editProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(Editprofile));
		Editprofile.click();
	}
	public void editProfileName() {
		wait.until(ExpectedConditions.visibilityOf(changeprofile));
		changeprofile.sendKeys("Nishi1");
	}
	public void clickingOnContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(Continue));
		Continue.click();
	}
	public String VerifyProfileChanged() {
		wait.until(ExpectedConditions.elementToBeClickable(ProfileName));
		return ProfileName.getText();
		
	}
	public void goToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(Cart));
		Cart.click();
	}
	public void goToOrders() {
		wait.until(ExpectedConditions.elementToBeClickable(Orders));
		Orders.click();
	}
	public HomePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void searchFlightTicketBookings() {
		wait.until(ExpectedConditions.visibilityOf(SearchTextbox));
		SearchTextbox.sendKeys("Flight ticket booking" + Keys.ENTER);		
	}

}
