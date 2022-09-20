package com.MyEcom.Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.MyEcom.base.BaseClass;

public class SignInPagemanualpom extends BaseClass 
{
	public SignInPagemanualpom()
		{
			PageFactory.initElements(driver, this);
		}
		
	@FindBy(id = "email_create")
	WebElement loinmailid;
	
	@FindBy(id = "SubmitCreate")
	WebElement acountcreatbutton;
	
	@FindBy(id = "id_gender1")
	WebElement title;
	
	@FindBy(id = "customer_firstname")
	WebElement fname;
	
	@FindBy(id = "customer_lastname")
	WebElement lname;
	
	@FindBy(xpath = "//input[@id ='email']")
	WebElement emailid;
	
	@FindBy(xpath = "//input[@id ='passwd']")
	WebElement password;
	
	@FindBy(xpath = "//select[@id ='days']")
	WebElement date;
	
	@FindBy(xpath = "//select[@id ='months']")
	WebElement month;
	
	@FindBy(xpath = "//select[@id ='years']")
	WebElement year;
	
	@FindBy(id = "extends")
	WebElement loginemailid;
	
	@FindBy(id = "passwd")
	WebElement loginpassword;
	
	@FindBy(id ="SubmitLogin")
	WebElement signinbutton;
	
	public void loinmailid() throws InterruptedException
	{
		loinmailid.sendKeys("sonupatil7058@gmail.com");
		Thread.sleep(2000);
		acountcreatbutton.click();
	
	}
	
	public void acountcreatbutton()
	{
		title.click();
		fname.sendKeys("Rohan");
		lname.sendKeys("Patil");
		password.sendKeys("Abc@123");
	}
	
	public void dob()
	{
		Select dates = new Select(date);
		dates.selectByVisibleText("25");
		
		Select months = new Select(month);
		months.selectByIndex(6);
		
		Select years = new Select(year);
		years.selectByVisibleText("2011");
		
	}
		
}
