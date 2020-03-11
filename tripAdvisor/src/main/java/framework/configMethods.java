package framework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;


public class configMethods {
	
	
	@BeforeSuite
	public void beforesuite(ITestContext ctx) {
		Data.suiteName=ctx.getCurrentXmlTest().getSuite().getName();
		Logs.initializelog();
		Utility_Files.processtokill();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String fileName = "ExecutionLog_" + timeStamp+".log";
		String filePath = System.getProperty("user.dir")+"\\Logs\\"+fileName;
		File f = new File(filePath);
		System.setProperty("log.file", filePath);
		System.setProperty("log.parent.path", f.getParent());
		System.setProperty("log.file.name", FilenameUtils.getBaseName(f.getName()));
		Data.logger = LogManager.getRootLogger();
		Data.logger.trace("Initializting the log file in before suite");
		
	}
	@AfterSuite
	public void aftersuite() {
		Logs.FinalizeReport();
		Data.logger.trace("Exceution has been completed");
	}
	@BeforeTest
	public void beforeTest(ITestContext ctx) {
		Data.testname=ctx.getCurrentXmlTest().getName();
		Data.logger.trace("beforetest annotations has been used for the test: " +Data.testname);
	    Data.maintest=Data.reports.createTest(Data.testname);
	
	}
	@AfterTest
	public void afterTest() {
		Data.driver.close();
	}
	@BeforeMethod
	public void beforemethod(Method method) {
		Data.Methodname=method.getName();
		Data.logger.trace("Executing the test case:" +Data.Methodname);
		Data.test=Data.maintest.createNode(Data.Methodname);
	}
	@AfterMethod
	public void resultstatus(ITestResult results) {
		try {
		if(results.getStatus()==ITestResult.FAILURE) {
			Data.test.log(Data.status.FAIL, "this test case is failed" +results.getName());
			
				Data.test.log(Data.status.FAIL, "this test case is failed" +results.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromPath(Utility_Files.capturescreenshot(Data.Methodname)).build());
			
			
		}
			else if(results.getStatus()==ITestResult.SUCCESS) {
				Data.test.log(Data.status.PASS, "This test case is passed" +results.getName());
				Data.test.log(Data.status.PASS, "This test case is passed" +results.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromPath(Utility_Files.capturescreenshot(Data.Methodname)).build());
				
			}
			else if(results.getStatus()==ITestResult.SKIP) {
				Data.test.log(Data.status.SKIP, "This test case is skipped" +results.getName());
				Data.test.log(Data.status.SKIP, "This test case is passed" +results.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromPath(Utility_Files.capturescreenshot(Data.Methodname)).build());
				
				
		}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Data.logger.trace("Completed the testcase:" +Data.Methodname);
	}
   
}
