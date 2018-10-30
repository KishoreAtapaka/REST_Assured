package serviceNow;

import java.util.List;

import javax.swing.plaf.basic.BasicArrowButton;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIncidents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.authentication=RestAssured.basic("admin", "Sairam99!");
		RestAssured.baseURI="https://dev71943.service-now.com/api/now/table";
		Response response=RestAssured.given()
				.param("urgency", "2")
				.get("incident");
		
		JsonPath json=response.jsonPath();
		json.prettyPrint();
		List<String> incidentNumbers=json.get("result.number");	
		for(String incidentNumber:incidentNumbers)
		{
			System.out.println(incidentNumber);
		}
			

	}

}
