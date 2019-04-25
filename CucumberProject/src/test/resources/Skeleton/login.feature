Feature: Login Feature
Scenario Outline:Valid User Scenario
Given The URL of TestMe APP
When user enters <username> as username
And user enters <password> as password
Then user is in <page>
Examples:
|username|password|page|
|Lalitha|Password123|Home|
|admin|Password456|Admin Home|

@invalid
Scenario: Invalid scenario
    Given The URL of TestMe APP
    When user enters invalid data
    |deva|Password123|
    |Lalitha|Lava|
    |Lalitha1|Lava1|
    Then user is in login page
    |abc|
    |dce|
    |vgt|





#Scenario: Valid Admin User Scenario
#Given The URL of TestMe APP
#When user enters "admin" as username
#And user enters "Password456" as password
#Then user is in home page
