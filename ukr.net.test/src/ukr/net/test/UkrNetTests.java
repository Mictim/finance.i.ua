package ukr.net.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class UkrNetTests {
	public static final String SITE_URL = "http://www.ukr.net";

	@BeforeTest
	public void beforeTest() {
	  }
	
	@Test
	public void launchTest() {
		Driver.getInstance().get(SITE_URL);
	}
  
	@AfterTest
	public void afterTest() {
		  Driver.getInstance().close();
	 }
}
