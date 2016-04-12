package CommonMethods;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Substitute;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ObjectRepository.TestData.DriverSetup;
import ObjectRepository.TestData.GetTestJava;
import ObjectRepository.TestData.ReadTestProperties;
import ObjectRepository.ElementLocators.Locators;

public class CommonMethods extends DriverSetup {
	
	public static boolean navigateToURL() //throws Exception
	{
		try{
			String sURL = ReadTestProperties.getProperty("url");
			String browserType = ReadTestProperties.getProperty("browserType");
			DriverSetup.SelectBrowser(browserType, sURL);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}return true;
	}
	
	public static void login() throws Exception {
		navigateToURL();
		String email = ReadTestProperties.getProperty("username");
		String pwd = ReadTestProperties.getProperty("password");
		
		oBrowser.findElement(Locators.LOGINBUTTON).click();
		WebDriverWait oWait = new WebDriverWait(oBrowser, 60);
		oWait.until(ExpectedConditions.visibilityOf(oBrowser.findElement(Locators.EMAILID)));
		oBrowser.findElement(Locators.EMAILID).sendKeys(email);
		oBrowser.findElement(Locators.PASSWORD).sendKeys(pwd);
		oBrowser.findElement(Locators.SUBMIT).click();
		oWait.until(ExpectedConditions.visibilityOf(oBrowser.findElement(Locators.ACCOUNTNAME)));
	}
	
	
	public static void logout() throws Exception
	{
		Actions builder = new Actions(oBrowser);
		Action movetoAccount = builder.moveToElement(oBrowser.findElement(Locators.ACCOUNTNAME)).build();
		movetoAccount.perform();
		Action clickonSignout = builder.click(oBrowser.findElement(By.id("nav-item-signout"))).build();
		clickonSignout.perform();
	}
	
	@Test
	public static Cell[][] readFromExcel(String filePath, String fileName, String sheetName) throws Exception
	{
		Cell[][] cellContent= null;
		
			File file = new File(filePath+"\\"+fileName);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook excelWorkBook = null;		
			String fileExtension = fileName.substring(fileName.indexOf("."));
			System.out.println("File Extension is "+fileExtension);
			if (fileExtension.equalsIgnoreCase(".xlsx"))
			{
				excelWorkBook = new XSSFWorkbook(inputStream);
			}
			else 
			{
				excelWorkBook = new HSSFWorkbook(inputStream);
			}
			int noOfSheets = excelWorkBook.getNumberOfSheets();
			Sheet excelSheet = excelWorkBook.getSheet(sheetName);
			System.out.println("Total number of rows is "+excelSheet.getPhysicalNumberOfRows());
			System.out.println("No of Columns is "+excelSheet.getRow(0).getPhysicalNumberOfCells());
			int rowCount = excelSheet.getPhysicalNumberOfRows();
			int colCount = excelSheet.getRow(1).getPhysicalNumberOfCells();
			System.out.println("row count is "+rowCount+", Column count is "+colCount);
			cellContent = new Cell[rowCount-1][colCount];
			
			for (int i=1; i<rowCount; i++)
			{
				Row row = excelSheet.getRow(i);
				for (int j=0; j<colCount; j++)
				{
					cellContent[i-1][j] = row.getCell(j);
					System.out.println((i-1)+"th, "+j+"th element "+cellContent[i-1][j]);
				}
			}
			System.out.println("Length of depts is "+cellContent.length);
			System.out.println("columns in depts is "+cellContent[0].length);
			for (int k=0; k<cellContent.length; k++)
				for (int a=0; a<cellContent[0].length; a++)
					System.out.println("printing the "+k+" "+a+" element for depsts "+cellContent[k][a]);
		
		return cellContent;		
	}
	
	 public static void waitUntilElementIsVisible(WebDriver oBrowser, By oBy, long timeoutseconds) throws Exception
	 {
	 	WebDriverWait oWait = new WebDriverWait(oBrowser, timeoutseconds);
	 	oWait.until(ExpectedConditions.visibilityOfElementLocated(oBy));
	 }
	 
	 public static void quitBrowser() throws Exception
	 {
		 oBrowser.close();
		 oBrowser.quit();			
	 }
}
	

