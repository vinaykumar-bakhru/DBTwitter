package com.db.twitter.stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.db.twitter.appsettings.Setup;
import com.db.twitter.ui.pageobject.LandingPageObject;

import cucumber.api.java.After;

import org.apache.commons.io.FileUtils;

public class BackgroundStepDefs extends Setup{
	
	LandingPageObject landingPage;
	
	public BackgroundStepDefs()
	{
		landingPage = new LandingPageObject(driver);
	}

	@After
	public void EndofEachScenario(cucumber.api.Scenario scenario) throws IOException
	{
		if(scenario.getStatus().equals("failed"))
		{
			String fileName = scenario.getName();
			takeScreenshot(fileName);
			landingPage.LogoutFromTwitter();
			driver.close();
			
		}
		else
		{
			driver.close();
		}
	}
	
	private void takeScreenshot(String fileName) throws IOException
	{
		fileName = fileName.replaceAll("[/:?<>|\\\\]", " ");
		TakesScreenshot srcShot = (TakesScreenshot)driver;
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		String filePath = "/DBTwitterAutomation/target/";
		File destFile = new File(filePath);
		FileUtils.copyFile(srcFile, destFile);
	}
	
}
