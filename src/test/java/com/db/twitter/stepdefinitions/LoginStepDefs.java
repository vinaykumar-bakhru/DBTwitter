package com.db.twitter.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.db.twitter.appsettings.Setup;
import com.db.twitter.ui.pageobject.LandingPageObject;
import com.db.twitter.ui.pageobject.LoginPageObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefs extends Setup{
	
	LoginPageObject loginPage;
	LandingPageObject landingPage;
	
	public LoginStepDefs()
	{
		initialise();
		loginPage = new LoginPageObject(driver);
		landingPage = new LandingPageObject(driver);
	}
	
	@Given("^I navigate to Twitter Login Screen$")
	public void I_navigate_to_Twitter_login()
	{
		String url = Setup.configProperty.getProperty("url");
		navigatetoUrl(url);
	}
	
	@And("^I navigate to User Profile Screen$")
	public void I_navigate_to_user_profile_screen()
	{
		landingPage.OpenUserProfile();
	}
	
	@When("^I Login to Twitter with (.*) and (.*)$")
	public void I_login_to_twitter_with(String username, String password)
	{
		loginPage.LoginToTwitter(username, password);
	}
	
	@Then("^An Error Message is displayed$")
	public void an_error_message_is_displayed()
	{
		String expectedMessage = Setup.configProperty.getProperty("loginErrorMessage");
		String actualMessage = loginPage.VerifyErrorMessage();
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Then("^The Login is Successfull$")
	public void the_login_is_successful()
	{
		assertTrue(landingPage.VerifyLoginIsSuccessful());
	}
	
	@And("^I Logout from Twitter$")
	public void I_logout_from_twitter()
	{
		landingPage.LogoutFromTwitter();
	}

}
