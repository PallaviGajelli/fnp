package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fnpHomePage {
	  WebDriver driver; 
	  static String searchbutton = "//*[@id=\"searchbtn\"]/i";
	  static String Image="//*[@id=\"searchProductListing\"]/li[1]/a/figure/img";
	  static String searchbox = "//*[@id=\"fnpsearch\"]" ;
	   
	  public static void searchbox( WebDriver driver) {
		  WebElement Search=driver.findElement(By.xpath(searchbox));
		  Search.sendKeys("sleeping budha");}
	  
	  
	  public static void clicksearch( WebDriver driver){
		  WebElement Searchbutton=driver.findElement(By.xpath(searchbutton)); 
		  Searchbutton.click();}
	  
	  public static void clickImage( WebDriver driver){
		  WebElement image =driver.findElement(By.xpath(Image)); 
		  image.click();}
	  
	/*
	 * WebElement Searchbutton =driver.findElement(By.xpath(searchbutton));
	 * WebElement image = driver.findElement(By.xpath(Image));
	 * 
	 * public static void click( WebDriver driver,String button) { // WebElement
	 * WEButton= driver.findElement(By.xpath(button)); button.click();
	 */
	  
	  }
	 


