package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		StepDefination m=new StepDefination();
		if(StepDefination.Place_ID==null)
		{
			m.add_place_payload("SahanaBharu", "Kannada", "Bengaluru");
			m.user_calls_with_the_http_request("AddPlaceAPI", "POST");
//			m.the_api_call_got_success_with_status_code(200);
			m.verify_place_id_created_maps_to_using("SahanaBharu","getPlaceAPI");
		}
	}
	
	
}
