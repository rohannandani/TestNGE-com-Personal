package com.MyEcom.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MyEcom.base.BaseClass;

import io.netty.handler.codec.http.multipart.FileUpload;

public class Utility extends BaseClass
{
	public void applyExplicitwait(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void applyFluentWait(WebDriver driver, final WebElement ele) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(Duration.ofSeconds(30)) 			
				.pollingEvery(Duration.ofSeconds(5)) 			
				.ignoring(NoSuchElementException.class);
		WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
				return ele;
			}
		});
	}
	
	public static String getScreenShot(WebDriver driver, String Name) throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyMMDDhmmss"));
		String des = projectPath + "//screenshot//"+Name+currentTime+" .png";
		File destinationFile = new File(des);
		FileUtils.copyDirectory(scr, destinationFile);
		return des;
	}

}
