package utility;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersLogic implements ITestListener {
	
	//public static	WebDriver driver;//Interface

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		ITestListener.super.onTestSuccess(result);
		 TakesScreenshot ts=      (TakesScreenshot) BaseTest.driver;
		   File   source=  ts.getScreenshotAs(OutputType.FILE);        
		   File destination=new File("C:\\Users\\sinha\\eclipse-workspace\\amazonEndToEnd\\test-output\\Screenshots\\Pass\\screenshot.png");

		
		try {
			FileHandler.copy(source,destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                     
	
	}
	@Override
	public void onTestFailure(ITestResult result) 
	{
		ITestListener.super.onTestFailure(result);
		 TakesScreenshot ts=      (TakesScreenshot)  BaseTest.driver;
		   File   source=  ts.getScreenshotAs(OutputType.FILE);        
		   File destination=new File("C:\\Users\\sinha\\eclipse-workspace\\amazonEndToEnd\\test-output\\Screenshots\\Fail\\screenshot.png");

		
		try {
			FileHandler.copy(source,destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                     
	}

}
