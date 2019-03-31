package testcases;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.NewSessionPayload;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;

import pages.fnpCartPage;

public class fnpextentReport {

	public static ExtentHtmlReporter HtmlReporter;
	public static ExtentReports Report;
	public static ExtentTest test;
	private static WebDriver driver;
	
	
	//why reports are not generating
	//Report setup(look and feel,environment details)
		@BeforeTest
		public void setExtent() {
		
		  HtmlReporter=new ExtentHtmlReporter("C:\\Users\\sanjaygajelli\\eclipse-workspace\\fnp\\fnpExtentReport\\fnpReport.html");
		  HtmlReporter.config().setDocumentTitle("Automation Report");
		  HtmlReporter.config().setReportName("Functional Testing");
		  HtmlReporter.config().setTheme(Theme.STANDARD);
		 
			
		    Report= new ExtentReports();
		    test = Report.createTest("fnpextentReport");
		    Report.attachReporter(HtmlReporter);
		   
			Report.setSystemInfo("Tester Name", "Pallavi");
			Report.setSystemInfo("Website", "FernsNpetals");
			
			
	 	}
	
		//launch website
		@BeforeMethod             
		public  void launchweb() {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sanjaygajelli\\Downloads\\chromedriver_win32\\chromedriver.exe");
					  driver = new ChromeDriver(options); 
					  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					  driver.get("https://www.fnp.com/control/checkout-page-rj/#/checkout-page");
			}
		
		@Test                       
		private static void validlogin() throws InterruptedException 
		{
		    fnpCartPage cart=PageFactory.initElements(driver, fnpCartPage.class);
			cart.validloginfnp("testmeapp1@gmail.com","test@2018");
			driver.close();
		}
		
		//check result and take screnshot for failed testcases
		@AfterMethod
		public void checkResult(ITestResult result) throws Exception {
			
			if (result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL, "Test case failed is :"+result.getName());
				test.log(Status.FAIL, "Reson for failure is :"+result.getThrowable());
				String screenshotPath =fnpextentReport.getScreenShot(driver,result.getName());
				test.addScreenCaptureFromPath(screenshotPath);
			}
			else if (result.getStatus()==ITestResult.SKIP) {
				test.log(Status.SKIP, "Test case skipped is :"+result.getName());
			}else if (result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS, "Test case passed is :"+result.getName());				
			}
			
		}
		
		public static String getScreenShot(WebDriver driver,String screenshotName ) throws IOException {
		String DateName= new SimpleDateFormat("mmddyymmss").format(new Date(0));
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String Destination = ("C:\\Users\\sanjaygajelli\\eclipse-workspace\\fnp\\fnpScreenshot\\"+DateName+"\\"+screenshotName+".png");
		File finalDestination =new File(Destination);
		FileUtils.copyFile(source, finalDestination);
		return Destination;
		}
			 
		//close and flush
		@AfterTest 
		public void endReport() throws IOException
		{
			  driver.quit();
			  Runtime rt =Runtime.getRuntime();
			  Process proc = rt.exec("taskkill /im chrome.exe /f /t");
			  Report.flush();
		}
		
		
		
	}

	
	


