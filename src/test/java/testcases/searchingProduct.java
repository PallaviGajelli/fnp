package testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class searchingProduct {
//main(String[] args) throws InterruptedException {
	
	@Test
	public static void searchingproduct() throws InterruptedException {
 //1. Launch the FNP Application  in the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\sanjaygajelli\\Downloads\\chromedriver_win32\\chromedriver.exe");
				  WebDriver chrome = new ChromeDriver(options); 
				  chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  chrome .get("https://www.fnp.com");
				  
// 2.Enter keyword in the search textbox and click on search.(Ex:Buddha) 
//Note:Expected step1 has to be verified (1.It should display Buddha products incategory page.)
				  
		  WebElement searchbox =
		  chrome.findElement(By.xpath("//*[@id=\"fnpsearch\"]"));  
		  searchbox.sendKeys("Sleeping Budha");
		  //click search
		  chrome.findElement(By.xpath("//*[@id=\"searchbtn\"]/i")).click();

// 3.Select any product(EX:Sleeping Buddha)	
		  
		  
		  chrome.findElement(By.xpath("//*[@id=\"searchProductListing\"]/li[1]/a/figure/img")).click();
		  chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //handling windows
		  //String home = chrome.getWindowHandle()
		  Set<String>IDs= chrome.getWindowHandles();
		  java.util.Iterator<String> iter=IDs.iterator();
		  String homewindow = iter.next(); 
		  String cartwindow = iter.next();
		 
		  
		  
		  
		  chrome.switchTo().window(cartwindow);
		 
//4.Enter Area/Pincode in the textbox Note:Expected step2 has to be verified	
//step2.It should display the area name in the Textbox 		  
		  //child window send add
		WebElement add = chrome.findElement(By.id("destlookup"));
				 add.sendKeys("1112223");
		  chrome.findElement(By.xpath("//*[@id=\"addToCart\"]")).click();
		 // chrome.alertIsPresent();

         
		// alert 
		  String alert1=
		  chrome.findElement(By.xpath("//*[@id=\"pincodeAlert\"]")).getText();
		  
		  System.out.println(alert1);
		
		  add.clear();
		  Thread.sleep(2000);
		  
		  
		  add.sendKeys("solapu"); 
		
		  //dynamic xpath
		//div[@class='pac-container pac-logo show-city'//div/descendant::span[@class='pac-matched']
		  
          List<WebElement> a= chrome.findElements(By.xpath("//span[text()='Solapu']"));
          a.get(1).click();
 

		 Thread.sleep(3000);
// 5.Click on Buy now button 	
		  
		  //chrome.findElement(By.xpath("//*[@id=\"addToCart\"]")).click();
		  chrome.findElement(By.xpath("//*[@id=\"buynow\"]")).click();
		  
// 6.Click on continue with one Add-on	
	     
		  Thread.sleep(2000);
		  chrome.findElement(By.xpath("//*[@id=\"FNP_ADDON_ROOT_INDIA\"]/ul/li[5]/label/div/span")).click();
          chrome.findElement(By.xpath("//*[@id='addon']/form/div[3]/button")).click();
		

//7.Enter Existing Mail id and click on continue button
		//  String loginwindow = iter.next();
		 // chrome.switchTo().window(loginwindow);
		  
          //Thread.sleep(5000);
		 // chrome.switchTo().frame("//twa.netcoresmartech.com/webactivity/ADGMOT35CHFLVDHBJNIG50K969M21TS1KFD3PQNLRI7AU8CN1TC0.js");
		  Thread.sleep(5000);
		  
		  WebElement mailID= chrome.findElement(By.xpath("//*[@id=\"loginformEmailId\"]"));
		  mailID.sendKeys("testmeapp1@gmail.com");

		  // 8.Enter valid Password and click on continue button Note:Expected step3 has to be verified
//3.It should display the delivery details		 
		 chrome.findElement(By.xpath("//*[@id=\"submit-check\"]/span[1]/span[1]")).click();

		  WebElement Pwd = chrome.findElement(By.xpath("//*[@id=\"loginPassword\"]"));
			 Pwd.sendKeys("test@2018");
			 Thread.sleep(3000);
			 chrome.findElement(By.xpath("//*[@id=\"submit-check\"]/span[1]/span[1]")).click();
			 Thread.sleep(3000);
			
			 
			 
		/*
		 * chrome.findElement(By.xpath("//*[@id=\"sender-mobile-require\"]"));
		 * mobileNO.sendKeys("9876543210"); Thread.sleep(3000);
		 * chrome.findElement(By.xpath("//*[@id=\"save-mobile\"]/span[1]/span[1]")).
		 * click(); Thread.sleep(3000);
		 */
	    
	      WebElement deliveryDetails = chrome.findElement(By.xpath("//*[@id=\"sidebar\"]"));
	      deliveryDetails.getText();
	      
	      Boolean DeliDetai = deliveryDetails.isDisplayed();
	      
	      if(DeliDetai==true) {
	    	  System.out.println("Delivery Details are Displyaed");
	    	  
	      }else {
	    	  System.out.println("Delivery Details are NOT Displyaed");
	      }

		      
//9.Click on saved Address	
		//chrome.findElement(By.xpath("//*[@id=\"rNameId-1\"]")).sendKeys("chaya");
	      JavascriptExecutor js = (JavascriptExecutor) chrome;
			 WebElement name = chrome.findElement(By.xpath("//*[@id=\"rNameId-1\"]"));
			 js.executeScript("arguments[0].scrollIntoView();", name);
			 name.sendKeys("chaya");
			 chrome.findElement(By.xpath("//*[@id=\"rAddressId-1\"]")).sendKeys("63 Telangi pachha peth solapur");
		     chrome.findElement(By.xpath("//*[@id=\"rMobileId-1\"]")).sendKeys("9876543210");
			 chrome.findElement(By.xpath("//*[@id=\"save-address-btn-1\"]/span[1]/span[1]")).click();
		
		
//10.Accept terms and conditions And click on Proceed to pay button Note:Expected step4 has to be verified
//4.It should display the Payment Page
		//scrooldown
		JavascriptExecutor js1 = (JavascriptExecutor) chrome;
		WebElement checkbox = chrome.findElement(By.xpath("//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div/label/span[1]/span[1]/input"));
		js1.executeScript("arguments[0].scrollIntoView();", checkbox);
		checkbox.click();
		chrome.findElement(By.xpath("//*[@id=\"proceed-to-checkout\"]/span[1]/span[1]")).click();
		String PGurl= chrome.getCurrentUrl();
		
		if (PGurl=="https://www.fnp.com/control/checkout-page-rj/#/checkout-page") {
		System.out.println("you are at PGurl "+PGurl);}
		else {
			System.out.println("you are at other than PGurl ");
		}
		
		  
	
	
	     chrome.quit(); 
	      
	      
	  }
}
	  
		 
			
/*
 * /2.Area/Pincode:Kondapur/500084 3.Existing user: Mail Id: test@gmail.com Pwd:
 * test123 4.Name:chaya 5.Address:Madhapur 6.Mobile no:9876543210
 * 
 */
		  
		  
		  
		  
		   

		  
		  
		 
		 
	    
	
	    
	      
	      
		
		
		
				  
	


