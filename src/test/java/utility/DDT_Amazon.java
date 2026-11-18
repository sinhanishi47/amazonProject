package utility;



	import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

	public class DDT_Amazon {
		public static void main(String[] args) throws Exception {
			
		
		
		  // Create a FileInputStream to connect to the Excel file
		FileInputStream fs=new FileInputStream("C:\\Users\\sinha\\eclipse-workspace\\JavaProject\\test-output\\excelsheet\\DDT_practice.xlsx");

	    // Create a Workbook object and load the Excel file into memory
	    Workbook wb = WorkbookFactory.create(fs);

	    String un=        wb.getSheet("loginDetails").getRow(1).getCell(0).getStringCellValue();
	   System.out.println(un);
	    String pwd=        wb.getSheet("loginDetails").getRow(1).getCell(1).getStringCellValue();
	    System.out.println(pwd);
	    ChromeOptions options=new ChromeOptions();
	    options.addArguments("start-maximized");
	    
	    ChromeDriver driver=new ChromeDriver(options);        
	    driver.get("https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	WebElement e1=        driver.findElement(By.xpath("//input[@name='email']"));
	e1.sendKeys(un);

	WebElement e2=        driver.findElement(By.xpath("//span[@id='continue']"));
	e2.click();
	Thread.sleep(3000);
	WebElement e3=        driver.findElement(By.xpath("//input[@type='password']"));
	e3.sendKeys(pwd);
	Thread.sleep(3000);

	WebElement e4=        driver.findElement(By.xpath("//input[@type='submit']"));
	e4.click();
	}
	}



