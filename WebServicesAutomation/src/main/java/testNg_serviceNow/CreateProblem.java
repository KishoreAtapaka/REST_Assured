package testNg_serviceNow;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateProblem extends BaseClass{
	
	@Test
	void createProblem()
	{
		response=RestAssured.given().contentType("application/json").body("{\"description\":\"Automated\"}").log().all().post("problem");
		//response.prettyPrint();
		probDesc=response.jsonPath().get("result.description");
		probPriority=response.jsonPath().get("result.priority");
		number=response.jsonPath().get("result.number");
//		System.out.println(probDesc);
//		System.out.println(probPriority);
//		System.out.println("The created problem is: "+number);
	}

}
