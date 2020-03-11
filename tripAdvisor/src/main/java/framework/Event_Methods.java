package framework;

import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Event_Methods {
	
	

	public static boolean waitforElement_is_Displayed(WebElement Element, int timeout){
		boolean isElementDisplayed= false;
		
		try {
		
		WebDriverWait wait= new WebDriverWait(Data.driver, timeout);
	    Element	=wait.until(ExpectedConditions.visibilityOf(Element));
	    wait.pollingEvery(Duration.ofMillis(200));
	    isElementDisplayed=true;
		}catch(Exception e) {
			isElementDisplayed=false;
			System.out.println("Element is not displayed");
			
		}
		return isElementDisplayed;
	}
	
		
   public static boolean waitforElement_is_Enabled(WebElement Element,int timeout) {
	   boolean isElementEnabled=false;
	   try {
	   
	   WebDriverWait wait=new WebDriverWait(Data.driver, timeout);
	   wait.until(ExpectedConditions.elementToBeClickable(Element));
	   wait.pollingEvery(Duration.ofMillis(200));
	   isElementEnabled=true;
	   }catch(Exception e) {
		   isElementEnabled=true;
		   System.out.println("Element is not Enabled");
	   }
	   return isElementEnabled;
   }
	   
 
   
    public  static void Enter_value(WebElement Element,String input) {
	   if(Element==null) {
		   Assert.assertFalse(true, "NO such Element is found with that locator");
	   } else {
			   if( waitforElement_is_Displayed(Element,20)) {
				   if(  waitforElement_is_Enabled(Element,20)) {
					   Element.clear();
					   Element.sendKeys(input);
					   
				   }else {
					   Assert.assertTrue(false, "Element "+input+" is not enabled even after waiting for 20 seconds");
					   
			   }
				   
			   
		   }else {
			   Assert.assertTrue(false, "Element "+input+" is not Displayed even after waiting for 20 seconds");
		   }
		   
	   }
	  
   }
    
    public static void clickbutton(WebElement Element) {
    	if(Element==null) {
    		Assert.assertTrue(false, "No such Element found");
    		
    	}else {
    		  if(waitforElement_is_Displayed(Element, 2)) {
    			  if(waitforElement_is_Enabled(Element, 2)) {
    				  Element.click();
    			  }else {
    				  Assert.assertTrue(false, "Element is not Enabled even after 20 seconds");
    			  }
    		  }else {
    			  Assert.assertTrue(false, "Element is not Displayed even after 20 seconds");
    		  }
    	}
    	
    }
    
    public static void switchtoframe(WebElement element) {
    	try {
    	Data.driver.switchTo().frame(element);
    	
    	
    }catch(Exception e) {
    	System.out.println("no such frame" +element);
    }
    	
     
    	
    	
    }
    public static void selectvalueinListBox(List<WebElement> element,String input) {
    	List<WebElement>alloptions=element;
    	boolean isValueFound=false;
    	for(WebElement options: alloptions) {
    		if(waitforElement_is_Displayed(options, 20)) {
    			if(waitforElement_is_Enabled(options, 20)) {
    				if(options.getText().equalsIgnoreCase(input)) {
    					options.click();
    					isValueFound=true;
    					break;
    				}
    			}
    		}
    		
    	}
    	if(!isValueFound) {
    		System.out.println("value"+input+"is not found in the list"+element.toString());
    		Assert.assertFalse(true, "value"+input+"is not found in the list"+element.toString());
    	}
    	
    	
    }
    
}
    
   
	
	    


    
		
	
	

