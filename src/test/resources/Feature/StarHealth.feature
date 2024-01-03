Feature: Phase End project

Scenario: Star health home page test

Given User open the chrome browser and starhealth application
When User  waits for the Welcome to Star Health pop-up and closes it
Then  validates the Star Health home page title using a JUnit assertion 
Then  clicks on the Buy Now button 
And User enters following details
| URL | FullName | PhNo | PIN   | Email |
| admin | admin | 9380756810 | 585326| admin@gmail.com|
| maya | admin | 9380756810 | 585326 | admin@gmail.com|
And User clicks on the Star Health logo 
Then Close all the browsers