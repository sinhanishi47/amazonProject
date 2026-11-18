package amazon.amazonEndToEnd;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseTest;

//Check if user is able to select each payment method
public class Tc12_payment extends BaseTest{
	@Test
	public void paymentmethod() throws InterruptedException {
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
	SoftAssert s1=new SoftAssert();
s1.assertEquals(checkout.selectCashonDelivery(), true,"not able to select");
s1.assertEquals(checkout.amazonPayBalance(), true,"not able to select");
s1.assertEquals(checkout.creditCard(), true,"not able to select");
s1.assertAll();

}
}