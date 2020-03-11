package framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class Logs {
	
	public static void initializelog() {
		Utility_Files.Createfolder(System.getProperty("user.dir")+"//Reports//");
        String filename=Data.suiteName+"_"+Utility_Files.getTimeStamp()+".html";
		String file= System.getProperty("user.dir")+"//Reports//"+filename;
		Data.htmlreporter=new ExtentHtmlReporter(file);
		Data.htmlreporter.config().setDocumentTitle("Result "+Data.suiteName);
		Data.htmlreporter.config().setTheme(Theme.STANDARD);
		Data.htmlreporter.config().setReportName("Test Execution");
		Data.htmlreporter.config().setTimeStampFormat("DD.MM.YYYY HH.mm.ss");
		Data.reports= new ExtentReports();
		Data.reports.attachReporter(Data.htmlreporter);
	
	}
	public static void FinalizeReport() {
		Data.reports.flush();
	}
}
