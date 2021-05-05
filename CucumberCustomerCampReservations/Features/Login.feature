Feature: validate login

Background: launch browser
Given Navigate to url


@smoke
Scenario: Perform Login
When I enter userName "vanivulisetti" and password "Samsum@1"
And I select Login button
Then User should be Logged in 

@test1 
Scenario Outline: Perform Login with multiple data
When I enter userName "<userName>" and password "<password>"
And I select Login button
Then User should be Logged in

Examples:
|userName|password|
|vanivulisetti|Samsum@1|
|vanikotipalli0001|Samsum@1|
|vanivulisetti03|Sampath@1|