package com.db.twitter.appsettings;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeoutUtils extends Setup{
	
	private static WebDriverWait wait;
	
	public static WebElement WaitforElementToBeAvailable(WebElement element)
	{
		long duration = Long.parseLong(Setup.configProperty.getProperty("timeoutduration"));
		wait = new WebDriverWait(driver, duration);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public static WebElement WaitforElementToBeAvailable(By obj)
	{
		long duration = Long.parseLong(Setup.configProperty.getProperty("timeoutduration"));
		wait = new WebDriverWait(driver, duration);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(obj));
		return element;
	}
	
	public static List<WebElement> WaitforAllElementToBeAvailable(By obj)
	{
		long duration = Long.parseLong(Setup.configProperty.getProperty("timeoutduration"));
		wait = new WebDriverWait(driver, duration);
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj));
		return element;
	}
	
	public static void waitForInterval()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void ScrollWindow()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
	}

}
