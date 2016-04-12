package PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {
	private WebDriver oBrowser;
	
	//@[FindsBy(How = How.xpath, Using = "//span[text()='Hello. Sign in']")]
	@FindBy(how = How.XPATH, using = "//span[text()='Hello. Sign in']")
	private WebElement loginButton;
	
	@FindBy(how = How.ID, using = "nav-link-shopall")
	private WebElement allDepartmentsPageLink;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Stay on Amazon.com') and @class='redir-a-button-sec-center' ]")
	private WebElement stayOnAmazonCOM;
	
	@FindBy(how = How.XPATH, using = "//label[@id='redir-opt-out-label']")
	private WebElement sOACDNS; //sOACDNS = Do not show me again option in Stay on Amazon.com window 
	
	public LoginPage(WebDriver oBrowser)
	{
		this.oBrowser = oBrowser;
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (stayOnAmazonCOM.isDisplayed())
		{
			sOACDNS.click();
			stayOnAmazonCOM.click();
		}
		if (!(oBrowser.getTitle().equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more")))
			System.out.println("Opening Amazon.com Page Failed");
	}
	
	public CredentialsPage login() throws Exception{
		loginButton.click();
		PageFactory.initElements(oBrowser, (new CredentialsPage(this.oBrowser)));
		return (new CredentialsPage(oBrowser));
	}

}
