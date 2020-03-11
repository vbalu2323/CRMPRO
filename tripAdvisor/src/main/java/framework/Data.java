package framework;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Data {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String suiteName;
	public static Object[] process_to_terminate= {"chrome.exe","firefox.exe","edge.exe"};
	public static String testname;
	public static String Methodname;
	public static ExtentTest maintest;
	public static Status status;
	public static Logger logger;
	
	

}
