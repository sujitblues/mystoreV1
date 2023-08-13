package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.mystore.utilities.ReadConfig;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
public class BaseClass {
	ReadConfig readConfig =new ReadConfig();
	String url =readConfig.getBaseUrl();
	String browser=readConfig.getBrowser();

	public static WebDriver	driver;
	public static Logger Logger;
	//using xml file and parallel execution 
	/*
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		//Check if parameter passed from TestNG is 'firefox'
		WebDriverManager.chromedriver().setup();
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		if(browser.equalsIgnoreCase("firefox")){
		driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
	    driver = new ChromeDriver(op);
		}
		//Check if parameter passed as 'Edge'
		else if(browser.equalsIgnoreCase("edge")){
				 driver = new EdgeDriver();
				}
		else{
			System.out.println("Not found the browser");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get(url);
		//for logging
		Logger=LogManager.getLogger("MyStoreV1");
	
	}
	*/

	//using browser value from config.properties file
	@BeforeClass
	public void setup()
	{
		System.out.println(browser);
		
		switch(browser.toLowerCase())
		{
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(op);
			break;
		case "firefox" :
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge" :
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
			break;
		default :
			driver=null;
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get(url);
		//for logging
		Logger=LogManager.getLogger("MyStoreV1");
	}
	
	/*
	public void login() throws InterruptedException
	{
		Homepage pg=new Homepage(driver);
 		pg.clickOnLogin();
 		login lpg=new login(driver);
 		lpg.enteEmailAddress("sujittesting@gmail.com");
 		lpg.entePassword("Hello@123");
 		lpg.clickOnLoginButton();
		
	}
	*/
	public void caputreScreenShot(WebDriver driver,String testName) throws IOException
	{
		//Step1: Convert webDriver object to TakesCreenshot interface
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		
		//Step2: call getScreenshotAs method to create image file
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//Screenshots//"+testName+".png");
		
		//Step3: Copy image file to destination
		FileUtils.copyFile(src, dest);
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
