Feature: Validating place APIs

Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
	Given Add Place Payload "<Name>" "<Language>" "<Address>"
	When user calls "AddPlaceAPI" with the "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_Id created maps to "<Name>" using "getplaceAPI"
	
Examples:
 | Name | Language | Address        |
 | Apple | IOS  | JP Nagar, Mysuru|

 
Scenario: Verify If Delete Place Functionality Is Working

	Given 