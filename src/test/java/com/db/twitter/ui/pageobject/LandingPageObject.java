package com.db.twitter.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.twitter.appsettings.TimeoutUtils;

public class LandingPageObject {
	
	private WebDriver driver;
	
	public LandingPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@aria-label='Profile']")
	private WebElement profileButton;

	@FindBy(xpath="//div[@aria-label='Account menu']")
	private WebElement userAccount;
	
	@FindBy(xpath="//a[@href='/logout']//div//div[@dir='auto']")
	private WebElement logoutLink;
	
	@FindBy(xpath="//div[@dir='auto']//span//span[contains(text(),'Log out')]")
	private WebElement logoutConfirmButton;
	
	@FindBy(xpath="//div/input[@data-testid='SearchBox_Search_Input']")
	private WebElement searchAccount;
	
	public boolean VerifyLoginIsSuccessful()
	{
		TimeoutUtils.WaitforElementToBeAvailable(userAccount);
		return true;
	}
	
	public void LogoutFromTwitter()
	{
		driver.navigate().refresh();
		TimeoutUtils.WaitforElementToBeAvailable(userAccount);
		userAccount.click();
		TimeoutUtils.WaitforElementToBeAvailable(logoutLink);
		logoutLink.click();
		TimeoutUtils.WaitforElementToBeAvailable(logoutConfirmButton);
		logoutConfirmButton.click();
	}
	
	public void OpenUserProfile() {
		TimeoutUtils.WaitforElementToBeAvailable(profileButton);
		profileButton.click();
	}
	
	public void NavigateToAccountPage(String account)
	{
		TimeoutUtils.WaitforElementToBeAvailable(searchAccount);
		searchAccount.clear();
		searchAccount.sendKeys("@"+ account + Keys.ENTER);
		TimeoutUtils.waitForInterval();
		By accountLink = By.xpath("//a[@href='/" + account+ "']");
		WebElement  twitterAccount = TimeoutUtils.WaitforElementToBeAvailable(accountLink);
		twitterAccount.click();
		TimeoutUtils.waitForInterval();
	}
}
