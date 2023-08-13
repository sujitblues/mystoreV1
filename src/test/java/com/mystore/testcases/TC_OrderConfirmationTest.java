package com.mystore.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.mystore.pageobject.CheckOutPage;
import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.ProductSummaryPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.login;

public class TC_OrderConfirmationTest extends BaseClass{
	String Ordersucesstextexpected="Your order has been successfully processed";
	@Test
	public void VerifyOrderConfirmationText() throws InterruptedException
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
			driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]/a")).click();
			Thread.sleep(3000);
			
		SearchResultPage searchpage=new SearchResultPage(driver);
		searchpage.enterQuantity();
		searchpage.clickOnAddCart();
		Thread.sleep(2000);
		//searchpage.clickOnShoppingCart();
		searchpage.mosueHoverOnCart();
		searchpage.clickOnGoToCart();
		Thread.sleep(2000);
		ProductSummaryPage summarypage=new ProductSummaryPage(driver);
		summarypage.selectCountry();
		summarypage.selectStateProvince();
		summarypage.enterPostalCode();
		summarypage.clickOnEstimateShipping();
		summarypage.clickOnTerm();
		summarypage.clickOnCheckout();
		CheckOutPage checkout=new CheckOutPage(driver);
		checkout.clickOnBillingAddressContinue();
		checkout.clickOnShippingAddressContinue();
		checkout.clickOnShippingMethodContinue();
		checkout.clickOnPaymentMethodContinue();
		checkout.clickOnPaymentInfoContinue();
		checkout.clickOnConfirm();
		OrderConfirmationPage orderconfirmationtext=new OrderConfirmationPage(driver);
		String acutualtext=orderconfirmationtext.getOrdrSucessText();
		String ordernumber=orderconfirmationtext.getdOrderNumber();
		if(acutualtext.equalsIgnoreCase(Ordersucesstextexpected))
		{
			System.out.println("Order placed successfully");
			System.out.println();
			System.out.println("Your order Number"+ordernumber);
		}
		else
		{
			System.out.println("Something went wrong");
		}
		pg.logout();
	}

}
