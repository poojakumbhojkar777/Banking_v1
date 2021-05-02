package com.banking.TestCases;

import java.io.File;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.Utilities.ReadConfig;
public class BaseClass {
	


	ReadConfig readconfig=new ReadConfig();
	
	public String baseurl=readconfig.getApplicationUrl();
	public String Username=readconfig.getUsername();
	public String Password=readconfig.getPassword();
	public String Title="Guru99 Bank Manager HomePage123";
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		if(br.equals("chrome"))
	{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver1\\chromedriver.exe\\");
	
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		logger=Logger.getLogger("Banking");
		PropertyConfigurator.configure("Log4j.properties");
		driver.get(baseurl);
	}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe\\");
			
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
	
	}
	
	@AfterClass
	public void tierDown()
	{
		driver.quit();
	}
	
	public void CatptureScreenshot(WebDriver driver, String tname) throws IOException
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source= ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+ "/Screenshots/"+tname+".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
	
	
	}

	public static String randomString()
	{
		 byte[] array = new byte[7]; // length is bounded by 7
		    new Random().nextBytes(array);
		    String generatedString = new String(array, Charset.forName("UTF-8"));

		    return (generatedString);
	}
}
