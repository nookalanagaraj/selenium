package ObjectRepository.TestData;

public class GetTestJava {

	static ReadTestProperties readObj = new ReadTestProperties();
	public static String browserType = ReadTestProperties.getProperty("browserType");
	public static String URL = ReadTestProperties.getProperty("url");

}
