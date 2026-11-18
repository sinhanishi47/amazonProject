package amazon.amazonEndToEnd;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseTest;

//Verify that items can be added to the shopping cart from product pages.
public class Tc9_AddToCart extends BaseTest {
	@Test
	public void addToCart() {
		Reporter.log("Browser Launched Successfully");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enteringUsername();
		loginPage.clickingOnContinue();
		loginPage.enteringPassword();
		loginPage.clickingOnSignIn();
		Reporter.log("Login is successful");

		HomePage homePage = new HomePage(driver);
		homePage.searchingtheProduct();
		Reporter.log("Search product is successful");

		SearchResultpage searchPage = new SearchResultpage(driver);
		searchPage.clickOnFirstProduct(driver);
		ProductPage productpage = new ProductPage(driver);
		productpage.clickOnAddToCart();
		Reporter.log(" product is  added successfully");

		SoftAssert a1 = new SoftAssert();
		a1.assertEquals(productpage.actualBehaviour_AddedToCart(), "Added to cart", "sorry assrtion failed");
		a1.assertAll();
		Reporter.log("Test case is pass");

	}
}