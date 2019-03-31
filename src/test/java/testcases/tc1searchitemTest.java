package testcases;

import org.testng.annotations.Test;
import pages.fnpHomePage;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class tc1searchitemTest {
	//private static final String ;
	WebDriver chrome;
	

	@Test
  public void f() throws InterruptedException {
	  Thread.sleep(3000);
	  fnpHomePage.searchbox(chrome);
	  Thread.sleep(3000);
	  fnpHomePage.clicksearch(chrome);
	  Thread.sleep(3000);
	  fnpHomePage.clickImage(chrome);
	  Thread.sleep(3000);
		
		  /*Set<String>IDs= chrome.getWindowHandles(); java.util.Iterator<String>
		  iter=IDs.iterator(); String homewindow = iter.next(); String cartwindow =
		  iter.next(); chrome.switchTo().window(cartwindow);
		  
		  fnpCartPage.sendaddress(chrome, "11122233443"); String
		  alert1=chrome.findElement(By.xpath("//*[@id=\"pincodeAlert\"]")).getText();
		  System.out.println(alert1); fnpCartPage.sendaddressclear(chrome);
		  fnpCartPage.sendaddress(chrome, "solapu"); List<WebElement> a=
		  chrome.findElements(By.xpath("//span[text()='Solapu']")); a.get(1).click();
		  Thread.sleep(3000); fnpCartPage.clickbuynow(chrome);*/
		 
	  
	  
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException  {
	  ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\sanjaygajelli\\Downloads\\chromedriver_win32\\chromedriver.exe");
				  chrome = new ChromeDriver(options); 
				  chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  chrome .get("https://www.fnp.com");
  }

  
	
	  @AfterClass 	  
	  public void afterClass() {
		  chrome.quit();
	  
	  }
	 

}
