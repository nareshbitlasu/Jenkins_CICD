package com.restAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;




public class BasicOpeartions_UsingXML {
	
	@Test
	public void verifySingleContect() {
		
		given()
		
		.when()
			.get("https://stageappsp.smashfly.com/contactmanagerservice/v2/ContactManagerRestService.svc/help/operations/SaveContact#request-xml")
			
		.then()
			.statusCode(200)
			.log().all();
			
		
		
		
	}

}
