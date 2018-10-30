package testNg_Jira;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SearchIssues extends BaseClass_Jira {
	
	@Test
	void searchIssues()
	{
		response=RestAssured.given()
				.header("Authorization", "Basic NzIua2lzaG9yZUBnbWFpbC5jb206U2FpcmFtOTkh", "")
				.get("search");
		List<String> issues=response.jsonPath().get("issues.id");
		System.out.println("List of issues for this project are: ");
		for(String issue:issues)
		{
			System.out.println(issue);
		}
			issue_id=issues.get((issues.size())-1);
		
		
	}

}
