package testingSelenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_FindingBrokenLinks {
	
	
	WebDriver driver;
	String chrome ="src/test/resources/Drivers/chromedriver.exe";
	
	@BeforeTest
	public void initilise() {
	System.setProperty("webdriver.chrome.driver",chrome);
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}
	
	@Test
	public void links() {
		
		String homePage="http://www.zlti.com";
		
		driver.get(homePage);
		String url="";
		HttpURLConnection huc =null;
		int responseCode=0;
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr=allLinks.iterator();
		while(itr.hasNext()) {
			url=itr.next().getAttribute("href");
			System.out.println("The url is "+url);
			if(url == null || url.isEmpty()) {
				System.out.println("URL is empty or not configured");
				continue;
			}
			if(!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain");
			}
			
			try {
				huc= (HttpURLConnection) new URL(url).openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				responseCode=huc.getResponseCode();
				if(responseCode>=400) {
					System.out.println("The url: "+url+" is broken and the response code is "+responseCode);
				}else {
					System.out.println("The url: "+url+" is valid and the response code is "+responseCode);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		driver.quit();
		
		
	}

}
