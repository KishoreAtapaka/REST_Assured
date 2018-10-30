package testNg_serviceNow;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRandomChangeRequest extends BaseClass{
	
	@Test(dependsOnMethods= "testNg_serviceNow.GetAllChangeRequests.getAllChangeRequests")
	void deleteRandomChangeRequest()
	{
		response =RestAssured.given().log().all().delete("change_request/"+sys_id);
		System.out.println(response.getStatusCode());
		
		
	}

}
