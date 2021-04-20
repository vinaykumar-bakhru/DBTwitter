package com.db.twitter.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.db.twitter.appsettings.Setup;
import com.db.twitter.ui.pageobject.LandingPageObject;
import com.db.twitter.ui.pageobject.TweetsPageObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TweetsSetpDefs extends Setup{
	
	LandingPageObject landingPage;
	TweetsPageObject tweetsPage;
	
	public TweetsSetpDefs()
	{
		landingPage = new LandingPageObject(driver);
		tweetsPage = new TweetsPageObject(driver);
	}
	
	
	@When("^I navigate to (.*) account screen$")
	public void I_navigate_to_account_screen(String account)
	{
		landingPage.NavigateToAccountPage(account);
	}
	
	@Then("^I retrive the tweets in the given Interval$")
	public void I_retrive_the_tweets_in_given_interval()
	{
		List<String> tweets = tweetsPage.GetTweetsInInterval();
		for (String item : tweets) {
			System.out.println(item);
		}
	}
	
	@And("^I divide the Tweets in SubTweets with (.*)$")
	public void I_retrive_the_tweets_in_subtweets_with(String characterCount)
	{
		int count = Integer.parseInt(characterCount);
		HashMap<Integer, ArrayList<String>> list = tweetsPage.SplitTweetAsPerCount(count);
		
		for (Map.Entry<Integer, ArrayList<String>> item : list.entrySet()) {
			System.out.println("Tweet " + item.getKey() + " :-");
			for (String iterable_element : item.getValue()) {
				System.out.println(iterable_element);
			}
			System.out.println("-------------------------------------");
		}
	}

}
