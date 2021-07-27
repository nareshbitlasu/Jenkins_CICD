package com.restAssured;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class PostRequest {
	
	public static HashMap<String, String> hm = new HashMap<String, String>();
	
	@BeforeClass
	public void postdata() {
		hm.put("FirstName", RestUtils.getFirstName());
		hm.put("LastName", RestUtils.getLastName());
		hm.put("UserName", RestUtils.getUserName());
		hm.put("Password", RestUtils.getPassword());
		hm.put("Email", RestUtils.getEmail());
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
	}
	
	@Test
	public void testData() {
		
		given()
			.contentType("application/json")
			.body(hm)
		
		.when()
		
			.post()
		
		.then()
	
			.statusCode(201)
			.and()
			.body("SuccessCode", equalTo("OPERATION_SUCCESS"))
			.body("Message", equalTo("Operation completed successfully"));
			
	}
	
	
	
}


