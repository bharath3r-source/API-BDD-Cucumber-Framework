package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import pojo.Addplace;
import pojo.GetLocation;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.response.Response;

public class StepDefination extends Utils{

	RequestSpecification req;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data=new TestDataBuild();
	
	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String Name, String Language, String Address)  throws IOException {
		
		req=given().spec(requestSpecification()).body(data.addPlacePayLoad(Name, Language, Address));
			
	}

	@When("user calls {string} with the {string} http request")
	public void user_calls_with_the_http_request(String resource, String method) {
		
		APIResources  resourceAPI=APIResources.valueOf(resource);  // to initialize the enum constant - valueof will convert string into enum constant
		
		
		if (method.equalsIgnoreCase("POST"))
		{
			System.out.println(resourceAPI.getResource());
			response=req.when().post(resourceAPI.getResource());
			
		}else if (method.equalsIgnoreCase("GET"))
		{
			System.out.println(resourceAPI.getResource());
			response=req.when().get(resourceAPI.getResource());
		}
		
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String Keyvalue, String Expectedvalue) {
		
			assertEquals(getJsonPath(response,Keyvalue),Expectedvalue);
			
	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String ExpectedName, String place) throws IOException {
	    
		String Place_ID=getJsonPath(response, "place_id");
		APIResources  resourceAPI=APIResources.valueOf("getPlaceAPI");
		req=given().spec(requestSpecification()).queryParam("place_id", Place_ID);
		user_calls_with_the_http_request("getPlaceAPI", "GET");
		
		String ActualName=getJsonPath(response,"name");
		
		assertEquals(ActualName, ExpectedName);
		
	}
}
