package com.MyEcom.Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyEcom.base.BaseClass;

public class NewProductPage extends BaseClass
{
	public NewProductPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Search')]")
	WebElement searchPageHeading;
	
	@FindBy(xpath = "//i[@class='icon-th-list']")
	WebElement viewinlist;
	
	@FindBy(xpath = "//i[@class='icon-th-large']")
	WebElement viewingrid;
	
	@FindBy(xpath = "//img[@alt='Printed Dress']")
	WebElement dress;
	
	public String getSearchPageHeading() 
	{
		String pageHeading = driver.getTitle();
		return pageHeading;
	}	

}
