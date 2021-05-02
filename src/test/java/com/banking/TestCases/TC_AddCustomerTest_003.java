package com.banking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.PageObjects.AddCustomer;
import com.banking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(Username);
		lp.setpassword(Password);
		lp.getlogin();
		
		AddCustomer addcust= new AddCustomer(driver);
		
		addcust.clickNewCustomer();
		addcust.setName("Rahul");
		addcust.setGender();
		addcust.setDOB("02", "03", "1995");
		addcust.setAddress("abc");
		addcust.setCity("pune");
		addcust.setState("Maharashtra");
		addcust.setPIN(123467);
		addcust.setMobNo("9874587458");
		String email=randomString()+"@gamil.com";
		addcust.setEmail(email);
		addcust.setPassword("Rahul@123");
		addcust.clickSubmit();
		
		Thread.sleep(3000);
		boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			logger.info("Customer Registered Successfully");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.warn("Test case failed");
			CatptureScreenshot(driver,"addCustomer");
		}
		
		
		
	}

	
}
