package testNg_Jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import testNg_serviceNow.BaseClass;

public class CreateIssue extends BaseClass{
	
	@Test
	void createissue()
	{
		probDesc="";
		ResponseBody response=RestAssured.given().header("Authorization", "Basic NzIua2lzaG9yZUBnbWFpbC5jb206U2FpcmFtOTkh", "")
				.contentType("application/json")
		.body("{\n" + 
				" 	\"fields\": {\n" + 
				"\"project\": {\n" + 
				"      \"id\": \"10000\"\n" + 
				"    },\n" + 
				"    \"summary\": \"+probDesc+\",\n" + 
				"    \"issuetype\": {\n" + 
				"      \"id\": \"10002\"\n" + 
				"    }\n" + 
				"}\n" + 
				"}").log().all().post("issue");
		//System.out.println(response.getStatusCode());
		

		
	}

}
