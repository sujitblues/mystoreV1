package com.mystore.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.ProductSummaryPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.login;

import junit.framework.Assert;

public class TC_ProductSummaryTest extends BaseClass{
	@Test
	public void verifyQuantity() throws InterruptedException
	{
	
	
	}
	@Test
	public void verifyCountry() throws InterruptedException
	{
		Homepage pg=new Homepage(driver);
 		pg.clickOnLogin();
 		login lpg=new login(driver);
 		lpg.enteEmailAddress("sujittesting@gmail.com");
 		lpg.entePassword("Hello@123");
 		lpg.clickOnLoginButton();
 		String value="14.1";
 		String expectedcountry="India";
		//String successtext="The product has been added to your shopping cart";
			pg.TypeInField( value);
			driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]/a")).click();
			Thread.sleep(3000);
			
		SearchResultPage searchpage=new SearchResultPage(driver);
		searchpage.enterQuantity();
		searchpage.clickOnAddCart();
		Thread.sleep(2000);
		searchpage.clickOnShoppingCart();
		Thread.sleep(2000);
		ProductSummaryPage summarypage=new ProductSummaryPage(driver);
		summarypage.selectCountry();
		Assert.assertEquals(expectedcountry, false);
		
	}
	@Test
	public void verifyTerm()
	{
		
	}
	
}
