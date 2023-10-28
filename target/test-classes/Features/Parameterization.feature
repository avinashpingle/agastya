Feature: This features explains parameterization

Scenario: Passing parameter to scenario step
	Given I have 15 and 15
	When I add them
	Then check if the result is prime
	
#Scenario: Data table example
#	Given I have following pair of numbers:
#		|11|14|
#		|45|91|
#		|92|83|
#	When I add them
#	Then check if the result is prime
	
Scenario Outline: Data driven testing with cucumber
	Given I have <row_num>
	Then print the pincode
	
Examples:
	|row_num|
	|1|
	|2|
	|3|
	|4|
	|5|
	|6|
	
	
	
	
	
	
	
	
	