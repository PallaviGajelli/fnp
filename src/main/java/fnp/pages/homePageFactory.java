package fnp.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;



public class homePageFactory {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"fnpsearch\"]")WebElement searchbox;
	@FindBy(xpath="//*[@id=\"searchbtn\"]/i")WebElement searchbutton;
	@FindBy(xpath="//*[@id=\"searchProductListing\"]/li[1]/a/figure/img")WebElement item;
	

	public homePageFactory(WebDriver driver) {
		this.driver=driver;	}	
	
	
	public void searchproduct(String items) throws InterruptedException {
		//Thread.sleep(3000);
		searchbox.sendKeys(items);
		Thread.sleep(2000);
		searchbutton.click();
		Thread.sleep(3000);
		item.click();
		//Thread.sleep(5000);
	}
	
	
	
}
