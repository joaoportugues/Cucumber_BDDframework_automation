@all
Feature: Search Functionality

# this symbol used to comments

Background:
Given User open the Application

@search @existing_product @smoke @regression
Scenario: Search for a existing product
When User enters the existing product into search field "HP"
And click on search button
Then the product should be displayed in search results

@search @non_existing_product @regression
Scenario: Search for a non existing product
When User enters the non existing product into search field "Honda"
And click on search button
Then Proper information message should be displayed

@search @no_product @smoke @regression
Scenario: Search without providing any product
When User does not enters anything into search field
And click on search button
Then Proper information message should be displayed