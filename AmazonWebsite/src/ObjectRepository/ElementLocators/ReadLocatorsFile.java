package ObjectRepository.ElementLocators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadLocatorsFile {

	public static String readLocators(String key){
		Properties prop = new Properties();
		FileInputStream stream;
		try {
			stream = new FileInputStream("D:\\Preparation\\SeleniumAutomation\\SeleniumWorkSpace\\AmazonWebsite\\src\\ObjectRepository\\ElementLocators\\locators.properties");
			prop.load(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = prop.getProperty(key);
		return value;
	}
}
