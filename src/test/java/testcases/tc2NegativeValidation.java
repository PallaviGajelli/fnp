package testcases;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class tc2NegativeValidation {
	/*
	 * 1. Launch the FNP Application in the browser 2.Enter valid keyword
	 * (Ex:Buddha) 3.Select any product (EX:Sleeping Buddha) 4.Enter Invalid
	 * Area/Pin code in the textbox Note:Expected step1 has to be verified 5.Click
	 * on Buy now button 6.Click on continue with one Add-on 7.Enter Invalid Mail id
	 * and click on continue button Note:Expected step2 has to be verified 9.Click
	 * on Add new address and leave the all fields empty and click on continue
	 * button 10.Accept terms and conditions And click on Proceed to pay button
	 * Note:Expected step3 has to be verified
	 */
	

    private static WebDriver driver;
    @Test
    public static void tc2NegativeValidation() throws InterruptedException, IOException {
    	try
    	{
    		
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
			  cart.searchinvalidaddress("11111222");
			  cart.searchvalidaddress("Solapu"); 
			  cart.addonbutton.click();
			  cart.invalidloginfnp("asas@ju676576");
			 // cart.loginEmailID.clear();
	          cart.validloginfnp("testmeapp1@gmail.com", "test@2018");
			  cart.validateDeliveryDetailsDisplyed();
			 // cart.filladdToDelivery(driver, null,null,null);
			  //cart.validationAlert("nameisrequire");
			 // cart.validationAlert("addisrequire");
			 // cart.validationAlert("mobileisreqire");
			  cart.filladdToDelivery(driver, "solapur", "9876543210", "chaya");
			  cart.placeorder();
			  cart.checkUrl();
	  
    	}
    	catch(Exception ex)
    	{}
    	finally
    	{   
    		driver.quit();
			Runtime rt =Runtime.getRuntime();
			Process proc = rt.exec("taskkill /im chrome.exe /f /t");    		
    	}
}
}
