package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	public static String fetchData(int rowindex,int colindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("‪F:\\Velocity\\manual rec\\test data.xlsx");
		String data=WorkbookFactory.create(file).getSheet("sanket data").getRow(rowindex).getCell(colindex).getStringCellValue();
		return data;
		
	}
	
	public static void scrrenShot(WebDriver driver,String filename) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sorce=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(" F:\\sc\\d1.jpeg  ");
		FileHandler.copy(sorce, dest);
	}

}
