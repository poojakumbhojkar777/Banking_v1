package com.banking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

	WebDriver ldriver;
	
	public AddCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	private WebElement NewCustomer;
	
	@FindBy(name="name")
	WebElement CustomerName;
	
	@FindBy(name="rad1")
	WebElement Gender;
	
	@FindBy(id="dob")
	WebElement DOB;
	
	@FindBy(name="addr")
	WebElement Address;
	
	@FindBy(name="city")
	WebElement City;
	
	@FindBy(name="state")
	WebElement State;
	
	@FindBy(name="pinno")
	WebElement PIN;
	
	@FindBy(name="telephoneno")
	WebElement MobNo;
	
	@FindBy(name="emailid")
	WebElement Email;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="sub")
	WebElement Submit;
	
	@FindBy(name="res")
	WebElement Reset;
	
	public void clickNewCustomer()
	{
		NewCustomer.click();
	}
	
	public void setName(String cname)
	{
		CustomerName.sendKeys(cname);
	}
	
	public void setGender()
	{
		Gender.click();
	}
	
	public void setDOB(String mm,String dd,String yy)
	{
		DOB.sendKeys(mm);
		DOB.sendKeys(dd);
		DOB.sendKeys(yy);
		
	}
	public void setAddress(String addr)
	{
		Address.sendKeys(addr);
	}
	
	public void setCity(String city)
	{
		City.sendKeys(city);
	}
	
	public void setState(String state)
	{
		State.sendKeys(state);
	}
	
	public void setPIN(int pin)
	{
		PIN.sendKeys(String.valueOf(pin));
	}
	
	public void setMobNo(String mobno)
	{
		MobNo.sendKeys(mobno);
	}
	
	public void setEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void setPassword(String passwd)
	{
		Password.sendKeys(passwd);
	}
	
	public void clickSubmit()
	{
		Submit.click();
	}
	
	public void clickReset()
	{
		Reset.click();
	}
}
