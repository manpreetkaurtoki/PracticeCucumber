@smoke
Feature: Test Login Cases



Background:

Given user is on xyz site
When user clicks on form auth
Then user should land on login page

@high
@Login
Scenario Outline:
Verify credentials
When user enters username "<username>"
And enter password "<password>"
And user clicks on Login button
Then user should see "<result>"

 Examples:
      | username  | password   			| result          |
      | admin     | admin123   			| failure         |
      | user1     | wrongpass  			| failure         |
      | tomsmith  | SuperSecretPassword!| success         |
      | testuser  | test123    			| failure         |