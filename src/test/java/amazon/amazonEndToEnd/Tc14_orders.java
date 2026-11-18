package amazon.amazonEndToEnd;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.BaseTest;

//Go to orders page and click on your last ordered product and give 5star ratings
public class Tc14_orders extends BaseTest {

		@Test
		public void Orders() throws InterruptedException {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enteringUsername();
			loginPage.clickingOnContinue();
			loginPage.enteringPassword();
			loginPage.clickingOnSignIn();
			HomePage homePage = new HomePage(driver);
			homePage.goToOrders();
			
			YourOrderPage orderpage=new YourOrderPage(driver);
			orderpage.select2025();

			orderpage.viewYourItem();
			orderpage.writeReview();
			orderpage.ClickingOnStars();
			orderpage.ClickingOnSubmit();
			SoftAssert a1 = new SoftAssert();
			a1.assertEquals(orderpage.ReviewSubmittedAssertion(), "Review Submitted", "sorry assrtion failed");
			a1.assertAll();
}
}