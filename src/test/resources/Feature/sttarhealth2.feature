@all
Feature: Phase End project

Scenario: Star health home page test

Given User open the chrome browser and starhealth application
When User  waits for the Welcome to Star Health pop-up and closes it
Then  validates the Star Health home page title using a JUnit assertion 
Then  clicks on the Buy Now button 
And User enters following details
| FullName | PhNo | PIN |
| admin | 9380756810 | 585326 |
| maya | 9380756810 | 585326 | 
And  User clicks on I need health insurance from the drop-down menu and select plan
And Validate the user mobile number
And User clicks on the Star Health logo 
And Close all the browsers