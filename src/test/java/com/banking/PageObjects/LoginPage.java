package com.banking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver,this);
	}
	WebDriver lDriver;

	@FindBy(name="uid")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="btnLogin")
	WebElement login;

	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement Logout;

	

	public void setusername(String uname)
	{
		username.sendKeys(uname);
	}

	public void setpassword(String passwd)
	{
		password.sendKeys(passwd);
	}

	public void getlogin()
	{
		login.click();
	}
	public void getlogout()
	{
		Logout.click();
	}


}

