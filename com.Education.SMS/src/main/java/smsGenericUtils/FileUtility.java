package smsGenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


public class FileUtility
{
	public String getPropertyKeyValue(String key) throws Throwable
	{
		
		FileInputStream fileInputStream = new FileInputStream(IpathConstants.propertyFilePath);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String value = properties.getProperty(key);
		return value;
		
		
	}

}
