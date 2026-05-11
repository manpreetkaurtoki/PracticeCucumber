@tag
Feature: Test Login Cases


@high
@tag1
Scenario:
Verify that user can login to application with correct credentials
Given user is on xyz site
When user clicks on form auth
Then user should land on login page
When user enters username "tomsmit"
And enter password "SuperSecretPassword!"
And user clicks on Login button
Then user should be successfully logged in