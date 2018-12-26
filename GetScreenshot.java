package com.ibm.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot {
	
	public void takeScreenshot(WebDriver driver)throws IOException, InterruptedException 
	{
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		Date date=new Date();
		String currentDate=date.toString().replaceAll(":", "-");
		FileUtils.copyFile(file,new File("./screenshots/Error_"+currentDate+".png"));
		
	
	}

}
