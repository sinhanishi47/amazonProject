package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Fetching {

	@DataProvider(name = "loginData")
	public static Object loginData() throws Exception {
		
		Object [][] d1=new Object[1][2];
        FileInputStream fs = new FileInputStream(
				"C:\\Users\\sinha\\eclipse-workspace\\AB67\\test-output\\excelsheet\\AmazonprojectDDT.xlsx");

		// Create a Workbook object and load the Excel file into memory
		Workbook wb = WorkbookFactory.create(fs);
		for (int row = 1; row < 2; row++) {
			for (int column = 0; column < 2; column++) {
				d1[row-1][column]=wb.getSheet("loginData").getRow(row).getCell(column).getStringCellValue();
			}
		}
		wb.close();
		fs.close();
		return d1;
}

	@DataProvider(name = "invalidloginData")
	public static Object invalidloginData() throws Exception {
		
		Object [][] d1=new Object[1][2];
FileInputStream fs = new FileInputStream(
				"C:\\Users\\sinha\\eclipse-workspace\\AB67\\test-output\\excelsheet\\AmazonprojectDDT.xlsx");

		// Create a Workbook object and load the Excel file into memory
		Workbook wb = WorkbookFactory.create(fs);
		for (int row = 1; row < 2; row++) {
			for (int column = 0; column < 2; column++) {
				d1[row-1][column]=wb.getSheet("invalidLoginData").getRow(row).getCell(column).getStringCellValue();
			}
		}
		wb.close();
		fs.close();
		return d1;
}
}

