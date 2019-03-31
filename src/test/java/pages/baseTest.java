package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class baseTest {
	

		
	@Test
	public static void	Launchfnp(){ 
	    	ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver",
					  "C:\\Users\\sanjaygajelli\\Downloads\\chromedriver_win32\\chromedriver.exe");
					  WebDriver chrome = new ChromeDriver(options); 
					  chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					  chrome .get("https://www.fnp.com");
	    }
	 
		}	



	
