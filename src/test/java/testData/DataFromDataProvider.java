package testData;

import org.testng.annotations.DataProvider;

public class DataFromDataProvider {
	
	@DataProvider(name="dataLoad")
	public static Object[][] getData(){
		return new Object[][] {
			
			{"Computer", "India"},
			{"Keyboard", "UK"},
			{"MotherBoard", "USA"}
			
		};
	}

}
