package com.restAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetRequest {
	

	@Test (enabled=true)
	public void getWeatherDetails() {
		
		given()
		.when()
			.get("http://demoqa.com/utilities/weather/city/Hyderabad")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("City", equalTo("Hyderabad"))
			.header("Content-Type", "application/json; charset=utf-8");
	}
	

}
