package com.MyEcom.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.ITestResult;
import java.io.IOException;
import com.MyEcom.Pom.IndexPagePom;
import com.MyEcom.Pom.NewProductPage;
import com.MyEcom.Pom.SignInPagePom;
import com.MyEcom.base.BaseClass;
import com.MyEcom.utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class IndexPageTest extends BaseClass
{
	IndexPagePom indexPagePom;
	SignInPagePom signInPagePom;
	NewProductPage productListingPom;
	SoftAssert softassert = new SoftAssert();
	
	ExtentReports extentReport;
	ExtentTest logger;
	
	@BeforeMethod
	public void generateExtentReport()
	{
		ExtentSparkReporter genrateReport = new ExtentSparkReporter(projectPath+"\\ExtentReport\\ExtentReport.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(genrateReport);
		
	}
	
	@AfterMethod
	public void flushReport()
	{
		extentReport.flush();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		loadApplication();
		driver.get(prop.getProperty("baseurl"));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, result.getName()+"Test case Fail");
			logger.log(Status.FAIL, result.getThrowable());
			logger.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenShot(driver, result.getName())).build());
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			logger.log(Status.SKIP, result.getName() + "Test case Skip");
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, result.getName() + "Test Case PASS");
		}
		
		driver.quit();
	}
	
	@Test
	public void validateLogo() 
	{
		logger = extentReport.createTest("validateLogo");
		indexPagePom = new IndexPagePom();
		boolean res = indexPagePom.validateLogo();
		Assert.assertTrue(res);
	}
	
	@Test
	public void ValidateTittle()
	{
		logger = extentReport.createTest("ValidateTittle");
		indexPagePom = new IndexPagePom();
		String title = indexPagePom.getTitleOfPage();
		Assert.assertEquals(title, "My Store");
		//System.out.println("Titele fof page = "+title);
	}
	
	
	@Test
	public void ClickOnSignIn() throws InterruptedException
	{
		logger = extentReport.createTest("ClickOnSignIn");
		indexPagePom = new IndexPagePom();
		indexPagePom.ClickOnSignIn();
		String pageHeading = signInPagePom.getPageHEading();
		Assert.assertEquals(pageHeading, "Login - My Store");
	}
	
	@Test
	public void SearchProduct()
	{
		logger = extentReport.createTest("SearchProduct");
		indexPagePom = new IndexPagePom();
		indexPagePom.SendTextToSearch();
		Assert.assertTrue(true);
	}
	
	@Test
	public void ValidateSearchButton()
	{
		logger = extentReport.createTest("ValidateSearchButton");
		indexPagePom = new IndexPagePom();
		indexPagePom.SendTextToSearch();
		indexPagePom.ClickOnSearch();	
	}

}
