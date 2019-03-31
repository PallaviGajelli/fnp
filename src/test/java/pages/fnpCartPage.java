package pages;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class fnpCartPage {
	
	//private static final String Else = null;

	WebDriver driver;
    
   // @FindBy(xpath="destlookup")WebElement searchaddressbutton;
    @FindBy(xpath="//*[@id=\"destlookup\"]")WebElement searchaddressbox;  
    @FindBy(xpath="//span[text()='Solapu']")WebElement firstdynamicaddress;
    @FindBy(xpath="//*[@id=\"addToCart\"]")WebElement addtocartbutton;
    @FindBy(xpath="//*[@id=\"buynow\"]")WebElement buynowbutton;
    @FindBy(xpath="//*[@id=\"FNP_ADDON_ROOT_INDIA\"]/ul/li[5]/label/div/span")WebElement addoncheckbox;
    @FindBy(xpath="//*[@id='addon']/form/div[3]/button")
	public WebElement addonbutton;
    @FindBy(xpath="//*[@id=\"check-login\"]/div/div/div/div/span")WebElement checklogin;
    
   // @FindBy(xpath=)WebElement withoutaddonbutton;
    @FindBy(xpath="//*[@id=\"sidebar\"]")WebElement deliveryDetails;
    public @FindBy(xpath="//*[@id=\"loginformEmailId\"]")WebElement loginEmailID;
    @FindBy(xpath="//*[@id=\"loginPassword\"]")WebElement pwd;
    @FindBy(xpath="//*[@id=\"submit-check\"]/span[1]/span[1]")WebElement continuebutton;
  //*[@id="submit-check"]/span[1]/span[1]
    @FindBy(xpath="//*[@id=\"rNameId-1\"]")WebElement rname;
    @FindBy(xpath="//*[@id=\"rMobileId-1\"]")WebElement rmobileno;
    @FindBy(xpath="//*[@id=\"rAddressId-1\"]")WebElement raddress;
    @FindBy(xpath="//*[@id=\"addressform-1\"]/div[1]/div[2]/span")WebElement nameisrequire;
    @FindBy(xpath="//*[@id=\"addressform-1\"]/div[3]/span")WebElement addisrequire;
    @FindBy(xpath="//*[@id=\"addressform-1\"]/div[8]/div/span")WebElement mobileisreqire;
    @FindBy(xpath="//*[@id=\"remailId-1\"]")WebElement rEmailid;//optional
    @FindBy(xpath="//*[@id=\"datetimelink\"]")WebElement deliverydate;
    @FindBy(xpath="//*[@id=\"save-address-btn-1\"]/span[1]/span[1]")WebElement submitaddressbutton;
    @FindBy(xpath="//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div/label/span[1]/span[1]/input")WebElement Iagreetickbox;
    @FindBy(xpath="//*[@id=\"proceed-to-checkout\"]/span[1]/span[1]")WebElement submitorderbutton;
    @FindBy(xpath="//*[@id=\"dateAlert\"]")WebElement pincodealert;
    @FindBy(xpath="//*[@id=\"pincodeAlert\"]")WebElement deliverydatealert;
    
  
      
    public  fnpCartPage(WebDriver driver) {
    	this.driver=driver;
    }
   
    public void click(String buttonName) {
    	switch (buttonName) {
		//case "searchaddressbutton":searchaddressbutton.click();
		//      break;
		case "addtocartbutton":addtocartbutton.click();
		      break;			
		case "buynowbutton":buynowbutton.click();
		      break;
		case "addoncheckbox":addoncheckbox.click();
	          break;
       // case "withoutaddonbutton":withoutaddonbutton.click();
		   //   break;
        case "connectbutton":continuebutton.click();  
		      break;
        case "submitaddressbutton":submitaddressbutton.click();
		      break;
        case "Iagreetickbox":Iagreetickbox.click();
		      break;
        case "submitorderbutton":submitorderbutton.click();
			  break;
		default : System.out.print("Button not found");
			  break;
		}    
    }
   
    public  void searchvalidaddress(String youraddress) throws InterruptedException {
    	searchaddressbox.sendKeys(youraddress);
    	Thread.sleep(3000);
    	List<WebElement> a= driver.findElements(By.xpath("//span[text()='Solapu']"));
    	 a.get(1).click(); 
    	 Thread.sleep(3000);
    	 buynowbutton.click();
    	 Thread.sleep(4000);
    	  }
    public void searchinvalidaddress(String youraddress) throws InterruptedException {
    	searchaddressbox.sendKeys(youraddress);
    	Thread.sleep(2000);
    	addtocartbutton.click();
	  if(pincodealert.isDisplayed()) { 
		  String alert=pincodealert.getText();
		  if (alert==" Select Delivery Area to continue ")
		  {
	         System.out.println("right alert="+alert);
	       } 
		  else {
	        System.out.println(alert+" is wrong alert");
	         }}
		  searchaddressbox.clear();
		  Thread.sleep(1000);
		  
	   }
	 
    
    public void addonproducts() throws InterruptedException {
    	addoncheckbox.click();
    	addonbutton.click();
    	Thread.sleep(3000);
    }
    
    public void validloginfnp(String loginemailID,String password ) throws InterruptedException {
    	loginEmailID.sendKeys(loginemailID);
    	continuebutton.click();	
	    	Thread.sleep(3000);
	    	pwd.sendKeys(password);
	    	Thread.sleep(2000);
	    	continuebutton.click();
	    	Thread.sleep(3000);
    	}
    
    public void invalidloginfnp(String loginemailID) throws InterruptedException {
    	loginEmailID.sendKeys(loginemailID);
    	Thread.sleep(1000);
    	continuebutton.click();	
    	if (checklogin.isEnabled()) {
    		System.out.println("This is invalid Email ID");}
    	else {
    		System.out.println("This is valid Email ID");
    	     }	
    	loginEmailID.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));	 
			  Thread.sleep(2000);
	         }
    	
    
  
    public void filladdToDelivery( WebDriver driver,String address,String mobileno,String name ) {
    	
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
		// WebElement name = chrome.findElement(By.xpath("//*[@id=\"rNameId-1\"]"));
		 js.executeScript("arguments[0].scrollIntoView();", rname);
    	rname.sendKeys(name);
    	rmobileno.sendKeys(mobileno);
    	raddress.sendKeys(address);
    	submitaddressbutton.click();
    	
    	
    }
   
    public void placeorder() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		// WebElement name = chrome.findElement(By.xpath("//*[@id=\"rNameId-1\"]"));
		 js.executeScript("arguments[0].scrollIntoView();", Iagreetickbox);
		 Iagreetickbox.click();
		 submitorderbutton.click();
		 
    }
    
   
   
    	public void validationAlert(String alrets) {
        
    		switch (alrets) {
			case "nameisrequire":if(nameisrequire.isDisplayed()) {
	    		                 String alert=nameisrequire.getText();
	        	                 if (alert=="* Name is required") {
	        		             System.out.println("right alert="+alert);
	        	            }
	        	           else {
	        		            System.out.println(alert+"wrong alert");
	        	            }}
				
				break;
            case "addisrequire":if(addisrequire.isDisplayed()) {
                                String alert=addisrequire.getText();
                                if (alert=="* Recipient's address is required") {
	                            System.out.println("right alert="+alert);
                               }
                               else {
	                           System.out.println(alert+"wrong alert");
                                }}
				
				break;
            case "mobileisreqire":if(mobileisreqire.isDisplayed()) {
                                  String alert=mobileisreqire.getText();
                                  if (alert=="* Recipient’s mobile number is required.") {
	                              System.out.println("right alert="+alert);
                                   }
                                  else {
	                              System.out.println(alert+"wrong alert");
                                  }}
	
	            break;
			default:System.out.println("No alert is displayed");
				break;
			}
		/*
		 * String alert1=alrets.getText(); if (!alert1.isEmpty()) {
		 * System.out.println("alert recieved ="+alert1); } else {
		 * System.out.println(alert1+"wrong alert"); }
		 */
    		
    		
    	}
    	
    	       
   public void validateDeliveryDetailsDisplyed(){
	   
	   Boolean DeliDetai = deliveryDetails.isDisplayed();
	   if(DeliDetai==true) {
	    	  System.out.println("Delivery Details are Displyaed");
	    	  
	      }else {
	    	  System.out.println("Delivery Details are NOT Displyaed");

	     }
	    }
       
  public void checkUrl() {
	  String PGurl= driver.getCurrentUrl();
		
		if (PGurl=="https://www.fnp.com/control/checkout-page-rj/#/checkout-page") {
		System.out.println("you are at PGurl "+PGurl);}
		else {
			System.out.println("you are at other than PGurl ");
		}
  }
  
   
   
   
   
   }
    
	
	            
		
