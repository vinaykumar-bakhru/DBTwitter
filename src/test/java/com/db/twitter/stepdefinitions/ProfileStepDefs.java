package com.db.twitter.stepdefinitions;

import static org.junit.Assert.assertEquals;

import com.db.twitter.appsettings.Setup;
import com.db.twitter.ui.pageobject.EditProfilePageObject;
import com.db.twitter.ui.pageobject.UserProfilePageObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProfileStepDefs extends Setup{
	
	UserProfilePageObject userProfile;
	EditProfilePageObject editProfile;

	public ProfileStepDefs()
	{
		userProfile = new UserProfilePageObject(driver);
		editProfile = new EditProfilePageObject(driver);
	}
	
	@And("^I navigate to Edit Profile Screen$")
	public void I_navigate_to_edit_profile_screen()
	{
		userProfile.EditUserProfile();
	}
	
	@When("^I set Bio for the user as (.*)$")
	public void I_set_bio_for_the_user_as(String bio)
	{
		editProfile.SetUserBioDetails(bio);
	}
	
	@When("^I set Location for the user as (.*)$")
	public void I_set_location_for_the_user_as(String location)
	{
		editProfile.SetUserLocation(location);
	}
	
	@When("^I set WebSite for the user as (.*)$")
	public void I_set_website_for_the_user_as(String website)
	{
		editProfile.SetUserWebSiteField(website);
	}
	
	@And("^I save the updates$")
	public void I_save_the_updates()
	{
		editProfile.SaveUpdates();
	}
	
	@Then("^I check the updated details as (.*), (.*) and (.*)$")
	public void I_check_the_updated_details_as(String bio, String location, String website)
	{
		String actualBio = userProfile.GetUserBio();
		String actualLocation = userProfile.GetUserLocation();
		String actualWebSite = userProfile.GetUserWebSite();
		
		assertEquals("The Bio Details do not match", bio, actualBio);
		assertEquals("The Location Details do not match", location, actualLocation);
		assertEquals("The WebSite Details do not match", website, actualWebSite);
	}
	
	@When("^I update the User Profile Pic from path (.*)$")
	public void I_update_the_user_profile_pic(String path)
	{
		editProfile.SetUserProfilePic(path);
	}
	
}
