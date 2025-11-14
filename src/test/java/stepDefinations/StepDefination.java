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

	@When("user calls {string} with the Post http request")
	public void user_calls_with_the_post_http_request(String string) {
		resspec=new ResponseSpecBuilder().expectStatusCode(200).build();
		response=req.when().post("maps/api/place/add/json").then().spec(resspec).extract().response();
		
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
		
		String ress=response.asString();
			JsonPath js=new JsonPath(ress);
			assertEquals(js.get(string),string2);
	}

	
	
}
