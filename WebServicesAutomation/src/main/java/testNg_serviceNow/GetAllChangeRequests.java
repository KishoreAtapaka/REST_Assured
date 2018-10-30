package testNg_serviceNow;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class GetAllChangeRequests extends BaseClass {
	
	
	@Test
	void getAllChangeRequests()
	{
		response=RestAssured.given().log().all().get("change_request");
		List<String> changeRequests=response.jsonPath().get("result.number");
		System.out.println("Total: "+changeRequests.size());
		int random = (int )(Math. random() * (changeRequests.size() -1)); 
		sys_id=changeRequests.get(random);
		

		
		
	}
	

}
