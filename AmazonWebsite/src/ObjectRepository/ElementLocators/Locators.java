package ObjectRepository.ElementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ObjectRepository.TestData.DriverSetup;

public class Locators extends DriverSetup{

	//public static String LoginButton = "//span[text()='Hello. Sign in']";
	public static By LOGINBUTTON = By.xpath(ReadLocatorsFile.readLocators("loginButton"));
	public static By EMAILID = By.id(ReadLocatorsFile.readLocators("emailID"));
	public static By PASSWORD = By.id(ReadLocatorsFile.readLocators("pwd"));
	public static By SUBMIT = By.id(ReadLocatorsFile.readLocators("submit"));
	public static By ACCOUNTNAME = By.id(ReadLocatorsFile.readLocators("accountName"));
	public static By ALLDEPARTMENTS = By.id(ReadLocatorsFile.readLocators("departments"));
	public static By SEARCHBAR = By.id(ReadLocatorsFile.readLocators("searchBar"));
	public static By DEPARTMENTNAME	= By.xpath(ReadLocatorsFile.readLocators("departmentName"));
	public static By SEARCHDROPDOWNBOX = By.id(ReadLocatorsFile.readLocators("searchDropdownBox"));
	public static By SEARCHBUTTON = By.xpath(ReadLocatorsFile.readLocators("searchButton"));
	public static By SEARCHCOUNT = By.id(ReadLocatorsFile.readLocators("searchResultCount"));
	public static By LOGO = By.xpath(ReadLocatorsFile.readLocators("searchResultCount"));
	public static By BUYBOX =By.id(ReadLocatorsFile.readLocators("buyBox"));
	public static By STOCKAVAILABLE = By.xpath(ReadLocatorsFile.readLocators("stockAvailble"));
	public static By QUANTITYBOX = By.xpath(ReadLocatorsFile.readLocators("quantityBox"));
	public static By ADDCARTBUTTON = By.id(ReadLocatorsFile.readLocators("addCartButton"));
}
