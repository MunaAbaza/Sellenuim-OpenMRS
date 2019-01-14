package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class SelenuimUtils {

	public static void captureScreenshot(WebDriver driver) throws IOException
	{

    //take screenshot is an interface which we need to import
	TakesScreenshot tsh = (TakesScreenshot) driver;
	File srcFile  = tsh.getScreenshotAs(OutputType.FILE);
	System.out.println(srcFile.getAbsolutePath());//Temp location
	//To copy the screenshot store in a location; we need to import commom.io maven (Commons IO library

	FileUtils.copyFile(srcFile,new File("C:\\Work\\SelenuimDocs\\ScreenShots\\"+Calendar.getInstance().getTimeInMillis() +"OpenMrs.jpg"));
	}
	


}