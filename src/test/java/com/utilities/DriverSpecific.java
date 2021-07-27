package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSpecific {
	
	String chrome ="src/test/resources/Drivers/chromedriver.exe";
	WebDriver driver;
	
	
	
	/*
	 * public WebDriver invokeDriver(String chromeDriver) {
	 * if(chromeDriver.contentEquals("chrome")) {
	 * System.setProperty("webdriver.chrome.driver",chrome); driver = new
	 * ChromeDriver(); }
	 * 
	 * return this.driver; }
	 * 
	 * public void closeBrowser() { this.driver.close(); }
	 */

}
