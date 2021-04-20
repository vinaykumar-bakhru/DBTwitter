Feature: Twitter Profile Update Feature
  As A Twitter User
  I want to Check the Profile Update Functionality
  So That I can update the Profile successfully

  @ProfileUpdates
  Scenario Outline: Validating Profile Updates on Twitter
    Given I navigate to Twitter Login Screen
    When I Login to Twitter with <username> and <password>
    Then The Login is Successfull
    And I navigate to User Profile Screen
    And I navigate to Edit Profile Screen
    When I set Bio for the user as <Bio>
    And I set Location for the user as <Location>
    And I set WebSite for the user as <Website>
    And I save the updates
    Then I check the updated details as <Bio>, <Location> and <Website>
    And I Logout from Twitter

    Examples: 
      | username  	 | password 	 | Bio											| Location | Website     |
      | @AutoDeutsch | Prepaid@12  | Selenium Automation user | Pune		 | twitter.com |
      
      
  @ProfilePicUpdates
  Scenario Outline: Validating Profile Pic Updates on Twitter
    Given I navigate to Twitter Login Screen
    When I Login to Twitter with <username> and <password>
    Then The Login is Successfull
    And I navigate to User Profile Screen
    And I navigate to Edit Profile Screen
    When I update the User Profile Pic from path <path>
    And I save the updates
    And I Logout from Twitter
    
    Examples: 
      | username  	 | password 	 | path									|
      | @AutoDeutsch | Prepaid@12  | D:\\ProfilePhoto.jpg |
    
    
