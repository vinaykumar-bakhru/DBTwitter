package com.db.twitter.appsettings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Setup {
	
	public static WebDriver driver;
	public static Properties configProperty = new Properties();
	
	private void getTestBase()
	{
		String filePath = "src/test/resources/Config/";
		String fileName = "config.properties";
		String baseFilePath = filePath + fileName;
		
		try {
			FileInputStream input = new FileInputStream(baseFilePath);
			configProperty.load(input);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}	 
	
	public void initialise()
	{
		getTestBase();
		String browser = configProperty.getProperty("browser");
		switch(browser)
		{
			case "CHROME":
				initialiseChromeBrowser();
				break;
		}
	}
	
	public void initialiseChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/config/ChromeDrivers/chromedriver.exe");
		driver = new ChromeDriver();		
	}
	
	public void navigatetoUrl(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}

}
