@tag
Feature: Test Login Cases

@tag1
Scenario:
Verify that user can login to application with correct credentials
Given Chrome browser is opened
And user is on xyz site
When user clicks on Login link
Then user should land on login page
When user enters username "Manpreet"
And enter password "Test123"
And user clicks on Sign In
Then user should be successfully logged in