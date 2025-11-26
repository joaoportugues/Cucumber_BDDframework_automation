@all
Feature: User Registration

Background:
Given User navigates to Account registration page

Scenario: Register with mandatory fields
When User enters below details in the fields
|firstName		|Venus|
|lastName		|A|
|telephone		|123456789|
|password		|12345|
And User select private policy field
And User clicks on Continue button
Then User account get created successfully

Scenario: Register with all fields
When User enters below details in the fields
|firstName		|Venus|
|lastName		|A|
|telephone		|123456789|
|password		|12345|
And User selects yes for newsletter option
And User select private policy field
And User clicks on Continue button
Then User account get created successfully

Scenario: Register without providing any  fields
When User does not enter any fields
And  User clicks on Continue button
Then Warning messages should be displayed under all the respective fields 

Scenario: Register with already existing email address
When User enters below details in the fields
|firstName		|Venus|
|lastName		|A|
|email			|va123999@gmail.com|
|telephone		|123456789|
|password		|12345|
And User selects yes for newsletter option
And User select private policy field
And User clicks on Continue button
Then Warning message about email address already exists