
@all
Feature: Login Functionality 

Registered user should be able to login to access account details.

Background:
Given User navigates to Login page

@login @valid_credentials @smoke @regression
Scenario Outline: Login with valid credentials
When User enters the valid email address "<email>"
And Enters valid password "<password>"
And Clicks on Login button
Then User should Login successfully.
Examples:
|email|				|password|
|va123@gmail.com|	|12345|
|venaagr@gmail.com|	|12345|
|agrve@gmail.com|	|12345|

@login @invalid_credentials @dev @smoke @regression
Scenario: Login with invalid credentials
When User enters the invalid email address 
And Enters invalid password "12345xyz"
And Clicks on Login button
Then User should not Login and get proper warning message.

@login @invalid_credentials @smoke @regression
Scenario: Login with valid email and invalid password
When User enters the valid email address "va123@gmail.com"
And Enters invalid password "12345xyz"
And Clicks on Login button
Then User should not Login and get proper warning message.

@login @invalid_credentials @smoke @wip @regression
Scenario: Login with invalid email and valid password
When User enters the invalid email address 
And Enters valid password "12345"
And Clicks on Login button
Then User should not Login and get proper warning message.

@login @smoke @regression @ignore @regression
Scenario: Login without providing credentials
When User does not enters any credentials
And Clicks on Login button
Then User should not Login and get proper warning message.