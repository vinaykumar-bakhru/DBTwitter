package com.db.twitter.ui.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.twitter.appsettings.Setup;
import com.db.twitter.appsettings.TimeoutUtils;

public class LoginPageObject {
	
	public LoginPageObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="session[username_or_email]")
	private WebElement usernameField;
	
	@FindBy(name="session[password]")
	private WebElement passwordField;
	
	@FindBy(xpath="//div[@data-testid='LoginForm_Login_Button']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[contains(text(),'There was unusual login activity on your account. ')]")
	private WebElement errorMessage;
	
	public void LoginToTwitter(String username, String password)
	{
		TimeoutUtils.WaitforElementToBeAvailable(usernameField);
		TimeoutUtils.WaitforElementToBeAvailable(passwordField);
		
		usernameField.clear();
		usernameField.sendKeys(username);
		
		passwordField.clear();
		passwordField.sendKeys(password);
		
		loginButton.click();
	}
	
	public String VerifyErrorMessage() 
	{
		TimeoutUtils.WaitforElementToBeAvailable(errorMessage);
		String actualMessage = errorMessage.getText();
		return actualMessage;
	}
	
	
}
