package amazon.amazonEndToEnd;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseTest;
import utility.Data_Fetching;

//Ensure login fails with incorrect email or password.
public class Tc3_loginFails extends BaseTest{
	@Test(dataProvider = "invalidloginData"  , dataProviderClass=Data_Fetching.class)

	public void withInValidCredentials(String UN,String PWD)
	{
	Reporter.log("Browser is launched successfully");
	LoginPageDDT login=new LoginPageDDT(driver);
	login.enteringUsername(UN);
	Reporter.log("Username is entered");
	login.clickingOnContinue();
	login.incorrectpassword(PWD);
	Reporter.log("password is entered");
    login.clickingOnSignIn();
	Reporter.log("Click on continue button is successful");

	SoftAssert s1=new SoftAssert();
	s1.assertEquals(login.getErrorMessage(), "Your password is incorrect");
	s1.assertAll();
	Reporter.log("Error message displayed");
	Reporter.log("Testcase is pass");


	}
}
