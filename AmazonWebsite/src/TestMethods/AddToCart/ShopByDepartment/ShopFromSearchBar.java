package TestMethods.AddToCart.ShopByDepartment;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import CommonMethods.CommonMethods;
import ObjectRepository.ElementLocators.Locators;
import ObjectRepository.ElementLocators.ReadLocatorsFile;
import ObjectRepository.TestData.DriverSetup;
import ObjectRepository.TestData.ReadTestProperties;
import TestMethods.AddToCart.CartandBuy.AddToCart;

public class ShopFromSearchBar extends DriverSetup {

	@Test
	public static void shopbyDepartment() throws Exception
	{
		String filePath = ReadTestProperties.getProperty("filePath");
		String fileName = ReadTestProperties.getProperty("fileName");
		String sheetName = ReadTestProperties.getProperty("sheetName");
		Cell[][] depts = null;
		Cell[][] prods = null;
		
		depts = CommonMethods.readFromExcel(filePath, fileName, sheetName);
				
		for (int deptRow=0; deptRow<depts.length; deptRow++)
		{
			for (int deptColumn=0; deptColumn<depts[0].length; deptColumn++)
			{
				String deptname = depts[deptRow][deptColumn].toString();
				System.out.println("The converted dept name is "+deptname);
								
				prods = CommonMethods.readFromExcel(filePath, fileName, deptname);
				System.out.println("length of the prods is "+prods.length);
				System.out.println("Breadth of the prods is "+prods[0].length);
				for (int prodRow =0; prodRow<prods.length; prodRow++)
				{
					oBrowser.findElement(Locators.ALLDEPARTMENTS).click();
					oBrowser.findElement(Locators.SEARCHBAR).click();
					Actions builder1 = new Actions(oBrowser);
						
					CommonMethods.waitUntilElementIsVisible(oBrowser,By.xpath("//a[text()='"+deptname+"']") , 45);
					oBrowser.findElement(By.xpath("//a[text()='"+deptname+"']")).click();
					CommonMethods.waitUntilElementIsVisible(oBrowser,Locators.SEARCHBAR , 45);
									
					String prodName = prods[prodRow][0].toString();
					String category = prods[prodRow][1].toString();
					String videoFormat = prods[prodRow][2].toString();
					String[] quantity = prods[prodRow][3].toString().split("\\.");
					
					System.out.println("Value of quantity is "+quantity[0]+" "+quantity[1]);
					System.out.println("product name is "+prodName+", Category is "+category);
					
					oBrowser.findElement(Locators.SEARCHBAR).sendKeys(prodName.toLowerCase());
					oBrowser.findElement(Locators.SEARCHDROPDOWNBOX).click();
					oBrowser.findElement(By.xpath("//select[@id='searchDropdownBox']/option[text()='"+category+"']")).click();
					oBrowser.findElement(Locators.SEARCHBUTTON).click();
					
					CommonMethods.waitUntilElementIsVisible(oBrowser, Locators.SEARCHCOUNT, 45);
										
					if(oBrowser.findElement(By.xpath("//div[@id='centerPlus']/descendant::a[text()='"+videoFormat+"']")).isDisplayed())
						oBrowser.findElement(By.xpath("//div[@id='centerPlus']/descendant::a[text()='"+videoFormat+"']")).click();
					else
					{
						System.out.println("The video for the selected format "+videoFormat+" is not present");
					}
					oBrowser.findElement(By.xpath("//a[@title='"+prodName+"']")).click();
					AddToCart.addToCart(quantity[0]);
					oBrowser.findElement(Locators.LOGO).click();
				}
			}
		}
	}
}
