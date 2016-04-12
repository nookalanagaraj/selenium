package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;;

public class HomePage {

	private WebDriver oBrowser;
	
	@FindBy(how = How.XPATH, using = "//a[@id='nav-link-yourAccount']/span[text()='Hello. Sign in']")
	private WebElement signIN;
	
	@FindBy(how = How.ID, using = "nav-link-shopall")
	private WebElement allDepartmentsPageLink;
	
	public HomePage(WebDriver oBrowser)
	{
		this.oBrowser = oBrowser;
		if(signIN.isDisplayed())
			System.out.println("The Login is not successful");
	}
	
	public AllDepartments navigateToAllDepartments() throws Exception
	{
		allDepartmentsPageLink.click();
		PageFactory.initElements(oBrowser, (new AllDepartments(this.oBrowser)));
		return (new AllDepartments(oBrowser));
	}
	
}
