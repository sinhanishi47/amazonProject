package amazon.amazonEndToEnd;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseTest;

//Validate the entire checkout process, including address selection,payment method selection, and order review.

public class Tc11_checkout extends BaseTest {

	@Test
	public void checkout() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enteringUsername();
		loginPage.clickingOnContinue();
		loginPage.enteringPassword();
		loginPage.clickingOnSignIn();
		HomePage homePage = new HomePage(driver);
		homePage.searchingtheProduct();
		SearchResultpage searchPage = new SearchResultpage(driver);
		searchPage.clickOnFirstProduct(driver);
		ProductPage productpage = new ProductPage(driver);
		productpage.clickOnAddToCart();
		homePage.goToCart();
		CartPage cartpage = new CartPage(driver);
		cartpage.clickProceed();

		CheckOutPage checkout = new CheckOutPage(driver);
		checkout.clickonChange();
		checkout.SelectAddress();
		checkout.deilverTothisAddress();
	//	checkout.clickChangePay();
		checkout.selectPayMethod();
	checkout.clickUsethis();
	//	checkout.clickonReview();
	
	SoftAssert s1=new SoftAssert();
	s1.assertEquals(checkout.actualBehaviour(), "₹₹382.00");
	s1.assertAll();
		
	}
}