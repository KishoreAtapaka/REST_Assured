package testNg_Jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteIssue extends BaseClass_Jira{
	
	@Test(dependsOnMethods = { "testNg_Jira.SearchIssues.java.searchIssues" })
	void deleteIssue()
	{
		System.out.println("ISSUE ID IS "+issue_id);
		response=RestAssured.given().
				header("Authorization", "Basic NzIua2lzaG9yZUBnbWFpbC5jb206U2FpcmFtOTkh", "").
				log().all().
			delete("issue/"+issue_id);
		System.out.println(response.getStatusCode());
		if(response.getStatusCode()==204)
			System.out.println("Deletion of "+issue_id+" successful");
		else
			System.out.println("Deletion of "+issue_id+" is unsuccessful");
		
	}

}
