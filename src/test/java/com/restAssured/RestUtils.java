package com.restAssured;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return "Computer"+generatedString;
	}
	
	public static String getLastName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return "Key"+generatedString;
	}
	
	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return "Monitor"+generatedString;
	} 
	
	public static String getPassword() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return "UPS"+generatedString;
	}
	
	public static String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return generatedString+"gmail.com";
	}
}
