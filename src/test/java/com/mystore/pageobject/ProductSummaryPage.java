package com.mystore.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ProductSummaryPage {
	WebDriver ldriver;
	public ProductSummaryPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="CountryId") WebElement country;
	@FindBy(id="ZipPostalCode") WebElement postalcode;
	@FindBy(id="StateProvinceId") WebElement statepovince;
	@FindBy(xpath="//input[@name='estimateshipping']") WebElement estimateshiping;
	@FindBy(xpath="//input[@id='termsofservice']") WebElement termofservice;
	@FindBy(xpath="//button[@id='checkout']") WebElement checkout;
	public void selectCountry() throws InterruptedException
	{
		//dropdowncountry.selectByVisibleText("India");
		Thread.sleep(3000);
		Select dropdowncountry = new Select(country); 
		
		List<WebElement>alloptions=dropdowncountry.getOptions();
		for(WebElement option:alloptions)
		{
			if(option.getText().equals("India"))
			{
				option.click();
				break;
			}
		}
		
	}
	public void selectStateProvince()
	{
		Select dropdownstate = new Select(statepovince);
		dropdownstate.selectByValue("0");
	}
	public void enterPostalCode()
	{
		postalcode.clear();
		postalcode.sendKeys("110044");
	}
	public void clickOnEstimateShipping() throws InterruptedException
	{
		Thread.sleep(3000);
		estimateshiping.click();
	}
	public void clickOnTerm() throws InterruptedException
	{
		Thread.sleep(3000);
		boolean isSelected=termofservice.isSelected();
		if(isSelected==false)
		{
			termofservice.click();
		}		
		
	}
	public void clickOnCheckout()
	{
		checkout.click();
	}

}
