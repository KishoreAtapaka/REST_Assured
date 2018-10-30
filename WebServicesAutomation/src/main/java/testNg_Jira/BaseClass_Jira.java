package testNg_Jira;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.response.Response;

public class BaseClass_Jira {
	
	static String issue_id; 
	Response response;
	
	@BeforeSuite
	void authenticateUser()
	{

		RestAssured.baseURI="https://kishroreatapaka.atlassian.net/rest/api/3/";
	}

}
