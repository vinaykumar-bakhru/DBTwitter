Feature: Retriving The Tweets
  As a Twitter user,
  I want to retrive the tweets in an interval
  So that i can check the tweets

  @Tweets
  Scenario Outline: Navigating to tyhe Twitter Account
    Given I navigate to Twitter Login Screen
    When I Login to Twitter with <username> and <password>
    Then The Login is Successfull
    When I navigate to <account> account screen
    Then I retrive the tweets in the given Interval
    And I divide the Tweets in SubTweets with <count>
    And I Logout from Twitter

   Examples: 
      | username  	 | password 	 | account			| count |
      | @AutoDeutsch | Prepaid@12  | TOIIndiaNews | 50    |
