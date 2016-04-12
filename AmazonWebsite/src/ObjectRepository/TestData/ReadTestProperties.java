package ObjectRepository.TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadTestProperties {

	public static String getProperty(String keyName)
	{
		Properties Prop = new Properties();
		try{
			Prop.load(new FileInputStream("D:\\Preparation\\SeleniumAutomation\\SeleniumWorkSpace\\AmazonWebsite\\src\\ObjectRepository\\TestData\\testdata.properties"));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		String value = Prop.getProperty(keyName);
		return value;
			
	}
}
