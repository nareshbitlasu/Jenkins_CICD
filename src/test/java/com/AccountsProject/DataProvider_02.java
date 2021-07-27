package com.AccountsProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testData.DataFromDataProvider;

public class DataProvider_02 {
	
	WebDriver driver;
	String chrome ="src/test/resources/Drivers/chromedriver.exe";
	@BeforeTest
	public void initilise() {
	System.setProperty("webdriver.chrome.driver",chrome);
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://google.com");
	}
	
	@Test(dataProvider="dataLoad", dataProviderClass=DataFromDataProvider.class)
	public void workWithMultipleData(String author, String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
        //search value in google searchbox
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
        Thread.sleep(3000);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue +"::::"+searchKey);
        searchText.clear();
        //Verify if the value in google search box is correct
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
	/*
	 * @DataProvider(name="dataLoad") public Object[][] getData(){ return new
	 * Object[][] {
	 * 
	 * {"Computer", "India"}, {"Keyboard", "UK"}, {"MotherBoard", "USA"}
	 * 
	 * }; }
	 */

}
