package testNg_serviceNow;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseClass {
	
	static String sys_id=""; public static String probDesc=""; static String probPriority=""; static String number="";
	static Response response;
	static String jiraIssueNumber="";
	
	
	@BeforeSuite
	void authenticateUser(){
	RestAssured.authentication=RestAssured.basic("admin", "Sairam99!");
	RestAssured.baseURI="https://dev71943.service-now.com/api/now/table";
	
	}
	
	
	
	

}
