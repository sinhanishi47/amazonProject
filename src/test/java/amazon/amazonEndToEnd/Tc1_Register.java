package amazon.amazonEndToEnd;

import org.testng.Reporter;
import org.testng.annotations.Test;

import utility.BaseTest;

//Test if a new user can successfully register.
public class Tc1_Register extends BaseTest{
	@Test
	public void Register()
	{
		Reporter.log("Browser is launched successfully");
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enteringUsername();
	
	}	

}
