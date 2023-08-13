package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {//Create object of webdriver
	WebDriver ldriver;
	public CheckOutPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//div[@id='billing-buttons-container']/input[@title='Continue']")
	WebElement billingaddress;
	@FindBy(xpath="//div[@id='shipping-buttons-container']/input[@title='Continue']")
	WebElement shippingaddress;
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']/input[@value='Continue']")
	WebElement shippingmethod;
	@FindBy(xpath="//input[@id='paymentmethod_0']")
	WebElement cashondelivery;
	@FindBy(xpath="//div[@id='payment-method-buttons-container']/input[@value='Continue']")
	WebElement paymentmethod;
	@FindBy(xpath="//div[@id='payment-info-buttons-container']/input[@value='Continue']")
	WebElement paymentinfo;
	@FindBy(xpath="//input[@value='Confirm']")
	WebElement paymentconfirm;
	
	public void clickOnBillingAddressContinue() throws InterruptedException
	{
		Thread.sleep(3000);
		billingaddress.click();
	}
	public void clickOnShippingAddressContinue() throws InterruptedException
	{
		Thread.sleep(3000);
		shippingaddress.click();
	}
	public void clickOnShippingMethodContinue() throws InterruptedException
	{
		Thread.sleep(3000);
		shippingmethod.click();
	}
	public void selectOnPaymentMethod() throws InterruptedException
	{
		Thread.sleep(3000);
		cashondelivery.click();
	}
	public void clickOnPaymentMethodContinue() throws InterruptedException
	{
		Thread.sleep(3000);
		paymentmethod.click();
	}
	public void clickOnPaymentInfoContinue() throws InterruptedException
	{
		Thread.sleep(3000);
		paymentinfo.click();
	}
	public void clickOnConfirm() throws InterruptedException
	{
		Thread.sleep(3000);
		paymentconfirm.click();
	}
}
