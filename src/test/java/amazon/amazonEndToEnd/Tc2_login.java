package amazon.amazonEndToEnd;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseTest;
import utility.Data_Fetching;
import utility.RetryLogic;

//Verify login is successful with correct email and password.
public class Tc2_login extends BaseTest
{
	@Test(dataProvider = "loginData", dataProviderClass = Data_Fetching.class,retryAnalyzer = RetryLogic.class)
	public void withValidCredentials(String UN, String PWD) throws Exception 
	{
        LoginPageDDT login = new LoginPageDDT(driver);
		login.enteringUsername(UN);
		Reporter.log("Username is entered");
		login.clickingOnContinue();
		login.enteringPassword(PWD);
		Reporter.log("password is entered");
        login.clickingOnSignIn();

		SoftAssert a = new SoftAssert();
		a.assertEquals(driver.getTitle(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",
				"Sorry: Assertion failed");
		a.assertAll();
		Reporter.log("Login is succesful");
		Reporter.log("Testcase is pass");

	}

}
