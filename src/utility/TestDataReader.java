package utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//TestDataReader class - reads the properties file and stores them into static variables
public class TestDataReader 
{
	public static String blockingPageUrl;
	public static String fullPathFilter;
	public static String partialPathFilter;
	public static String wildCardFilter;
	public static String dynamicFilter;
	public static String deepDomainsFilter;
	public static String commandtoAddFilter;
	
	//Reads data from the properties file and assigns values to the static variables
	public static void readTestData() throws IOException
	{
		String path = System.getProperty("user.dir");
		String propertiesPath = path+ "/src/utility/TestData.properties";
		FileReader fr = new FileReader(propertiesPath);
		Properties p = new Properties();
		p.load(fr);
		blockingPageUrl = p.getProperty("blockingPageUrl");
		fullPathFilter = p.getProperty("fullPathFilter");
		partialPathFilter = p.getProperty("partialPathFilter");
		wildCardFilter = p.getProperty("wildCardFilter");
		dynamicFilter = p.getProperty("dynamicFilter");
		deepDomainsFilter = p.getProperty("deepDomainsFilter");	
		commandtoAddFilter = p.getProperty("commandtoAddFilter");
	}
}
