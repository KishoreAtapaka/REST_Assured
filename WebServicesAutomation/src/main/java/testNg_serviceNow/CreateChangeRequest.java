package testNg_serviceNow;

import org.junit.experimental.theories.DataPoint;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateChangeRequest extends BaseClass{
	
	@Test(dataProvider="create")
	void createChangeRequest(String shortDesc)
	{
		//String shortDesc="test";
		response=RestAssured.given().contentType("application/json").body("{\"short_description\":\""+shortDesc+"\"}").log().all().post("change_request");
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
	@DataProvider(name="create")
	Object[] getData()
	{
		Object[] str = new Object[2];
		str[0]="Test1";
		str[1]="Test2";
		return str;
	}
	
	

}
