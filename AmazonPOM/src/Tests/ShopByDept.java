package Tests;

import org.testng.annotations.Test;

import PageFactory.*;
import TestData.DriverSetup;

public class ShopByDept extends DriverSetup{

	@Test
	public static void testCase1() throws Exception
	{
		LoginPage login = DriverSetup.SelectBrowser();
		CredentialsPage cp = login.login();
		HomePage hp = cp.signIn();
		AllDepartments ad = hp.navigateToAllDepartments();
		ad.navigateToAllVideos();
	}
}
