package com.MyEcom.Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyEcom.base.BaseClass;

public class IndexPagePom extends BaseClass
{
	public IndexPagePom()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signin;
	
	@FindBy(id = "search_query_top")
	WebElement searchproduct;
	
	@FindBy(name = "submit_search")
	WebElement searchbutton;
	
	public boolean validateLogo() 
	{
		if(logo.isDisplayed()) 
		{
			System.out.println("logo is available");
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public String getTitleOfPage()
	{
		String getTitle = driver.getTitle();
		return getTitle;
		
	}
	
	public SignInPagePom ClickOnSignIn() throws InterruptedException
	{
		Thread.sleep(2000);
		signin.click();
		return new SignInPagePom();
	}
	
	public void SendTextToSearch()
	{
		searchproduct.sendKeys("Dress");
		searchproduct.getAttribute("value");
	}
	
	public NewProductPage ClickOnSearch()
	{
		searchbutton.click();
		return new NewProductPage();
	}
	
}
