package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AllDepartments {

	private WebDriver oBrowser;
	
	@FindBy(how = How.XPATH, using = "//a[text()='All Videos'")
	private WebElement allVideosLink;
	
	public AllDepartments(WebDriver oBrowser)
	{
		this.oBrowser = oBrowser;
		if(!(oBrowser.getTitle().equals("Amazon.com - Earth's Biggest Selection")))
			System.out.println("This is not All Departments Page");
	}
	
	public void navigateToAllVideos() throws Exception
	{
		allVideosLink.click();
	}
}
