package com.banking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.PageObjects.LoginPage;
import com.banking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	
	
	@Test(dataProvider="LoginData")
	public void LoginTestDDT(String uname,String passwd)
	{
		LoginPage lp=new LoginPage(driver);
		driver.get(baseurl);
		lp.setusername(uname);
		logger.info("Username Entered");
		lp.setpassword(passwd);
		logger.info("Password Entered");
		lp.getlogin();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.getlogout();
			logger.info("Clicked on Log out");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			
		}
	}
	
	public boolean isAlertPresent()
	{
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [] [] getData() throws IOException
	{
		//C:\Users\Pooja\eclipse-workspace\Banking_v1_Branch\src\test\java\com\banking\TestData
		String path=System.getProperty("user.dir")+"/src/test/java/com/banking/TestData/LoginTestData.xlsx";
		int rowNum=XLUtils.getRowCount(path, "sheet1");
		int colCount=XLUtils.getCoulmnCount(path, "sheet1", 1);
		String LoginData[][]=new String [rowNum] [colCount];
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				LoginData[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		
		
		return LoginData;
		
	}
	
	
	

}
