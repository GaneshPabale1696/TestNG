package PropertiesPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFiles {
	
	Properties properties;
	
	String path="F:\\Projects\\TestNG-master\\TestNG-master\\src\\test\\java\\PropertiesPackage\\ConfigText.txt";

	public ReadConfigFiles()
	{
		properties=new Properties();
		try {
			FileInputStream fis=new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getURL()
	{
		String url=properties.getProperty("url");
		if(url!=null)
		{
			return url;
		} else
		{
			throw new RuntimeException("url not specified in config file.");
		}
	}
	
	public String getUserName()
	{
		String username=properties.getProperty("username");
		if(username!=null)
		{
			return username;
		} else
		{
			throw new RuntimeException("username is not specified in config file.");
		}
	}
	
	public String getPassword()
	{
		String pwd=properties.getProperty("password");
		if(pwd!=null)
		{
			return pwd;
		} else
		{
			throw new RuntimeException("pwd is not specified in config file.");
		}
	}
}
