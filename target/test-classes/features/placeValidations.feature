Feature: Validating place APIs

Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
	Given Add Place Payload "<Name>" "<Language>" "<Address>"
	When user calls "AddPlaceAPI" with the Post http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	
Examples:
 | Name | Language | Address        |
 | Apple | IOS  | JP Nagar, Mysuru|
 | SAMSUNG | Spanish |Hannover |