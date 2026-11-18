package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
@Listeners(ListenersLogic.class)
public class BaseTest {
	public static  WebDriver driver;//Interface
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(@Optional("chrome")String nameOfBrowser) throws InterruptedException
	{
		
		if(nameOfBrowser.equals("chrome"))
		{
		 driver=new ChromeDriver();
		}
		if(nameOfBrowser.equals("firefox"))
		{
		 driver=new FirefoxDriver();
		}
		if(nameOfBrowser.equals("edge"))
		{
		 driver=new EdgeDriver();
		}	
		 driver.get("https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D155259815513%26hvpone%3D%26hvptwo%3D%26hvadid%3D815461303151%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D3924494936536654393%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9061994%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2462831%26mcid%3D4c22dcdee2bf3a71b0b832c5c4ba9c17%26hvocijid%3D3924494936536654393--%26hvexpln%3Dnav%26gad_source%3D1&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Thread.sleep(2000);
		
	}
	/*@AfterMethod
	public void quit()
	{
		driver.quit();
	}*/

}
