package amazon.amazonEndToEnd;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utility.BaseTest;

//Verify that searching with filters (e.g., category, price range) yields accurate results.

public class Tc6_Filters extends BaseTest{
	@Test
	
	
	
	public void filters() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enteringUsername();
		loginPage.clickingOnContinue();
		loginPage.enteringPassword();
		loginPage.clickingOnSignIn();
		
		HomePage homePage=new HomePage(driver);
        // Search shoe
        homePage.searchingtheProduct();
		Reporter.log("Product name is entered successfully");

		SearchResultpage searchPage=new SearchResultpage(driver);
		searchPage.selectCampusBrand();
		//Verify product text
        for (WebElement p : searchPage.getProductNames()) {

            String productName = p.getText();
          System.out.println("Product: " + productName);

            Assert.assertTrue(
                    productName.toLowerCase().contains("campus"),
                    "Product is NOT a Campus product: " + productName
            );
        }
	}

}
