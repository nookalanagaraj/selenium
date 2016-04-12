package TestData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import TestData.ReadTestProperties;
import PageFactory.LoginPage;

import org.openqa.selenium.support.*;
//import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;


public class DriverSetup {

	static WebDriver oBrowser;
	
	/*@FindBy(how = How.XPATH, using = "//span[contains(text(),'Stay on Amazon.com') and @class='redir-a-button-sec-center' ]")
	private WebElement stayOnAmazonCOM;
	
	@FindBy(how = How.XPATH, using = "//label[@id='redir-opt-out-label']")
	private WebElement sOACDNS; //sOACDNS = Do not show me again option in Stay on Amazon.com window
	
	
	
	@FindBy(xpath = "//label[@id='redir-opt-out-label']")
	WebElement sOACDNS; //sOACDNS = Do not show me again option in Stay on Amazon.com window
	*/
	public static LoginPage SelectBrowser() throws Exception
	{
		String browserType = ReadTestProperties.getProperty("browserType"); 
		String sURL = ReadTestProperties.getProperty("url");
		browserType = browserType.trim().toUpperCase();
		
		
		switch(browserType)
		{
		case "IE" :
			System.setProperty("webdriver.ie.driver", "D:\\Preparation\\SeleniumAutomation\\IEDriver\\IEDriverServer.exe");
			oBrowser = new InternetExplorerDriver();
			oBrowser.manage().deleteAllCookies();
			break;
			
		case "CHROME" :
			System.setProperty("webdriver.chrome.driver", "D:/Preparation/SeleniumAutomation/ChromeDriver/chromedriver.exe");
			oBrowser = new ChromeDriver();
			oBrowser.manage().deleteAllCookies();
			break;
			
		case "HTMLUNIT" :
			oBrowser = new HtmlUnitDriver();
			break;
			
		default :
			oBrowser =  new FirefoxDriver();
			oBrowser.manage().deleteAllCookies();
			break;			
		}
		
		oBrowser.manage().window().maximize();
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		oBrowser.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		oBrowser.navigate().to(sURL);
		Thread.sleep(30000);
		
		
		/*if(oBrowser.findElement(By.xpath("//span[contains(text(),'Stay on Amazon.com') and @class='redir-a-button-sec-center' ]")).isDisplayed())
		{
			oBrowser.findElement(By.xpath("//label[@id='redir-opt-out-label']")).click();
			oBrowser.findElement(By.xpath("//span[contains(text(),'Stay on Amazon.com') and @class='redir-a-button-sec-center' ]")).click();
		}
		
		if (stayOnAmazonCOM.isDisplayed())
		{
			sOACDNS.click();
			stayOnAmazonCOM.click();
		}*/
		
		PageFactory.initElements(oBrowser, (new LoginPage(oBrowser)));
		return (new LoginPage(oBrowser));
	}
}
