package TestMethods.AddToCart.CartandBuy;

import org.openqa.selenium.By;

import ObjectRepository.ElementLocators.Locators;
import ObjectRepository.TestData.DriverSetup;

public class AddToCart extends DriverSetup {
	
	public static void addToCart(String quantity) throws Exception{
		if(oBrowser.findElement(By.id("buybox")).isDisplayed())
		{
			if(oBrowser.findElement(Locators.STOCKAVAILABLE).isDisplayed())
			{
				oBrowser.findElement(Locators.QUANTITYBOX).click();
				oBrowser.findElement(By.xpath("//div[@id='buybox']/descendant::select[@id='quantity']/option[@value='"+quantity+"']")).click();
				oBrowser.findElement(Locators.ADDCARTBUTTON).click();
			}
			else System.out.println("The item is out of stock");
		}
		else System.out.println("This is not buy page.");
	}
}
