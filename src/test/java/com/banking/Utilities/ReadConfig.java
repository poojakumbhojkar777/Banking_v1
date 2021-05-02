package com.banking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {



	Properties prop;

	public ReadConfig()
	{
		File src=new File("./Configuration//Config.properties");
		try {

			FileInputStream fis=new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+ e.getMessage());
		}

	}

	public String getApplicationUrl()
	{
		String url=prop.getProperty("baseurl");
		return url;
	}
	public String getUsername()
	{
		String uname=prop.getProperty("Username");
		return uname;
	}

	public String getPassword()
	{
		String passwd=prop.getProperty("Password");
		return passwd;
	}
	public String getchromepath()
	{
		String chromepath=prop.getProperty("chromepath");
		return chromepath;
	}
}
