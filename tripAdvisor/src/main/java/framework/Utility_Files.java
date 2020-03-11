package framework;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utility_Files {

	public static void Createfolder(String folderpath) {
		File folder= new File(folderpath);
		if(!folder.exists()) {
			folder.mkdirs();
		}
	}


	public static String getTimeStamp() {
		String timestamp="";
		Date d=new Date();
		Calendar c= Calendar.getInstance();
		timestamp= timestamp+c.get(Calendar.MONTH)+c.get(Calendar.HOUR)+c.get(Calendar.MINUTE)+c.get(Calendar.SECOND);
		return timestamp;

	}

	public static void processtokill() {

		String killprocess="taskkill /f /im ";
		for(int i=0;i<Data.process_to_terminate.length;i++) {
			try {
				Runtime.getRuntime().exec(killprocess+Data.process_to_terminate[i] );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static String capturescreenshot(String screenshotname) throws IOException {
		Createfolder(System.getProperty("user.dir")+"\\screenshots\\");
		TakesScreenshot ts = (TakesScreenshot) Data.driver;
		screenshotname = screenshotname+getTimeStamp()+".png";
		File image=ts.getScreenshotAs(OutputType.FILE);
		String destpath= System.getProperty("user.dir")+"\\screenshots\\"+screenshotname;
		File destPath=new File(destpath);
		
			FileUtils.moveFile(image, destPath);
		
		return destpath;

	}
	 public static boolean check_file_exists(String filepath) {
		 File f=new File(filepath);
		 if(f.exists()) {
			 Data.logger.info("Successfully found the file" +filepath);
			 return true;
		 }else {
			 Data.logger.info("file not foung" +filepath);
			 return false;
		 }
	 }




}
