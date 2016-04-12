package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import TestData.ReadTestProperties;

public class CredentialsPage {

	private WebDriver oBrowser;
	
	@FindBy(how = How.ID, using = "ap_email")
	private WebElement emailIDField;
	
	@FindBy(how = How.ID, using = "ap_password")
	private WebElement passwordField;
	
	@FindBy(how = How.ID, using = "signInSubmit")
	private WebElement signInButton;
	
	

	public CredentialsPage(WebDriver oBrowser)
	{
		this.oBrowser = oBrowser;
		String pageTitle = oBrowser.getTitle();
		if(!(pageTitle.equals("Amazon Sign In")))
		{
			System.out.println("This is not Credentials Login page");
		}
	}
	
	public HomePage signIn() throws Exception
	{
		String email = ReadTestProperties.getProperty("username");
		String pwd = ReadTestProperties.getProperty("password");
		emailIDField.sendKeys(email);
		passwordField.sendKeys(pwd);
		signInButton.click();
		PageFactory.initElements(oBrowser, (new HomePage(this.oBrowser)));
		return (new HomePage(oBrowser));
	}
}
