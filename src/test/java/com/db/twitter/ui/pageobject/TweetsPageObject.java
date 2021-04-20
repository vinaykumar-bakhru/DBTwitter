package com.db.twitter.ui.pageobject;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.db.twitter.appsettings.Setup;
import com.db.twitter.appsettings.TimeoutUtils;

public class TweetsPageObject {
	
	private List<String> tweetList= new ArrayList<String>();
	
	public TweetsPageObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@data-testid='tweet']")
	private List<WebElement> listTweets;
		
	public List<String> GetTweetsInInterval()
	{
		long tweetDuration = Long.parseLong(Setup.configProperty.getProperty("tweetDuration"));
		By list = By.xpath("//div[@data-testid='tweet']");
		List<WebElement> searchlist = TimeoutUtils.WaitforAllElementToBeAvailable(list);
		TimeoutUtils.ScrollWindow();
		searchlist = TimeoutUtils.WaitforAllElementToBeAvailable(list);
		
		String tweets = "";
				
		for (WebElement element : searchlist) {
			WebElement time = element.findElement(By.xpath(".//div[2]/div/div/div/div/a/time"));
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		    Date date;
			try {
				String tweetDateTime = time.getAttribute("datetime");
				date = sdf.parse(tweetDateTime);
				System.out.println(date);
				sdf.setTimeZone(TimeZone.getTimeZone("IST"));
				Date currentdate = new Date();
				currentdate = sdf.parse(sdf.format(currentdate)); 
				long diff = (currentdate.getTime() - date.getTime())/(60*1000)%60;
				if(diff<tweetDuration)
				{
					List<WebElement> spans = element.findElements(By.xpath(".//div/span"));
					tweets = "";
					for(WebElement span : spans) {
						tweets = tweets + " " + span.getText(); 
					}
					tweetList.add(tweets);
					
				}
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    
		}
		
		return tweetList;
	}
	
	public HashMap<Integer, ArrayList<String>> SplitTweetAsPerCount(int characterCount)
	{
		HashMap<Integer, ArrayList<String>> smallTweets = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> eachTweetBreakUp;
		
		int count =1;
		for(String tweet : tweetList)
		{
			eachTweetBreakUp = new ArrayList<String>();
			eachTweetBreakUp = SplitTweetsIntoSpecifyCharacter(tweet, characterCount);
			smallTweets.put(count, eachTweetBreakUp);
			count++;
		}
		
		return smallTweets;
	}
	
	private ArrayList<String> SplitTweetsIntoSpecifyCharacter(String twt,int charcterCount){ 
		
		ArrayList<String> splitTweets = new ArrayList<String>();
		StringBuffer tweet = new StringBuffer(twt);
		if(tweet.length() > charcterCount) {
			List<String> ret = new ArrayList<String>((tweet.length() + charcterCount - 1) / charcterCount);
		    for (int start = 0; start < tweet.length(); start += charcterCount) {
		        ret.add(tweet.substring(start, Math.min(tweet.length(), start + charcterCount)));
		    }
		    for (String item : ret) {
		    	splitTweets.add(item);
			}
		}
		else {
			splitTweets.add(tweet.toString());
		}
		return splitTweets;
	}

}
