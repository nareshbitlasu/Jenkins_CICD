package com.AccountsProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example_Alert_02 {
	
	WebDriver driver;
	String chrome ="src/test/resources/Drivers/chromedriver.exe";
	@BeforeTest
	public void initilise() {
	System.setProperty("webdriver.chrome.driver",chrome);
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}
	
	@Test(enabled=false)
	public void alertVerification() {
		//driver.manage().window().fullscreen();
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("58345");
		driver.findElement(By.name("submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		driver.findElement(By.name("cusid")).clear();
		driver.findElement(By.name("cusid")).sendKeys("58345");
		driver.findElement(By.name("submit")).submit();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText=driver.switchTo().alert().getText();
		System.out.println("The alert text is "+alertText);
		driver.switchTo().alert().accept();
		driver.close();
		
	}
	
	@Test(enabled = false)
	public void desiredCapabilities() {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		String platformName=cap.getPlatform().toString();
		System.out.println("The platform is "+platformName);
		//cap.
	}
	
	@Test
	public void validateToolTip() {
		driver.get("http://demo.guru99.com/test/tooltip.html");
		
		
	}

}
