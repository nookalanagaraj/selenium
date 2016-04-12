package DriverTests;

import org.apache.xmlbeans.impl.tool.XSTCTester.TestCaseResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestMethods.AddToCart.ShopByDepartment.ShopFromSearchBar;
import CommonMethods.CommonMethods;

public class shopByDeptSuite {

	@Test
	public static void testCase1()
	{
		boolean testCaseResult=true;
		try{
			
			int testCaseID = 1;
			CommonMethods.login();
			ShopFromSearchBar.shopbyDepartment();
			/*CommonMethods.logout();
			CommonMethods.quitBrowser();
			*/
			Assert.assertTrue(testCaseResult);
		}catch(Exception e){
			e.printStackTrace();
			testCaseResult=false;
			Assert.assertTrue(testCaseResult);
		}
	}
}
