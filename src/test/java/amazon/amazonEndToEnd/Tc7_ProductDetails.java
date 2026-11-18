package amazon.amazonEndToEnd;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseTest;

//Ensure that the product detail page displays all necessary information (price, reviews, description).
public class Tc7_ProductDetails extends BaseTest{
	@Test
	
	
	
	public void ProductDetails() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enteringUsername();
		loginPage.clickingOnContinue();
		loginPage.enteringPassword();
		loginPage.clickingOnSignIn();
		
		HomePage homePage=new HomePage(driver);
		homePage.searchingtheProduct();
		
		SearchResultpage searchPage=new SearchResultpage(driver);
		searchPage.clickOnFirstProduct(driver);
		
		ProductPage productpage=new ProductPage(driver);

		SoftAssert a=new SoftAssert();
		a.assertTrue(productpage.isPriceDisplayed(),"price not displayed");
		a.assertTrue(productpage.isReviewDisplayed(),"price not displayed");

		a.assertTrue(productpage.isProductDetailsDisplayed(),"price not displayed");


}
}