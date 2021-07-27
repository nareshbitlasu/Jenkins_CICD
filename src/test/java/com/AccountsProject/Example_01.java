package com.AccountsProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.utilities.DriverSpecific;


public class Example_01 {
	WebDriver driver;
	String chrome ="src/test/resources/Drivers/chromedriver.exe";
	@BeforeTest
	public void initilise() {
	System.setProperty("webdriver.chrome.driver",chrome);
	driver = new ChromeDriver();
	}
	
	@Test(priority=0)
	public void testCase_01() {
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.manage().window().fullscreen();
		driver.findElement(By.id("textbox")).sendKeys("downloadingfile");
		String valueEntered=driver.findElement(By.id("textbox")).getAttribute("value");
		System.out.println("The entered value is "+valueEntered);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
	
	
	}


	
	  @AfterTest 
	  public void afterCompletingTask()
	  { 
		  driver.close();
	}
	 

}
