package ukr.net.test;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	private static FirefoxDriver instance = null;
	
	private Driver(){
	}
		
	public static FirefoxDriver getInstance(){
		if(instance == null) {
			instance = new FirefoxDriver();
		}
		return instance;
	}
		
}

