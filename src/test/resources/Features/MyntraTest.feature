Feature: Scenarios mentioned in this file will test the search component for different products

Scenario: Verify search results for Sneakers
	Given Application is launched completely
	When User searches Sneakers in search component
	Then All results must contain Sneakers word in the product title
	


