package amazon.amazonEndToEnd;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultpage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//a[@class='a-link-normal s-no-outline']")
	private List<WebElement> allProduct;

	@FindBy(xpath = "//div[@id='deliveryRefinements']/descendant::span[text()='Get It in 2 Days']/ancestor::span[@class='a-list-item']/descendant::i")
    public WebElement getIn2DaysRadio;
	
	@FindBy(xpath = "//li[@id='p_90/20912642031']//input[@type='checkbox']")
    public WebElement getIn2Dayscheckbox;

    // Brand - Campus
    //@FindBy(xpath ="//div[@id='brandsRefinements']/descendant::span[text()='Campus']/ancestor::span[@class='a-list-item']/descendant::i")
    @FindBy(xpath="//div[@id='brandsRefinements']/descendant::span[text()='Bata']/preceding-sibling::div")
	public WebElement brandfilter;
	
	@FindBy(xpath = "//div[@data-cy='title-recipe']")
	List<WebElement> productName;
	 // Product names
    @FindBy(xpath = "//div[@data-component-type='s-search-result']//h2//span")
    List<WebElement> productNames;

	@FindBy(id = "s-result-sort-select")
	private WebElement Sort;
	
	@FindBy(xpath="//span[@class='a-dropdown-prompt']")
	private WebElement Text;
	
	
	

	  public void selectCampusBrand() {
		wait.until(ExpectedConditions.elementToBeClickable(brandfilter));
		if(!brandfilter.isSelected()) {
			brandfilter.click();
		}
	}
       public List<WebElement> getProductNames() {
            wait.until(ExpectedConditions.visibilityOfAllElements(productName));
System.out.println("total products:  "+productName.size());
           return productName;
       }
       
       public void selectGetIn2Days() {
    	     wait.until(ExpectedConditions.elementToBeClickable(getIn2DaysRadio));
    	     if (!getIn2DaysRadio.isSelected()) {
    	    	 getIn2DaysRadio.click();	
    	         }
    	     }
	public boolean isGetIn2DaysSelected() {
		wait.until(ExpectedConditions.visibilityOf(getIn2Dayscheckbox));
       return getIn2Dayscheckbox.isSelected();
    }
	
    // Verify Campus brand selected
    public boolean isCampusBrandSelected() {
         return brandfilter.isSelected();
    }
	public void sortbyPrice() {
		wait.until(ExpectedConditions.visibilityOf(Sort));
		Select select = new Select(Sort);
		select.selectByVisibleText("Price: Low to High");
	}
	public String VerifySorting() {
		wait.until(ExpectedConditions.visibilityOf(Text));
    return Text.getText();
		
	}

	public void clickOnFirstProduct(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(allProduct.get(0)));

		WebElement e1 = allProduct.get(0);
		e1.click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> a = window.iterator();
		String parent = a.next();
		String child = a.next();
		driver.switchTo().window(child);
	}

	// Intialization of elements under constructor using Pagefactory class
	public SearchResultpage(WebDriver driver) {
		 this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        PageFactory.initElements(driver, this);	}

	
    }
	    
	


