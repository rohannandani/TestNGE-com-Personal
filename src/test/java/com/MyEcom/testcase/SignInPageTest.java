package com.MyEcom.testcase;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;


import com.MyEcom.Pom.IndexPagePom;
import com.MyEcom.Pom.SignInPagePom;
import com.MyEcom.Pom.signUpPageDetails;
import com.MyEcom.base.BaseClass;
import com.MyEcom.utility.ExcelSheetHandle;
import com.MyEcom.utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SignInPageTest extends BaseClass
{
	ExcelSheetHandle data = new ExcelSheetHandle();
	SignInPagePom signInPagePom;
	IndexPagePom indexPagePom;
	signUpPageDetails signuppagedetails = new signUpPageDetails();
	
	ExtentReports extentReports;
	ExtentTest logger;
	
	public SignInPageTest()
	{	// TODO Auto-generated constructor stub
	
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		loadApplication();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}

	@Test
	public void login() throws FileNotFoundException, InterruptedException 
	{
		//data.getSheet(fis,"login")
		Sheet sh = ExcelSheetHandle.getSheet(ExcelSheetHandle.getexcelfile(), "login");
		Map<String, Object> logindata = data.getExcelSheetData(sh);
		IndexPagePom indexPagePom = new IndexPagePom();
		signInPagePom = indexPagePom.ClickOnSignIn();
		signInPagePom.setLoinData((String)logindata.get("emailid"), (String)logindata.get("password"));
		Thread.sleep(3000);
	}
	
	@Test
	public void signup() throws FileNotFoundException, InterruptedException
	{
		Sheet sh = data.getSheet(data.getexcelfile(), "signin");
		String signupdata = data.getSingleStringValue(sh, 1, 0);
		IndexPagePom indexPagePom = new IndexPagePom();
		signInPagePom = indexPagePom.ClickOnSignIn();
		signInPagePom.setSignupdata(signupdata);
		Thread.sleep(5000);
	}
	
	
	@Test
	public void signUpDetalis() throws FileNotFoundException, InterruptedException
	{
		signup();
		Thread.sleep(2000);
		Sheet sh = data.getSheet(data.getexcelfile(), "signin");
		Map<String, Object> signindata = data.getExcelSheetData(sh);
		signUpPageDetails signuppagedetails = new signUpPageDetails();
		signuppagedetails.titilemr();
		signuppagedetails.getsignUpdata((String)signindata.get("fname"),(String)signindata.get("lname"), (String)signindata.get("passward"), 
										(String)signindata.get("address"), (String)signindata.get("city"), (String)signindata.get("zip"),
										(String)signindata.get("monum"));
		Thread.sleep(2000);
		//signuppagedetails.getpinandmobile();
		signuppagedetails.dropdowin();
		Thread.sleep(9000);
		}
	
	
}
