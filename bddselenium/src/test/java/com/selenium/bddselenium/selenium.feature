Feature: Calculator addition feature
@selenium 
Scenario: Addition calculator

	Given navigate to calculator page 
	When user enter two integer 5 and 6
	Then answer should be 11