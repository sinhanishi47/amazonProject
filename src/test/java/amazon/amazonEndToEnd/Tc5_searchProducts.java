package amazon.amazonEndToEnd;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseTest;
import utility.Data_Fetching;

//Test searching for products using its name like shoe
public class Tc5_searchProducts extends BaseTest {
	@Test(dataProvider = "loginData", dataProviderClass = Data_Fetching.class)
	public void withValidCredentials(String UN, String PWD) throws Exception 
	{
		Reporter.log("Browser and URL launched Successfully");
         LoginPageDDT login = new LoginPageDDT(driver);
		login.enteringUsername(UN);
		Reporter.log("Username is entered");
		login.clickingOnContinue();
		login.enteringPassword(PWD);
		Reporter.log("password is entered");
        login.clickingOnSignIn();
	SoftAssert a1=new SoftAssert();
	a1.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Sorry: Assertion failed");
	Reporter.log("Login is succesful");

	HomePage homePage=new HomePage(driver);
	homePage.searchingtheProduct();
	
	Reporter.log("product is searched");

	SoftAssert a2=new SoftAssert();
	a2.assertEquals(homePage.actualBehaviour_CountingProductCount()>30, true,"Sorry: Assertion failed");
	a2.assertAll();
	Reporter.log("Testcase is Pass");


}
}