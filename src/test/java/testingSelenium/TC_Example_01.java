package testingSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_Example_01 {
	
	WebDriver driver;
	String chrome ="src/test/resources/Drivers/chromedriver.exe";
	@BeforeTest
	public void initilise() {
	System.setProperty("webdriver.chrome.driver",chrome);
	driver = new ChromeDriver();
	}

		
	
	@Test(enabled = false)
	public void TC_01() {
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().fullscreen();
		
		Select s = new Select(driver.findElement(By.name("country")));
		s.selectByIndex(2);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		s.selectByVisibleText("ARGENTINA");
		boolean multiple=s.isMultiple();
		System.out.println("The dorpdown allows multiple select statements? "+multiple);
		/*
		 * List<WebElement> seletedElements=s.getOptions();
		 * seletedElements.stream().forEach(a->System.out.println(a.getText()));
		 * List<String>
		 * strelements=seletedElements.stream().map(a->a.getText()).collect(Collectors.
		 * toList()); for(String ss:strelements) {
		 * System.out.println("The list extracted from stream: "+ss); }
		 */
		
		driver.close();
		
	}
	
	@Test(enabled = true)
	public void TC_02() {
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().fullscreen();
		
		/*
		 * Select s = new Select(driver.findElement(By.name("country")));
		 * s.selectByIndex(2); driver.manage().timeouts().implicitlyWait(2,
		 * TimeUnit.SECONDS); s.selectByVisibleText("ARGENTINA"); boolean
		 * multiple=s.isMultiple();
		 * System.out.println("The dorpdown allows multiple select statements? "
		 * +multiple); List<WebElement> seletedElements=s.getOptions();
		 * seletedElements.stream().forEach(a->System.out.println(a.getText()));
		 * List<String>
		 * strelements=seletedElements.stream().map(a->a.getText()).collect(Collectors.
		 * toList()); for(String ss:strelements) {
		 * System.out.println("The list extracted from stream: "+ss); }
		 */
		/*
		 * Actions builder = new Actions(driver); Action action=
		 * builder.moveToElement(driver.findElement(By.linkText("Home"))).build();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * action.perform(); builder.click();
		 */
		
		driver.findElement(By.linkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.findElement(By.name("userName")).sendKeys("user1");
		driver.findElement(By.name("password")).sendKeys("user");
		
		
		
		
		driver.close();
		
	}

}