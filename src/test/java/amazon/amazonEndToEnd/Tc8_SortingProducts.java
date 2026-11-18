package amazon.amazonEndToEnd;

import org.testng.Assert;
import org.testng.annotations.Test;

import utility.BaseTest;

public class Tc8_SortingProducts extends BaseTest{
		@Test
		
		public void filters() {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enteringUsername();
			loginPage.clickingOnContinue();
			loginPage.enteringPassword();
			loginPage.clickingOnSignIn();
			
			HomePage homePage=new HomePage(driver);
			homePage.searchingtheProduct();
			
			SearchResultpage searchPage=new SearchResultpage(driver);
			searchPage.sortbyPrice();
			Assert.assertEquals(searchPage.VerifySorting(),"Price: Low to High","Assertion failed");
			}
}