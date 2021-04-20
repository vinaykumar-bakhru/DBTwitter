Feature: Title of your feature
  AS a Twitter User
  I want to Test Twitter Login Functionality
  So That I can login to Twitter Successfully

  @Login
  Scenario Outline: Invalid Credentails gives an Error Message
    Given I navigate to Twitter Login Screen
    When I Login to Twitter with <username> and <password>
    Then An Error Message is displayed
    

    Examples: 
      | username  	| password 	 |
      | abc@xyz.com | password12 | 
      
      
  @Login
  Scenario Outline: Valid Credentails Have a Successfull login
    Given I navigate to Twitter Login Screen
    When I Login to Twitter with <username> and <password>
    Then The Login is Successfull
    And I Logout from Twitter
    

    Examples: 
      | username  	 | password 	 |
      | @AutoDeutsch | Prepaid@12  | 
