package com.restAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class BasicOperations {

	
	@Test
	public void test_statuscode() {
		
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void singleDataValidation() {
		
		given()
		
		.when()
		 	.get("http://dummy.restapiexample.com/api/v1/employee/15")
		 	
		 .then()
		 	.statusCode(200)
		 	.log().all()
			.body("data.employee_name", equalTo("Tatyana Fitzpatrick"));
		 	
	}
	
	@Test
	public void validatingMultipleDataElements() {
		
		given()
		
		.when()
			.get("http://dummy.restapiexample.com/api/v1/employee/15")
		
		.then()
			.statusCode(200)
			.log().all()
			.body("data.employee_salary", equalTo(385750))
			.body("data.employee_age", equalTo(	19));	
	}
	
	@Test
	public void addingParameters() {
		
		given()
			.param("name", "computer")
			.header("header", "HP")
		.when()
			.get("http://dummy.restapiexample.com/api/v1/employee/15")
		.then()
	 		.statusCode(200)
	 		.log().all();
		
		
	}
	
}
