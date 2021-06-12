package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;

public class BasePage {

	 public static WebDriver driver;

	    public BasePage(WebDriver driver) {
//	    	String path = System.getProperty("user.dir");   // return project folder path
//			String driverpath = path + "\\chrome\\chromedriver.exe";   // return driver folder path 
//			System.out.println(driverpath);
//			String p2 = System.setProperty("webdriver.chrome.driver",driverpath);
//	    	driver = new ChromeDriver();
//	        this.driver = driver;
	    }
	    
}
