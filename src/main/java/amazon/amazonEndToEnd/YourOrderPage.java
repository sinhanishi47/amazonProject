package amazon.amazonEndToEnd;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourOrderPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	@FindBy(name = "timeFilter")
	private WebElement dropdown;
	
	@FindBy(xpath="//a[@class='a-button-text' and @id='a-autoid-5-announce']")

	private WebElement viewuritem;
	
	@FindBy(name = "search")
	private WebElement search;
	
	@FindBy(xpath  = "//a[contains(text(),'Write a product review')]")
	private WebElement review;
	@FindBy(xpath  = "//span[@role='radio'][4]")
	private WebElement Stars;
	@FindBy(xpath  ="//span[@class='a-button-inner']/input")
	private WebElement Submit;
	@FindBy(xpath  ="//div[@class='a-alert-content']/span")
	private WebElement ReviewAssertion;
	
	public void select2025()   { 
		wait.until(ExpectedConditions.visibilityOf(dropdown));
		Select select = new Select(dropdown);
		select.selectByVisibleText(" 2025");
	}
	public void viewYourItem() {
		wait.until(ExpectedConditions.elementToBeClickable(viewuritem));
		viewuritem.click();
	}
	public void writeReview() {
		wait.until(ExpectedConditions.elementToBeClickable(review));
		review.click();
	}
	public void ClickingOnStars() {
		wait.until(ExpectedConditions.elementToBeClickable(Stars));
		Stars.click();
	}
	public void ClickingOnSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(Submit));
		Submit.click();
	}
	public String ReviewSubmittedAssertion() {
		String msg = ReviewAssertion.getText();
		return msg;
	}
	public void searchproduct() {
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys("earbuds"+Keys.ENTER);
	}
	
	
	public YourOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
