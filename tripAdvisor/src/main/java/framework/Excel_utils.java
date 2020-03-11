package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class Excel_utils {
	 
    public static XSSFWorkbook getworkbook(String filepath) throws IOException {
    	
    	FileInputStream fis= new FileInputStream(filepath);
    	XSSFWorkbook workbook= new XSSFWorkbook(fis);
    	if(Utility_Files.check_file_exists(filepath)) {
    		Data.logger.info("File exists");
    		
    	}else {
    		Data.logger.info("workbook is not found" +filepath);
    		Assert.assertTrue(false, "The data file : "+filepath+" does not exist");
    		
    	}
    	Data.logger.info("successfully get the workbook data");
    	return workbook;
    	
    	
		
		
	}
    

}
