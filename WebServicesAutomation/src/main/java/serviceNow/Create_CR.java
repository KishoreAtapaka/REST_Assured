package serviceNow;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Create_CR {
	
	static int initialCount=0;
	static int finalCount=0;
	static List<String> changeRequests;
	static String sys_id;
	
	static int getCrs(String URL)
	{
		
		Response response=RestAssured.given().param("priority", "2").get(URL);
		changeRequests=response.jsonPath().get("result.number");
		return changeRequests.size();
		
	}
	
	static boolean createCr(String URL, String body)
	{
		boolean flag=false;
		Response response=RestAssured.given().contentType("application/json").body(body).post(URL);
		sys_id=response.jsonPath().get("result.sys_id");
		response=RestAssured.given().param("priority", "2").get(URL);
		changeRequests=response.jsonPath().get("result.number");
		finalCount=changeRequests.size();
		response=RestAssured.given().param("sysparm_fields", "priority").get("change_request/"+sys_id);
		//response.prettyPrint();
		String priorityValue=response.jsonPath().get("result.priority");
		
		if(finalCount==(initialCount+1) && (priorityValue.equalsIgnoreCase("2")))
		{
			flag=true;
			System.out.println("Creation is successful: "+sys_id);
		}
		
		else
			System.out.println("Creation unsuccessful");

		
		
		
		
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.authentication=RestAssured.basic("admin", "Sairam99!");
		RestAssured.baseURI="https://dev71943.service-now.com/api/now/table";
		initialCount=getCrs("change_request");
		System.out.println("The total number of change requests available at present: "+initialCount);
		createCr("change_request", "{\"priority\":\"2\"}");
		
		

		
	}

}
