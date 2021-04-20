package com.db.twitter.ui.pageobject;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.twitter.appsettings.TimeoutUtils;

public class EditProfilePageObject {
	
	public EditProfilePageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="description")
	private WebElement userBioField;
	
	@FindBy(name="location")
	private WebElement userLocationField;
	
	@FindBy(name="url")
	private WebElement userWebsiteField;
	
	@FindBy(xpath="//div[@aria-label='Add avatar photo']")
	private WebElement userProfilePicButton;
	
	@FindBy(xpath="//div[@data-testid='Profile_Save_Button']")
	private WebElement userProfileSaveButton;
	
	public void SetUserBioDetails(String bio)
	{
		TimeoutUtils.WaitforElementToBeAvailable(userBioField);
		userBioField.clear();
		userBioField.sendKeys(bio);
	}
	
	public void SetUserLocation(String location)
	{
		TimeoutUtils.WaitforElementToBeAvailable(userLocationField);
		userLocationField.clear();
		userLocationField.sendKeys(location);
	}
	
	public void SetUserWebSiteField(String website)
	{
		TimeoutUtils.WaitforElementToBeAvailable(userWebsiteField);
		userWebsiteField.clear();
		userWebsiteField.sendKeys(website);
	}
	
	public void SaveUpdates()
	{
		TimeoutUtils.WaitforElementToBeAvailable(userProfileSaveButton);
		userProfileSaveButton.click();
		TimeoutUtils.waitForInterval();
		
	}
	
	public void SetUserProfilePic(String path)
	{
		TimeoutUtils.WaitforElementToBeAvailable(userProfilePicButton);
		userProfilePicButton.click();
		TimeoutUtils.waitForInterval();
		UploadFile(path);
	}
	
	
	public void SetClipboardData(String string) {
			StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public  void UploadFile(String fileLocation) {
        try {
        	
            SetClipboardData(fileLocation);
          
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER); 
            By apply = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]");
            WebElement applyButton = TimeoutUtils.WaitforElementToBeAvailable(apply);
            //WebElement applyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]")));
    		applyButton.click();
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }
}
