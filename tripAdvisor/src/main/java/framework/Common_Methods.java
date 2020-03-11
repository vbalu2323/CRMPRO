package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Common_Methods {

	public static void launchApplication(String browser, String url){
		
		switch(browser.toLowerCase()) {
		
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			Data.driver= new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			Data.driver=new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			Data.driver= new EdgeDriver();
			break;
			
		case "default":
            Assert.assertTrue(false, "Application not launched");
			break;
		
		}
		Data.driver.get(url);
		Data.driver.manage().window().maximize();
		Data.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
		
	

	}

}
