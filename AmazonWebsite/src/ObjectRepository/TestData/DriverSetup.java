package ObjectRepository.TestData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class DriverSetup {

	public static WebDriver oBrowser;
	
	
	public static void SelectBrowser(String browserType, String sURL)
	{
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
		if(oBrowser.findElement(By.xpath("//span[contains(text(),'Stay on Amazon.com') and @class='redir-a-button-sec-center' ]")).isDisplayed())
		{
			oBrowser.findElement(By.xpath("//label[@id='redir-opt-out-label']")).click();
			oBrowser.findElement(By.xpath("//span[contains(text(),'Stay on Amazon.com') and @class='redir-a-button-sec-center' ]")).click();
		}
	}
}
