package amazon.amazonEndToEnd;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utility.BaseTest;

//Check if a user can successfully edit their profile information.
public class Tc4_profileEdit extends BaseTest {
	@Test
	public void manageProfile() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enteringUsername();
		loginPage.clickingOnContinue();
		loginPage.enteringPassword();
		loginPage.clickingOnSignIn();
		
		HomePage homePage = new HomePage(driver);
		homePage.HoverOverAccountandList(driver);
		Reporter.log("Hoverover on Accounts and Lists is successful");

		homePage.clickingOnMangeProfile();
		homePage.clickingOnAccountHolder();
		homePage.HoverOverAccountandList2(driver);
		homePage.clickingOnMangeProfile();
        homePage.clickonView();
		homePage.editProfile();
		homePage.editProfileName();
		homePage.clickingOnContinue();
		
		Assert.assertEquals(homePage.VerifyProfileChanged(),"Nishi1","Assertion failed");
		
		
		
		
		
	}

}
