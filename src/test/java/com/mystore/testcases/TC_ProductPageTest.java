package com.mystore.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.login;

public class TC_ProductPageTest extends BaseClass {
	@Test(enabled=false)
	public void VerifySearchProduct() throws InterruptedException
	{
		Homepage pg=new Homepage(driver);
 		pg.clickOnLogin();
 		login lpg=new login(driver);
 		lpg.enteEmailAddress("sujittesting@gmail.com");
 		lpg.entePassword("Hello@123");
 		lpg.clickOnLoginButton();
 		String value="14.1";
			pg.TypeInField( value);
			//search result list element
			driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]/a")).click();
			Thread.sleep(3000);
 		
 		//Get the Name of searched product
 		SearchResultPage resultpg=new SearchResultPage(driver);
 		String SearchResultProductName=resultpg.getSearchResultProductName();
 		//Verify that correct product is displying after search
 		if(SearchResultProductName.contains(value))
 		{
 			Assert.assertTrue(true);
 		}
 		else
 		{
 			Assert.assertTrue(false);
 		}
 		pg.logout();
	}
	//Verify shopping content on mouse hover for shopping cart
	@Test(enabled=true)
	public void verifyShoppingCart() throws InterruptedException
	{
		Homepage pg=new Homepage(driver);
 		pg.clickOnLogin();
 		login lpg=new login(driver);
 		lpg.enteEmailAddress("sujittesting@gmail.com");
 		lpg.entePassword("Hello@123");
 		lpg.clickOnLoginButton();
 		String value="14.1";
		pg.TypeInField( value);
			//search result list element
			driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]/a")).click();
			Thread.sleep(3000);
			
		SearchResultPage searchpage=new SearchResultPage(driver);
		searchpage.enterQuantity(); //Add quantity
		searchpage.clickOnAddCart(); //item add to cart
		Thread.sleep(3000);
		searchpage.mosueHoverOnCart(); //Mouse hover on shopping cart
		Thread.sleep(3000);
			}
@Test(enabled=false)	
public void verifyItemAddSuccessMessage() throws InterruptedException
{
	Homepage pg=new Homepage(driver);
		pg.clickOnLogin();
		login lpg=new login(driver);
		lpg.enteEmailAddress("sujittesting@gmail.com");
		lpg.entePassword("Hello@123");
		lpg.clickOnLoginButton();
		String value="14.1";
	String successtext="The product has been added to your shopping cart";
		pg.TypeInField( value);
		//search result list element
		driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]/a")).click();
		Thread.sleep(3000);
		
	SearchResultPage searchpage=new SearchResultPage(driver);
	searchpage.enterQuantity();
	searchpage.clickOnAddCart();
	//Thread.sleep(3000);
	String currentsuccesstext=searchpage.getItemAddSuccessfulText();
			Assert.assertEquals(successtext, currentsuccesstext);
}
}
