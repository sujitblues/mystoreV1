package com.mystore.testcases;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.login;


import junit.framework.Assert;

public class TC_HomePageTest extends BaseClass{
	//open url
	
 	
 	@Test(priority=0)
 	public void verifyLogin() throws InterruptedException, IOException
 	 	{
 		
 		Homepage pg=new Homepage(driver);
 		pg.clickOnLogin();
 		Logger.info("Clicked on login");
 		login lpg=new login(driver);
 		lpg.enteEmailAddress("sujittesting@gmail.com");
 		lpg.entePassword("Hello@123");
 		lpg.clickOnLoginButton();
 		String loginStatus=pg.getLoginStatus();
 		Assert.assertEquals("Log out", loginStatus);
 		Logger.info("Login successfully");
 		caputreScreenShot(driver,"verifyLogin");
 		Thread.sleep(1000);
 		pg.logout();
 		
 	}
 	@Test(priority=1,enabled=false)
 	public void VerifySearchItemAndClick() throws InterruptedException
 	{
 		
 		driver.get(url);
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000)); 
 		Homepage pg=new Homepage(driver);
 		pg.clickOnLogin();
 		login lpg=new login(driver);
 		lpg.enteEmailAddress("sujittesting@gmail.com");
 		lpg.entePassword("Hello@123");
 		lpg.clickOnLoginButton();
 		
 					String value="14.1";
 					String expected="14.1 inch Laptop";
 					
 					SearchResultPage titleofitem=new SearchResultPage(driver);
  					pg.TypeInField( value);
 					driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]/a")).click();
 					Thread.sleep(3000);
 					String currentproductname=titleofitem.getSearchResultProductName();
 					Assert.assertEquals(expected, currentproductname);
 		
 	}
}
