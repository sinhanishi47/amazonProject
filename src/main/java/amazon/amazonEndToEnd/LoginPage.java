package amazon.amazonEndToEnd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  {
	WebDriver driver;

	// synchronization
	WebDriverWait wait;

//Locating components using FindBy annotation
	// Locating components
	@FindBy(name = "email")
	private WebElement username;

	@FindBy(id = "continue")
	private WebElement continuebutton;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(id = "signInSubmit")
	private WebElement signin;

	@FindBy(xpath = "//div[@id='claim-collection-container']/h1")
	private WebElement signinorCreateAccount_Assertion;
	
	@FindBy(xpath = "//div[@id='auth-error-message-box']")
	private WebElement loginFailAssertion;
	
	@FindBy(xpath="//*[contains(text(),'incorrect') or " +
	                     "contains(text(),'cannot find an account') or " +
	                     "contains(text(),'not recognized')]")
	 private WebElement errorMessage;

  

	// creating separate methods for each components to perform action
	public void enteringUsername() {
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys("sinhanishi47@gmail.com");
	}
	public void incorrectpassword() {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("bvdhs");
	}

	public void clickingOnContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(continuebutton));
		continuebutton.click();
	}

	public void enteringPassword() {
		wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Nishi@123");
	}

	public void clickingOnSignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(signin));
    signin.click();
	}
	
	 // public void getErrorMessage() {
		//   String err= errorMessage.getText();
	  
	// Intialization of elements under constructor using Pagefactory class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public String actualBehaviour() {
		String title = signinorCreateAccount_Assertion.getText();
		return title;
	}
	  // Get error message
    public String getErrorMessage() {

         wait.until(
                ExpectedConditions.visibilityOf(errorMessage) );

        return errorMessage.getText();
    }
	
}
