package TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadTestProperties {

	public static String getProperty(String keyName) throws Exception
	{
		Properties Prop = new Properties();
		try{
			Prop.load(new FileInputStream("D:\\Preparation\\SeleniumAutomation\\SeleniumWorkSpace\\AmazonPOM\\src\\TestData\\testdata.properties"));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		String value = Prop.getProperty(keyName);
		return value;
			
	}
}
