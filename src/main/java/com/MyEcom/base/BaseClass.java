package com.MyEcom.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.BeforeTest;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	public static String projectPath = System.getProperty("user.dir");
	
	public void loadApplication() throws InterruptedException
	{
		
		String browser = (String) prop.get("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			driver = new ChromeDriver(); 
		
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", projectPath+"//drivers//msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
			driver = (WebDriver) new FirefoxDriver();
		}
		
	driver.get(prop.getProperty("baseurl"));
	Thread.sleep(2000);
	
	}
	
	@BeforeTest
	public void readProp() throws IOException
	{
		FileInputStream fls = new FileInputStream(projectPath+"//Config/config.properties");
		prop =  new Properties();
		prop.load(fls);
		
	}

}
