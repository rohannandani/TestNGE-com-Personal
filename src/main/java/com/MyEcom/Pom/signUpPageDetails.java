package com.MyEcom.Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.MyEcom.base.BaseClass;

public class signUpPageDetails extends BaseClass
{
	public signUpPageDetails()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "id_gender1")
	WebElement title;
	
	@FindBy(id = "customer_firstname")
	WebElement fname;
	
	@FindBy(id = "customer_lastname")
	WebElement lname;
	
	@FindBy(xpath = "//input[@id ='email']")
	WebElement emailid;
	
	@FindBy(xpath = "//input[@id ='passwd']")
	WebElement passward;
	
	@FindBy(xpath = "//select[@id ='days']")
	WebElement date;
	
	@FindBy(xpath = "//select[@id ='months']")
	WebElement month;
	
	@FindBy(xpath = "//select[@id ='years']")
	WebElement year;
	
	@FindBy(id = "address1")
	WebElement address1;
	
	@FindBy(id = "city")
	WebElement gcity;
	
	@FindBy(id = "id_state") //dropdown
	WebElement gstate;
	
	@FindBy(id = "postcode")
	WebElement  gzipcode;
	
	@FindBy(id = "phone_mobile")
	WebElement gmnumber;
	
	@FindBy(id = "submitAccount")
	WebElement resister;
	

	
	public void titilemr()
	{
		title.click();
	}
	
	public void getsignUpdata(String Name, String LName, String pass, String add, String city, String zips, String mobile) throws InterruptedException
	{
		fname.sendKeys(Name);
		lname.sendKeys(LName);
		passward.sendKeys(pass);
		address1.sendKeys(add);
		gcity.sendKeys(city);
		gzipcode.sendKeys(zips);
		gmnumber.sendKeys(mobile);
		
	}
	
	/*public void getpinandmobile()
	{
		gzipcode.sendKeys("416102");
		gmnumber.sendKeys("785694136");
		
	}*/
	
	public void dropdowin()
	{
		Select days = new Select(date);
		days.selectByValue("22");
		
		Select months = new Select(month);
		months.selectByValue("5");
		
		Select years = new Select(year);
		years.selectByValue("1998");
		
		Select state = new Select(gstate);
		state.selectByVisibleText("Indiana");
		
	}
}
