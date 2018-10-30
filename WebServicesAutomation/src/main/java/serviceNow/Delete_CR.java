package serviceNow;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_CR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.authentication=RestAssured.basic("admin", "Sairam99!");
		RestAssured.baseURI="https://dev71943.service-now.com/api/now/table";
		//String sys_id="7bf851b6db412300826ba08a48961903";
		Response response=RestAssured.given()
				.pathParam("sys_id", "1a9ad5b6db412300826ba08a489619ae")
				.log().all()
				.delete("change_request/{sys_id}");
if(response.getStatusCode()==204)
{
	System.out.println("Deletion Success");
}
else
	System.out.println("Deletion unsuccessful");
	}

}
