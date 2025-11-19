Feature: Validating place APIs


# Tags are just written to practice
@AddPlace @place @smoke  
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
	Given Add Place Payload "<Name>" "<Language>" "<Address>"
	When user calls "AddPlaceAPI" with the "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_Id created maps to "<Name>" using "getPlaceAPI"
	
Examples:
 | Name | Language | Address        |
 | Apple | IOS  | JP Nagar, Mysuru|

@DeletePlace @name  @regresion
Scenario: Verify If Delete Place Functionality Is Working

	Given DeletePlace Payload
	When user calls "deletePlaceAPI" with the "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"