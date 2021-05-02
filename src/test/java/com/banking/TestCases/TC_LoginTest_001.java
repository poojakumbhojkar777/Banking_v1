package com.banking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	

	@Test
	public void LoginTest() throws IOException
	{
		
		driver.get(baseurl);
		LoginPage L1=new LoginPage(driver);
		L1.setusername(Username);
		logger.info("Entered Username");
		L1.setpassword(Password);
		
	logger.info("Entered password");
		L1.getlogin();
		String ActualTitle=driver.getTitle();
		if(ActualTitle.equals(Title))
		{
			Assert.assertTrue(true);
			logger.info("Test Passed");
			
		}
		else
		{
			CatptureScreenshot(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Test Failed");
		}
		
		
	}
	


}
