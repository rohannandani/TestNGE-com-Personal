package com.MyEcom.Pom;

import org.apache.commons.math3.analysis.function.Sin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyEcom.base.BaseClass;

public class SignInPagePom extends BaseClass

{
	public SignInPagePom()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "email_create")
	WebElement signupnmailid;
	
	@FindBy(id = "SubmitCreate")
	WebElement creatbutton;
	
	@FindBy(id = "email")
	WebElement loginemailid;
	
	@FindBy(id = "passwd")
	WebElement loginpassword;
	
	@FindBy(id ="SubmitLogin")
	WebElement signinbutton;
	
	
	public String getPageHEading()
	{
		String pageHeading = driver.getTitle();
		return pageHeading;
	}
	
	
	public void setLoinData(String username, String password)
	{
		loginemailid.sendKeys(username);
		loginpassword.sendKeys(password);

	}
	
	public signUpPageDetails setSignupdata(String email) throws InterruptedException
	{
		signupnmailid.sendKeys(email);
		Thread.sleep(2000);
		creatbutton.click();
		return new signUpPageDetails();
		

		
	}
	
	
	
	
	
	

}
