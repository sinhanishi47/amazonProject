package amazon.amazonEndToEnd;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseTest;

//Test updating item quantities and removing items from the cart.
public class Tc10_QuantityUpdate extends BaseTest
{
	
	@Test
	public void updateQty()
	{
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
		CartPage cartpage=new CartPage(driver);
		cartpage.removeOneQty();
		SoftAssert a1 = new SoftAssert();
		a1.assertEquals(cartpage.actualBehaviour_subTotal(), "Subtotal (4 items)", "sorry assrtion failed");
		a1.assertAll();
		
    }
}