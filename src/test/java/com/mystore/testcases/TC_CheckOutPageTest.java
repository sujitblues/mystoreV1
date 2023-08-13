package com.mystore.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.mystore.pageobject.CheckOutPage;
import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.ProductSummaryPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.login;

public class TC_CheckOutPageTest extends BaseClass {
	@Test
	public void verifyCheckOut() throws InterruptedException
	{
		Homepage pg=new Homepage(driver);
 		pg.clickOnLogin();
 		login lpg=new login(driver);
 		lpg.enteEmailAddress("sujittesting@gmail.com");
 		lpg.entePassword("Hello@123");
 		lpg.clickOnLoginButton();
 		String value="14.1";
		//String successtext="The product has been added to your shopping cart";
			pg.TypeInField( value);
			//search result list element
			driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]/a")).click();
			Thread.sleep(3000);
			
		SearchResultPage searchpage=new SearchResultPage(driver);
		searchpage.enterQuantity();
		searchpage.clickOnAddCart();
		Thread.sleep(3000);
		searchpage.mosueHoverOnCart();
		Thread.sleep(5000);
		searchpage.clickOnGoToCart();
		ProductSummaryPage summarypage=new ProductSummaryPage(driver);
		summarypage.selectCountry();
		summarypage.selectStateProvince();
		summarypage.enterPostalCode();
		summarypage.clickOnEstimateShipping();
		//Thread.sleep(3000);
		summarypage.clickOnTerm();
		summarypage.clickOnCheckout();
		
		CheckOutPage checkout=new CheckOutPage(driver);
		checkout.clickOnBillingAddressContinue();
		checkout.clickOnShippingAddressContinue();
		checkout.clickOnShippingMethodContinue();
		checkout.clickOnPaymentMethodContinue();
		checkout.clickOnPaymentInfoContinue();
		checkout.clickOnConfirm();
		pg.logout();
		
	}

}
