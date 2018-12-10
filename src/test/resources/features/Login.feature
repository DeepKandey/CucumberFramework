Feature: Login Feature 
	Verify if user is able to Login in to the site

Scenario Outline: Login as a authenticated user 
	Given user is on homepage 
	When user navigates to Login Page 
	And user enters "<username>" and "<password>" 
	Then success message is displayed 
	Examples: 
		|username|password|
		|deepak.rai21@yahoo.com|Rehan@91|
		|deepakggs@gmail.com|TeraNaam|