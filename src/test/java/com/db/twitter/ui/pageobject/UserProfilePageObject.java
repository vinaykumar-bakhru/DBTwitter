package com.db.twitter.ui.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.twitter.appsettings.TimeoutUtils;

public class UserProfilePageObject {

	public UserProfilePageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/settings/profile']")
	private WebElement editProfileButton;
	
	@FindBy(xpath="//div[@data-testid='UserDescription']/span")
	private WebElement userBioField;
	
	@FindBy(xpath="//div[@data-testid='UserProfileHeader_Items']/span/span/span")
	private WebElement userLocationField;
	
	@FindBy(xpath="//div[@data-testid='UserProfileHeader_Items']/a")
	private WebElement userWebsiteField;
	
	public void EditUserProfile()
	{
		TimeoutUtils.WaitforElementToBeAvailable(editProfileButton);
		editProfileButton.click();
	}
	
	public String GetUserBio()
	{
		TimeoutUtils.WaitforElementToBeAvailable(userBioField); 
		return userBioField.getText();
	}
	
	public String GetUserLocation()
	{
		TimeoutUtils.WaitforElementToBeAvailable(userLocationField); 
		return userLocationField.getText();
	}
	
	public String GetUserWebSite()
	{
		TimeoutUtils.WaitforElementToBeAvailable(userWebsiteField); 
		return userWebsiteField.getText();
	}
}
