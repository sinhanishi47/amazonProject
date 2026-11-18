package amazon.amazonEndToEnd;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utility.AmazonBase;

//Reach till cart page without login in amazon application
public class Tc15_withoutlogin extends AmazonBase{
       @Test
       public void withoutLogin() {
   		Reporter.log("Browser Launched Successfully");

		HomePage homePage = new HomePage(driver);
		homePage.searchingtheProduct();
		Reporter.log("Product search is successfull");

		SearchResultpage searchPage = new SearchResultpage(driver);
		searchPage.clickOnFirstProduct(driver);

		ProductPage productpage = new ProductPage(driver);
		productpage.clickOnAddToCart();

		CartPage cartpage = new CartPage(driver);
		cartpage.clickonGoToCart();
		Reporter.log("Click on go to cart is successful");

		Assert.assertEquals(cartpage.Cart_Assertion(), "Shopping Cart", "Assertion failed");
		Reporter.log("Testcase is Pass");

}
}