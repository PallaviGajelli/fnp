package testcases;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;




public class tc1PsitiveValidation {
	
    
	private static WebDriver driver;
    @Test
	public static void tc1PsitiveValidation() throws InterruptedException, IOException {
	try {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\sanjaygajelli\\Downloads\\chromedriver_win32\\chromedriver.exe");
			  driver = new ChromeDriver(options); 
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.get("https://www.fnp.com");
			  
			 // homePageFactory home = new homePageFactory(driver);
			  fnp.pages.homePageFactory home =PageFactory.initElements(driver, fnp.pages.homePageFactory.class);
			  home.searchproduct("sleeping budha");
			  
			  Set<String>IDs= driver.getWindowHandles();
			  java.util.Iterator<String> iter=IDs.iterator();
			  String homewindow = iter.next(); 
			  String cartwindow = iter.next();
			 		  
			  driver.switchTo().window(cartwindow);
			 
			  //fnpCartPage cart = new fnpCartPage(driver);  
			  fnp.pages.fnpCartPage cart=PageFactory.initElements(driver, fnp.pages.fnpCartPage.class);
			  Thread.sleep(3000);
			  cart.searchvalidaddress("Solapu");  
			  cart.addonproducts();
			  cart.validloginfnp("testmeapp1@gmail.com", "test@2018");
			  cart.validateDeliveryDetailsDisplyed();
			  cart.filladdToDelivery(driver, "solapur", "9876543210", "chaya");
			  cart.placeorder();
			  cart.checkUrl();
			  
	}
	catch(Exception e) {
		System.out.println(e);
	}
	finally {
			  driver.quit();
			  Runtime rt =Runtime.getRuntime();
			  Process proc = rt.exec("taskkill /im chrome.exe /f /t");
	} 

}
}