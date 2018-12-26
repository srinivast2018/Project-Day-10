package com.ibm.initialization;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.ibm.utilities.PropertiesFileHandler;

public class WebDriverLaunch {
	public WebDriver driver;
	public WebDriverWait wait;
	public PropertiesFileHandler propFileHandler;
	public HashMap<String, String> data;

	//Getting the keys from properties file
	//@BeforeSuite
	@BeforeSuite(groups= {"high","low"})
		public void preSetForTest() throws IOException {
		String file = "./TestData/groceries.properties";
		propFileHandler = new PropertiesFileHandler();
		data = propFileHandler.getPropertiesAsMap(file);
	}

	
	
	@BeforeMethod(groups= {"high","low"})
	//@BeforeTest
	@Parameters({"browser"})
	public void Initialization(@Optional("ff")String browser) {
		browserInitialization(browser);
		wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	//@AfterMethod	
	//Closing driver
	@AfterMethod(groups= {"high","low"})
	public void closeBrowser() {
		driver.quit();
	}
	
	//Setting path for webdriver
	public void browserInitialization(String browser)
	{
		switch (browser.toLowerCase()) {
		case "ff":
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ch":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("No browser Available "+browser);
			break;
		}
	}
}
