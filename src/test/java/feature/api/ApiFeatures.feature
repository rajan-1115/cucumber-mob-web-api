Feature: Verify api

Scenario: Case1
Given User has hit the api
Then Verify status code is 200
Then Verify the value of "first_name" for id "10" is "Byron"




